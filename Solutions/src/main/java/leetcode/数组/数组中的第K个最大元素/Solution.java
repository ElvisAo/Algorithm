package leetcode.数组.数组中的第K个最大元素;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 0, 9999, -9999};
        int k = 3;
        System.out.println(new Solution().solution_2(arr, k));
    }

    /**
     * {@快排找k大}
     *
     * @param nums
     * @param k
     * @return
     */
    public int solution_1(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, k - 1);
        return nums[k - 1];
    }

    private void quickSort(int[] nums, int s, int e, int k) {
        if (s < e) {
            int pivot = partition(nums, s, e);
            if (pivot == k) return;
            else if (pivot < k) {
                quickSort(nums, pivot + 1, e, k);
            } else {
                quickSort(nums, s, pivot - 1, k);
            }
        }
    }

    private int partition(int[] nums, int s, int e) {
        int pivot = nums[s];
        while (s < e) {
            while (s < e && pivot >= nums[e]) e--;
            nums[s] = nums[e];
            while (s < e && pivot < nums[s]) s++;
            nums[e] = nums[s];
        }
        nums[s] = pivot;
        return s;
    }

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
        MaxHeap maxHeap = new MaxHeap(nums);
        for (int i = 1; i < k; i++) System.out.println(maxHeap.popMax());
        return maxHeap.popMax();
    }
}
