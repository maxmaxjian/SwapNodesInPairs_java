import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private ListNode input;
    private ListNode expected;
    private Solution soln = new Solution1();

    public SolutionTest(ListNode input, ListNode output) {
        this.input = input;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {create(new int[]{1,2,3,4}), create(new int[]{2,1,4,3})},
                {null, null}
        });
    }

    private static ListNode create(int[] nums) {
        if (nums.length == 0) {
            return null;
        } else {
            ListNode head = new ListNode(nums[0]);
            ListNode p = head;
            for(int i = 1; i < nums.length; i++) {
                p.next = new ListNode(nums[i]);
                p = p.next;
            }
            return head;
        }
    }

    @Test
    public void test() {
        assertTrue(verifyEquals(expected, soln.swapPairs(input)));
    }

    private boolean verifyEquals(ListNode expected, ListNode actual) {
        ListNode p1 = expected, p2 = actual;
        while (p1 != null && p2 != null) {
            if (p1.val == p2.val) {
                p1 = p1.next;
                p2 = p2.next;
            } else {
                return false;
            }
        }
        if (p1 != null || p2 != null) {
            return false;
        } else {
            return true;
        }
    }
}