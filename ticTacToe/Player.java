package homeExerciseLesson11;

import java.util.Scanner;

public class Player {
    protected String playerType;
    protected String symbol;

    public Player(String playerType, String symbol) {
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public Move getMove(Board b) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter row number (0-2): ");
            int rowNumber = sc.nextInt();
            System.out.println("Please enter column number (0-2): ");
            int columnNumber = sc.nextInt();

            if ((rowNumber <0 || rowNumber >2) || (columnNumber < 0 || columnNumber > 2)){
                System.out.println("Number must be from 0 till 2");
            } else {
                Move move = new Move(rowNumber, columnNumber, this);
                return move;
            }
        }
    }

    String getplayerType() {
        return playerType;
    }

    String getSymbol() {
        return symbol;
    }
}
