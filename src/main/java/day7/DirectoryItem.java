package day7;

public interface DirectoryItem {
    int getSize();

    String getName();

    <T> T accept(DirectoryItemVisitor<T> directoryItemVisitor);
}
