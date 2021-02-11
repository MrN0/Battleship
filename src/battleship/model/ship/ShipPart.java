package battleship.model.ship;

import battleship.model.Coordinate;

/**
 * This class represents a part of the ship
 */
public class ShipPart {
    // the ship to which this part of the ship belongs
    private final Ship ship;
    // the coordinate of this part
    private final Coordinate coordinate;
    // the condition of this part
    private boolean damaged;

    /**
     * Constructs a ShipPart
     *
     * @param ship			the {@link Ship} to which this part belongs
     * @param coordinate    the cell {@link Coordinate} of this part
     */
    public ShipPart(Ship ship, Coordinate coordinate) {
        this.ship = ship;
        this.coordinate = coordinate;
        this.damaged = false;
    }

    /**
     * This method returns the ship to which this part of the ship belongs
     *
     * @return	the {@link Ship} to which this part belongs
     */
    public Ship getShip() {
        return ship;
    }

    /**
     * This method returns the coordinate of this part
     *
     * @return      the cell {@link Coordinate} of this part
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * This method returns the condition of this part
     *
     * @return	true if part is damaged, false otherwise
     */
    public boolean isDamaged() {
        return damaged;
    }

    /**
     * This method marks this ship part as damaged
     */
    public void setDamaged() {
        this.damaged = true;
    }
}
