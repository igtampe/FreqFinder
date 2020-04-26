package ciic4020.project2.strategiesClasses;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * 
 * @author Ignacio Tampe (igtampe)
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class MapFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public MapFD() {super("Map");}

	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		
		//First things first, let's create our results arraylist
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
		
		return results;
	}

}
