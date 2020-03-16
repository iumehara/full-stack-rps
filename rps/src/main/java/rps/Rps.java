package rps;

import static rps.Hand.*;
import static rps.Result.P1_WINS;
import static rps.Result.P2_WINS;

public class Rps {
    public Result play(Hand p1, Hand p2) {
        if (p1 == ROCK && p2 == Hand.SCISSORS ||
                p1 == PAPER && p2 == ROCK ||
                p1 == SCISSORS && p2 == PAPER) {
            return P1_WINS;
        }
        return P2_WINS;
    }
}
