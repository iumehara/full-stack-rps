package com.example.janken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rps.Hand;
import rps.Result;
import rps.Rps;

@Repository
public class RefereeRepoDefault implements RefereeRepo {
    @Autowired
    private Rps rps;

    public RefereeRepoDefault(Rps rps) {
        this.rps = rps;
    }

    @Override
    public MatchResult judge(Match match) {
        Result result = rps.play(handFrom(match.getP1()), handFrom(match.getP2()));
        return new MatchResult(
                match.getP1(),
                match.getP2(),
                outcomeFrom(result)
        );
    }

    private Hand handFrom(Shape shape) {
        return Hand.valueOf(shape.name());
    }

    private Outcome outcomeFrom(Result result) {
        return Outcome.valueOf(result.name());
    }
}
