package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;

    public int getDegrees() {
        return degrees;
    }
    private static int toRange(int degrees) {
        while (degrees < 0) degrees += 360;
        return degrees % 360;
    }

    public static Direction ofDegrees(int degrees) {
        degrees = toRange(degrees);
        for (Direction direction : Direction.values()){
            if (degrees == direction.getDegrees()) return direction;
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        degrees = toRange(degrees);
        if (degrees < 25) return N;
        else if (degrees < 70) return NE;
        else if (degrees < 115) return E;
        else if (degrees < 150) return SE;
        else if (degrees < 205) return S;
        else if (degrees < 250) return SW;
        else if (degrees < 295) return W;
        else if (degrees < 340) return NW;
        return N;
    }

    public Direction opposite() {
        if (this == N) return S;
        if (this == NE) return SW;
        if (this == E) return W;
        if (this == SE) return NW;
        if (this == S) return N;
        if (this == SW) return NE;
        if (this == W) return E;
        return SE;
    }

    public int differenceDegreesTo(Direction direction) {
        int differences = Math.abs(this.getDegrees() - direction.getDegrees());
        return Math.min(differences, 360 - differences);
    }
}
