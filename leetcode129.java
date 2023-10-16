/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    void solve(TreeNode root,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> path){
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            path.add(root.val);
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        path.add(root.val);
        solve(root.left,res,path);
        solve(root.right,res,path);
        path.remove(path.size()-1);
    }
    public int sumNumbers(TreeNode root) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> path=new ArrayList<>();
        solve(root,res,path);
      //  System.out.println(res);
        int ans=0;
        for(ArrayList<Integer> i:res){
            int lsum=0;
            for(int j:i){
                lsum=lsum*10+j;
            }
            ans+=lsum;
        }
        return ans;
    }
}
