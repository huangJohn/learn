package com.zh.algs.test.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/16
 */
public class FindNthNodeFromEndInALinkedList {

    /**
     * Description:
     * 也可以用双快慢指针实现
     */

    private Node head;

    public static void main(String[] args) {

        FindNthNodeFromEndInALinkedList test = new FindNthNodeFromEndInALinkedList();
        test.head = ListNodeUtil.push(test.head, 1);
        test.head = ListNodeUtil.push(test.head, 2);
        test.head = ListNodeUtil.push(test.head, 3);
        test.head = ListNodeUtil.push(test.head, 4);
        ListNodeUtil.print(test.head);

        System.out.println(test.findNthFromEnd(2));
        System.out.println(test.findNthFromEnd(4));
        System.out.println(test.findNthFromEnd(5));

    }


    /**
     * Description:
     * 1 - 2 - 3 - 4         n=1      >         正数 3 length=4 4-1=3
     *                       n=2      >         正数 2          4-2=2
     *                       n=4                    0          4-4=0
     *
     */
    public int findNthFromEnd(int nFromEnd) {

        int length = ListNodeUtil.findLength(head);

        if (length < nFromEnd) {
            throw new RuntimeException("倒数n值大于了链表长度");
        }


        return ListNodeUtil.findNthNode(head, length - nFromEnd);
    }

}
