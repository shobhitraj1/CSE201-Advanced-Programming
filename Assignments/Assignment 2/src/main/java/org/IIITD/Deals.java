package org.IIITD;

// abstract class Deals serves as blueprint for creating objects of type Deal
public abstract class Deals {
    private int combinedTickets;
    private int dealPercentage;
    private int dealID;

    public Deals(int combinedTickets, int dealPercentage, int dealID) {
        this.combinedTickets = combinedTickets;
        this.dealPercentage = dealPercentage;
        this.dealID = dealID;
    }

    public Deals(int combinedTickets, int dealPercentage) {
        this.combinedTickets = combinedTickets;
        this.dealPercentage = dealPercentage;
    }

    public int getCombinedTickets() {
        return combinedTickets;
    }

    public void setCombinedTickets(int combinedTickets) {
        this.combinedTickets = combinedTickets;
    }

    public int getDealPercentage() {
        return dealPercentage;
    }

    public void setDealPercentage(int dealPercentage) {
        this.dealPercentage = dealPercentage;
    }

    public int getDealID() {
        return dealID;
    }

    public void setDealID(int dealID) {
        this.dealID = dealID;
    }
}
