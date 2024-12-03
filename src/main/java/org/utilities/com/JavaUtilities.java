package org.utilities.com;

import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JavaUtilities {
	
	public String sheetname;
	public static  Properties prop;
	
	public static void openProp() {
		//String value=null;
		String path="D:\\eclipse\\BBEComSelE2E\\src\\test\\resources\\TestData\\config.properties";
		try {
			 prop = new Properties();
			FileInputStream istream =new  FileInputStream(path);
			prop.load(istream);
			//value = prop.getProperty(key);
			//System.out.println(value);
		}
		catch(Exception e){
			e.printStackTrace();
		}
			
		}
		
		public static String readingExcel(String sheet, int row, int col) {
			String result=null;
			try {
				String filepath=System.getProperty("user.dir")+"D:\\eclipse\\BBEComSelE2E\\src\\test\\resources\\TestData\\Productlist.xlsx";
				DataFormatter format= new DataFormatter();
				FileInputStream instream = new FileInputStream(filepath);
				XSSFWorkbook book= new XSSFWorkbook(instream);
				XSSFCell cell = book.getSheet(sheet).getRow(row).getCell(col);
				result = format.formatCellValue(cell);
				book.close();
				instream.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return result;
		}
		public static void verifyLink(String url) {
			try {
				URL link = new URL(url);
				HttpURLConnection httpURLConnection = (HttpURLConnection)link.openConnection();
				httpURLConnection.setConnectTimeout(2000);
				httpURLConnection.connect();
				
				if(httpURLConnection.getResponseCode()==200){
					System.out.println(url+" - "+httpURLConnection.getResponseCode());
				}else {
					System.out.println(url+" - "+httpURLConnection.getResponseCode()+" - "+"is a broken link");
				}
				}catch (Exception e) {
				System.out.println(url+"-"+"is a broken link");
			}
			
		}
		
		public static String[][] readExcel(String sheetname) throws Exception {
			
			XSSFWorkbook book = new XSSFWorkbook("D:\\eclipse\\BBEComSelE2E\\src\\test\\resources\\TestData\\Productlist.xlsx");
			XSSFSheet sheet = book.getSheet(sheetname);
			int rowcount = sheet.getLastRowNum();
			short columncount = sheet.getRow(0).getLastCellNum();
			
			String[][] data = new String[rowcount][columncount];
			for(int i = 1 ; i <= rowcount; i++) {
				
				XSSFRow row = sheet.getRow(i);
				
				for(int j = 0; j < columncount; j++) {
					
					XSSFCell cell = row.getCell(j);
					data[i-1][j]=cell.getStringCellValue();
				}
			}
			
			book.close();
			return data;
		}
}
