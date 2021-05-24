package com.java8.mapflatmap;

import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {

	public static void main(String[] args) {
		
     	List<Customer> customers = new Database().getAll();
//		List<String> emails = customers.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());
//		System.out.println(emails);
		
	  
//    List<List<String>> phoneNumbers = customers.stream()
//     	                                         .map(customer -> customer.getPhoneNumbers()).collect(Collectors.toList());	
//    System.out.println(phoneNumbers);

     	
     	
     	
		List<String> phones = customers.stream().flatMap(customer -> customer.getPhoneNumbers().stream())
				                                .collect(Collectors.toList());

		System.out.println(phones);
		
	}
	
}




/*

get the customers from database

from this list we want to get the list of emails, which are strings




i.e:   List<Customer>     convert to       List<String>



here we can go for map method..

from this list of customers, we are mapping all emails as list of strings and 

returning as another stream ... that is called Data transformation







--> first get all the customers

--> convert it to stream


--> then use the map function 

Stream.map(Function<? super Customer, ? extends Object> mapper)



if we observe the  map function arguments, its Function of Stream



--> from this you will get, one customer object,

get the email id &

 --> and convert it to list
 
 
 --> assign it to local variable
 
 --> define local variable so that we can print emails
 
 



--> map fucntion, we use one to one mapping

 ex: here one customer .has ..one email














Scenario 2
----------->


fetch all the phone numbers




if we use the map we are getting ..

 List<List<String>> phoneNumbers
 
 
 
 we don't want that.... we want List of Strings 
 
 
 
 o/p: 
 [[397937955, 21654725], [89563865, 2487238947], [38946328654, 3286487236], [389246829364, 948609467]]
 
 
 
 
 we are getting stream of stream data...
 
 we don't want that
 
 
 
 
 
 
 so it means data is non flattering structure
 
 
 
 
 
 first flatter the to single stream and then I need to do the mapping 
 
 
 with map we can't do that....
 
 so we go for flatMap
 
 
 
 
 
 
 --> if we observe, one customer have many phone nubmers
 
 thats how we can go for flatmap method 
 
 
 when we have one to many scenarios
 
 
 
 
 
 
 
 --> flatmap will take the input as stream of stream
 
 
 
 so convert the below to stream 
 
 Before
 ----->
 customer -> customer.getPhoneNumbers()
 
 
  
 After
 ----->
.flatMap(customer -> customer.getPhoneNumbers().stream())
 
 
 
 
 
 
 output: 
 -----
 
 [397937955, 21654725, 89563865, 2487238947, 38946328654, 3286487236, 389246829364, 948609467]
 
 
 
 
 
 
 
 
 --> so flatmap can be used for both 
 
    map() function and data flattering
    
    
    
 
 
 
 
 
 
 
 
 
 
 Differences between Java 8 Map() Vs flatMap() :

map()	flatMap()
It processes stream of values.	
It processes stream of stream of values.

It does only mapping.	
It performs mapping as well as flattening.


It’s mapper function produces single value for each input value.	
It’s mapper function produces multiple values for each input value.


It is a One-To-One mapping.	
It is a One-To-Many mapping.

Data Transformation : From Stream to Stream	
Data Transformation : From Stream<Stream to Stream


Use this method when the mapper function is producing a single value for each input value.	
Use this method when the mapper function is producing multiple values for each input value.



*/