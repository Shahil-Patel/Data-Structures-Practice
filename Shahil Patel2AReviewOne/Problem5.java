import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Formatter;
public class Problem5
{
	public static void main(String args[])
	{
		ArrayList<Car> cars=new ArrayList<>();
		File name = new File("Prob5Input.txt");
		int count=100;
		ArrayList<Car> high=new ArrayList<>();
		ArrayList<Car> low=new ArrayList<>();
		try
		{
			BufferedReader input = new BufferedReader(
									 new FileReader(name));
			String text,output="";
			while( (text=input.readLine())!= null)
			{
				String[] temp=text.split("	");
				if(count!=100)
				{
					for(int x=0;x<temp.length;x++){
					//	System.out.print(temp[x]+" ");
						if(temp[x].equals("NA")){
							temp[x]="-1";
						}
					}
					Car carz=new Car(temp[0],Double.parseDouble(temp[1]),Integer.parseInt(temp[2]),Double.parseDouble(temp[3]),Integer.parseInt(temp[4]),Double.parseDouble(temp[5]),Double.parseDouble(temp[6]),Integer.parseInt(temp[7]),temp[8]);
					cars.add(carz);
				}
				count=0;
			}
			int limit=3;
			//MPG
			cars.sort(Comparator.comparing(Car::getMpg));
			for(int x=0;x<limit;x++){
				if(cars.get(x).getMpg()>-1){
					low.add(cars.get(x));
				}
				else limit++;
				if(x<3)
					high.add(cars.get(cars.size()-1-x));
			}
			limit=3;
			//CYLINDERS
			cars.sort(Comparator.comparing(Car::getCylinders));
			for(int x=0;x<limit;x++){
				if(cars.get(x).getCylinders()>-1){
					low.add(cars.get(x));
				}
				else limit++;
				if(x<3)
					high.add(cars.get(cars.size()-1-x));
			}
			limit=3;
			//DISPLACEMENT
			cars.sort(Comparator.comparing(Car::getDisplacement));
			for(int x=0;x<limit;x++){
				if(cars.get(x).getDisplacement()>-1){
					low.add(cars.get(x));
				}
				else limit++;
				if(x<3)
					high.add(cars.get(cars.size()-1-x));
			}
			limit=3;
			//HORSEPOWER
			cars.sort(Comparator.comparing(Car::getHp));
			for(int x=0;x<limit;x++){
				if(cars.get(x).getHp()>-1){
					low.add(cars.get(x));
				}
				else limit++;
				if(x<3)
					high.add(cars.get(cars.size()-1-x));
			}
			limit=3;
			//WEIGHT
			cars.sort(Comparator.comparing(Car::getWeight));
			for(int x=0;x<limit;x++){
				if(cars.get(x).getWeight()>-1){
					low.add(cars.get(x));
				}
				else limit++;
				if(x<3)
					high.add(cars.get(cars.size()-1-x));
			}
			limit=3;
			//ACCELERATION
			cars.sort(Comparator.comparing(Car::getAcceleration));
			for(int x=0;x<limit;x++){
				if(cars.get(x).getAcceleration()>-1){
					low.add(cars.get(x));
				}
				else limit++;
				if(x<3)
					high.add(cars.get(cars.size()-1-x));
			}
			limit=3;
			//YEAR
			cars.sort(Comparator.comparing(Car::getYear));
			for(int x=0;x<limit;x++){
				if(cars.get(x).getYear()>-1){
					low.add(cars.get(x));
				}
				else limit++;
				if(x<3)
					high.add(cars.get(cars.size()-1-x));
			}
			limit=3;
			for(int x=0;x<7;x++){
				if(x==0){
					System.out.println(String.format("%-40s %s","Highest MPG","Lowest MPG"));
					System.out.println(String.format("%-40s %s",high.get(x).getModel(),low.get(x).getModel()));
					System.out.println(String.format("%-40s %s",high.get(x+1).getModel(),low.get(x+1).getModel()));
					System.out.println(String.format("%-40s %s",high.get(x+2).getModel(),low.get(x+2).getModel()));
					System.out.println();
				}
				else if(x==1){
					System.out.println(String.format("%-40s %s","Highest # Cylinder","Lowest # Cylinder"));
					System.out.println(String.format("%-40s %s",high.get(x+2).getModel(),low.get(x+2).getModel()));
					System.out.println(String.format("%-40s %s",high.get(x+3).getModel(),low.get(x+3).getModel()));
					System.out.println(String.format("%-40s %s",high.get(x+4).getModel(),low.get(x+4).getModel()));
					System.out.println();
				}
				else if(x==2){
					System.out.println(String.format("%-40s %s","Highest Displacement","Lowest # Displacement"));
					System.out.println(String.format("%-40s %s",high.get(x+4).getModel(),low.get(x+4).getModel()));
					System.out.println(String.format("%-40s %s",high.get(x+5).getModel(),low.get(x+5).getModel()));
					System.out.println(String.format("%-40s %s",high.get(x+6).getModel(),low.get(x+6).getModel()));
					System.out.println();
				}
				else if(x==3){
					System.out.println(String.format("%-40s %s","Highest Horsepower","Lowest Horsepower"));
					System.out.println(String.format("%-40s %s",high.get(x+6).getModel(),low.get(x+6).getModel()));
					System.out.println(String.format("%-40s %s",high.get(x+7).getModel(),low.get(x+7).getModel()));
					System.out.println(String.format("%-40s %s",high.get(x+8).getModel(),low.get(x+8).getModel()));
					System.out.println();
				}
				else if(x==4){
					System.out.println(String.format("%-40s %s","Highest Weight","Lowest Weight"));
					System.out.println(String.format("%-40s %s",high.get(x+8).getModel(),low.get(x+8).getModel()));
					System.out.println(String.format("%-40s %s",high.get(x+9).getModel(),low.get(x+9).getModel()));
					System.out.println(String.format("%-40s %s",high.get(x+10).getModel(),low.get(x+10).getModel()));
					System.out.println();
				}
				else if(x==5){
					System.out.println(String.format("%-40s %s","Highest Acceleration","Lowest Acceleration"));
					System.out.println(String.format("%-40s %s",high.get(x+10).getModel(),low.get(x+10).getModel()));
					System.out.println(String.format("%-40s %s",high.get(x+11).getModel(),low.get(x+11).getModel()));
					System.out.println(String.format("%-40s %s",high.get(x+12).getModel(),low.get(x+12).getModel()));
					System.out.println();
				}
				else if(x==6){
					System.out.println(String.format("%-40s %s","Highest Year","Lowest Year"));
					System.out.println(String.format("%-40s %s",high.get(x+12).getModel(),low.get(x+12).getModel()));
					System.out.println(String.format("%-40s %s",high.get(x+13).getModel(),low.get(x+13).getModel()));
					System.out.println(String.format("%-40s %s",high.get(x+14).getModel(),low.get(x+14).getModel()));
					System.out.println();
				}
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}
	public static class Car{
		String model="";
		double mpg;
		int cylinders;
		double displacement;
		int hp;
		double weight;
		double acceleration;
		int year;
		String country;
		public Car(String model, double mpg, int cylinders, double displacement, int hp, double weight, double acceleration, int year, String country){
			this.model=model;
			this.mpg=mpg;
			this.cylinders=cylinders;
			this.displacement=displacement;
			this.hp=hp;
			this.weight=weight;
			this.acceleration=acceleration;
			this.year=year;
			this.country=country;
		}
		public String getModel(){
			return model;
		}
		public void setModel(String model){
			this.model=model;
		}
		public double getMpg(){
			return mpg;
		}
		public void setMpg(double mpg){
			this.mpg=mpg;
		}
		public int getCylinders(){
			return cylinders;
		}
		public void setCylinders(int cylinders){
			this.cylinders=cylinders;
		}
		public double getDisplacement(){
			return displacement;
		}
		public void setDisplacement(double displacement){
			this.displacement=displacement;
		}
		public int getHp(){
			return hp;
		}
		public void setHp(int hp){
			this.hp=hp;
		}
		public double getWeight(){
			return weight;
		}
		public void setWeight(double weight){
			this.weight=weight;
		}
		public double getAcceleration(){
			return acceleration;
		}
		public void setAcceleration(double acceleration){
			this.acceleration=acceleration;
		}
		public int getYear(){
			return year;
		}
		public void setYear(int year){
			this.year=year;
		}
		public String getCountry(){
			return country;
		}
		public void setCountry(String country){
			this.country=country;
		}
		public String toString(){
			if(model.length()>=30){
				return "\n"+model+"\t"+mpg+"\t"+cylinders+"\t"+displacement+"\t"+hp+"\t"+weight+"\t"+acceleration+"\t"+year+"\t"+country;
			}
			else if(model.length()>=24){
				return "\n"+model+"\t\t"+mpg+"\t"+cylinders+"\t"+displacement+"\t"+hp+"\t"+weight+"\t"+acceleration+"\t"+year+"\t"+country;
			}
			else if(model.length()>=16){
				return "\n"+model+"\t\t\t"+mpg+"\t"+cylinders+"\t"+displacement+"\t"+hp+"\t"+weight+"\t"+acceleration+"\t"+year+"\t"+country;
			}
			else{
				return "\n"+model+"\t\t\t\t"+mpg+"\t"+cylinders+"\t"+displacement+"\t"+hp+"\t"+weight+"\t"+acceleration+"\t"+year+"\t"+country;
			}
		}
	}
}
