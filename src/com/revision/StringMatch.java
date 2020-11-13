package com.revision;

public class StringMatch {
	public static void main(String[] args)
	{

	String regex = ".@.";

	StringMatch.compare("Hacker@Earth.com", regex);
	StringMatch.compare("a@N", regex);
	StringMatch.compare("Java@Program", regex);

	}

	public static void compare(String str, String regex)
	{
	    if (str.matches(regex))
	    {
	        System.out.println(str + " matches");
	    }
	    else
	    {
	        System.out.println(str + " does not match");
	    }
	}
}
