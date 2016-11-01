package tld.datasodi;

public class Processor implements Comparable<Object> {
	Integer id;
	Processor(){
		synchronized (Processors.hwm){
			id = Processors.hwm++;
		}
	}
	@Override
	public int compareTo(Object o) {
		return id.compareTo(((Processor) o).id);
	}
	public int processTask(DBtable t){
		System.out.println(t.toString());
		return 0;
	}
}
