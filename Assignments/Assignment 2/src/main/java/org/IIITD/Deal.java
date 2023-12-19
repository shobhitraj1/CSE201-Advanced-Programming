package org.IIITD;

// class Deal defines the properties & behaviours of different special deals
public class Deal extends Deals implements Zoo {
    private static int noofdeals = 0;

    public Deal(int combinedTickets, int dealPercentage, int dealID) {
        super(combinedTickets, dealPercentage, dealID);
    }

    public Deal(int combinedTickets, int dealPercentage) {
        super(combinedTickets, dealPercentage);
    }

    public static int getNoofdeals() {
        return noofdeals;
    }

    public static void setNoofdeals(int noofdeals) {
        Deal.noofdeals = noofdeals;
    }

    //custom string representation making it easier to display information about special deals
    @Override
    public String toString() {
        return "Special Deal: " + "Buy " + this.getCombinedTickets() + " tickets and get " + this.getDealPercentage() + "% off";
    }
}
