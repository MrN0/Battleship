package battleship.model.field;

import battleship.model.ship.Ship;
import battleship.model.ship.ShipPart;

/**
 * This class represents the battlefield cell
 */
public class Cell {
    // cell mark
    private Mark mark;
    // part of the ship in this cell
    private ShipPart shipPart;

    /**
     * Constructs cell
     *
     * @param mark	the cell {@link Mark}
     */
    public Cell(Mark mark) {
        this.mark = mark;
    }

    /**
     * This method returns the current cell mark
     *
     * @return	the cell {@link Mark}
     */
    public Mark getMark() {
        return mark;
    }

    /**
     * This method changes the cell mark
     *
     * @param mark	the {@link Mark} to mark for change
     */
    public void setMark(Mark mark) {
        if (Mark.SHIP.equals(this.mark)) {
            shipPart.setDamaged();
        }
        this.mark = mark;
    }

    /**
     * This method returns the ship placed in this cell
     *
     * @return	the {@link Ship} placed in this cell,
     * 			{@code null} if the cell is empty
     */
    public Ship getPlacedShip() {
        return shipPart.getShip();
    }

    /**
     * This method adds a ship part to this cell
     *
     * @param shipPart	the {@link ShipPart} to be added
     */
    public void setShipPart(ShipPart shipPart) {
        this.shipPart = shipPart;
        this.mark = Mark.SHIP;
    }
}
