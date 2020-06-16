import java.sql.*;
import java.lang.System;
import java.util.Scanner;
import java.io.*;
class Project
{
 public static Connection conn;
 public static Scanner sc=new Scanner(System.in);
 public static String y;
 public static String z;
  static
  {
  	try
  	{
  		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ictk","root","");
  		if(conn!=null)
  			System.out.println("connection is on");
  		else
  				System.out.println("connection error");
  	}
  	catch(Exception e)
  	{
  		System.out.println(e);
  	}
  }
   
   public static void start() throws Exception
   {  new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
      do{System.out.println("Enter Your choice\n1.Login\n2.Exit");
       int k=sc.nextInt();
       sc.nextLine();
       switch(k)
       {
        case 1: newLog(); break;
        case 2: System.out.println("Exit Done"); System.exit(0); break;
        default : System.out.println("Invalid Input");
      }
      }while(true);    
   }

   public static void newLog() throws Exception
   {   new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
       System.out.println("Enter your username");
       String a=sc.nextLine();
       System.out.println("Enter your password");
       String b=sc.nextLine();
       String c=(jconnect.logIn(a,b));
       System.out.println(c);
       if(c.equals("employee"))
        { System.out.println("\nYou are "+c);
          employee(a); }

       else if(c.equals("admin"))
        { System.out.println("\nYou are "+c);
          admin(a); }
      }


    public static String logIn(String a,String b)  throws Exception
    {  new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
      String qry="select usertype from employee where username=? and userpass=?";
    	PreparedStatement stmt= conn.prepareStatement(qry);
    	stmt.setString(1,a);
    	stmt.setString(2,b);
    	ResultSet rs=stmt.executeQuery();
        if(rs.next())
        {
        	return (rs.getString(1));
        }
        else
        	{ return "Invalid Username or Password";}
        
    }
   
   public static void employee(String x) throws Exception
   {  y=x;
   	do{System.out.println("   ************************************  WELCOME EMPLOYEE  **********************************   ");
    System.out.println("Enter your choice\n1.Add new Prospect\n2.View All Prospect\n3.Update Prospect");
    System.out.println("4.Search\n5.Change Own Password\n6.Signout");

    int a=sc.nextInt();
    switch(a)
    {
      
      case 1: newProspect(); break;
      case 2: viewProspect(); break;
      case 3: updateProspect(); break;
      case 4: searchByEmployee(); break;
      case 5: changePassEmployee(x); break;
      case 6: System.out.println("\nExit done");start();
      default : System.out.println("\nInvalid Input");employee(y); break;

    }}while(true);
  }

    
    public static void newProspect() throws Exception
    { new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
      String qry="insert into prospect values(?,?,?,?,?,?,?,?)";
     PreparedStatement stmt=conn.prepareStatement(qry);
     System.out.println("Enter Prospect Id");
     stmt.setInt(1,sc.nextInt());
     sc.nextLine();
     System.out.println("Enter Prospect Name");
     stmt.setString(2,sc.nextLine());
     System.out.println("Enter Prospect's Phone No.");
     stmt.setString(3,sc.nextLine());
     System.out.println("Enter Prospect's Address");
     stmt.setString(4,sc.nextLine());
     System.out.println("Enter Interested Model");
     stmt.setString(5,sc.nextLine());
     System.out.println("Enter Interested Colour");
     stmt.setString(6,sc.nextLine());
     System.out.println("Enter Date of Visit");
     stmt.setString(7,sc.nextLine());
     System.out.println("Enter Hotness");
     stmt.setString(8,sc.nextLine());
     if(stmt.executeUpdate()>0)
        System.out.println("\nrecord inserted");
     else
        System.out.println("\nrecord not inserted");
    }

    public static void viewProspect() throws Exception
    { new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    String qry="select * from Prospect";
    PreparedStatement stmt=conn.prepareStatement(qry);
    ResultSet rs=stmt.executeQuery();
    System.out.println("prospid\tprospname\tprospphone\tprospaddress\t\tinterestedmodel\t\tinterestedcolor\t\tdateofvisit\t\thotness");
    while(rs.next())
    {
      System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t\t"+rs.getString(6)+"\t\t\t\t"+rs.getString(7)+"\t\t\t"+rs.getString(8));
    }
  }


    public static void updateProspect() throws Exception
   {  System.out.println("\nEnter Your Choice\n1.Phone\n2.Model\n3.Colour\n4.Hotness\nBack To Main Menu : Press 5");
     int c=sc.nextInt();
     switch(c)
     { 
      case 1: phone(); break;
      case 2: model(); break;
      case 3: colour(); break;
      case 4: upHotness(); break;
      case 5: employee(y); break;
      default : System.out.println("invalid input");
     }
    }


    public static void phone() throws Exception
     {   new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
         String qry="update prospect set prospphone =? where prospld=?";
         PreparedStatement stmt=conn.prepareStatement(qry);
         System.out.println("Enter prospect id");
         stmt.setInt(2,sc.nextInt());
         sc.nextLine();
         System.out.println("Enter new phone no");
         stmt.setString(1,sc.nextLine());
         if(stmt.executeUpdate()>0)
        System.out.println("record inserted");
        else
        System.out.println("record not inserted");
        updateProspect();
     }

    public static void model() throws Exception
    {    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
         String qry="update prospect set interestedmodel=? where prospld=?";
         PreparedStatement stmt=conn.prepareStatement(qry);
         System.out.println("Enter prospect id");
         stmt.setInt(2,sc.nextInt());
         sc.nextLine();
         System.out.println("Enter New Interested Model");
         stmt.setString(1,sc.nextLine());
         if(stmt.executeUpdate()>0)
        System.out.println("record inserted");
     else
        System.out.println("record not inserted");
         updateProspect();
    }

    public static void colour() throws Exception
    {    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
         String qry="update prospect set interestedcolor =? where prospld=?";
         PreparedStatement stmt=conn.prepareStatement(qry);
         System.out.println("Enter prospect id");
         stmt.setInt(2,sc.nextInt());
         sc.nextLine();
         System.out.println("Enter New Color");
         stmt.setString(1,sc.nextLine());
         if(stmt.executeUpdate()>0)
        System.out.println("record inserted");
     else
        System.out.println("record not inserted");
         updateProspect();
    }

    public static void upHotness() throws Exception
    {    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
         String qry="update prospect set hotness=? where prospld=?";
         PreparedStatement stmt=conn.prepareStatement(qry);
         System.out.println("Enter prospect id");
         stmt.setInt(2,sc.nextInt());
         sc.nextLine();
         System.out.println("Enter Hotness");
         stmt.setString(1,sc.nextLine());
         if(stmt.executeUpdate()>0)
        System.out.println("record inserted");
     else
        System.out.println("record not inserted");
        updateProspect();
    }

    public static void searchByEmployee() throws Exception
   { System.out.println("1.By Hotness\n2.Prospect id\n3.Back To Main Menu :Press 3");
     int d=sc.nextInt();
     sc.nextLine();
     switch(d)
     {
      case 1: byEmpHotness(); break;
      case 2: byEmpProspectId(); break;
      case 3: employee(y);break;
      default :System.out.println("Invalid Input");
     }
    }

    public static void byEmpHotness() throws Exception
    {  new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
       String qry="select *from prospect where hotness=?";
      PreparedStatement stmt= conn.prepareStatement(qry);
      System.out.println("Enter Hotness");
      stmt.setString(1,sc.nextLine());
      ResultSet rs=stmt.executeQuery();
      
     System.out.println("prospid\tprospname\tprospphone\tprospaddress\t\tinterestedmodel\t\tinterestedcolor\t\tdateofvisit\t\thotness");
     while(rs.next())
    { 
      System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t\t"+rs.getString(6)+"\t\t\t\t"+rs.getString(7)+"\t\t\t"+rs.getString(8));
    }
     
    searchByEmployee();
   }


    public static void byEmpProspectId() throws Exception
    {  new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
      String qry="select *from prospect where prospld=?";
      PreparedStatement stmt= conn.prepareStatement(qry);
      System.out.println("Enter prospect Id");
      stmt.setInt(1,sc.nextInt());
      sc.nextLine();
      ResultSet rs=stmt.executeQuery();
      System.out.println("prospid\tprospname\tprospphone\tprospaddress\t\tinterestedmodel\t\tinterestedcolor\t\tdateofvisit\t\thotness");
     while(rs.next())
    { 
      System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t\t"+rs.getString(6)+"\t\t\t\t"+rs.getString(7)+"\t\t\t"+rs.getString(8));
    }
     searchByEmployee();
   }

    public static void changePassEmployee(String x) throws Exception
    {  new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        String qry="update employee set userpass =? where username=?";
         PreparedStatement stmt=conn.prepareStatement(qry);
         stmt.setString(2,x);
         sc.nextLine();
         System.out.println("Enter New Password");
         stmt.setString(1,sc.nextLine());
         if(stmt.executeUpdate()>0)
        System.out.println("Password Successfully Changed");
         else
        System.out.println("record not inserted");
       }

     public static void admin(String x) throws Exception
    {  z=x;
    do{	System.out.println("   ************************************  WELCOME ADMIN   *******************************    ");
    	System.out.println("1.Create User Account\n2.View All Users\n3.View All Prospect\n4.Change Password");
      System.out.println("5.Search Prospect\n6.Activate/Deactivate Account\n7.Signout");
  
      int b=sc.nextInt();
      sc.nextLine();
    switch(b)
    {
      
      case 1: createAccount(); break;
      case 2: viewAllUser(); break;
      case 3: viewProspect(); break;
      case 4: changePass(); break;
      case 5: searchByAdmin(); break;
      case 6: changeStatus(); break;
      case 7: System.out.println("\nExit Done");start();
      default: System.out.println("Invalid Input");

    }}while(true);
  }
   
  public static void createAccount() throws Exception
  {  System.out.println("Enter your choice\n1.Create Employee Account\n2.Create Admin Account\nBack To Main Menu : Press 3");
    int d=sc.nextInt();
    sc.nextLine();
    switch(d)
    {
      case 1: createEmployee(); break;
      case 2: createAdmin(); break;
      case 3: admin(z);break;
      default : System.out.println("Invalid Input"); createAccount(); break;     
     }
   }
   
   public static void createEmployee() throws Exception
   {  new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
     String qry="insert into employee values(?,?,?,?,?,?,?)";
     PreparedStatement stmt=conn.prepareStatement(qry);
     System.out.println("Enter Employee's Username");
     stmt.setString(1,sc.nextLine());     
     System.out.println("Enter Employee's Password");
     stmt.setString(2,sc.nextLine());
     stmt.setString(3,"employee");
     System.out.println("Enter Employee's Full Name");
     stmt.setString(4,sc.nextLine());
     System.out.println("Enter Employee's Phone No.");
     stmt.setString(5,sc.nextLine());
     System.out.println("Enter Employee's Email");
     stmt.setString(6,sc.nextLine());
     System.out.println("Enter Employee's Status");
     stmt.setString(7,sc.nextLine());      
     if(stmt.executeUpdate()>0)
        System.out.println("\nEmployee's Account Created");
     else
        System.out.println("\nrecord not inserted");
     createAccount();
   }

   public static void createAdmin() throws Exception
   {  new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
     String qry="insert into employee values(?,?,?,?,?,?,?)";
     PreparedStatement stmt=conn.prepareStatement(qry);
     System.out.println("Enter Admin's Username");
     stmt.setString(1,sc.nextLine());     
     System.out.println("Enter Admin's Password");
     stmt.setString(2,sc.nextLine());
     stmt.setString(3,"admin");
     System.out.println("Enter Admin's Full Name");
     stmt.setString(4,sc.nextLine());
     System.out.println("Enter Admin's Phone No.");
     stmt.setString(5,sc.nextLine());
     System.out.println("Enter Admin's Email");
     stmt.setString(6,sc.nextLine());
     System.out.println("Enter Admin's Status");
     stmt.setString(7,sc.nextLine());      
     if(stmt.executeUpdate()>0)
        System.out.println("\nAdmin's Account Created");
     else
        System.out.println("\nrecord not inserted");
     createAccount();

   }

   public static void viewAllUser() throws Exception
   { new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
     String qry="select * from employee where usertype=?";
    PreparedStatement stmt=conn.prepareStatement(qry);
    stmt.setString(1,"employee");   
    ResultSet rs=stmt.executeQuery();
    System.out.println("username\tuserpass\tusertype\tfullname\t\tphone\t\temail\t\tstatus");
    while(rs.next())
    {
      System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t  "+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7));
    }
   }

   public static void changePass() throws Exception
   { System.out.println("Enter Your Choice\n1.Self\n2.Others\n3.Back To Main Menu : Press 3");
    int d=sc.nextInt();
    sc.nextLine();
    switch(d)
    {
      case 1: selfPass(z); break;
      case 2: changePassOthers(); break;
      case 3: admin(z);break;
      default : System.out.println("Invalid Input");
    }
   }

   public static void selfPass(String x) throws Exception
   { new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
     String qry="update employee set userpass =? where username=?";
    PreparedStatement stmt=conn.prepareStatement(qry);
    stmt.setString(2,x);
    System.out.println("Enter New Password");
    stmt.setString(1,sc.nextLine());
    if(stmt.executeUpdate()>0)
    System.out.println("Password Successfully Changed");
    else
    System.out.println("Somthing went Wrong");
    changePass();
   }

    public static void changePassOthers() throws Exception
    { new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
      String qry="update employee set userpass=? where username=?";
      PreparedStatement stmt=conn.prepareStatement(qry);
      System.out.println("Enter User Username");
      stmt.setString(2,sc.nextLine());
      System.out.println("Enter User's New Password");
      stmt.setString(1,sc.nextLine());
      if(stmt.executeUpdate()>0)
      System.out.println("Password Successfully Changed");
      else
      System.out.println("Invalid User Name");
      changePass();
     }


   public static void searchByAdmin() throws Exception
   { System.out.println("1.By Hotness\n2.Prospect id\n3.Back To Main Menu :Press 3");
     int d=sc.nextInt();
     sc.nextLine();
     switch(d)
     {
      case 1: byAdHotness(); break;
      case 2: byAdProspectId(); break;
      case 3: admin(z);break;
      default :System.out.println("Invalid Input");
     }
    }

    public static void byAdHotness() throws Exception
    { new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
      String qry="select *from prospect where hotness=?";
      PreparedStatement stmt= conn.prepareStatement(qry);
      System.out.println("Enter Hotness");
      stmt.setString(1,sc.nextLine());
      ResultSet rs=stmt.executeQuery();
      System.out.println("prospid\tprospname\tprospphone\tprospaddress\t\tinterestedmodel\t\tinterestedcolor\t\tdateofvisit\t\thotness");
     while(rs.next())
    { 
      System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t\t"+rs.getString(6)+"\t\t\t\t"+rs.getString(7)+"\t\t\t"+rs.getString(8));
    }
     searchByAdmin();
   }


    public static void byAdProspectId() throws Exception
    { new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
       String qry="select *from prospect where prospld=?";
      PreparedStatement stmt= conn.prepareStatement(qry);
      System.out.println("Enter prospect Id");
      stmt.setInt(1,sc.nextInt());
      sc.nextLine();
      ResultSet rs=stmt.executeQuery();
  System.out.println("prospid\tprospname\tprospphone\tprospaddress\t\tinterestedmodel\t\tinterestedcolor\t\tdateofvisit\t\thotness");
     while(rs.next())
    { 
      System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t\t"+rs.getString(6)+"\t\t\t\t"+rs.getString(7)+"\t\t\t"+rs.getString(8));
    }
     searchByAdmin();
   }

    public static void changeStatus() throws Exception
    {   new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        String qry="update employee set status=? where username=?";
         PreparedStatement stmt=conn.prepareStatement(qry);
         System.out.println("Enter Username");
         stmt.setString(2,sc.nextLine());
         System.out.println("Enter New Status");
         stmt.setString(1,sc.nextLine());
         if(stmt.executeUpdate()>0)
        System.out.println("record inserted");
     else
        System.out.println("record not inserted");
       
    }


    public static void main(String [] args)  throws Exception
    {  new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
       Scanner sc=new Scanner(System.in);
       start();
  }
}