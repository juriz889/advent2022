package day7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Folder implements DirectoryItem {
    private final String name;
    private final List<DirectoryItem> files = new ArrayList<>();
    private final Folder parent;

    public Folder(String name, Folder parent) {
        this.name = name;
        this.parent = parent;
    }

    public Folder getParent() {
        return parent;
    }

    public void addContent(DirectoryItem directoryItem) {
        this.files.add(directoryItem);
    }

    @Override
    public int getSize() {
        return files.stream().mapToInt(DirectoryItem::getSize).sum();
    }

    @Override
    public String getName() {
        return name;
    }

    public List<DirectoryItem> getFiles() {
        return files;
    }

    @Override
    public <T> T accept(DirectoryItemVisitor<T> directoryItemVisitor) {
        return directoryItemVisitor.visit(this);
    }
}
