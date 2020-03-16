package com.example.janken;

import org.junit.jupiter.api.Test;
import rps.Hand;
import rps.Result;
import rps.Rps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class RefereeRepoDefaultTests {
    @Test
    void judge() {
        Rps rps = mock(Rps.class);
        when(rps.play(any(), any())).thenReturn(Result.P2_WINS);
        RefereeRepoDefault refereeRepo = new RefereeRepoDefault(rps);


        MatchResult result = refereeRepo.judge(new Match(Shape.ROCK, Shape.PAPER));


        verify(rps).play(Hand.ROCK, Hand.PAPER);
        assertThat(result).isEqualTo(new MatchResult(Shape.ROCK, Shape.PAPER, Outcome.P2_WINS));
    }
}
