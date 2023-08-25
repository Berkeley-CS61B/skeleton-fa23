package game2048;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static com.google.common.truth.Truth.assertWithMessage;
import static game2048.TestUtils.checkTilt;


@Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
public class TestTiltMerge {
    /*
     * ******************
     * *  TESTING TILT  *
     * ******************
     * <p>
     * The following tests determine the correctness of your `tilt`
     * method.
     */

    /** Checks that the right two pieces merge when 3 adjacent pieces have same value. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("3 tile merge")
    public void testTripleMerge1() {
        int[][] before = new int[][]{
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {4, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.NORTH);
    }

    /** Checks that the right two pieces merge when 3 adjacent pieces have same value. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("3 tile merge")
    public void testTripleMerge2() {
        int[][] before = new int[][]{
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {4, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.SOUTH);
    }

    /** Checks two adjacent merges work. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("adjacent merge")
    public void testQuadrupleMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 2},
                {0, 0, 0, 2},
                {0, 0, 0, 2},
                {0, 0, 0, 2},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 4},
                {0, 0, 0, 4},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 8, 0), Side.NORTH);
    }

    /** Checks that a tile only merges once per tilt. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("One merge per North tilt")
    public void testSingleMergeUp() {
        int[][] before = new int[][]{
                {2, 0, 0, 0},
                {2, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {4, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.NORTH);
    }

    /** Checks that a tile only merges once per tilt. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("One merge per South tilt")
    public void testSingleMergeSouth() {
        int[][] before = new int[][]{
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {2, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {4, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.SOUTH);
    }

    /** Checks that a tile only merges once per tilt. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("One merge per East tilt")
    public void testSingleMergeEast() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 0, 2, 2},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 4, 4},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.EAST);
    }

    /** Checks that a tile only merges once per tilt. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("One merge per West tilt")
    public void testSingleMergeWest() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 2, 0, 4},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 4, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.WEST);
    }


    /** Merge adjacent tiles up. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("Up tilt with merge")
    public void testUpAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 0, 2, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 4, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.NORTH);
    }

    /** Merge non-adjacent tiles up. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("Up tilt with gap and merge")
    public void testUpNonAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 0, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 4, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.NORTH);
    }

    /** Move and merge adjacent tiles up. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("Up tilt with gaps and merge")
    public void testUpAdjacentMergeMove() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 2, 0},
                {0, 0, 2, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 4, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.NORTH);
    }

    /** Merge adjacent tiles right. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("Adjacent right merge")
    public void testRightAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, 2},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 4},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.EAST);
    }

    /** Merge non-adjacent tiles right. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("Right merge with gap")
    public void testRightNonAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 2},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 4},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.EAST);
    }

    /** Move and merge adjacent tiles right. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("Adjacent merge with gaps")
    public void testRightAdjacentMergeMove() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 2, 2, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 4},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.EAST);
    }

    /** Move and merge non-adjacent tiles right. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("Right merge with gaps")
    public void testRightNonAdjacentMergeMove() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 2, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 4},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.EAST);
    }

    /** Merge adjacent tiles down. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("Adjacent down merge")
    public void testDownAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 2, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 4, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.SOUTH);
    }

    /** Merge non-adjacent tiles down. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("Down merge")
    public void testDownNonAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 2, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 2, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 4, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.SOUTH);
    }

    /** Move and merge adjacent tiles down. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("Adjacent down move and merge")
    public void testDownAdjacentMergeMove() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 2, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 4, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.SOUTH);
    }

    /** Move and merge non-adjacent tiles down. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("Down move and merge")
    public void testDownNonAdjacentMergeMove() {
        int[][] before = new int[][]{
                {0, 2, 0, 0},
                {0, 0, 0, 0},
                {0, 2, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 4, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.SOUTH);
    }

    /** Merge adjacent tiles left. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("Left adjacent merge")
    public void testLeftAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {2, 2, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.WEST);
    }

    /** Merge non-adjacent tiles left. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("Left merge")
    public void testLeftNonAdjacentMerge() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {2, 0, 0, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.WEST);
    }

    /** Move and merge adjacent tiles left. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("Adjacent merge and move")
    public void testLeftAdjacentMergeMove() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 2, 2, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.WEST);
    }

    /** Move and merge non-adjacent tiles left. */
    @Test
    @Tag("tilt-merge")
    @DisplayName("Merge and move with gaps")
    public void testLeftNonAdjacentMergeMove() {
        int[][] before = new int[][]{
                {0, 0, 0, 0},
                {0, 2, 0, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        int[][] after = new int[][]{
                {0, 0, 0, 0},
                {4, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        checkTilt(new Model(before, 0, 0), new Model(after, 4, 0), Side.WEST);
    }


}
