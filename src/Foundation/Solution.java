package Foundation;

import java.util.ArrayList;



public class Solution {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> sub = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        dfs(target, root, 0);
        return res;
    }

    private void dfs(int target, TreeNode root, int sum){

        if(sum+root.val>target){
            return ;
        }
        else if(target==sum+root.val){
            sub.add(root.val);
            res.add(sub);
            //sub.remove(sub.size()-1);
            return ;
        }
        else{
            sub.add(root.val);
            if(root.left!=null){
                dfs(target, root.left, sum+root.val);
            }
            if(root.right!=null){
                dfs(target, root.right, sum+root.val);
            }
            sub.remove(sub.size()-1);
            return ;
        }

    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

        public void setLR(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }

    }


    public static void main(String[] args) {
        Solution mys = new Solution();
        TreeNode root = new TreeNode(10);
        TreeNode secL = new TreeNode(5);
        secL.setLR(new TreeNode(4), new TreeNode(7));
        root.setLR(secL, new TreeNode(12));
        mys.res = mys.FindPath(root, 22);
        for (ArrayList<Integer> onesub :
                mys.res) {
            for (Integer i :
                    onesub) {
                System.out.println(i);
            }
        }


        ArrayList<TreeNode> Ns = new ArrayList<TreeNode>();
        TreeNode t10 = new TreeNode(10);
        Ns.add(t10);
        Ns.add(t10);
        Ns.add(t10);
        for (TreeNode t :
                Ns) {
            System.out.println(t.val);
        }

        t10.val = 999;
        for (TreeNode t :
                Ns) {
            System.out.println(t.val);
        }
    }
}


