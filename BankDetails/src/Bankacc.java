import java.util.*;
public class Bankacc{
    public String accname;
    public double bal=0.0;
    Scanner sc=new Scanner(System.in);

    public Bankacc()
    {

        System.out.println("Enter your Name");
        accname=sc.nextLine();
    }

}
