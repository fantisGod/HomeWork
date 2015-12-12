package classification.util;

import java.util.HashMap;

public class Record {
	private ColumnNames columnNames;
	private HashMap<String, String> cells;
	
	public Record(ColumnNames columnNames, String tupleLine){
		cells = new HashMap<String,String>();
		this.setColumnNames(columnNames);
		String[] cellValues = tupleLine.split(";");
		for(int i = 0 ; i < cellValues.length ; i++){
			cellValues[i]=cellValues[i].replaceAll("\"","");
			cells.put(columnNames.get(i), cellValues[i]);
		}
	}
	public String toString(){
		return cells.toString();
	}
	
	public String getValue(String columnName){
		return cells.get(columnName);
	}
	public void setValue(String columnName,String value){
		 this.cells.put(columnName,value);
	}
	
	public String getValue(int columnIndex){
		String columnName = columnNames.get(columnIndex);
		return getValue(columnName);
	}

	/**
	 * @return the columnNames
	 */
	public ColumnNames getColumnNames() {
		return columnNames;
	}

	/**
	 * @param columnNames the columnNames to set
	 */
	private void setColumnNames(ColumnNames columnNames) {
		this.columnNames = columnNames;
	}
}
