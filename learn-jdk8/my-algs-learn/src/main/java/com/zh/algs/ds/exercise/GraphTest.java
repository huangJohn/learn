package com.zh.algs.ds.exercise;

import com.zh.algs.graph.Graph;
import org.bouncycastle.mail.smime.CMSProcessableBodyPartInbound;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2020/8/5
 */
public class GraphTest {

    public int V;
    public LinkedList<Integer>[] adj;

    public void addEdge(int v, int w) {
        this.adj[v].add(w);
    }

    public static void main(String[] args) {


        GraphTest graph = new GraphTest(4);
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

    public GraphTest(int v) {
        V = v;
        adj = new LinkedList[this.V];

        for (int i = 0; i < this.adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void BFS(int s) {

        boolean[] visited = new boolean[V];
        visited[s] = true;

        LinkedList<Integer> q = new LinkedList<>();
        q.add(s);

        while (q.size() != 0) {
            s = q.poll();
            System.out.print(s + "\t");

            ListIterator<Integer> iterator = adj[s].listIterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

    public void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + "\t");
        ListIterator<Integer> iterator = adj[v].listIterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (!visited[next]) {
                DFSUtil(next, visited);
            }
        }
    }
}
