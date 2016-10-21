import java.util.*;

public class Marmot {
    static int min;
    static int[] molex;
    static int[] moley;
    static int[] homex;
    static int[] homey;
    static int x1;
    static int x2;
    static int x3;
    static int x4;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int regiments = Integer.parseInt(in.nextLine());
        for(int i = 0; i < regiments; i++) {
            min = -1;
            molex = new int[4];
            moley = new int[4];
            homex = new int[4];
            homey = new int[4];
            for(int x = 0; x < 4; x++) {
                String[] nums = in.nextLine().split(" ");
                molex[x] = Integer.parseInt(nums[0]);
                moley[x] = Integer.parseInt(nums[0]);
                homex[x] = Integer.parseInt(nums[0]);
                homey[x] = Integer.parseInt(nums[0]);
            }
            for(x1 = 0; x1 < 4; x1++) {
                for(x2 = 0; x2 < 4; x2++) {
                    for(x3 = 0; x3 < 4; x3++) {
                        for(x4 = 0; x4 < 4; x4++) {
                            check();
                            int temp = molex[3];
                            molex[3] = homex[3]-moley[3];
                            moley[3] = homey[3]+temp;
                        }
                        check();
                        int temp = molex[2];
                        molex[2] = homex[2]-moley[2];
                        moley[2] = homey[2]+temp;
                    }
                    check();
                    int temp = molex[1];
                    molex[1] = homex[1]-moley[1];
                    moley[1] = homey[1]+temp;
                }
                check();
                int temp = molex[0];
                molex[0] = homex[0]-moley[0];
                moley[0] = homey[0]+temp;
            }
            System.out.println(min);
        }
    }
    
    static void check() {
        if((x1+x2+x3+x4)>=min && min != -1) {
            return;
        }
        int distance1 = (int)(Math.pow((molex[0]-molex[1]), 2)+Math.pow((moley[0]-moley[1]), 2));
        int distance2 = (int)(Math.pow((molex[0]-molex[2]), 2)+Math.pow((moley[0]-moley[2]), 2));
        int distance3 = (int)(Math.pow((molex[0]-molex[3]), 2)+Math.pow((moley[0]-moley[3]), 2));
        int point1;
        int point2;
        int distance;
        if(distance1 == distance2) {
            point1 = 1;
            point2 = 2;
            distance = distance3;
        } else if(distance1 == distance3) {
            point1 = 1;
            point2 = 3;
            distance = distance2;
        } else if(distance2 == distance3) {
            point1 = 2;
            point2 = 3;
            distance = distance1;
        } else {
            return;
        }
        if((int)(Math.pow((molex[point1]-molex[point2]), 2)+Math.pow((moley[point1]-moley[point2]), 2)) == distance) {
            min = x1+x2+x3+x4;
        }
    }
}
