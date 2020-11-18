   <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
    <spring:url var="images" value="/resources/images"/>
    <h3>All Students</h3>
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
          <th>Photo</th>
          <th>Action</th>
          <th>Pdf</th>
       </tr>
       
          <c:forEach var="stu" items="${listStudents}">
          <tr>
             <td>${stu.id}</td>
             <td>${stu.name}</td>
             <td>${stu.fname}</td>
             <td>${stu.address}</td>
             <td>${stu.dob}</td>
             <td>${stu.gender}</td>
             <td>${stu.course}</td>
             <td>${stu.email}</td>
             <td>${stu.contact}</td>
             <th><img src="${images}/${stu.id}.jpg" height="100px" width="75px"></th>
             <td><a href="${contextRoot}/delete?id=${stu.id}">DELETE</a>
                 <a href="${contextRoot}/update?id=${stu.id}">UPDATE</a>
                  <a href="${contextRoot}/singleStudent/${stu.id}" target="_blank">VIEW</a>
                 </td>
                 <td><a href="${contextRoot}/singleReport/${stu.id}"  target="_blank">Download</a></td>
                </tr> </c:forEach>
                 
               
        </table>
        
        <a href="${contextRoot}/report">Generate Report</a>