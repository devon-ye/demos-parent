# Spring-MVC

## Spring-MVC拦截器

### 什么是拦截器
     
     通过统一拦截从浏览器发往服务端的请求来完成功能的增强
      
### 拦截器的基本工作原理
   
    HandlerMapping 将url和method进行映射
    
   
### 拦截器的配置
    SpringMVC拦截器可以通过配置过滤器来解决乱码问题
   
### 使用场景
    
    1.解决请求的共性问题：
       乱码问题
       权限验证问题
## Spring-filter过滤器

## spring-mvc和Struts之间的区别



    我们从以下几个维度来区分两者的概念：
     1.  机制：spring mvc的入口是servlet，而struts2是filter。
         补充几点知识：
         《 Filter 实现javax.servlet.Filter接口，在web.xml中配置与标签指定使用哪个Filter实现类过滤哪些URL链接。只在web启动时进行初始化操作。 filter 流程是线性的， url传来之后，检查之后，可保持原来的流程继续向下执行，被下一个filter, servlet接收等，而servlet 处理之
     后，不会继续向下传递。filter功能可用来保持流程继续按照原来的方式进行下去，或者主导流程，而servlet的功能主要用来主导流程。 
     特点：可以在响应之前修改Request和Response的头部，只能转发请求，不能直接发出响应。filter可用来进行字符编码的过滤，检测用户 
     是否登陆的过滤，禁止页面缓存等》
             《 Servlet， servlet 流程是短的，url传来之后，就对其进行处理，之后返回或转向到某一自己指定的页面。它主要用来在业务处理之前进行控制 》
             《 Listener呢？我们知道 servlet、filter都是针对url之类的，而listener是针对对象的操作的，如session的创建，session.setAttribute的发生，在这样的事件发 生时做一些事情。 》 
     
     2. 性能：spring会稍微比struts快。 spring mvc是基于方法的设计 ， 而sturts是基于类 ，每次发一次请求都会实例一个action，每个action都会被注入属性，而spring基于方法，粒度更细(粒度级别的东西比较sychronized和lock)，但要小心把握像在servlet控制数据一样。 spring3 mvc是方法级别的拦截，拦截到方法后根据参数上的注解，把request数据注入进去，在spring3 mvc中，一个方法对应一个request上下文。 而struts2框架是类级别的拦截，每次来了请求就创建一个Action，然后调用setter getter方法把request中的数据注入；struts2实际上是通过setter getter方法与request打交道的；struts2中，一个Action对象对应一个request上下文。
     3. 参数传递：struts是在接受参数的时候，可以用属性来接受参数，这就说明参数是让多个方法共享的。所以D是对的。
     4. 设计思想上： struts更加符合oop的编程思想 ， spring就比较谨慎，在servlet上扩展。
     5. intercepter(拦截器)的实现机制：struts有以自己的interceptor机制， spring mvc用的是独立的AOP方式 。这样导致struts的配置文件量还是比spring mvc大，虽然struts的配置能继承，所以我觉得，就拿使用上来讲，spring mvc使用更加简洁， 开发效率Spring MVC确实比struts2高 。 spring mvc是方法级别的拦截，一个方法对应一个request上下文，而方法同时又跟一个url对应，所以说从架构本身上 spring3 mvc就容易实现restful url 。 struts2是类级别的拦截，一个类对应一个request上下文；实现restful url要费劲，因为struts2 action的一个方法可以对应一个url；而其类属性却被所有方法共享，这也就无法用注解或其他方式标识其所属方法了。 spring3 mvc的方法之间基本上独立的，独享request response数据，请求数据通过参数获取，处理结果通过ModelMap交回给框架方法之间不共享变量， 而struts2搞的就比较乱，虽然方法之间也是独立的，但其所有Action变量是共享的，这不会影响程序运行，却给我们编码，读程序时带来麻烦。
     6. 另外，spring3 mvc的验证也是一个亮点，支持JSR303， 处理ajax的请求更是方便 ，只需一个注解 @ResponseBody  ，然后直接返回响应文本即可。