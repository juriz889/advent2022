package day16;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pipe {
    private final String name;
    private final int rate;
    private final List<String> follows;

    private Map<String, Integer> shortestPath;

    public Pipe(String name, int rate, List<String> follows) {
        this.name = name;
        this.rate = rate;
        this.follows = follows.stream().map(String::trim).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public int getRate() {
        return rate;
    }


    public List<String> getFollows() {
        return follows;
    }

    public void setShortestPath(Map<String, Integer> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Map<String, Integer> getShortestPath() {
        return shortestPath;
    }

    @Override
    public String toString() {
        return "Pipe{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", follows=" + follows +
                ", shortestPath=" + shortestPath +
                '}';
    }
}
