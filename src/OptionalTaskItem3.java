import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OptionalTaskItem3 {
    static List<File> internalDirectoriesAndFiles = new ArrayList<>();

    private static List<File> getInternalDirectoriesAndFies(File externalDirectory)  {
        File[] externalDirectoryContent = externalDirectory.listFiles();
        try {


            for (File file : externalDirectoryContent) {
                if (file.isDirectory()) {
                    internalDirectoriesAndFiles.add(file);
                    getInternalDirectoriesAndFies(file);
                } else {
                    internalDirectoriesAndFiles.add(file);
                }
            }
        } catch (NullPointerException e){
            System.out.println("No such directory: "+externalDirectory+"\r\n"+e);
        }
        return internalDirectoriesAndFiles;
        }



    private static void printAndWriteIntoFileExternalDirectoryContents(String pathToExternalDirectory, String pathToOutputFile) {
        File externalDirectory = new File(pathToExternalDirectory);
        Path directoryTree = Paths.get(pathToExternalDirectory);
        internalDirectoriesAndFiles = getInternalDirectoriesAndFies(externalDirectory);
        try {
            FileWriter fileWriter = new FileWriter(pathToOutputFile);
            BufferedWriter bufferedWriter =  new BufferedWriter(fileWriter);
            System.out.printf("%nThe file tree for directory: %s%n", directoryTree.toAbsolutePath());
            bufferedWriter.write("The file tree for directory: " + directoryTree.toAbsolutePath());
            bufferedWriter.newLine();
            for (File element : internalDirectoriesAndFiles) {
                System.out.println(element);
                bufferedWriter.write(String.valueOf(element));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String pathToExternalDirectory = "C:/data/OptionalTaskCollections/src/Item3/In";
        String pathToOutputFile = "C:/data/OptionalTaskCollections/src/Item3/Out/OptionalTaskItemThreeOutput.txt";
        printAndWriteIntoFileExternalDirectoryContents(pathToExternalDirectory, pathToOutputFile);
    }
}
