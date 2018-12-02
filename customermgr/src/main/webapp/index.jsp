<html>
<body>
<h2>Hello World! hello customermgr</h2>

<%@page import="com.usst.exerciseweb.customermgr.Customer1" %>

<%
    System.out.println("now in customermgr index.jsp");
    new Customer1().c1();
%>

</body>
</html>
