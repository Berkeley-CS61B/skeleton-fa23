package game2048;

import java.util.Arrays;
import java.util.Formatter;

/**
 * @author hug
 */
public class Board {
    /** Current contents of the board. */
    private final Tile[][] _values;
    /** Side that the board currently views as north. */
    private Side _viewPerspective;

    public Board(int size) {
        _values = new Tile[size][size];
        _viewPerspective = Side.NORTH;
    }

    /** Shifts the view of the board such that the board behaves as if side S is north. */
    public void setViewingPerspective(Side s) {
        _viewPerspective = s;
    }

    /** Create a board where RAWVALUES hold the values of the tiles on the board 
     * (0 is null) with a current score of SCORE and the viewing perspective set to north. */
    public Board(int[][] rawValues) {
        int size = rawValues.length;
        _values = new Tile[size][size];
        _viewPerspective = Side.NORTH;
        for (int col = 0; col < size; col += 1) {
            for (int row = 0; row < size; row += 1) {
                int value = rawValues[size - 1 - row][col];
                Tile tile;
                if (value == 0) {
                    tile = null;
                } else {
                    tile = Tile.create(value, col, row);
                }
                _values[col][row] = tile;
            }
        }
    }

    /** Returns the size of the board. */
    public int size() {
        return _values.length;
    }

    /** Return the current Tile at (COL, ROW), when sitting with the board
     *  oriented so that SIDE is at the top (farthest) from you. */
    private Tile vtile(int col, int row, Side side) {
        return _values[side.col(col, row, size())][side.row(col, row, size())];
    }

    /** Return the current Tile at (COL, ROW), where 0 <= ROW < size(),
     *  0 <= COL < size(). Returns null if there is no tile there. */
    public Tile tile(int col, int row) {
        return vtile(col, row, _viewPerspective);
    }

    /** Clear the board to empty and reset the score. */
    public void clear() {
        for (Tile[] column : _values) {
            Arrays.fill(column, null);
        }
    }

    /** Adds the tile T to the board */
    public void addTile(Tile t) {
        _values[t.col()][t.row()] = t;
    }

    /** Places the Tile TILE at column COL, row ROW where COL and ROW are
     * treated as coordinates with respect to the current viewPerspective.
     *
     * Returns whether or not this move is a merge.
     * */
    public boolean move(int col, int row, Tile tile) {
        int pcol = _viewPerspective.col(col, row, size()),
                prow = _viewPerspective.row(col, row, size());
        if (tile.col() == pcol && tile.row() == prow) {
            return false;
        }
        Tile tile1 = vtile(col, row, _viewPerspective);
        _values[tile.col()][tile.row()] = null;

        // Move or merge the tile. It is important to call setNext
        // on the old tile(s) so they can be animated into position
        if (tile1 == null) {
            Tile next = Tile.create(tile.value(), pcol, prow);
            tile.setNext(next);
            _values[pcol][prow] = next;
            return false;
        } else {
            assert tile.value() == tile1.value(); // only merge equal tiles
            Tile next = Tile.create(2 * tile.value(), pcol, prow);
            tile.setNext(next);
            tile1.setNext(next);
            _values[pcol][prow] = next;
            return true;
        }
    }

    /** Returns the board as a string, used for debugging. */
    @Override
    public String toString() {
        Formatter out = new Formatter();
        out.format("%n[%n");
        for (int row = size() - 1; row >= 0; row -= 1) {
            for (int col = 0; col < size(); col += 1) {
                if (tile(col, row) == null) {
                    out.format("|    ");
                } else {
                    out.format("|%4d", tile(col, row).value());
                }
            }
            out.format("|%n");
        }
        return out.toString();
    }
}
