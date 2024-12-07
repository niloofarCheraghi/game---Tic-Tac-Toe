package Game;

import java.util.Arrays;
import java.util.InputMismatchException;
import Game.Util.BoardLineTypeEnum;

public class Board {

    private String[] _board;
    private int dimention = 3;

    public Board() {
        _board = new String[dimention * dimention];
    }

    public void Print() {

        System.out.println(" |---|---|---| ");

        for (int i = 0; i < (dimention * dimention); i += dimention) {
            for (int j = 0; j < dimention; j++) {
                System.out.print(" | " + _board[i + j]);
            }
            System.out.println(" | ");
        }
        System.out.println(" |---|---|---| ");
    }

    public void Feed() {
        for (int a = 0; a < _board.length; a++) {
            _board[a] = String.valueOf(a + 1);
        }
    }

    public boolean IsSlotValid(int slot) {
        try {
            if (slot > 0 && slot <= dimention * dimention)
                return true;

        } catch (InputMismatchException e) {
            return false;
        }
        return false;
    }

    public boolean IsSlotFree(int slot) {
        return _board[slot - 1].equals(String.valueOf(slot));
    }

    public void SetSlot(int slot, String value) {
        _board[slot - 1] = value;
    }

    public BoardLineTypeEnum CheckLine() {
        for (int a = 0; a < (dimention * dimention) - 1; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = _board[0] + _board[1] + _board[2];
                    break;
                case 1:
                    line = _board[3] + _board[4] + _board[5];
                    break;
                case 2:
                    line = _board[6] + _board[7] + _board[8];
                    break;
                case 3:
                    line = _board[0] + _board[3] + _board[6];
                    break;
                case 4:
                    line = _board[1] + _board[4] + _board[7];
                    break;
                case 5:
                    line = _board[2] + _board[5] + _board[8];
                    break;
                case 6:
                    line = _board[0] + _board[4] + _board[8];
                    break;
                case 7:
                    line = _board[2] + _board[4] + _board[6];
                    break;
            }

            if (line.equals(BoardLineTypeEnum.XXX.name()))
                return BoardLineTypeEnum.XXX;

            else if (line.equals(BoardLineTypeEnum.OOO.name()))
                return BoardLineTypeEnum.OOO;

        }
        for (int a = 0; a < dimention * dimention; a++) {
            if (Arrays.asList(_board).contains(
                    String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                return BoardLineTypeEnum.Draw;
            }
        }
        return BoardLineTypeEnum.Nothing;
    }
}
