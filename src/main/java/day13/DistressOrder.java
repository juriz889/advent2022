package day13;

public class DistressOrder {
    public boolean isInRightOrder(String left, String right) {
        Frame parsedResult = getParsedResult(left);
        Frame parsedRight = getParsedResult(right, 1);
        System.out.println("Left parsed " + parsedResult);
        System.out.println("Right parsed " + parsedRight);
        return parsedResult.compareTo(parsedRight) < 0;
    }

    public Frame getParsedResult(String left) {
        return getParsedResult(left, 1);
    }

    private Frame getParsedResult(String left, int start) {
        int level = 0;
        Frame result = new Frame();
        char[] chars = left.toCharArray();
        String content = "";
        for (int i = start; i < chars.length; i++) {
            char currentChar = chars[i];
            if (currentChar == '[') {
                level++;
                if (level == 1) {
                    result.addChild(getParsedResult(left.substring(i + 1), 0));
                }
            } else if (currentChar == ']') {
                level--;
                if (level < 0) {
                    break;
                }
            } else {
                if (level == 0) {
                    if (currentChar != ',') {
                        content += currentChar;
                    } else {
                        if (!content.isEmpty()) {
                            Frame frame = new Frame();
                            frame.setContent(String.valueOf(content));
                            result.addChild(frame);
                            content = "";
                        }

                    }
                }
            }
        }
        if (!content.isEmpty()) {
            Frame frame = new Frame();
            frame.setContent(String.valueOf(content));
            result.addChild(frame);
        }
        result.setContent("");
        return result;
    }

}
