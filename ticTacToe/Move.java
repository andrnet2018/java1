package homeExerciseLesson11;

public class Move {
    private int x;
    private int y;
    private Player p;

    public Move(int x, int y, Player p) {
        this.x = x;
        this.y = y;
        this.p = p;
    }

    public int getMoveRow() {
        return x;
    }

    public int getMoveColumn() {
        return y;
    }

    public Player getPlayer() {
        return p;
    }


}
