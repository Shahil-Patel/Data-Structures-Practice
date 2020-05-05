import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.*;
import java.util.ArrayList;
import java.text.DecimalFormat;
public class Problem7
{
	public static void main(String args[])
	{
		File name = new File("Prob7Input.txt");
		int count=1;
		double dollar1=0.0;
		double conv1=0.0;
		double fee1=0.0;
		double conv2=0.0;
		double fee2=0.0;
		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(name));
			String text,output="";
			while( (text=input.readLine())!= null)
			{
				switch(count){
					case 1:
						dollar1=Double.parseDouble(text.substring(9,text.length()));
						break;
					case 2:
						conv1=Double.parseDouble(text.substring(5,text.length()));
						break;
					case 3:
						fee1=Double.parseDouble(text.substring(5,text.length()));
						break;
					case 4:
						conv2=Double.parseDouble(text.substring(5,text.length()));
						break;
					case 5:
						fee2=Double.parseDouble(text.substring(5,text.length()));
						break;

				}
				if(count==5){
					count=0;
					 DecimalFormat df = new DecimalFormat("#,###,##0.00");
					//System.out.println(dollar1+"\n"+conv1+"\n"+fee1+"\n"+conv2+"\n"+fee2);
					double total1=dollar1*(1-fee1/100)*(conv1);
					double total2=dollar1*(1-fee2/100)*(conv2);
					//System.out.println(total1+" "+total2);
				//	System.out.println(df.format(total1)+" "+df.format(total2));
					System.out.println("Booth 1: "+df.format(total1)+" euros");
					System.out.println("Booth 2: "+df.format(total2)+" euros");
					if(total1>total2){
						System.out.println("Booth 1 is the best; difference is "+df.format(total1-total2)+" euros");
					}
					else{
						System.out.println("Booth 2 is the best; difference is "+df.format(total2-total1)+" euros");
					}
					System.out.println();
				}
				count++;
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}
