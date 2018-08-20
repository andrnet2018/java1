package homeExerciseLesson11;

public class PlayerPC extends Player {
    public PlayerPC(String playerType, String symbol)
    {
        super(playerType, symbol);
    }

    @Override
    public Move getMove(Board b) {
        String tempSymbol = symbol;
        for (int j = 0;  j< 2; j++) {
            if ((j==1) && (symbol.equals("X")))
                tempSymbol = "O";
            else if ((j==1) && (symbol.equals("O")))
                tempSymbol = "X";

            for (int i = 0; i < 3; i++) {
                // po gorizontali
                if (((b.getCell(i,0)).equals(b.getCell(i,1))) && (b.getCell(i,0).equals(tempSymbol)) && b.getCell(i,2).equals("")) {
                    Move move = new Move(i,2,this);
                    return move;
                }
                if (((b.getCell(i,1)).equals(b.getCell(i,2))) && (b.getCell(i,1).equals(tempSymbol)) && b.getCell(i,0).equals("")) {
                    Move move = new Move(i,0,this);
                    return move;
                }
                if (((b.getCell(i,0)).equals(b.getCell(i,2))) && (b.getCell(i,0).equals(tempSymbol)) && b.getCell(i,1).equals("")) {
                    Move move = new Move(i,1,this);
                    return move;
                }

                // po vettikali
                if (((b.getCell(0,i)).equals(b.getCell(1,i))) && (b.getCell(0,i).equals(tempSymbol)) && b.getCell(2,i).equals("")) {
                    Move move = new Move(2,i,this);
                    return move;
                }
                if (((b.getCell(i,1)).equals(b.getCell(i,2))) && (b.getCell(i,1).equals(tempSymbol)) && b.getCell(i,0).equals("")) {
                    Move move = new Move(i,0,this);
                    return move;
                }
                if (((b.getCell(i,0)).equals(b.getCell(i,2))) && (b.getCell(i,0).equals(tempSymbol)) && b.getCell(i,1).equals("")) {
                    Move move = new Move(i,1,this);
                    return move;
                }

                // diagonalj slevo na pravo sverhu v niz
                if (((b.getCell(0,0)).equals(b.getCell(1,1))) && (b.getCell(0,0).equals(tempSymbol)) && b.getCell(2,2).equals("")) {
                    Move move = new Move(2,2,this);
                    return move;
                }
                if (((b.getCell(0,0)).equals(b.getCell(2,2))) && (b.getCell(0,0).equals(tempSymbol)) && b.getCell(1,1).equals("")) {
                    Move move = new Move(1,1,this);
                    return move;
                }
                if (((b.getCell(1,1)).equals(b.getCell(2,2))) && (b.getCell(1,1).equals(tempSymbol)) && b.getCell(0,0).equals("")) {
                    Move move = new Move(0,0,this);
                    return move;
                }

                // diagonalj spravo na levo vniz
                if (((b.getCell(0,2)).equals(b.getCell(1,1))) && (b.getCell(0,2).equals(tempSymbol)) && b.getCell(2,0).equals("")) {
                    Move move = new Move(2,0,this);
                    return move;
                }
                if (((b.getCell(0,2)).equals(b.getCell(2,0))) && (b.getCell(0,2).equals(tempSymbol)) && b.getCell(1,1).equals("")) {
                    Move move = new Move(1,1,this);
                    return move;
                }
                if (((b.getCell(1,1)).equals(b.getCell(2,0))) && (b.getCell(1,1).equals(tempSymbol)) && b.getCell(0,2).equals("")) {
                    Move move = new Move(0,2,this);
                    return move;
                }
            }

        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b.getCell(i,j).equals("")) {
                    Move move = new Move(i,j, this);
                    return move;
                }
            }
        }

        return null;
    }
}
