<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>One</title>
  </head>
  <body>
  <h1>Page One</h1>

  <% System.out.println("Page One Started"); %>

<%--  <%response.sendRedirect("http://google.com");%>--%>
<% request.getRequestDispatcher("/two.jsp").forward(request, response);%>

  <% System.out.println("Page One Finished"); %>

  </body>
</html>
