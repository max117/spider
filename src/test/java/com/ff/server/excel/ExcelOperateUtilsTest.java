
package com.ff.server.excel;

import org.junit.Test;

public class ExcelOperateUtilsTest {

    @Test
    public void getXls(){
        
        ExcelOperateUtils excelOperateUtils = new ExcelOperateUtils();
        String path = "C:\\Users\\fengjuzhi\\Desktop\\走访统计.xls";
        excelOperateUtils.readExcel(path);
    }
}

