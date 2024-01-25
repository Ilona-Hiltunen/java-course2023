package part01;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CommitIds {

    /**
     * Returns the commit ids from the given commit log. The format of an individual
     * commit is as follows:
     *
     * <pre>
     * Commit d4e5f6 by ohjelmointi2 (Parent: a1b2c3)
     * This is my comment message!
     * This is the second line of the message.
     * </pre>
     *
     * There can be multiple commits in the commit log or there can be none. The
     * commits in the log are separated by a blank line. See the file
     * commit-log-example.txt for an example of a commit log.
     *
     * For the contents of that example file, the method should return a collection
     * containing the following strings:
     *
     * 7b9f1e, a3d8e7, 4f2a1d, e6c5b2, 1d9g4z, 8h5k2y, m3n5p8, j7i2k9, o1z6x9,
     * r5t2v7, s9l4p0, u8y3w1, x0p3q7, k4n6t8, p9r2t4, t7u9w2, z2x4c6
     *
     * @param commitLog a multi-line string containing the log of commits
     * @return a collection of commit ids
     */
    public Collection<String> getCommitIds(String commitLog) {
    
        List<String> commitIds = new LinkedList<>();

        if (!commitLog.isEmpty()) {
            String[] dividedlogs = commitLog.split("\n\n");
            for (String log : dividedlogs) {
                if (!log.trim().isEmpty()) {
                    String id = log.substring(log.indexOf("Commit") + 7, 13).trim();
                    commitIds.add(id);
                }
            }
        }

        return commitIds;
    }
}
