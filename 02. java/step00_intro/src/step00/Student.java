package step00;

import java.util.HashSet;

public class Student {

	public class CopyObject implements Cloneable {

	    private String name;
	    private int age;

	    public CopyObject() {
	    }

	    public CopyObject(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }

	    @Override
	    protected CopyObject clone() throws CloneNotSupportedException {
	        return (CopyObject) super.clone();
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }
	}


	   
	    void shallowCopy() throws CloneNotSupportedException {
	        CopyObject original = new CopyObject("JuHyun", 20);
	        CopyObject copy = original.clone();

	        copy.setName("JuBal");

	        System.out.println(original.getName());
	        System.out.println(copy.getName());
	    }

}
