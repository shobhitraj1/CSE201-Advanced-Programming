package com.IIITD_AP_KR22;
import java.util.*;


class SignUpException extends Exception{
    SignUpException(String msg){
        super(msg);
    }

    public String toString(){
        return super.getMessage();
    }

}


public class q2e{
    private static Map<String,q2e> a=new HashMap<String,q2e>();
    private final String u, p;

    private q2e(String x,String y){
        u=x;
        p=y;
    }

    public static q2e getInstance(String x, String y) throws SignUpException {
        String key = x;
        if (!a.containsKey(key)) {
            a.put(key, new q2e(x,y));
        }else{
            throw new SignUpException("Username already exists");
        }
        return a.get(key);
    }

    @Override
    public String toString() {
        return "Account Created: {" +
                "u='" + u + '\'' +
                ", p='" + p + '\'' +
                '}';
    }
}




class MMMain{
    public static void main(String[] args) throws SignUpException{

        q2e.getInstance("rohit","sharma");
        q2e.getInstance("virat","kohli");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        int flag=0;
        while(true){

            System.out.println("Enter username");

            String userName = myObj.nextLine();

            System.out.println("Enter password");

            String passWord = myObj.nextLine();

            try{
            System.out.println(q2e.getInstance(userName,passWord));
            break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }


        }



    }
}