/*Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false. */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        StringBuffer sbs = new StringBuffer();
        StringBuffer sbt = new StringBuffer();
        printPreorder(s,sbs);
        printPreorder(t,sbt);
       
        return sbs.toString().contains(sbt.toString());
    }
    void printPreorder(TreeNode node,StringBuffer sb) 
    { 
        
        if (node == null) 
        {
           sb.append(",#");
            return;
        }
  
        /* first print data of node */
        sb.append(","+node.val); 
  
        /* then recur on left sutree */
        printPreorder(node.left,sb); 
  
        /* now recur on right subtree */
         printPreorder(node.right,sb);
    }
}