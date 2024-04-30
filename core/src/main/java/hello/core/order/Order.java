package hello.core.order;

public class Order {
    //회원아이디
    private Long memberId;
    //성품명
    private String itemName;
    //상품 가격
    private int itemPrice;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    // 할인 가격
    private int discountPrice;

    public Order(Long memberId, String itemName, int itemPrice, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "itemPrice=" + itemPrice +
                ", itemName='" + itemName + '\'' +
                ", memberId=" + memberId +
                ", discountPrice=" + discountPrice +
                '}';
    }

    private int calculatePrice(){
        return itemPrice - discountPrice;
    }
}
