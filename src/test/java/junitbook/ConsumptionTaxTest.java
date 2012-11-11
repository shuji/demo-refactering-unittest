package junitbook;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class ConsumptionTaxTest {

    @DataPoints
    public static Fixture[] FIXTURES = new Fixture[] {
            new Fixture(5, 100, 105), 
            new Fixture(5, 3000, 3150),
            new Fixture(10, 50, 55), 
            new Fixture(5, 50, 52),
            new Fixture(3, 50, 51), };

    @Theory
    public void applyのテスト(Fixture f) throws Exception {
        ConsumptionTax sut = new ConsumptionTax(f.rate);
        assertThat(sut.apply(f.amount), is(f.expected));
    }

    static class Fixture {
        int rate;
        int amount;
        int expected;

        public Fixture(int rate, int amount, int expected) {
            this.rate = rate;
            this.amount = amount;
            this.expected = expected;
        }
    }

}