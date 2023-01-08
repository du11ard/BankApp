import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatingTest {

    @Test
    void fiveYearsInMonth() {
        Calculating calculating = new Calculating();
        assertEquals(60,calculating.yearInMonth(5));
    }

    @Test
    void oneSixSixInMonth(){
        Calculating calculating = new Calculating();
        assertEquals(1992,calculating.yearInMonth(166));
    }

    @Test
    void calculateMonthlyInterest() {
    }

    @Test
    void calculateMonthlyPayment() {
    }

    @Test
    void oneToOne_pow() {
        Calculating calculating = new Calculating();
        assertEquals(1, calculating.pow(1,1));
    }

    @Test
    void doubleToOne_pow() {
        Calculating calculating = new Calculating();
        assertEquals(9.1, calculating.pow(9.1,1));
    }

    @Test
    void doubleToInt_pow() {
        Calculating calculating = new Calculating();
        assertEquals(490770721.273, calculating.pow(12.2,8), 0.0001);
    }
}