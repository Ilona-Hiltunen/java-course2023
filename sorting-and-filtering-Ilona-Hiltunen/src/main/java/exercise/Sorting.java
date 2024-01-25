package exercise;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import model.Post;
import model.User;

public class Sorting {

    /**
     * Returns a new List with the Post objects in the given list sorted by their
     * publishedAt date in ascending order (oldest first).
     *
     * This method does not modify the given list.
     *
     * @param posts list of posts to sort
     * @return a new list of posts sorted by their published date in ascending order
     */
    public static List<Post> sortPostsByPublishedDate(List<Post> posts) {
     
        List<Post> sortedPosts = new ArrayList<>(posts);

        for (int i = 0; i < sortedPosts.size() - 1; i++) {
        
            for (int j = 0; j < sortedPosts.size() - i - 1; j++) {

                Instant dateA = Instant.parse(sortedPosts.get(j).publishedAt());
                Instant dateB = Instant.parse(sortedPosts.get(j+1).publishedAt());

                if (dateA.isAfter(dateB)) {
                    Post temp = sortedPosts.get(j);
                    sortedPosts.set(j, sortedPosts.get(j+1));
                    sortedPosts.set(j+1, temp);
                }
            }
        }        
         
        return sortedPosts;
    }

    /**
     * Returns a new list with the given users sorted by their registration date in
     * ascending order (oldest first).
     *
     * This method does not modify the given list.
     *
     * @param users list of users to sort
     * @return a new list of users sorted by their registration date
     */
    public static List<User> sortUsersByRegistrationDate(List<User> users) {
        /*
         * Note that each User can have different data types for `registeredAt` field:
         * - numeric (seconds since epoch), for example "1632225600"
         * - string (ISO 8601), for example "2021-09-21T12:00:00Z"
         *
         * This time a simple alphabetical ordering of the string values is not enough.
         */

        List<User> sortedUsers = users.stream()
        .sorted(Comparator.comparing(user -> {
        if (user.registeredAt().matches("\\d+")) {
        return Instant.ofEpochSecond(Long.parseLong(user.registeredAt()));
        } else {
        return Instant.parse(user.registeredAt());
        }}))
        .collect(Collectors.toList());
        
        return sortedUsers;
    }
}
