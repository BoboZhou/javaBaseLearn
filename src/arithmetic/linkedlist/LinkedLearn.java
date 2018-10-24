package arithmetic.linkedlist;

/**
 * 链表算法学习类
 */
public class LinkedLearn {
    public static void main(String[] args) {
        Node nodeOne = new Node(1);
        for (int i = 1; i < 10; i++) {

            nodeOne.add(new Node(i));

        }
        nodeOne.add(new Node(39));
        System.out.println(nodeOne);

        Node nodeTwo = new Node(1);
        for (int i = 1; i < 50; i = i * 2) {
            nodeTwo.add(new Node(i));

        }
        System.out.println(nodeTwo);

        Node x = mergerTowSortLink(nodeOne.first, nodeTwo.first);
        System.out.println(x);

    }

    /**
     * @return
     * @Description : 合并两个有序链表
     * @Param :
     * @Author bobo
     * @date: 2018/9/28
     */
    static Node mergerTowSortLink(Node n1, Node n2) {
        Node n = new Node();

        Node current = n1.val >= n2.val ? n2 : n1;
        n.next = current;
        Node n1Next = n1.next;
        Node n2Next = n2.next;
        while (n2Next != null || n1Next != null) {
            /** 其中一个为null 走到了末尾*/
            if (n1Next == null) {
                current.next = n2Next;
                current = n2Next;
                n2Next = n2Next.next;
            } else if (n2Next == null) {
                current.next = n1Next;
                current = n1Next;
                n1Next = n1Next.next;
            }
            //俩个都不为null
            else if (n1Next.val == n2Next.val) {
                n2Next = n2Next.next;
            } else if (n1Next.val < n2Next.val) {

                current.next = n1Next;
                current = n1Next;
                n1Next = n1Next.next;
            }
            else {
                current.next = n2Next;
                current = n2Next;
                n2Next = n2Next.next;
            }

        }
        return n;


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

        public Node() {
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

        public synchronized void add(Node node) {
            if (first == null) {
                first = node;
                tail = node;
                return;
            }
            first.tail = node;
            tail.next = node;
            tail = node;


        }

        @Override
        public String toString() {
            Node c = first;
            if (null ==  c)
                first = next;
            StringBuilder stringBuffer = new StringBuilder();
            while (c!= null && c.next != null) {
                stringBuffer.append(c.val).append(" ->");
                c = c.next;
            }
            if (c != null) {
                stringBuffer.append(c.val);
            }
            return stringBuffer.toString();
        }

    }


}


