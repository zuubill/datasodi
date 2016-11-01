package tld.datasodi;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import tld.datasodi.test.Test;

public class Run {
	public static MaskMethods maskMethods = new MaskMethods();
	public static Processors processors = new Processors(10);
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		maskMethods.register(new MaskNone());
		maskMethods.register(new MaskErase());
		maskMethods.register(new MaskOverwrite());
		maskMethods.register(new MaskOverwrite("HASH", '#'));
		maskMethods.register(new MaskUppercase());
		maskMethods.register(new MaskScramble());
		MaskMethod upperCase = maskMethods.getMethod("UPPER");

// /*
 		DBtable dbt_1 = new DBtable("EE_CORE", "CREBIT", "TOIM", "MASK");
		DBcolumn dbc_1_1 = new DBcolumn(dbt_1, "OP_NUMBER", "NONE");
		DBcolumn dbc_1_2 = new DBcolumn(dbt_1, "NIMI2", "SCRAMBLE");
		dbt_1.insert("1","Aadam");
		dbt_1.insert("2","Joonas");
		dbt_1.insert("3","Loppen-\"Busch");

		
/*		DBtable dbt_2 = new DBtable("EE_CORE", "CREBIT", "EPANGAD", "COPY");
		DBcolumn dbc_2_1 = new DBcolumn(dbt_2, "NIMI2", "SCRAMBLE");
		DBcolumn dbc_2_2 = new DBcolumn(dbt_2, "OP_NUMBER", "");
*/		
// */
		
		new Test().Run(dbt_1);
	}

}
