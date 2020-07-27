package com.zh.algs.ds.linkedlist;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/7/16
 */
public class DeleteANodeByGivenPosition {

    private Node head;

    public static void main(String[] args) {

        DeleteANodeByGivenPosition test = new DeleteANodeByGivenPosition();

        test.head = ListNodeUtil.append(test.head, 1);
        test.head = ListNodeUtil.append(test.head, 2);
        test.head = ListNodeUtil.append(test.head, 3);
        test.head = ListNodeUtil.append(test.head, 4);

        ListNodeUtil.print(test.head);

        test.deleteByGivenPosition(1);

        ListNodeUtil.print(test.head);

        test.deleteByGivenPosition(0);

        ListNodeUtil.print(test.head);

        test.deleteByGivenPosition(6);

        ListNodeUtil.print(test.head);

        test.deleteByGivenPosition(2);

        ListNodeUtil.print(test.head);


    }

    public void deleteByGivenPosition(int position) {

        if (head == null) {
            return;
        }

        Node tmp = head;
        //处理head位置position==0
        if (position == 0) {
            head = tmp.next;
            return;
        }

        /**
         * Description:
         * 找position前一个位置
         * 8 - 2 - 3 - 1 - 7
         * 0   1   2   3   4   5   6
         * position=3，需要删除data=1的node
         * prev node data=3，next需2步
         * 从position=0开始先next再+1，i和next次数同步调+，2 < 3-1 条件for终止，i=0，1
         */
        for (int i = 0; tmp != null && i < position - 1; i++) {
            tmp = tmp.next;
        }

        //可能5或者超过5=多余
        if (tmp == null || tmp.next == null) {
            return;
        }

        //前位置next next代表position后面node
        tmp.next = tmp.next.next;

    }

}
