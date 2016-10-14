import java.util.*;

public class Registration {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lines = Integer.parseInt(in.nextLine());
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < lines; i++) {
            String name = in.nextLine();
            if(!map.containsKey(name)) {
                System.out.println("OK");
                map.put(name, 1);
            } else {
                System.out.println(name+map.get(name));
                map.put(name, map.get(name)+1);
            }
        }
    }
}
