package part02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class GroupCommitIdsTest {

    // the class to be tested
    private Contributors solution = new Contributors();

    @Test
    void noCommitIdsAreReturnedForEmptyCommitHistory() {
        Map<String, Collection<String>> contributors = solution.groupCommitIdsByContributors("");

        assertTrue(contributors.isEmpty(), "should return an empty map for an empty commit history");
    }

    @Test
    void commitIdsAreAddedToMultipleContributorsWithSingleCommits() {
        String commitHistory = """
                Commit r3f4g5 by SpeedySamantha (Parent: u7v8w9)
                Optimization - Turbocharged Ordering System
                Optimizing the ordering system for lightning-fast pizza procurement!

                Commit o1l2m3 by InnovationIsaac (Parent: r3f4g5)
                Discussion - Drone Delivery Dream
                Dreaming of drone-delivered pizzas - a futuristic pizza dream!
                """;

        Map<String, Collection<String>> contributors = solution.groupCommitIdsByContributors(commitHistory);

        assertTrue(contributors.containsKey("SpeedySamantha"), "should contain the first contributor");
        assertTrue(contributors.containsKey("InnovationIsaac"), "should contain the second contributor");
        assertEquals(2, contributors.size(), "there should not be any extra contributors in the map");

        assertTrue(contributors.get("SpeedySamantha").contains("r3f4g5"), "should contain the first commit id");
        assertEquals(1, contributors.get("SpeedySamantha").size(),
                "there should not be any extra commit ids for Samantha");

        assertTrue(contributors.get("InnovationIsaac").contains("o1l2m3"), "should contain the second commit id");
        assertEquals(1, contributors.get("InnovationIsaac").size(),
                "there should not be any extra commit ids for Isaac");
    }

    @Test
    void multipleCommitsBySingleContributorAreGroupedCorrectly() {
        String commitHistory = """
                Commit r3f4g5 by SpeedySamantha (Parent: u7v8w9)
                Optimization - Turbocharged Ordering System
                Optimizing the ordering system for lightning-fast pizza procurement!

                Commit o1l2m3 by SpeedySamantha (Parent: r3f4g5)
                Reverted turbocharging
                Sleep(-1) actually did not turn back time
                """;

        Map<String, Collection<String>> contributors = solution.groupCommitIdsByContributors(commitHistory);

        assertTrue(contributors.containsKey("SpeedySamantha"), "should contain the only contributor");
        assertEquals(1, contributors.size(), "there should not be any extra contributors in the map");

        assertTrue(contributors.get("SpeedySamantha").contains("r3f4g5"), "should contain the first commit id");
        assertTrue(contributors.get("SpeedySamantha").contains("o1l2m3"), "should contain the second commit id");
        assertEquals(2, contributors.get("SpeedySamantha").size(),
                "there should not be any extra commit ids for Samantha");
    }
}
