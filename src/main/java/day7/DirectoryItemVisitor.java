package day7;

public interface DirectoryItemVisitor<T> {
    T visit(Folder folder);

    T visit(File file);
}
