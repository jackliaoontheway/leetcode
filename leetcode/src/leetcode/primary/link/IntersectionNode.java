package leetcode.primary.link;

/**
 * 相交链表
 * https://leetcode-cn.com/submissions/detail/33374878/
 */
public class IntersectionNode {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null  || headB == null ) {
            return null;
        }

        ListNode currentA = headA;
        while(currentA != null) {
            ListNode currentB = headB;
            while(currentB != null) {
                if(currentA == currentB) {
                    return currentB;
                }
                currentB = currentB.next;
            }
            currentA = currentA.next;
        }

        return null;
    }

}
