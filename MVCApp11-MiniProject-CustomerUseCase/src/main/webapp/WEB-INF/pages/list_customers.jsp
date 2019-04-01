<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
	
	
<div class="container d-flex justify-content-center mt-3">
  <div class="page-header">
    <h1 style="color: red; text-align: center;">Customers Info</h1>      
  </div>
  </div>
  <c:if test="${!empty errorMsg}">
         <h3 class="text-danger font-weight-bold" align="center"><b>${errorMsg} </b></h3>
   </c:if><br>
<div class="container">

<c:choose>
	<c:when test="${! empty listDTO }">
		<table class="table table-striped table-bordered text-center" id="customers">
			<tr >
				<th>Sr No</th>
				<th>Customer ID</th>
				<th>Customer Name</th>
				<th>Address</th>
				<th>Mobile No</th>
				<th>Bill Amount</th>
				<th colspan="2" class=" ">Operations</th>
			</tr>
			<c:forEach var="dto" items="${listDTO }">
				<tr >
				<td>${dto.srNo}</td>
				<td>${dto.cno }</td>
				<td>${dto.cname}</td>
				<td>${dto.caddr }</td>
				<td>${dto.mobileNo}</td>
				<td>${dto.billAmt}</td>
				<td><a href="update.htm?cno=${dto.cno }" class="btn btn-primary"><i class="fa fa-edit fa-fw mr-2" aria-hidden="true"></i>Update</a></td>
				<td><a href="delete.htm?cno=${dto.cno }" onclick="return confirm('Are You Sure To Delete ?')" class="btn btn-danger"><i class="fa fa-trash fa-fw mr-2" aria-hidden="true"></i>Delete</a></td>
				
				</tr>
				
			</c:forEach>

		</table>

	</c:when>
	<c:otherwise>
		<h1 style="color:red;text-align:center">Records Not Found</h1>
	</c:otherwise>

</c:choose>
 <c:if test="${!empty resMsg}">
         <h3 class="text-info font-weight-bold" align="center"><b>${resMsg} </b></h3>
   </c:if><br>
<div class="container d-flex justify-content-center">

<a href="add.htm" class="btn btn-success"><i class="fa fa-plus fa-fw mr-2" aria-hidden="true"></i>ADD CUSTOMER</a>
</div>
</div>

<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>