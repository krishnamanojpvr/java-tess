Java provides two interfaces to sort objects using data members of the class: 

1.Comparable
2.Comparator

Using Comparable Interface :

A comparable object is capable of comparing itself with another object. The class itself must implements the java.lang.Comparable interface to compare its instances. 
Consider a Movie class that has members like, rating, name, year. Suppose we wish to sort a list of Movies based on year of release. We can implement the Comparable interface with the Movie class, and we override the method compareTo() of Comparable interface. 

Using Comparator:

Unlike Comparable, Comparator is external to the element type we are comparing. It’s a separate class. We create multiple separate classes (that implement Comparator) to compare by different members.
Collections class has a second sort() method and it takes Comparator. The sort() method invokes the compare() to sort objects.

To compare movies by Rating, we need to do 3 things:

1.Create a class that implements Comparator (and thus the compare() method that does the work previously done by compareTo()).
2.Make an instance of the Comparator class.
3.Call the overloaded sort() method, giving it both the list and the instance of the class that implements Comparator.




-> Comparable is meant for objects with natural ordering which means the object itself must know how it is to be ordered. For example Roll Numbers of students.
-> Logically, Comparable interface compares “this” reference with the object specified and Comparator in Java compares two different class objects provided.
-> If any class implements Comparable interface in Java then collection of that object either List or Array can be sorted automatically by using Collections.sort() or Arrays.sort() method and objects will be sorted based on there natural order defined by CompareTo method.

-> Comparator interface sorting is done through a separate class.

-> A basic differentiating feature is that using comparable we can use only one comparison. Whereas, we can write more than one custom comparators as you want for a given type, all using different interpretations of what sorting means. Like in the comparable example we could just sort by only one attribute, i.e., year but in the comparator, we were able to use different attributes like rating, name, and year as well.

-> To summarize, if sorting of objects needs to be based on natural order then use Comparable whereas if you sorting needs to be done on attributes of different objects, then use Comparator in Java.
