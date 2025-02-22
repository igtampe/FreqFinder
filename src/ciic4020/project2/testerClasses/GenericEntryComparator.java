package ciic4020.project2.testerClasses;

import java.util.Comparator;
import java.util.Map.Entry;

public class GenericEntryComparator<K extends Comparable<K>, E> implements
		Comparator<Entry<K, E>> {

	@Override
	public int compare(Entry<K, E> o1, Entry<K, E> o2) {
		return o1.getKey().compareTo(o2.getKey());
	}
	
	

}
