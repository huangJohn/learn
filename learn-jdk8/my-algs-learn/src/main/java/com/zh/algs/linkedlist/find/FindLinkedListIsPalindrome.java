package com.zh.algs.linkedlist.find;

import java.util.Stack;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/4/10
 */
public class FindLinkedListIsPalindrome {


    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    Node secondHalfHead;

    public static void main(String[] args) {

        FindLinkedListIsPalindrome findLinkedListIsPalindrome = new FindLinkedListIsPalindrome();
        findLinkedListIsPalindrome.push(1);
        findLinkedListIsPalindrome.push(2);
        findLinkedListIsPalindrome.push(3);
        findLinkedListIsPalindrome.push(3);
        findLinkedListIsPalindrome.push(2);
        findLinkedListIsPalindrome.push(1);

        System.out.println(findLinkedListIsPalindrome.isPalindrome());
        System.out.println(findLinkedListIsPalindrome.isPalindromeByReserve());
    }

    public void push(int data) {

        Node node = new Node(data);
        node.next = head;
        head = node;
    }


    public boolean isPalindromeByReserve() {

        Node slow = head;
        Node fast = head;
        boolean isPalindrome = true;

        Node prevOfSlow = null;
        Node middle = null;

        if (head != null && head.next != null) {

            while ( fast != null && fast.next != null) {
                fast = fast.next.next;
                prevOfSlow = slow;
                slow = slow.next;

            }

            if (fast != null) {
                middle = slow;
                slow = slow.next;
            }

            secondHalfHead = slow;
            prevOfSlow.next = null;
            reserve();

            isPalindrome = compare(head, secondHalfHead);

            reserve();

            if (middle != null) {
                prevOfSlow.next = middle;
                middle.next = secondHalfHead;
            } else {
                prevOfSlow.next = secondHalfHead;
            }

        }
        return isPalindrome;

    }

    private boolean compare(Node head, Node secondHalfHead) {

        Node tmp1 = head;
        Node tmp2 = secondHalfHead;
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

        Node cur = secondHalfHead;
        Node prev = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        secondHalfHead = prev;
    }

    public boolean isPalindrome() {


        Stack<Integer> stack = new Stack<>();

        Node cur = head;

        while (cur != null) {
            stack.push(cur.data);
            cur = cur.next;
        }

        boolean isPalindrome = true;

        Node tmp = head;
        while (tmp != null) {
            Integer pop = stack.pop();
            if (tmp.data != pop) {
                isPalindrome = false;
                break;
            }
            tmp = tmp.next;
        }

        return isPalindrome;


    }

}
