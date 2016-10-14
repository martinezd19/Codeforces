import java.util.*;

public class Marmot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int regiments = Integer.parseInt(in.nextLine());
        for(int i = 0; i < regiments; i++) {
            int[] molex = new int[4];
            int[] moley = new int[4];
            int[] homex = new int[4];
            int[] homey = new int[4];
            for(int x = 0; x < 4; x++) {
                String[] nums = in.nextLine().split(" ");
                molex[x] = Integer.parseInt(nums[0]);
                moley[x] = Integer.parseInt(nums[0]);
                homex[x] = Integer.parseInt(nums[0]);
                homey[x] = Integer.parseInt(nums[0]);
            }
            for(int x1 = 0; x1 < 4; x1++) {
                for(int x2 = 0; x2 < 4; x2++) {
                    for(int x3 = 0; x3 < 4; x3++) {
                        for(int x4 = 0; x4 < 4; x4++) {
                            
                        }
                    }
                }
            }
        }
    }
}
