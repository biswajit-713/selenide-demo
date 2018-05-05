package utility;

import java.util.Random;

public class TestUtilities {
    public static Integer getRandomNumberInRange(int startValue, int endValue){
        return startValue + new Random().nextInt(endValue - startValue + 1);
    }
}
