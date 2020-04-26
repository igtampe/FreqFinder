package ciic4020.project2.testerClasses;

import java.util.ArrayList;
import java.util.Map;

import ciic4020.project2.strategiesClasses.OrderedFD;

public class OrderedTester1 {
	public static void main(String[] args) {
		
		//If I had not changed the size, I wouldn't've realized we were missing the last element
		//Hopefully this doesn't affect the experimentation :nervous_smile:
		
		System.out.println("Testing Map strategy"); 
		ArrayList<Integer> data = TestingUtils.generateListOfIntegers(10); 
		
		TestingUtils.displayListElements("Original Data", data);
		
		OrderedFD<Integer> s = new OrderedFD<Integer>(); 
		ArrayList<Map.Entry<Integer, Integer>> fd = s.computeFDList(data); 

		//Sorting here isn't really necessary since the list comes pre-sorted
		//fd.sort(new EntryIntComparator());
		
		TestingUtils.displayListElements("Frequency Distribution", fd);
	}

}