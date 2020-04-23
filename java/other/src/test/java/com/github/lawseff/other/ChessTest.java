package com.github.lawseff.other;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class ChessTest {

    private static final int HORSE_X = 4;
    private static final int HORSE_Y = 4;

    private Chess chess;

    @DataProvider
    public static Object[][] trueDataProviderCanHorseBeatPawn() {
        return new Object[][] {
                { 2, 5 }, { 3, 6 }, { 5, 6 }, { 6, 5 }, { 6, 3 }, { 5, 2 }, { 3, 2 }, { 2, 3 },
        };
    }

    @DataProvider
    public static Object[][] falseDataProviderCanHorseBeatPawn() {
        return new Object[][] {
                { 2, 6 }, { 4, 6 }, { 6, 6 }, { 6, 4 }, { 6, 2 }, { 4, 2 }, { 2, 2 },
                { 3, 5 }, { 4, 5 }, { 5, 5 }, { 5, 4 }, { 5, 3 }, { 4, 3 }, { 3, 3 },
        };
    }

    @Before
    public void init() {
        chess = new Chess();
    }

    @Test
    @UseDataProvider("trueDataProviderCanHorseBeatPawn")
    public void canHorseBeatPawnShouldReturnTrue(int pawnX, int pawnY) {
        // when
        boolean canBeat = chess.canHorseBeatPawn(HORSE_X, HORSE_Y, pawnX, pawnY);

        // then
        Assert.assertTrue(canBeat);
    }

    @Test
    @UseDataProvider("falseDataProviderCanHorseBeatPawn")
    public void canHorseBeatPawnShouldReturnFalse(int pawnX, int pawnY) {
        // when
        boolean canBeat = chess.canHorseBeatPawn(HORSE_X, HORSE_Y, pawnX, pawnY);

        // then
        Assert.assertFalse(canBeat);
    }

}
