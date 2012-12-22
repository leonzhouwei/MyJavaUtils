package main.java.com.example.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;

public class OutputExcel {

	public static void outputExcel() throws IOException {
		// 创建一个excel文件
		Workbook wb = new HSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();
		// 创建两个sheet
		Sheet sheet1 = wb.createSheet("sheet1");
		// Sheet sheet2 = wb.createSheet("sheet2");

		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat(
				"yyyy-MM-DD hh:mm:ss"));

		// 创建标题
		// 创建一行，从0开始
		Row row1 = sheet1.createRow(0);
		row1.createCell(0).setCellValue("测试1");
		row1.createCell(1).setCellValue("测试2");
		row1.createCell(2).setCellValue("测试3");
		row1.createCell(3).setCellValue("测试4");
		row1.createCell(4).setCellValue("测试5");
		row1.createCell(5).setCellValue("测试6");
		row1.createCell(6).setCellValue("图片");

		// 创建真正的值
		Row row = sheet1.createRow(1);

		// 创建两个图片数据
		InputStream is = new FileInputStream("resources/image1.jpg");
		InputStream is2 = new FileInputStream("resources/google.png");
		byte[] bytes = IOUtils.toByteArray(is);
		byte[] bytes2 = IOUtils.toByteArray(is2);
		int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
		int pictureIdx2 = wb.addPicture(bytes2, Workbook.PICTURE_TYPE_JPEG);
		is.close();
		is2.close();

		// 创建一个单元格，从0开始
		Cell cell = row.createCell(0);
		cell.setCellValue(1);

		// 或者在一行中写完
		row.createCell(1).setCellValue(1.2);
		row.createCell(2).setCellValue(
				createHelper.createRichTextString("This is a string"));
		row.createCell(3).setCellValue(true);
		row.createCell(4).setCellValue("测试");
		Cell cell5 = row.createCell(5);
		cell5.setCellValue(new Date());
		cell5.setCellStyle(cellStyle);
		Cell cell6 = row.createCell(6);
		// Create the drawing patriarch. This is the top level container for all
		// shapes.
		Drawing drawing = sheet1.createDrawingPatriarch();

		// add a picture shape
		ClientAnchor anchor = createHelper.createClientAnchor();
		int x1 = 0;
		int y1 = 0;
		int x2 = 800;
		int y2 = 255;
		// 前四个参数x1,y1,x2,y2 是图片以所在单元格位基础的坐标
		// 后四个参数代表作在的行和列的单元格,从0开始
		HSSFClientAnchor anchor2 = new HSSFClientAnchor(x1, y1, x2, y2,
				(short) 6, 1, (short) 6, 1);
		// set top-left corner of the picture,
		// subsequent call of Picture#resize() will operate relative to it
		// 设置图片左上角的位置

		// 添加第一张图片
		anchor.setCol1(6);
		anchor.setCol2(7);
		anchor.setRow1(1);
		anchor.setRow2(2);

		Picture pict = drawing.createPicture(anchor, pictureIdx);

		// 添加第二张图片

		anchor2.setAnchorType(2);
		Picture pict2 = drawing.createPicture(anchor2, pictureIdx2);

		// auto-size picture relative to its top-left corner
		// Picture.resize() works only for JPEG and PNG. Other formats are not
		// yet supported.
		pict.resize();

		// resize 上面设置的坐标就白设了
		// pict2.resize();

		FileOutputStream fileOut = new FileOutputStream("resources/output.xls");
		wb.write(fileOut);
		fileOut.close();
		//
		// Workbook wb = new XSSFWorkbook();
		// FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
		// wb.write(fileOut);
		// fileOut.close();

	}

	public static void main(String[] args) {
		try {
			OutputExcel.outputExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}