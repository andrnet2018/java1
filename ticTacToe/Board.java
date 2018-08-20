package homeExerciseLesson11;

public class Board {
    private String[][] table;

    public Board() {
        this.table = new String[3][3];
        for (int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table[0].length; j++) {
                this.table[i][j] = "";
            }
        }
    }

    public void printBoard() {
        for(int i=0; i<table.length; i++) {
            for(int j=0; j<table[i].length; j++)
                System.out.print(" " + fixedLengthString(table[i][j], 1) + " " + "|");
            System.out.println("");
            System.out.println("------------");
        }
        System.out.println();
    }

    public static String fixedLengthString(String string, int length) {
        return String.format("%1$"+length+ "s", string);
    }

    public boolean isMoveValid(int x, int y) {
        if (table[x][y].equals("X") || table[x][y].equals("O")) {
            System.out.println("Cell " + x + ":" + y +
                    " is filled, please choice other cell");
            return false;
        } else {
            return true;
        }
    }

    public boolean isWin() {
        for (int i = 0; i < 3; i++) {
            if (((table[i][0].equals(table[i][1])) && (table[i][1].equals(table[i][2]) && (!table[i][0].equals("")))) ||
            ((table[0][i].equals(table[1][i])) && (table[1][i].equals(table[2][i]) && (!table[0][i].equals("")))))
                return true;
        }
        if (((table[0][0].equals(table[1][1])) && (table[1][1].equals(table[2][2]) && (!table[0][0].equals("")))) ||
                ((table[2][0].equals(table[1][1])) && (table[1][1].equals(table[0][2]) && (!table[2][0].equals("")))))
            return true;
        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (table[i][j].equals(""))
                    return false;
                return true;
    }

    public String getCell(int x, int y) {
        return table[x][y];
    }

    public void setCell(int x, int y, String symbol) {
        table[x][y] = symbol;
    }

}

