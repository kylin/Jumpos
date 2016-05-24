package com.june.implemented.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.jxls.util.Util;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static boolean formulaEquals(String fo1,String fo2){
		if(fo1.startsWith("=")&& fo2.startsWith("=")){
			String s="[0-9]";
			Pattern pat=Pattern.compile(s);
			Matcher mat=pat.matcher(fo1);
			fo1=mat.replaceAll("");
			mat=pat.matcher(fo2);
			fo2=mat.replaceAll("");
		}
		return fo1.equals(fo2);
	}
	
    // 复制文件
    public void copyFile(File sourceFile, File targetFile) throws Exception {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } finally {
            // 关闭流
            if (inBuff != null)
                inBuff.close();
            if (outBuff != null)
                outBuff.close();
        }
    }
	
    
     public static void insertRow(XSSFWorkbook wb, XSSFSheet sheet, int startRow,int rows) {  
    	 if(rows == 0) return;
          sheet.shiftRows(startRow + 1, sheet.getLastRowNum(), rows,true,false);  
          //  Parameters:  
          //   startRow - the row to start shifting  
          //   endRow - the row to end shifting  
          //   n - the number of rows to shift  
          //   copyRowHeight - whether to copy the row height during the shift  
          //   resetOriginalRowHeight - whether to set the original row's height to the default  
          sheet.createRow(startRow); 
  
          for (int i = 0; i < rows; i++) {  
                
                XSSFRow sourceRow = null;  
                XSSFRow targetRow = null;  
                  
                sourceRow = sheet.getRow(startRow);  
                targetRow = sheet.createRow(++startRow);  
                  
                Util.copyRow(sheet, sourceRow, targetRow);  
          }  
            
    }  
     public static void insertRow(HSSFWorkbook wb, HSSFSheet sheet, int startRow,int rows) {  
         if(rows == 0) return;
    	 sheet.shiftRows(startRow + 1, sheet.getLastRowNum(), rows,true,false);  
    	 //  Parameters:  
    	 //   startRow - the row to start shifting  
    	 //   endRow - the row to end shifting  
    	 //   n - the number of rows to shift  
    	 //   copyRowHeight - whether to copy the row height during the shift  
    	 //   resetOriginalRowHeight - whether to set the original row's height to the default  
    	 sheet.createRow(startRow); 
    	 
    	 for (int i = 0; i < rows; i++) {  
    		 
    		 HSSFRow sourceRow = null;  
    		 HSSFRow targetRow = null;  
    		 
    		 sourceRow = sheet.getRow(startRow);  
    		 targetRow = sheet.createRow(++startRow);  
    		 
    		 Util.copyRow(sheet, sourceRow, targetRow);  
    	 }  
    	 
     }  
	
	/**
	 * 根据标签获得所在行的行数
	 */
	public int getRowIndex(String path,String flagName) throws Exception{
		Workbook workBook = null;
		Cell cell=null;
		Sheet sheet=null;
		Row row=null;
		int rowIndex = 0;
		FileInputStream fis = new FileInputStream(path);
		if (path.endsWith(".xls")) {
			workBook = new HSSFWorkbook(fis); // 2003
			for (int i = 0; i < workBook.getNumberOfNames(); i++) {
				Name aNamedCell = workBook.getNameAt(i);
				sheet=workBook.getSheet(aNamedCell.getSheetName());
				//System.out.println("sheetName:"+sheet.getSheetName());
				// 命名单元格是属于整个表格文件，而不是某个sheet
				// 得到名称
				String name = aNamedCell.getNameName();
				// 得到备注
				String comment = aNamedCell.getComment();
				if(name != null && name.equals(flagName)){
					//获得一个指向该区域的对象
					AreaReference aref= new AreaReference(aNamedCell.getRefersToFormula());
					//获得一个数组，存储了这块区域的所有的单元格的指向
					CellReference[] crefs = aref.getAllReferencedCells();
					//获得某个单元格的坐标
					for(CellReference cref:crefs){
						int x=cref.getRow();
						int y=cref.getCol();
						if(rowIndex < x){
							rowIndex = x;
						}
					}
				}
				
			}
			
		} else if (path.endsWith(".xlsx")) {
			workBook = new XSSFWorkbook(fis); // 2007
			for (int i = 0; i < workBook.getNumberOfNames(); i++) {
				Name aNamedCell = workBook.getNameAt(i);
				sheet=workBook.getSheet(aNamedCell.getSheetName());
				//System.out.println("sheetName:"+sheet.getSheetName());
				// 命名单元格是属于整个表格文件，而不是某个sheet
				// 得到名称
				String name = aNamedCell.getNameName();
				// 得到备注
				String comment = aNamedCell.getComment();
				if(name != null && name.equals(flagName)){
					//获得一个指向该区域的对象
					AreaReference aref= new AreaReference(aNamedCell.getRefersToFormula());
					//获得一个数组，存储了这块区域的所有的单元格的指向
					CellReference[] crefs = aref.getAllReferencedCells();
					//获得某个单元格的坐标
					for(CellReference cref:crefs){
						int x=cref.getRow();
						int y=cref.getCol();
						if(rowIndex < x){
							rowIndex = x;
						}
					}
				}
				
			}
			
		}
		return rowIndex;
	}
	
	public static String getCellStringValue(Cell cell){

		String result="";
		if (null != cell) {  
            switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: // ????  
                result=String.valueOf(cell.getNumericCellValue());
                break;  
            case Cell.CELL_TYPE_STRING: // ???  
                result=cell.getStringCellValue();  
                break;  
            case Cell.CELL_TYPE_BOOLEAN: // Boolean  
                result=String.valueOf(cell.getBooleanCellValue());  	                                
                break;  
            case Cell.CELL_TYPE_FORMULA: // ???  
               result="="+cell.getCellFormula();  
                break;  
            case Cell.CELL_TYPE_BLANK: // ???  
               result="";  
                break;  
            case Cell.CELL_TYPE_ERROR: // ????  
             result="error";  
                break;  
            default:  
            	result="";
               System.out.print("无法识别的类型");  
                break;  
          }
		}
		if(result==null||result.isEmpty()) return "";
		return result;
	
	}
	public static Object getCellValue(Cell cell){
		Object result="";
		if (null != cell) {  
            switch (cell.getCellType()) {  
            case Cell.CELL_TYPE_NUMERIC: // number 
            	if(DateUtil.isCellDateFormatted(cell))// 数字
            		result=cell.getDateCellValue();
            	else result=cell.getNumericCellValue();
                break;  
            case Cell.CELL_TYPE_STRING: // string
                result=cell.getStringCellValue();  
                break;  
            case Cell.CELL_TYPE_BOOLEAN: // boolean  
                result=cell.getBooleanCellValue();  	                                
                break;  
            case Cell.CELL_TYPE_FORMULA: // formula  
               	result="="+cell.getCellFormula();  
                break;  
            case Cell.CELL_TYPE_BLANK: // blank  
               	result=new String("");  
                break;  
            case Cell.CELL_TYPE_ERROR: // error  
             	result=new String("ERROR");  
                break;  
            default:  
            	result=new String("");
               	System.out.print("Unknow Type");  
                break;  
          }
		}
		return result;
	}
	
}
