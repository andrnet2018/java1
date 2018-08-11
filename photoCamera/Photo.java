package homeExerciseLesson9.photoCamera;

public class Photo {

    private String photoContents;
    private String photoName;

    public Photo(String photoContents) {
        this.photoContents = photoContents;
    }

    public void definePhotoName(String photoName) {
        this.photoName = photoName;
    }


    public String getPhotoContents() {
        return photoContents;
    }

    public String getPhotoName() {
        return photoName;
    }

}
