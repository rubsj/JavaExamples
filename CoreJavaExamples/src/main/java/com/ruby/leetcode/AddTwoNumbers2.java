package com.ruby.leetcode;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);

        ListNode ptr = result;
        int carryOver = 0;

        while(l1 != null || l2 != null || carryOver != 0){
              int val1 = l1!=null ? l1.val :0;
              int val2 = l2!=null ?l2.val :0;
            int sum = (val1 + val2 + carryOver) % 10;
            carryOver = (val1 + val2 + carryOver) / 10;
        
             l1 = l1!=null?l1.next:l1;
             l2 = l2!=null?l2.next:l2;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }
        return result.next;
    }

    //official solution on site
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

/*    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new AddTwoNumbers2().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }*/

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
       // ListNode l1 = stringToListNode("[2,4,3,6]");
      //  ListNode l1 = stringToListNode("[]");
        ListNode l1 = stringToListNode("[9,9]");
//        ListNode l2 = stringToListNode("[5,6,4]");
        ListNode l2 = stringToListNode("[1]");
 //       System.out.println(l1.toString());
   //     System.out.println(l2.toString());
        ListNode ret = new AddTwoNumbers2().addTwoNumbers(l1, l2);
        String out = listNodeToString(ret);

        System.out.print(out);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}



