package day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DistressSignal {

    public int getPackagesInOrder(String input) {
        String[] split = input.split("\n");
        DistressOrder distressOrder = new DistressOrder();
        int result = 0;
        int numberOfComparison = 1;
        for (int i = 0; i < split.length; i += 3) {
            String left = split[i];
            String right = split[i + 1];
            System.out.println(left);
            System.out.println(right);
            if (distressOrder.isInRightOrder(left, right)) {
                result += numberOfComparison;
            }
            numberOfComparison++;
        }
        return result;
    }

    public int solvePart2(String s) {
        String[] split = s.split("\n");
        DistressOrder distressOrder = new DistressOrder();
        List<Frame> allFrames = new ArrayList<>();
        for (int i = 0; i < split.length; i += 3) {
            String left = split[i];
            String right = split[i + 1];
            System.out.println(left);
            System.out.println(right);
            allFrames.add(distressOrder.getParsedResult(left));
            allFrames.add(distressOrder.getParsedResult(right));
        }
        Frame parsedResult = distressOrder.getParsedResult("[[2]]");
        allFrames.add(parsedResult);
        Frame parsedResult1 = distressOrder.getParsedResult("[[6]]");
        allFrames.add(parsedResult1);
        Collections.sort(allFrames);

        return (allFrames.indexOf(parsedResult) + 1) * (allFrames.indexOf(parsedResult1) + 1);

    }
}
