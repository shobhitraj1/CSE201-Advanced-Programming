package com.IIITD_AP_KR22;
import java.io.*;
import java.util.*;

class q1e{
    public static void main(String[] args) throws IOException {
        BufferedReader a1 = null;
        BufferedReader a2 = null;
        BufferedWriter o1 = null;
        BufferedWriter o2 = null;
        ArrayList<Integer> m1 = new ArrayList<Integer>();
        ArrayList<Integer> m2 = new ArrayList<Integer>();
        a1 = new BufferedReader(new FileReader("C:/Users/koteswar/IdeaProjects/ap2023/src/com/IIITD_AP_KR22/A1.txt"));
        a2 = new BufferedReader(new FileReader("C:/Users/koteswar/IdeaProjects/ap2023/src/com/IIITD_AP_KR22/A2.txt"));
        o1 = new BufferedWriter(new FileWriter("C:/Users/koteswar/IdeaProjects/ap2023/src/com/IIITD_AP_KR22/O1.txt"));
        o2 = new BufferedWriter(new FileWriter("C:/Users/koteswar/IdeaProjects/ap2023/src/com/IIITD_AP_KR22/O2.txt"));

        String l;
        while ((l = a1.readLine()) != null){
            m1.add(Integer.valueOf(l));
            m2.add(Integer.valueOf(a2.readLine()));
        }
        int mm=0;
        int mm2=0;
        for (int i=0;i<m1.size();i++){
            String mms="";
            String mms2="";
            for (int j=0;j<m1.size();j++) {

                mm=(m1.get(i)*m2.get(j));
                mms=mms+String.valueOf(mm)+",";

                mm2=(m2.get(i)*m1.get(j));
                mms2=mms2+String.valueOf(mm2)+",";

            }

            o1.write(mms+'\n');
            o2.write(mms2+'\n');

        }






        a1.close();
        a2.close();
        o1.close();
        o2.close();

    }
}