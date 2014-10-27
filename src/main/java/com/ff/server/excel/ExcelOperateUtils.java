package com.ff.server.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @ClassName: ExcelOperateUtils
 * @Description: Excel操作类
 * @author fengjiuchen
 * @date 2014年7月22日 下午2:34:45
 * @version 1.0
 */
public class ExcelOperateUtils {

    /**
     * @Title: readExcel
     * @Description: 读Excel
     * @date 2014年7月22日 下午3:31:03
     * @return void
     * @throws
     */
    public void readExcel(String path) {

        try {
            if ("xls".equals(path.substring(path.lastIndexOf(".") + 1).trim().toLowerCase())) {
                HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(path));
                xlsExcelRead(hssfWorkbook);
            } else if ("xlsx".equals(path.substring(path.lastIndexOf(".") + 1).trim().toLowerCase())) {
                XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(path));
                xlsxExcelRead(xssfWorkbook);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Title: xlsExcelRead
     * @Description: xls类型的Excel读取
     * @param hssfWorkbook
     * @date 2014年7月22日 下午3:31:31
     * @return void
     * @throws
     */
    public void xlsExcelRead(HSSFWorkbook hssfWorkbook) {

        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                // 循环列Cell
                for (int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
                    HSSFCell hssfCell = hssfRow.getCell(cellNum);
                    if (hssfCell == null) {
                        continue;
                    }
                    System.out.print("\t" + hssfCell.getStringCellValue());
                }
            }
        }
    }

    /**
     * @Title: xlsxExcelRead
     * @Description: xlsx类型的Excel读取
     * @param xssfWorkbook
     * @date 2014年7月22日 下午3:32:14
     * @return void
     * @throws
     */
    public void xlsxExcelRead(XSSFWorkbook xssfWorkbook) {

        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow == null) {
                    continue;
                }
                // 循环列Cell
                for (int cellNum = 0; cellNum <= xssfRow.getLastCellNum(); cellNum++) {
                    XSSFCell xssfCell = xssfRow.getCell(cellNum);
                    if (xssfCell == null) {
                        continue;
                    }
                    System.out.print("\t" + String.valueOf(xssfCell.getStringCellValue()));
                }
            }
        }
    }

    /**
     * @Title: writeExcel 
     * @Description: 写Excel
     * @param path
     * @param map 
     * @date 2014年7月22日 下午4:30:47 
     * @return void 
     * @throws
     */
    public void writeExcel(String path, Map<String, Object> map) {

        try {
            if ("xls".equals(path.substring(path.lastIndexOf(".") + 1).trim().toLowerCase())) {
                HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(path));
                xlsExcelWrite(path, map, hssfWorkbook);
            } else if ("xlsx".equals(path.substring(path.lastIndexOf(".") + 1).trim().toLowerCase())) {
                XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(path));
                xlsExcelWrite(path, map, xssfWorkbook);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void xlsExcelWrite(String path, Map<String, Object> map, Workbook workbook) {

        if (null != map && null != path) {
            List<Object> headList = (List<Object>) map.get("HEADERINFO");
            List<TreeMap<String, Object>> dataList = (List<TreeMap<String, Object>>) map.get("DATAINFON");
            Sheet sheet = workbook.createSheet();
            /**
             * 设置Excel表的第一行即表头
             */
            Row row = sheet.createRow(0);
            for (int i = 0; i < headList.size(); i++) {
                Cell headCell = row.createCell(i);
                headCell.setCellType(Cell.CELL_TYPE_STRING);
                headCell.setCellValue(String.valueOf(headList.get(i)));
            }

            for (int i = 0; i < dataList.size(); i++) {
                Row rowdata = sheet.createRow(i + 1);// 创建数据行
                TreeMap<String, Object> mapdata = dataList.get(i);
                Iterator<String> it = mapdata.keySet().iterator();
                int j = 0;
                while (it.hasNext()) {
                    String strdata = String.valueOf(mapdata.get(it.next()));
                    Cell celldata = rowdata.createCell(j);
                    celldata.setCellType(Cell.CELL_TYPE_STRING);
                    celldata.setCellValue(strdata);
                    j++;
                }
            }
            File file = new File(path);
            OutputStream os;
            try {
                os = new FileOutputStream(file);
                os.flush();
                workbook.write(os);
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            } 
        }
    }

}
