import { useState } from "react";
import { usePhotoGallery } from "../hooks/usePhotoGallery";

export default function Gallery({
  onSelect,
}: {
  onSelect: (index: number) => void;
}) {
  const { photos, takePhoto } = usePhotoGallery();
  const [title, setTitle] = useState("");

  return (
    <div className="p-4 flex flex-col items-center">
      <h1 className="text-xl font-bold mb-2 text-center">Photo Journal</h1>

      <div className="flex mb-2">
        <input
          type="text"
          placeholder="Nhập tiêu đề..."
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          className="border p-1 flex-1 mr-2"
        />
        <button
          onClick={() => {
            if (title) {
              takePhoto(title);
              setTitle("");
            }
          }}
          className="bg-blue-500 text-white px-3 py-1 rounded"
        >
          Chụp ảnh
        </button>
      </div>

      {/* --- THAY ĐỔI Ở ĐÂY --- */}
      <div className="grid grid-cols-3 gap-2">
        {photos.map((photo, index) => (
          <div
            key={index}
            className="cursor-pointer"
            onClick={() => onSelect(index)}
          >
            <img
              src={photo.webviewPath}
              alt={photo.title}
              // Thay đổi chiều cao để ảnh có dạng chữ nhật đứng
              className="w-full h-40 object-cover rounded"
            />
            <p className="text-center text-sm mt-1">{photo.title}</p>
          </div>
        ))}
      </div>
    </div>
  );
}
