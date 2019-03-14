package assets;

import java.util.ArrayList;

public class ExcelRead {
	
	public static String getCell(int row, int col) {
		ExcelConfig excelPath = new ExcelConfig("D:\\github\\SeleniumFrameworkTraining\\AmazonMaven\\testdata.xlsx");
//	TASK (TBD) this is not working with numeric cells
		return excelPath.getData(0, row, col);
	}

	
//	TASK: ArrayList dataprovider from Excel file
	public static ArrayList<String> Row1() {
		ExcelConfig excelPath = new ExcelConfig("D:\\github\\SeleniumFrameworkTraining\\AmazonMaven\\testdata.xlsx");
		return (ArrayList<String>) excelPath.getRowData(0, 0);
	}
}
