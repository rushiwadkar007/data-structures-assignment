
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class SiteStats {
    private String url;
    private int numVisits;

    /**
     * Constructor for the SiteStats class
     *
     * @param url       String that represents an URL that the user has visited
     * @param numVisits An int that represents the number of times that the user has
     *                  visited the url
     */
    public SiteStats(String url, int numVisits) {
        this.url = url;
        this.numVisits = numVisits;
    }

    /**
     * This method returns the number of times that the user has visited the url.
     *
     * @return An int that represents the number of times that the user has visited
     *         the url
     */
    public int getNumVisits() {
        return this.numVisits;
    }

    /**
     * This method returns the url that we are currently tracking
     *
     * @return A String that represents the url that we are currently tracking
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * This method updates the number of times that we have visited the url
     *
     * @param an int that represents the number that we want to set numVisits to
     */
    public void setNumVisits(int updatedNumVisits) {
        this.numVisits = updatedNumVisits;
    }

    public String toString() {
        return this.url + " | " + this.numVisits;
    }
}

public class PartBSolution {

    private static Queue<SiteStats> sites = new LinkedList<SiteStats>();

    // Main method to list top n visited sites
    public static void listTopVisitedSites(Queue<SiteStats> sites, int n) {
        if (sites.isEmpty() || sites.size() < n)
            System.out.println("[]");
        else {
            sortQueue(sites);
            int i = 0;

            Iterator<SiteStats> iterator = sites.iterator();
            while (i < n && iterator.hasNext()) {
                System.out.println(iterator.next().toString());
                i++;
            }
        }
    }

    static void FrontToLast(Queue<SiteStats> q, int qsize) {
        if (qsize <= 0)
            return;

        q.add(q.peek());
        q.remove();
        FrontToLast(q, qsize - 1);
    }

    static void pushInQueue(Queue<SiteStats> q, SiteStats temp, int qsize) {
        if (q.isEmpty() || qsize == 0) {
            q.add(temp);
            return;
        } else if (temp.getNumVisits() > q.peek().getNumVisits()) {
            q.add(temp);
            FrontToLast(q, qsize);
        } else {
            q.add(q.peek());
            q.remove();
            pushInQueue(q, temp, qsize - 1);
        }
    }

    static void sortQueue(Queue<SiteStats> q) {
        if (q.isEmpty())
            return;
        SiteStats temp = q.peek();
        q.remove();
        sortQueue(q);
        pushInQueue(q, temp, q.size());
    }

    // Method to find the website in the queue and increment the visited count by 1,
    // adding new node in case website is not found
    public static void updateCount(String url) {
        boolean siteFound = false;

        for (SiteStats site : sites) {
            if (site.getUrl().equals(url)) {
                siteFound = true;
                site.setNumVisits(site.getNumVisits() + 1);
            }
        }

        if (siteFound == false) {
            sites.add(new SiteStats(url, 1));
        }
    }

    public static void main(String[] args) {
        String[] visitedSites = { "www.google.co.in", "www.google.co.in", "www.facebook.com", "www.upgrad.com",
                "www.google.co.in", "www.youtube.com", "www.facebook.com", "www.upgrad.com", "www.facebook.com",
                "www.google.co.in", "www.microsoft.com", "www.9gag.com", "www.netflix.com", "www.netflix.com",
                "www.9gag.com", "www.microsoft.com", "www.amazon.com", "www.amazon.com", "www.uber.com",
                "www.amazon.com", "www.microsoft.com", "www.upgrad.com" };

        if(visitedSites == null)		System.out.println("[]");
        else {
            for (String url : visitedSites) {
                updateCount(url);
            }

            listTopVisitedSites(sites, 5);

        }

    }

}
