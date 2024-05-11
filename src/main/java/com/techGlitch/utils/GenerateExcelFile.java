package com.techGlitch.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.List;

@Slf4j
public class GenerateExcelFile {


    public byte[] generateFileForExcelExportCommon(List<?> dataList, String fullyQualifiedClassName, String sheetName, String headersForExcel) throws NoSuchFieldException, ClassNotFoundException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(sheetName);
        new ArrayList<>();
        if (headersForExcel.isEmpty() || headersForExcel.equals("null")) {
            log.info("Excel Creation Method Encountered an Error");
        } else {
            String[] headersArray = headersForExcel.split(",");
            List<String> headersList = Arrays.asList(headersArray);
            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setBold(true);
            style.setFont(font);
            style.setFillBackgroundColor(IndexedColors.DARK_BLUE.getIndex());
            style.setFillPattern(FillPatternType.forInt(3));
            int headerCount = 0;
            Row headerRow = sheet.createRow(headerCount);

            for (Iterator var12 = headersList.iterator(); var12.hasNext(); ++headerCount) {
                String headerName = (String) var12.next();
                headerRow.createCell(headerCount).setCellValue(headerName);
                headerRow.getCell(headerCount).setCellStyle(style);
            }

            try {
                Class<?> clazz = Class.forName(fullyQualifiedClassName);

                try {

                    List<String> fieldsNameList = new ArrayList();
                    Field[] fields = clazz.getFields();
                    Field[] var15 = fields;
                    int var16 = fields.length;

                    for (int var17 = 0; var17 < var16; ++var17) {
                        Field f = var15[var17];
                        fieldsNameList.add(f.getName());
                    }
                    int rowCount = 1;
                    Iterator var31 = dataList.iterator();

                    while (var31.hasNext()) {
                        Object dto = var31.next();
                        Row dataRow = sheet.createRow(rowCount++);
                        for (int i = 0; i < fieldsNameList.size(); ++i) {
                            dataRow.createCell(i)
                                    .setCellValue((String) dto.getClass()
                                            .getDeclaredField((String) fieldsNameList
                                                    .get(i))
                                            .get(dto));

                        }
                    }
                } catch (IllegalAccessException var21) {
                    log.error("IllegalAccessException ==>" + var21);
                } catch (IllegalArgumentException var22) {
                    log.error("IllegalArgumentException ==>" + var22);
                } catch (SecurityException var23) {
                    log.error("SecurityException ==>" + var23);
                }
            } catch (ClassNotFoundException var24) {
                log.error("ClassNotFoundException ==> " + var24);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                try {
                    workbook.write(outputStream);
                } catch (IOException var20) {
                    var20.printStackTrace();
                }

                byte[] excelBytes = outputStream.toByteArray();
                String base64String = Base64.getEncoder().encodeToString(excelBytes);
                sheetName = null;
                headersForExcel = null;

                return excelBytes;

            }
            return null;
        }
        return null;

    }
}