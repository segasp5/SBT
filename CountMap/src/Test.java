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
    }
}
