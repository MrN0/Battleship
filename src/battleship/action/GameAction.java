package battleship.action;

import battleship.model.Coordinate;
import battleship.model.Player;
import battleship.model.ShotResult;
import battleship.model.field.Mark;
import battleship.model.ship.Ship;
import battleship.model.ship.ShipType;

/**
 * This class performs the actions for the game 'battlefield'
 */
public class GameAction {
    /**
     * This method adds a ship to the battlefield of a given player
     *
     * @param player		the {@link Player} who adds the ship
     * @param shipType		the {@link ShipType} the type of ship to be added
     * @param coordinates	the {@link Coordinate} array with the coordinates of the ship
     */
    public static void placeShip(Player player, ShipType shipType, Coordinate[] coordinates) {
        if (isLocationFree(player.getBattlefield(), coordinates)) {
            Ship ship = new Ship(shipType, coordinates);
            player.addShip(ship);
        } else {
            throw new IllegalArgumentException("You placed it too close to another one.");
        }
    }

    /**
     * This method shoots at the specified coordinates
     *
     * @param player		the {@link Player} who performs the shot
     * @param coordinate	the {@link Coordinate} for the shot
     * @return				the {@link ShotResult}
     */
    public static ShotResult shot(Player player, Coordinate coordinate) {
        if (Mark.SHIP.equals(player.getMarkByCoordinate(coordinate))) {
            player.setMarkByCoordinate(coordinate, Mark.HIT);
            Ship ship = player.getShipByCoordinate(coordinate);
            return ship.isSank() ? ShotResult.SANK : ShotResult.HIT;
        } else {
            player.setMarkByCoordinate(coordinate, Mark.MISS);
            return ShotResult.MISS;
        }
    }

    /**
     * This method checks if you can add a ship at the specified coordinates
     *
     * @param battlefield	the {@link Mark} a matrix array representing the player's battlefield
     * @param coordinates	the {@link Coordinate} array with the coordinates of the ship
     * @return				true if u can add, false otherwise
     */
    private static boolean isLocationFree(Mark[][] battlefield, Coordinate[] coordinates) {
        // first and last coordinate of the ship
        int startX = coordinates[0].getHorizontal();
        int endX = coordinates[coordinates.length - 1].getHorizontal();
        int startY = coordinates[0].getVertical();
        int endY = coordinates[coordinates.length - 1].getVertical();

        // extreme points for verification
        if (startX > 0) startX--;
        if (startY > 0) startY--;
        if (endX < battlefield.length - 1) startX++;
        if (endY < battlefield[0].length - 1) endY++;

        // check if the cell is free
        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                if (battlefield[i][j] != Mark.FOG) {
                    return false;
                }
            }
        }
        return true;
    }
}
