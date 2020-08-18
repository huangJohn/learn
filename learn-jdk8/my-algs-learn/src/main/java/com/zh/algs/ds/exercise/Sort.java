package com.zh.algs.ds.exercise;

import com.zh.algs.ds.linkedlist.ListNodeUtil;
import com.zh.algs.ds.linkedlist.Node;
import com.zh.algs.sorting.utils.SortingUtils;

import javax.swing.*;

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
        System.out.println("****归并排序结束***");

        int[] arr2 = {5, 8, 1, 3, 99, 56, 213, 23};
        SortingUtils.printArray(arr2);
        quickSort(arr2, 0, arr2.length - 1);
        SortingUtils.printArray(arr2);
        System.out.println("****快排结束***");

        int[] arr3 = {5, 8, 1, 3, 99, 56, 213, 23};
        SortingUtils.printArray(arr3);
        bubbleSort(arr3);
        SortingUtils.printArray(arr3);
        System.out.println("****冒泡结束***");

        int[] arr4 = {5, 8, 1, 3, 99, 56, 213, 23};
        SortingUtils.printArray(arr4);
        insertSort(arr4);
        SortingUtils.printArray(arr4);
        System.out.println("****插入结束***");


        head = ListNodeUtil.push(head, 1);
        head = ListNodeUtil.push(head, 10);
        head = ListNodeUtil.push(head, 8);
        head = ListNodeUtil.push(head, 7);
        head = ListNodeUtil.push(head, 4);
        ListNodeUtil.print(head);
        head = mergeLinkedList(head);
        ListNodeUtil.print(head);
        System.out.println("*****链表归并结束*****");

        int k = 4;
        System.out.println("nums数组第" + k + "小的数字是:" + kthSmallestNum(arr, k));
        System.out.println("nums数组第" + k + "大的数字是:" + kthLargestNum(arr, k));
    }

    public static int kthLargestNum(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (k > nums.length) {
            return -1;
        }

        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int pivot = partition(nums, lo, hi);
            if (pivot == nums.length - k) {
                return nums[pivot];
            } else if (pivot > k - 1) {
                hi = pivot - 1;
            } else {
                lo = pivot + 1;
            }
        }
        return -1;
    }

    public static int kthSmallestNum(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (k > nums.length) {
            return -1;
        }

        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int pivot = partition(nums, lo, hi);
            if (pivot == k - 1) {
                return nums[pivot];
            } else if (pivot > k - 1) {
                hi = pivot - 1;
            } else {
                lo = pivot + 1;
            }
        }
        return -1;
    }


    public static Node mergeLinkedList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node cur = head;

        Node middle = getMiddle(cur);
        Node middle_next = middle.next;
        middle.next = null;

        Node left = mergeLinkedList(cur);
        Node right = mergeLinkedList(middle_next);

        return doMerge4LinkedList(left, right);
    }

    private static Node doMerge4LinkedList(Node left, Node right) {

        Node res = null;

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.data <= right.data) {
            res = left;
            res.next = doMerge4LinkedList(left.next, right);
        } else {
            res = right;
            res.next = doMerge4LinkedList(left, right.next);
        }

        return res;
    }

    private static Node getMiddle(Node head) {

        if (head==null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
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
        int key = lo;
        while (lo <= hi) {
            while (lo <= hi && arr[lo] <= arr[key]) {
                lo++;
            }
            while (lo <= hi && arr[hi] >= arr[key]) {
                hi--;
            }
            if (lo > hi) {
                break;
            }
            int tmp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = tmp;
        }
        int tmp = arr[hi];
        arr[hi] = arr[key];
        arr[key] = tmp;
        return hi;
    }

    public static void mergeSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = (hi + lo) >> 1;
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid + 1, hi);
            doMerge(arr, lo, mid, hi);
        }
    }

    private static void doMerge(int[] arr, int lo, int mid, int hi) {
        int n1 = mid - lo + 1;
        int n2 = hi - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[lo + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = lo;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


}
