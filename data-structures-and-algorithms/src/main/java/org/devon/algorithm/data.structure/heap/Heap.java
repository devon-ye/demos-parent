package org.devon.algorithm.data.structure.heap;

/**
 * @author Devonmusa
 * @date 2019/8/9 4:42
 * @since
 */
public class Heap {
    private Comparable[] pq;
    private  int N;
    private  boolean less(int i,int j){
         return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i,int j){
        Comparable t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k){
        while ( k > 1 && less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }

    }

    private void sink(int k){
        while ( 2 * k <= N){
            int j = 2* k;
            if(j < N && less(j,j+1)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k = j;
        }
    }
}
