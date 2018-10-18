# mojo-web-archetype
Maven项目规范骨架（Web版）

------

- 自动化构建项目（告别重复劳动）
- 规范项目结构（只要创建，就是规范）
- 自动管理依赖构件（告别构件版本混乱）
- 一键发布项目/基线（告别dos/unix脚本命令）


## 运行环境

　![](https://img.shields.io/badge/Maven-3.2.5%2B-brightgreen.svg)  ![](https://img.shields.io/badge/JDK-1.7%2B-brightgreen.svg)


## 软件介绍

　快速创建一个规范架构的**Java Web项目（Maven版）**，使得**项目中自动内置**：

- **Spring/SpringMVC架构**
- [经验构件库](https://github.com/lyy289065406/exp-libs)：*用于快速开发的辅助包*
- war项目发布插件：*第三方插件`maven-war-plugin`，用于快速发布一个可运行应用到生产环境*
- 基线发布插件：*第三方插件`maven-release-plugin`，用于发布项目基线到版本库和 Nexus私服*


> 注：此骨架只能在J2EE中使用，若在J2SE中，会因为缺少Java Web组件会报错

## 使用说明

- 01.　本地已安装并部署好 `apache-maven-3.2.5`（或更高版本）
- 02.　下载本骨架项目 `mojo-web-archetype` 到本地，拷贝 `mojo-web-archetype/conf/archetype-catalog.xml` 文件到 `apache-maven-3.2.5/conf` 目录下，若目录下已存在同名文件，则只需把 `archetype-catalog.xml` 的内容附加进去即可：<br/>
```
<!-- Maven骨架 -->
<archetype>
  <groupId>exp.libs</groupId>
  <artifactId>mojo-web-archetype</artifactId>
  <version>1.0</version>   <!-- 注意版本号要根据实际发布的骨架版本号调整 -->
  <repository>http://127.0.0.1:8081/nexus/content/repositories/releases</repository> <!-- 若本地部署了Nexus私服则如实填写，这是releases库 -->
</archetype>
<archetype>
  <groupId>exp.libs</groupId>
  <artifactId>mojo-web-archetype</artifactId>
  <version>1.0-SNAPSHOT</version>  <!-- 同名骨架可配置多个版本号，但只有最高版本生效 -->
  <repository>http://127.0.0.1:8081/nexus/content/repositories/snapshots</repository> <!-- 若本地部署了Nexus私服则如实填写，这是snapshots库 -->
</archetype>
```
- 03.　通过 `maven install` 命令安装骨架到本地 Maven Repository
- 04.　（可选）若本地部署了 Nexus 私服，可通过 `maven deploy` 命令直接发布骨架到私服
- 05.　新建Maven项目，并选择此骨架进行项目构件：<br/>
![新建Maven项目](https://raw.githubusercontent.com/lyy289065406/mojo-web-archetype/master/doc/%E6%95%88%E6%9E%9C%E6%88%AA%E5%9B%BE/01-%E9%80%89%E6%8B%A9Maven%E9%AA%A8%E6%9E%B6.png)
- 06.　填写项目必要信息：<br/>
![填写项目必要信息](https://raw.githubusercontent.com/lyy289065406/mojo-web-archetype/master/doc/%E6%95%88%E6%9E%9C%E6%88%AA%E5%9B%BE/02-%E5%A1%AB%E5%86%99%E9%A1%B9%E7%9B%AE%E4%BF%A1%E6%81%AF.png)
- 07.　通过骨架所生成的项目，项目中会引用到 [`构件经验库 exp-libs`](https://github.com/lyy289065406/exp-libs) 的一些功能：<br/>
![通过骨架所生成的项目](https://raw.githubusercontent.com/lyy289065406/mojo-web-archetype/master/doc/%E6%95%88%E6%9E%9C%E6%88%AA%E5%9B%BE/03-%E7%94%9F%E6%88%90%E7%9A%84%E9%A1%B9%E7%9B%AE%E6%A8%A1%E6%9D%BF.png)
- 08.　通过 `maven install` 在 `target` 目录直接发布war包（拷贝到tomcat即可运行）：<br/>
![发布可运行项目到生产环境](https://raw.githubusercontent.com/lyy289065406/mojo-web-archetype/master/doc/%E6%95%88%E6%9E%9C%E6%88%AA%E5%9B%BE/04-%E5%8F%91%E5%B8%83%E9%A1%B9%E7%9B%AE.png)


## 运行效果

　通过 `Run on Server` 方式可在 Eclipse 中直接运行项目（当然把war包放到tomcat运行也是可以的）：

> 注：在 web.xml 切换 spring 配置文件可测试不同的控制器效果


![运行效果](https://raw.githubusercontent.com/lyy289065406/mojo-web-archetype/master/doc/%E6%95%88%E6%9E%9C%E6%88%AA%E5%9B%BE/05-%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C.png)


## 补充：通过本骨架所生成示例项目的 pom.xml 与 web.xml 文件

> 点击 [这里](https://github-production-release-asset-2e65be.s3.amazonaws.com/148517307/39b98c00-d16a-11e8-8e29-21fb4ca9a0c1?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20181016%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20181016T094123Z&X-Amz-Expires=300&X-Amz-Signature=badf0120ecd88889e126c25c9a84abb7d9a34a4eed2c25f2760536c5788f57f5&X-Amz-SignedHeaders=host&actor_id=17040287&response-content-disposition=attachment%3B%20filename%3Ddemo-archetype.zip&response-content-type=application%2Foctet-stream) 下载示例项目


- **pom.xml**<br/>
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!--项目基本信息(必填)-->
    <groupId>exp.libs</groupId>
    <artifactId>demo-web-archetype</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <name>项目名称(可选)</name>
    <description>项目描述(可选)</description>
    <url>项目SVN路径(可选)</url>
    <inceptionYear>工程的初始时间(可选)</inceptionYear>

    <!--项目的问题管理系统(可选)-->
    <issueManagement>
        <system>EXPLIBS-API-ONLINE</system>
        <url>https://lyy289065406.github.io/api-online/</url>
    </issueManagement>
    
    <!--项目的问题追踪系统(可选)-->
    <ciManagement>
        <system>jenkins</system>
        <url>http://127.0.0.1:8080/jenkins/</url>
    </ciManagement>

    <!-- 软件配置管理 -->
    <scm>
        <!-- 项目SVN主干目录（需保证目录已存在） -->
        <connection>scm:svn:http://127.0.0.1:81/svn/release/???/trunk</connection>
        <developerConnection>scm:svn:http://127.0.0.1:81/svn/release/???/trunk</developerConnection>
        <url>scm:svn:http://127.0.0.1:81/svn/release/???/trunk</url>
    </scm>

    <!-- 变量定义 -->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <jdk.version>1.6</jdk.version>
        <spring.version>3.1.2.RELEASE</spring.version>
        <explibs.version>1.0</explibs.version>
    </properties>


    <!-- 项目依赖 -->
    <dependencies>

        <!-- 经验库 -->
        <dependency>
          <groupId>exp.libs</groupId>
          <artifactId>exp-libs</artifactId>
          <version>${explibs.version}</version>
        </dependency>
        
        <!-- Servlet -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
        </dependency>

        <!-- Spring MVC -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
        </dependency>
        
        <dependency>
            <groupId>javax.servlet.jsp.jstl</groupId>
            <artifactId>jstl-api</artifactId>
            <version>1.2</version>
        </dependency>
        
        <dependency>
            <groupId>javax.servlet.jsp.jstl</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
            <classifier>sources</classifier>
        </dependency>
        
        <!-- 把Spring源代码中使用到的commons-logging替换成slf4j -->
        <dependency>  
          <groupId>org.slf4j</groupId>  
          <artifactId>jcl-over-slf4j</artifactId>  
          <version>1.7.12</version>  
        </dependency>
        
        <!-- logback for spring -->
        <dependency>
          <groupId>org.logback-extensions</groupId>  
          <artifactId>logback-ext-spring</artifactId>
          <version>0.1.2</version>
        </dependency>

        <!-- 单元测试 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.8.2</version>
            <scope>test</scope>
        </dependency>

    </dependencies>


    <!-- 项目构建 -->
    <build>
        <!-- build目标文件的文件名, 默认情况下为${artifactId}-${version}  -->
        <finalName>demo-web-archetype</finalName>
    
        <plugins>

            <!-- 版本打包插件，在dos跳转到项目根目录，依次执行（需保证没有引用快照、本地与SVN服务器内容完全一致）: 
                1 发布基线到svn: mvn release:prepare 
                2 发布引用到私服 : mvn release:perform -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-release-plugin</artifactId>
                <version>2.3.2</version>
                <configuration>
                    <!-- 项目的SVN基线目录（需保证目录已存在） -->
                    <tagBase>http://172.168.27.5:81/svn/release/???/tags</tagBase>
                </configuration>
            </plugin>

            <!-- 测试插件 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.7.2</version>
                <configuration>
                    <!-- 解决控制台输出乱码问题 -->
                    <forkMode>once</forkMode>
                    <argLine>-Dfile.encoding=UTF-8</argLine>
                    <systemProperties>
                        <property>
                            <name>net.sourceforge.cobertura.datafile</name>
                            <value>target/cobertura/cobertura.ser</value>
                        </property>
                    </systemProperties>
                    <!-- 项目打包时是否跳过d单元测试 -->
                    <skipTests>true</skipTests>
                </configuration>
            </plugin>

            <!-- 编译插件 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>${jdk.version}</source>
                    <target>${jdk.version}</target>
                    <encoding>${project.build.sourceEncoding}</encoding>
                    <showWarnings>true</showWarnings>
                </configuration>
            </plugin>

            <!-- war打包插件 -->
            <plugin>
                <artifactId>maven-war-plugin</artifactId>
                <version>2.4</version>
                <configuration>
                    <warName>${project.artifactId}</warName>
                    <warSourceDirectory>WebRoot</warSourceDirectory>
                    <failOnMissingWebXml>false</failOnMissingWebXml>
                </configuration>
            </plugin>

        </plugins>

    </build>

    <!-- 项目发布管理 -->
    <distributionManagement>

        <!-- 私服地址 ，公司级基线仓库 -->
        <repository>
            <id>Releases</id>
            <url>http://127.0.0.1:8081/nexus/content/repositories/releases</url>
        </repository>

        <!-- 私服地址 ，公司级快照仓库 -->
        <snapshotRepository>
            <id>Snapshots</id>
            <url>http://127.0.0.1:8081/nexus/content/repositories/snapshots</url>
        </snapshotRepository>
    </distributionManagement>

</project>

```

- **web.xml**<br/>
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns="http://java.sun.com/xml/ns/javaee"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
    id="WebApp_ID" version="3.0">

    <!-- web-app显示名称 -->
    <display-name>demo-web-archetype</display-name>


    <!-- 默认首页 -->
    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
        <welcome-file>index.htm</welcome-file>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>


    <!-- 字符集过滤器 : 处理页面乱码问题 -->
    <filter>
        <filter-name>encodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>


    <!-- 加载logback日志配置 -->
    <context-param>  
        <param-name>logbackConfigLocation</param-name>  
        <param-value>classpath:logback.xml</param-value>  
    </context-param>  
    <listener>  
        <listener-class>ch.qos.logback.ext.spring.web.LogbackConfigListener</listener-class>  
    </listener>  
    

    <!-- 表示工程默认以spring的方式启动 -->
    <!-- 注：这是[非SpringMVC]架构的配置, 若希望直接使用SpringMVC, 则无视此配置项即可 -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <context-param>     <!-- 指定spring配置文件(若无指定则启动时默认会在/WEB-INF目录下查找applicationContext.xml) -->
        <param-name>contextConfigLocation</param-name>
        <param-value>   <!-- classpath指代WEB-INF下的classes与lib目录, 优先级lib大于classes -->
          classpath*:applicationContext*.xml    <!-- 这是全局的, 应用于多个servlet -->
        </param-value>
    </context-param>
    

    <!-- 使得工程具备SpringMVC特性 -->
    <servlet>
        <servlet-name>SpringMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>

        <!-- 指定配置文件(若不配置则默认在/WEB-INF目录下查找XXX-servlet.xml作为配置文件) -->
        <init-param>
            <param-name>contextConfigLocation</param-name>  
            <param-value>      <!-- 仅仅SpringMVC使用的配置文件, 四选一即可 -->
                 <!-- classpath*:spring-bean.xml -->    <!-- 基于BeanName-URL方式配置的Controller --> 
                 <!-- classpath*:spring-class.xml -->   <!-- 基于ClassName方式配置的Controller --> 
                 classpath*:spring-mvc.xml              <!-- 基于注解方式配置的Controller --> 
                 <!-- classpath*:spring-url.xml -->     <!-- 基于Simple-URL方式配置的Controller --> 
            </param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>    <!-- 表示启动容器时初始化该Servlet -->
    </servlet>
    <servlet-mapping>
        <servlet-name>SpringMVC</servlet-name>  <!-- 表示哪些请求交给SpringMVC处理, "/"表示此为其他servlet都匹配不到时的缺省模式 -->
        <url-pattern>/</url-pattern>    <!-- 可以配置为诸如"*.html"表示拦截所有以html为扩展名的请求 -->
    </servlet-mapping>


    <!-- 用于测试demo中的SpringMVC跳转(可删除) -->
    <servlet>
        <servlet-name>TestSpringMVC</servlet-name>
        <jsp-file>/WEB-INF/pages/demo-mvc-request.jsp</jsp-file>
    </servlet>
    <servlet-mapping>
        <servlet-name>TestSpringMVC</servlet-name>
        <url-pattern>/demo-spring-mvc</url-pattern>
    </servlet-mapping>
    
</web-app>

```


## 版权声明

　[![Copyright (C) 2016-2018 By EXP](https://img.shields.io/badge/Copyright%20(C)-2006~2018%20By%20EXP-blue.svg)](http://exp-blog.com)　[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
  

- Site: [http://exp-blog.com](http://exp-blog.com) 
- Mail: <a href="mailto:289065406@qq.com?subject=[EXP's Github]%20Your%20Question%20（请写下您的疑问）&amp;body=What%20can%20I%20help%20you?%20（需要我提供什么帮助吗？）">289065406@qq.com</a>


------
