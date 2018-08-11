package homeExerciseLesson9.photoCamera;

import java.util.List;

public class MemoryCard {

    private List<Photo> photos;
    private int maxCapacity;
    private int currentPlace;

    public MemoryCard (List<Photo> photos, int maxCapacity) {
        this.photos = photos;
        this.maxCapacity = maxCapacity;
        this.currentPlace = 0;
    }

    public int countPhoto() {
        return photos.size();
    }

    public Photo getPhoto(int photoIndex) {
        if (photoIndex <= (photos.size()-1)) {
            return photos.get(photoIndex);
        } else {
            System.out.println("Photo not exist" );
            return null;
        }
    }

    public void deletePhoto(String contents) {
        int index = arrayIndexFind(contents);
        if (photos.size() > 0 && index != -1) {
            photos.remove(index);
        } else {
            System.out.println("Photo not exist");
        }
    }

    public void clearMemoryCard() {
        this.photos.clear();
        this.currentPlace = 0;
    }

    public void savePhoto(Photo photo ) {
        if (this.photos.size() < maxCapacity){
            photo.definePhotoName(Integer.toString(currentPlace) + ".jpg");
            this.photos.add(photo);
            this.currentPlace += 1;
        } else {
            System.out.println("Memory is full, please delete some photos");
        }

    }

    public int arrayIndexFind(String fileName) {
        int index = -1;
        for (int i = 0; i < photos.size(); i++) {
            if (photos.get(i).getPhotoName().equals(fileName)) {
                index = i;
            }
        }
        return index;
    }

}
