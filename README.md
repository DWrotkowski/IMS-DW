Coverage: 80%
# IMS - Project


## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
The goal of this project is to create an application from which the user can log in and then edit the database. User can edit things like: items, orders and customers. Main feature of this program is to allow user to create orders that cointains items, customer and value. The user can edit orders and add or remove customers and items. An additional function is logging in and creating an account.

	
## Technologies
Project is created with:
Version Control System: Git​

Source Code Management: GitHub​

Kanban Board: Jira​

Database Management System: MySQL Server 5.7(local or GCP instance)

 Programming Language: Java​

Build Tool: Maven​

Unit Testing: JUnit
	
## Setup
Download project from my github.
To run this project, install it locally using comand line or git:
to run it on git or comand line:
grt to main folder:
$ cd ../IMS/target
for example:
danie@DESKTOP-PFP0KQU MINGW64 ~/Desktop/code versions/IMS/target
then type: 
java -jar ims-0.0.1-jar-with-dependencies.jar
Now you can use aplication!!

## little demo
For example user want to add new order.
 
1:Step : type Login or create account 

Welcome to the Inventory Management System! 

What would you like to do today?

LOGIN: Enter user detalis to access aplication 
CREATE: Create new account 
EXIT: To exit application 

2:Step: Now login 

Please enter Username
dan
Please enter Password
123

3:Now select ORDER

Hello dan
Which entity would you like to use?

CUSTOMER: Information about customers

ITEM: Individual Items

ORDER: Purchases of items

LOGOUT: To loggout from this account

order
What would you like to do with order:

CREATE: To save a new entity into the database

READ: To read an entity from the database

UPDATE: To change an entity already in the database

DELETE: To remove an entity from the database

RETURN: To return to domain selection

ADD_ITEM: To add iterm to existing order

REMOVE_ITEM: Remove item from order

CALC_VALUE: Calc value of order

4. type create and add customer id

create
Please enter a order's customer's id
1
Order created, now you need add some items

5: Add item to order

What would you like to do with order:

CREATE: To save a new entity into the database

READ: To read an entity from the database

UPDATE: To change an entity already in the database

DELETE: To remove an entity from the database

RETURN: To return to domain selection

ADD_ITEM: To add iterm to existing order

REMOVE_ITEM: Remove item from order

CALC_VALUE: Calc value of order

add_item

Please enter the id of the order you would like to add item

2

Please enter a item

1

Item added to order

6: check order if exist:

read

ALL orders :

order_id= 1, customers_ id : 1

order_id= 2, customers_ id : 1

Orders with Items :

order_id= 1, customers_ id : 1, items= 1

order_id= 2, customers_ id : 1, items= 1

7: When you finish close application.

## Running the tests

 Break down into which tests and what they do
to run automated test select: 
src/test/main
and press right mouse button and select "Coverage As" and select "Junit".
test are methods with @Test above it.

There is 3 main vategories and one extra for extra feture
1: contorllers:
This test main input into conntorlers tathe will proces user input into  dao
2: dao:
This tests test feture that use code from mysql and work with database There two type of test expected outcome and second is error that wil triger expectations
3: domain:
This yesy work with class that store data for specifi class.

4:extra test:
here are extra test to test extra functions such as utitles.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management


### Unit Tests 

Unit tests are typically automated tests written and run by software developers to ensure that a section of an application known as the "unit" meets its design and behaves as intended. There run by imput.


@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}


### Integration Tests 
System Integration Testing is defined as a type of software testing carried out in an integrated hardware and software environment to verify the behavior of the complete system. To check conenection for example with dtatabse and check how work beetewn each other.
Run by implemantin code from other aplication.

@Test
	public void testRead() {
		final long ID = 1L;
		assertNull( DAO.read(ID));
	}




### And coding style tests

A testing unit should focus on one tiny bit of functionality and prove it correct . Focus on one bit of code.

@Test
	public void testCreate() {
		List<User> expected = new ArrayList<>();
		expected.add(new User( "dan", "123"));
		
		Mockito.when(dev.readAll()).thenReturn(expected);
		
		
		final String username = "dan";
		final String password = "321";
		final User created = new User(username, password);

		Mockito.when(utils.getString()).thenReturn(username, password);
		Mockito.when(dev.create(created)).thenReturn(created);

		assertEquals(created, account.create());

		Mockito.verify(utils, Mockito.times(4)).getString();
		Mockito.verify(dev, Mockito.times(1)).create(created);
	}



## Versioning

1.0.5

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Daniel Wrotkowski** - *Most of work* - https://github.com/DWrotkowski

## License

This project is licensed under the MIT license 

MIT License

Copyright (c) 2021 Daniel Wrotkowski

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
