package leetcode.primary.link;

/**
 * 相交链表
 * https://leetcode-cn.com/submissions/detail/33374878/
 */
public class IntersectionNode {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        ListNode currentA = headA;
        while (currentA != null) {
            ListNode currentB = headB;
            while (currentB != null) {
                if (currentA == currentB) {
                    return currentB;
                }
                currentB = currentB.next;
            }
            currentA = currentA.next;
        }

        return null;
    }

    /**
     * 第二种解决方案
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            if (l1 != null) {
                l1 = l1.next;
            } else {
                l1 = headB;
            }
            if (l2 != null) {
                l2 = l2.next;
            } else {
                l2 = headA;
            }
        }
        return l1;
    }

}
