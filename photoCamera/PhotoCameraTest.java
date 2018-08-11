package homeExerciseLesson9.photoCamera;

import java.util.ArrayList;
import java.util.List;

public class PhotoCameraTest {
    public static void main(String[] args) {

        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
    }

    private static void test1() {
        PhotoCamera photoCamera = createPhotocamera();
        checkResult(
                "Photocamera should be in OFF state right after creation",
                photoCamera.isSwitchOff()
        );
    }

    private static void test2() {
        PhotoCamera photoCamera = createPhotocamera();
        checkResult(
                "Accumulator should be FULL ENERGY right after creation",
                 photoCamera.isFullAccumulator()
        );
    }
    private static void test3() {
        PhotoCamera photoCamera = createPhotocamera();
        checkResult(
                "Should be ZERO photos right after creation",
                 photoCamera.getPhotoCollectionSize() == 0
        );
    }

    private static void test4() {
        PhotoCamera photoCamera = createPhotocamera();
        photoCamera.takePhoto("RIGA");
        checkResult(
                "Can not create photo if status OFF ",
                photoCamera.getPhotoCollectionSize() == 0
        );
    }

    private static void test5() {
        PhotoCamera photoCamera = createPhotocameraLowPhotosCapacity();
        photoCamera.switchOn();
        photoCamera.takePhoto("RIGA");
        photoCamera.takePhoto("JELGAVA");
        checkResult(
                "Should be created two photos ",
                photoCamera.getPhotoCollectionSize() == 2
        );
    }

    private static void test6() {
        PhotoCamera photoCamera = createPhotocamera();
        photoCamera.switchOn();
        photoCamera.takePhoto("RIGA");
        photoCamera.takePhoto("JELGAVA");
        photoCamera.takePhoto("OGRE");
        checkResult(
                "Accumulator condition not good after two photos ",
                !photoCamera.isAccumulatoryConditionIsGood()
        );
    }

    private static void test7() {
        PhotoCamera photoCamera = createPhotocamera();
        photoCamera.switchOn();
        photoCamera.takePhoto("RIGA");
        photoCamera.takePhoto("JELGAVA");
        photoCamera.switchOnDisplay();
        System.out.print("Test 7: Take photo RIGA == ");
        photoCamera.imagePlay(0);
    }

    private static void test8() {
        PhotoCamera photoCamera = createPhotocameraLowPhotosCapacity();
        photoCamera.switchOn();
        photoCamera.takePhoto("RIGA");
        photoCamera.takePhoto("JELGAVA");
        photoCamera.takePhoto("OGRE");
        photoCamera.takePhoto("VALMIERA");
        photoCamera.deletePhoto("0.jpg");
        checkResult(
                "After one photo deleted should be saved three photos ",
                photoCamera.getPhotoCollectionSize() == 3
        );
    }

    private static void test9() {
        PhotoCamera photoCamera = createPhotocameraLowPhotosCapacity();
        photoCamera.switchOn();
        photoCamera.takePhoto("RIGA");
        photoCamera.takePhoto("JELGAVA");
        photoCamera.takePhoto("OGRE");
        photoCamera.takePhoto("DAGDA");
        photoCamera.takePhoto("SEA");
        photoCamera.takePhoto("CONFERENCE");
        photoCamera.takePhoto("VACATION");

        checkResult(
                "Can not create seven photos, capacity only for five ",
                photoCamera.getPhotoCollectionSize() == 5
        );
    }

    private static void test10() {
        PhotoCamera photoCamera = createPhotocameraLowPhotosCapacity();
        photoCamera.switchOn();
        photoCamera.takePhoto("RIGA");
        photoCamera.takePhoto("JELGAVA");
        photoCamera.takePhoto("OGRE");
        photoCamera.formatMemoryCard();

        photoCamera.takePhoto("TESTS");
        checkResult(
                "Should be one photo after formating and one photo added ",
                photoCamera.getPhotoCollectionSize() == 1
        );
    }


    private static PhotoCamera createPhotocamera() {
        List<Photo> photos = new ArrayList<>();
        MemoryCard flashCard = new MemoryCard(photos, 20);
        Accumulator accumulator = new Accumulator(15);
        Display display = new Display();
        Matrix matrix = new Matrix();

        return new PhotoCamera(accumulator, flashCard, matrix, display);
    }

    private static PhotoCamera createPhotocameraLowPhotosCapacity() {
        List<Photo> photos = new ArrayList<>();
        MemoryCard flashCard = new MemoryCard(photos, 5);
        Accumulator accumulator = new Accumulator(500);
        Display display = new Display();
        Matrix matrix = new Matrix();

        return new PhotoCamera(accumulator, flashCard, matrix, display);
    }

    private static void checkResult(String testName, boolean result) {
        System.out.print(testName + " = ");
        if (result) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL");
        }
    }
}
