package com.revision;

import java.util.HashMap;
import java.util.Map;

class Geek  
{ 
      
    String name; 
    int id; 
      
    Geek(String name, int id) 
    { 
          
        this.name = name; 
        this.id = id; 
    } 
      
    @Override
    public boolean equals(Object obj) 
    { 
          
    // if both the object references are  
    // referring to the same object. 
    if(this == obj) 
            return true; 
          
        // it checks if the argument is of the  
        // type Geek by comparing the classes  
        // of the passed argument and this object. 
        // if(!(obj instanceof Geek)) return false; ---> avoid. 
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
          
        // type casting of the argument.  
        Geek geek = (Geek) obj; 
          
        // comparing the state of argument with  
        // the state of 'this' Object. 
        return (geek.name.equals(this.name)  && geek.id == this.id); 
    } 
      
    @Override
    public int hashCode() 
    { 
          
        // We are returning the Geek_id  
        // as a hashcode value. 
        // we can also return some  
        // other calculated value or may 
        // be memory address of the  
        // Object on which it is invoked.  
        // it depends on how you implement  
        // hashCode() method. 
        return this.id; 
    } 
      
} 
  
// Driver code 
class GFG  
{ 
    public static void main (String[] args)  
    { 
          
        // creating two Objects with  
        // same state 
        Geek g1 = new Geek("aditya", 1); 
        Geek g2 = new Geek("aditya", 1); 
          
        Map<Geek, String> map = new HashMap<Geek, String>(); 
        map.put(g1, "CSE"); 
        map.put(g2, "IT"); 
          
        for(Geek geek : map.keySet()) 
        { 
            System.out.println(map.get(geek).toString()); 
        } 
  
    } 
} 
