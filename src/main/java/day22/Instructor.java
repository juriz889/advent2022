package day22;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Instructor {
    private final List<String> instructionsList;
    private final static Pattern PATTERN = Pattern.compile("\\d+|[LR]?");

    public Instructor(String instuctions) {
        Matcher matcher = PATTERN.matcher(instuctions);
        List<MatchResult> collect = matcher.results().toList();
        instructionsList = collect.stream().map(m -> instuctions.substring(m.start(), m.end())).filter(s -> !s.isEmpty()).collect(Collectors.toList());
    }

    public List<String> getInstructions() {
        return instructionsList;
    }
}
