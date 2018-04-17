package com.study.collection;

import java.util.Collection;
import java.util.HashSet;

public class CollectionBasic {

	public static void main(String[] args) {
		Collection c = new HashSet();
		c.add("hello");
		c.add(888);
		c.add(new Name("Jerry","Jams"));

		c.add("hello");
		c.remove(888);
		c.remove(new Name("Jerry","Jams"));
		c.add(3.141592654);
		System.out.println(c);
	}

}

class Name implements Comparable
{
	private String firstName;
	private String lastName;
	
	public Name(String firstName,String lastName)
	{
		this.firstName=firstName;
		this.lastName=lastName;
	}
	
	public String toString()
	{
		return firstName+" "+lastName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	public boolean equals(Object obj)
	{
		if (obj instanceof Name)
		{
			Name temp = (Name)obj;
			
			return firstName.equals(temp.getFirstName()) &&
					lastName.equals(temp.getLastName());
		}
		else
		{
			return super.equals(obj);
		}
	}
	
	public int hashCode()
	{
		return firstName.hashCode();
	}
	
	public int compareTo(Object o)
	{
		Name n=(Name)o;
		int lastC=lastName.compareTo(n.lastName);
		if (lastC == 0)
			return firstName.compareTo(n.firstName);
		else
			return lastC;
	}
}
