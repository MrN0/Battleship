package battleship.model.field;

import java.util.ArrayList;
import java.util.List;

import battleship.model.Coordinate;
import battleship.model.ship.Ship;

/**
 * This class represents the battlefield of the game
 */
public class Battlefield {
    // the battlefield matrix
    private final Cell[][] battlefield;
    // ships on the battlefield
    private final List<Ship> ships;

    /**
     * Constructs battlefield
     *
     * @param height	battlefield height
     * @param width		battlefield width
     */
    public Battlefield(int height, int width) {
        this.battlefield = createBattlefield(height, width);
        this.ships = new ArrayList<>();
    }

    /**
     * This method returns battlefield with marks, including ships
     *
     * @return	the {@link Mark} matrix array with marks
     */
    public Mark[][] getBattlefield() {
        Mark[][] bf = new Mark[battlefield.length][battlefield[0].length];
        for (int i = 0; i < bf.length; i++) {
            for (int j = 0; j < bf[i].length; j++) {
                bf[i][j] = battlefield[i][j].getMark();
            }
        }
        return bf;
    }

    /**
     *  This method returns battlefield with marks, without ships
     *
     * @return	the {@link Mark} matrix array with marks
     */
    public Mark[][] getBattlefieldUnderFog() {
        Mark[][] bf = new Mark[battlefield.length][battlefield[0].length];
        for (int i = 0; i < bf.length; i++) {
            for (int j = 0; j < bf[i].length; j++) {
                bf[i][j] = Mark.SHIP.equals(battlefield[i][j].getMark()) ? Mark.FOG : battlefield[i][j].getMark();
            }
        }
        return bf;
    }

    /**
     * This method returns ships placed on the battlefield
     *
     * @return		the {@link Ship} list with ships
     */
    public List<Ship> getShips() {
        return ships;
    }

    /**
     * This method changes the cell mark at the specified coordinate
     *
     * @param coordinate	the specified {@link Coordinate}
     * @param mark			the specified {@link Mark}
     */
    public void markCell(Coordinate coordinate, Mark mark) {
        getCell(coordinate).setMark(mark);
    }

    /**
     * This method adds the ship to the battlefield
     *
     * @param ship	the {@link Ship} to add
     */
    public void addShip(Ship ship) {
        for (int i = 0; i < ship.getLength(); i++) {
            Coordinate c = ship.getShipPart(i).getCoordinate();
            getCell(c).setShipPart(ship.getShipPart(i));
        }
        ships.add(ship);
    }

    /**
     * This method returns a cell at the specified coordinate
     *
     * @param coordinate	the specified {@link Coordinate}
     * @return				the {@link Cell} at the specified coordinate
     */
    public Cell getCell(Coordinate coordinate) {
        return battlefield[coordinate.getVertical()][coordinate.getHorizontal()];
    }

    /**
     * This method creates a battlefield matrix and fills it with mark represented fog
     *
     * @param height	battlefield height
     * @param width		battlefield width
     * @return			the {@link Cell} battlefield matrix
     */
    private Cell[][] createBattlefield(int height, int width) {
        Cell[][] battlefield = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                battlefield[i][j] = new Cell(Mark.FOG);
            }
        }
        return battlefield;
    }
}
