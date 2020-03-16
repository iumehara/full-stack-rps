package com.example.janken;

public class RefereeRepoSpy implements RefereeRepo {
    Match judge_args;

    @Override
    public MatchResult judge(Match match) {
        judge_args = match;
        return null;
    }
}
