package com.zh.algs.ds.exercise;

import java.util.ListIterator;
import java.util.Stack;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/6
 */
public class TopologicalSort {

    private GraphTest graph;

    public TopologicalSort(int v) {
        this.graph = new GraphTest(v);
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
        boolean[] visited = new boolean[graph.V];

        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }

        System.out.println();

    }

    public void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        ListIterator<Integer> iterator = graph.adj[v].listIterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (!visited[next]) {
                visited[next] = true;
                topologicalSortUtil(next, visited, stack);
            }
        }

        stack.push(v);
    }
}
