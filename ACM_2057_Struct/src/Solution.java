import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            if(a == 1){
                int x = sc.nextInt();
                map.put(x, map.getOrDefault(x, 0) + 1);
            }else{
                int x = map.firstKey();
                System.out.println(x);
                int nom = map.get(x)-1;
                if(nom == 0){
                    map.remove(x);
                }else{
                    map.put(x, nom);
                }
            }
        }
    }
}
