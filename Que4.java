import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Employee implements Serializable
{
	int empid;
	String empname,design;
	double salary;
	public Employee(int empid, String empname, String design, double salary) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.design = design;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", design=" + design + ", salary=" + salary + "]";
	}
	
	
	public String disp() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", design=" + design + ", salary=" + salary + "]";
	}
	
	
}



public class Que4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List l=new ArrayList();
		
	    Employee e1=new Employee(10,"abc","xyc",1200);
	    Employee e2=new Employee(20,"abc","xyc",1200);
	    Employee e3=new Employee(30,"abc","xyc",1200);
	    Employee e4=new Employee(40,"abc","xyc",1200);
		
		l.add(e1);
		l.add(e2);
		l.add(e3);
		l.add(e4);
		
	    
		Iterator itr=l.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		try(FileOutputStream fos=new FileOutputStream("d:\\list7.txt"))
		{
			try(ObjectOutputStream oos=new ObjectOutputStream(fos))
			{
				oos.writeObject(l);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
		List l2=null;
		try(FileInputStream fis=new FileInputStream("d:\\list7.txt"))
		{
			try(ObjectInputStream ois=new ObjectInputStream(fis))
			{
				 l2 =(ArrayList)ois.readObject();
				 System.out.println("=========");
			}
		}
        catch(Exception e)
		{
        	e.printStackTrace();
		}
	
		Iterator itr1=l2.iterator();
		while(itr1.hasNext())
		{
			System.out.println(itr1.next());
		}
	    
		System.out.println("+++++++");
	    for(int i=0;i<l2.size();i++)
	    	System.out.println(((Employee) l2.get(i)).disp());
	
	}
	}