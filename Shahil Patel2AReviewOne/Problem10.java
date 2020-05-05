import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Formatter;
public class Problem10
{
	public static void main(String args[])
	{
		File name=new File("Prob10Input.txt");
		String text="";
		int rowsOfNotes=0;
		int numberOfMeasures=0;
		int notesPerRow=0;
		String[][] notes={
			{"E","A","D","G","B","E"},
			{"F","A#","D#","G#","C","F"},
			{"F#","B","E","A","C#","F#"},
			{"G","C","F","A#","D","G"},
			{"G#","C#","F#","B","D#","G#"}
		};
		ArrayList<String> temp=new ArrayList<>();
		ArrayList<String> orderedNotes=new ArrayList<>();
		ArrayList<String> individual=new ArrayList<>();
		try
		{
			BufferedReader input=new BufferedReader(new FileReader(name));
			while((text=input.readLine())!=null)
			{
				String[] str=text.split(",");
				notesPerRow=str[0].length(); //notes per row 6
				rowsOfNotes++; //rows of notes per measure 5
				numberOfMeasures=str.length; //number of measures 8
				for(int x=0;x<str.length;x++){
					temp.add(str[x]);
				}
			}
		//	System.out.println();
			for(int x=0;x<numberOfMeasures;x++){
				for(int y=0;y<numberOfMeasures*rowsOfNotes;y++){
					if(y%numberOfMeasures==0){
						orderedNotes.add(temp.get(x+y));
					}
				}
			}
			for(int x=0;x<orderedNotes.size();x++){
				String []e=orderedNotes.get(x).split("");
				for(int a=0;a<e.length;a++){
					individual.add(e[a]);
				}
			}
			String[][][] matrix=new String[numberOfMeasures][rowsOfNotes][notesPerRow];
			int matrixCount=0;
			for(int a=0;a<numberOfMeasures;a++){
				for(int b=0;b<rowsOfNotes;b++){
					for(int c=0;c<notesPerRow;c++){
						matrix[a][b][c]=individual.get(matrixCount);
						matrixCount++;
					}
				}
			}
			//a is measure b is row c is collumn
			System.out.print("Measure\t");
			for(int x=0;x<numberOfMeasures;x++){
				System.out.print("\t"+x);
			}
			System.out.println();
			int t=0;
			for(int y=notes[0].length-1;y>=0;y--){
				for(int x=notes.length-1;x>=0;x--){
					if(x>0&&!(notes[x-1][y].equals(notes[x][y]))){
						System.out.print(notes[x][y]+"\t\t");
						for(int a=0;a<matrix.length;a++){
							if(matrix[a][x][y].equals("*")||matrix[a][x][y].equals("o")){
								for(int b=t;b<a;b++){
									System.out.print("\t");
									t++;
								}
								System.out.print("O");
							}
						}
						t=0;
						System.out.println();
					}
					else if(x==0&&!(notes[x][y].equals("B"))){
						System.out.print(notes[x][y]+"\t\t");
						for(int a=0;a<matrix.length;a++){
							if(matrix[a][x][y].equals("*")||matrix[a][x][y].equals("o")){
								for(int b=t;b<a;b++){
									System.out.print("\t");
									t++;
								}
								System.out.print("O");
							}
						}
						t=0;
						System.out.println();
					}
				}
			}
			System.out.println("\n");
		}
		catch (IOException io)
		{
		}
	}
}