package sumin.game.engine.math;

import java.util.Random;

/**
 * Created by andrey on 27.11.2017.
 */

public class Rnd {
    private static final Random random = new Random();

    /**
     * Сгенерировать случайное число
     * @param min минимальное значение случайного числа
     * @param max максимальное значение случайного числа
     * @return результат
     */
    public static float nextFloat(float min, float max) {
        return random.nextFloat() * (max - min) + min;
    }
}
