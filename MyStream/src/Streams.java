import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by user on 08.12.2017.
 */
public class Streams<T> {
    private List<? extends T> list;

    public Streams(List<? extends T> collection) {
        this.list = collection;
    }

    public static <T> Streams<T> of(List<? extends T> collection) {
        return new Streams<>(collection);
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return new Streams<>(result);
    }

    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> key, Function<? super T, ? extends V> value) {
        Map<K, V> map = new HashMap<>();
        for (T t : list) {
            map.put(key.apply(t), value.apply(t));
        }
        return map;
    }

    public <R> Streams<R> transform(Function<? super T, ? extends R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return new Streams<>(result);
    }
}

