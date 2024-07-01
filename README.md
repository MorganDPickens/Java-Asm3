# Java-Asm3

to ensure it is in the most usable order: 1 - country, state, city; 2 – population. For sorting you should create
an Enum Class Sort (Name, Population).
2 Design
2.1 Draw a Class Diagram
Provide a class diagram illustrating the project's structure, including interfaces and all classes, excluding Main.
2.2 Draw an Object Diagram
Submit an object diagram depicting the initial state of the system after adding a few countries and cities,
clearly illustrating the array data and parallelism.
3 Code
3.1 Understand the Details
3.1.1 City
Create a City class that has the following fields, in this order: Name, Country, State, and Population. All of these should
be of String type except Population (integer). Add preconditions to prevent null and empty parameter contents except
for State. Implement interface Comparable<City> and @Override compareTo() method.
3.1.2 CityLinkedList
This class manages city data, utilizing the CityInterface.java class. Implement methods to access city data.
Ensure the constructor doesn’t accept any parameters. For the iterator() method, you must create an inner private
class MyIterator implements Iterator<E>.
3.1.3 Files
Utilize the provided data files: cities.txt cities data (for checking the project use citiesShort.txt file). The Main
class must read a file and add data to your CityLinkedList. For testing, it is better to use cityShort.txt file.
Page 2 of 3
3.2 Use the Interface(s)
Implement the provided interface(s) exactly as specified. Add helper methods as necessary, without altering
the interface.
3.3 Implement Other Requirements
• Don’t use a standard LinkedList and its methods. You need to write all methods yourself.
• Minimize the use of global variables.
