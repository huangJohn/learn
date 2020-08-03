package com.zh.algs.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/3
 */


public class Graph {

    private int V;//顶点
    private LinkedList<Integer> adj[];//邻边

    public Graph(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public static void main(String[] args) {

        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.BFS(2);
        System.out.println();
        graph.DFS(2);

    }

    public void BFS(int s) {

        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            //本节点下一层所有节点遍历 add，先入队，随后遍历子节点
            Iterator<Integer> iterator = adj[s].listIterator();
            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public void DFS(int s) {
        boolean[] visited = new boolean[V];
        DFSUtil(s, visited);
    }

    private void DFSUtil(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        ListIterator<Integer> iterator = adj[s].listIterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            //一直递归到底
            if (!visited[next]) {
                DFSUtil(next, visited);
            }
        }
    }


}
