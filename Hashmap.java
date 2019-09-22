import java.util.Map;
import java.util.Map.Entry;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Hashmap implements Serializable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 Map<Integer,String> hm=new HashMap<Integer,String>();  
		
		 hm.put(123,"sagar");
		 hm.put(236, "amol");
		 hm.put(238, "aad");
		 hm.put(234, "amdf");
		 hm.put(231, "afg");
		 hm.put(239, "asd");
		 hm.put(230, "aqwel");
		 hm.put(212, "aerl");
		 hm.put(245, "aqel");
		 hm.put(278, "amqwel");
		 
		 Set<Entry<Integer,String>> s=hm.entrySet();
		 Iterator<Entry<Integer,String>> itr=s.iterator();
		 while(itr.hasNext())
		 {
			 System.out.println(itr.next());
		 }
	     try(FileOutputStream fos=new FileOutputStream("d:\\list5.txt"))
	     {
	    	 try(ObjectOutputStream oos=new ObjectOutputStream(fos))
	    	 {
	    		 oos.writeObject(hm);
	    		 System.out.println("====");
	    	 }
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	     
	     Map hm2=null;
	     try(FileInputStream fis=new FileInputStream("d:\\list5.txt"))
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
