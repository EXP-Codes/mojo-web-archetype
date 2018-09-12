#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}._demo;

import java.util.List;
import java.util.Map;

import exp.libs.envm.Charset;
import exp.libs.warp.conf.xml.XConfig;
import exp.libs.warp.conf.xml.XConfigFactory;
import exp.libs.warp.db.sql.bean.DataSourceBean;
import exp.libs.warp.net.sock.bean.SocketBean;

/**
 * <PRE>
 * XML配置加载器 [exp.libs.warp.conf.xml.XConfig] 使用参考.
 * </PRE>
 * <br/><B>PROJECT : </B> xxxxxxx
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   xxxxxxx
 * @author    xxxxxxx
 * @since     jdk版本：jdk1.6
 */
public class Config {
	
	/** 程序配置文件（全量配置） */
	private final static String APP_CONF = "./conf/[prj-name]_conf.dat";
	
	/** 工程配置文件（常用配置） */
	private final static String USE_CONF = "./conf/[prj-name]_conf.xml";
	
	public final static String DEFAULT_CHARSET = Charset.UTF8;
	
	private final static String SOCK_NAME = "TEST-SOCK";
	
	private final static String DS_NAME = "TEST-DS";
	
	/** XML配置加载器 */
	private XConfig xConf;
	
	private static volatile Config instance;
	
	private Config() {
		this.xConf = XConfigFactory.createConfig("EXP-DEMO");
		xConf.loadConfFile(APP_CONF);	// 先加载全量配置文件
		xConf.loadConfFile(USE_CONF);	// 使用工程配置文件覆盖全量配置中同位置配置项
	}
	
	public static Config getInstn() {
		if(instance == null) {
			synchronized (Config.class) {
				if(instance == null) {
					instance = new Config();
				}
			}
		}
		return instance;
	}
	
	/**
	 * 定时刷新配置文件
	 * @param timeMillis 刷新间隔(ms)
	 */
	public void reflash(long timeMillis) {
		xConf.reflash(timeMillis);
	}
	
	/**
	 * 清理配置缓存.
	 * 	一般在程序终止前调用
	 */
	public void clear() {
		xConf.destroy();
	}
	
	/**
	 * 根据配置文件的socket结构体，获取socket配置对象
	 * @return
	 */
	public SocketBean getSocket() {
		return xConf.getSocketBean(SOCK_NAME);
	}
	
	/**
	 * 根据配置文件的datasource结构体，获取datasource配置对象
	 * @return
	 */
	public DataSourceBean getDataSource() {
		return xConf.getDataSourceBean(DS_NAME);
	}
	
	/**
	 * 取值样例
	 */
	@Deprecated
	@SuppressWarnings("unused")
	public void loadExample() {
		// 取对象
		DataSourceBean ds = xConf.getDataSourceBean(DS_NAME);
		SocketBean sb = xConf.getSocketBean(SOCK_NAME);

		// 取枚举值
		List<String> enums = xConf.getEnums("enumTag@EX-A");
		
		// 取字符串
		String port = xConf.getVal("port");	// 重名标签返回第一个值
		String dsPort = xConf.getVal("config/datasources/datasource@TEST/port");
		String sockPort = xConf.getVal("config/sockets/socket@TEST/port");
		
		// 取数值
		int maxConn = xConf.getInt("maximum-connection-count");
		int foob = xConf.getInt("foo", "b");
		long lifeTime = xConf.getInt("config/datasources/datasource@TEST/maximum-connection-lifetime");
		
		// 取属性值
		String caption = xConf.getAttribute("config/sockets/socket/delimiter", "caption");
		String hint = xConf.getAttribute("config/sockets/socket@TEST/delimiter", "hint");
		
		// 取属性集
		Map<String, String> attributs = xConf.getAttributes("enumTag@EX-B");
	}
	
}
