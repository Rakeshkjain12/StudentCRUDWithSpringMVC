  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <form:form action="${contextRoot}/searchStudent" method="post" >
       Enter Id OR Name OR Fname OR DOB OR Course
       <input type="text" name="keyword">
      <input type="submit" value="SEARCH">
    
    </form:form>
    
    <table>
       <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Father Name</th>
          <th>Address</th>
          <th>dob</th>
          <th>Gender</th>
          <th>Course</th>
          <th>Email</th>
          <th>Contact</th>
       </tr>
       <tr>
          <c:forEach var="stu" items="${listStudent}">
             <td>${stu.id}</td>
             <td>${stu.name}</td>
             <td>${stu.fname}</td>
             <td>${stu.address}</td>
             <td>${stu.dob}</td>
             <td>${stu.gender}</td>
             <td>${stu.course}</td>
             <td>${stu.email}</td>
             <td>${stu.contact}</td>
          </c:forEach>
       
       </tr>
    </table>