#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}._demo.web.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import ${package}._demo.Config;

/**
 * 基于BeanName-URL方式配置的Controller
 * 此demo与 spring-bean.xml 配置文件配套
 */
public class BeanNameUrlController implements Controller {
	
	private final static Logger log = LoggerFactory.getLogger(BeanNameUrlController.class);
	
	@Override
	public ModelAndView handleRequest(
			HttpServletRequest request, HttpServletResponse response) 
    				throws Exception {
		
		// ---------------------------------------------------
    	// TODO 业务逻辑
    	System.out.println("BeanNameUrlController Working.");
    	log.debug("BeanNameUrlController Work In: {}", "DEBUG");
    	log.info("BeanNameUrlController Work In: {}", "INFO");
    	log.warn("BeanNameUrlController Work In: {}", "WARN");
    	log.error("BeanNameUrlController Work In: {}", "ERROR");
    	// ---------------------------------------------------
    	
    	
    	ModelAndView mv = new ModelAndView();
    	
    	// 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
    	// 在本例中会根据spring-bean.xml的视图解析器viewResolver的配置跳转到 
    	//   /WEB/INF/pages/demo-mvc-response.jsp页面
    	mv.setViewName("demo-mvc-response");
    	
    	// 添加模型数据 可以是任意的POJO对象
		mv.addObject("message", "This is a BeanNameUrlController");
		mv.addObject("time", System.currentTimeMillis());
		mv.addObject("socket", Config.getInstn().getSocket().getSocket());
		return mv;
	}
	
}
