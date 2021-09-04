package Rehash;

public class Rehash {
    public static void main(String[] args) {
        int[] fake_input = {1, 2, 2, 2, 3};
        System.out.println(new Rehash().solution(fake_input));
    }

    public int solution(int[] arr) {
        int n = arr.length;
        int r = arr[0], counter = 1;
        for (int i = 1; i < n; i++) {   // 找出现次数超过一半的数字
            if (arr[i] == r) counter++;
            else {
                counter--;
                if (counter == 0) {
                    r = arr[i];
                    counter++;
                }
            }
        }
        counter = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == r) counter++;
        }
        return counter > n / 2 ? r : -1;
    }
}
