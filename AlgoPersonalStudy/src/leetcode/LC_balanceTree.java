package leetcode;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
public class LC_balanceTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int result = search(root);
//        if(result == -1) return false;
//        return true;
		
	}
	static int search(TreeNode node){
        if(node == null) return 0;
        int leftResult = 0, rightResult = 0;
        
        leftResult = search(node.left);
        rightResult = search(node.right);

        if(leftResult == -1 || rightResult == -1 || (int)Math.abs((double)(leftResult - rightResult)) > 1) return -1;

        return (int)Math.max(leftResult, rightResult) + 1;
    }
}
