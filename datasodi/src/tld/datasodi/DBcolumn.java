package tld.datasodi;


public class DBcolumn {
	private String source;
	private String owner;
	private DBtable table;
	private String name;
	private MaskMethod method;
	public DBcolumn(DBtable table, String name, String methodName){
		this.table = table;
		this.name = name;
		this.method = MaskMethods.getMethod(methodName);
		table.addColumn(this);
	}
	public String name() {
		return name;
	}
	public MaskMethod method() {
		// TODO Auto-generated method stub
		return method;
	}
}
