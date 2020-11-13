package com.revision;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class HackerEarth {

		int getValue() 
		{
		    int returnValue = 10;
		    try 
		    {
		        String[] Languages = {"Java", "Ruby"};
		        System.out.println(Languages[5]);
		    }
		    catch (Exception e) 
		    {
		        System.out.println("Catch Block :" + returnValue);
		        return returnValue;
		    }
		    finally
		    {
		        returnValue += 10;
		        System.out.println("Finally Block :" + returnValue);
		    }
		return returnValue;
		}

		public static void main(String args[])
		{
		    HackerEarth var = new HackerEarth();
		    System.out.println("Main Block:" + var.getValue());
		}
		}

 class HackerEarth2
{

@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@interface MyAnnotation { }

@Retention(RetentionPolicy.RUNTIME)
@interface Hints 
{
 Hint[] value();
}

@Repeatable(Hints.class)
@Retention(RetentionPolicy.RUNTIME)
@interface Hint
{
 String value();
}

@Hint("hint1")
@Hint("hint2")

class Person { }

public static void main(String[] args) 
 {
 Hint hint = Person.class.getAnnotation(Hint.class);
 System.out.println(hint);
 Hints hints1 = Person.class.getAnnotation(Hints.class);
 System.out.println(hints1.value().length);
 Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
 System.out.println(hints2.length);
 }
}