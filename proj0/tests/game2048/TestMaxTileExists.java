package game2048;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static com.google.common.truth.Truth.assertWithMessage;

/** Tests the maxTileExists() static method of Model.
 *
 * @author Omar Khan
 */
@Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
public class TestMaxTileExists {
    /** The board we'll be testing. */
    static Board b;

    /** Note that this isn't a possible board state. */
    @Test
    @Tag("max-tile")
    @DisplayName("Test empty board")
    public void testEmptyBoard() {
        int[][] rawVals = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };

        b = new Board(rawVals);
        assertWithMessage("Board is empty\n" + b).that(Model.maxTileExists(b)).isFalse();
    }

    /** Tests a full board with no max piece. */
    @Test
    @Tag("max-tile")
    @DisplayName("Test no max piece")
    public void testFullBoardNoMax() {
        int[][] rawVals = new int[][] {
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
        };

        b = new Board(rawVals);
        assertWithMessage("No 2048 tile on board\n" + b).that(Model.maxTileExists(b)).isFalse();
    }

    /** Tests a full board with the max piece. */
    @Test
    @Tag("max-tile")
    @DisplayName("Test board with max piece")
    public void testFullBoardMax() {
        int[][] rawVals = new int[][] {
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2048},
        };

        b = new Board(rawVals);
        assertWithMessage("One 2048 tile on board\n" + b).that(Model.maxTileExists(b)).isTrue();
    }

    /** Tests multiple max pieces. */
    @Test
    @Tag("max-tile")
    @DisplayName("Test board with multiple max pieces")
    public void testMultipleMax() {
        int[][] rawVals = new int[][] {
                {2, 2, 2, 2},
                {2, 2048, 0, 0},
                {0, 0, 0, 2},
                {0, 0, 2, 2048},
        };

        b = new Board(rawVals);
        assertWithMessage("Two 2048 tiles on board\n" + b).that(Model.maxTileExists(b)).isTrue();

    }

    /** Tests when the max piece is in the top right corner. */
    @Test
    @Tag("max-tile")
    @DisplayName("Test board with max piece in top right corner")
    public void testTopRightCorner() {
        int[][] rawVals = new int[][] {
                {0, 0, 0, 2048},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        b = new Board(rawVals);
        assertWithMessage("One 2048 tile on board\n" + b).that(Model.maxTileExists(b)).isTrue();
    }

    /** Tests when the max piece is in the top left corner. */
    @Test
    @Tag("max-tile")
    @DisplayName("Test board with max piece in top left corner")
    public void testTopLeftCorner() {
        int[][] rawVals = new int[][] {
                {2048, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        b = new Board(rawVals);
        assertWithMessage("One 2048 tile on board\n" + b).that(Model.maxTileExists(b)).isTrue();
    }

    /** Tests when the max piece is in the bottom left corner. */
    @Test
    @Tag("max-tile")
    @DisplayName("Test board with max piece in the bottom left corner")
    public void testBottomLeftCorner() {
        int[][] rawVals = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2048, 0, 0, 0}
        };

        b = new Board(rawVals);

        assertWithMessage("One 2048 tile on board\n" + b).that(Model.maxTileExists(b)).isTrue();
    }

    /** Tests when the max piece is in the bottom right corner. */
    @Test
    @Tag("max-tile")
    @DisplayName("Test board with max piece in the bottom right corner")
    public void testBottomRightCorner() {
        int[][] rawVals = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2048}
        };

        b = new Board(rawVals);

        assertWithMessage("One 2048 tile on board\n" + b).that(Model.maxTileExists(b)).isTrue();
    }

}
