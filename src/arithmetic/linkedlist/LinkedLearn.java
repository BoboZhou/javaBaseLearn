package arithmetic.linkedlist;

import java.util.Objects;

/**
 * 链表算法学习类
 */
public class LinkedLearn {
    public static void main(String[] args) {
        Node node1 = new Node(1, null);

        Node node2 = new Node(2, null);

        Node node3 = new Node(3, null);

        Node node4 = new Node(4, null);

        Node node5 = new Node(5, null);

        Node node6 = new Node(6, null);

        Node node7 = new Node(7, null);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;



    }

    static void mergerTowSortLink() {

    }

    static void removeNode(Integer val) {

    }

    static class Node {
        Integer val;
        Node next;
        Node pre;
        Node first;
        Node tail;

        public Node(Integer val, Node next, Node pre) {
            this.val = val;
            this.next = next;
            this.pre = pre;
        }

        public Node(Integer val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(Integer val) {
            this.val = val;
        }

        public void addNode(Node node) {
            if (first == null) {
                first = node;
                tail = node;
            }
        }
    }


}


