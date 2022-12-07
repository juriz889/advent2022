package day7;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirectoryParser {
    private static final Pattern CHANGE_DIRECTORY = Pattern.compile("\\$ cd (\\S+)");
    private static final Pattern FILE_NAME_WITH_SIZE = Pattern.compile("(\\d+) (\\S+)");

    public Folder parse(String input) {
        String[] split = input.split("\n");
        Matcher matcher = CHANGE_DIRECTORY.matcher(split[0]);
        matcher.find();
        String rootFolderName = matcher.group(1);
        Folder currentFolder = new Folder(rootFolderName, null);
        Folder rootFolder = currentFolder;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            matcher = CHANGE_DIRECTORY.matcher(s);
            if (matcher.find()) {
                String currentDirectory = matcher.group(1).trim();
                if (currentDirectory.equals("..")) {
                    currentFolder = currentFolder.getParent();
                } else {
                    Optional<DirectoryItem> first = currentFolder.getFiles().stream().filter(e -> e instanceof Folder).filter(e -> e.getName().equals(currentDirectory)).findFirst();
                    if (first.isPresent()) {
                        currentFolder = (Folder) first.get();
                    }
                }

            } else if ("$ ls".equals(s)) {
                for (int i1 = i + 1; i1 < split.length; i1++) {
                    String outputFromLS = split[i1];
                    if (outputFromLS.startsWith("$")) {
                        break;
                    }
                    if (outputFromLS.startsWith("dir")) {
                        Folder childFolder = new Folder(outputFromLS.split("dir")[1].trim(), currentFolder);
                        currentFolder.addContent(childFolder);
                    }
                    matcher = FILE_NAME_WITH_SIZE.matcher(outputFromLS);
                    if (matcher.find()) {
                        int fileSize = Integer.parseInt(matcher.group(1));
                        String fileName = matcher.group(2);
                        currentFolder.addContent(new File(fileName, fileSize));
                    }
                }
            }
        }
        return rootFolder;
    }
}
