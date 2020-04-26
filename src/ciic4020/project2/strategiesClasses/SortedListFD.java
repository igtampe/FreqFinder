package ciic4020.project2.strategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

import ciic4020.project2.sortedlist.SortedList;
import ciic4020.project2.sortedlist.SortedArrayList;

/**
 * This class implements the SortedList strategy to count frequencies in an ArrayList.
 * @author Ignacio Tampe (Igtampe)
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class SortedListFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	/**
	 * Our SortedList classes require the data type to be Comparable.
	 * However, Map.Entry and AbstractMap.SimpleEntry are not Comparable,
	 * so we extend AbstractMap.SimpleEntry and create a Comparable
	 * version that we can use with our SortedList.
	 * Note: The K (key) of this class will be the E of SortedListFD,
	 *       so it will be Comparable.
	 * @author Juan O. Lopez
	 *
	 * @param <K>  The type of the key of each entry
	 * @param <V>  The type of the value of each entry
	 */
	@SuppressWarnings("serial")
	private static class ComparableEntry<K extends Comparable<K>, V>
			extends AbstractMap.SimpleEntry<K, V>
			implements Comparable<Map.Entry<K, V>> {

		public ComparableEntry(K key, V value) {super(key, value);}

		@Override
		/* Entries will be compared based on their keys, which are Comparable */
		public int compareTo(Map.Entry<K, V> entry) {return getKey().compareTo(entry.getKey());	}
		
	} // End of ComparableEntry class

	/* Constructor */
	public SortedListFD() {super("SortedList");}

	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>(); 
		SortedList<ComparableEntry<E, Integer>> sortedlist = new SortedArrayList<ComparableEntry<E, Integer>>(1000);
		
		//OK this is basically the same, but not.
		
		boolean WeFoundIt =false;
		
		//Go through the entire original list
		for (E e : dataSet) {
			
			//Go through the sorted list.
			for (int i = 0; i < sortedlist.size(); i++) {
				
				//get the element from the sortedlist
				ComparableEntry<E, Integer> CurrentDataBit=sortedlist.get(i);
				
				//kk now for some tests.
				
				if(CurrentDataBit.getKey().equals(e)){
					//yay we found it. Increment its value, and lets get the heck out of here
					CurrentDataBit.setValue(CurrentDataBit.getValue()+1);
					WeFoundIt=true;
					break;
				}
				
				//This is the only bit that makes this different from sequential.
				if(CurrentDataBit.getKey().compareTo(e)>0){
					//Oh no, we should've passed it. Lets get the heck out of here
					WeFoundIt=false;
					break;
				}
				
			}
			
			//Woopsie, we didn't find it. We must *a d d    i t*
			if(!WeFoundIt) {sortedlist.add(new ComparableEntry<E, Integer>(e, 1));}
			
		}		
		
		//Lastly, (Even though this is the first bit of code we added) copy everything from sordtedlist to results
		//Oh no, this arraylist is not itterable. Oopsie poopsie.
			
		for (int i = 0; i < sortedlist.size(); i++) {results.add(sortedlist.get(i));}

		return results;
	}

}