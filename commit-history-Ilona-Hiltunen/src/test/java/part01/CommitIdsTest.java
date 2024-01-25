package part01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Test;

public class CommitIdsTest {

    // the class to be tested
    private CommitIds solution = new CommitIds();

    @Test
    void noCommitIdsAreReturnedForEmptyString() {
        Collection<String> ids = solution.getCommitIds("");

        assertTrue(ids.isEmpty(), "getCommitIds should return an empty collection for an empty string");
    }

    @Test
    void singleCommitIdIsReturnedForSingleCommit() {
        String commit = """
                Commit t4u5v6 by MSWordMishapMia (Parent: o1p2q3)
                Fix Code Edit - MS Word Strikes Again!
                Discovered someone edited code with MS Word - farewell, formatting chaos!
                """;

        Collection<String> ids = solution.getCommitIds(commit);

        assertTrue(ids.contains("t4u5v6"), "getCommitIds should return a collection containing the commit id");
        assertEquals(1, ids.size(), "there should not be any extra commit ids in the collection");
    }

    @Test
    void multipleCommitIdsAreReturnedForMultipleCommits() {
        String commits = """
                Commit r3f4g5 by SpeedySamantha (Parent: u7v8w9)
                Optimization - Turbocharged Ordering System
                Optimizing the ordering system for lightning-fast pizza procurement!

                Commit o1l2m3 by InnovationIsaac (Parent: r3f4g5)
                Discussion - Drone Delivery Dream
                Dreaming of drone-delivered pizzas - a futuristic pizza dream!
                """;

        Collection<String> ids = solution.getCommitIds(commits);
        assertTrue(ids.contains("r3f4g5"), "getCommitIds should return a collection containing the first commit id");
        assertTrue(ids.contains("o1l2m3"), "getCommitIds should return a collection containing the second commit id");
        assertEquals(2, ids.size(), "there should not be any extra commit ids in the collection");
    }
}
