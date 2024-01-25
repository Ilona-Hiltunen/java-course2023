package part03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import part01.CommitIds;
import part02.Contributors;

public class Main {

    public static void main(String[] args) throws IOException {
        Path logFile = Path.of("pizza-commits.txt");
        String fileContents = Files.readString(logFile, StandardCharsets.UTF_8);

        Contributors run1 = new Contributors();
        Main run2 = new Main();

        String[] commitLogs = run1.divideCommitlogs(fileContents);
        run2.bubbleSort(commitLogs);
        List<String> organizedCommits = run2.anotherSorting(commitLogs);

        for (String commit  : organizedCommits) {
        System.out.println(commit + "\n");

        }
    } 

    public List<String> anotherSorting (String[] commitLogs) {

    CommitIds run = new CommitIds();
    List<String> organizedCommits = new LinkedList<>();

        if (commitLogs != null) {
               organizedCommits.add(commitLogs[0]);
                String id = run.getCommitIds(organizedCommits.get(0)).toString().replace("[", "").replace("]", "").trim();
            for (int i = 1; i < commitLogs.length; i++){
                    for (int j = 0; j < commitLogs.length; j++) {
                        String parent = findParent(commitLogs[j]);
                            if (parent.equalsIgnoreCase(id)) {
                                organizedCommits.add(commitLogs[j]);
                            }
                    }
            id = run.getCommitIds(organizedCommits.get(i)).toString().replace("[", "").replace("]", "").trim();
            }


        }
       
    return organizedCommits;
    }
    


    public void bubbleSort (String[] commitLogs) {

           for (int i = 0; i < commitLogs.length; i++) {
                    for (int j = 1; j < commitLogs.length-i; j++) {
                    String parent = findParent(commitLogs[j]);
                        if (parent.equalsIgnoreCase("none")) {
                            String temp = commitLogs[j-1];
                            commitLogs[j-1] = commitLogs[j];
                            commitLogs[j] = temp;
                        }
           }
        }

    }
    

    public String findParent (String log) {

    if (!log.isEmpty()) {
        String parent = log.substring(log.indexOf("Parent: ") + 7).trim();
        parent = parent.substring(0, parent.indexOf(")")).trim();
        return parent;
    }
    return null;
    }
}