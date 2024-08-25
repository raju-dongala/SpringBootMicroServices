package com.apps;

import java.util.function.Predicate;

public class MyTest {

	public static void main(String[] args) {
		String[] names= {"Raju","Harika","Pavan","Divya","Narayana","Surya"};
		
		Predicate<String> namesCheck=name->name.contains("a");
		
		for (String string : names) {
			if(namesCheck.test(string)) {
				System.out.println(string);
			}
		}
	}

}
