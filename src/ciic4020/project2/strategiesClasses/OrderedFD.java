package ciic4020.project2.strategiesClasses;

import java.util.ArrayList;
import java.util.Map.Entry;

public class OrderedFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public OrderedFD() {super("Ordered");}

	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {	
		return null;
	}

}
