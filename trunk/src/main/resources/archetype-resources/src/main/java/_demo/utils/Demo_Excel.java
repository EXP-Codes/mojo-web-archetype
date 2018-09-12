#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}._demo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import exp.libs.warp.xls.Excel;
import exp.libs.warp.xls.Sheet;

/**
 * <PRE>
 * Excel 样例
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   2017-08-17
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class Demo_Excel {

	/**
	 * Excel 样例
	 */
	public void demo() {
		Excel excel = new Excel("C:\\Users\\Administrator\\Desktop\\2003.xls");
		excel.clear();	// 仅清空内存，不调用save/saveAs方法不会清空文件
		
		List<String> header = Arrays.asList(new String[] { "序号", "姓名", "Remark" });
		List<List<Object>> datas = new ArrayList<List<Object>>();
		datas.add(Arrays.asList(new Object[] { "1", "张三", 98.999D }));
		datas.add(Arrays.asList(new Object[] { "2", "李四", 1234567890123L }));
		datas.add(Arrays.asList(new Object[] { "3", "王五", new Date() }));
		datas.add(Arrays.asList(new Object[] { "4", "肾六", "hello excel" }));
		datas.add(Arrays.asList(new Object[] { "5", "田七", null }));
		int page = excel.createPagingSheets(header, datas, "TEST-", 2);
		System.out.println(page);
		
		boolean isOk = excel.saveAs("C:\\Users\\Administrator\\Desktop\\2007.xlsx");
		System.out.println(isOk);
		
		Sheet sheet = excel.getSheet(0);
		List<Object> rowDatas = sheet.getRowDatas(1);
		System.out.println(rowDatas);
		
		sheet.delRow(1);
		sheet.addRowDatas(Arrays.asList(new Object[] { "谁说的要对齐" }));
		isOk = excel.save();
		System.out.println(isOk);
	}
}
