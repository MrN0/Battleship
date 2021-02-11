package battleship.model.ship;

import battleship.model.Coordinate;

/**
 * This class represents the ship
 */
public class Ship {
    // the type of this ship
    private final String type;
    // array with parts of this ship
    private final ShipPart[] ship;

    /**
     * Constructs a Ship
     *
     * @param shipType		the {@link ShipType}
     * @param coordinates	the {@link Coordinate} array with coordinates for this ship
     */
    public Ship(ShipType shipType, Coordinate[] coordinates) {
        this.type = shipType.getName();
        this.ship = new ShipPart[shipType.getSize()];
        constructShip(coordinates);
    }

    /**
     * This method returns the ship type of this ship
     *
     * @return	the {@link String} ship type
     */
    public String getType() {
        return type;
    }

    /**
     * This method returns the length of this ship
     *
     * @return	the length of this ship
     */
    public int getLength() {
        return ship.length;
    }

    /**
     * This method returns ship part
     *
     * @param part		the ship part
     * @return			the {@link ShipPart}
     */
    public ShipPart getShipPart(int part) {
        return ship[part];
    }

    /**
     * This method returns the state of this ship
     *
     * @return	true if the ship sank, false otherwise
     */
    public boolean isSank() {
        for (ShipPart part : ship) {
            if (!part.isDamaged()) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method builds the ship according to the given coordinates
     *
     * @param coordinates	the {@link Coordinate} array with coordinates for this ship
     */
    private void constructShip(Coordinate[] coordinates) {
        for (int i = 0; i < ship.length; i++) {
            ship[i] = new ShipPart(this, coordinates[i]);
        }
    }
}
