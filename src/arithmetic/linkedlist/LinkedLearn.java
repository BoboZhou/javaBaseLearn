package arithmetic.linkedlist;

/**
 * 链表算法学习类
 */
public class LinkedLearn {
    public static void main(String[] args) throws Exception {
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
        String name = "**明朝那些**";
        System.out.println(nodeTwo);
        LinkedLearn linkedLearn = new LinkedLearn();
        Node x = linkedLearn.mergerTowSortLink(nodeOne.first, nodeTwo.first);
        System.out.println(x);
        System.out.println("*********************");
        Node nodeThe = new Node(1);

        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                for (int i1 = 0; i1 < 3; i1++) {
                    nodeThe.add(new Node(5));
                }
            }else {
                nodeThe.add(new Node(i));

            }

        }

        ListNode head = new ListNode(0);
        ListNode current = head;

        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                for (int i1 = 0; i1 < 3; i1++) {
                    current = current.add(new ListNode(5));

                }
            }else {
                current = current.add(new ListNode(i));


            }


        }
        System.out.println(head);
        System.out.println(removeAllRepetionNode(head));

    }

    /**
     * @return
     * @Description : 合并两个有序链表
     * @Param :
     * @Author bobo
     * @date: 2018/9/28
     */
     Node mergerTowSortLink(Node n1, Node n2) {
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
            } else {
                current.next = n2Next;
                current = n2Next;
                n2Next = n2Next.next;
            }

        }
        return n;


    }

    /**
     * @return
     * @Description : 删除链表所有重复元素
     * @Param :
     * @Author bobo
     * @date: 2018/10/25
     */
    public static   ListNode removeAllRepetionNode(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                Integer duplicate = head.next.val;
                while (head.next != null && head.next.val == duplicate)
                    head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
//        if (head == null || head.next == null) return head;
//        Node dummy = new Node(0);
//        dummy.next = head;
//        head = dummy;
//        while (head.next != null && head.next.next != null) {
//            if (head.next.val == head.next.next.val) {
//                int duplicate = head.next.val;
//                while (head.next != null && head.next.val == duplicate) {
//                    head.next = head.next.next;
//                }
//            } else {
//                head = head.next;
//            }
//        }
//        return dummy.next;





    }
     /**
       * @return
       * @Description : 翻转 链表
       * @Param :
       * @Author bobo
       * @date: 2018/10/25
       */

     Node remverNode(Node  head) {
        Node pre = null;
        Node cur = head;
        Node newHead = null;
        while (cur.next != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            if (next == null) newHead = cur;
            cur = next;
        }

        return newHead;
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

        public synchronized   String toString2() {
            Node c = first;
            if (null == c)
                first = next;
            StringBuffer stringBuffer = new StringBuffer();
            while (c != null && c.next != null) {
                stringBuffer.append(c.val).append(" ->");
                c = c.next;
            }
            if (c != null) {
                stringBuffer.append(c.val);
            }
            return stringBuffer.toString();
        }

    }

    public static class ListNode {
        /**
         * 当前值
         */
        int val;

        /**
         * 下一个节点
         */
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
        public ListNode add (ListNode node){
            next = node;
            return node;
        }

        @Override
        public String toString() {
            return val + " -> "
                     + next ;
        }
    }



}


