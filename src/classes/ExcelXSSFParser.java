package classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import org.apache.commons.compress.archivers.dump.InvalidFormatException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import org.apache.poi.xssf.usermodel.XSSFSheet;




public class ExcelXSSFParser {
	
	 FileInputStream file ; 
         ArrayList<String> values = new ArrayList<>();
    //create workbook instance refer to xlsx file
	 
         File fichier;
	 
	
	public ExcelXSSFParser(File fil) throws IOException {
		super();
        
                fichier=fil;
		this.file = new FileInputStream(fil);	
                 System.out.println(7777);
	}
 
	  	
	//that is for evaluate the cell type
	 

	public void excelParserAndSave() throws IOException, SQLException ,InvalidFormatException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		  System.out.println(111);	
                  System.out.println(fichier.getName());
                  String extension=fichier.getName().substring(fichier.getName().indexOf(".")+1, fichier.getName().length());
                  System.out.println(extension);	
                  String sql = "insert into employees values"+"(?,?,?,?,?,?,?,?,?,?,?)";
                  int i;
                  PreparedStatement preparedStatement=null;
                  Connection conn =null;
                  if(extension.equals("xlsx")||extension.equals("xlsm")){
                  XSSFWorkbook workbook=null; 
                  XSSFSheet sheet=null;
                  workbook = new XSSFWorkbook(file); 
                  sheet = workbook.getSheetAt(0);        
		  FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
	
                ///////////////////////////////
                 
                      
		 	//read ligne per ligne
                 System.out.println(6666);
                  
                         
       // Row row;
        for(Row row : sheet){
                values.clear();
        	if(row.getRowNum()==0) {
    			System.out.println("create table wma lezù :)");
    		}
    		else {
        	for (Cell cell : row) {
        		
        		switch(formulaEvaluator.evaluateInCell(cell).getCellType()) 
        		{
        			case NUMERIC:
        				values.add(Integer.toString((int)cell.getNumericCellValue()));
        				break;
        			case STRING:
        				values.add(cell.getStringCellValue());
        		
        				break;
        		
        		}
        		}
                 
                         // conn = DriverManager.getConnection("jdbc:derby://localhost:1527/supervisor", "jasser", "jasser");
                          conn= DBConnecter.connectionDB();
                          preparedStatement =conn.prepareStatement(sql);
                          preparedStatement.setInt(1,Integer.parseInt(values.get(0)));
                           System.out.println(9887);
                             
                         for (i=1;i<values.size() ;i++){
                             preparedStatement.setString(i+1, values.get(i).replace("'", "''"));
                         }
                         
        		  System.out.println("hmmmm");
                           System.out.println(sql);
                          preparedStatement.executeUpdate();
                }
        	
        	
        		
        		
        	}
	
	/////////////// if (extension.equals("xls"))
          }
                  else{
                  HSSFWorkbook workbook=null; 
                  HSSFSheet sheet=null;
                  workbook = new HSSFWorkbook(file); 
                  sheet = workbook.getSheetAt(0);        
		  FormulaEvaluator formulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
	
                  
                  	 	//read ligne per ligne
                 System.out.println(6666);
                  
                         
       // Row row;
        for(Row row : sheet){
                values.clear();
        	if(row.getRowNum()==0) {
    			System.out.println("create table wma lezù :)");
    		}
    		else {
        	for (Cell cell : row) {
        		
        		switch(formulaEvaluator.evaluateInCell(cell).getCellType()) 
        		{
        			case NUMERIC:
        				values.add(Integer.toString((int)cell.getNumericCellValue()));
        				break;
        			case STRING:
        				values.add(cell.getStringCellValue());
        		
        				break;
        		
        		}
        		}
                 
                        //  conn = DriverManager.getConnection("jdbc:derby://localhost:1527/supervisor", "jasser", "jasser");
                          conn=DBConnecter.connectionDB();
                          preparedStatement =conn.prepareStatement(sql);
                          preparedStatement.setInt(1,Integer.parseInt(values.get(0)));
                          System.out.println(9887);
                             
                         for (i=1;i<values.size() ;i++){
                             preparedStatement.setString(i+1, values.get(i).replace("'", "''"));
                         }
                         
        		  System.out.println("hmmmm");
                           System.out.println(sql);
                          preparedStatement.executeUpdate();
                }
        	
        	
        		
        		
        	}
                  
                    
                  }
	
	
	}
	
        	

}

