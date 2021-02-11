package battleship.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import battleship.controller.GameController;
import battleship.controller.GameView;
import battleship.model.Coordinate;
import battleship.model.ShotResult;
import battleship.model.field.Mark;
import battleship.model.ship.ShipType;

/**
 * This class is an implementation of the {@link GameView} in console mode
 */
public class ConsoleView implements GameView {
    // BufferedReader to read text from the input stream
    private final BufferedReader reader;
    // game controller
    private GameController controller;

    /**
     * Constructs ConsoleView
     */
    public ConsoleView() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void setController(GameController controller) {
        this.controller = controller;
    }

    @Override
    public void showBattlefield(Mark[][] battlefield) {
        // print the first line - column numbering
        System.out.print("  ");
        for (int i = 1; i <= battlefield[0].length; i++) {
            System.out.print(i == battlefield[0].length ? i : i + " ");
        }
        System.out.println();

        // print the battlefield
        for (int i = 0; i < battlefield.length; i++) {
            // print a row iteration with the capital letter
            System.out.printf("%c ", 'A' + i);
            // print the row of the battlefield
            for (int j = 0; j < battlefield[i].length; j++) {
                System.out.print(battlefield[i][j].getSign());

                if (j < battlefield[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void showBattlefields(Mark[][] enemyBattlefield, Mark[][] playerBattlefield) {
        showBattlefield(enemyBattlefield);
        System.out.println("---------------------");
        showBattlefield(playerBattlefield);
    }

    @Override
    public void showWinner(String playerName) {
        System.out.printf("You sank the last ship. %s won. Congratulations!%n", playerName);
    }

    @Override
    public void showShotResult(ShotResult shotResult) {
        switch (shotResult) {
            case HIT:
                System.out.println("You hit a ship!");
                break;
            case MISS:
                System.out.println("You missed!");
                break;
            case SANK:
                System.out.println("You sank a ship!");
        }
    }

    @Override
    public void promptForPlayer() {
        controller.addPlayer("Player1");
        controller.addPlayer("Player2");
    }

    @Override
    public void promptForShipsPlacement(String playerName) {
        System.out.printf("%s, place your ships on the game field%n", playerName);
    }

    @Override
    public void promptForShipCoordinates(ShipType shipType) {
        System.out.printf("Enter the coordinates of the %s (%d cells):%n", shipType.getName(), shipType.getSize());

        while (true) {
            try {
                Coordinate[] coordinates = getShipCoordinates(shipType);
                controller.placeShip(shipType, coordinates);
                break;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    @Override
    public void promptForAnotherPlayer() {
        System.out.println("Press Enter and pass the move to another player");
        System.out.println("...");
        readInputData(reader);
        controller.switchPlayer();
    }

    @Override
    public void promptForShot(String playerName) {
        System.out.printf("%n%s, it's your turn:%n", playerName);

        while (true) {
            try {
                Coordinate coordinate = getCoordinate();
                controller.performShot(coordinate);
                break;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    /**
     * This method reads the input data and converts it into an array with coordinates
     *
     * @param shipType						the {@link ShipType}
     * @return								the {@link Coordinate} array with coordinates for the ship
     * @throws IllegalArgumentException		if no two coordinates are specified
     */
    private Coordinate[] getShipCoordinates(ShipType shipType) throws IllegalArgumentException {
        String[] coordinates = readInputData(reader).split(" ");
        if (coordinates.length == 2) {
            Coordinate a = getCoordinateFromString(coordinates[0]);
            Coordinate b = getCoordinateFromString(coordinates[1]);
            return buildShipCoordinates(shipType, a, b);
        } else {
            throw new IllegalArgumentException(
                    "The coordinates must contain only the start and end points of the battleship.");
        }
    }


    /**
     * This method reads the input data and converts it into a coordinate
     *
     * @return								the converted {@link Coordinate}
     * @throws IllegalArgumentException		if no single coordinate is specified
     */
    private Coordinate getCoordinate() throws IllegalArgumentException {
        String[] coordinates = readInputData(reader).split(" ");
        if (coordinates.length == 1 && !coordinates[0].isEmpty()) {
            return getCoordinateFromString(coordinates[0]);
        } else {
            throw new IllegalArgumentException("Enter only one coordinate.");
        }
    }

    /**
     * This method builds the coordinates for the ship
     *
     * @param shipType						the {@link ShipType}
     * @param a								the first {@link Coordinate}
     * @param b								the second {@link Coordinate}
     * @return								the {@link Coordinate} array with coordinates for the ship
     * @throws IllegalArgumentException		if the coordinates do not indicate the correct length of the ship
     */
    private Coordinate[] buildShipCoordinates(ShipType shipType, Coordinate a, Coordinate b)
            throws IllegalArgumentException {
        if (Math.abs(a.getVertical() - b.getVertical()) + 1 == shipType.getSize()
                || Math.abs(a.getHorizontal() - b.getHorizontal()) + 1 == shipType.getSize()) {

            Coordinate[] shipCoordinates = new Coordinate[shipType.getSize()];

            if (coordinatesAlignedHorizontally(a, b)) {
                int vertical = Math.min(a.getVertical(), b.getVertical());
                for (int i = 0; i < shipCoordinates.length; i++) {
                    shipCoordinates[i] = new Coordinate(vertical++, a.getHorizontal());
                }
            } else {
                int horizontal = Math.min(a.getHorizontal(), b.getHorizontal());
                for (int i = 0; i < shipCoordinates.length; i++) {
                    shipCoordinates[i] = new Coordinate(a.getVertical(), horizontal++);
                }
            }

            return shipCoordinates;
        } else {
            throw new IllegalArgumentException(String.format("Wrong length of the %s!", shipType.getName()));
        }
    }

    /**
     * This method checks the alignment of coordinates vertically or horizontally
     *
     * @param a								the first {@link Coordinate}
     * @param b								the second {@link Coordinate}
     * @return								true if the ship is aligned horizontally, false otherwise
     * @throws IllegalArgumentException		if the coordinates are not in the same row or the same column
     */
    private boolean coordinatesAlignedHorizontally(Coordinate a, Coordinate b) throws IllegalArgumentException {
        if (a.getHorizontal() == b.getHorizontal()) {
            return true;
        } else if (a.getVertical() == b.getVertical()) {
            return false;
        } else {
            throw new IllegalArgumentException("Wrong ship location!");
        }
    }

    /**
     * This method converts the string to {@link Coordinate}
     *
     * @param coordinate					the {@link String} with coordinate
     * @return								the converted {@link Coordinate} from the string
     * @throws IllegalArgumentException		if if the coordinate is incorrect
     */
    private Coordinate getCoordinateFromString(String coordinate) throws IllegalArgumentException {
        int vertical = (int) coordinate.charAt(0) - 65;
        int horizontal;
        try {
            horizontal = Integer.parseInt(coordinate.substring(1)) - 1;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong coordinate!");
        }
        return new Coordinate(vertical, horizontal);
    }

    /**
     * This method reads data from the {@link BufferedReader}
     *
     * @param reader	the {@link BufferedReader}
     * @return			the {@link String} with input data
     */
    private String readInputData(BufferedReader reader) {
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException e) {
            System.out.println("Could not read the input data: " + e.getMessage());
        }
        return input;
    }

    /**
     * This method prints a specified error message
     *
     * @param message	{@link String} error message
     */
    private void printErrorMessage(String message) {
        System.out.printf("Error! %s Try again:%n", message);
    }
}
