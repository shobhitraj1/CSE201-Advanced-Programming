package org.IIITD;

// abstract class Discounts serves as blueprint for creating objects of type Discount
public abstract class Discounts {
    private String discountCategory;
    private int discountPercentage;
    private String discountCode;
    private int discountID;

    public Discounts(String discountCategory, int discountPercentage, String discountCode, int discountID) {
        this.discountCategory = discountCategory;
        this.discountPercentage = discountPercentage;
        this.discountCode = discountCode;
        this.discountID = discountID;
    }

    public Discounts(String discountCategory, int discountPercentage, String discountCode) {
        this.discountCategory = discountCategory;
        this.discountPercentage = discountPercentage;
        this.discountCode = discountCode;
    }

    public String getDiscountCategory() {
        return discountCategory;
    }

    public void setDiscountCategory(String discountCategory) {
        this.discountCategory = discountCategory;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }
}
