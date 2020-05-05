import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.*;
import java.util.ArrayList;
public class Problem4
{
	public static void main(String args[])
	{
		ArrayList<String> codes=new ArrayList<>();
		int count=1;
		File name = new File("Prob4Input.txt");
		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(name));
			String text,output="";
			while((text=input.readLine())!= null)
			{
				if(count==1){
					codes.add(text);
				}
				if(count==2){
					codes.add(text);
					String[] letters=codes.get(0).split("");
					String[] letters2=codes.get(1).split("");
					ArrayList<String> let=new ArrayList<>();
					ArrayList<String> let2=new ArrayList<>();
					for(int x=0;x<letters.length;x++){
						let.add(letters[x]);
						let2.add(letters2[x]);
					}
					int correct=0;
					int incorrect=0;
					for(int x=0;x<let.size();x++){
						if(let.get(x).equals(let2.get(x))){
							let.remove(x);
							let2.remove(x);
							correct++;
							x--;
						}
					}
					for(int x=0;x<let.size();x++){
						if(let.contains(let2.get(x))){
							let.remove(let2.get(x));
							let2.remove(x);
							x=-1;
							incorrect++;
						}
					}
					System.out.println("Code:  "+codes.get(0));
					System.out.println("Guess: "+codes.get(1));
					System.out.println("Color Correct - Correctly Placed: "+correct);
					System.out.println("Color Correct - Incorrectly Placed: "+incorrect);
					System.out.println();
					count=0;
					codes.clear();
				}
				count++;
				output+=text;
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}
