package com.rish889.rishFeb2024;

public class Solution {
    public static void main(String args[]) {
        Game game = new Game(6, new RandomFireStrategy(6));
        game.addShip("SH1", 1, 1, 1, 4, 4);

        game.fireMissile(1);
//        game.viewBattleField();
        game.fireMissile(2);
//        game.viewBattleField();
        game.fireMissile(1);
//        game.viewBattleField();
        game.fireMissile(2);
//        game.viewBattleField();
        game.fireMissile(1);
//        game.viewBattleField();
        game.fireMissile(2);
//        game.viewBattleField();
    }
}