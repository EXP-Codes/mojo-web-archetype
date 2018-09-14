<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>Spring MVC Response Page</title>
	</head>
	<body>
	    <!-- 显示由Spring MVC的Controller处理器传过来的模型数据 -->
	    msg: ${message} 
	    <br/>
	    ts: ${time}
	    <br/>
        socket: ${socket}
	</body>
</html>