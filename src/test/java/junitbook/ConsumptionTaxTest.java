package junitbook;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ConsumptionTaxTest {

    @Test
    public void 消費税が5パーセントのときapply_100は105を返す() throws Exception {
        ConsumptionTax sut = new ConsumptionTax(5);
        assertThat(sut.apply(100), is(105));
    }

    @Test
    public void 消費税が5パーセントのときapply_3000は3150を返す() throws Exception {
        ConsumptionTax sut = new ConsumptionTax(5);
        assertThat(sut.apply(3000), is(3150));
    }

    @Test
    public void 消費税が10パーセントのときapply_50は55を返す() throws Exception {
        ConsumptionTax sut = new ConsumptionTax(5);
        assertThat(sut.apply(100), is(105));
    }
    
}