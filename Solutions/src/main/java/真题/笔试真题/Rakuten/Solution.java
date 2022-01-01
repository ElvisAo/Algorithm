package 真题.笔试真题.Rakuten;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int lmt = A.length;
        int l = 0, r = lmt, res = lmt;
        while (l <= r) {
            int m = (l + r) / 2;
            if (check(A, m)) {    // 对候选解进行二分搜索，直到找到这个解（逼近）
                res = m;
                r = m - 1;
            } else l = m + 1;
        }
        return res;
    }

    private boolean check(int[] a, int m) {
        int n = a.length;
        int cnt = 0, cnt2 = 0;  // 记录不满足低估与高峰的
        for (int i = 1; i < n; i += 2) {
            if (i + 1 < n) {        //
                if (!(a[i - 1] > a[i] && a[i] < a[i + 1])) cnt++;   // 非峰值的数量
                if (!(a[i - 1] < a[i] && a[i] > a[i + 1])) cnt2++;  // 非低估的数量
            } else {    // 对最后一个元素特殊处理，由于是i+=2，所以这里天然就分了奇偶讨论
                if (!(a[i - 1] > a[i])) cnt++;
                if (!(a[i - 1] < a[i])) cnt2++;
            }
        }
        if (cnt <= m || cnt2 <= m) return true;
        return false;
    }

    public int solution2(int[] A) {
        int n = A.length;
        int cnt1 = 0, cnt2 = 0;
        for (int i = 1; i < n; i += 2) {
            if (i + 1 < n) {
                if (!(A[i - 1] < A[i] && A[i] > A[i + 1])) cnt1++;
                if (!(A[i - 1] > A[i] && A[i] < A[i + 1])) cnt2++;
            } else {    // equals to if(i + 1 == n),
                if (!(A[i - 1] < A[i])) cnt1++;
                if (!(A[i - 1] > A[i])) cnt2++;
            }
        }
        return Math.min(cnt1, cnt2);
    }
}

/*
#include<vector>
#include<iostream>

using namespace std;

        bool check(vector<int> &A, int ans) {
        int n = A.size();
        int cnt = 0;
        int cnt2 = 0;
        for(int i=1; i<n; i+=2) {
        if(i+1<n) {
        if(!(A[i-1] > A[i] && A[i] < A[i+1])) {
        cnt++;
        }
        if(!(A[i-1] < A[i] && A[i] > A[i+1])) {
        cnt2++;
        }
        }
        else {
        if(!(A[i-1] > A[i])) {
        cnt++;
        }
        if(!(A[i-1] < A[i])) {
        cnt2++;
        }
        }
        }
        if(cnt <=ans || cnt2 <= ans)
        return true;
        return false;
        }

        int solution(vector<int> &A) {
        int lmt = 100000;
        int l=0, r=lmt, ans=lmt;
        while(l<=r) {
        int m = (l+r)/2;
        if(check(A, m)) {
        ans = m;
        r = m - 1;
        }
        else {
        l = m + 1;
        }
        }
        return ans;
        }*/
