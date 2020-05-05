import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.*;
import java.util.ArrayList;
public class Problem3
{
	public static void main(String args[])
	{
		File name = new File("Prob3Input.txt");
		ArrayList<Integer> nums=new ArrayList<>();
		ArrayList<Integer> factorsOne=new ArrayList<>();
		ArrayList<Integer> factorsTwo=new ArrayList<>();
		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(name));
			String text,output="";
			while( (text=input.readLine())!= null)
			{
		//		System.out.println(text);
				String[] str=text.split(" ");
				for(int x=0;x<str.length;x++)
					nums.add(Integer.parseInt(str[x]));
			//	System.out.println(nums);
				output+=text;
				for(int x=1;x<=nums.get(0)/2;x++){
					if(nums.get(0)%x==0){
						factorsOne.add(x);
					}
				}
				for(int x=1;x<=nums.get(1)/2;x++){
					if(nums.get(1)%x==0){
						factorsTwo.add(x);
					}
				}
				int factOneSum=0;
				int factTwoSum=0;
				for(int x=0;x<factorsOne.size();x++){
					factOneSum+=factorsOne.get(x);
				}
				for(int x=0;x<factorsTwo.size();x++){
					factTwoSum+=factorsTwo.get(x);
				}
				if(factOneSum==nums.get(1)&&factTwoSum==nums.get(0)){
					String s="";
					for(int x=0;x<factorsOne.size()-2;x++){
						s+=factorsOne.get(x)+", ";
					}
					s+=factorsOne.get(factorsOne.size()-2)+" and "+factorsOne.get(factorsOne.size()-1)+".";
					System.out.println("The numbers "+nums.get(0)+" and "+nums.get(1)+" are amicable");
					System.out.println("      Factors of "+nums.get(0)+" are "+s+" Sum is "+factOneSum);
					s="";
					for(int x=0;x<factorsTwo.size()-2;x++){
						s+=factorsTwo.get(x)+", ";
					}
					s+=factorsTwo.get(factorsTwo.size()-2)+" and "+factorsTwo.get(factorsTwo.size()-1)+".";
					System.out.println("      Factors of "+nums.get(1)+" are "+s+" Sum is "+factTwoSum);
				}
				else{
					String s="";
					for(int x=0;x<factorsOne.size()-2;x++){
						s+=factorsOne.get(x)+", ";
					}
					s+=factorsOne.get(factorsOne.size()-2)+" and "+factorsOne.get(factorsOne.size()-1)+".";
					System.out.println("The numbers "+nums.get(0)+" and "+nums.get(1)+" are not amicable");
					System.out.println("      Factors of "+nums.get(0)+" are "+s+" Sum is "+factOneSum);
					s="";
					for(int x=0;x<factorsTwo.size()-2;x++){
						s+=factorsTwo.get(x)+", ";
					}
					s+=factorsTwo.get(factorsTwo.size()-2)+" and "+factorsTwo.get(factorsTwo.size()-1)+".";
					System.out.println("      Factors of "+nums.get(1)+" are "+s+" Sum is "+factTwoSum);
				}
				System.out.println();
				factorsOne.clear();
				factorsTwo.clear();
				nums.clear();
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}
