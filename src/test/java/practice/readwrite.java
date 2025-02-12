package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class readwrite {

	static String path = "C:\\Users\\91805\\OneDrive\\Desktop\\New\\detail.xlsx";
	
	public static void read() throws IOException {
		FileInputStream f = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(path);
		XSSFSheet sheet = book.getSheet("task");
		for(Row row: sheet) {
			for(Cell cel : row) {
				System.out.println(cel);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		read();
	}
}
