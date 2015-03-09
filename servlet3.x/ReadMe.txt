JavaEE基础(Jsp,Servlet)
JSP篇
1.jsp运行的基本原理
2.jsp的注释、声明、输出表达式、脚本
3.jsp的3个编译指令：page、taglib、include
4.jsp的7个动作指令：jsp:forward、jsp:include、jsp:param、jsp:usebean、jsp:plugin
	jsp:setProperty、jsp:getProperty
5.jsp的9个内置对象：request、response、out、config、exception、session、pageContext、
	page、application

Servlet篇
1.Servlet的开发:doGet、doPost、doPut、doDelete
2.Servlet3.0可以直接通过Annotation方式配置Servlet
3.Servlet的startup-on-load
4.使用ServletConfig(config)访问配置参数

JSP2自定义标签篇
1.自定义标签开发过程：
	1.开发自定义标签处理类
	2.建立一个*.tld文件
	3.在JSP文件中使用自定义标签
	4.开发带属性的标签
	5.开发已页面片段为属性的标签
	6.动态属性的标签
	
Filter篇
1.创建Filter类
2.使用Annotation或在web.xml中配置Filter

Listener篇
1.定义Listener实现类
2.通过Annotation或在web.xml中配置Listener

JSP2新特性
1.在web.xml中配置jsp属性
2.表达式语言的支持，可以自定义表达式函数
3.对于tag file的支持

Servlet3.0新特性
1.Annotaion的支持
2.web模块支持
3.异步处理支持
4.改进的Servlet API，如文件的上传
