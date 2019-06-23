package com.demo.helper.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelHelper {
	
	public static String username;
	public static String password;

	public Object[][] getExcelData(String excelLoc, String sheetName ) {

		
		try {
			
			Object dataSets [][]=null;
			FileInputStream file= new FileInputStream(new File(excelLoc));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRow=sheet.getLastRowNum();
			System.out.println(totalRow);
			int totalColumn=sheet.getRow(0).getLastCellNum();
			dataSets= new Object[totalRow+1][totalColumn];
			
			Iterator<Row> rowIterator = sheet.iterator();
			int i=0;
			while (rowIterator.hasNext()) {
				i++;
				Row row=rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				int j=0;
				while (cellIterator.hasNext()) {
					j++;
					Cell cell = cellIterator.next();
					
					switch (cell.getCellType()) {
					case STRING:
						dataSets[i-1][j-1]=cell.getStringCellValue();
						break;
					case NUMERIC:
						dataSets[i-1][j-1]=cell.getNumericCellValue();
						break;
					case BOOLEAN:
						dataSets[i-1][j-1]=cell.getBooleanCellValue();
						break;
					default:
						System.out.println("No matching datat type found");
						break;
					}
				}
			}
			workbook.close();
			return dataSets;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
/*	public void updateResult(String excelLoc, String sheetName, String status) {
		
		try {
			
			FileInputStream file= new FileInputStream(new File(excelLoc));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRow=sheet.getLastRowNum()+1;
			for (int i = 1; i < totalRow; i++) {
				XSSFRow row = sheet.getRow(i);
				String ce=row.getCell(0).getStringCellValue();
				if (ce.contains(s)) {
					row.createCell(1).setCellValue(status);
					file.close();
					FileOutputStream out = new FileOutputStream(new File(excelLoc));
					workbook.write(out);
					out.close();
					break;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
*/
	public void getExcelDataSet(Object[][] data) {
		
		 for(int i=1; i<data.length; i++) {
		        for(int j=0; j<data[i].length-1; j++) {
		            System.out.println("Values at arr["+i+"]["+j+"] is "+data[i][j]);
		            username= (String) data[i][0];
		            password=  data[i][1].toString();
		            //System.out.println(username +" "+ password);
		        }
		    }
	}
	
/*	public static void main(String[] args) {
		
		excelHelper exc= new excelHelper();
		Object[][] obj=exc.getExcelData(System.getProperty("user.dir")+"\\src\\resources\\testData.xlsx", "login");
		exc.getExcelDataSet(obj);
	}*/
}
