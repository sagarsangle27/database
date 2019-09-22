import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;



public class HashDemo implements Serializable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer,String> hm=new HashMap<Integer,String>();
		
		Scanner sc=new Scanner(System.in);
		Integer key=null;
		String value=null;
		for(int i=1;i<11;i++)
		{
			key=sc.nextInt();
			value=sc.next();
			hm.put(key, value);
		}
		
		Set<Entry<Integer,String>> s=hm.entrySet();
		Iterator<Entry<Integer,String>> itr=s.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
			
		}
		try(FileOutputStream fos=new FileOutputStream("d:list3.txt"))
		{
			try(ObjectOutputStream oop=new ObjectOutputStream(fos))
			{
				oop.writeObject(hm);
				System.out.println("=====");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    Map hm2=null;
	    
	    try(FileInputStream fis=new FileInputStream("d:\\list3.txt"))
	     {
	    	 try(ObjectInputStream ois=new ObjectInputStream(fis))
	    	 {
	    		 
	    		hm2=(HashMap)ois.readObject(); 
	    		 
	    	 }
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	     Set<Entry<Integer,String>> s1=hm.entrySet();
	     Iterator<Entry<Integer,String>> itr1=s1.iterator();
		 while(itr1.hasNext())
		 {
			 System.out.println(itr1.next());
		 } 
	     
	}

}
