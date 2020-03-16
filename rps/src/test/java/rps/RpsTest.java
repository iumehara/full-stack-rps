package rps;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static rps.Hand.*;
import static rps.Result.P1_WINS;
import static rps.Result.P2_WINS;

public class RpsTest {
    private Rps rps;

    @Before
    public void setUp() {
        rps = new Rps();
    }

    @Test
    public void rockVsPaper() {
        assertEquals(P2_WINS, rps.play(ROCK, PAPER));
    }

    @Test
    public void rockVsScissors() {
        assertEquals(P1_WINS, rps.play(ROCK, SCISSORS));
    }

    @Test
    public void paperVsRock() {
        assertEquals(P1_WINS, rps.play(PAPER, ROCK));
    }

    @Test
    public void paperVsScissors() {
        assertEquals(P2_WINS, rps.play(PAPER, SCISSORS));
    }
    @Test
    public void scissorsVsRock() {
        assertEquals(P2_WINS, rps.play(SCISSORS, ROCK));
    }

    @Test
    public void scissorsVsPaper() {
        assertEquals(P1_WINS, rps.play(SCISSORS, PAPER));
    }
}
