package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilis {
	
	public static String username;
	public static String password;
	
	@SuppressWarnings("resource")
	public void ReadExcel() throws IOException {
		String excelFilePath = "./resources/credentials.xlsx";
		File file = new File(excelFilePath);
		System.out.println(file.getAbsolutePath());
		FileInputStream inputstream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(rows).getLastCellNum();
		
		System.out.println(rows);
		System.out.println(cols);
		
		for(int r = 1; r <= rows ;r++) {
			XSSFRow row = sheet.getRow(r);
			
			for (int c = 0;  c < 1; c++) {
				XSSFCell cell = row.getCell(c);
				
				row = sheet.getRow(r);
				cell = row.getCell(c + 0);
				username = cell.getStringCellValue();
				System.out.println(username);
				
				cell = row.getCell(c + 1);
				password = cell.getStringCellValue();
				System.out.println(password);
				
			}
			 
		}
		
		
	}
	
	@SuppressWarnings("resource")
	public void writeExcelData(String username, String password) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("UserInfo");
		
		Object data[][] = {{"UserName", "PassWord"}, { username, password}
		};
		
		int rows = data.length;
		int cols = data[0].length;
		
		for(int r = 0; r < rows; r++) {
			XSSFRow row = sheet.createRow(r);
			
			for(int c = 0; c < cols; c++) {
				XSSFCell cell = row.createCell(c);
				Object value = data[r][c];
				
				if(value instanceof String) {
					cell.setCellValue((String) value);
				}
				if(value instanceof Integer) {
					cell.setCellValue((Integer) value);
				}
				if(value instanceof Boolean) {
					cell.setCellValue((Boolean) value);
				}
				if(value instanceof Double) {
					cell.setCellValue((Double) value);
				}
				
				
			}
				
		}
		String writExcelData = "./resources/writeData.xlsx";
		File file = new File(writExcelData);
		FileOutputStream writeStram = new FileOutputStream(file);
		workbook.write(writeStram);
		
		workbook.close();
		writeStram.close();
		
		
		
	}

}
