package tld.datasodi.test;

import java.sql.SQLException;
import java.util.regex.Matcher;

import tld.datasodi.DBcolumn;
import tld.datasodi.DBtable;
import tld.datasodi.DBtableRow;
import tld.datasodi.MaskMethod;
import tld.datasodi.MaskMethods;

public class Test {


	public void Run(DBtable dbt) throws SQLException {
		DBtable maskMetaData = new DBtable("FILE", "NONE", "metadata.txt", "NONE");
		DBcolumn maskMetaData_source = new DBcolumn(maskMetaData, "SOURCE", "NONE");
		DBcolumn maskMetaData_owner = new DBcolumn(maskMetaData, "OWNER", "NONE");
		DBcolumn maskMetaData_table = new DBcolumn(maskMetaData, "TABLE_NAME", "NONE");
		DBcolumn maskMetaData_column = new DBcolumn(maskMetaData, "COLUMN_NAME", "NONE");
		
		
		String input = "abcd XYZ QWERTY efg jklmnopq 0123456789 !@#$%^&*( ";
		System.out.println("method list start");
		for (String s: MaskMethods.keySet()){
			System.out.println("key= "+ s+ "; method= "+ MaskMethods.getMethod(s));
		}
		System.out.println("methods listed");
//		MaskMethod m = MaskMethods.getMethod("HASH");
//		System.out.println("method = "+ m);
//		System.out.println(m.mask("abcd X efg"));
	
		System.out.println("Converting "+ input);
		
		for (String s: MaskMethods.keySet()){
			MaskMethod m = MaskMethods.getMethod(s);
			System.out.println(m.getName() + ": "+ m.mask(input));
		}
//		ResultSetMetaDataGenerate rsmd = new ResultSetMetaDataGenerate();
/*		for (int i=1; i<=dbt.columns.size(); i++)
			rsmd.addColumn(dbt.columns.get(i));
		for (int i=1; i<=rsmd.getColumnCount(); i++)
			System.out.println(i+ ": "+ rsmd.getColumnName(i));*/
			
/*		ResultSetGenerate rs = new ResultSetGenerate(dbt);
		rs.data(10);
*/		
		for (int k=1; k<=dbt.getColumnCount(); k++){
System.out.println("column #"+ k+ "; name= "+ dbt.getColumnName(k));				
		}
		System.out.println();
		dbt.beforeFirst();
		while(dbt.hasNext()){
			DBtableRow r = dbt.nextRow();
			for (int k=1; k<=dbt.getColumnCount(); k++){
				String s = r.getString(k);
				
//				String cName = dbt.getColumnName(k);
//				System.out.println(cName);
				DBcolumn dbc = dbt.getColumn(k);
//				System.out.println(dbc);
				String st = "\""+ dbc.method().mask(s).replaceAll("\"","\\\\\"")+ "\"";
//				String st = s.replaceAll("\"","\\\\\"");
				if (k!=1)
					System.out.print("; ");
				System.out.print(st);
			}
			System.out.println();
		}
		
	}
}
