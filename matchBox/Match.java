package homeExerciseLesson9.matchBox;

public class Match {
    private MatchState state;

    public Match() {
        this.state = MatchState.NOTBURN;
    }

    public void burn() {
        this.state = MatchState.BURN;
    }

    public boolean isNotBorn() {
        return this.state == MatchState.NOTBURN;
    }




}
