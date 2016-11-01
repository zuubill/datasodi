package tld.datasodi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class TableMetadata {
	Set<DBtable> tables = new HashSet<>();
	Map<DBtable,DBcolumn> columns = new HashMap<>();
	void putTable(DBtable table){
		if (table == null)
			System.out.println(0/0);
		tables.add(table);
	}
	DBtable getTable(String source, String owner, String name){
		for (DBtable t: tables){
			if (t.getSource().equals(source) && 
					t.getOwner().equals(owner) &&
					t.getName().equals(name))
			return t;			
		}
		return null;
	}
	SortedMap<Integer, DBcolumn> getTabColumns (String source, String owner, String name){
		return getTable(source, owner, name).getColumns();
	}

}
