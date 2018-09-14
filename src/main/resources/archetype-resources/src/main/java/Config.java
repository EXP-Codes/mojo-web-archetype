#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

/**
 * <PRE>
 * 配置加载器
 * </PRE>
 * <br/><B>PROJECT : </B> xxxxxxx
 * <br/><B>SUPPORT : </B> <a href="http://www.exp-blog.com" target="_blank">www.exp-blog.com</a> 
 * @version   xxxxxxx
 * @author    xxxxxxx
 * @since     jdk版本：jdk1.6
 */
public class Config {
	
	private static volatile Config instance;
	
	private Config() {}
	
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
	
}
