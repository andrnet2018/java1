package homeExerciseLesson9.matchBox;

import java.util.ArrayList;
import java.util.List;

public class MatchBoxTest {
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
        test11();
        test12();
        test13();
        test14();
        test15();
        test16();

    }

    private static void test1() {
        MatchBox matchbox = createMatchBoxWithMatches(100);
        checkResult(
                "Matchbox should be in closed state right after creation",
                matchbox.isClosed()
        );
    }

    private static void test2() {
        MatchBox matchbox = createMatchBoxWithMatches(100);
        matchbox.open();
        checkResult(
                "Matchbox should change their state to OPEN",
                matchbox.isOpen()
        );
    }

    private static void test3() {
        MatchBox matchbox = createMatchBoxWithMatches(100);
        matchbox.open();
        matchbox.close();
        checkResult(
                "Matchbox should change their state to CLOSED",
                matchbox.isClosed()
        );
    }

    private static void test4() {
        MatchBox matchbox = createMatchBoxWithMatches(100);
        matchbox.open();
        checkResult(
                "Matchbox should be 100 matches",
                matchbox.countMatches() == 100
        );
    }

    private static void test5() {
        MatchBox matchbox = createMatchBoxWithMatches(100);
        checkResult(
                "Can not count matches if matchbox is closed",
                matchbox.countMatches() == 0
        );
    }

    private static void test6() {
        MatchBox matchbox = createMatchBoxWithMatches(100);
        checkResult("Matchbox default capacity should be 100", matchbox.getCapacity() == 100);
    }

    private static void test7() {
        MatchBox matchbox = createMatchBoxWithMatches(100);
        checkResult("Matchbox is full", matchbox.isFull());
    }

    private static void test8() {
        List<Match> matches =  createNotFullMatchList(50);
        MatchBox  matchbox = new MatchBox(matches, 100);
        checkResult("Matchbox is not full", matchbox.isFull() == false);
    }

    private static void test9() {
        MatchBox matchbox = createMatchBoxWithMatches(100);
        matchbox.open();
        matchbox.putMatch(new Match());
        checkResult("Not possible put match," +
                " Matchbox is full", matchbox.isFull());
    }

    private static void test10() {
        MatchBox matchbox = createMatchBoxWithMatches(100);
        matchbox.open();
        matchbox.getMatch();
        checkResult("Matchbox count should be 99", matchbox.countMatches() == 99);
    }

    private static void test11() {
        List<Match> matches =  createNotFullMatchList(50);
        MatchBox  matchbox = new MatchBox(matches, 100);
        matchbox.open();
        matchbox.putMatch(new Match());
        checkResult("Can add match to matchbox", matchbox.countMatches() == 51);
    }

    private static void test12() {
        List<Match> matches =  createNotFullMatchList(50);

        checkResult("Match after creation not burn", matches.get(0).isNotBorn());
    }

    private static void test13() {
        MatchBox matchbox = createMatchBoxWithMatches(100);
        matchbox.open();
        Match match = matchbox.strikeMatch();
        checkResult("Match burn", match.isNotBorn() == false);
    }

    private static void test14() {
        MatchBox matchbox = createMatchBoxWithMatches(100);
        for (int i = 0; i < 100; i++) {
            matchbox.open();
            matchbox.getMatch();
        }
        checkResult("Take all matches from matchbox", matchbox.isEmpty());
    }

    private static void test15() {
        MatchBox matchbox = createMatchBoxWithMatches(100);
        for (int i = 0; i < 100; i++) {
            matchbox.open();
            matchbox.strikeMatch();
        }
        checkResult("matchbox status is not usable", matchbox.isNotUsable());
    }

    private static void test16() {
        MatchBox matchbox = createMatchBoxWithMatches(100);
        for (int i = 0; i < 50; i++) {
            matchbox.open();
            matchbox.strikeMatch();
        }
        checkResult("Flint Paper status is 50%", matchbox.getCurrentFlintPaperTimes() == 50);
    }


    private static MatchBox createMatchBoxWithMatches(int capacity) {
        List<Match> matches = createMatchList(capacity);
        return new MatchBox(matches, capacity);
    }

    private static List<Match> createMatchList(int capacity) {
        List<Match> matches = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            matches.add(new Match());
        }
        return matches;
    }

    private static List<Match> createNotFullMatchList(int count) {
        List<Match> matches = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            matches.add(new Match());
        }
        return matches;
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
