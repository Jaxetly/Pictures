package su.intercraft;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BitCountTest {

    @Test
    public void testBitCount() {
        int input = 0b0110010; // Пример входного числа
        int expectedOutput = Integer.bitCount(input); // Ожидаемый результат

        assertEquals(expectedOutput, 3); // Проверка, что функция возвращает корректное количество единиц в байте
    }
}