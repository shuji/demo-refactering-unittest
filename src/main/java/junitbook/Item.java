package junitbook;

/**
 * 商品クラス.
 * @author shuji.w6e
 */
public class Item {

    String name;
    int price;
    int discount;

    public Item() {
        this("", 0, 0);
    }

    public int getDiscountPrice() {
        if (discount == 0) return price;
        return (price * (100 - discount)) / 100;
    }

    public Item(String name, int price, int discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + discount;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + price;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Item other = (Item) obj;
        if (discount != other.discount) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        if (price != other.price) return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Item[");
        str.append(name);
        str.append(",price=").append(price);
        str.append(",discount=").append(discount);
        str.append("]");
        return str.toString();
    }

}
