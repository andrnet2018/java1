package homeExerciseLesson9.photoCamera;

public class PhotoCamera {

    private CameraState state;
    private Accumulator accumulator;
    private MemoryCard memoryCard;
    private Matrix matrix;
    private Display display;

    public PhotoCamera(Accumulator accumulator, MemoryCard memoryCard, Matrix matrix, Display display) {
        this.state =CameraState.OFF;
        this.accumulator = accumulator;
        this.memoryCard = memoryCard;
        this.matrix = matrix;
        this.display = display;
    }


    public void switchOn() {
        if (this.state == CameraState.OFF) {
            this.state = CameraState.ON;
        }
    }

    public void switchOff() {
        if (this.state == CameraState.ON) {
            this.state = CameraState.OFF;
        }
    }

    public void switchOnDisplay() {
        this.display.switchOn();
    }

    public int getPhotoCollectionSize() {
        return memoryCard.countPhoto();
    }

    public boolean isSwitchOff(){
        return this.state == CameraState.OFF;
    }

    public boolean isSwitchOn() {
        return this.state == CameraState.ON;
    }

    public boolean isFullAccumulator() {
        return accumulator.isFullChange();
    }

    public boolean isAccumulatoryConditionIsGood() {
        return accumulator.isEnoughtEnergy();
    }

    public void takePhoto(String contents) {
        if (isSwitchOn() && accumulator.isEnoughtEnergy()) {
            matrix.matrixOn();
            Photo photo = matrix.createPhoto(contents);
            memoryCard.savePhoto(photo);
            matrix.matrixOff();
            accumulator.reduceEnergy();
        } else {
            System.out.println("Please switch on photocamera or charge accumulator!");
        }
    }

    public void deletePhoto(String fileName) {
        if (isSwitchOn()){
            memoryCard.deletePhoto(fileName);
            accumulator.reduceEnergy();
        } else {
            System.out.println("Please switch on a photocamera");
        }
    }

    public void imagePlay(int index) {
        if (this.state == CameraState.ON && accumulator.isEnoughtEnergy()) {
            Photo photo = memoryCard.getPhoto(index);
            display.showPhoto(photo);
            accumulator.reduceEnergy();
        } else {
            System.out.println("Please switch on photocamera or charge accumulator!");
        }
    }

    public void formatMemoryCard() {
        memoryCard.clearMemoryCard();
        accumulator.reduceEnergy();
        accumulator.reduceEnergy();
    }
}
