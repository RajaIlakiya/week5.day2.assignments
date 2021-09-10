package week5.day1.assignment2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ServiceNowExcel {
	public static String[][] readData(String fileName,String SheetName) throws IOException {
		// TODO Auto-generated method stub
//			public static String[][] readData() throws IOException {
//		XSSFWorkbook wb=new XSSFWorkbook("./exceldata/CreateLead.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook("./exceldata/"+fileName+".xlsx");

XSSFSheet sheet=wb.getSheet(SheetName);
int rowCount=sheet.getLastRowNum();
System.out.println("Create lead row count: " + rowCount);
int cellCount=sheet.getRow(0).getLastCellNum();
System.out.println("Create lead cell count: " + cellCount);
//create 2D array
String[][] data=new String[rowCount][cellCount];

for(int i=1;i<=rowCount;i++)
{
	for(int j=0;j<cellCount;j++)
	{
		String text=sheet.getRow(i).getCell(j).getStringCellValue();
		System.out.println(text);
	//get row and column value	
		data[i-1][j]=text;
	}

}
wb.close();
return data;
	}

}
