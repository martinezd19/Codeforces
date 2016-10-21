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
            int[] molexo = new int[4];
            int[] moleyo = new int[4];
            for(int x = 0; x < 4; x++) {
                String[] nums = in.nextLine().split(" ");
                molexo[x] = Integer.parseInt(nums[0]);
                moleyo[x] = Integer.parseInt(nums[1]);
                molex[x] = molexo[x];
                moley[x] = moleyo[x];
                homex[x] = Integer.parseInt(nums[2]);
                homey[x] = Integer.parseInt(nums[3]);
            }
            for(x1 = 0; x1 < 4; x1++) {
                molex[1] = molexo[1];
                moley[1] = moleyo[1];
                for(x2 = 0; x2 < 4; x2++) {
                    molex[2] = molexo[2];
                    moley[2] = moleyo[2];
                    for(x3 = 0; x3 < 4; x3++) {
                        molex[3] = molexo[3];
                        moley[3] = moleyo[3];
                        for(x4 = 0; x4 < 4; x4++) {
                            check();
                            int temp = (molex[3]-homex[3]);
                            molex[3] = homex[3]-(moley[3]-homey[3]);
                            moley[3] = homey[3]+temp;
                        }
                        check();
                        int temp = (molex[2]-homex[2]);
                        molex[2] = homex[2]-(moley[2]-homey[2]);
                        moley[2] = homey[2]+temp;
                    }
                    check();
                    int temp = (molex[1]-homex[1]);
                    molex[1] = homex[1]-(moley[1]-homey[1]);
                    moley[1] = homey[1]+temp;
                }
                check();
                int temp = (molex[0]-homex[0]);
                molex[0] = homex[0]-(moley[0]-homey[0]);
                moley[0] = homey[0]+temp;
            }
            System.out.println(min);
        }
    }
    
    static void check() {
        if((x1+x2+x3+x4)>=min && min != -1) {
            return;
        }
        for(int i = 0; i < 4; i++) {
            for(int x = i+1; x < 4; x++) {
                if(molex[i] == molex[x] && moley[i] == moley[x]) {
                    return;
                }
            }
        }
        long distance1 = (long)(Math.pow((molex[0]-molex[1]), 2)+Math.pow((moley[0]-moley[1]), 2));
        long distance2 = (long)(Math.pow((molex[0]-molex[2]), 2)+Math.pow((moley[0]-moley[2]), 2));
        long distance3 = (long)(Math.pow((molex[0]-molex[3]), 2)+Math.pow((moley[0]-moley[3]), 2));
        //System.out.println("D1: "+distance1+" D2: "+distance2+" D3: "+distance3+" min: "+min);
        int point1;
        int point2;
        int exclpoint;
        long distance;
        long adj;
        if(distance1 == distance2 && distance1 != distance3) {
            //System.out.println("TRUE1");
            //System.out.println(x1+" "+x2+" "+x3+" "+x4);
            point1 = 1;
            point2 = 2;
            exclpoint = 3;
            distance = distance3;
            adj = distance1;
            //System.out.println((long)(Math.pow((molex[point1]-molex[point2]), 2)+Math.pow((moley[point1]-moley[point2]), 2)));
        } else if(distance1 == distance3 && distance1 != distance2) {
            //System.out.println("TRUE2");
            //System.out.println(x1+" "+x2+" "+x3+" "+x4);
            point1 = 1;
            point2 = 3;
            exclpoint = 2;
            distance = distance2;
            adj = distance1;
            //System.out.println((long)(Math.pow((molex[point1]-molex[point2]), 2)+Math.pow((moley[point1]-moley[point2]), 2)));
        } else if(distance2 == distance3 && distance2 != distance1) {
            //System.out.println("TRUE3");
            //System.out.println(x1+" "+x2+" "+x3+" "+x4);
            point1 = 2;
            point2 = 3;
            exclpoint = 1;
            distance = distance1;
            adj = distance2;
            //System.out.println((long)(Math.pow((molex[point1]-molex[point2]), 2)+Math.pow((moley[point1]-moley[point2]), 2)));
        } else {
            return;
        }
        if((long)(Math.pow((molex[point1]-molex[point2]), 2)+Math.pow((moley[point1]-moley[point2]), 2)) == distance && 
           (long)(Math.pow((molex[exclpoint]-molex[point2]), 2)+Math.pow((moley[exclpoint]-moley[point2]), 2)) == adj &&
           (long)(Math.pow((molex[exclpoint]-molex[point1]), 2)+Math.pow((moley[exclpoint]-moley[point1]), 2)) == adj) {
            min = x1+x2+x3+x4;
        }
    }
}
