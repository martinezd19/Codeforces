import java.util.*;

public class olympiad {
    static int[] problems;
    static int numValid = 0;
    static int minD;
    static int maxD;
    static int diffD;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] params = in.nextLine().split(" ");
        int numProblems = Integer.parseInt(params[0]);
        minD = Integer.parseInt(params[1]);
        maxD = Integer.parseInt(params[2]);
        diffD = Integer.parseInt(params[3]);
        String[] problemsString = in.nextLine().split(" ");
        problems = new int[problemsString.length];
        for(int i = 0; i < problemsString.length; i++) {
            problems[i] = Integer.parseInt(problemsString[i]);
        }
        combinations();
        System.out.println(numValid);
    }
    
    static void combinations() {
        ArrayList<ArrayList<Integer>> results = new ArrayList();
        for(int i = 0; i < problems.length; i++) {
            int resultsLength = results.size();
            for(int j = 0; j < resultsLength; j++) {
                ArrayList<Integer> v = (ArrayList<Integer>)results.get(j).clone();
                v.add(problems[i]);
                results.add(v);
            }
            ArrayList<Integer> v = new ArrayList<>();
            v.add(problems[i]);
            results.add(v);
        }
        for(ArrayList<Integer> x : results) {
            check(x);
        }
    }
    
    static void check(ArrayList<Integer> nums) {
        int min = -1;
        for(int i : nums) {
            if(min == -1 || i<min) {
                min = i;
            }
        }
        int max = -1;
        for(int i : nums) {
            if(i>max) {
                max = i;
            }
        }
        if(!((max-min)>=diffD)) {
            return;
        }
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum >= minD && sum <= maxD) {
            numValid++;
        }
    }
}
