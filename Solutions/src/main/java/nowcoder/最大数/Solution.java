package nowcoder.最大数;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solve(new int[]{12, 3, 45}));
    }

    public String solve(int[] nums) {
        if (nums == null || nums.length == 0) return "0";
        /*AtomicInteger count0 = new AtomicInteger();
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        Arrays.stream(nums).forEach(x -> {
            list.add(x);
            if (x == 0) count0.getAndIncrement();
        });
        if (count0.intValue() == nums.length) return "0";
        List<Integer> collect = list.stream().sorted((x, y) -> (y.toString() + x.toString()).compareTo(x.toString() + y.toString())).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Integer n : collect) {
            sb.append(n);
        }
        return sb.toString();*/
        quickSort(nums, 0, nums.length - 1);
        int count0 = 0;
        StringBuilder sb = new StringBuilder(nums.length);
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (nums[i] == 0) count0++;
        }
        if (count0 == nums.length) return "0";
        return sb.toString();
    }

    private void quickSort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(nums, lo, hi);
            quickSort(nums, lo, pivot - 1);
            quickSort(nums, pivot + 1, hi);
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        while (lo < hi) {
            while (lo < hi && !needExchange(pivot, nums[hi])) hi--;
            nums[lo] = nums[hi];
            while (lo < hi && !needExchange(nums[lo], pivot)) lo++;
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }

    private boolean needExchange(int i, int j) {
        return (i + "" + j).compareTo(j + "" + i) < 0;
    }
}
