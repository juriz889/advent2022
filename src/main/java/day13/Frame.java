package day13;

import java.util.ArrayList;
import java.util.List;

public class Frame implements Comparable<Frame> {
    private String content;
    private final List<Frame> children = new ArrayList<>();

    public void setContent(String content) {
        this.content = content;
    }

    public void addChild(Frame frame) {
        children.add(frame);
    }

    private Frame toList() {
        if (!this.content.isEmpty()) {
            Frame e = new Frame();
            Frame child = new Frame();
            child.setContent(this.content);
            e.addChild(child);
            return e;
        } else {
            return this;
        }
    }

    @Override
    public String toString() {
        return "Frame{" +
                "content='" + content + '\'' +
                ", children=" + children +
                '}';
    }

    @Override
    public int compareTo(Frame o) {
        if (!this.content.isEmpty() && !o.content.isEmpty()) {
            Integer myNum = Integer.parseInt(content);
            Integer otherNum;
            otherNum = Integer.parseInt(o.content);
            return myNum.compareTo(otherNum);

        } else {
            Frame myListed = this.toList();
            Frame otherListed = o.toList();
            for (int i = 0; i < myListed.children.size(); i++) {
                Frame myChild = myListed.children.get(i);
                Frame otherChild;

                if (otherListed.children.size() <= i) {
                    return 1;
                }
                otherChild = otherListed.children.get(i);

                if (myChild.compareTo(otherChild) != 0) {
                    return myChild.compareTo(otherChild);
                }
            }
            if (myListed.children.size() < otherListed.children.size()) {
                return -1;
            }
        }
        return 0;
    }
}
