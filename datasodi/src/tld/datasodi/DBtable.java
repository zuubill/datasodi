package tld.datasodi;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import tld.datasodi.test.ResultSetMetaDataGenerate;

public class DBtable {
	private final String source;
	private final String owner;
	private final String tableName;
	private final String transport;
	public SortedMap<Integer, DBcolumn> columns = new TreeMap<>();

	SortedMap<Integer,DBtableRow> rowData = new TreeMap<>();
	public int currentRowNumber = 0;

//	private ResultSet rs;
//	private ResultSetMetaDataGenerate rsmd = new ResultSetMetaDataGenerate();
	private Integer numColumns = 0;
	public DBtable (String source, String owner, String name, String transport){
		this.source = source;
		this.owner = owner;
		this.tableName = name;
		this.transport = transport;
	}
	public String getSource() {
		return source;
	}
	public String getOwner() {
		return owner;
	}
	public String getName() {
		return tableName;
	}
	public String getTransport() {
		return transport;
	}
/*	void setData (ResultSet rs) throws SQLException{
		this.rs = rs;
		this.rsmd = (ResultSetMetaDataGenerate) rs.getMetaData();
	}
*/	public void insert(String... ss) throws SQLException{
		DBtableRow r = new DBtableRow(this);
		int columnIndex = 0;
		for (String s: ss)
			r.updateString(++columnIndex, s);
		insert(r);
	}
	public void insert(DBtableRow row) throws SQLException {
		int key = rowData.size()+1; 
		rowData.put(key, row);
	}

	int addColumn (DBcolumn column){
		if (columns.values().contains(column)) {
			return 0;
		}
		else {		
			numColumns++;
			columns.put(numColumns, column);
			return getColumnCount();
		}
	}
	public DBcolumn getColumn (int position){
		return columns.get(position);
	}
	public DBcolumn getColumn (String name){
		for (DBcolumn c: columns.values())
			if (c.name().equals(name))
				return c;
		return null;
	}
	boolean isMaskableColumn (int position) throws SQLException{
		return (getColumn(position).method() != null);
	}
	boolean isMaskableColumn(String name) {
		return (getColumn(name).method() != null);
	}
/*	public ResultSetMetaData getMetaData() {
		return rsmd;
	}
*/	public SortedMap<Integer, DBcolumn> getColumns() {
		return columns;
	}
	public void beforeFirst() {
		currentRowNumber = 0;
	}
	public int getColumnCount() {
		return numColumns;
	}
	public String getColumnName(int k) {
		return columns.get(k).name();
	}
	public boolean hasNext() {
		return (currentRowNumber < rowData.size());
	}
	public DBtableRow nextRow() {
		if (!hasNext())
			return null;
		return rowData.get(++currentRowNumber);
	}
}
