package com.zh.algs.ds.exercise;

import com.zh.algs.ds.linkedlist.ListNodeUtil;
import com.zh.algs.ds.linkedlist.Node;
import com.zh.algs.sorting.utils.SortingUtils;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/2
 */
public class Sort {

    private static Node head;

    public static void main(String[] args) {

        int[] arr = {5, 8, 1, 3, 99, 56, 213, 23};
        SortingUtils.printArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        SortingUtils.printArray(arr);
        System.out.println("*******");

        int[] arr2 = {5, 8, 1, 3, 99, 56, 213, 23};
        SortingUtils.printArray(arr2);
        quickSort(arr2, 0, arr2.length - 1);
        SortingUtils.printArray(arr2);
        System.out.println("*******");

        int[] arr3 = {5, 8, 1, 3, 99, 56, 213, 23};
        SortingUtils.printArray(arr3);
        bubbleSort(arr3);
        SortingUtils.printArray(arr3);
        System.out.println("*******");

        int[] arr4 = {5, 8, 1, 3, 99, 56, 213, 23};
        SortingUtils.printArray(arr4);
        insertSort(arr4);
        SortingUtils.printArray(arr4);
        System.out.println("*******");


        head = ListNodeUtil.push(head, 1);
        head = ListNodeUtil.push(head, 10);
        head = ListNodeUtil.push(head, 8);
        head = ListNodeUtil.push(head, 7);
        head = ListNodeUtil.push(head, 4);
        ListNodeUtil.print(head);

        head = mergeLinkedList(head);
        ListNodeUtil.print(head);
    }

    public static Node mergeLinkedList(Node head1) {

        if (head1 == null || head1.next == null) {
            return head1;
        }

        Node middle = getMiddle(head1);
        Node middleNext = middle.next;
        middle.next = null;

        Node left = mergeLinkedList(head1);
        Node right = mergeLinkedList(middleNext);
        return sorted(left, right);
    }

    private static Node sorted(Node left, Node right) {

        Node res = null;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.data <= right.data) {
            res = left;
            res.next = sorted(left.next, right);
        } else {
            res = right;
            res.next = sorted(left, right.next);
        }

        return res;
    }

    private static Node getMiddle(Node head1) {

        if (head1 == null) {
            return null;
        }

        Node slow = head1;
        Node fast = head1;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void mergeSort(int[] arr, int lo, int hi) {

        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid + 1, hi);
            sorted(arr, lo, mid, hi);
        }
    }

    private static void sorted(int[] arr, int lo, int mid, int hi) {
        int n1 = mid - lo + 1;
        int n2 = hi - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        int i = 0, j = 0;
        for (i = 0; i < n1; i++) {
            left[i] = arr[lo + i];
        }
        for (j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        i = 0;
        j = 0;
        int k = lo;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivot = partition(arr, lo, hi);
            quickSort(arr, lo, pivot - 1);
            quickSort(arr, pivot + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {

        int key = arr[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (arr[j] <= key) {
                i++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        int tmp = arr[i + 1];
        arr[i + 1] = arr[hi];
        arr[hi] = tmp;
        return i + 1;

    }

    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

}
