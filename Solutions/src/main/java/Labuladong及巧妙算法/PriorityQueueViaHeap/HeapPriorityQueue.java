package Labuladong及巧妙算法.PriorityQueueViaHeap;

import java.util.Arrays;

class MaxPQ<K extends Comparable<K>> {
    private K[] pq;
    private int size = 0;  // 当前priority queue中的元素个数

    public MaxPQ(int capacity) {
        pq = (K[]) new Comparable[capacity + 1];   // 索引0不用
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return i * 2;
    }

    private int right(int i) {
        return i * 2 + 1;
    }

    private void swap(int i, int j) {
        K t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swim(int i) {
        while (i > 1 && less(parent(i), i)) {   // 要大于1才上浮
            swap(parent(i), i);
            i = parent(i);
        }
    }

    private void sink(int i) {
        while (left(i) <= size) {   // 如果左子节点存在
            int major = left(i);
            if (right(i) <= size && less(major, right(i))) {
                major = right(i);
            }
            if (less(i, major)) {
                swap(major, i);
                i = major;
            } else break;
        }
    }

    public K max() {
        return pq[1];
    }

    public void insert(K k) {
        pq[++size] = k;
        swim(size);
    }

    public K removeMax() {
        K r = pq[1];
        swap(1, size--);
        pq[size + 1] = null;
        sink(1);
        return r;
    }
    public void print(){
        System.out.println(Arrays.toString(pq));
    }

}

public class HeapPriorityQueue {
    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>(10);
        pq.insert(5);
        pq.insert(7);
        pq.insert(3);
        pq.insert(9);
        pq.insert(15);
        pq.insert(23);
        pq.insert(2);
        pq.insert(1);
        pq.insert(3);
        pq.insert(6);
        System.out.println(pq.removeMax());
        pq.insert(4);
        System.out.println(pq.removeMax());
        pq.insert(56);
        System.out.println(pq.removeMax());
        pq.insert(31);
        System.out.println(pq.removeMax());
        pq.print();
    }
}
