import java.util.*;

public class Rank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] inNums = in.nextLine().split(" ");
        int lines = Integer.parseInt(inNums[0]), place = Integer.parseInt(inNums[1]);
        HashMap<String, Integer> map = new HashMap<>();
        int[][] teams = new int[lines][2];
        int[] problems = new int[lines];
        for(int i = 0; i < lines; i++) {
            String key = in.nextLine();
            int duplicate = (map.containsKey(key)) ? (map.get(key)+1) : 1;
            map.put(key, duplicate);
            teams[i][0] = Integer.parseInt(key.split(" ")[0]);
            teams[i][1] = Integer.parseInt(key.split(" ")[1]);
        }
        int temp;
        for (int i = 1; i < teams.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(teams[j][0] > teams[j-1][0]){
                    temp = teams[j][0];
                    teams[j][0] = teams[j-1][0];
                    teams[j-1][0] = temp;
                    temp = teams[j][1];
                    teams[j][1] = teams[j-1][1];
                    teams[j-1][1] = temp;
                }
            }
        }
        ArrayList<Integer> ties = new ArrayList<>();
        int num = -1, index = -1;
        for(int i = 0; i < teams.length; i++) {
            if(teams[i][0] != num) {
                ties.add(0);
                index++;
            } else {
                ties.set(index, ties.get(index)+1);
            }
        }
        for(int i = 0; i < ties.size(); i++) {
            for (int x = 1; x < ties.get(i); x++) {
                for(int j = x ; j > 0 ; j--){
                    if(teams[j][1] < teams[j-1][1]){
                        temp = teams[j][0];
                        teams[j][0] = teams[j-1][0];
                        teams[j-1][0] = temp;
                        temp = teams[j][1];
                        teams[j][1] = teams[j-1][1];
                        teams[j-1][1] = temp;
                    }
                }
            }
        }
        System.out.println(map.get((String)(teams[place-1][0]+" "+teams[place-1][1])));
    }
}
