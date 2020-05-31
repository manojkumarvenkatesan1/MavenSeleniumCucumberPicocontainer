package pojoJavaClasses;

public class Customer {
	
	//Data Driven Testing using Json with Cucumber
	
	//POJO stands for Plain Old Java Object. It is an ordinary Java object, 
	//not bound by any special restriction other than those forced by the Java Language Specification and not requiring any class path. 
	//POJOs are used for increasing the readability and re-usability of a program
	   public String firstName;
	   public String lastName;
	   public int age;
	   public String emailAddress;
	   public Address address;
	   public PhoneNumber phoneNumber; 
	   
	   public class Address {
	   public String streetAddress;
	   public String city;
	   public String postCode;
	   public String state;
	   public String country;
	   public String county;
	   }
	 
	   public class PhoneNumber {
	   public String home;
	   public String mob;
	   }
}
