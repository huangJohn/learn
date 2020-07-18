package com.zh.algs.ds.linkedlist;

import java.util.Stack;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/17
 */
public class FindIsPalindrome {


    private Node head;

    private Node secondHalf;

    public static void main(String[] args) {

        FindIsPalindrome findIsPalindrome = new FindIsPalindrome();
        findIsPalindrome.head = ListNodeUtil.createHeadByAppend4Palindrome2();
        ListNodeUtil.print(findIsPalindrome.head);
        System.out.println(findIsPalindrome.isPalindrome());
        ListNodeUtil.print(findIsPalindrome.head);

        System.out.println(findIsPalindrome.isPalindromeByStack());

    }

    public boolean isPalindrome() {

        if (head != null && head.next != null) {

            /*first find middle*/
            Node slow = head, fast = head;
            Node prevOfSlow = null;
            Node middle = null;

            boolean isPalindrome = true;

            while (slow != null && fast != null && fast.next != null) {
                fast = fast.next.next;

                prevOfSlow = slow;
                slow = slow.next;
            }

            if (fast != null) {
                middle = slow;
                slow = slow.next;
            }

            secondHalf = slow;
            prevOfSlow.next = null;
            reserve();

            isPalindrome = compare(head, secondHalf);

            reserve();

            if (middle != null) {
                prevOfSlow.next = middle;
                middle.next = secondHalf;
            } else {
                prevOfSlow.next = secondHalf;
            }

            return isPalindrome;
        }

        return false;
    }

    private boolean compare(Node head, Node secondHalf) {

        Node tmp1 = head;
        Node tmp2 = secondHalf;

        while (tmp1 != null && tmp2 != null) {
            if (tmp1.data == tmp2.data) {
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
            } else {
                return false;
            }
        }

        if (tmp1 == null && tmp2 == null) {
            return true;
        }

        return false;
    }

    private void reserve() {

        Node cur = secondHalf;
        Node prev = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        secondHalf = prev;
    }

    public boolean isPalindromeByStack() {

        Stack<Integer> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur.data);
            cur = cur.next;
        }

        boolean isPalindrome = true;
        cur = head;
        while (cur != null) {
            Integer pop = stack.pop();
            if (pop != cur.data) {
                isPalindrome = false;
                break;
            }
            cur = cur.next;
        }

        return isPalindrome;

    }

}
