package junitbook;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

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
public class ItemCart {

    final Map<Item, Integer> items = new LinkedHashMap<>();
    boolean cashOnDelivery = false;
    Coupon coupon = Coupon.NONE;

    public void add(Item newItem) {
        this.add(newItem, 1);
    }

    public void add(Item newItem, int value) {
        int newValue = getValue(newItem) + value;
        items.put(newItem, newValue);
    }

    public int getValue(Item item) {
        return items.containsKey(item) ? items.get(item) : 0;
    }

    public int getTotalAmount() {
        int total = 0;
        for (Entry<Item, Integer> entry : items.entrySet()) {
            Item item = entry.getKey();
            if (item.getDiscount() != 0) {
                total += item.getDiscountPrice() * entry.getValue();
            } else if (coupon == Coupon.NONE) {
                total += item.getPrice() * entry.getValue();
            } else {
                int p = item.getPrice() * (100 - coupon.rate) / 100;
                total += p * entry.getValue();
            }
        }
        if (total < 6000) total += 800;
        if (cashOnDelivery) total += 300;
        return total;
    }

    public boolean isCashOnDelivery() {
        return cashOnDelivery;
    }

    public void setCashOnDelivery(boolean cashOnDelivery) {
        this.cashOnDelivery = cashOnDelivery;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

}
