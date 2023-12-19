package org.IIITD;

import java.util.ArrayList;

//The Zoo interface serves as a common interface for different components of the zoo, such as
//attractions, animals, deals, and discounts - implemented by different classes to manage the Zoo
public interface Zoo {
    ArrayList<Visitor> visitors = new ArrayList<>();
    ArrayList<Attraction> attractions = new ArrayList<>();
    ArrayList<Animal> animals = new ArrayList<>();
    ArrayList<Discount> discounts = new ArrayList<>();
    ArrayList<Deal> deals = new ArrayList<>();
    ArrayList<String> feedback = new ArrayList<>();
}
