package main_game_package;

import board.Board;
import game_master.TicTacToe;
import player.Player;
import java.util.Scanner;

public class Main {
    private static final int EXIT_SUCCESS = 0;
    private static final int EXIT_UNEXPECTED_ERROR = 1;
    private static final int EXIT_INPUT_CLOSED = 2;

    public static void main(String[] args) {
        int exitCode = EXIT_SUCCESS;
        Scanner scanner = new Scanner(System.in);

        printWelcomeBanner();

        try {
            boolean keepPlaying = true;

            while (keepPlaying) {
                TicTacToe game = new TicTacToe(
                        new Player('X'),
                        new Player('O'),
                        new Board()
                );

                game.start();
                keepPlaying = askForAnotherGame(scanner);
            }

            System.out.println("Spiel beendet. Danke fürs Spielen!");
        } catch (IllegalStateException e) {
            System.out.println();
            System.out.println("Spiel wurde beendet: " + e.getMessage());
            exitCode = EXIT_SUCCESS;
        } catch (Exception e) {
            System.err.println("Ein unerwarteter Fehler ist aufgetreten: " + e.getMessage());
            exitCode = EXIT_UNEXPECTED_ERROR;
        } finally {
            scanner.close();
        }

        System.exit(exitCode);
    }

    private static void printWelcomeBanner() {
        System.out.println("""
                =========================================
                 _______ _        _______           _______
                |__   __(_)      |__   __|         |__   __|
                   | |   _  ___     | | __ _  ___     | | ___   ___
                   | |  | |/ __|    | |/ _` |/ __|    | |/ _ \\ / _ \\
                   | |  | | (__     | | (_| | (__     | | (_) |  __/
                   |_|  |_|\\___|    |_|\\__,_|\\___|    |_|\\___/ \\___|

                        Willkommen zu Tic Tac Toe!
                =========================================
                Eingabe: Zeile und Spalte jeweils von 0 bis 2
                Beenden: jederzeit mit Ctrl+Z danach Enter unter Windows, Ctrl+D unter macOS/Linux
                Alternativ: 'q', 'quit' oder 'exit' eingeben
                Beispiel: Zeile 1, Spalte 1 setzt in die Mitte
                =========================================
                """);
    }

    private static boolean askForAnotherGame(Scanner scanner) {
        while (true) {
            System.out.print("Noch einmal spielen? (j/n): ");

            if (!scanner.hasNextLine()) {
                throw new IllegalStateException("Keine weitere Eingabe verfuegbar.");
            }

            String input = scanner.nextLine().trim().toLowerCase();

            if (input.isEmpty()) {
                continue;
            }

            if (input.equals("j") || input.equals("ja") || input.equals("y") || input.equals("yes")) {
                return true;
            }

            if (input.equals("n") || input.equals("nein") || input.equals("no") || input.equals("q") || input.equals("quit") || input.equals("exit")) {
                return false;
            }

            System.out.println("Ungueltige Eingabe. Bitte 'j' fuer Ja oder 'n' fuer Nein eingeben.");
        }
    }
}
