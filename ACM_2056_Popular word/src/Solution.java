import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(new BufferedReader(new FileReader("D://User//Desktop//input.txt")));
            Map<String, Integer> map = new TreeMap<>();
            String[] str;
            int max = 0;

            while (sc.hasNext()) {
                String s = sc.next().toLowerCase();
                //System.out.println(s);
                str = s.split("\\s | \n");

                for (int i = 0; i < str.length; i++) {
                    if (map.containsKey(str[i])) {
                        int temp = map.get(str[i]);
                        temp++;
                        if (max < temp) max = temp;
                        map.replace(str[i], temp);
                    } else {
                        map.put(str[i], 1);
                    }
                }
            }

            for (String key : map.keySet()) {
                if (map.get(key) == max) System.out.println(key);
            }
        } catch (Exception e) {
        }
    }
}