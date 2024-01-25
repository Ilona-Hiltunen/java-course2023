package part02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;

public class GetContributorsTest {

    // the class under test
    private Contributors solution = new Contributors();

    @Test
    void emptyLogReturnsNoContributors() {
        Collection<String> contributors = solution.getContributors("");

        assertTrue(contributors.isEmpty(), "should return an empty collection for an empty commit history");
    }

    @Test
    void getContributorsFromMultipleCommits() {
        String commits = """
                Commit r3f4g5 by SpeedySamantha (Parent: u7v8w9)
                Optimization - Turbocharged Ordering System
                Optimizing the ordering system for lightning-fast pizza procurement!

                Commit o1l2m3 by InnovationIsaac (Parent: r3f4g5)
                Discussion - Drone Delivery Dream
                Dreaming of drone-delivered pizzas - a futuristic pizza dream!
                """;

        Collection<String> contributors = solution.getContributors(commits);

        assertTrue(contributors.contains("SpeedySamantha"), "contains the first contributor");
        assertTrue(contributors.contains("InnovationIsaac"), "contains the second contributor");

        assertEquals(2, contributors.size(), "there should not be any extra contributors in the collection");
    }

    @Test
    void contributorsDoNotContainDuplicates() {
        String commits = """
                Commit r3f4g5 by SpeedySamantha (Parent: u7v8w9)
                Optimization - Turbocharged Ordering System
                Optimizing the ordering system for lightning-fast pizza procurement!

                Commit o1l2m3 by InnovationIsaac (Parent: r3f4g5)
                Discussion - Drone Delivery Dream
                Dreaming of drone-delivered pizzas - a futuristic pizza dream!

                Commit xyz123 by SpeedySamantha (Parent: o1l2m3)
                Reverted turbocharging
                Sleep(-1) actually did not turn back time

                Commit omg123 by InnovationIsaac (Parent: xyz123)
                asdfg
                Well this is a useless commit message
                """;

        Collection<String> contributors = solution.getContributors(commits);

        assertEquals(1, Collections.frequency(contributors, "SpeedySamantha"), "contains the first contributor once");
        assertEquals(1, Collections.frequency(contributors, "InnovationIsaac"), "contains the second contributor once");

        assertEquals(2, contributors.size(), "there should not be duplicates in the contributors");
    }
}
