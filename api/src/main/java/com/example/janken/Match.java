package com.example.janken;

import java.util.Objects;

public class Match {
    private Shape p1;
    private Shape p2;

    public Match() {
    }

    public Match(Shape p1, Shape p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Shape getP1() {
        return p1;
    }

    public Shape getP2() {
        return p2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return p1 == match.p1 &&
                p2 == match.p2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2);
    }

    @Override
    public String toString() {
        return "Match{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }
}
