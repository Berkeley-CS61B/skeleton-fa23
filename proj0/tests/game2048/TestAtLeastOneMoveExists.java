package game2048;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static com.google.common.truth.Truth.assertWithMessage;

/** Tests the atLeastOneMoveExists() static method of Model.
 *
 * You shouldn't expect to pass these tests until you're passing all the tests
 * in TestEmptySpace.
 *
 * @author Omar Khan
 */
@Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
public class TestAtLeastOneMoveExists {

    /** The Board that we'll be testing on. */
    static Board b;

    /** Tests a board with some empty space.
     *
     *  Note that this isn't a comprehensive test for empty space. For that,
     * see the TestEmptySpace class.
     */
    @Test
    @Tag("at-least-one-move-exists")
    @DisplayName("Empty Space Exists")
    public void testEmptySpace() {
        int[][] rawVals = new int[][] {
                {0, 0, 4, 0},
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 0, 0, 0},
        };

        b = new Board(rawVals);
        assertWithMessage("A tilt in any direction will change the board "
                        + "(there is empty space on the board)\n" + b).that(Model.atLeastOneMoveExists(b)).isTrue();
    }

    /** Tests a board where a tilt in any direction would cause a change. */
    @Test
    @Tag("at-least-one-move-exists")
    @DisplayName("Valid Tilt Exists")
    public void testAnyDir() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 2},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {4, 2, 4, 2},
        };

        b = new Board(rawVals);
        assertWithMessage("A tilt in any direction will change the board\n"
                + b).that(Model.atLeastOneMoveExists(b)).isTrue();
    }

    /** Tests a board where a tilt left or right would cause a change. */
    @Test
    @Tag("at-least-one-move-exists")
    @DisplayName("Valid Left/Right Tilt")
    public void testLeftOrRight() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 8, 4, 2},
                {2, 2, 2, 4},
                {4, 8, 4, 2},
        };

        b = new Board(rawVals);
        assertWithMessage("A tilt left or right will change the board\n" + b).that(Model.atLeastOneMoveExists(b)).isTrue();
    }

    /** Tests a board where a tilt up or down would cause a change. */
    @Test
    @Tag("at-least-one-move-exists")
    @DisplayName("Valid Up/Down Tilt")
    public void testUpOrDown() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 8, 4, 2},
                {2, 16, 4, 8},
                {4, 8, 4, 2},
        };

        b = new Board(rawVals);
        assertWithMessage("A tilt up or down will change the board\n" + b).that(Model.atLeastOneMoveExists(b)).isTrue();
    }

    /** Tests a board where some move exists (max tile is on the board).
     *
     * While having the max tile on the board does mean the game is over, it
     * should not be handled in this method.
     */
    @Test
    @Tag("at-least-one-move-exists")
    @DisplayName("Valid Tilt with Max Tile")
    public void testMoveExistsMaxPiece() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 2, 2, 4},
                {4, 2, 4, 2048},
        };

        b = new Board(rawVals);
        assertWithMessage("A tilt in any direction will change the board\n"
                + b).that(Model.atLeastOneMoveExists(b)).isTrue();
    }

    /** Tests a board where no move exists. */
    @Test
    @Tag("at-least-one-move-exists")
    @DisplayName("No Valid Move")
    public void testNoMoveExists1() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {4, 2, 4, 2},
        };

        b = new Board(rawVals);
        assertWithMessage("No move exists\n" + b).that(Model.atLeastOneMoveExists(b)).isFalse();
    }

    /** Tests a board where no move exists. */
    @Test
    @Tag("at-least-one-move-exists")
    @DisplayName("No Valid Move")
    public void testNoMoveExists2() {
        int[][] rawVals = new int[][] {
                {2, 1024, 2, 4},
                {4, 2, 4, 2},
                {2, 8, 16, 4},
                {512, 2, 4, 2},
        };

        b = new Board(rawVals);
        assertWithMessage("No move exists\n" + b).that(Model.atLeastOneMoveExists(b)).isFalse();
    }

    /** Tests a board where no move exists. */
    @Test
    @Tag("at-least-one-move-exists")
    @DisplayName("No Valid Move")
    public void testNoMoveExists3() {
        int[][] rawVals = new int[][] {
                {8, 4, 2, 32},
                {32, 2, 4, 2},
                {2, 8, 2, 4},
                {4, 64, 4, 64},
        };

        b = new Board(rawVals);
        assertWithMessage("No move exists\n" + b).that(Model.atLeastOneMoveExists(b)).isFalse();
    }

    /** Tests a board where no move exists. */
    @Test
    @Tag("at-least-one-move-exists")
    @DisplayName("No Valid Move")
    public void testNoMoveExists4() {
        int[][] rawVals = new int[][] {
                {2, 4, 2, 32},
                {32, 2, 4, 2},
                {2, 128, 2, 4},
                {4, 2, 4, 2},
        };

        b = new Board(rawVals);
        assertWithMessage("No move exists\n" + b).that(Model.atLeastOneMoveExists(b)).isFalse();
    }

    /** Tests a board where no move exists. */
    @Test
    @Tag("at-least-one-move-exists")
    @DisplayName("No Valid Move")
    public void testNoMoveExists5() {
        int[][] rawVals = new int[][] {
                {8, 16, 2, 32},
                {32, 2, 64, 2},
                {2, 256, 128, 256},
                {1024, 8, 4, 2},
        };

        b = new Board(rawVals);
        assertWithMessage("No move exists\n" + b).that(Model.atLeastOneMoveExists(b)).isFalse();

    }
}
