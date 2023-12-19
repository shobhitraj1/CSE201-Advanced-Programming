package org.IIITD.Question_2;

import java.util.Comparator;

public class JointComp implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (int) ((o1.getDistance() - 6 * (o1.getCgpa())) - (o2.getDistance() - 6 * (o2.getCgpa())));
    }
}
