package nsuite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * A class to clean duplicate entries out of provided array.  
 * @author Parag Sagar
 *
Given a sorted array of integers, write a method to remove the duplicates.  Do
not use any classes from the java.util package, or the equivalent library for
your language.

Example: [ 1, 2, 3, 3, 3, 4, 4, 10, 13, 15, 15, 17 ] ->
         [ 1, 2, 3, 4, 10, 13, 15, 17 ]

 */
public class Cleanser {
	
	
	/**
	 * Public method to remove Duplicates of a given primitive integer Array
	 * @param values
	 * @return
	 */
    public int[] removeDuplicates(int[] values){
    	int newValues[] ; //This is our return array. also We have strict requirement of return int[] 
    	List<Integer> checker = new ArrayList();     	 // Logic is to keep an List to check for duplicates 
    	if(values.length > 1) //if array has less than 2 element that it has no duplicates
    	{
    		//array to keep temp values. Because we always need to know the size of array at the time of initializing an array.
    		//we could have used another loop to copy list values to  
    		int anotherArray[] = new int[values.length];  
    		int newValueCount = 1;
    		checker.add(values[0]); //Adding 1st value to list so we start checking from 2nd value 
    		anotherArray[0] = values[0];
    		for(int i=1; i< values.length;i++){
    			
    			if(!checker.contains(values[i]))//Checking for duplicate value exists . Can also check the anotherarray for exists.
    			{
    				checker.add(values[i]); 
    				anotherArray[newValueCount++] = values[i]; //Add to temp array and increment the count
    			}
    		}
    		newValues = Arrays.copyOfRange(anotherArray, 0, checker.size()); //Utilizing java utility to create a new array with desired length OR we could have copies the list here in a loop. 
    	}
    	else 
    	{
    		newValues = values;
    	}
    	return newValues;
    }//Method End removeDuplicates(int[] values)
    

    /** 
     * Simple Method to remove duplicates of object arrays.
     * @param values of Any object,
     * @return Returns the same Object type non duplicated values
     */
	public <T> T[] removeDuplicates(T[] values) {
	    return (T[]) new HashSet<T>(Arrays.asList(values)).toArray();
	}


    
    /** 
     * Main Method to show how this Program works.
     * @param args
     */
	public static void main(String[] args) {
		Cleanser clean = new Cleanser();

		int values[] ={1, 2, 3, 3, 3, 4, 4, 10, 13, 15, 15, 17 };
		int  retVals[] = clean.removeDuplicates(values);
		for(int i=0; i< retVals.length;i++){
			System.out.println(retVals[i]);	
		}

		//Generic Object Type Example.
		print((Object[])clean.removeDuplicates(new Integer[]{1, 2, 3, 3, 3, 4, 4, 10, 13, 15, 15, 17} ));
		print((Object[])clean.removeDuplicates(new Character[]{'A','A','B'}));
		print((Object[])clean.removeDuplicates(new String[]{"D","D","E","D","F"}));
		
	}


	/**
	 * Generic method to print a Object array
	 * @param values
	 */
	private static <T> void print(T[] values) {
		for(int i=0; i< values.length;i++){
			System.out.println(values[i]);	
		}
		
	}
	
}
