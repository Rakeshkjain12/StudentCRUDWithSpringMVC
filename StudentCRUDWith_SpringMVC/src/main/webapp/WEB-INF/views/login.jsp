   <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  	<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
  	
  	
  	<form:form action="" method="post">
  	   <table>
  	       <tr>
  	          <td>Email</td>
  	          <td><input type= "email" name="email" ></td>
  	       </tr>
  	        <tr>
  	          <td>DOB</td>
  	          <td><input type="date" name="email"></td>
  	       </tr>
  	        <tr>
  	          <td colspan="2"><input type="submit" value="Login">
  	          <a href="#">Forget Password</a>
  	          </td>
  	        </tr>
  	   
  	   </table>
  	
  	
  	</form:form>