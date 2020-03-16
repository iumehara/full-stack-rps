package com.example.janken;

import java.util.Objects;

public class MatchResult {
    private Shape p1;
    private Shape p2;
    private Outcome outcome;

    public MatchResult() {
    }

    public MatchResult(Shape p1, Shape p2, Outcome outcome) {
        this.p1 = p1;
        this.p2 = p2;
        this.outcome = outcome;
    }

    public Shape getP1() {
        return p1;
    }

    public Shape getP2() {
        return p2;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchResult that = (MatchResult) o;
        return p1 == that.p1 &&
                p2 == that.p2 &&
                outcome == that.outcome;
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2, outcome);
    }

    @Override
    public String toString() {
        return "MatchResult{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", outcome=" + outcome +
                '}';
    }
}
