package org.IIITD.Question_2;

import java.util.Comparator;

public class DistanceComp implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.getDistance() - o1.getDistance(); //higher to lower
    }
}
