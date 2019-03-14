package assets;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {

	XSSFWorkbook wb;
	
	XSSFSheet sheet;
	
	public ExcelConfig(String excelPath) {
	
		try {
			
			File src = new File(excelPath);
			
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
					

		} 
		
		catch (Exception e) {
			
			System.out.print("Excel Data Config Error!!!");
		}
		
	}

	
	public String getData(int sheetNumber, int rowNumber, int columnNumber)	{
		
		sheet = wb.getSheetAt(sheetNumber);
		
		DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
		Cell cell = sheet.getRow(rowNumber).getCell(columnNumber);
		String cellString = formatter.formatCellValue(cell); 
		return cellString;
		
	}
	
	
	public List<String> getRowData(int sheetNumber, int rowNumber) {
		
		sheet = wb.getSheetAt(sheetNumber);
		
		List<String> rowData = new ArrayList<String>();
		int lastColumn = sheet.getRow(rowNumber).getLastCellNum();
		int n = 0;
		while(n < lastColumn) {
			String cellData = sheet.getRow(rowNumber).getCell(n).getStringCellValue();
			rowData.add(cellData);
			n++;
		}
		
		return rowData;
	}
}

