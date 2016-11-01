package tld.datasodi;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class DBtableRow {
	DBtable dbt;
	SortedMap<Integer,String> columnData = new TreeMap<>();
	public DBtableRow (DBtable dbt){
		this.dbt = dbt;
	}
	public DBtableRow (DBtable dbt, SortedMap<Integer, String> columnData){
		this.dbt = dbt;
		this.columnData = columnData;
	}
	public String getString(int columnIndex) {
		return columnData.get(columnIndex).toString();
	}
	public void updateString(int columnIndex, String s) {
		columnData.put(columnIndex,s );
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<"+super.toString());
		for (String s: columnData.values())
			sb.append(s+ "; ");
		sb.append(">");
		return sb.toString();
	}
}
