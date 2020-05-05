import java.util.*;
public class SetPractice
{
	public SetPractice()
	{
		ArrayList<HashSet> a=new ArrayList<HashSet>();
		int size=(int)(Math.random()*11)+2;
		for(int x=0;x<size;x++){
			HashSet<Integer> set=new HashSet<Integer>();
			while(set.size()<20){
				set.add((int)(Math.random()*60)+1);
			}
			a.add(set);
		}
		System.out.println(a+"\n");
		System.out.println(union(a.get(0),a.get(1)));
		System.out.println(notUnion(a.get(0),a.get(1)));
		System.out.println(evenUnion(a.get(0),a.get(1)));
		System.out.println(notEvenUnion(a.get(0),a.get(1)));
	}
	public HashSet<Integer> union(HashSet<Integer> one,HashSet<Integer> two){
		HashSet<Integer> t=new HashSet<Integer>();
		Iterator<Integer> it=one.iterator();
		Iterator<Integer> it2=two.iterator();
		while(it.hasNext())
		{
			int temp=it.next();
			if(two.contains(temp)){
				t.add(temp);
			}
		}
		return t;
	}
	public HashSet<Integer> notUnion(HashSet<Integer> one,HashSet<Integer> two){
		HashSet<Integer> t=new HashSet<Integer>();
		Iterator<Integer> it=one.iterator();
		Iterator<Integer> it2=two.iterator();
		while(it.hasNext())
		{
			int temp=it.next();
			if(!(two.contains(temp))){
				t.add(temp);
			}
		}
		return t;
	}
	public HashSet<Integer> evenUnion(HashSet<Integer> one,HashSet<Integer> two){
		HashSet<Integer> t=new HashSet<Integer>();
		Iterator<Integer> it=one.iterator();
		Iterator<Integer> it2=two.iterator();
		while(it.hasNext())
		{
			int temp=it.next();
			if(temp%2==0&&(two.contains(temp))){
				t.add(temp);
			}
		}
		return t;
	}
	public HashSet<Integer> notEvenUnion(HashSet<Integer> one,HashSet<Integer> two){
		HashSet<Integer> t=new HashSet<Integer>();
		Iterator<Integer> it=one.iterator();
		Iterator<Integer> it2=two.iterator();
		while(it.hasNext())
		{
			int temp=it.next();
			if(temp%2==0&&!(two.contains(temp))){
				t.add(temp);
			}
		}
		return t;
	}
	public static void main(String args[])
	{
		SetPractice app = new SetPractice();
	}
}
