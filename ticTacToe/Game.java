package homeExerciseLesson11;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player p1;
    private Player p2;
    private Player current;

    public Game() {
        board = new Board();
        playerChoice();
    }

    public  void playerChoice() {
        Scanner sc = new Scanner(System.in);
        int playerTemp = 2;
        while ((playerTemp != 1) && (playerTemp != 0)) {
            System.out.println("Choise player 1 type: Human or PC");
            System.out.println("Input: 0 - Human; 1 - PC :");
            playerTemp = sc.nextInt();

            if (playerTemp == 0) {
                p1 = new Player("Human", "X");
            } else {
                p1 = new PlayerPC ("PC", "X");
            }
        }

        playerTemp = 2;
        while ((playerTemp != 1) && (playerTemp != 0)) {
            System.out.println("Choise player 2 type: Human or PC");
            System.out.println("Input: 0 - Human; 1 - PC :");
            playerTemp = sc.nextInt();

            if (playerTemp == 0) {
                p2 = new Player("Human", "O");
            } else {
                p2 = new PlayerPC ("PC", "O");
            }
        }

    }

    public void play() {
        int number = 1;
        this.current = p1;
        while (true) {
            board.printBoard();
            System.out.println("Play player " + number + " " + current.getplayerType() + " :");
            while (true) {
                Move move = current.getMove(board);
                if (board.isMoveValid(move.getMoveRow(), move.getMoveColumn())) {
                    board.setCell(move.getMoveRow(), move.getMoveColumn(), current.getSymbol());
                    break;
                }
            }


                if (board.isWin()) {
                    System.out.println("Winner is player number " +
                            + number + ": " + current.getplayerType());
                    board.printBoard();
                    break;
                }

                if (board.isDraw()){
                    System.out.println("Draw!");
                    board.printBoard();
                    break;
                }

                if (current == p1) {
                    current = p2;
                    number = 2;
                } else {
                    current = p1;
                    number =1;
                }

        }
    }
}
