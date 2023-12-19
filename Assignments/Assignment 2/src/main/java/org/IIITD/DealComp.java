package org.IIITD;

import java.util.Comparator;

// class used to create a comparator to sort deals on a particular basis by overriding compare
public class DealComp implements Comparator<Deal> {

    //compare & sort deals higher to lower according to number of combined tickets bought
    @Override
    public int compare(Deal o1, Deal o2) {
        return o2.getCombinedTickets() - o1.getCombinedTickets();
    }
}
