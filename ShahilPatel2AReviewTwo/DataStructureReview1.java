import java.util.*;
public class DataStructureReview1
{
	public DataStructureReview1()
	{
		ArrayList<Integer> arr=new ArrayList<Integer>();
		int randomSize=(int)(Math.random()*101)+50;
		for(int x=0;x<randomSize;x++)
		{
			int rand=(int)(Math.random()*100)+1;
			arr.add(rand);
		}
		int[][] arr2D=new int[(int)Math.ceil(Math.sqrt(arr.size()))][(int)Math.ceil(Math.sqrt(arr.size()))];
		System.out.println(arr);
		int count=arr.size();
		while(count>0)
		{
			int r=(int)(Math.random()*arr2D.length);
			int c=(int)(Math.random()*arr2D.length);
			if(arr2D[r][c]==0)
			{
				arr2D[r][c]=arr.get(count-1);
				count--;
			}
		}
		System.out.println();
		for(int x=0;x<arr2D.length;x++)
		{
			for(int y=0;y<arr2D[0].length;y++)
			{
				System.out.print(arr2D[x][y]+" ");
			}
			System.out.println();
		}
		Stack<Integer> steakStack=new Stack<Integer>();
		for(int x=0;x<arr2D.length;x++)
		{
			for(int y=0;y<arr2D[0].length;y++)
			{
				steakStack.push(arr2D[y][x]);
			}
		}
		System.out.println("\nStack: "+steakStack);
		HashSet<Integer> hashBrown=new HashSet<Integer>();
		for(int x=0;x<steakStack.size();x++)
		{
			hashBrown.add(steakStack.pop());
		}
		System.out.println("\nHashSet: "+hashBrown+"\n");
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		Iterator it=hashBrown.iterator();
		while(it.hasNext())
		{
			int temp=(int)it.next();
			pq.add(temp);
			it.remove();
		}
		System.out.println("Priority Queue: "+pq+"\n");
		TreeMap<Integer,TreeSet<Integer>> map=new TreeMap<Integer,TreeSet<Integer>>();
		TreeSet<Integer> odd=new TreeSet<Integer>();
		int recentEven=0;
		while(!pq.isEmpty())
		{
			if(pq.peek()%2==0)
			{
				int t=(int)(pq.poll());
				map.put(recentEven,odd);
				odd=new TreeSet<Integer>();
				recentEven=t;
			}
			else
			{
				odd.add(pq.poll());
			}
		}
		Iterator mapIt=map.keySet().iterator();
		while(mapIt.hasNext())
		{
			int t=(int)mapIt.next();
			System.out.println(t+": "+"{"+(map.get(t)+"").substring(1,(map.get(t)+"").length()-1)+"}");
		}
	}
	public static void main(String[] args)
	{
		DataStructureReview1 app=new DataStructureReview1();
	}
}