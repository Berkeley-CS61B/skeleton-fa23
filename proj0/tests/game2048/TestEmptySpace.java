package game2048;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static com.google.common.truth.Truth.assertWithMessage;


/** Tests the emptySpaceExists() static method of Model.
 *
 * @author Omar Khan
 */
@Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
public class TestEmptySpace {

    /** The Board that we'll be testing on. */
    static Board b;

    /** Note that this isn't a possible board state. */
    @Test
    @Tag("empty-space")
    @DisplayName("Fully empty board")
    public void testCompletelyEmpty() {
        int[][] rawVals = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        b = new Board(rawVals);
        assertWithMessage("Board is full of empty space\n" + b).that(Model.emptySpaceExists(b)).isTrue();
    }

    /** Tests a board that is completely full except for the top row. */
    @Test
    @Tag("empty-space")
    @DisplayName("Empty top row")
    public void testEmptyTopRow() {
        int[][] rawVals = new int[][] {
                {0, 0, 0, 0},
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
        };

        b = new Board(rawVals);
        assertWithMessage("Top row is empty\n" + b).that(Model.emptySpaceExists(b)).isTrue();

    }

    /** Tests a board that is completely full except for the bottom row. */
    @Test
    @Tag("empty-space")
    @DisplayName("Empty bottom row")
    public void testEmptyBottomRow() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {0, 0, 0, 0},
        };

        b = new Board(rawVals);
        assertWithMessage("Bottom row is empty\n" + b).that(Model.emptySpaceExists(b)).isTrue();

    }


    /** Tests a board that is completely full except for the left column. */
    @Test
    @Tag("empty-space")
    @DisplayName("Empty left column")
    public void testEmptyLeftCol() {
        int[][] rawVals = new int[][] {
                {0, 4, 2, 4},
                {0, 2, 4, 2},
                {0, 4, 2, 4},
                {0, 2, 4, 2},
        };

        b = new Board(rawVals);
        assertWithMessage("Left col is empty\n" + b).that(Model.emptySpaceExists(b)).isTrue();
    }

    /** Tests a board that is completely full except for the right column. */
    @Test
    @Tag("empty-space")
    @DisplayName("Empty right column")
    public void testEmptyRightCol() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 0},
                {4, 2, 4, 0},
                {2, 4, 2, 0},
                {4, 2, 4, 0},
        };

        b = new Board(rawVals);
        assertWithMessage("Right col is empty\n" + b).that(Model.emptySpaceExists(b)).isTrue();
    }

    /** Tests a completely full board except one piece. */
    @Test
    @Tag("empty-space")
    @DisplayName("One empty space")
    public void testAlmostFullBoard() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 0, 2, 4},
                {4, 2, 4, 2},
        };

        b = new Board(rawVals);
        assertWithMessage("Board is not full\n" + b).that(Model.emptySpaceExists(b)).isTrue();
    }

    /** Tests a completely full board.
     * The game isn't over since you can merge, but the emptySpaceExists method
     * should only look for empty space (and not adjacent values).
     */
    @Test
    @Tag("empty-space")
    @DisplayName("Full board with valid merge")
    public void testFullBoard() {
        int[][] rawVals = new int[][] {
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
        };

        b = new Board(rawVals);
        assertWithMessage("Board is full\n" + b).that(Model.emptySpaceExists(b)).isFalse();
    }

    /** Tests a completely full board. */
    @Test
    @Tag("empty-space")
    @DisplayName("Full board")
    public void testFullBoardNoMerge() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {4, 2, 4, 2},
        };

        b = new Board(rawVals);
        assertWithMessage("Board is full\n" + b).that(Model.emptySpaceExists(b)).isFalse();

    }
}