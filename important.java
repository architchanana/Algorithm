package com.company.arraydeque;

import java.util.*;

class Pair{
    int i;int j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
public class pankah {
    public static void main(String[] args) {
        List<String>str=new ArrayList<>();

        str.add("aaaba");
        str.add("ababa");
        str.add("aaaca");
        System.out.println(StrokesRequired(str));
    }

    public static int StrokesRequired(List<String> picture) {
        int count=0;
        char[][]ch=new char[picture.size()][picture.get(0).length()];
        for(int i=0;i<ch.length;i++){
            for(int j=0;j<ch[0].length;j++){
                ch[i][j]=picture.get(i).charAt(j);
            }
        }
        boolean [][]vis=new boolean[picture.size()][picture.get(0).length()];
        for(int i=0;i<ch.length;i++){
            for(int j=0;j<ch[0].length;j++){
                if(!vis[i][j]){
                    bfs(i,j,ch[i][j],vis,ch);
                    count++;
                }
            }
        }
        return count;
    }
    public static void bfs(int i,int j,char ch, boolean[][]vis,char [][]adj){
        Queue<Pair>pq=new LinkedList<>();
        pq.add(new Pair(i,j));
        vis[i][j]=true;
        while(!pq.isEmpty()){
            Pair op=pq.poll();
            i=op.i;
            j=op.j;
            int []delr={0,1,0,-1};
            int []delc={1,0,-1,0};
            for(int k=0;k<4;k++){
                int nrow=i+delr[k];
                int ncol=j+delc[k];
                if(nrow>=0 && nrow<adj.length && ncol>=0 && ncol<adj[0].length && !vis[nrow][ncol]  && adj[nrow][ncol]==ch){
                    vis[nrow][ncol]=true;
                    pq.add(new Pair(nrow,ncol));
                }
            }
        }
    }
}
