package day7;

public class OnlyLessThan100000FileSizeVisitor implements DirectoryItemVisitor<Integer> {
    @Override
    public Integer visit(Folder folder) {
        int result = 0;
        for (DirectoryItem file : folder.getFiles()) {
            result += file.accept(this);
        }
        int size = folder.getSize();
        if (size <= 100000) {
            return size + result;
        }
        return result;
    }

    @Override
    public Integer visit(File file) {
        return 0;
    }
}
