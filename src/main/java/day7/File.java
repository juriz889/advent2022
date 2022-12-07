package day7;

public final class File implements DirectoryItem {
    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public <T> T accept(DirectoryItemVisitor<T> directoryItemVisitor) {
        return directoryItemVisitor.visit(this);
    }
}
