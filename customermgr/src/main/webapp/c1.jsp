<html>
<body>
<h2>Hello World!Customermgr</h2>
<%@page import="cusomermgr.Customer1" %>

<%
    System.out.println("now in Customermgr c1.jsp");
    new Customer1().c1("c1 method");
%>
</body>
</html>
