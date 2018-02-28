package com.b2q.wsh.monitor;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class WSHTestJournal extends TestListenerAdapter{
    @Override
    public void onTestFailure(ITestResult iTestResult){
        String name = iTestResult.getMethod().getMethodName();
        System.err.println("方法："+name+"运行失败了");
    }

}
