package game2048;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static com.google.common.truth.Truth.assertWithMessage;
import static game2048.TestUtils.checkTilt;

/** Tests the tilt() method in the up (Side.NORTH) direction only.
 *
 * @author Omar Khan
 */
@Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
public class TestUpOnly {

    /** Move tiles up (no merging). */
    @Test
    @Tag("up")
    @DisplayName("Up Tilt")
    public void testUpNoMerge() {
        int[][] before = new int[][] {
                {0, 0, 4, 0},
                {0, 0, 0, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][] {
                {0, 0, 4, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 0, 0), Side.NORTH);
    }

    /** A basic merge. */
    @Test
    @Tag("up")
    @DisplayName("Up merge")
    public void testUpBasicMerge() {
        int[][] before = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 2, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][] {
                {0, 0, 4, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.NORTH);
    }

    /** A triple merge. Only the leading 2 tiles should merge. */
    @Test
    @Tag("up")
    @DisplayName("Triple merge")
    public void testUpTripleMerge() {
        int[][] before = new int[][] {
                {0, 0, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 2, 0},
                {0, 0, 2, 0},
        };
        int[][] after = new int[][] {
                {0, 0, 4, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.NORTH);
    }

    /** A tricky merge.
     *
     * The tricky part here is that the 4 tile on the bottom row shouldn't
     * merge with the newly created 4 tile on the top row. If you're failing
     * this test, try seeing how you can ensure that the bottom 4 tile doesn't
     * merge with the newly created 4 tile on top.
     */
    @Test
    @Tag("up")
    @DisplayName("Limit Merging")
    public void testUpTrickyMerge() {
        int[][] before = new int[][] {
                {0, 0, 2, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 4, 0},
        };
        int[][] after = new int[][] {
                {0, 0, 4, 0},
                {0, 0, 4, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.NORTH);
    }
}
