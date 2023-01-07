package day16;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pipes {
    private final Pattern PATTERN = Pattern.compile("Valve (\\w+) has flow rate=(\\d+); tunnels? leads? to (valves|valve) (.*)");

    public int solve(String input) {
        String[] split = input.split("\n");
        List<Pipe> pipes = new ArrayList<>();
        Map<String, Pipe> pipeNameVsPipe = new HashMap<>();
        for (String s : split) {
            Matcher matcher = PATTERN.matcher(s);
            matcher.find();
            String pipeName = matcher.group(1);
            Integer rate = Integer.parseInt(matcher.group(2));
            String[] follows = matcher.group(4).split(",");
            Pipe pipe = new Pipe(pipeName, rate, List.of(follows));
            pipeNameVsPipe.put(pipeName, pipe);
            pipes.add(pipe);
        }
        System.out.println(pipes);
        for (String pipe : pipeNameVsPipe.keySet()) {
            Pipe currentPipe1 = pipeNameVsPipe.get(pipe);
            Stack<ShortestPath> toFollow = new Stack<>();
            toFollow.add(new ShortestPath(currentPipe1, 1));
            Map<String, Integer> pipeVsStepToReach = new HashMap<>();
            Set<Pipe> visited = new HashSet<>();
            visited.add(currentPipe1);
            while (!toFollow.isEmpty()) {
                ShortestPath shortestPath = toFollow.pop();
                Integer integer = pipeVsStepToReach.get(shortestPath.getCurrentPipe().getName());
                if ((integer == null || integer > shortestPath.getSteps())) {
                    pipeVsStepToReach.put(shortestPath.getCurrentPipe().getName(), shortestPath.getSteps());
                }

                for (String follow : shortestPath.getCurrentPipe().getFollows()) {
                    if (!pipeVsStepToReach.containsKey(follow) || pipeVsStepToReach.get(follow) >= shortestPath.getSteps() + 1) {
                        toFollow.add(new ShortestPath(pipeNameVsPipe.get(follow), shortestPath.getSteps() + 1));
                    }
                }
            }
            currentPipe1.setShortestPath(pipeVsStepToReach);
            System.out.println(currentPipe1);
        }
        return extracted(pipeNameVsPipe, pipeNameVsPipe.get("AA"));
    }

    private int extracted(Map<String, Pipe> pipeNameVsPipe, Pipe startPipe) {
        Stack<Path> toFollow = new Stack<>();
        int highestRelease = 0;
        Path bestPath = null;
        toFollow.add(new Path(startPipe, 0, new LinkedList<>(), 0, 0));
        while (!toFollow.isEmpty()) {
            Path currentPath = toFollow.pop();
            Pipe currentPipe = currentPath.getCurrentPipe();
            int remaining = 30 - currentPath.getSteps();
            if (remaining > 0) {
                int release = currentPath.getRelease() + (currentPath.getStepRelease() * remaining);
                if (release >= highestRelease) {
                    highestRelease = release;
                    bestPath = currentPath;
                }
            }
            if (currentPath.getSteps() > 30) {
                continue;
            }
            if (currentPath.getRelease() >= highestRelease) {
                highestRelease = currentPath.getRelease();
                bestPath = currentPath;
            }
            for (Map.Entry<String, Integer> entry : currentPipe.getShortestPath().entrySet()) {
                Pipe currentPie = pipeNameVsPipe.get(entry.getKey());
                if (currentPie.getRate() == 0) {
                    continue;
                }
                if (!currentPath.getOpenPipes().contains(entry.getKey())) {
                    List<String> open = new LinkedList<>(currentPath.getOpenPipes());
                    String key = entry.getKey();
                    open.add(key);
                    int sum = pipeNameVsPipe.values().stream().filter(e -> currentPath.getOpenPipes().contains(e.getName())).map(Pipe::getRate).mapToInt(Integer::intValue).sum();

                    toFollow.add(new Path(currentPie, currentPath.getSteps() + entry.getValue(), open, currentPath.getRelease() + sum * entry.getValue(), sum + currentPie.getRate()));
                }
            }
        }
        System.out.println(bestPath);
        return highestRelease;
    }

    private boolean isHasAnyPipeToOpen(Map<String, Pipe> pipeNameVsPipe, Path currentPath, String trim) {
        Set<String> checked = new HashSet<>();
        Queue<String> toCheck = new LinkedList<>();
        toCheck.add(trim);
        while (!toCheck.isEmpty()) {
            String peek = toCheck.poll();
            if (!checked.add(peek)) {
                continue;
            }
            if (!currentPath.getOpenPipes().contains(peek)) {
                return false;
            }
            Pipe pipe = pipeNameVsPipe.get(peek);
            for (String follow : pipe.getFollows()) {
                toCheck.add(follow);
            }
        }
        return true;
    }

 /*   private double getBestScoreFormPipe(Map<String, Pipe> pipeNameVsPipe, Pipe pipe, double highestScore, double distance, Set<String> visited) {
        if (!visited.add(pipe.getName())) {
            return highestScore;
        }
        if (!pipe.isOpen() && (pipe.getRate() / (distance)) >= highestScore) {
            highestScore = pipe.getRate() / (distance);
        }
        for (String follow : pipe.getFollows()) {
            Pipe followed = pipeNameVsPipe.get(follow.trim());
            highestScore = getBestScoreFormPipe(pipeNameVsPipe, followed, highestScore, distance + 1, visited);
        }
        return highestScore;
    }

    private Supplier<Pipe> openSupplier(Pipe pipe) {
        return () -> {
            pipe.setOpen(true);
            System.out.println("Opening pipe " + pipe.getName());
            return pipe;
        };
    }

    private Supplier<Pipe> visitSupplier(Pipe pipe) {
        return () -> {
            System.out.println("Moving to  pipe " + pipe.getName());
            return pipe;
        };
    } */
}
