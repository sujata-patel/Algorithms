package sujata.algo;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private static class Node {
        int key, val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private int capacity;
    Map<Integer, Node> cache;
    private Node head, tail;

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null)
            return -1;
        moveToFront(node);
        return node.val;
    }

    private void moveToFront(Node node) {
        if(node.prev != null) {
            node.prev.next = node.next;
            node.prev = null;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
            node.next = head;
        }else{
            tail = node;
        }

        if(head != null) {
            head.prev = node;
        }
        head = node;
        if(tail == null) {
            tail = node;
        }

    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.val = value;
            moveToFront(node);
        } else {
            node = new Node(key, value);
            if (cache.size() == capacity) {
                cache.remove(tail.key);
                removeNode(tail);
            }
            insertAtHead(node);
            map.put(key, node);
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);

    }
}
