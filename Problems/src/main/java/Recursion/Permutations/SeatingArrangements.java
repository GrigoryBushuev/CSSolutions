package Recursion.Permutations;
import java.util.*;

/*
A teacher is trying to arrange a seating chart in their classroom. They have N students who will sit
in a line. They also have a list of pairs of students who have to sit next to each other. Write a
function to find all of the possible seating arrangements.

Function signature:
List<List<Integer>> arrangements(int N, Map<Integer, Integer> pairs)

For the input, we will assume that the N students are referred to by numbers 1‑N. In the map, if two
students have to sit next to each other, you will have a mapping from student1 ‑> student2
AND student2 ‑> student1.
eg.
arrangements(3, {1‑>3, 3‑>1}) =
[[1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2]]
*/
public class SeatingArrangements {
    public List<List<Integer>> arrangements(int N, Map<Integer, Integer> pairs) {
        List<List<Integer>> result = new LinkedList<>();
        generateArrangements(N, pairs, new LinkedList<>(), new HashSet<>(), result);
        return result;
    }

    private static void generateArrangements(int totalStudents, Map<Integer, Integer> pairs, LinkedList<Integer> path, Set<Integer> toSkip, List<List<Integer>> result) {
        if (totalStudents == path.size()) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = 1; i <= totalStudents; i++) {
            if (toSkip.contains(i)) {
                continue;
            }
            toSkip.add(i);
            path.add(i);
            Integer pairIndex = pairs.get(i);
            if (pairIndex != null) {
                toSkip.add(pairIndex);
                path.add(pairIndex);
            }
            generateArrangements(totalStudents, pairs, path, toSkip, result);
            toSkip.remove(i);
            path.removeLast();
            if (pairIndex != null) {
                toSkip.remove(pairIndex);
                path.removeLast();
            }
        }
    }
}
