<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  	<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
    
    
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${contextRoot}- ${title}</title>
<s:url var="css" value="/resources/css/style.css"/>
<link href="${css}" rel="stylesheet" type="text/css">

</head>

<s:url var="images" value="resources/images"/>
<body background="${images}/bg.jpg">

<table border="1" width="80%" align="center">
   <tr>
     <td height="100px">
        <!-- Header -->
        <%@include file="./include/header.jsp" %>
     </td>
   </tr>
   
   <tr>
     <td height="25px">
      <!-- Menu -->
              <%@include file="./include/menu.jsp" %>
     </td>
   </tr>
   
   <tr>
     <td height="350px">
        <!-- Page Content area -->
         <c:if test="${ClickOnaddStudent == true}">
         <%@include file="addstudent.jsp" %>
      </c:if>
      
      <c:if test="${ClickOnUserLogin == true}">
         <%@include file="login.jsp" %>
      </c:if>
      
      
      
      <c:if test="${ClickOnsearchStudent == true}">
         <%@include file="searchStudent.jsp" %>
      </c:if>
      
      <c:if test="${ClickOnSingleStudent == true}">
         <%@include file="singlestudent.jsp" %>
      </c:if>
      
      <c:if test="${ClickOnAllStudent == true}">
         <%@include file="allstudent.jsp" %>
      </c:if>
        
     </td>
   </tr>
   
   <tr>
     <td height="25px">
         <!-- Footer -->
                 <%@include file="./include/footer.jsp" %>
     </td>
   </tr>

</table>





</body>
</html>