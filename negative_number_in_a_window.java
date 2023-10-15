package com.company.Sliding_window;

import java.util.LinkedList;
import java.util.Queue;

public class first_neg_number_in_every_n_size_window {
    public static void main(String[] args) {

    }
    public long[] printFirstNegativeInteger(long A[], int N, int k)
    {
        int i=0;
        int j=0;
        long[]ans=new long[A.length-k+1];
        int op=0;
        Queue<Long> q=new LinkedList<>();
        while(j<A.length){
            if(A[j]<0){
                q.add(A[j]);
            }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(!q.isEmpty()){
                    ans[op]=q.peek();
                    if(A[i]==q.peek()){
                        q.poll();
                    }
                }
                else{
                    ans[op]=0;
                }
                i++;
                j++;
                op++;
            }
        }
        return ans;
    }
}
