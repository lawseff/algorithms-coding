package com.github.lawseff.other;

public class Chess {

    public boolean canHorseBeatPawn(int horseX, int horseY, int pawnX, int pawnY) {
        return Math.abs(horseX - pawnX) * Math.abs(horseY - pawnY) == 2;
    }

}
