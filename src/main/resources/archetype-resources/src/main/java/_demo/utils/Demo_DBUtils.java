#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}._demo.utils;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import exp.libs.warp.db.sql.DBUtils;
import exp.libs.warp.db.sql.bean.DataSourceBean;
import ${package}._demo.Config;

/**
 * <PRE>
 * DB工具 样例
 * </PRE>
 * <br/><B>PROJECT : </B> exp-libs
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   2017-08-17
 * @author    EXP: 272629724@qq.com
 * @since     jdk版本：jdk1.6
 */
public class Demo_DBUtils {

	/**
	 * 增删改查样例
	 */
	@SuppressWarnings("unused")
	public void demoForADUQ() {
		DataSourceBean ds = Config.getInstn().getDataSource();
//		ds.setDriver(DBType.MYSQL.DRIVER);	// 修改数据源配置（可选）
//		ds.set....
		
		Connection conn = DBUtils.getConn(ds);	// 先用连接池、失败则用JDBC, 最多重试10次
//		conn = DBUtils.getConn(ds, 3);		// 先用连接池、失败则用JDBC, 最多重试3次
//		conn = DBUtils.getConnByJDBC(ds);	// 强制使用JDBC取连接, 失败不重试
//		conn = DBUtils.getConnByPool(ds);	// 强制使用连接池取连接, 失败不重试
		
		// 查询结果集为单个数值
		String sql = "select count(1) from table where ...";
		int num = DBUtils.queryInt(conn, sql);
		
		// 查询 【key值为key, value值为val】 的表单数据
		sql = "select key, value from table where ...";
		Map<String, String> kvs = DBUtils.queryKVS(conn, sql);
		Map<String, Object> kvo = DBUtils.queryKVO(conn, sql);
		
		// 查询 【列名为key, 列值为val】 的多行数据
		sql = "select * from table where ...";
		List<Map<String, String>> sDatas = DBUtils.queryKVSs(conn, sql);
		List<Map<String, Object>> oDatas = DBUtils.queryKVOs(conn, sql);
		
		// 查询 【列名为key, 列值为val】 的第一行数据
		sql = "select * from table where ...";
		Map<String, String> sRow = DBUtils.queryFirstRowStr(conn, sql);
		Map<String, Object> oRow = DBUtils.queryFirstRowObj(conn, sql);
		
		// 查询第N列数据
		sql = "select col from table where ...";
		List<String> sCol = DBUtils.queryColumnStr(conn, sql, 8);
		List<Object> oCol = DBUtils.queryColumnObj(conn, sql, 8);
				
		// 增删改
		sql = "insert/update/delete ...";
		boolean isOk = DBUtils.execute(conn, sql);
		
		// 存储过程
		String proSql = "SP_DEMO(?, ?, ...)";
		Object[] params = { 0, "demo" };
		List<Map<String, Object>> rst = DBUtils.callSP(conn, proSql, params);
		
		DBUtils.close(conn);
	}
	
	/**
	 * JavaBean 样例
	 */
	@SuppressWarnings("unused")
	public void demoForBean() {
		DataSourceBean ds = Config.getInstn().getDataSource();
		Connection conn = DBUtils.getConn(ds);
		
		// 转换物理表为JavaBean对象
		boolean isOk = DBUtils.createBeanFromDB(conn, 
				"foo.bar.bean", // 所生成的JaveBean类的包路径
				"./src/main/java/foo/bar/bean", // JaveBean类的输出目录
				new String[] { "table1", "table2" });	// 要转换的表名
		
		String sql = "select * from table where ...";
//		List<JavaBean> beans = DBUtils.query(JavaBean.class, conn, sql);
//		
//		JavaBean.insert(...);
//		JavaBean.delete(...);
//		JavaBean.update(...);
//		JavaBean.query(...);
		
		DBUtils.close(conn);
	}
	
}
