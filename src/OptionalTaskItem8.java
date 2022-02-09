import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class OptionalTaskItem8 {

    private static List<String> getListOfStringLinesOutOfInputFile(String pathToInputFile) {
        List<String> listOfStringLines = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(pathToInputFile));
            while (scanner.hasNextLine()) {
                listOfStringLines.add(scanner.nextLine().replaceAll("[,.]", ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(listOfStringLines);
        return listOfStringLines;
    }

    private static Set<String> makeSetOfWordsOutOfListOfStringLines(List<String> listOfStringLines) {
        Set<String> setOfUniqueWords = new HashSet<>();
        listOfStringLines.forEach(stringLine -> {

            String[] wordsOfStringLine = stringLine.split(" ");
            for (String word : wordsOfStringLine) {
                setOfUniqueWords.add(word.toLowerCase());
            }
        });
        System.out.println(setOfUniqueWords);
        return setOfUniqueWords;
    }
    private static void fillTheOutputFileWithSetOfUniqueWords(String pathToOutputFile, Set<String> setOfUniqueWords){

        try (FileWriter fileWriter = new FileWriter(pathToOutputFile)) {
            for (String word : setOfUniqueWords) {

                fileWriter.write(word+"\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String pathToInputFile = "C:/data/OptionalTaskCollections/src/Item8/In/OptionalTaskItem8Input.txt";
        String pathToOutputFile = "C:/data/OptionalTaskCollections/src/Item8/Out/OptionalTaskItem8Output.txt";
        fillTheOutputFileWithSetOfUniqueWords(pathToOutputFile,
                makeSetOfWordsOutOfListOfStringLines(getListOfStringLinesOutOfInputFile(pathToInputFile)));

    }
}
