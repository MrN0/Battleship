package battleship.controller;

import battleship.model.ShotResult;
import battleship.model.field.Mark;
import battleship.model.ship.ShipType;

/**
 * This interface contains the methods required to implement the view class
 */
public interface GameView {
    /**
     * This method sets the controller for this game view
     *
     * @param controller    the game {@link GameController}
     */
    void setController(GameController controller);

    /**
     * This method displays the specified battlefield
     *
     * @param battlefield	the {@link Mark} a matrix array representing battlefield
     */
    void showBattlefield(Mark[][] battlefield);

    /**
     * This method displays the battlefield of the enemy and the player
     *
     * @param enemyBattlefield		the {@link Mark} a matrix array representing the enemy's battlefield
     * @param playerBattlefield		the {@link Mark} a matrix array representing the player's battlefield
     */
    void showBattlefields(Mark[][] enemyBattlefield, Mark[][] playerBattlefield);

    /**
     * This method displays a winner
     *
     * @param playerName	the {@link String} player name
     */
    void showWinner(String playerName);

    /**
     * This method displays the result of the shot
     *
     * @param shotResult    the {@link ShotResult}
     */
    void showShotResult(ShotResult shotResult);

    /**
     * This method prompts to add a players
     */
    void promptForPlayer();

    /**
     * This method prompts the player to place a ship
     *
     * @param playerName	the {@link String} player name
     */
    void promptForShipsPlacement(String playerName);

    /**
     * This method prompts the player to enter the coordinates of the ship
     *
     * @param shipType		the {@link ShipType}
     */
    void promptForShipCoordinates(ShipType shipType);

    /**
     * This method prompts for another player
     */
    void promptForAnotherPlayer();

    /**
     * This method makes a request to execute a shot
     *
     * @param playerName	the {@link String} player name
     */
    void promptForShot(String playerName);
}
