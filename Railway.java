package sample;
import java.util.*;
class Train
{
	int train_number;
	String train_name;
	String seat_type;
	int available_seats;
	Train(int t,String n,String s,int as)
	{
		train_number=t;
		train_name=n;
		seat_type=s;
		available_seats=as;
	}
	public void display()
	{
		System.out.println("Train Number: "+train_number+"\nTrain Name: "+train_name+"\nSeat Type: "+seat_type+"\nAvailable Seats: "+available_seats);
	}
}
class Book
{
	String pname;
	int tid;
	Date d;
	String date;
	Book(String p,int i,String de)
	{
		pname=p;
		tid=i;
		date=de;
	}
	public void show()
	{
		System.out.println("PASSENGER NAME: "+pname+"\nTRAIN ID: "+tid+"\nDATE: "+date);
	}
	public boolean isAvailable(List<Book> b,List<Train> t)
	{
		return true;
	}
}
public class Railway {
	public static void main(String[] args) {
		  Scanner s=new Scanner(System.in);
		  List<Train> l=new ArrayList<>();
		  l.add(new Train(101,"Vande Bharat","AC",40));
		  l.add(new Train(102,"Jan Shathabthi","Non AC",25));
		  l.add(new Train(103,"Cheran Express","Sleeper",67));
		  ArrayList<Book> b=new ArrayList<>();
		  int ans=1;
		  do
		  {
			  System.out.println("--------------------------------WELCOME TO RAILWAY RESERVATION--------------------------------");
			  System.out.print("1.Display Train Info\'s\n2.Book a Train\n3.Add Trains\n4.Booked Passengers\nPlease Enter Your Choice:");
			  int choice=s.nextInt();
			  switch(choice)
			  {
			  case 1:
			  {
				  int i=1;
				  for(Train t:l)
				  {
					  System.out.println("----TRAIN "+i+" DETAILS----");
					  t.display();
					  i++;
				  }
				  break;
			  }
			  case 2:
			  {
				  System.out.println("Enter the Passenger Name: ");
				  String st=s.next();
				  System.out.println("Enter the Train ID: ");
				  int t=s.nextInt();
				  System.out.println("Enter the Date: ");
				  String d=s.next();
				  Book bk=new Book(st,t,d);
				  b.add(bk);
				  if(bk.isAvailable(b,l))
				  {
					  System.out.println("Your Booking is Confirmed: ");
				  }
				  else
				  {
					  System.out.println("Your Booking is not Confirmed!");
				  }
				  
				  break;
			  }
			  case 3:
			  {
				  System.out.println("Enter the Train Number: ");
				  int tn=s.nextInt();
				  System.out.println("Enter the Train Name: ");
				  String tname=s.next();
				  System.out.println("Enter the Seat Type: ");
				  s.nextLine();
				  String sty=s.nextLine();
				  System.out.println("Enter the Total Seats: ");
				  int ts=s.nextInt();
				  if(!l.contains(new Train(tn,tname,sty,ts)))
				  {
					  l.add(new Train(tn,tname,sty,ts));
					  System.out.println("Train Added SuccessFully..");
				  }
				  else
					  System.out.println("Train Already exists!");
				  break;
			  }
			  case 4:
			  {
				  if(b.size()==0)
					  System.out.println("No Passengers Book Yet!");
				  else
				  {
					  for(Book bk: b)
					  {
						  bk.show();
					  }  
				  }
				  break;
			   }
			  default:
			  {
				  System.out.println("Invalid Choice!");
				  break;
			  }
			  }
			  
			  System.out.println("Enter 1 to Continue");
			  ans=s.nextInt();
		  }while(ans==1);
	}
}
