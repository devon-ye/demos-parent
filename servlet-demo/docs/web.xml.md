# web.xml

## 概念
     学名:部署描述符文件

## 元素


           icon：元素指出IDE和GUI工具用来表示Web应用的一个和两个图像文件的位置。
           display-name：元素提供GUI工具可能会用来标记这个特定的Web应用的一个名称。
           description：元素给出与此有关的说明性文本。
           context-param：元素声明应用范围内的初始化参数。
           filter： 过滤器元素将一个名字与一个实现javax.servlet.Filter接口的类相关联。
           filter-mapping： 一旦命名了一个过滤器，就要利用filter-mapping元素把它与一个或多个servlet或JSP页面相关联。
           listener： servlet API的版本2.3增加了对事件监听程序的支持，事件监听程序在建立、修改和删除会话或servlet环境时得到通知。Listener元素指出事件监听程序类。
           servlet： 在向servlet或JSP页面制定初始化参数或定制URL时，必须首先命名servlet或JSP页面。Servlet元素就是用来完成此项任务的。
           servlet-mapping： 服务器一般为servlet提供一个缺省的URL：http://host/webAppPrefix/servlet/ServletName。但是，常常会更改这个URL，以便servlet可以访问初始化参数或更容易地处理相对URL。在更改缺省URL时，使用servlet-mapping元素。
           session-config： 如果某个会话在一定时间内未被访问，服务器可以抛弃它以节省内存。可通过使用HttpSession的setMaxInactiveInterval方法明确设置单个会话对象的超时值，或者可利用session-config元素制定缺省超时值。
           mime-mapping： 如果Web应用具有想到特殊的文件，希望能保证给他们分配特定的MIME类型，则mime-mapping元素提供这种保证。
           welcom-file-list：元素指示服务器在收到引用一个目录名而不是文件名的URL时，使用哪个文件。
           error-page：元素使得在返回特定HTTP状态代码时，或者特定类型的异常被抛出时，能够制定将要显示的页面。
           taglib：元素对标记库描述符文件（Tag Libraryu Descriptor file）指定别名。此功能使你能够更改TLD文件的位置，而不用编辑使用这些文件的JSP页面。
           resource-env-ref：元素声明与资源相关的一个管理对象。
           resource-ref：元素声明一个资源工厂使用的外部资源。
           security-constraint：元素制定应该保护的URL。它与login-config元素联合使用
           login-config： 用login-config元素来指定服务器应该怎样给试图访问受保护页面的用户授权。它与sercurity-constraint元素联合使用。
           security-role：元素给出安全角色的一个列表，这些角色将出现在servlet元素内的security-role-ref元素的role-name子元素中。分别地声明角色可使高级IDE处理安全信息更为容易。
           env-entry：元素声明Web应用的环境项。
           ejb-ref：元素声明一个EJB的主目录的引用。
           ejb-local-ref：元素声明一个EJB的本地主目录的应用。
---
## Filer配置详解
　　
      配置如下：


          <filter>
             < !-- 名称-- >
             <filter-name>MyFilter</filter-name>
             <!-- 类实现详解　-->
             <filter-class>servlet.filter.MyFilter</filter-class>
             <!-- 实现类初始化参数　-->
             <init-param>
                <param-name>name</param-name>
                <param-value>Sam-Sho</param-value>
             </init-param>
          </filter>
          <filter-mapping>
             <filter-name>MyFilter</filter-name>
             < !-- url 规则，可配置多个 -- >
             <url-pattern>/jsp/*</url-pattern>
             <url-pattern> *.do</url-pattern>
            　<!--dispatcher 方式有以下四种　-->
              <! -- REQUEST ：表示仅当直接请求servlet时才生效。  -- >
              <! --  FORWARD ：表示仅当某servlet通过forward转发到该servlet时才生效。  -- >
              <!--  INCLUDE ：Jsp中可以通过<jsp:include/>请求某servlet， 只有这种情况才有效。  -- >
              <!-- 　 ERROR ：Jsp中可以通过<%@page errorPage="error.jsp" %>指定错误处理页面，仅在这种情况下才生效。  -- >　　　　　　
            <dispatcher>REQUEST</dispatcher>
            <dispatcher>FORWARD</dispatcher>
        </filter-mapping>


　　　　注意：<url-pattern>和<dispatcher> 是且的关系，只有满足<url-pattern>的条件，且满足<dispatcher>的条件，该Filter 才能生效。

　　
　　　