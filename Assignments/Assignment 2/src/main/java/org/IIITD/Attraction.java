package org.IIITD;

// class Attraction defines the properties & behaviours of different attractions in the zoo
public class Attraction implements Zoo {
    private String attractionName;
    private String attractionDesc;
    private int attractionID;
    private int ticketPrice; //for basic members
    private boolean isOpen;
    private int ticketSold; //The attraction should also maintain the count of ticketed visitors.
    private int visitedTimes; //The attraction should maintain the number of times it was visited.
    private static int noofattractions = 0;

    public Attraction(String attractionName, String attractionDesc, int attractionID, int ticketPrice) {
        this.attractionName = attractionName;
        this.attractionDesc = attractionDesc;
        this.attractionID = attractionID;
        this.ticketPrice = ticketPrice;
        this.isOpen = true; //By default, the attraction will be open
        this.ticketSold = 0; //start with 0
        this.visitedTimes = 0; //starts with 0
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public String getAttractionDesc() {
        return attractionDesc;
    }

    public void setAttractionDesc(String attractionDesc) {
        this.attractionDesc = attractionDesc;
    }

    public int getAttractionID() {
        return attractionID;
    }

    public void setAttractionID(int attractionID) {
        this.attractionID = attractionID;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getTicketSold() {
        return ticketSold;
    }

    public void setTicketSold(int ticketSold) {
        this.ticketSold = ticketSold;
    }

    public int getVisitedTimes() {
        return visitedTimes;
    }

    public void setVisitedTimes(int visitedTimes) {
        this.visitedTimes = visitedTimes;
    }

    public static int getNoofattractions() {
        return noofattractions;
    }

    public static void setNoofattractions(int noofattractions) {
        Attraction.noofattractions = noofattractions;
    }

    //custom string representation making it easier to display information about attractions
    @Override
    public String toString() {
        if (this.isOpen) {
            return "Attraction:" +
                    "\nAttraction Name: " + attractionName + "\nAttraction Description: " + attractionDesc +
                    "\nAttraction ID: " + attractionID + "\nTicket Price (for basic members): " + ticketPrice +
                    "\nStatus: OPEN";
        } else {
            return "Attraction:" +
                    "\nAttraction Name: " + attractionName + "\nAttraction Description: " + attractionDesc +
                    "\nAttraction ID: " + attractionID + "\nTicket Price (for basic members): " + ticketPrice +
                    "\nStatus: CLOSED";
        }
    }
}
