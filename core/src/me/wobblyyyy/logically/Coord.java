package me.wobblyyyy.logically;

public class Coord {
    private final int x;
    private final int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Coord shift(int xShift, int yShift) {
        return new Coord(x + xShift, y + yShift);
    }

    public Coord shiftX(int shift) {
        return shift(shift, 0);
    }

    public Coord shiftY(int shift) {
        return shift(0, shift);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Coord) {
            Coord c = (Coord) o;
            
            return this.x == c.x && this.y == c.y;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return (x * 10_000) + y;
    }
}
