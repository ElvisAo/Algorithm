package 高频面试.字节跳动.排序;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int[] t = new Solution().heapSort(arr);
        System.out.println(Arrays.toString(t));
    }

    /**
     * {@冒泡}
     *
     * @param arr
     * @return
     */
    public int[] bubbleSort(int[] arr) {
        int ln = arr.length;
        for (int i = 0; i < ln; i++) {
            for (int j = 0; j < ln - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /**
     * {@选择排序：时间复杂度超了}
     *
     * @param arr
     * @return
     */
    public int[] choiceSort(int[] arr) {
        int ln = arr.length;
        for (int i = 0; i < ln; i++) {
            int minVal = arr[i], minIndex = i;
            for (int j = i; j < ln; j++) {
                if (minVal > arr[j]) {
                    minIndex = j;
                    minVal = arr[j];
                }
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    /**
     * {@快排}
     *
     * @param arr
     * @return
     */
    public int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length);
        return arr;
    }

    public void quickSort(int[] arr, int s, int e) {
        if (s < e) {
            int pivot = partition(arr, s, e);
            quickSort(arr, s, pivot);   // 左闭右开
            quickSort(arr, pivot + 1, e);
        }
    }

    private int partition(int[] arr, int s, int e) {
        int pivot = arr[s];
        int left = s, right = e - 1;
        while (left < right) {
            while (left < right && arr[right] > pivot) right--;    // 取的左边的，就要从右边开始
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) left++;
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    /**
     * {@堆排序}
     *
     * @param arr
     * @return
     */
    public int[] heapSort(int[] arr) {
        MinHeap heap = new MinHeap(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = heap.pop();
        }
        return arr;
    }

    class MinHeap {
        int[] array;
        int size;

        public MinHeap(int[] array) {
            this.array = new int[array.length + 1];
            size = 0;
            iniHeap(array);
        }

        /**
         * {@注意：在每次添加一个元素的时候，就已经对其排序了，important!!!}
         * @param array
         */
        private void iniHeap(int[] array) {
            int n = array.length;
            for (int i = 0; i < n; i++) {
                this.array[++size] = array[i];
                swim(size);
            }
        }

        public int pop() {
            int t = array[1];
            swap(1, size--);
            sink(1);
            return t;
        }


        private void swim(int i) {
            while (i > 1 && lt(i, parent(i))) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        private void sink(int i) {
            while (left(i) <= size) {
                int s = left(i);
                if (right(i) <= size && lt(right(i), s)) s = right(i);
                if (lt(s, i)) {
                    swap(i, s);
                    i = s;
                } else break;
            }
        }

        private int left(int i) {
            return i * 2;
        }

        private int right(int i) {
            return 2 * i + 1;
        }

        private int parent(int i) {
            return i / 2;
        }

        private boolean lt(int i, int j) {
            return array[i] < array[j];
        }

        private void swap(int i, int j) {
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    }
}
