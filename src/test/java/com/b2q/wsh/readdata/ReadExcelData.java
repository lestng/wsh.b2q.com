package com.b2q.wsh.readdata;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ReadExcelData {
    /*public static void main(String[] args) {
        Object[][] ont=getExcelData("dataTestEx.xlsx");
        for (int i=0;i<ont.length;i++){
            for(int j=0;j<ont[i].length;j++){
                System.out.print(ont[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println(ont);
    }*/
    //Excel文件内容获取
    public static Object[][] getExcelData(String filename){
        Object[][] objs=null;
        //获取文件
        InputStream is = ReadExcelData.class.getClassLoader().getResourceAsStream(filename);
        Workbook wk = null;
        try {
            wk = new XSSFWorkbook(is);
            Sheet sheet = wk.getSheet("Sheet1");
            int lastRowNum = sheet.getLastRowNum();
            Row titleRow = sheet.getRow(0);
            int lastCellNum = titleRow.getLastCellNum();
            objs = new Object[lastRowNum][lastCellNum];
            for (int i=0;i<objs.length;i++){
                Row row=sheet.getRow(i+1);
                for (int j=0;j<objs[i].length;j++){
                    objs[i][j]=getObject(row.getCell(j));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                wk.close();
                is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return objs;
    }
    //进行文件内容的数据类型判断并获取值
    private static Object getObject(Cell cell){
        Object data = null;
        switch (cell.getCellTypeEnum()){
            case BOOLEAN:
                data=cell.getBooleanCellValue();
                break;
            case NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)){
                    data=cell.getDateCellValue();
                }else {
                    data=double2int(cell.getNumericCellValue());
                }
                break;
            case STRING:
                data=cell.getStringCellValue();
                break;
            default:
                data=null;
        }
        return data;
    }
    //将double类型的数据转变为int类型 数据类型转换
    private static Object double2int(double from){
        if (from - (int)from == 0){
            return (int)from;
        }else {
            return from;
        }
    }
}
