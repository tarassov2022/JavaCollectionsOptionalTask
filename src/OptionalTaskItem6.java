import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OptionalTaskItem6 {
    static List<String> poem = new ArrayList<>();


    private static void fillThePoemListWithPoemLines(String pathToInputFile) {
        try {
            Scanner scanner = new Scanner(new File(pathToInputFile));
            while (scanner.hasNextLine()) {
                poem.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void fillTheOutputFileWithPoemLines(String pathToOutputFile, List<String> poem){

            try (FileWriter fileWriter = new FileWriter(pathToOutputFile)) {
            for (String poemLine : poem) {

                fileWriter.write(poemLine+"\r\n");
           }
        } catch (IOException e) {
                e.printStackTrace();
            }
    }




    private static void printThePoem(List<String> poem) {
        for (String poemLine : poem) {
            System.out.println(poemLine);
        }
    }

    private static final Comparator<String> compareLinesByLength = (o1, o2) -> o1.length() - o2.length();

    public static void main(String[] args) {
        String pathToInputFile = "C:/data/OptionalTaskCollections/src/Item6/In/OptionalTaskItem6Input.txt";
        String pathToOutputFile = "C:/data/OptionalTaskCollections/src/Item6/Out/OptionalTaskItem6Output.txt";
        fillThePoemListWithPoemLines(pathToInputFile);
        System.out.println("The poem: ");
        printThePoem(poem);
        System.out.println("\nSorted out: ");
        poem.sort(compareLinesByLength);
        printThePoem(poem);
        fillTheOutputFileWithPoemLines(pathToOutputFile,poem);
    }
}
