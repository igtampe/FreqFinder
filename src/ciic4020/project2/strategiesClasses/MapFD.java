package ciic4020.project2.strategiesClasses;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This is the Map portion of FreqFinder. It uses a hashtbale to have a table that pairs already found values with their frequency
 * as we go through the list. Because HashTables and Maps have faster access times, this should make this portion much faster.
 * 
 * Also I took the liberty to have some fun with the variable names. I hope whoever evaluates this code doesn't mind,
 * and understands the refference
 * 
 * Just in case though, TheFacesOfEvil was originally named DataSet.
 * 
 * @author Ignacio Tampe (igtampe)
 *
 * @param <E> The type of the elements whose frequencies are being counted.
 */
public class MapFD<E extends Comparable<E>> extends AbstractFDStrategy<E> {

	public MapFD() {super("Map");}

	@Override
	public ArrayList<Entry<E, Integer>> computeFDList(ArrayList<E> TheFacesOfEvil) {
		
		//Gee, it sure is boring around here...
	    //My boy, this is what all true heroes strive for.
		//I just wonder what Ganon's up to.
		
		//First things first, let's create our results arraylist
		ArrayList<Map.Entry<E, Integer>> results = new ArrayList<Map.Entry<E, Integer>>();
		
		//HERE IS THE MAP. WHERE DO YOU WISH TO GO? 
		Map<E, Integer> TheMap = new Hashtable<E, Integer>();
		
		//THESE ARE THE FACES, OF EVIL!
		for (E Face : TheFacesOfEvil) {
			
			//we already have it.
			if(TheMap.containsKey(Face)) {TheMap.put(Face, TheMap.get(Face) + 1);}
			
			//We don't have it
			else {TheMap.put(Face,1);}
			
			//Real talk I love how flexible Java is with comments that I can put a comment between the if and else.
			//I hope this doesn't break convention or something.
			
		}
		
		//now lets copy it to the arraylist, and SQUADALA! WE'RE OFF!
		for (Entry<E, Integer> Entry : TheMap.entrySet()) {results.add(Entry);}
		return results;
	}

}
