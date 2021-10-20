<%@ page import ="java.util.*" %>
<%@ page import="com.tec.binarytree.RRServlet" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>
   Available Brands
</h1>
<%
RRServlet printear = new RRServlet();
List result= (List) request.getAttribute("brands");
Iterator it = result.iterator();
out.println(printear.respuestaCliente);
out.println("<br>We have <br><br>");
while(it.hasNext()){
out.println(it.next()+"<br>");
}
%>
</body>
</html>
