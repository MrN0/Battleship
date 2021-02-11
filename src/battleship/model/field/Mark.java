package battleship.model.field;

/**
 * This enumeration class represents the marks on the battlefield
 */
public enum Mark {
    FOG('~'),
    HIT('X'),
    MISS('M'),
    SHIP('O');

    private final char sign;

    Mark(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }
}
