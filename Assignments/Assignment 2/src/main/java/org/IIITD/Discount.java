package org.IIITD;

// class Discount defines the properties & behaviours of different discounts
public class Discount extends Discounts implements Zoo {
    private static int noofdiscounts = 0;

    public Discount(String discountCategory, int discountPercentage, String discountCode, int discountID) {
        super(discountCategory, discountPercentage, discountCode, discountID);
    }

    public Discount(String discountCategory, int discountPercentage, String discountCode) {
        super(discountCategory, discountPercentage, discountCode);
    }

    public static int getNoofdiscounts() {
        return noofdiscounts;
    }

    public static void setNoofdiscounts(int noofdiscounts) {
        Discount.noofdiscounts = noofdiscounts;
    }

    //custom string representation making it easier to display information about discounts
    @Override
    public String toString() {
        return "Discount: " + this.getDiscountCategory() + " (" + this.getDiscountPercentage() + "% discount) - " + this.getDiscountCode();
    }
}
