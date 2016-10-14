import java.util.*;

public class Lecture {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] inNums = in.nextLine().split(" ");
        int lines = Integer.parseInt(inNums[1]);
        HashMap<String, String> language = new HashMap<>();
        for(int i = 0; i < lines; i++) {
            String[] wordsInLine = in.nextLine().split(" ");
            language.put(wordsInLine[0], wordsInLine[1]);
        }
        String[] lecture = in.nextLine().split(" ");
        for(int i = 0; i < lecture.length; i++) {
            String output = (language.get(lecture[i]).length() < lecture[i].length()) ? language.get(lecture[i]) : lecture[i];
            System.out.print(output+" ");
        }
    }
}
