package nsuite;

import java.util.Arrays;
import java.util.Iterator;

/**
 * A simple iterator Which removes duplicate elements.
 * @author Parag Sagar
 *
Given a sorted array of integers, write a method to remove the duplicates.  Do
not use any classes from the java.util package, or the equivalent library for Java
using java.util.Iterator
 *
 * @param <T>
 */
public class SimpleIterator<T> implements Iterator<T>{

	private T[] localArray ;
	private int size , currentEnementIndex;
	private int removedElement = -1;

	public SimpleIterator(){
		//default;
	}
	
	/**
	 * Constructor with Array argument.
	 * @param array
	 */
	public SimpleIterator(T[] array){
		
		localArray = array;
		Arrays.sort(localArray);
		size = array.length;
	}
	
	public Iterator<T> iterator()
	{
		return this;
	}
	
	/**
	 * Method which find whether it has next value 
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		removedElement = -1;
		return (size != currentEnementIndex);
	}

	/** 
	 * method to get the next non duplicate element.
	 */
	@Override
	public T next() {
		// TODO Auto-generated method stub
		int nextElementIndex = currentEnementIndex +1 ;

			while(nextElementIndex < size && currentEnementIndex < nextElementIndex && localArray[currentEnementIndex].equals(localArray[nextElementIndex]))
			{
			//	remove the next Element and reset the size and counter
				skip();
				next();
				
			}
		if(removedElement != -1 )
		{
			currentEnementIndex = removedElement+1;
		}
		return localArray[currentEnementIndex++];
	}

	@Override
	public void remove() {
		
	}

	/**
	 * Skips the duplicate element
	 */
	private void skip(){
//		System.out.println(" Removing Duplicate "+localArray[counter]+" at " + counter );
		removedElement = currentEnementIndex;
		currentEnementIndex++;
	}
	
/**
 * Method to provide examples  	
 * @param args
 */
	public static void  main(String[] args) {
		
		//Integer Example
		SimpleIterator<Integer> check = new SimpleIterator<Integer>(new Integer[]{1,2,2,2,2,2,3,4,5,5,5,5,6,6,6,6});
		Iterator<Integer> itr = check.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}

		//String example
		SimpleIterator<String> strCheck = new SimpleIterator<String>(new String[]{"ABC","BCD","BCD","BCD","BCD","DBA"});
		Iterator<String> strItr = strCheck.iterator();
		while(strItr.hasNext())
		{
			System.out.println(strItr.next());
		}		
	}

}
