package ciic4020.project2.strategiesClasses;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/***
 * This is the ordered part of FreqFinder. It sorts the list before finding frequency, and takes advantage of this fact to make
 * Finding Frequency a lot easier, with a lot cleaner code.
 * 
 * @author Ignacio Tampe (Igtampe)
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class OrderedFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public OrderedFD() {super("Ordered");}

	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {	

		//First things first, lets make sure we have esta cosita done.
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
		
		//We need <i>AT LEAST</i> one element to do this, so if the list is empty, this would break.
		//So lets make sure there's at least one element.
		if(dataSet.size()==0) {return results;}
		
		//Sort the original set
		dataSet.sort(null);
		
		E PrevEntry = dataSet.get(0);
		int PrevEntryAmount=0; //0 since we're going to find it again on the first element
		
		//Go through the entire set.
		for (E entry : dataSet) {
			if(entry.equals(PrevEntry)) {
				//We found it again, increment the preventry's amount
				PrevEntryAmount++;
			}
			else {
				//We've just found *another* element that's different. Add PrevEntry to the list, then update PrevEntry to be this one.
				results.add(new AbstractMap.SimpleEntry<E, Integer>(PrevEntry,PrevEntryAmount));
				PrevEntry=entry;
				PrevEntryAmount=1; //One since we litterally just found it.
			}
		}
		
		//Last but most certainly not least, add the last prevelement
		results.add(new AbstractMap.SimpleEntry<E, Integer>(PrevEntry,PrevEntryAmount));
		//Since we don't have another element to indicate we found another one, the add routine is never run for this last element, so we must run it here.
		
		return results;
		//Return the results and we're out of here.
	}

}
