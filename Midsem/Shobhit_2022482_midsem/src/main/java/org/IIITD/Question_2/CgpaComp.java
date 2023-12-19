package org.IIITD.Question_2;

import java.util.Comparator;

public class CgpaComp implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (int) (o1.getCgpa() - o2.getCgpa()); //lower to higher
    }
}
