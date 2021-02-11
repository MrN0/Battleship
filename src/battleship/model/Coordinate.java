package battleship.model;

import java.util.Objects;

/**
 * This class represents a coordinate that contains horizontal and vertical
 * values
 */
public class Coordinate {
    // the vertical coordinate
    private final int vertical;
    // the horizontal coordinate
    private final int horizontal;

    /**
     * Constructs a coordinate
     *
     * @param vertical   the vertical coordinate
     * @param horizontal the horizontal coordinate
     */
    public Coordinate(int vertical, int horizontal) {
        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    /**
     * This method returns the coordinate vertically
     *
     * @return	the coordinate vertically
     */
    public int getVertical() {
        return vertical;
    }

    /**
     * This method returns the coordinate horizontally
     *
     * @return	the coordinate horizontally
     */
    public int getHorizontal() {
        return horizontal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return vertical == that.vertical && horizontal == that.horizontal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertical, horizontal);
    }
}
