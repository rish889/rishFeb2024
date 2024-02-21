package com.rish889.rishFeb2024;

public class Game {
    private int seaArea;
    private String battlefiled[][];
    private FireStrategy fireStrategy;

    public Game(int n, FireStrategy fireStrategy) {
        this.seaArea = n;
        this.battlefiled = new String[n][n];
        this.fireStrategy = fireStrategy;
    }

    public void addShip(String shipId, int size, int xPlayerA, int yPlayerA, int xPlayerB, int yPlayerB) {
        //handle size
        battlefiled[xPlayerA][yPlayerA] = "A" + shipId;
        battlefiled[xPlayerB][yPlayerB] = "B" + shipId;
    }

    public void fireMissile(int player) {
        System.out.println("Player" + player + " fires");
        Integer[] coordinates = fireStrategy.fireMissile(player);
        if (battlefiled[coordinates[0]][coordinates[1]] != null) {
            System.out.println("Player" + player + " wins");
        }
    }

    public void viewBattleField() {
        for (int i = 0; i < seaArea; i++) {
            for (int j = 0; j < seaArea; j++) {
                System.out.print(battlefiled[i][j] + "  ");
            }
            System.out.println();
        }
    }


}
