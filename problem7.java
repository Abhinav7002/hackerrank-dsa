import java.util.*;

class BrowserHistory {
    private List<String> history;
    private int currentIndex;
    private int lastIndex;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        currentIndex = 0;
        lastIndex = 0;
    }

    public void visit(String url) {
        currentIndex++;
        if (history.size() > currentIndex) {
            history.set(currentIndex, url);
        } else {
            history.add(url);
        }
        lastIndex = currentIndex;
    }

    public String back(int steps) {
        currentIndex = Math.max(0, currentIndex - steps);
        return history.get(currentIndex);
    }

    public String forward(int steps) {
        currentIndex = Math.min(lastIndex, currentIndex + steps);
        return history.get(currentIndex);
    }
}
