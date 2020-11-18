
    <s:url var="images" value="/resources/images"/>
    <div align="center">
      <h3>Student Details</h3>
      <form:form action="" modelAttribute="student">
           <table>
               <tr height="100">
                   <td width="200">ID</td>          
                   <td>${student.id }</td>        <td><img src="${images}/${student.id}.jpg" height="100px" width="75px"> </td>
               </tr>
               
                <tr height="50">
                   <td>Name</td>
                   <td>${student.name}</td>
               </tr>
                <tr height="50">
                   <td>Father's Name</td>
                   <td>${student.fname}</td>
               </tr>
                <tr height="50">
                   <td>Address</td>
                   <td>${student.address}</td>
               </tr>
                <tr height="50">
                   <td>DOB</td>
                   <td>${student.dob}</td>
               </tr>
                <tr>
                   <td height="50">Gender</td>
                   <td>${student.gender}</td>
               </tr>
                <tr>
                   <td height="50">Course</td>
                   <td>${student.course}</td>
               </tr>
                <tr>
                   <td height="50">Email</td>
                   <td>${student.email}</td>
               </tr>
                <tr>
                   <td>Contact</td>
                   <td>${student.contact}</td>
               </tr>
                
          
           </table>
      </form:form>
                 <a href="${contextRoot}/singleReport/${student.id}" target="_blank">Generate Pdf</a>
    </div>