package 真题.笔试真题.阿里.星球问题;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * if gg[i] == gg[j] * p，则可以在i、j星球间跳动，其中 p为1或质数
 * 问：能否在只经过1~r星球的条件下，从星球l到星球r
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), q = scanner.nextInt();
        int[] gg = new int[n + 1];
        int maxN = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            gg[i] = scanner.nextInt();
            maxN = maxN < gg[i] ? gg[i] : maxN;
        }
        int counter = 0, l, r;
        LinkedHashSet<Integer> primes = new LinkedHashSet<>();
        calcPrimeSeq(primes, maxN);
        for (int i = 1; i <= n; )
            while (counter < q) {
                l = scanner.nextInt();
                r = scanner.nextInt();
                if ((gg[l] == 1 && primes.contains(gg[r])) || helper(primes, gg, l, r))
                    System.out.println("ok");
                else System.out.println("no");
            }
    }

    private static boolean helper(LinkedHashSet<Integer> primes, int[] gg, int l, int r) {
        if (!canReachL(primes, gg, l)) return false;
        return lcanReachL(primes, gg, r, gg[l]);
    }

    private static boolean canReachL(LinkedHashSet<Integer> primes, int[] gg, int l) {
        if (primes.contains(gg[l])) return true;
        Iterator<Integer> iterator = primes.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            int ele = iterator.next();
            if (ele % gg[l] == 0) {
                return canReachL(primes, gg, ele / gg[l]);
            }
        }
        return false;
    }

    private static boolean lcanReachL(LinkedHashSet<Integer> primes, int[] gg, int rval, int lval) {
        Iterator<Integer> iterator = primes.iterator();
        while (iterator.hasNext()) {
            int ele = iterator.next();
            if (lval * ele < rval) {
                if (rval % ele == 0 && lcanReachL(primes, gg, rval / ele, lval)) {
                    return true;
                }
            } else if (lval * ele == rval) return true;
            else if (lval * ele > rval) return false;
        }
        return false;
    }

    private static void calcPrimeSeq(LinkedHashSet<Integer> primes, int maxN) {
        boolean isPrime;
        for (int i = 1; i <= maxN; i++) {
            isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
    }
}
