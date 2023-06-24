package leetcode;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
public class LC_975963683 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static int maxDeps = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        search(root,1);
        int result = maxDeps;
        maxDeps = 0;
        return result;
    }
    static public void search(TreeNode node, int deps){
        if(node.left != null){
            search(node.left, deps+1);
        }
        if(node.right != null){
            search(node.right, deps+1);
        }
        maxDeps = Math.max(maxDeps, deps);
    }
}
