package com.pm.demo;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.StringJoiner;

public class TESTJAVA8 {

	
	public static void main(String[] args) {
//		List<Student> studentlist = new ArrayList<Student>();
//	      studentlist.add(new Student("Jon", 22, 1001)); 
//	      studentlist.add(new Student("Steve", 19, 1003)); 
//	      studentlist.add(new Student("Kevin", 23, 1005)); 
//	      studentlist.add(new Student("Ron", 20, 1010)); 
//	      studentlist.add(new Student("Lucy", 18, 1111));
//	      
//	      
//	      studentlist.sort((Student s1, Student s2)->s2.getName().compareTo(s1.getName()));List<Integer> list = Arrays.asList(arr);
	        // Stored the array as list
		
		Integer[] arr = new Integer[] { 100, 100, 9, 8, 200 };
        List<Integer> list = Arrays.asList(arr);
        list.forEach(System.out::println);
        OptionalDouble avg = list.stream().mapToInt(n -> n * n).filter(n -> n > 100).average();

        if (avg.isPresent())
            System.out.println(avg.getAsDouble());
        
        
//        StringJoiner stj = new StringJoiner(arg0, arg1, arg2);
	}

}


class Student {
	   String name; 
	   int age; 
	   int id; 
	   public String getName() {
	      return name; 
	   } 
	   public int getAge() { 
	      return age; 
	   } 
	   public int getId() { 
	      return id; 
	   } 
	   Student(String n, int a, int i){ 
	      name = n; 
	      age = a; 
	      id = i; 
	   } 
	   @Override public String toString() {     
	      return ("Student[ "+"Name:"+this.getName()+             
	              " Age: "+ this.getAge() +                     
	              " Id: "+ this.getId()+"]"); 
	   }
	}