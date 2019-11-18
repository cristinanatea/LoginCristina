<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<title>Cris's login</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<link href="<c:url value="/criss.css" />" rel="stylesheet">

</head>
<body>
    <div class="container-fluid">
        <div class="row mx-auto">
            <div class="col-lg-6 leftside d-none d-lg-block">
		    <!-- <img src="original.jpg" class="img-fluid" /> -->
            </div>
            <div class="col-lg-6 my-auto">
                <form class="form-control" action ="login" method= "post">
                        <img src="woman.jfif" class="rounded mx-auto d-block" />
                        <div class="form-group">
                            <label for="email" class="col-sm-2">Email:</label>
                            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" />
                        </div>
						<div class="form-group">
                            <label for="pwd" class="col-sm-2">Password:</label>
                            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" />
                        </div>

                        <div class="checkbox">
                            <label><input type="checkbox"> Remember me</input></label>
                        </div>

                        <c:if test="${!empty errorMessage}">
                            <div class="text-center">
				                <c:out value="Error: ${errorMessage}" />
                            </div>
                        </c:if>
			
                        <div class="text-center">
                            <button type="submit" class="btn">Submit</button>
						</div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>