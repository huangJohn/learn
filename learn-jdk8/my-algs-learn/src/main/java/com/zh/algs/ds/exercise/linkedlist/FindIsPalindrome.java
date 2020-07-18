package com.zh.algs.ds.exercise.linkedlist;

import com.zh.algs.ds.linkedlist.ListNodeUtil;
import com.zh.algs.ds.linkedlist.Node;

import java.util.Stack;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/18
 */
public class FindIsPalindrome {


    private Node head;


    private Node secondHalf;

    public static void main(String[] args) {

        FindIsPalindrome findIsPalindrome = new FindIsPalindrome();
        findIsPalindrome.head = ListNodeUtil.createHeadByAppend4Palindrome2();
        System.out.println(findIsPalindrome.isPalindrome());
        System.out.println(findIsPalindrome.isPalindromeByStack());

        findIsPalindrome.head = ListNodeUtil.createHeadByAppend4Palindrome();
        System.out.println(findIsPalindrome.isPalindrome());
        System.out.println(findIsPalindrome.isPalindromeByStack());

    }


    public boolean isPalindrome() {


        if (head != null && head.next != null) {


            Node slow = head, fast = head;


            Node prevOfSlow = null;
            Node middle = null;

            while (slow != null && fast != null && fast.next != null) {
                prevOfSlow = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            /**
             * Description:
             * 1-2-3-4-3-2-1
             *     a
             *         a
             *             a
             *
             * 1-2-3-3-2-1
             *     a
             *         a
             *             a=null
             */
            if (fast != null) {
                middle = slow;
                slow = slow.next;
            }

            boolean isPalindrome = true;

            secondHalf = slow;
            prevOfSlow.next = null;
            reverse();

            isPalindrome = compare(head, secondHalf);

            reverse();

            if (middle != null) {
                prevOfSlow.next = middle;
                middle.next = slow;
            } else {
                prevOfSlow.next = slow;
            }


            return isPalindrome;
        }

        return false;
    }

    public boolean compare(Node head, Node secondHalf) {
        Node tmp1 = head;
        Node tmp2 = secondHalf;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.data != tmp2.data) {
                return false;
            } else {
                tmp1 = tmp1.next;
                tmp2 = tmp2.next;
            }
        }


        if (tmp1 == null && tmp2 == null) {
            return true;
        }


        return false;
    }

    public void reverse() {

        Node cur = secondHalf;

        Node next = null;
        Node prev = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        secondHalf = prev;

    }


    public boolean isPalindromeByStack() {


        Node cur = head;

        Stack<Integer> stack = new Stack<>();

        while (cur != null) {
            stack.push(cur.data);
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            Integer pop = stack.pop();
            if (pop != cur.data) {
                return false;
            }
            cur = cur.next;
        }

        return true;

    }

}
