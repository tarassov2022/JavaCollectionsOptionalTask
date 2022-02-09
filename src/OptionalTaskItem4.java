import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OptionalTaskItem4 {

    private static final String Poem =
                    "Now Delaney had a donkey that everyone admired,\n"+
                    "Temporary lazy and permanently tired\n"+
                    "A leg at every corner balancing his head,\n"+
                    "And a tail to let you know which end he wanted to be fed\n"+
                    "The day Delaney's donkey ran the half mile race.\n";

    private static void printPoem(List<String> poemLines) {
        for (String line : poemLines) {
            System.out.println(line);
        }
    }
    private static final Comparator<String> compareLineByLength = (o1, o2) -> o1.length() - o2.length();

    public static void main(String[] args) {
        List<String> poem = Arrays.asList(Poem.split("\n"));
        System.out.println("A Donkey Poem: ");
        printPoem(poem);
        poem.sort(compareLineByLength);
        System.out.println("\nSorted out: ");
        printPoem(poem);
    }
}
