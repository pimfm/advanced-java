package nl.HAN.ASD.APP.graph;

import nl.HAN.ASD.APP.dataStructures.LinkedList.MyLinkedList;
import nl.HAN.ASD.APP.dataStructures.MyQueue;

import java.util.Arrays;

/**
 * Created by Pim van Gurp, 9/16/2015.
 */
public class GraphMain {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge("Apeldoorn", "Arnhem", 33.1);
        graph.addEdge("Apeldoorn", "Teuge", 6.6);
        graph.addEdge("Apeldoorn", "Deventer", 20.5);
        graph.addEdge("Teuge", "Deventer", 11.1);
        graph.addEdge("Teuge", "Twello", 0.1);
        graph.addEdge("Twello", "Deventer", 0.1);
        graph.addEdge("Deventer", "Enschede", 0.1);

        System.out.println(graph.toString());
        System.out.println(Arrays.toString( graph.shortestPath("Apeldoorn", "Deventer") ));
        System.out.println("Connected: " + graph.isConnected());

        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(456);
        list.add(98);
        list.add(45);
        System.out.println(Arrays.toString(list.toArray(new Integer[list.size()])));

        MyQueue<Integer> q = new MyQueue<>();
        q.enqueue(34);
        q.enqueue(45);
        q.enqueue(67);
        System.out.println(Arrays.toString(q.toArray()));
    }
}