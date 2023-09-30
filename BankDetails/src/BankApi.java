import java.util.*;
public class BankApi {
    private HashMap<Integer,Bankacc> map;
    public int acc_no=1000;
    Scanner sc=new Scanner(System.in);
    BankApi()
    {
        this.map=new HashMap<>();
    }
    public void createacc()
    {
        Bankacc bc=new Bankacc();
        map.put(++acc_no,bc);

    }
    public void checkBalance()
    {
        System.out.println("Enter your account no");
        int number=sc.nextInt();
        if(map.get(number)!=null)
        {
            Bankacc bc=map.get(number);
            System.out.println("Account holder name:"+bc.accname);
            System.out.println("Account holder bal:"+bc.bal);
        }
        else {
            System.out.println("Account doesn't exsist");
        }
    }
    public void del(){
        System.out.println("Enter your account no");
        int number=sc.nextInt();
        if(map.get(number)!=null)
        {
            map.remove(new Integer(number));
            System.out.println("Account deleted successfully");
        }
        else {
            System.out.println("Account doesn't exsist");
        }
    }
    public void acc_details()
    {
        if(map.size()==0)
        {
            System.out.println("No Account Found");
        }

        for(int i:map.keySet())
        {
            System.out.println("---------------------------------------");
            Bankacc bc=map.get(i);
            System.out.println("Account number"+i);
            System.out.println("Account holder name:"+bc.accname);
            System.out.println("Account holder bal:"+bc.bal);
            System.out.println("---------------------------------------");
        }
    }
    public void deposite()
    {
        System.out.println("Enter your account no");
        int number=sc.nextInt();
        if(map.get(number)!=null)
        {
            System.out.println("Enter deposite amount");
            int amount=sc.nextInt();
            Bankacc bc=map.get(number);
            bc.bal+=amount;
            Bankacc bc1=map.get(number);
            System.out.println("Account holder bal:"+bc1.bal);


        }
        else {
            System.out.println("Account doesn't exsist");
        }
    }

    public  void transfer()
    {
        System.out.println("Enter your sender account no");
        int sender=sc.nextInt();
        if(map.get(sender)!=null)
        {
            System.out.println("Enter your reciver account no");
            int reciver=sc.nextInt();
            Bankacc send=map.get(sender);
            if(map.get(reciver)!=null)
            {
                System.out.println("Enter your account ");
                int amount=sc.nextInt();
                Bankacc rev=map.get(reciver);
                if(send.bal>=amount) {
                    rev.bal+=amount;
                    send.bal-=amount;
                    System.out.println("transaction completed");

                }
                else {
                    System.out.println("amount insufficent");
                }


            }
            else {
                System.out.println("reciver Account not found");
            }
        }
        else {
            System.out.println("sender Account not found");
        }
    }

    public void credit()
    {
        System.out.println("Enter your account no");
        int number=sc.nextInt();
        if(map.get(number)!=null)
        {
            System.out.println("Enter credit amount");
            int amount=sc.nextInt();
            Bankacc bc=map.get(number);
            if(bc.bal>=amount) {
                bc.bal -= amount;
                Bankacc bc1 = map.get(number);
                System.out.println("Account holder bal:" + bc1.bal);
            }
            else {
                System.out.println("amount insufficent");
            }

        }
        else {
            System.out.println("Account doesn't exsist");
        }
    }


    public static void main(String args[])
    {
        BankApi acc=new BankApi();
        int ch;

        while(true) {
            System.out.println("choicse:");
            System.out.println("1.create account");
            System.out.println("2.check account");
            System.out.println("3.deposite amount");
            System.out.println("4.credit amount");
            System.out.println("5.tranfer ammount");
            System.out.println("6.delete account");
            System.out.println("7.check accounts");
            System.out.println("8.Exit");
            System.out.println("enter the chioce");
            ch=acc.sc.nextInt();
            boolean flg=false;

            switch (ch) {
                case 1:
                    acc.createacc();
                    break;
                case 2:
                    acc.checkBalance();
                    break;
                case 3:
                    acc.deposite();
                    break;
                case 4:
                    acc.credit();
                    break;
                case 5:
                    acc.transfer();
                    break;
                case 6:
                    acc.del();
                    break;
                case 7:
                    acc.acc_details();
                    break;
                default:
                    System.out.println("__Exit__");
                    flg=true;
                    break;
            }
            if(flg)
                break;
        }
    }
}


