package study2021.suanfa;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/3/31 13:08
 */
public class ListTest {
    public static void main(String[] args) {

        //ListNode head = new ListNode(1);

        int[] i = {1,2,3,4,5};

        int b = 0;
        for (int a = 6; a >= i.length; a-- ) {
            b = a;
        }
        b--;
/*        if (a > i.length) {
            System.out.println(i[5]);
        }*/
        System.out.println(b);
        System.out.println(i[b]);


    }

    public ListNode test01(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode current = head.next;
        prev.next = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
        }
        return prev;
    }
}
