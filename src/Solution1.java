import java.io.*;
import java.util.*;

public class Solution1 {
    //eg. "C:\\folder"
    private static String path;
    private static BufferedWriter output;
    private static Queue<FileObject> filesQueue;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        path = scanner.nextLine();
        Solution1 solution = new Solution1();

        try {
            try {
                output = new BufferedWriter(new FileWriter(path + "\\output.txt"));
                File[] allFiles = solution.getAllFilesFromDirectory();

                solution.saveFileObjectsToTheQueue(allFiles);
                solution.mergeFiles();

            } finally {
                output.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File[] getAllFilesFromDirectory() {
        File directory = new File(path);
        return directory.listFiles(((dir, name) -> name.startsWith("input") && name.endsWith(".txt")));
    }

    private void saveFileObjectsToTheQueue(File[] files) {
        filesQueue = new PriorityQueue<>(files.length, Comparator.comparingInt(o -> o.lineNumber));

        for (File file : files) {
            try {
                FileObject fileObject = new FileObject(file);
                if (fileObject.line != null) {
                    filesQueue.add(fileObject);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void mergeFiles() {
        while (filesQueue.size() > 0) {
            String line = filesQueue.peek().line;
            saveLineToOutput(line);

            //read next line in the file
            filesQueue.peek().readLine();
            checkIfTheLineIsLastInFile(line);
        }
    }

    private void saveLineToOutput(String line) {
        try {
            output.write(line);
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkIfTheLineIsLastInFile(String line) {

        if (line.equals(filesQueue.peek().line)) {
            //we got to the end of the file, so we remove it from our queue
            filesQueue.remove();
        } else {
            FileObject file = filesQueue.poll();
            filesQueue.add(file);
        }
    }

    private class FileObject {
        private int lineNumber;
        private String line;
        private Scanner scanner;

        public FileObject(File file) throws FileNotFoundException {
            scanner = new Scanner(file);
            readLine();
        }

        private void readLine() {
            if (scanner.hasNext()) {
                line = scanner.nextLine();
                getLineProperties();
            }
        }

        private void getLineProperties() {
            lineNumber = Integer.parseInt(line.substring(0, 1));
            line = line.substring(2);
        }
    }
}
