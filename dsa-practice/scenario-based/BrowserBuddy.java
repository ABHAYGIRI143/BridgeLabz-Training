

import java.util.Stack;


class PageNode {
    String url;
    PageNode prev;
    PageNode next;

    PageNode(String url) {
        this.url = url;
    }
}


class BrowserTab {

    private PageNode current;

    // Visit new page
    public void visit(String url) {
        PageNode newPage = new PageNode(url);

        if (current != null) {
            current.next = newPage;
            newPage.prev = current;
        }

        current = newPage;
        System.out.println("Visited: " + url);
    }

    // Go back
    public void back() {
        if (current == null || current.prev == null) {
            System.out.println("No previous page");
            return;
        }

        current = current.prev;
        System.out.println("Back to: " + current.url);
    }

    // Go forward
    public void forward() {
        if (current == null || current.next == null) {
            System.out.println("No forward page");
            return;
        }

        current = current.next;
        System.out.println("Forward to: " + current.url);
    }

    public String getCurrentPage() {
        return current != null ? current.url : "Empty Tab";
    }
}


class BrowserManager {

    private BrowserTab activeTab;
    private Stack<BrowserTab> closedTabs = new Stack<>();

    // Open new tab
    public void openTab() {
        activeTab = new BrowserTab();
        System.out.println("New tab opened");
    }

    // Close current tab
    public void closeTab() {
        if (activeTab == null) {
            System.out.println("No active tab to close");
            return;
        }

        closedTabs.push(activeTab);
        activeTab = null;
        System.out.println("Tab closed");
    }

    // Restore last closed tab
    public void restoreTab() {
        if (closedTabs.isEmpty()) {
            System.out.println("No closed tabs to restore");
            return;
        }

        activeTab = closedTabs.pop();
        System.out.println("Tab restored");
    }

    public BrowserTab getActiveTab() {
        return activeTab;
    }
}


public class BrowserBuddy {

    public static void main(String[] args) {

        BrowserManager manager = new BrowserManager();

        manager.openTab();
        BrowserTab tab = manager.getActiveTab();

        tab.visit("google.com");
        tab.visit("github.com");
        tab.visit("stackoverflow.com");

        tab.back();
        tab.back();
        tab.forward();

        manager.closeTab();
        manager.restoreTab();

        System.out.println("Current Page: " + tab.getCurrentPage());
    }
}
