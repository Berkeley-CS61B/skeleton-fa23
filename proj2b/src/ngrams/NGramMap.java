package ngrams;
import edu.berkeley.eecs.inst.cs61b.ngrams.StaffNGramMap;

/**
 * A placeholder implementation of NGramMap.
 */
public class NGramMap {
    private final StaffNGramMap staffSolution;

    public NGramMap(String wordsFilename, String countsFilename) {
        this.staffSolution = new StaffNGramMap(wordsFilename, countsFilename);
    }

    public TimeSeries countHistory(String word, int startYear, int endYear) {
        TimeSeries h = new TimeSeries();
        h.putAll(staffSolution.countHistory(word, startYear, endYear));
        return h;
    }

    public TimeSeries weightHistory(String word, int startYear, int endYear) {
        throw new UnsupportedOperationException();
    }
}
