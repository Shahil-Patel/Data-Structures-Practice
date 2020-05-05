import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.*;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;
import java.text.*;
import java.util.Calendar;
public class Problem8
{
	public static void main(String args[])
	{
		File name = new File("Prob8Input.txt");

		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(name));
 			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm a");
 			LocalDateTime now = LocalDateTime.now();
 			String current=dtf.format(now);
 			String date=current.substring(0,10);
 			String time=current.substring(11,current.length());
			String text,output="";
			ArrayList<String> times=new ArrayList<>();
			while( (text=input.readLine())!= null)
			{
				if(!(current.substring(11,12).equals("0")))
					System.out.println("Depature Date and Time: "+time+" on "+date);
				else
					System.out.println("Depature Date and Time: "+time.substring(1)+" on "+date);
				String[] temp=text.split(" ");
				for(int x=0;x<temp.length;x++){
					times.add(temp[x]);
				}
				Calendar c = Calendar.getInstance();
				int Tmins=0;
				Tmins=Integer.parseInt(times.get(2));
				Tmins+=Integer.parseInt(times.get(1))*60;
				Tmins+=Integer.parseInt(times.get(0))*24*60;
				c.add(Calendar.MINUTE,Tmins);
				times.clear();
				Tmins=0;
				Date d=c.getTime();
       			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
				if(c.get(Calendar.AM_PM)==0){
					if(c.get(Calendar.HOUR)==0){
						if(c.get(Calendar.MINUTE)<10){
							System.out.println("Arrival Date and Time: 12:0"+c.get(Calendar.MINUTE)+" AM "+" on "+sdf.format(d));
						}
						else System.out.println("Arrival Date and Time: 12:"+c.get(Calendar.MINUTE)+" AM "+" on "+sdf.format(d));
					}
					else{
						if(c.get(Calendar.MINUTE)<10){
							System.out.println("Arrival Date and Time: "+c.get(Calendar.HOUR)+":0"+c.get(Calendar.MINUTE)+" AM "+" on "+sdf.format(d));
						}
						else System.out.println("Arrival Date and Time: "+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+" AM "+" on "+sdf.format(d));
						}
				}
				else{
					if(c.get(Calendar.HOUR)==0){
						if(c.get(Calendar.MINUTE)<10){
							System.out.println("Arrival Date and Time: 12:0"+c.get(Calendar.MINUTE)+" PM "+" on "+sdf.format(d));
						}
						else System.out.println("Arrival Date and Time: 12:"+c.get(Calendar.MINUTE)+" PM "+" on "+sdf.format(d));
					}
					else{
						if(c.get(Calendar.MINUTE)<10){
							System.out.println("Arrival Date and Time: "+c.get(Calendar.HOUR)+":0"+c.get(Calendar.MINUTE)+" PM "+" on "+sdf.format(d));
						}
						else System.out.println("Arrival Date and Time: "+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+" PM "+" on "+sdf.format(d));
					}
				}
				System.out.println();
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}
