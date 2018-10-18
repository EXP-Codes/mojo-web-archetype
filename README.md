# mojo-web-archetype
Maven项目规范骨架（Web版）

------


## 运行环境

　![](https://img.shields.io/badge/Maven-3.2.5%2B-brightgreen.svg)  ![](https://img.shields.io/badge/JDK-1.7%2B-brightgreen.svg)


## 软件介绍

　快速创建一个规范架构的**Java Web项目（Maven版）**，使得**项目中自动内置**：

- **Spring/SpringMVC架构**
- [经验构件库](https://github.com/lyy289065406/exp-libs)：*用于快速开发的辅助包*
- [Maven项目发布插件](https://github.com/lyy289065406/mojo-release-plugin)：*用于快速发布一个可运行应用到生产环境*
- 混淆打包插件：*第三方插件`proguard-maven-plugin`，用于保护所发布的项目代码*
- Ant插件：*第三方插件`maven-antrun-plugin`，用于拷贝项目配置、文档等资源到发布包*
- 基线发布插件：*第三方插件`maven-release-plugin`，用于发布项目基线到版本库和Nexus私服*



> 此骨架只能在J2EE中使用，若在J2SE中，会因为缺少Java Web组件会报错

## 使用说明

- 01.　本地已安装并部署好 `apache-maven-3.2.5`（或更高版本）
- 02.　下载本骨架项目 `mojo-archetype` 到本地，拷贝 `mojo-archetype/conf/archetype-catalog.xml` 文件到 `apache-maven-3.2.5/conf` 目录下，若目录下已存在同名文件，则只需把 `archetype-catalog.xml` 的内容附加进去即可：<br/>
```
<!-- Maven骨架 -->
<archetype>
  <groupId>exp.libs</groupId>
  <artifactId>mojo-archetype</artifactId>
  <version>1.0</version>   <!-- 注意版本号要根据实际发布的骨架版本号调整 -->
  <repository>http://127.0.0.1:8081/nexus/content/repositories/releases</repository> <!-- 若本地部署了Nexus私服则如实填写，这是releases库 -->
</archetype>
<archetype>
  <groupId>exp.libs</groupId>
  <artifactId>mojo-archetype</artifactId>
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
- 08.　通过 `maven install` 在 `target` 目录直接发布可运行应用（详见[`Maven项目发布插件 mojo-release-plugin`](https://github.com/lyy289065406/mojo-release-plugin)）：<br/>
![发布可运行项目到生产环境](https://raw.githubusercontent.com/lyy289065406/mojo-web-archetype/master/doc/%E6%95%88%E6%9E%9C%E6%88%AA%E5%9B%BE/04-%E5%8F%91%E5%B8%83%E9%A1%B9%E7%9B%AE.png)


## 运行效果

。。。

## 补充：通过本骨架所生成示例项目的pom.xml文件

> 点击 [这里](https://github-production-release-asset-2e65be.s3.amazonaws.com/148517307/39b98c00-d16a-11e8-8e29-21fb4ca9a0c1?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20181016%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20181016T094123Z&X-Amz-Expires=300&X-Amz-Signature=badf0120ecd88889e126c25c9a84abb7d9a34a4eed2c25f2760536c5788f57f5&X-Amz-SignedHeaders=host&actor_id=17040287&response-content-disposition=attachment%3B%20filename%3Ddemo-archetype.zip&response-content-type=application%2Foctet-stream) 下载示例项目


```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!--项目基本信息(必填)-->
    <groupId>exp.libs</groupId>
    <artifactId>demo-archetype</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

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
        <release.dir>${project.build.directory}/${project.artifactId}-${project.version}</release.dir>
        <jdk.version>1.6</jdk.version>
        <explibs.version>1.0-SNAPSHOT</explibs.version>
        <mrp.plugin.version>1.0-SNAPSHOT</mrp.plugin.version>
    </properties>

    <!-- 项目依赖 -->
    <dependencies>
    
        <!-- 经验库 -->
        <dependency>
          <groupId>exp.libs</groupId>
          <artifactId>exp-libs</artifactId>
          <version>${explibs.version}</version>
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
        <plugins>

            <!-- 指定项目JDK版本 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>${jdk.version}</source>
                    <target>${jdk.version}</target>
                </configuration>
            </plugin>
            
            <!-- 版本打包插件，在dos跳转到项目根目录，依次执行（需保证没有引用快照、本地与SVN服务器内容完全一致）: 
                1 发布基线到svn: mvn release:prepare 
                2 发布引用到私服 : mvn release:perform -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-release-plugin</artifactId>
                <version>2.3.2</version>
                <configuration>
                    <!-- 项目的SVN基线目录（需保证目录已存在） -->
                    <tagBase>http://127.0.0.1:81/svn/release/???/tags</tagBase>
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
            
            <!-- 混淆打包插件 -->
            <plugin>
                <groupId>com.github.wvengen</groupId>
                <artifactId>proguard-maven-plugin</artifactId>
                <version>2.0.7</version>
                <executions>
                    <execution>
                        <phase>package</phase>    <!-- 触发混淆打包的maven周期 -->
                        <goals>
                            <goal>proguard</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <!-- attach 的作用是在 install/deploy 时, 将生成的 pg 文件也安装/部署 -->
                    <attach>false</attach>
                    <attachArtifactClassifier>pg</attachArtifactClassifier>
                    
                    <!-- 指定混淆处理所需要的库文件 -->
                    <libs>
                        <lib>${java.home}/lib/rt.jar</lib> <!-- 运行时库rt是必须的 -->
                    </libs>
                    
                    <!-- 指定要做混淆处理的 应用程序jar、war、ear，或目录 -->
                    <injar></injar>
                    
                    <!-- 指定混淆处理完后要输出的jar、war、ear，及其目录名称 -->
                    <outjar>${project.build.finalName}-pg</outjar>
                    
                    <!-- 混淆规则: 详细配置方式参考 ProGuard 官方文档 -->
                    <options>
                        <option>-ignorewarnings</option>         <!-- 忽略混淆警告 -->
                        <!-- option>-dontobfuscate</option -->    <!-- 不混淆输入的类文件 -->
                        <option>-dontshrink</option>               <!-- 不压缩输入的类文件 -->
                        <option>-dontoptimize</option>             <!-- 不做代码优化 -->
                        <option>-dontskipnonpubliclibraryclasses</option>        <!-- 不跳过私有依赖的类库 -->
                        <option>-dontskipnonpubliclibraryclassmembers</option>    <!-- 不跳过私有依赖的类库成员 -->
                        <!-- option>-overloadaggressively</option -->                <!-- 混淆时应用侵入式重载 -->
                        <!-- option>-obfuscationdictionary {filename}</option -->    <!-- 使用给定文件中的关键字作为要混淆方法的名称 -->
                        <!-- option>-applymapping {filename}</option -->            <!-- 重用映射增加混淆 -->
                        <!-- option>-useuniqueclassmembernames</option -->            <!-- 确定统一的混淆类的成员名称来增加混淆 -->
                        <!-- option>-dontusemixedcaseclassnames</option -->            <!-- 混淆时不会产生形形色色的类名 -->
                        <!-- option>-renamesourcefileattribute {string}</option -->    <!-- 设置源文件中给定的字符串常量 -->
                        <!-- option>-flattenpackagehierarchy {package_name}</option -->    <!-- 重新包装所有重命名的包并放在给定的单一包中 -->
                        <!-- option>-repackageclass {package_name}</option -->            <!-- 重新包装所有重命名的类文件中放在给定的单一包中 -->
            
            
                        <!--平行包结构（重构包层次），所有混淆的代码放在 pg 包下 -->
                        <!-- 最好不要随便放, 若有多个项目混淆，不同jar的混淆类可能重名 -->
                        <!-- 建议为{project.root.package}.pg （不存在此变量，此处仅为了说明） -->
                        <option>-repackageclasses exp.libs.pojo.pg</option>
            
                        <!-- 保留[源码] --><!-- 按实际项目切换 -->
                        <!-- option>-keepattributes SourceFile</option -->
                        
                        <!-- 保留[行号] --><!-- 按实际项目切换 -->
                        <option>-keepattributes LineNumberTable</option>
                        
                        <!-- 保留[注释] --><!-- 按实际项目切换 -->
                        <!-- option>-keepattributes *Annotation*</option -->
                        
                        <!-- 保留[注解] --><!-- 按实际项目切换 -->
                        <!-- option>-keepattributes Signature</option -->
                        
                        <!-- 保持[入口类]不变 -->
                        <!-- 按实际项目修正 -->
                        <option>-keep class 
                            exp.libs.pojo.Version,
                            exp.libs.pojo.Main
                        </option>
                        
                        <!-- 保持[Bean类]不变（若框架对 Bean中的内容做了反射处理，则必须保持不变） -->
                        <!-- 按实际项目修正 -->
                        <option>-keep class exp.libs.pojo.bean.** { *;}</option>
                        
                        <!-- 保持[所有入口方法]不变 -->
                        <!-- 固定不变 -->
                        <option>-keepclasseswithmembers public class * { 
                                    public static void main(java.lang.String[]);
                                }
                        </option>
                        
                        <!-- 保持[对外API的类名和方法名]不变 -->
                        <!-- 按实际项目修正 -->
                        <option>-keep class exp.libs.pojo.api.** { *;}</option>
                        
                        <!-- 保持[所有本地化方法]不变 -->
                        <!-- 固定不变 -->
                        <option>-keepclasseswithmembernames class * {
                                    native &lt;methods&gt;;
                                }
                        </option>
                        
                        <!-- 保持[所有类成员变量]不变 -->
                        <!-- 按实际项目修正 -->
                        <!-- option>-keepclassmembers class * {
                                    &lt;fields&gt;;
                                }
                        </option -->
                        
                        <!-- 保持[所有枚举类必须的方法]不变 -->
                        <!-- 固定不变 -->
                        <option>-keepclassmembers class * extends java.lang.Enum {
                                    public static **[] values();
                                    public static ** valueOf(java.lang.String);
                                }
                        </option>
                        
                        <!-- 保持[所有序列化接口]不变（若项目中不使用序列化，也可注释） -->
                        <!-- 固定不变 -->
                        <option>-keepclassmembers class * implements java.io.Serializable {
                                    static final long serialVersionUID;
                                    static final java.io.ObjectStreamField[] serialPersistentFields;
                                    private void writeObject(java.io.ObjectOutputStream);
                                    private void readObject(java.io.ObjectInputStream);
                                    java.lang.Object writeReplace();
                                    java.lang.Object readResolve();
                                }
                        </option>
                    </options>
                </configuration>
            </plugin>

            <!-- Ant插件：项目部署文件复制 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-antrun-plugin</artifactId>
                <version>1.7</version>
                <executions>
                    <execution>
                        <id>ant-build</id>
                        <phase>install</phase>
                        <goals>
                            <goal>run</goal>
                        </goals>
                        <configuration>
                            <target>
                                <echo>拷贝数据库脚本</echo>
                                <copy todir="${release.dir}/script">
                                    <fileset dir="script"></fileset>
                                </copy>
                                <echo>拷贝项目配置文件</echo>
                                <copy todir="${release.dir}/conf">
                                    <fileset dir="conf" />
                                </copy>
                                <echo>拷贝文档</echo>
                                <copy todir="${release.dir}/doc/04_维护文档">
                                    <fileset dir="doc/04_维护文档" />
                                </copy>
                                <copy todir="${release.dir}/doc/06_使用文档">
                                    <fileset dir="doc/06_使用文档" />
                                </copy>
                                <copy todir="${release.dir}/doc/07_演示文档">
                                    <fileset dir="doc/07_演示文档" />
                                </copy>
                            </target>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
            
            <!-- 项目发布插件(自动生成脚本) -->
            <plugin>
                <groupId>exp.libs</groupId>
                <artifactId>mojo-release-plugin</artifactId>
                <version>${mrp.plugin.version}</version>
                <executions>
                    <execution>
                        <id>mrp</id>
                        <phase>install</phase>
                        <goals>
                            <goal>install</goal>
                        </goals>
                        <configuration>
                            <mavenRepository>D:\mavenRepository</mavenRepository>
                            <verClass>exp.libs.pojo.Version</verClass>
                            <mainClass>exp.libs.pojo.Main</mainClass>
                            <mainArgs></mainArgs>
                            <charset>UTF-8</charset>
                            <jdkPath>java</jdkPath>
                            <xms>32m</xms>
                            <xmx>64m</xmx>
                            <jdkParams></jdkParams>
                            <noVerJarRegex>exp-?libs-.*</noVerJarRegex> <!-- 不使用版本号的依赖构件(正则式) -->
                            <proguard>false</proguard>  <!-- 是否使用混淆包(需配置混淆打包插件) -->
                        </configuration>
                    </execution>
                </executions>
            </plugin>
            
            <!-- 打包源码: 项目发布基线版本时会自动打包源码，不要启用此插件，否则会失败 -->
            <!-- plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-source-plugin</artifactId>
                <version>2.1.2</version>
                <executions>
                    <execution>
                        <id>attach-sources</id>
                        <phase>verify</phase>
                        <goals>
                            <goal>jar-no-fork</goal>
                            <goal>test-jar-no-fork</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin -->

            <!-- 打包javadoc: 项目发布基线版本时会自动打包javadoc，若报错不要启用此插件 -->
            <!-- javadoc插件会强制使用GBK读取pom文件的内容, 若得到的html网页标题乱码,  -->
            <!-- 则需要通过Run Configurations -> 自定义Maven install命令 -> Common -> Encoding:GBK 确保不会乱码 -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-javadoc-plugin</artifactId>
                <version>2.9.1</version>
                <configuration>
                    <aggregate>true</aggregate>
                    <charset>UTF-8</charset>
                    <encoding>UTF-8</encoding>
                    <docencoding>UTF-8</docencoding>
                </configuration>
                <executions>
                    <execution>
                        <id>attach-javadocs</id>
                        <goals>
                            <goal>jar</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>

        </plugins>
    </build>

    <!-- 项目发布管理 -->
    <distributionManagement>
    
        <!-- 私服地址 ，基线仓库 -->
        <repository>
            <id>Releases</id>
            <url>http://127.0.0.1:8081/nexus/content/repositories/releases</url>
        </repository>
        
        <!-- 私服地址 ，快照仓库 -->
        <snapshotRepository>
            <id>Snapshots</id>
            <url>http://127.0.0.1:8081/nexus/content/repositories/snapshots</url>
        </snapshotRepository>
    </distributionManagement>
</project>

```

## 版权声明

　[![Copyright (C) 2016-2018 By EXP](https://img.shields.io/badge/Copyright%20(C)-2006~2018%20By%20EXP-blue.svg)](http://exp-blog.com)　[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
  

- Site: [http://exp-blog.com](http://exp-blog.com) 
- Mail: <a href="mailto:289065406@qq.com?subject=[EXP's Github]%20Your%20Question%20（请写下您的疑问）&amp;body=What%20can%20I%20help%20you?%20（需要我提供什么帮助吗？）">289065406@qq.com</a>


------
