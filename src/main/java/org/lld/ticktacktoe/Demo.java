package org.lld.ticktacktoe;

public class Demo {
    public static void main(String[] args) {
        var player1 = new Player("Uzair", 'X');
        var player2 = new Player("Tariq", 'O');

        GameManager.getInstance().initPlayers(player1, player2);
        GameManager.getInstance().start();
    }
}
