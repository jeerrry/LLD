package org.lld.ticktactoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GameManager {
    private static GameManager instance = null;
    private Player player1;
    private Player player2;
    private Board board;

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }

        return instance;
    }

    private GameManager() {
        this.board = new Board(3);
    }

    public void initPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        var players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        Collections.shuffle(players);
        System.out.println(players.getFirst().getName() + ": will go first");
        var scanner = new Scanner(System.in);
        board.displayBoard();
        while (!board.isBoardFull()) {
            for (Player player : players) {
                System.out.println(player.getName() + ": turn, make your move...Add row,col comma seperated.");
                while (true) {
                    var input = scanner.nextLine();
                    String[] inputVal = input.split(",");
                    int row = Integer.parseInt(inputVal[0]);
                    int col = Integer.parseInt(inputVal[1]);
                    if (board.move(row, col, player.getMark())) {
                        board.displayBoard();
                        if (board.isVictory(player.getMark()) == GameState.VICTORY) {
                            System.out.println("Player " + player.getName() + ": won!");
                            return;
                        }
                        break;
                    } else {
                        System.out.println("Invalid move, add input again!");
                    }
                }
            }
        }

        System.out.println("Game ended in a draw");
    }
}
