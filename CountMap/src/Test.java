//Generics (hw 07)
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        CountMap<String> map = new CountMapImpl<>();

        map.add("qwerty");
        map.add("asd");
        map.add("qwerty");

        System.out.println(map.getCount("qwerty"));//2
        System.out.println(map.getCount("asd"));//1
        System.out.println(map.getCount("ZX"));//0

        Map<String, Integer> map2 = new HashMap<>();
        map.toMap(map2);
        for (String key : map2.keySet()) {
            System.out.println(key + " - " + map2.get(key));
        }

        System.out.println(map.size());//2

        System.out.println(map.remove("qwerty"));//2
        System.out.println(map.size());//1

        map.add("xyz");
        map.add("das Wort");

        Map<String, Integer> map3 = new HashMap<>();

        map.toMap(map3);
        System.out.println("map3:");
        for (String key : map3.keySet()) {
            System.out.println(key);
        }

        map.add("neues Wort");

        System.out.println("\nmap3 again:");
        for (String key : map3.keySet()) {
            System.out.println(key);
        }
    }
}