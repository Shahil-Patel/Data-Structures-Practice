import java.util.Stack;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
public class StackDemo
{
	public static void main(String args[])
	{
		StackDemo app=new StackDemo();
	}
	public StackDemo(){
		Stack<Integer> lifo = new Stack<Integer>();
		int decimal=123;
		if(decimal==0){
			System.out.print(0);
		}
		while(decimal>0){
			lifo.push(decimal%2);
			decimal/=2;
		}
		while(!lifo.empty()){
			System.out.print(lifo.pop());
		}
		System.out.println("\n");


		String reverse="Shahil";
		Stack<String> lifoString = new Stack<String>();
		for(int x=0;x<reverse.length()-1;x++){
			lifoString.push(reverse.substring(x,x+1));
		}
		while(!lifoString.empty()){
			System.out.print(lifoString.pop());
		}
		System.out.println("\n");


		Stack<Book> lifoBooks = new Stack<Book>();
		try
		{
			int c=0;
			String last="";
			String first="";
			String title="";
			String rating="";
			BufferedReader input = new BufferedReader(new FileReader("100BestSciFi21stCentury.txt"));
			String text="";
			while((text=input.readLine())!= null)
			{
				switch(c){
					case 1:
					break;
					case 2: String[] str=text.split("\t");
							title=str[1];
					break;
					case 3: String[] str2=text.split(" ");
							first=str2[1];
							last=str2[2];
					break;
					case 4: String[] str3=text.split(" ");
							rating=str3[0];
					break;
					case 5:
					break;
					case 6:
							Book book=new Book(first,last,title,rating,"","","");
							lifoBooks.push(book);
							c=-1;
							last="";
							first="";
							title="";
							rating="";
					break;
				}
				c++;
			}
			while(!lifoBooks.empty()){
				if(lifoBooks.peek().getFirstName().substring(0,1).equals("E")||lifoBooks.peek().getFirstName().substring(0,1).equals("P")||lifoBooks.peek().getFirstName().substring(0,1).equals("H")||lifoBooks.peek().getFirstName().substring(0,1).equals("S")||lifoBooks.peek().getLastName().substring(0,1).equals("E")||lifoBooks.peek().getLastName().substring(0,1).equals("P")||lifoBooks.peek().getLastName().substring(0,1).equals("H")||lifoBooks.peek().getLastName().substring(0,1).equals("S")){
					System.out.println(lifoBooks.pop());
				}
				else lifoBooks.pop();
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
	public class Book{
		private String firstName;
		private String lastName;
		private String title;
		private String rating;
		private String numRate;
		private String numVote;
		private String numScore;
		public Book(String firstName,String lastName,String title,String rating,String numRate,String numVote,String numScore){
			this.firstName=firstName;
			this.lastName=lastName;
			this.title=title;
			this.rating=rating;
			this.numRate=numRate;
			this.numVote=numVote;
			this.numScore=numScore;
		}
		public String getFirstName(){
			return firstName;
		}
		public String getLastName(){
			return lastName;
		}
		public String toString(){
			return lastName+", "+firstName+"-"+title+"; "+rating;
		}
	}
}