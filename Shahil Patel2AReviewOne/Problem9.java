import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.*;
import java.util.ArrayList;
public class Problem9
{
	public static void main(String args[])
	{
		File name = new File("Prob9Input.txt");
		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(name));
			String[][] spiral;
			String text,output="";
			while((text=input.readLine())!=null)
			{
				spiral=new String[Integer.parseInt(text)][Integer.parseInt(text)];
				for(int x=0;x<spiral.length;x++){
					for(int y=0;y<spiral[0].length;y++){
						spiral[x][y]="-";
					}
				}
				for(int x=0;x<spiral.length;x++){
					for(int y=x;y<spiral.length-x;y++){
						if(x%2==0){
							spiral[x][y]="*";
							spiral[spiral.length-1-x][y]="*";
							spiral[y][spiral.length-1-x]="*";
						}
					}
				}
				for(int x=0;x<spiral.length;x++){
					for(int y=spiral.length-1-x;y>=x+2;y--){
						if(x%2==0)
							spiral[y][x]="*";
					}
				}
				int temp1=2;
				int temp2=1;
				for(int x=0;x<spiral.length-2;x+=4){
					spiral[temp1][temp2]="*";
					temp2+=2;
					temp1+=2;
				}
				if(spiral[0].length%4==2){
					spiral[spiral.length/2][spiral.length/2-1]="-";
				}
				for(String[] temp:spiral){
					for(String value:temp){
				    	System.out.print(" "+value);
					}
				    System.out.println();
				}
				System.out.println("\n");
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}
