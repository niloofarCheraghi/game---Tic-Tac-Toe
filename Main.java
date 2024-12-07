package Game;

import java.util.InputMismatchException;
import java.util.Scanner;
import Game.Util.BoardLineTypeEnum;
import Game.Util.PlayerTypeEnum;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Board board = new Board();
        Player player = new Player(PlayerTypeEnum.X);

        var line = BoardLineTypeEnum.Nothing;

        System.out.println("Welcome to 3x3 Tic Tac Toe.");

        board.Feed();
        board.Print();

        System.out.println(
                player.GetTurn() + " will play first. Enter a slot number to place " + player.GetTurn() + " in:");

        var numInput = -1;
        while (line == BoardLineTypeEnum.Nothing) {
            try {
                numInput = in.nextInt();
                if (!board.IsSlotValid(numInput)) {
                    System.out.println("Invalid input; re-enter slot number:");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input; re-enter slot number:");
                in.next();
                continue;
            }

            if (!board.IsSlotFree(numInput)) {
                System.out.println("Slot already taken; re-enter slot number:");
                continue;
            }

            board.SetSlot(numInput, player.GetTurn().name());

            player.ChangePlayer();
            board.Print();
            line = board.CheckLine();
        }

        if (line.equals(BoardLineTypeEnum.Draw))
            System.out.println("It's a draw! Thanks for playing.");

        else
            System.out.println("Congratulations! " + player.GetWinner(line) + "'s have won! Thanks for playing.");

        in.close();
    }
}
