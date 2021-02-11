package battleship.model;

import battleship.model.field.Battlefield;
import battleship.model.field.Mark;
import battleship.model.ship.Ship;

/**
 * This class represents the player
 */
public class Player {
    // player's name
    private final String name;
    // player's battlefield
    private final Battlefield battlefield;

    /**
     * Constructs a player
     *
     * @param name	player's name
     */
    public Player(String name) {
        this.name = name;
        this.battlefield = new Battlefield(10, 10);
    }

    /**
     * This method returns the player's name
     *
     * @return	the {@link String} player name
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the player's battlefield with marks, including ships
     *
     * @return		the {@link Mark} matrix array with marks
     */
    public Mark[][] getBattlefield() {
        return battlefield.getBattlefield();
    }

    /**
     * This method returns the player's battlefield with marks, without ships
     *
     * @return		the {@link Mark} matrix array with marks
     */
    public Mark[][] getBattlefieldUnderFog() {
        return battlefield.getBattlefieldUnderFog();
    }

    /**
     * This method returns the mark on the battlefield at the specified coordinate
     *
     * @param coordinate	the given {@link Coordinate}
     * @return				the {@link Mark} on the battlefield at the specified coordinate
     */
    public Mark getMarkByCoordinate(Coordinate coordinate) {
        return battlefield.getCell(coordinate).getMark();
    }

    /**
     * This method changes the mark at the specified coordinate
     *
     * @param coordinate	the {@link Coordinate}
     * @param mark			the {@link Mark} to be change
     */
    public void setMarkByCoordinate(Coordinate coordinate, Mark mark) {
        battlefield.markCell(coordinate, mark);
    }

    /**
     * This method returns a ship that is at a given coordinate
     *
     * @param coordiante	the given {@link Coordinate}
     * @return				the {@link Ship} that is at a given coordinate
     */
    public Ship getShipByCoordinate(Coordinate coordiante) {
        return battlefield.getCell(coordiante).getPlacedShip();
    }

    /**
     * This method adds a ship to the player's battlefield
     *
     * @param ship	the {@link Ship} to be added
     */
    public void addShip(Ship ship) {
        battlefield.addShip(ship);
    }

    /**
     * This method returns the player's status (lost or not)
     *
     * @return	true if the player lost, false otherwise
     */
    public boolean loss() {
        for (Ship ship : battlefield.getShips()) {
            if (!ship.isSank()) {
                return false;
            }
        }
        return true;
    }
}
