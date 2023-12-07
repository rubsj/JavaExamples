package com.ruby.leetcode;

import lombok.ToString;

/**
 * You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.
 * <p>
 * Implement the BrowserHistory class:
 * <p>
 * BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
 * void visit(string url) Visits url from the current page. It clears up all the forward history.
 * string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
 * string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.
 * <p>
 * Example:
 * <p>
 * Input:
 * ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
 * [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
 * Output:
 * [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]
 * <p>
 * Explanation:
 * BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
 * browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
 * browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
 * browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
 * browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
 * browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
 * browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
 * browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
 * browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
 * browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
 * browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= homepage.length <= 20
 * 1 <= url.length <= 20
 * 1 <= steps <= 100
 * homepage and url consist of  '.' or lower case English letters.
 * At most 5000 calls will be made to visit, back, and forward.
 */
@ToString
public class BrowserHistory {
    BrowserNode head;
    BrowserNode tail;

    BrowserNode display;

    public BrowserHistory(String homepage) {
        this.head = new BrowserNode("");
        this.tail = new BrowserNode("");
        BrowserNode home = new BrowserNode(homepage);
        home.next = tail;
        home.prev = this.head;
        this.head.next = home;
        this.tail.prev = home;
        this.display = home;
    }

    public void visit(String url) {
        BrowserNode node = new BrowserNode(url);
        node.next = this.tail;
        node.prev = this.display;
        this.display.next = node;
        this.tail.prev = node;
        this.display = node;
        System.out.printf("currently displayed node is %s %n" , this.display);

    }

    public String back(int steps) {
        BrowserNode curr = this.display;
        int move = steps;
        while (curr.prev != this.head &&  move > 0) {
            curr = curr.prev;
            move = move - 1;
        }
        System.out.printf("node found for the back steps %d is %s %n ", steps, curr);
        this.display = curr;
        return curr.url;
    }

    public String forward(int steps) {
        BrowserNode curr = this.display;
        int move = steps;
        while (curr.next != this.tail && move > 0) {
            curr = curr.next;
            move = move - 1;
        }
        System.out.printf("node found for the forward steps %d is %s %n ", steps, curr);
        this.display = curr;
        return curr.url;
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        System.out.printf("current browser history is %s %n", browserHistory);
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
        browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"

    }
}

class BrowserNode {
    String url;
    BrowserNode next;
    BrowserNode prev;

    public BrowserNode(String url) {
        this.url = url;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return String.format("Node is %s" , this.url);
    }
}
