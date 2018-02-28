package com.b2q.wsh.readdata;

import org.testng.annotations.DataProvider;

public class DataParamater {
    @DataProvider(name = "wsh_login_data")
    public Object[][] getParamaterData(){
        Object[][] objs = ReadExcelData.getExcelData("logindata.xlsx");
        for(int i=0;i<objs.length;i++){
            objs[i][1]=objs[i][1]+"";
        }
        return objs;
    }
    /*@DataProvider(name = "wsh_procond_data")*/


}
