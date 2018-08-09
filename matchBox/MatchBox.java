package homeExerciseLesson9.matchBox;

import java.util.List;

public class MatchBox {

    private MatchBoxState state;
    private int capacity;
    private int maxFlintPaperTimes;
    private int currentFlintPaperTimes;
    private List<Match> matches;

    public MatchBox(List<Match> matches, int capacity) {
        this.state = MatchBoxState.CLOSED;
        this.capacity = capacity;
        this.matches = matches;
        this.maxFlintPaperTimes = 100;
        this.currentFlintPaperTimes = this.maxFlintPaperTimes;
    }

    public void putMatch(Match match) {
        if (!isOpen()) {
            System.out.println("Matchbox not open!");
        } else {
            if (isFull()) {
                System.out.println("Matchbox is full!");
            }  else {
                this.matches.add(match);
            }
        }


    }

    public Match getMatch() {
        if (!isOpen()) {
            System.out.println("Matchbox not open!");
            return null;
        } else {
            if (isEmpty()) {
                System.out.println("Matchbox is empty!");
                return null;
            } else {
                Match match = this.matches.get(0);
                this.matches.remove(0);
                return match;
            }
        }
    }

    public boolean isFull() {
        return matches.size() == capacity;
    }

    public boolean isEmpty() {
        return matches.isEmpty();
    }

    public int countMatches() {
        if (!isOpen()) {
            System.out.println("Matchbox is not in open state!");
            return 0;
        } else {
            return matches.size();
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void open() {
        this.state = MatchBoxState.OPEN;
    }

    public void close() {
        this.state = MatchBoxState.CLOSED;
    }

    public boolean isOpen() {
        return state == MatchBoxState.OPEN;
    }

    public boolean isClosed() {
        return state == MatchBoxState.CLOSED;
    }

    public boolean isNotUsable() {
        return state == MatchBoxState.NOTUSABLE;
    }



    public int getCurrentFlintPaperTimes() {
        return currentFlintPaperTimes;
    }

    public Match strikeMatch() {
        if (currentFlintPaperTimes >= 1) {
            open();
            Match match = getMatch();
            match.burn();
            currentFlintPaperTimes -= 1;
            if (currentFlintPaperTimes == 0) {
                this.state = MatchBoxState.NOTUSABLE;
                return null;
            }
            return match;
        } else {
            System.out.println("This matchbox not usable for burning");
            this.state = MatchBoxState.NOTUSABLE;
            return null;
        }

    }

}
