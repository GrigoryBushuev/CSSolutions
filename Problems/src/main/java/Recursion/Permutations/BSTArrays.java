package Recursion.Permutations;
import java.util.*;
/*
* http://thebookofproblems.com/problems/bst-all-possible-arrays
BST: All Possible Arrays

Given a binary search tree, print all possible arrays that produce the tree.
An array produces a tree by inserting the array's elements one by one into the tree.
The elements are taken from the array from left to right.

Example. Consider the following binary search tree.
   4
  / \
 2   9
Its corresponding arrays are the following.

[4, 9, 2]
[4, 2, 9]

Input. The input file consists of positive integer N on the first line followed by N test cases.
The first line of any given test case consists of a pair of positive integers M and R separated by a single space.
Integer M indicates the number of edges in the binary search tree and R is the root of the tree.
The M lines that remain in the test case consist of pairs of positive integers P and C corresponding to an edge that goes from parent node P to child node C.
The following input file corresponds to the example.

1
2 4
4 2
4 9
Output. The output consists of all possible arrays for each test case. The arrays that correspond to a given test case must appear in lexicographical order.
Each array must appear on a single line. To print an array, print the elements separated by space.
For example, the corresponding is the output for the previous input.

4 2 9
4 9 2
*/
public class BSTArrays {
    public static class Node {
        private final int value;
        public Node(int value) {
            this.value = value;
        }

        public Node left;
        public Node right;
    }

    public static void main(String... args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numberOfTestCases = sc.nextInt();
            for (int i = 0; i < numberOfTestCases; i++) {
                int numberOfEdges = sc.nextInt();
                int rootNodeValue = sc.nextInt();
                var rootNode = new Node(rootNodeValue);
                HashMap<Integer, Node> nodesHashMap = new HashMap<>(numberOfEdges + 1);
                nodesHashMap.put(rootNodeValue, rootNode);
                for (int j = 0; j < numberOfEdges; j++) {
                    int parentNodeValue = sc.nextInt();
                    int currentNodeValue = sc.nextInt();
                    var parent = nodesHashMap.get(parentNodeValue);
                    var currentNode = new Node(currentNodeValue);
                    nodesHashMap.put(currentNodeValue, currentNode);
                    if (currentNodeValue > parentNodeValue) {
                        parent.right = currentNode;
                    } else {
                        parent.left = currentNode;
                    }
                }
                var result = allBSTOrders(rootNode);
                for (var res : result) {
                    System.out.println(Arrays.toString(res.toArray()));
                }
            }
        }
    }

    public static List<List<Integer>> allBSTOrders(Node root) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        LinkedList<Node> opportunities = new LinkedList<>();
        opportunities.add(root);
        genenerateBSTs(path, opportunities, results);
        return results;
    }

    private static void genenerateBSTs(LinkedList<Integer> path, LinkedList<Node> opportunities, List<List<Integer>> result) {
        if (opportunities.isEmpty()) {
            result.add(new LinkedList<>(path));
            return;
        }
        LinkedList<Node> levelOpportunities = new LinkedList<>(opportunities);
        for (Node opportunity : levelOpportunities) {
            if (opportunity.left != null) {
                opportunities.add(opportunity.left);
            }
            if (opportunity.right != null) {
                opportunities.add(opportunity.right);
            }
            opportunities.removeFirst();
            path.add(opportunity.value);
            genenerateBSTs(path, opportunities, result);
            path.removeLast();
            if (opportunity.right != null) {
                opportunities.removeLast();
            }
            if (opportunity.left != null) {
                opportunities.removeLast();
            }
            opportunities.addLast(opportunity);
        }
    }
}