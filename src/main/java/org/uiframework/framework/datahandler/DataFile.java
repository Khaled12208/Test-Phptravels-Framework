package org.uiframework.framework.datahandler;


import java.util.HashMap;
import java.util.Map;

public abstract class DataFile {

    protected HashMap<String, String> Data;
    protected HashMap<Integer, HashMap> ExcelData;
    protected DataFileType Type;

    public abstract DataFile ReadData() throws Exception;

    public HashMap<String, String> getData() {
        if (Type == DataFileType.EXCEL)
            return ExcelData.get(1);
        else
            return Data;
    }
    public HashMap<Integer, HashMap> getExcelSheetData() {
            return ExcelData;
    }


}
