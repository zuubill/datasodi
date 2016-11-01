package tld.datasodi;

import java.util.SortedSet;
import java.util.TreeSet;

public class Processors {
	protected static Integer hwm = 0;
	SortedSet<Processor> pFree = new TreeSet<>();
	SortedSet<Processor> pRunning = new TreeSet<>();
	Object blocker = new Object();
	Processors(int n){
		for (int i=0; i<n; i++)
			pFree.add (new Processor());
	}
	synchronized Processor get(){
		if (pFree.isEmpty()) return null;
		Processor p = pFree.first();
		pRunning.add(p);
		return p;
	}
	synchronized void release(Processor p){
		pRunning.remove(p);
		pFree.add(p);
	}
}
