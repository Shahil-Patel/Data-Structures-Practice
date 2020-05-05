import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.*;
import java.util.ArrayList;
import java.math.BigInteger;
public class Problem2
{
	public static void main(String args[])
	{
		File name = new File("Prob2Input.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String text,output="";
			while( (text=input.readLine())!= null)
			{
				long number=Integer.parseInt(text);
				BigInteger a=new BigInteger("2");
				BigInteger b=new BigInteger("1");
				BigInteger c=new BigInteger("0");
				for(long x=0;x<number;x++){
					c=a.add(b);
					a=b;
					b=c;
				}
				System.out.println(a+"\n");
			}
		}
		catch (IOException io)
		{
		}
	}
}