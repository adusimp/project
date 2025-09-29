import { type Photo } from "../hooks/usePhotoGallery";

export default function PhotoDetail({
  photo,
  onBack,
}: {
  photo: Photo;
  onBack: () => void;
}) {
  return (
    <div className="p-4">
      <button
        onClick={onBack}
        className="bg-gray-400 text-white px-2 py-1 rounded mb-2"
      >
        ⬅ Quay lại
      </button>
      <img
        src={photo.webviewPath}
        alt={photo.title}
        className="w-full rounded"
      />
      <h2 className="text-lg font-semibold mt-2">{photo.title}</h2>
    </div>
  );
}
