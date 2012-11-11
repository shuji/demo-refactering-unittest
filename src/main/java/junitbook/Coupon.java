package junitbook;

public class Coupon {
    public static final Coupon NONE = new Coupon(0);
    public final int rate;

    public Coupon(int rate) {
        this.rate = rate;
    }
}
