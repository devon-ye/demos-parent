#JSP(Java servlet pages)常用标签

## 常见的动态网页技术对比
    
    Jsp:基于Java平台，安全性高，适合开发大型的企业级JavaWeb应用
    asp.net：基于.net平台，简单易学，但是安全性和跨平台行较差
    php：简单、高效、开发周期短成本低，适合开发中小型企业应用
 
## JSP部分

### Jsp页面组成
    
    静态内容
    指令
       page指令：<%@ %>位于JSP页面顶端，可包含多个，
                常用属性：language、import、contenType
       include指令
       taglib指令
    表达式
    小脚本
    声明
       <%! Java代码 %>  Jsp页面中定业变量和方法
    注释
       html注释：<!-- -->  客户端可见
       jsp注释：<%-- --%>  客户端不可见
       jsp脚本注释：//d单行注释  /**/多行注释

### JSP页面生命周期
   
     index.jps---> 判断是否是第一次请求--->jsp页面转成Servlet，并生成字节码，执行init方法--->解析执行，jspService()
### JSP内置对象
####  JSP内置对象定义
       是通过wen容器创建的一组对象，不许用用new关键字去创建，就可以直接使用的对象
#### JPS内置九大对象
     
     out：是jspWriter类的实例,是向客户端输出内容的常用对象
     request：是HttpRServletRequest类的实例，客户端请求被封装在该对象，即完成request请求之前，该对象一直有效
     response：是HttpServletResqonse类的实例，具有页面作用域，response对象只对本页面的本次访问有效
     session：HttpSession类的实例，从客户打开jsp页面，到关闭页面离开服务器称为一次会话Session即
     application：是ServletContext类的实例.从服务启动,到服务关闭
     page:指向当前页面,是object类的实例
     pageContext:类名PageContext,可访问当前页面的所有内置对象
     config:是Servlet初始化时的对象
     exception:页面产生异常时,产生该对象
     
#### JSP内置对象的四大作用域

#### 请求重定向和请求转发之间的区别
     请求重定向：客户端行为，response.sendRedirect(),本质上是两次请求，第一次请求结果不保存，地址栏url会改变
     请求转发：服务端行为，request.getRequestDispatcher().forward(req,rep),本质上是一次请求，转发后请求对象会保存，地址栏url不会改变

## TOMCAT



## JSTL部分
### 概念
   即用JSTL实现JSP页面中的常用代码
   
### 依赖包
   JSTL环境搭建
   tomcat+JSTL1.1.2
    jstl下载地址:archive.apache.org/dist/jakarta/taglibs
### JSTL常用标签
   <c:out> </c:out> 变量及属性的输出
   
   <c:set></c:set> 存值到scope和存值到JavaBean
   
   <c:remove></c:remove> 只能remove变量，不能remove属性
   
   <c:catch></c:catch> 可包含其它标签
   
   <c:if></c:if> 跟代码中一样
   
   <c:choose></c:choose>
   
   <c:forEach></c:forEach>  遍历存储在集合中的元素
   
   <c:forTokens> </c:forTokens> 浏览并截取字符串
   
   <c:import></c:import>   包含其它应用中的jsp
    
   <c:redirect> </c:redirect>  重定向，需要引入核心taglib
   
   <c:url></c:url>