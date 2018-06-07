package com.example.demo.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MathIntegration {

  public static void main(String[] args) {
    double d1 = integrate(x -> x, 10, 100, 1000);
    System.out.println(d1);
    double d2 = integrate(x -> x * x, 10, 100, 1000);
    System.out.println(d2);
    double d3 = integrate(x -> Math.pow(x, 3), 10, 100, 1000);
    System.out.println(d3);
    double d4 = integrate(Math::sin, 10, 100, 1000);
    System.out.println(d4);
    
    Person person=new Person(1,"Tom",111.00);
    Person person1=new Person(2,"jak",121.00);
    Person person2=new Person(3,"lili",1000.00);
    Person person3=new Person(4,"semil",1111.00);
    List<Person> people=new ArrayList<Person>();
    people.add(person1);
    people.add(person2);
    people.add(person3);
    
    List<Person> list=findMatchPerson(people,p->p.getId()==10);
    findMatchPerson(people,p->p.getName().equals("Bingo"));
    findMatchPerson(people,p->p.getSalary()>1000.0);
    
    
//    mapSum(people,Person::getSalary);
    
    Car car=new Car("大众","蓝色","23143545",1);
    Car car1=new Car("卓越","蓝色","23143545",100);
    Car car2=new Car("奔驰","蓝色","23143545",1212);
    Car car3=new Car("奥拓","蓝色","23143545",3234);
    Car car4=new Car("夏利","蓝色","23143545",4546);
    List<Car> carlist=new ArrayList<Car>();
    carlist.add(car);
    carlist.add(car1);
    carlist.add(car2);
    carlist.add(car3);
    carlist.add(car4);
    int price=mapSum(carlist,Car::getPrice);
    System.out.println("++++++++++++++"+price);
    
  }
  public static List<Person> findMatchPerson(List<Person> list,Predicate<Person> func) {
	  List<Person> list1=new ArrayList<Person>();
	 for (Person person : list) {
		boolean test=func.test(person);
		//????
		if(test)list1.add(person);	 
	}
	  return list1;
  }

  public static double integrate(integrable func, double x1, double x2, int numSlices) {
    if (numSlices < 1) numSlices = 1;
    double delta = (x2 - x1) / numSlices;
    double start = x1 + delta / 2.0;
    double sum = 0.0;
    for (int i = 0; i <numSlices; i++) {
      sum += delta * func.eval(start + delta * i);
    }
    return sum;
  }
  
  public static <T>int mapSum(List<T>entries,Function<T,Integer> f){
	  int sum=0;
	  for(T entry:entries) {
		  sum+=f.apply(entry);
		  }
	  return sum;
  }
  
  
 //定义Car 完成mapSum(cars,Car::getPrice)
  
  
}