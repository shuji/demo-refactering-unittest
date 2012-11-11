package junitbook.step_definitions;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Map;

import junitbook.Coupon;
import junitbook.Item;
import junitbook.ItemCart;
import cucumber.api.DataTable;
import cucumber.api.java.ja.ならば;
import cucumber.api.java.ja.もし;
import cucumber.api.java.ja.前提;

public class ItemCartStepDefs {

    ItemCart sut = new ItemCart();
    private int actual;

    @前提("^以下の商品をカートに追加する:$")
    public void 以下の商品をカートに追加する(DataTable table) throws Throwable {
        for (Map<String, String> row : table.asMaps()) {
            Item item = new Item();
            item.setName(row.get("名前"));
            item.setPrice(Integer.valueOf(row.get("単価")));
            item.setDiscount(Integer.valueOf(row.get("割引")));
            sut.add(item, Integer.valueOf(row.get("数量")));
        }
    }

    @前提("^代引きを設定する$")
    public void 代引きを設定する() throws Throwable {
        sut.setCashOnDelivery(true);
    }
    
    @前提("^\"([^\"]*)\"%のクーポンを設定する$")
    public void _のクーポンを設定する(int rate) throws Throwable {
        sut.setCoupon(new Coupon(rate));
    }


    @もし("^合計価格を計算したならば$")
    public void 合計価格を計算したならば() throws Throwable {
        actual = sut.getTotalAmount();
    }

    @ならば("^(\\d+)であるべき$")
    public void であるべき(int expected) throws Throwable {
        assertThat(actual, is(expected));
    }
}
