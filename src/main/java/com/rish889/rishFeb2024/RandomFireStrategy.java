package com.rish889.rishFeb2024;


import java.util.Arrays;

public class RandomFireStrategy implements FireStrategy {
    private int seaArea;
    private Integer[] player1GridAlreadyFired;
    private Integer[] player2GridAlreadyFired;
    private int firedMissile;

    public RandomFireStrategy(int seaArea) {
        this.seaArea = seaArea;
        this.firedMissile = 0;
        this.player1GridAlreadyFired = new Integer[seaArea * seaArea / 2];
        this.player2GridAlreadyFired = new Integer[seaArea * seaArea / 2];
    }

    @Override
    public Integer[] fireMissile(int player) {
        int totalNumberOfGrids = (seaArea * seaArea / 2 - firedMissile);
        int random = (int) (Math.random() * (totalNumberOfGrids));
        Integer[] gridAlreadyFired;
        if (player == 1) {
            gridAlreadyFired = player1GridAlreadyFired;
        } else {
            gridAlreadyFired = player2GridAlreadyFired;
        }

        for (int i = 0; i < (seaArea * seaArea / 2); i++) {
            if (gridAlreadyFired[i] != null && random < i) {
                random++;
            }
        }

        int x = random / seaArea;
        int y = random % seaArea;
        if (player == 1) {
            x = x + (seaArea / 2);
        } else {
            firedMissile++;
        }
        gridAlreadyFired[random] = 1;
        System.out.println(totalNumberOfGrids + "  " + random + "  " + x + "  " + y);
        Arrays.stream(gridAlreadyFired).forEach(g -> System.out.print(g + "  "));
        System.out.println();
        return new Integer[]{x, y};
    }
}
