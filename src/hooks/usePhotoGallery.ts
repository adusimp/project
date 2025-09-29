import { useState, useEffect } from "react";
import { Camera, CameraResultType, CameraSource } from "@capacitor/camera";
import { Filesystem, Directory } from "@capacitor/filesystem";
import { Preferences } from "@capacitor/preferences";

export interface Photo {
  filepath: string;
  webviewPath: string;
  title: string;
}

const PHOTO_STORAGE = "photos";

export function usePhotoGallery() {
  const [photos, setPhotos] = useState<Photo[]>([]);

  useEffect(() => {
    loadSaved();
  }, []);

  const takePhoto = async (title: string) => {
    const cameraPhoto = await Camera.getPhoto({
      resultType: CameraResultType.Uri,
      source: CameraSource.Camera,
      quality: 90,
    });

    const fileName = new Date().getTime() + ".jpeg";
    const savedFile = await savePicture(cameraPhoto.webPath!, fileName);

    const newPhoto: Photo = {
      filepath: fileName,
      webviewPath: savedFile,
      title,
    };

    const newPhotos = [newPhoto, ...photos];
    setPhotos(newPhotos);

    await Preferences.set({
      key: PHOTO_STORAGE,
      value: JSON.stringify(newPhotos),
    });
  };

  const savePicture = async (photoPath: string, fileName: string) => {
    const response = await fetch(photoPath);
    const blob = await response.blob();
    const base64 = await convertBlobToBase64(blob) as string;

    await Filesystem.writeFile({
      path: fileName,
      data: base64,
      directory: Directory.Data,
    });

    return photoPath;
  };

  const loadSaved = async () => {
    const { value } = await Preferences.get({ key: PHOTO_STORAGE });
    if (value) {
      setPhotos(JSON.parse(value));
    }
  };

  return {
    photos,
    takePhoto,
  };
}

function convertBlobToBase64(blob: Blob) {
  return new Promise((resolve, reject) => {
    const reader = new FileReader();
    reader.onerror = reject;
    reader.onload = () => resolve(reader.result as string);
    reader.readAsDataURL(blob);
  });
}
