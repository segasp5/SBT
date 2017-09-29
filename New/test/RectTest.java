import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by user on 29.09.2017.
 */
class RectTest {
    @Test
    public void testArea(){
        double a = 2;
        double b = 5;
        Rect rect = new Rect(a, b);

        assertEquals(a * b * 3.14, rect.area(), 0.1);
    }

}