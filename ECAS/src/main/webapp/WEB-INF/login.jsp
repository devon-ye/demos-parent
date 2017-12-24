<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/12/9
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/xml" charset="UTF-8"/>
    <title>教务综合管理系统</title>
    <%@include file="../pages/common/taglibs.jsp"%>
    <%@include file="../pages/common/inc.jsp"%>
    <script type="text/javascript">
        function loginClick() {
            loginform.submit();
        }
    </script>
    <style type="text/css">
        body {
            MARGIN: 0px;
        }

        .STYLE1 {
            font-size: 14px
        }

        .STYLE2 {
            font-size: 15px
        }
    </style>
    <style type="text/css">
        .div1 {
            padding-left: 30px;
            background: url(${ctx}/image/login/1.png) 4px no-repeat;
            background-color: #FFFFFF;
            width: 140px;
            height: 25px;
            line-height: 25px;
            border: 1px solid #ccc;
        }

        .div2 {
            padding-left: 30px;
            background: url(${ctx}/image/login/2.png) 4px no-repeat;
            background-color: #FFFFFF;
            width: 140px;
            height: 25px;
            line-height: 25px;
            border: 1px solid #ccc;
        }

        input {
            border: 0;
            font-size: 18px;
        }
        a:link {
            color:#3F4476;
            text-decoration:blink;
        }
    </style>
</head>
<body>
<form id="loginform" method="post"
      action="<%=contextPath%>/ecas/doLogin.do">
    <img src="${ctx}/image/login/bg.jpg" width="100%" height="100%" style="z-index:-100;position:absolute;left:0;top:0">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" style="margin-top:100px">
        <tr>
            <td height="200" style="text-align: center">
                <span><img src="${ctx}/image/login/logo.png" width="40" height="20"><span>
                <span style="font-size: 30px;font-weight:800">XXX学综合测评系统</span>

            </td>
        </tr>
    </table>
    <table width="543" height="255" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td background="${ctx}/image/login/kuang.png">
                <table width="320" border="0" align="center" cellpadding="0" cellspacing="15">
                    <tr>
                        <td width="25%"><span class="STYLE2">账  号：</span></td>                    <td width="75%">
                        <div class="div1">
                            <input name="userName" type="text" id="userName"
                                   style="height:22px;width:137px;outline:none; vertical-align:middle;"/>
                        </div>
                        <strong class="red">${msg}</strong>
                    </td>
                    </tr>
                    <tr>
                        <td width="25%"><span class="STYLE2">密  码：</span></td>
                        <td width="75%">
                            <div class="div2">
                                <input name="password" type="password" id="password"
                                       style="height:22px;width:137px;outline:none;vertical-align:middle;"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div align="center"><img src="${ctx}/image/login/login.jpg" width="81" height="26" onclick="loginClick()"/></div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>

</form>
</body>
</html>
