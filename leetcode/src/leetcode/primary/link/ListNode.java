package leetcode.primary.link;

import java.util.Objects;

public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

	@Override
	public boolean equals(Object o) {
		ListNode listNode = (ListNode) o;
		return val == listNode.val;
	}

	@Override
	public int hashCode() {
		return Objects.hash(val, next);
	}
}
