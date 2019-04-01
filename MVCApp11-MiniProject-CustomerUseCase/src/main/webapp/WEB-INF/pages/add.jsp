<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<title>Add New Customer</title>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container mt-5">
<form:form commandName="custCmd" method="POST">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="cname">Customer Name</label>
      <form:input path="cname" class="form-control" id="cname" placeholder="Customer Name" autocomplete="off" />
    </div>
    <div class="form-group col-md-6">
      <label for="cadd">Address</label>
      <form:input path="caddr" class="form-control" id="cadd" placeholder="Address" autocomplete="off" />
    </div>
  </div>
 
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="mobile">Mobile Number</label>
      <form:input path="mobileNo" class="form-control" id="mobile" placeholder="Mobile Number" autocomplete="off" />
    </div>

    <div class="form-group col-md-6">
      <label for="billAmt">Bill Amount</label>
      <form:input path="billAmt" class="form-control" id="billAmt" placeholder="Bill Amount" autocomplete="off" />
    </div>
  </div>
 <div class="container d-flex justify-content-center">
  <button type="submit" class="btn btn-primary w-25"><i class="fa fa-plus-square fa-fw mr-2" aria-hidden="true"></i>Add Customer</button>
  </div>
</form:form>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>