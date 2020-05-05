import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.*;
import java.util.ArrayList;
public class Task1
{
	public static void main(String args[])
	{
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		File name = new File("task1Text.txt");
		try
		{
			BufferedReader input = new BufferedReader( new FileReader(name));
			String text,output="";
			while( (text=input.readLine())!= null)
			{
				String[] temp=text.split("");
				for(int x=0;x<temp.length;x++)
				{
					if(!map.containsKey(temp[x]))
						map.put(temp[x],0);
					map.put(temp[x],map.get(temp[x])+1);
				}
			}
			System.out.println(map);
		}
		catch (IOException io){}
	}
}