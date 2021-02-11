package battleship.controller;

import java.util.ArrayList;
import java.util.List;

import battleship.action.GameAction;
import battleship.model.Coordinate;
import battleship.model.Player;
import battleship.model.ShotResult;
import battleship.model.ship.ShipType;

/**
 * This class is the controller of this game
 */
public class GameController {
    // state of the game
    private enum GameState {
        CREATE_PLAYERS,
        PLACE_SHIPS,
        PERFORM_SHOT,
        END_GAME
    }

    // the view of the game
    private final GameView view;
    // list of players
    private final List<Player> players;
    // current player
    private Player currentPlayer;
    // enemy player
    private Player enemyPlayer;
    // current state of the game
    private GameState state;

    /**
     * Constructs game controller
     *
     * @param view	the {@link GameView}
     */
    public GameController(GameView view) {
        this.players = new ArrayList<>();
        this.state = GameState.CREATE_PLAYERS;
        this.view = view;
        view.setController(this);
    }

    /**
     * This method starts and controls the stages of the game
     */
    public void run() {
        boolean playGame = true;
        while (playGame) {
            switch (state) {
                case CREATE_PLAYERS:
                    createPlayers();
                    break;
                case PLACE_SHIPS:
                    placeShips();
                    break;
                case PERFORM_SHOT:
                    play();
                    break;
                case END_GAME:
                    playGame = false;
            }
        }
    }

    /**
     * This method adds a new player to the list of players
     *
     * @param playerName	the {@link String} player name
     */
    public void addPlayer(String playerName) {
        players.add(new Player(playerName));
    }

    /**
     * This method swap players
     */
    public void switchPlayer() {
        Player tmp = currentPlayer;
        currentPlayer = enemyPlayer;
        enemyPlayer = tmp;
    }

    /**
     * This method adds the ship to the battlefield of the current player
     *
     * @param shipType			the {@link ShipType}
     * @param shipCoordinates	the {@link Coordinate} array of ship coordinates
     */
    public void placeShip(ShipType shipType, Coordinate[] shipCoordinates) {
        GameAction.placeShip(currentPlayer, shipType, shipCoordinates);
    }

    /**
     * This method performs a player's shot
     *
     * @param coordinate	the  {@link Coordinate} of the shot
     */
    public void performShot(Coordinate coordinate) {
        ShotResult shotResult = GameAction.shot(enemyPlayer, coordinate);
        if (enemyPlayer.loss()) {
            view.showBattlefields(enemyPlayer.getBattlefieldUnderFog(), currentPlayer.getBattlefield());
            view.showWinner(currentPlayer.getName());
            state = GameState.END_GAME;
        } else {
            view.showShotResult(shotResult);
            view.promptForAnotherPlayer();
        }
    }

    /**
     * This method is responsible for creating players
     */
    private void createPlayers() {
        view.promptForPlayer();

        if (players.size() == 2) {
            currentPlayer = players.get(0);
            enemyPlayer = players.get(1);
            state = GameState.PLACE_SHIPS;
        }
    }

    /**
     * This method is responsible for placing ships
     */
    private void placeShips() {
        view.promptForShipsPlacement(currentPlayer.getName());
        view.showBattlefield(currentPlayer.getBattlefield());

        for (ShipType shipType : ShipType.values()) {
            view.promptForShipCoordinates(shipType);
            view.showBattlefield(currentPlayer.getBattlefield());
        }

        if (currentPlayer.equals(players.get(players.size() - 1))) {
            state = GameState.PERFORM_SHOT;
        }
        view.promptForAnotherPlayer();
    }

    /**
     * This method prompts for a shot
     */
    private void play() {
        view.showBattlefields(enemyPlayer.getBattlefieldUnderFog(), currentPlayer.getBattlefield());
        view.promptForShot(currentPlayer.getName());
    }
}
