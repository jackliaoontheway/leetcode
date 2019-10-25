package leetcode.primary.link;

import java.math.BigInteger;

/**
 * 两数相加
 * https://leetcode-cn.com/submissions/detail/34230984/
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(9);
        ListNode node12 = new ListNode(9);
        ListNode node13 = new ListNode(9);
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node12;
        node12.next = node13;

        node1 = new AddTwoNumbers().addTwoNumbers2(node1, node4);

        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }

    /**
     * 第二种解决方案
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode current = null;
        boolean plusOne = false;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int valPlus = l1.val + l2.val;
                if (plusOne) {
                    valPlus++;
                }
                plusOne = (valPlus >= 10);

                ListNode newNode = new ListNode(valPlus % 10);
                if (current == null) {
                    result = newNode;
                } else {
                    current.next = newNode;
                }
                current = newNode;

                l1 = l1.next;
                l2 = l2.next;
                continue;
            }
            if (l1 != null) {
                int valPlus = l1.val;
                if (plusOne) {
                    valPlus++;
                }
                plusOne = (valPlus >= 10);
                ListNode newNode = new ListNode(valPlus % 10);
                if (current == null) {
                    result = newNode;
                } else {
                    current.next = newNode;
                }
                current = newNode;
                l1 = l1.next;
                continue;
            }
            if (l2 != null) {
                int valPlus = l2.val;
                if (plusOne) {
                    valPlus++;
                }
                plusOne = (valPlus >= 10);
                ListNode newNode = new ListNode(valPlus % 10);
                if (current == null) {
                    result = newNode;
                } else {
                    current.next = newNode;
                }
                current = newNode;
                l2 = l2.next;
                continue;
            }
        }
        if (plusOne) {
            current.next = new ListNode(1);
        }
        return result;
    }

    /**
     * 第一种解决方案 使用 BigInteger
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.append(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.append(l2.val);
                l2 = l2.next;
            }
        }
        s1 = s1.reverse();
        s2 = s2.reverse();

        BigInteger bPlus = new BigInteger(s1.toString()).add(new BigInteger(s2.toString()));

        ListNode result = null;
        if (bPlus.compareTo(BigInteger.valueOf(10)) < 0) {
            result = new ListNode(bPlus.intValue());
            return result;
        }

        ListNode currentNode = null;
        while (bPlus.divide(BigInteger.valueOf(10)).compareTo(BigInteger.valueOf(0)) > 0) {
            int x = bPlus.remainder(BigInteger.valueOf(10)).intValue();
            if (result == null) {
                result = new ListNode(x);
                currentNode = result;
            } else {
                currentNode.next = new ListNode(x);
                currentNode = currentNode.next;
            }
            bPlus = bPlus.divide(BigInteger.valueOf(10));
        }
        if (bPlus.intValue() > 0) {
            currentNode.next = new ListNode(bPlus.intValue());
        }
        return result;
    }
}
