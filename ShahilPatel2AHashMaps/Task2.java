import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.*;
import java.util.Map.*;
import java.util.ArrayList;
public class Task2
{
	public static void main(String args[])
	{
		ArrayList<Citizen> people=new ArrayList<Citizen>();
		TreeMap<String,TreeSet<Citizen>> mapStreet=new TreeMap<String,TreeSet<Citizen>>();
		TreeMap<String,PriorityQueue<Double>> mapBirthPlace=new TreeMap<String,PriorityQueue<Double>>();
		TreeMap<String,ArrayList<String>> mapLanguage=new TreeMap<String,ArrayList<String>>();
		TreeMap<String,HashSet<String>> mapJob=new TreeMap<String,HashSet<String>>();
		TreeMap<String,HashSet<String>> mapGender=new TreeMap<String,HashSet<String>>();
		TreeMap<String,TreeSet<Double>> mapRent=new TreeMap<String,TreeSet<Double>>();
		TreeMap<String,TreeSet<String>> mapImmigrate=new TreeMap<String,TreeSet<String>>();
		File name = new File("FedCensus1930_CambriaCountyPA.txt");
		try
		{
			BufferedReader input = new BufferedReader( new FileReader(name));
			String t="";
			while( (t=input.readLine())!= null)
			{
				if(t.contains("Street")||t.contains("Court")||t.contains("Broad"))
				{
					Citizen citizen=new Citizen(t.substring(71,88),t.substring(55,71),t.substring(20,36),t.substring(36,45),t.substring(88,108),t.substring(108,113),t.substring(113,121),t.substring(133,138),t.substring(143,151),t.substring(151,156),t.substring(156,162),t.substring(162,167),t.substring(167,173),t.substring(173,190),t.substring(190,207),t.substring(207,224),t.substring(224,235),t.substring(235,241),t.substring(252,274),t.substring(274,303),t.substring(342)+"\n");
					people.add(citizen);
				}
			}
		}
		catch (IOException io)
		{
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("STREET KEY CITIZENS; IN TREE SET\n");
		for(int x=0;x<people.size();x++)
		{
			if(!mapStreet.containsKey(people.get(x).getStreet()))
			{
				TreeSet<Citizen> temp=new TreeSet<Citizen>();
				temp.add(people.get(x));
				mapStreet.put(people.get(x).getStreet(),temp);
			}
			mapStreet.get(people.get(x).getStreet()).add(people.get(x));
		}
		Iterator it=mapStreet.values().iterator();
		while(it.hasNext())
			System.out.println(it.next()+"\n");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("BIRTHPLACE KEY AGES; IN PRIORITY QUEUE\n");
		for(int x=0;x<people.size();x++)
		{
			if(!mapBirthPlace.containsKey(people.get(x).getBirthPlace()))
			{
				PriorityQueue<Double> temp=new PriorityQueue<Double>();
				String[] age=people.get(x).getAge().split("");
				Double ageT=0.0;
				if(people.get(x).getAge().contains("/")&&people.get(x).getAge().contains("*")==false)
				{
					int space=-1;
					for(int y=0;y<age.length;y++)
					{
						if(age[y].equals(" "))
							space=y;
						if(age[y].equals("/"))
						{
							if(space>0)
								ageT=Double.parseDouble(people.get(x).getAge().substring(space,y))/Double.parseDouble(people.get(x).getAge().substring(y+1));
							else ageT=Double.parseDouble(people.get(x).getAge().substring(0,y))/Double.parseDouble(people.get(x).getAge().substring(y+1));
						}
					}
				}
				else if(people.get(x).getAge().contains("*"))
				{
					ageT=Double.parseDouble(age[0])+1.0/12;
				}
				else if(people.get(x).getAge().contains("un"))
				{
					ageT=Double.NaN;
				}
				else
				{
					ageT=Double.parseDouble(people.get(x).getAge().trim());
				}
				ageT*=100;
				int at=(int)Math.round(ageT);
				ageT=at/100.0;
				mapBirthPlace.put(people.get(x).getBirthPlace(),temp);
			}
			String[] age=people.get(x).getAge().split("");
			Double ageT=0.0;
			if(people.get(x).getAge().contains("/")&&people.get(x).getAge().contains("*")==false)
			{
				int space=-1;
				for(int y=0;y<age.length;y++)
				{
					if(age[y].equals(" "))
						space=y;
					if(age[y].equals("/"))
					{
						if(space>0)
							ageT=Double.parseDouble(people.get(x).getAge().substring(space,y))/Double.parseDouble(people.get(x).getAge().substring(y+1));
						else ageT=Double.parseDouble(people.get(x).getAge().substring(0,y))/Double.parseDouble(people.get(x).getAge().substring(y+1));
					}
				}
			}
			else if(people.get(x).getAge().contains("*"))
			{
				ageT=Double.parseDouble(age[0])+4.0/12;
			}
			else if(people.get(x).getAge().contains("un"))
			{
				ageT=Double.NaN;
			}
			else
			{
				ageT=Double.parseDouble(people.get(x).getAge().trim());
			}
			ageT*=100;
			int at=(int)Math.round(ageT);
			ageT=at/100.0;
			mapBirthPlace.get(people.get(x).getBirthPlace()).add(ageT);
		}
		it=mapBirthPlace.keySet().iterator();
		String temp2="";
		while(it.hasNext())
		{
			temp2=it.next().toString();
			if(temp2.contains("Pennsylvania")==false)
			{
				System.out.println(temp2);
				System.out.println(mapBirthPlace.get(temp2)+"\n");
			}
			else System.out.println("Number of citizens in PA: "+mapBirthPlace.get(temp2).size()+"\n");
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("LANGUAGE KEY; NAMES IN ARRAYLIST\n");
		for(int x=0;x<people.size();x++)
		{
			if(!mapLanguage.containsKey(people.get(x).getMothersTongue()))
			{
				ArrayList<String> names=new ArrayList<String>();
				names.add(people.get(x).getLastName().trim()+", "+people.get(x).getFirstName().trim());
				mapLanguage.put(people.get(x).getMothersTongue(),names);
			}
			mapLanguage.get(people.get(x).getMothersTongue()).add(people.get(x).getLastName().trim()+", "+people.get(x).getFirstName().trim());
		}
		it=mapLanguage.keySet().iterator();
		while(it.hasNext())
		{
			temp2=it.next().toString();
			System.out.print(temp2);
			System.out.println(" "+mapLanguage.get(temp2).size()+"\n");
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("OCUPATION KEY; FATHER'S BIRTHPLACE IN HASHSET\n");
		for(int x=0;x<people.size();x++)
		{
			if(!mapJob.containsKey(people.get(x).getOccupation().trim()))
			{
				HashSet<String> temp=new HashSet<String>();
				temp.add(people.get(x).getFathersBirthplace().trim());
				mapJob.put(people.get(x).getOccupation().trim(),temp);
			}
			mapJob.get(people.get(x).getOccupation().trim()).add(people.get(x).getFathersBirthplace().trim());
		}
		it=mapJob.keySet().iterator();
		while(it.hasNext())
		{
			temp2=it.next().toString();
			System.out.print(temp2);
			System.out.println(" "+mapJob.get(temp2)+"\n");
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("GENDER KEY; REMARKS IN HASHSET\n");
		for(int x=0;x<people.size();x++)
		{
			if(!mapGender.containsKey(people.get(x).getGender().trim()))
			{
				HashSet<String> temp=new HashSet<String>();
				temp.add(people.get(x).getRemarks().trim());
				mapGender.put(people.get(x).getGender().trim(),temp);
			}
			mapGender.get(people.get(x).getGender().trim()).add(people.get(x).getRemarks().trim());
		}
		it=mapGender.keySet().iterator();
		while(it.hasNext())
		{
			temp2=it.next().toString();
			System.out.print(temp2);
			System.out.println(" "+mapGender.get(temp2)+"\n");
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("RENT/OWN KEY; VALUE OF PROPERTIES IN TREESET\n");
 		for(int x=0;x<people.size();x++)
 		{
			double t=0.0;
			if(!mapRent.containsKey(people.get(x).getRenting().trim()))
			{
				TreeSet<Double> temp=new TreeSet<Double>();
				if(people.get(x).getRenting().trim().equals("O")||people.get(x).getRenting().trim().equals("O*"))
				{
					String newStr=people.get(x).getPropertyValue().replaceAll(",","").replaceAll("\\$","").replaceAll("\\*","").trim();
					if(newStr.length()>0)
					{
						t=Double.parseDouble(newStr);
					}
					else t=Double.NaN;
					temp.add(t);
				}
				else if((people.get(x).getRenting().trim().equals("R")||people.get(x).getRenting().trim().equals("R*"))&&people.get(x).getRenting().trim().contains("/")==false)
				{
					String newStr = people.get(x).getPropertyValue().replaceAll(",","").replaceAll("\\$","").replaceAll("\\*","").trim();
					if(newStr.length()>0)
					{
						t=Double.parseDouble(newStr);
					}
					else t=Double.NaN;
					temp.add(t);
				}
				else
				{
					temp.add(Double.NaN);
				}
				mapRent.put(people.get(x).getRenting().trim(),temp);
			}
			if(people.get(x).getRenting().trim().equals("O")||people.get(x).getRenting().trim().equals("O*"))
			{
				String newStr=people.get(x).getPropertyValue().replaceAll(",","").replaceAll("\\$","").replaceAll("\\*","").trim();
				if(newStr.length()>0&&newStr.contains("un")==false)
				{
					t=Double.parseDouble(newStr);
				}
				else t=Double.NaN;
			}
			else if((people.get(x).getRenting().trim().equals("R")||people.get(x).getRenting().trim().equals("R*"))&&people.get(x).getRenting().trim().contains("/")==false)
			{
				String newStr = people.get(x).getPropertyValue().replaceAll(",","").replaceAll("\\$","").replaceAll("\\*","").trim();
				if(newStr.length()>0&&newStr.contains("/")==false&&newStr.contains("un")==false)
				{
					t=Double.parseDouble(newStr);
				}
				else if(newStr.contains("/"))
				{
					String[] splitFrac=newStr.split(" ");
					t=Double.parseDouble(splitFrac[0]);
					splitFrac=splitFrac[1].split("/");
					t+=Double.parseDouble(splitFrac[0])/Double.parseDouble(splitFrac[1]);
				}
				else t=Double.NaN;
			}
			else
			{
				t=Double.NaN;
			}
			mapRent.get(people.get(x).getRenting().trim()).add(t);
		}
 		it=mapRent.keySet().iterator();
 		while(it.hasNext())
 		{
 			temp2=it.next().toString();
 			System.out.print(temp2);
 			System.out.println(" "+mapRent.get(temp2)+"\n");
		}
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("FATHER'S BIRTHPLACE KEY; YEAR IMMIGRATED IN TREESET: I chose this to see the relationship between (for the most part) familial origins and migration trends between these origins\n");
		for(int x=0;x<people.size();x++)
		{
			if(!mapImmigrate.containsKey(people.get(x).getFathersBirthplace().trim()))
			{
				TreeSet<String> temp=new TreeSet<String>();
				temp.add(people.get(x).getYearImmigrated().trim());
				mapImmigrate.put(people.get(x).getFathersBirthplace().trim(),temp);
			}
			mapImmigrate.get(people.get(x).getFathersBirthplace().trim()).add(people.get(x).getYearImmigrated().trim());
		}
		it=mapImmigrate.keySet().iterator();
		while(it.hasNext())
		{
			temp2=it.next().toString();
			System.out.print(temp2);
			System.out.println(" "+mapImmigrate.get(temp2)+"\n");
		}
	}
	public static class Citizen implements Comparable<Citizen>
	{
		private String firstName;
		private String lastName;
		private String street;
		private String streetNumber;
		private String relation;
		private String renting;
		private String propertyValue;
		private String gender;
		private String age;
		private String maritalStatus;
		private String ageAtFirstMarriage;
		private String attendSchool;
		private String canRead;
		private String birthplace;
		private String fathersBirthplace;
		private String mothersBirthplace;
		private String mothersTongue;
		private String yearImmigrated;
		private String occupation;
		private String industry;
		private String remarks;
		public Citizen(String firstName, String lastName, String street, String streetNumber, String relation, String renting, String propertyValue, String gender, String age, String maritalStatus, String  ageAtFirstMarriage, String attendSchool, String canRead, String birthplace, String mothersBirthplace, String fathersBirthplace, String mothersTongue, String yearImmigrated, String occupation, String industry, String remarks)
		{
			this.firstName=firstName;
			this.lastName=lastName;
			this.street=street;
			this.streetNumber=streetNumber;
			this.relation=relation;
			this.renting=renting;
			this.propertyValue=propertyValue;
			this.gender=gender;
			this.age=age;
			this.maritalStatus=maritalStatus;
			this.ageAtFirstMarriage=ageAtFirstMarriage;
			this.attendSchool=attendSchool;
			this.canRead=canRead;
			this.birthplace=birthplace;
			this.fathersBirthplace=fathersBirthplace;
			this.mothersBirthplace=mothersBirthplace;
			this.mothersTongue=mothersTongue;
			this.yearImmigrated=yearImmigrated;
			this.occupation=occupation;
			this.industry=industry;
			this.remarks=remarks;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getStreetNumber() {
			return streetNumber;
		}
		public void setStreetNumber(String streetNumber) {
			this.streetNumber = streetNumber;
		}
		public String getRelation() {
			return relation;
		}
		public void setRelation(String relation) {
			this.relation = relation;
		}
		public String getRenting() {
			return renting;
		}
		public void setRenting(String renting) {
			this.renting = renting;
		}
		public String getPropertyValue() {
			return propertyValue;
		}
		public void setPropertyValue(String propertyValue) {
			this.propertyValue = propertyValue;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getMaritalStatus() {
			return maritalStatus;
		}
		public void setMaritalStatus(String maritalStatus) {
			this.maritalStatus = maritalStatus;
		}
		public String getAgeAtFirstMarriage() {
			return ageAtFirstMarriage;
		}
		public void setAgeAtFirstMarriage(String ageAtFirstMarriage) {
			this.ageAtFirstMarriage = ageAtFirstMarriage;
		}
		public String getAttendSchool() {
			return attendSchool;
		}
		public void setAttendSchool(String attendSchool) {
			this.attendSchool = attendSchool;
		}
		public String getCanRead() {
			return canRead;
		}
		public void setCanRead(String canRead) {
			this.canRead = canRead;
		}
		public String getBirthPlace() {
			return birthplace;
		}
		public void setBirthPlace(String birthplace) {
			this.birthplace = birthplace;
		}
		public String getFathersBirthplace() {
			return fathersBirthplace;
		}
		public void setFathersBirthplace(String fathersBirthplace) {
			this.fathersBirthplace = fathersBirthplace;
		}
		public String getMothersBirthplace() {
			return mothersBirthplace;
		}
		public void setMothersBirthplace(String mothersBirthplace) {
			this.mothersBirthplace = mothersBirthplace;
		}
		public String getMothersTongue() {
			return mothersTongue;
		}
		public void setMothersTongue(String mothersTongue) {
			this.mothersTongue = mothersTongue;
		}
		public String getYearImmigrated() {
			return yearImmigrated;
		}
		public void setYearImmigrated(String yearImmigrated) {
			this.yearImmigrated = yearImmigrated;
		}
		public String getOccupation() {
			return occupation;
		}
		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}
		public String getIndustry() {
			return industry;
		}
		public void setIndustry(String industry) {
			this.industry = industry;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		public String combo(){
			return firstName+lastName+street+streetNumber+relation+renting+propertyValue+gender+age+maritalStatus+ageAtFirstMarriage+attendSchool+canRead+birthplace+fathersBirthplace+mothersBirthplace+mothersTongue+yearImmigrated+occupation+industry+remarks;
		}
		public int compareTo(Citizen obj){
			return combo().compareTo(obj.combo());
		}
		public String toString(){
			return "First name: "+getFirstName()+" Last name: "+getLastName()+" Street: "+getStreet()+" Street no.: "+getStreetNumber()+" Relation: "+getRelation()+" Renting Status: "+getRenting()+" Property Value: "+getPropertyValue()+" Gender: "+getGender()+" Age: "+getAge()+" Marital Status: "+getMaritalStatus()+" Age at 1st Marriage: "+getAgeAtFirstMarriage()+" Attend School: "+getAttendSchool()+" Literate: "+getCanRead()+" Birth Place: "+getBirthPlace()+" Father's Birth Place: "+getFathersBirthplace()+" Mother's Birth Place: "+getMothersBirthplace()+" Language: "+getMothersTongue()+" Year Immigrated: "+getYearImmigrated()+" Job: "+getOccupation()+" Industry: "+getIndustry()+" Remarks: "+getRemarks();
		}
	}
}