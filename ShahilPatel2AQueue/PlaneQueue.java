import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.*;
import java.text.*;
public class PlaneQueue
{
	public PlaneQueue(){
		Queue<Passenger> q=new LinkedList<Passenger>();
 		PriorityQueue<Passenger> pq = new PriorityQueue<Passenger>();
		File name = new File("PassengerInfo.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String text,output="";
			while( (text=input.readLine())!= null)
			{
				System.out.println(text);
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
	public static void main(String[] args){
		PlaneQueue app=new PlaneQueue();
	}
	public class Passenger implements Comparable<Passenger>{
		private String first;
		private String last;
		private String city;
		private String time;
		public Passenger(String first,String last,String city,String time){
			this.first=first;
			this.last=last;
			this.city=city;
			this.time=time;
		}
		public String getFirst(){
			return first;
		}
		public String getLast(){
			return last;
		}
		public String flightCity(){
			return city;
		}
		public String flightTime(){
			return time;
		}
		public int etdCalc(String time){
			int current=543; //9:03 AM
			String hourMin="";
			String minutes="";
			String[] str=time.split(":");
			String[] str2=str[1].split(" ");
			hourMin=(Integer.parseInt(str[0])*60)+"";
			minutes=(str2[0])+"";
			if(str2[1].equals("AM")){

			}
			else{
				hourMin=(Integer.parseInt(hourMin)+12*60)+"";
			}
			return Integer.parseInt(hourMin)+Integer.parseInt(minutes);
		}
		public int compareTo(Passenger pass){
			int a = pass.etdCalc(time);
			int b = this.etdCalc(this.time);
			if (a>b) return 1;
			if (a<b) return -1;
			return 0;
		}
		public String toString(){
			return last+", "+first+"-"+city+"-"+flightTime()+"-"+etdCalc(time);
		}
	}
}




