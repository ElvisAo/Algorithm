package 真题.笔试真题.华为.全排列;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            System.out.println(0);
            return;
        }
        char[] array = input.toCharArray();
        HashSet<String> set = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        backtrack(array, new StringBuilder(), set, visited);
        System.out.println(set.size());
        for (String s : set) System.out.println(s);
    }

    private static void backtrack(char[] array, StringBuilder path, HashSet<String> set, HashSet<Integer> visited) {
        if (path.length() == array.length) {
            set.add(path.toString());
            return;
        }
        for (int j = 0; j < array.length; j++) {
            if (visited.contains(j)) continue;
            path.append(array[j]);
            visited.add(j);
            backtrack(array, path, set, visited);
            path.deleteCharAt(path.length() - 1);
            visited.remove(j);
        }
    }
}
