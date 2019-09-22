
package GenericsAssignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Assignment1 {

	public static void main(String[] args) {
		List<MyClass> aL = new ArrayList<MyClass>();
		MyClass m1 = new MyClass(1,"Sagar");
		MyClass m2 = new MyClass(2,"Arpit");
		MyClass m3 = new MyClass(3,"Ankit");
		MyClass m4 = new MyClass(4,"Shubham");
		MyClass m5 = new MyClass(5,"Amol");
		aL.add(m1);
		aL.add(m2);
		aL.add(m3);
		aL.add(m4);
		aL.add(m5);
		Iterator<MyClass> itr = aL.iterator();	//Iterator is a Interface while iterator is a method in ArrayList
		while(itr.hasNext()) {
			System.out.println(itr.next());	//m1,m2,m3,m4,m5
		}
		try (FileOutputStream fos = new FileOutputStream("d:\\list8.txt")){
			try(ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(aL);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		List<?> ref =null;
		try (FileInputStream fis = new FileInputStream("d:\\list8.txt")){
			try(ObjectInputStream ois = new ObjectInputStream(fis)){
				ref = (ArrayList<?>)ois.readObject();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("-+++++++++++++++++++++=");
		Iterator<?> itr2 =ref.iterator();	//Iterator is a Interface while iterator is a method in ArrayList
		while(itr2.hasNext()) {
			System.out.println(itr2.next());	//m1,m2,m3,m4,m5
		}
		
	}

}

class MyClass implements Serializable{
	private int rollNo;
	private String name;
	public MyClass(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}
	@Override
	public String toString() {
		return "MyClass [rollNo=" + rollNo + ", name=" + name + "]";
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
