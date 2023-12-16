package Trees;

 // Definition for a binary tree node.
 public class LCTreeNode {
     public int val;
     public LCTreeNode left;
     public LCTreeNode right;
     public LCTreeNode() {}
     public LCTreeNode(int val) { this.val = val; }
     public LCTreeNode(int val, LCTreeNode left, LCTreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
