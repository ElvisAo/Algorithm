# 二分查找中的一些注意事项

- 二分查找的三大要素：
    - left与right的初值
    - while(left?right)中？的取值
    - 跳出while后left与right的状态
- 个人习惯：
  - 如果是查找某个指定值（可能不在数组中），包括左右边界：
    - 初值：left = 0, right = nums.length-1
    - while(left <= right)，因为==时也要进行判断
    - 跳出循环后，left = right + 1
  - 如果是查找数组中的最值（最大最小值，一定在数组中）：
    - 初值：left = 0, right = nums.length-1
    - while(left < right)
    - 跳出循环后left==right，这时候这个值往往就是所求值，当然，具体的要根据while中的if来判断
- 找左边界时：
    - 当==时，需要往左边逼近，所以right = mid - 1
    - 如果答案存在，则为lo
- 找右边界时：
    - 当==时，需要往右边避近，所以left = mid + 1
    - 如果答案存在，则为hi
- while中left?right与right初值的关系：
    - 一般个人喜欢取right = nums.length-1
    - 当？为<=时，表明跳出循环后left>right，亦即left~right区间内没有元素
    - 当？为<时，表明跳出循环后left==right，亦即区间内还有一个元素
- 对于不存在的case，一定要在最后判断是否==target
- 取mid时，>>与/的注意点：
    - \>>时，(-1>>1) == -1
    - /时，由于需要算加法，可能存在溢出的情况
    - 最佳写法：left+(right-left)/2

切记：由于==时while会继续，所以在循环中，==时一定需要移动，而不能是left=mid or right=mid