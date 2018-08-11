package homeExerciseLesson9.photoCamera;

public class Matrix {
    private Photo photo;
    private MatrixState state;

    public Matrix() {
        this.state = MatrixState.OFF;
    }

    public void matrixOn(){
        this.state = MatrixState.ON;
    }

    public void matrixOff() {
        this.state = MatrixState.OFF;
    }

    public Photo createPhoto(String contents) {
        Photo photo = new Photo(contents);
        return photo;
    }
}
