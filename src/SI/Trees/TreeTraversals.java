package SI.Trees;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by pillutja on 8/17/2018.
 */
public class TreeTraversals {
    static StringBuilder sb = new StringBuilder();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int testCases =in.nextInt();
        for (int i = 0; i < testCases; i++) {
            traversals();
            System.out.println();
        }
    }

    private static void traversals() throws IOException {
        int n = in.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=in.nextInt();
        }
        TreeNode root=null;
        for (int i = 0; i < n; i++) {
            root=insert(root,a[i]);
        }
        sb = new StringBuilder();
        preOrder(root);
        System.out.println(sb.toString());
        sb = new StringBuilder();
        inOrder(root);
        System.out.println(sb.toString());
        sb = new StringBuilder();
        postOrder(root);
        System.out.println(sb.toString());
    }

    private static void preOrder(TreeNode root) {
        if(root==null)
            return;
        sb.append(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    private static void inOrder(TreeNode root) {
        if(root==null)
            return;
        inOrder(root.left);
        sb.append(root.val+" ");
        inOrder(root.right);
    }
    private static void postOrder(TreeNode root) {
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        sb.append(root.val+" ");
    }
    private static TreeNode insert(TreeNode root, int x) {
        if(root==null)
            return new TreeNode(x);
        if(x<root.val)
            root.left=insert(root.left,x);
        else
            root.right=insert(root.right,x);
        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left,right;
    public TreeNode(int val){
        this.val = val;
        left=null;
        right=null;
    }
}