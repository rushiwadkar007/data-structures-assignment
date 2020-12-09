import java.util.Stack;
import java.util.Scanner;

public class PartA {

    private static Stack<String> history = new Stack<String>();

    public static Boolean isBrowsingHistoryEmpty() {
        return history.isEmpty();
    }

    public static String mostRecentlyVisitedSite() {
        return history.peek();
    }

    public static void addSiteToHistory(String url) {
        history.push(url);
    }

    public static void goBackInTime(int n) {
        for (int i = 0; i < n; i++) {
            if (!history.isEmpty())
                history.pop();
        }
    }

    public static void printBrowsingHistory() {
        if (history.isEmpty()) {
            System.out.print("Browsing history is empty");
        } else {
            int count = history.size();

            System.out.print("[");

            for (int i = 0; i < count; i++) {
                System.out.print(history.get(i));
                if (i < count - 1)
                    System.out.print(", ");
            }

            System.out.print("]");
        }
    }

    public static void main(String[] args) {
        System.out.println(isBrowsingHistoryEmpty()); // Checking if Browsing History is Empty
        addSiteToHistory("www.google.co.in"); // Navigating to Google
        addSiteToHistory("www.facebook.com"); // Navigating to Facebook
        addSiteToHistory("www.upgrad.com"); // Navigating to UpGrad
        System.out.println(isBrowsingHistoryEmpty()); // Checking if Browsing History is Empty
        System.out.println(mostRecentlyVisitedSite()); // Fetching most recently visited site (UpGrad)
        addSiteToHistory("www.youtube.com"); // Navigating to Youtube
        goBackInTime(2); // Going back by 2 sites
        addSiteToHistory("www.yahoo.com"); // Navigating to UpGrad platform site
        System.out.println(mostRecentlyVisitedSite()); // Fetching most recently visited site (UpGrad Learn Platform)
        printBrowsingHistory(); // Printing browsing history

    }

}

/**
 * Your code should have the following Output:
 * <p>
 * true
 * false
 * www.upgrad.com
 * www.yahoo.com
 * [www.google.co.in, www.facebook.com, www.yahoo.com]
 */

