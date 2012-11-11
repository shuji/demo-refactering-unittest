package junitbook;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * 合計金額が6000円以上の場合、送料無料となる
 * 割引クーポン（10%）を利用する場合、消費税適用前の合計金額に適用する
 * 個々の商品に割引が設定されている商品は割引クーポンには適用されない
 * 送料無料は割引後の合計金額を基準とする
 * 送料は全国一律で800円となる
 * 代引きの場合、手数料が300円（税込み）発生する
 * 消費税は5%とする
 * @author shuji.w6e
 */
@Ignore("Cucumberによるテストに変更")
public class ItemCartTest {
    
    @Test
    public void 合計金額が3000円で代引きでない場合() throws Exception {
        Item item1 = new Item("Book", 2000, 0);
        Item item2 = new Item("Drink", 200, 0);
        ItemCart cart = new ItemCart();
        cart.add(item1);
        cart.add(item2, 5);
        int total = cart.getTotalAmount();
        assertThat(total, is(3800));
    }
    
    @Test
    public void 合計金額が6000円で代引きでない場合() throws Exception {
        Item item1 = new Item("Book", 2000, 0);
        Item item2 = new Item("Drink", 200, 0);
        ItemCart cart = new ItemCart();
        cart.add(item1, 2);
        cart.add(item2, 10);
        int total = cart.getTotalAmount();
        assertThat(total, is(6000));
    }

    @Test
    public void 合計金額が5999円で代引きでない場合() throws Exception {
        Item item1 = new Item("Book", 2000, 0);
        Item item2 = new Item("Drink", 200, 0);
        Item item3 = new Item("CD", 1999, 0);
        ItemCart cart = new ItemCart();
        cart.add(item1, 1);
        cart.add(item2, 10);
        cart.add(item3, 1);
        int total = cart.getTotalAmount();
        assertThat(total, is(6799));
    }
    
    @Test
    public void セール品が含まれ送料無料の場合() throws Exception {
        Item item1 = new Item("Book", 2000, 0);
        Item item2 = new Item("A", 5000, 10);
        ItemCart cart = new ItemCart();
        cart.add(item1, 1);
        cart.add(item2, 1);
        int total = cart.getTotalAmount();
        assertThat(total, is(6500));
    }
    
}
