import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(asList(5, 3, 7, 6, 1, 4, 2, 3));
        System.out.println(CollectionUtils.range(list, 3, 5));

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 == o2) return 0;
                return (o1 < o2) ? -1 : 1;
            }
        };

        System.out.println(CollectionUtils.range(list, 3, 5, comp));
    }
}
