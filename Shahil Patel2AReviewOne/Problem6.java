import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.*;
import java.util.ArrayList;
public class Problem6
{
	public static void main(String args[])
	{
		File name = new File("Prob6Input.txt");
		ArrayList<String> dir=new ArrayList<>();
		int top=1;
		int west=3;
		int east=4;
		int bottom=6;
		int south=5;
		int north=2;
		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(name));
			String text,output="";
			while((text=input.readLine())!=null)
			{
				String[] temp=text.split("");
				for(int x=0;x<temp.length;x++){
					dir.add(temp[x]);
				}
				for(int x=0;x<dir.size();x++){
					int tempN=north;
					int tempS=south;
					int tempE=east;
					int tempW=west;
					int tempT=top;
					int tempB=bottom;
					switch(dir.get(x)){
						case "N":
							north=tempT;
							top=south;
							break;
						case "S":
							top=tempN;
							north=bottom;
							break;
						case "E":
							top=tempW;
							west=bottom;
							break;
						case "W":
							west=tempT;
							top=east;
							break;
					}
					south=Math.abs(north-7);
					east=Math.abs(west-7);
					bottom=Math.abs(top-7);
					north=Math.abs(south-7);
					top=Math.abs(bottom-7);
					west=Math.abs(east-7);
				}
				System.out.println(top);
				top=1;
				west=3;
				east=4;
				bottom=6;
				south=5;
				north=2;
				dir.clear();
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}
