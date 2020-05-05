import java.util.LinkedList;
import java.util.Queue;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.math.*;
import javax.swing.*;
import java.util.*;
import java.util.ArrayList;
import java.lang.*;
public class QueueQuestions
{
	public QueueQuestions(){
		Queue<Words> q=new LinkedList<Words>();
 		PriorityQueue<Words> pq = new PriorityQueue<Words>();
		File name = new File("textBlock.txt");
		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(name));
			String text,output="";
			while( (text=input.readLine())!= null)
			{
				String[] str=text.split(" ");
				for(int x=0;x<str.length;x++){
					Words word=new Words(str[x]);
					q.add(word);
					pq.add(word);
				}
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
		while(!pq.isEmpty())
		{
			System.out.println(String.format("%-20s %s",q.poll(),pq.poll()));
		}
		System.out.println();
	}
	public static void main(String[] args){
		QueueQuestions app=new QueueQuestions();
	}
	public class Words implements Comparable<Words>{
		private String letter;
		public Words(String letter){
			this.letter=letter;
		}
		public String getLetter(){
			return letter;
		}
		public int compareTo(Words letter){
			String a = letter.getLetter();
			String b = this.letter;
	//		return b.toLowerCase().compareTo(a.toLowerCase()); //ACCENDING
			return a.toLowerCase().compareTo(b.toLowerCase()); //DECENDING
		}
		public String toString(){
			return letter+" ";
		}
	}
}




