import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

//        1->4->5
//        1->3->4
//        2->6

        int numberOfListNodes = 3;

        ListNode[] lists = new ListNode[numberOfListNodes];

        //ListNode 1
        ListNode ln = new ListNode(5);
        ln.next = new ListNode(6);
        ln.next.next = new ListNode(10);

        lists[0] = ln;

        //ListNode 2
        ListNode ln0 = new ListNode(2);
        ln0.next = new ListNode(7);
        ln0.next.next = new ListNode(11);

        lists[1] = ln0;

        //ListNode 3
        ListNode ln1 = new ListNode(4);
        ln1.next = new ListNode(15);

        lists[2] = ln1;

        //
        ListNode head = mergeKLists(lists);

        while(head!=null) {
            System.out.print(head.val+ " ");
            head = head.next;
        }

    }


    public static ListNode mergeKLists(ListNode[] lists) {

        Comparator<ListNode> cmp;

        cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        };

        Queue<ListNode> q = new PriorityQueue<>(cmp);

        for (ListNode l : lists) {
            if (l != null) {
                q.add(l);
            }
        }

        ListNode head = new ListNode(0);
        ListNode point = head;

        while (!q.isEmpty()) {

            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;

            if (next != null) {
                q.add(next);
            }
        }

        return head.next;

    }


      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

}