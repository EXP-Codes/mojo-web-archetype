#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}._demo.web.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import ${package}._demo.Config;

/**
 * 基于注解方式配置的Controller
 * 此demo与 spring-mvc.xml 配置文件配套
 */
@Controller
public class AnnotationController extends AbstractController{

	private final static Logger log = LoggerFactory.getLogger(AnnotationController.class);
	
    @Override
    @RequestMapping(value="/demo-annotation")	// 在请求URL中包含此路径时则映射到此方法
    protected ModelAndView handleRequestInternal(
    		HttpServletRequest request, HttpServletResponse response) 
    				throws Exception {
    	
    	// ---------------------------------------------------
    	// TODO 业务逻辑
    	System.out.println("AnnotationController Working.");
    	log.debug("AnnotationController Work In: {}", "DEBUG");
    	log.info("AnnotationController Work In: {}", "INFO");
    	log.warn("AnnotationController Work In: {}", "WARN");
    	log.error("AnnotationController Work In: {}", "ERROR");
    	// ---------------------------------------------------
    	
    	
    	ModelAndView mv = new ModelAndView();
    	
    	// 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
    	// 在本例中会根据spring-mvc.xml的视图解析器viewResolver的配置跳转到 
    	//   /WEB/INF/pages/demo-mvc-response.jsp页面
    	mv.setViewName("demo-mvc-response");
    	
    	// 添加模型数据 可以是任意的POJO对象
		mv.addObject("message", "This is a AnnotationController");
		mv.addObject("time", System.currentTimeMillis());
		mv.addObject("socket", Config.getInstn().getSocket().getSocket());
		return mv;
    }

}
