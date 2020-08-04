package com.zh.algs.graph;

import java.util.ListIterator;
import java.util.Stack;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/4
 */
public class TopologicalSort {

    Graph graph;

    TopologicalSort(int v) {
        graph = new Graph(v);
    }

    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort(6);
        topologicalSort.graph.addEdge(5, 2);
        topologicalSort.graph.addEdge(5, 0);
        topologicalSort.graph.addEdge(4, 0);
        topologicalSort.graph.addEdge(4, 1);
        topologicalSort.graph.addEdge(2, 3);
        topologicalSort.graph.addEdge(3, 1);
        topologicalSort.topologicalSort();
    }


    public void topologicalSort() {

        Stack<Integer> stack = new Stack<>();

        //initial
        boolean[] visited = new boolean[graph.V];

        //recursive
        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

    }

    public void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        //mark
        visited[v] = true;
        ListIterator<Integer> integerListIterator = graph.adj[v].listIterator();
        Integer next;
        while (integerListIterator.hasNext()) {
            next = integerListIterator.next();
            if (!visited[next]) {
                topologicalSortUtil(next, visited, stack);
            }
        }
        stack.push(v);
    }


}
