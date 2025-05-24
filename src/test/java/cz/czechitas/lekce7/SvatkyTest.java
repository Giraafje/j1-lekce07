package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        Svatky svatky = new Svatky();
        // name is in the list
        assertTrue(svatky.jeVSeznamu("Jana"));
        // name is not in the list
        assertFalse(svatky.jeVSeznamu("Lenka"));
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        Svatky svatky = new Svatky();
        // expecting 37 names
        assertEquals(37, svatky.getPocetJmen());
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        Svatky svatky = new Svatky();
        assertEquals(37, svatky.getSeznamJmen().size());
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Lenka", 21, 2);
        assertTrue(svatky.jeVSeznamu("Lenka"));
        assertEquals(MonthDay.of(2, 21), svatky.vratKdyMaSvatek("Lenka"));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Lenka", 21, Month.FEBRUARY);
        assertTrue(svatky.jeVSeznamu("Lenka"));
        assertEquals(MonthDay.of(2, 21), svatky.vratKdyMaSvatek("Lenka"));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void prridatSvatekMonthDay() {
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Lenka", MonthDay.of(Month.FEBRUARY, 21));
        assertTrue(svatky.jeVSeznamu("Lenka"));
        assertEquals(MonthDay.of(2, 21), svatky.vratKdyMaSvatek("Lenka"));
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        Svatky svatky = new Svatky();
        int originalCount = svatky.getPocetJmen();
        svatky.smazSvatek("Ctibor");
        // expecting one item less
        assertEquals(originalCount - 1, svatky.getPocetJmen());
    }
}
