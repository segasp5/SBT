import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 27.10.2017.
 */
public class CountMapImpl<K> implements CountMap<K> {

    Map<K, Integer> m = new HashMap<>();

    @Override
    public void add(K o) {
        if (m.containsKey(o)) {
            m.replace(o, m.get(o) + 1);
        }else{
            m.put(o, 1);
        }
    }

    @Override
    public int getCount(K o) {
        if (m.containsKey(o)) {
            return m.get(o);
        } else {
            return 0;
        }
    }

    @Override
    public int remove(K o) {
        int number = m.get(o);
        m.remove(o);
        return number;
    }

    @Override
    public int size() {
        return m.size();
    }

    @Override
    public void addAll(CountMap<K> source) {
        Map<K, Integer> map = source.toMap();
        for (K key : map.keySet()) {
            if(m.containsKey(key)){
                m.replace(key, m.get(key) + map.get(key));
            }else{
                m.put(key, map.get(key));
            }
        }
    }

    @Override
    public Map toMap() {
        Map<K, Integer> map = new HashMap<>();
        for (K key : map.keySet()) {
            map.put(key, m.get(key));
        }
        return map;
    }

    @Override
    public void toMap(Map destination) {
        //destination = this.toMap();
        //destination = m;

        for (K key : m.keySet()) {
            destination.put(key, m.get(key));
        }
    }
}
