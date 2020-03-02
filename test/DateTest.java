import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTest {

    @Test
    public void constructorTest() {
        Date empty = new Date();
        assertEquals(empty, new Date(2020, 2, 25));

        Date randomDate = new Date(2025, 7, 13);
        assertEquals(randomDate, new Date(2025, 7, 13));
    }

    @Test
    public void nextDayTest() {

        Date empty = new Date();
        empty.nextDay();
        assertEquals(new Date(2020, 2, 26), empty);

        Date leap1 = new Date(2020, 2, 28);
        leap1.nextDay();
        assertEquals(new Date(2020, 2, 29), leap1);
        leap1.nextDay();
        assertEquals(new Date(2020, 3, 1), leap1);

        Date leap2 = new Date(2021, 2, 28);
        leap2.nextDay();
        assertEquals(new Date(2021, 3, 1), leap2);

        Date monthSwitch = new Date(2020, 5, 31);
        monthSwitch.nextDay();
        assertEquals(new Date(2020, 6, 1), monthSwitch);

        Date augustWith31 = new Date(2020, 8, 31);
        augustWith31.nextDay();
        assertEquals(new Date(2020, 9, 1), augustWith31);

        Date yearSwitch = new Date(2020, 12, 31);
        yearSwitch.nextDay();
        assertEquals(new Date(2021, 1, 1), yearSwitch);
    }
}
