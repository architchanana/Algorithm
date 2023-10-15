package com.company.arraydeque;

import java.util.*;

class Pair{
        TreeNode node;
        int row;
        Pair(TreeNode node,int row){
        this.node=node;
        this.row=row;
        }
}
class TreeNode
{
    int data;
    TreeNode left, right;

    TreeNode(int item)
    {
        data = item;
        left = right = null;
    }
}
public class chirag {
    public static void main(String[] args) {
        TreeNode head=new TreeNode(1);
        head.left=new TreeNode(2);
        head.right=new TreeNode(3);
        head.left.left=new TreeNode(4);
        head.left.right=new TreeNode(5);
        head.right.left=new TreeNode(6);
        head.right.right=new TreeNode(7);
        chirag sc=new chirag();
        sc.communicateToEmployees(head);
    }
    public void communicateToEmployees(TreeNode root){
        ArrayList<Integer>left=leftView(root);
        ArrayList<Integer>right=rightView(root);
        ArrayList<Integer>ans=new ArrayList<>();
        int i=0;
        boolean check=true;
        while(i<left.size() && i<right.size()){
            if(check){
                ans.add(left.get(i));
            }
            else{
                ans.add(right.get(i));
            }
            i++;
            if(check){
                check=false;
            }
            else{
                check=true;
            }
        }
        System.out.println(ans);
    }
    static void rightViewUtil(TreeNode root ,ArrayList<Integer> list, int level){
        if(root==null){return;}
        //first add the list then set it !
        if (level == list.size()) {
            list.add(root.data);
        } else {
            list.set(level, root.data);
        }
        rightViewUtil(root.left,list,level+1);
        rightViewUtil(root.right,list,level+1);

    }
    ArrayList<Integer> rightView(TreeNode node) {
        //add code here.
        ArrayList<Integer> list = new ArrayList<Integer>();
        rightViewUtil(node, list, 0);
        return list;
    }
    ArrayList<Integer> leftView(TreeNode root)
    {
        if(root==null){
            return (new ArrayList<>());
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        TreeMap<Integer,TreeNode> map=new TreeMap<>();
        while(!q.isEmpty()){
            Pair t=q.poll();
            TreeNode node=t.node;
            int row=t.row;
            if(!map.containsKey(row)){
                map.put(row,node);
            }
            if(node.left!=null){
                q.add(new Pair(node.left,row+1));
            }
            if(node.right!=null){
                q.add(new Pair(node.right,row+1));
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for(Map.Entry<Integer,TreeNode>mp:map.entrySet()){
            ans.add(mp.getValue().data);
        }
        return ans;
    }
}
