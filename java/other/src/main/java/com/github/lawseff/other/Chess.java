package com.github.lawseff.other;

public class Chess {

    public boolean canHorseBeatPawn(int horseX, int horseY, int pawnX, int pawnY) {
        return Math.abs(horseX - pawnX) == 2 && Math.abs(horseY - pawnY) == 1 ||
                Math.abs(horseX - pawnX) == 1 && Math.abs(horseY - pawnY) == 2;
    }

}
