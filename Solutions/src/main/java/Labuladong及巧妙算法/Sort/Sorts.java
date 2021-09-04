package Labuladong及巧妙算法.Sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Sorts {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 1, 3, 324, 1, 2};
        new Sorts().heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean exchanged = true;
        for (int i = 1; i < n; i++) {
            if (!exchanged) break;
            exchanged = false;
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    exchanged = true;
                }
            }
        }
    }

    /**
     * 双向冒泡
     *
     * @param arr
     */
    public void doubleBubbleSort(int[] arr) {
        int n = arr.length, left = 0, right = n - 1;
        while (left < right) {
            for (int i = left + 1; i <= right; i++) {
                if (arr[left] > arr[i]) {   // 把后面最小的放到前面
                    swap(arr, left, i);
                }
            }
            left++;
            for (int i = right; i >= left; i--) {
                if (arr[right] < arr[i]) {  // 把前面大的放到后面
                    swap(arr, right, i);
                }
            }
            right--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * 快排
     *
     * @param arr
     */
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int s, int e) {
        if (s < e) {
            int pivot = partition(arr, s, e);
            quickSort(arr, pivot + 1, e);
            quickSort(arr, s, pivot - 1);
        }
    }

    private int partition(int[] arr, int s, int e) {
        int pivot = arr[s];
        while (s < e) {
            while (s < e && pivot < arr[e]) e--;
            arr[s] = arr[e];
            while (s < e && pivot >= arr[s]) s++;
            arr[e] = arr[s];
        }
        arr[s] = pivot;
        return s;
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public void choiceSort(int[] arr) {
        int n = arr.length;
        int minVal, minIndex;
        for (int i = 0; i < n; i++) {
            minIndex = i;
            minVal = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (minVal > arr[j]) {
                    minIndex = j;
                    minVal = arr[j];
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 堆排序
     *
     * @param arr
     */
    public void heapSort(int[] arr) {
        /**
         * 小顶堆
         */
        class MinHeap {
            int[] arr;
            int size;   // size，可以取得

            public MinHeap(int[] arr) {
                this.size = 0;
                this.arr = new int[arr.length + 1];
                for (int i = 1; i <= arr.length; i++) { // 关键点在于添加的时候就上浮
                    this.arr[i] = arr[i - 1];
                    size++;
                    swim(size);
                }
            }

            public int pop() {
                int v = arr[1];
                swap(1, size--);
                sink(1);
                return v;
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

            private boolean less(int i, int j) {
                return arr[i] < arr[j];
            }

            private void swap(int i, int j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }

            private void swim(int i) {
                while (parent(i) > 0) {
                    if (less(i, parent(i))) {
                        swap(i, parent(i));
                        i = parent(i);
                    } else break;
                }
            }

            private void sink(int i) {
                int smaller;
                while (left(i) <= size) {
                    smaller = left(i);
                    if (right(i) <= size && less(right(i), left(i))) smaller = right(i);
                    if (less(smaller, i)) {
                        swap(smaller, i);
                        i = smaller;
                    } else break;
                }
            }
        }
        MinHeap minHeap = new MinHeap(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = minHeap.pop();
        }
    }
}
