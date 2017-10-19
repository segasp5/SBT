import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {
        Class<?> toClass = to.getClass();
        Class<?> fromClass = from.getClass();


        Method[] fromMethods = fromClass.getDeclaredMethods();
        Method[] toMethods = toClass.getDeclaredMethods();

        Map<String, Method> getters = new HashMap<>();
        Map<String, Method> setters = new HashMap<>();


        for (Method method : fromMethods) {
            if (method.getName().startsWith("get")) {
                getters.put(method.getName(), method);
            }
        }
        for (Method method : toMethods) {
            if (method.getName().startsWith("set")) {
                setters.put(method.getName(), method);
            }
        }

        for (Map.Entry<String, Method> entry : getters.entrySet()) {
            String setMethodName = entry.getKey().replace("get", "set");
            if (setters.containsKey(setMethodName)) {
                Method set = setters.get(setMethodName);
                Class<?> setParameterType = set.getParameterTypes()[0];
                Method get = entry.getValue();
                Class<?> getReturnType = get.getReturnType();
                if (setParameterType.isAssignableFrom(getReturnType)) {
                    try {
                        get.invoke(from);
                    } catch (InvocationTargetException e) {
                        System.out.println(e.getMessage());
                    } catch (IllegalAccessException e) {
                        System.out.println(e.getMessage());
                    }

                    try {
                        set.invoke(to, get.invoke(from));
                    } catch (IllegalAccessException e) {
                        System.out.println(e.getMessage());
                    } catch (InvocationTargetException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
