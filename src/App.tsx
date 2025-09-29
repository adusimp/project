import { useState } from "react";
import Gallery from "./pages/Gallery";
import PhotoDetail from "./pages/PhotoDetail";
import { usePhotoGallery } from "./hooks/usePhotoGallery";

export default function App() {
  const { photos } = usePhotoGallery();
  const [selected, setSelected] = useState<number | null>(null);

  if (selected !== null) {
    return (
      <PhotoDetail photo={photos[selected]} onBack={() => setSelected(null)} />
    );
  }

  return <Gallery onSelect={(index) => setSelected(index)} />;
}
