package TopK;

import java.util.Arrays;

public class Solution2 {
    class MaxHeap {
        private int[] array;
        private int n;
        private int size;

        /**
         * {@注意，是在copy的时候就已经swim排序，而不是全部copy完后再swim——会出问题}
         *
         * @param array
         */
        public MaxHeap(int[] array) {
            this.n = array.length + 1;
            this.array = new int[n];
            for (int i = 1; i < n; i++) {
                this.array[i] = array[i - 1];
                swim(i);
            }
            size = this.n - 1;
            init();
        }

        private void init() {
        }

        public int popMax() {
            int max = array[1];
            swap(1, size--);
            sink(1);
            return max;
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
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }

        private void swim(int i) {
            while (parent(i) > 0 && array[i] > array[parent(i)]) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        private void sink(int i) {
            while (left(i) <= size) {
                int max = left(i);
                if (right(i) <= size && array[left(i)] < array[right(i)]) max = right(i);
                if (array[i] > array[max]) return;
                swap(i, max);
                i = max;
            }
        }
    }

    public int solution_2(int[] nums, int k) {
        MaxHeap maxHeap = new MaxHeap(Arrays.copyOf(nums, k));
        return maxHeap.popMax();
    }
}
