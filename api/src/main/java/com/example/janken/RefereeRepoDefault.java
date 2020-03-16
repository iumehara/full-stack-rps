package com.example.janken;

import org.springframework.stereotype.Repository;

@Repository
public class RefereeRepoDefault implements RefereeRepo {
    @Override
    public MatchResult judge(Match match) {
        return null;
    }
}
