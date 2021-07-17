package 面试真题.腾讯.单链表快排;

import common.ListNode;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;

/**
 * 单链表快排
 */
public class Solution {

    public static final int R = 5;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(new FileInputStream("面试真题/链表/单链表快排/input.txt"));
        int[] arr = new int[R];
        for (int i = 0; i < R; i++) {
            arr[i] = new Random().nextInt(100);
        }
/*        int[] arr = new int[4];
        arr[0] = 4;
        arr[1] = 2;
        arr[2] = 1;
        arr[3] = 3;*/
        System.out.println(Arrays.toString(arr));
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            p.next = node;
            p = p.next;
        }
        quickSort(head.next, null);
        head = head.next;
        while (head != null) {
            System.out.print(head);
            head = head.next;
        }
    }

    /**
     * {@主要是通过swap节点的值来减少了交换节点的麻烦}
     *
     * @param head
     * @param tail
     */
    public static void quickSort(ListNode head, ListNode tail) {
        if (head != tail) {
            /**
             * {@以各部分第一个元素为pivot元素,然后划分左右}
             */
            ListNode pr = partition(head, tail);
            /**
             * {@首可取，尾不可取}
             */
            quickSort(head, pr);
            quickSort(pr.next, tail);
        }
    }

    /**
     * {@核心在于partition的时候只交换值}
     * {@因为每次partitiond的时候都只交换值，所以实际上每次quicksort递归的时候，也是只看值的，不要被head节点所迷惑}
     *
     * @param head
     * @param tail
     * @return
     */
    private static ListNode partition(ListNode head, ListNode tail) {
        if (head == tail) return head;

        /**
         * {@把pivot的值取出来}
         */
        int val = head.val;
        ListNode pre = head, slow = head.next, fast;
        /**
         * {@用pre记录比pivot小的最后一个元素，交换的时候是用pre进行交换的}
         */
        while (true) {
            /**
             * {@slow表示比pivot元素大的元素，pre表示比pivot小的最后一个值，注意循环外是用pre与head进行的交换}
             * {@在while结束的时候，slow是比pivot大的，注意后面fast在while结束后是比pivot小的，所以交换slow和fast}
             */
            while (slow != tail && slow.val < val) {
                pre = slow;
                slow = slow.next;
            }
            if (slow == tail) break;

            /**
             * {@fast表示比pivot元素小的元素——while结束的时候}
             */
            fast = slow.next;
            while (fast != tail && fast.val > val) {
                fast = fast.next;
            }
            if (fast == tail) break;
            /**
             * {@如果存在fast在slow之后,则交换两个元素的值}
             */
            swap(slow, fast);
            /**
             * 后面遍历的时候会自动往后面走，所以这里其实不需要再手动往后面移
             */
         /*   pre = slow;
            slow = slow.next;*/
        }
        /**
         * {@注意是pre和head交换，因为pre是比pivot（也就是head）小的最后一个值，即，交换后，pivot前面的元素都比pivot小}
         * {@把pivot的值填回去}
         */
        swap(head, pre);
        /**
         * {@注意，返回的是节点，因为是交换后的，所以pre的val其实就是pivot}
         */
        return pre;
    }

    /**
     * 节点的交换仅通过值的交换来实现
     *
     * @param one
     * @param two
     */
    private static void swap(ListNode one, ListNode two) {
        int tmp = one.val;
        one.val = two.val;
        two.val = tmp;
    }
}