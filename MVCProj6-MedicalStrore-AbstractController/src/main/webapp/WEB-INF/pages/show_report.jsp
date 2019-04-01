<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
 <c:when test="${!empty listMed}">
   <table border="1"  bgcolor="cyan">
     <tr> <th>Med Id</th><th>MedName</th><th>Price</th><th>Company</th></tr>
     <c:forEach var="dto" items="${listMed}">
       <tr>
        <td>${dto.medId}</td>
        <td>${dto.medName}</td>
        <td>${dto.price}</td>
        <td>${dto.company}</td>
       </tr>
     </c:forEach>
   </table>
 </c:when>
 <c:otherwise>
    <b>Records not found</b>
 </c:otherwise>
</c:choose>
<br>
 <a href="home.htm">home</a>

