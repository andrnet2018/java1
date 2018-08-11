package homeExerciseLesson9.photoCamera;

public class Display {
    private DisplayState state;

    public Display() {
        this.state = DisplayState.OFF;
    }

    public void switchOn() {
        this.state = DisplayState.ON;
    }


    public void showPhoto(Photo photo) {
        if (this.state == DisplayState.ON) {
            System.out.println("This photo content is : " + photo.getPhotoContents());
        } else {
            System.out.println("Please switch ON display");
        }

    }
}
