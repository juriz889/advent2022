package day7;

public class SpaceFreeUpForUpdateVisitor implements DirectoryItemVisitor<Folder> {
    private static final int SPACE_REQUIRED = 30000000;
    private static final int SPACE_AVAILABLE = 70000000;
    private final int currentSpaceOccupied;
    private final int spaceToFreeUp;
    private Folder smallestFolderToDelete;

    public SpaceFreeUpForUpdateVisitor(int currentSpaceOccupied) {
        this.currentSpaceOccupied = currentSpaceOccupied;
        spaceToFreeUp = SPACE_REQUIRED - (SPACE_AVAILABLE - currentSpaceOccupied);
    }

    @Override
    public Folder visit(Folder folder) {
        for (DirectoryItem file : folder.getFiles()) {
           file.accept(this);
        }
        if (folder.getSize() >= spaceToFreeUp) {
            if (smallestFolderToDelete != null && smallestFolderToDelete.getSize() > folder.getSize()) {
                smallestFolderToDelete = folder;
            } else if (smallestFolderToDelete == null) {
                smallestFolderToDelete = folder;
            }
        }
        return smallestFolderToDelete;
    }

    @Override
    public Folder visit(File file) {
        return null;
    }
}
