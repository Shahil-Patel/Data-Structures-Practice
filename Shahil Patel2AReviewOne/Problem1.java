import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.*;
import java.util.ArrayList;
public class Problem1
{
	public static void main(String args[])
	{
		int count=1;
		ArrayList<Integer> one=new ArrayList<>();
		ArrayList<Integer> two=new ArrayList<>();
		ArrayList<Integer> three=new ArrayList<>();
		ArrayList<Integer> superSimilar=new ArrayList<>();
		ArrayList<Integer> superSuperSimilar=new ArrayList<>();
		File name = new File("Prob1Input.txt");
		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(name));
			String text,output="";
			while( (text=input.readLine())!= null)
			{
				if(count<4){
					String[] words=text.split(" ");
					if(count==1){
						one=new ArrayList<>();
						for(int x=0;x<words.length;x++){
							one.add(Integer.parseInt(words[x]));
						}
					}
					if(count==2){
						two=new ArrayList<>();
						for(int x=0;x<words.length;x++){
							two.add(Integer.parseInt(words[x]));
						}
					}
					if(count==3){
						three=new ArrayList<>();
						for(int x=0;x<words.length;x++){
							three.add(Integer.parseInt(words[x]));
						}
					}
				}
				count++;
				if(count==4){
					ArrayList<Integer> similar=new ArrayList<>();
					superSimilar=new ArrayList<>();
					System.out.println("Set 1: "+one.toString().replace("[","{").replace("]","}"));
					System.out.println("Set 2: "+two.toString().replace("[","{").replace("]","}"));
					System.out.println("Set 3: "+three.toString().replace("[","{").replace("]","}"));
					for(int a=0;a<one.size();a++){
						for(int b=0;b<two.size();b++){
							if(one.contains(two.get(b))){
								similar.add(two.get(b));
							}
						}
					}
					for(int a=0;a<three.size();a++){
						for(int b=0;b<similar.size();b++){
							if(three.contains(similar.get(b))){
								superSimilar.add(similar.get(b));
							}
						}
					}
					Collections.sort(superSimilar);
					for(int x=0;x<superSimilar.size()-1;x++){
						if(superSimilar.get(x)==superSimilar.get(x+1)){
							superSimilar.remove(x+1);
							x--;
						}
					}
					String str="    Intersection of sets: "+superSimilar.toString().replace("[","{").replace("]","}");
					System.out.println(str);
					count=1;
				}
				output+=text;
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
}
