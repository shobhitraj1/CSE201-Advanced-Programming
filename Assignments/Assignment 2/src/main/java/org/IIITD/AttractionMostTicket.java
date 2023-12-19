package org.IIITD;

import java.util.Comparator;

// class used to create a comparator to sort attractions on a particular basis by overriding compare
public class AttractionMostTicket implements Comparator<Attraction> {

    //compare & sort attractions higher to lower according to most ticket sold
    @Override
    public int compare(Attraction o1, Attraction o2) {
        return o2.getTicketSold() - o1.getTicketSold();
    }
}
