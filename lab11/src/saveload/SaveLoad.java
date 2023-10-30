package saveload;

import utils.FileUtils;

public class SaveLoad {

    public static void main(String[] args) {
        // We want to save the number of times that the file has been written to.
        // Make sure to use FileUtils!
        String fileName = "saveandload.txt";

        // TODO: First, check if the file exists (specifically saveandload.txt)
        //  If it doesn't exist, write the number of times we've written into the file
        //  so far, excluding the first time if the file doesn't exist (i.e. 0).
        //  Otherwise, continue with next steps.

        if (!FileUtils.fileExists(fileName)) {
            // TODO: If it doesn't exist, then we want to place 0 in the file first.

        }

        // TODO: Next, read the contents of the file. Make sure it's read in as an integer.

        // TODO: Increment the count

        // TODO: Write the count back in.

        // Make note of where the file is stored and check if the count has been incremented.
    }
}
