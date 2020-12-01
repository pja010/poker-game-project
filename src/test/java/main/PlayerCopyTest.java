package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to test the functionality of the PlayerCopy poker actions.
 */
class PlayerCopyTest {

    PlayerCopy testPlayer1;
    PlayerCopy testPlayer2;
    PlayerCopy testPlayer3 ;

    /**
     * Example test bets of various sizes.
     */
    private double smallBet;
    private double largeBet;
    private double illegalBet;

    @BeforeEach
    void setUp(){
        testPlayer1 = new PlayerCopy(1);
        testPlayer2 = new PlayerCopy(2);
        testPlayer3 = new PlayerCopy(3);

        testPlayer1.setChips(100);
        testPlayer2.setChips(1000);
        testPlayer3.setChips(10000);

        smallBet = 10;
        largeBet = 1000;
        illegalBet = -10;
    }

    @Test
    void makeBetMove() {
        testPlayer1.makeBetMove(smallBet);
        testPlayer2.makeBetMove(smallBet);
        testPlayer3.makeBetMove(largeBet);

        assertEquals(testPlayer1.getPlayerAction(),PlayerAction.BET);
        assertEquals(testPlayer2.getPlayerAction(), PlayerAction.BET);
        assertEquals(testPlayer3.getPlayerAction(), PlayerAction.BET);
    }

    @Test
    void makeBetMoveException() {
        assertThrows(IllegalArgumentException.class,
                () -> testPlayer1.makeBetMove(largeBet));
        assertThrows(IllegalArgumentException.class,
                () -> testPlayer3.makeBetMove(illegalBet));
}

    @Test
    void makeCheckMove() {
        testPlayer2.makeCheckMove();
        assertEquals(PlayerAction.CHECK, testPlayer2.getPlayerAction());
        assertNotEquals(PlayerAction.CHECK,testPlayer3.getPlayerAction());
    }

    @Test
    void makeFoldMove() {
        testPlayer2.makeFoldMove();
        assertEquals(PlayerAction.FOLD, testPlayer2.getPlayerAction());
        assertNotEquals(testPlayer2.getPlayerAction(),testPlayer3.getPlayerAction());
    }
}