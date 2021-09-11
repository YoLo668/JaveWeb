<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <script type="text/javascript" src="jquery/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                document.location.href="add.jsp";
            })
        })
    </script>
</head>
<body>
<p style="color: red;font-size: 30px">${error}</p>
<form action="login.do" method="post">
    用户名:<input type="text" name="username"/><br/>
    密码:<input type="password" name="password"/><br/>
    <input type="submit" value="提交"/>
    <input type="button" value="注册" id="btn"/>
</form>

</body>
</html>
