package org.uiframework.framework.datahandler;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.uiframework.framework.helpers.ReadFilesFromResources;

import java.util.HashMap;


public class Excel extends DataFile {

    private ReadFilesFromResources FileReader;
    private final String resourceFilePath;
    private final  Class<?> Class;
    private  final String SheetName;
    private  XSSFWorkbook workbook;
    private  XSSFSheet sheet;
    private  XSSFRow row;
    private  XSSFCell cell;



    protected Excel(String resourceFilePath, String SheetName ,Class<?> Class) {
        this.SheetName=SheetName;
        this.resourceFilePath=resourceFilePath;
        this.Class=Class;
        super.Type=DataFileType.EXCEL;

    }


    @Override
    public DataFile ReadData() throws Exception {
        this.FileReader= new ReadFilesFromResources();
        try {
            this.workbook = new XSSFWorkbook(FileReader.readResourcesAsFileInputStream(resourceFilePath, Class));
            this.sheet = workbook.getSheet(SheetName);
            XSSFRow FistRow = sheet.getRow(0);
            int NumberOfRows = sheet.getLastRowNum() + 1;
            int NumberOfCells = FistRow.getLastCellNum();
            super.ExcelData = new HashMap<Integer, HashMap>();
            for (int i = 1; i < NumberOfRows; i++) {
                XSSFRow row = sheet.getRow(i);
                HashMap RowData = new HashMap<String, String>();
                for (int j = 0; j < NumberOfCells; j++) {
                    cell = row.getCell(j);
                    RowData.put(getCellValueAsString(FistRow.getCell(j)), getCellValueAsString(row.getCell(j)));
                }

                ExcelData.put(i, RowData);

            }
        } catch (Exception e)
        {
            throw new Exception("Error : Couldn't Read WorkBook Form Excel File : "+resourceFilePath,e);

        }
        return this;
    }

    private String getCellValueAsString(Cell cell) {
        String cellValue = null;
        switch (cell.getCellType()) {
            case NUMERIC:
                cellValue = String.valueOf((int)cell.getNumericCellValue());
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case FORMULA:
                cellValue= cell.getCellFormula();
            case BLANK:
                cellValue="BLANK";
            default:
                cellValue ="DEFAULT";
        }
        return cellValue;
    }

}
