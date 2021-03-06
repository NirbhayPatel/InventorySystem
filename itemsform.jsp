<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Item Information</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container{
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
    <div class="container myrow-container">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">
                    Item Details
                </h3>
            </div>
            <div class="panel-body">
                <form:form id="itemRegisterForm" cssClass="form-horizontal" modelAttribute="items" method="post" action="newitem">
    
                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="items1" >Item Name</form:label> </div>
                        <div class="col-xs-6">                   
                            <form:input cssClass="form-control" path="items1"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="dsca" cssClass="control-label col-xs-3">Description</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="dsca"/>
                        </div>
                    </div>
    
    
                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-4">
                            </div>
                            <div class="col-xs-4">
                                <input type="submit" id="saveItem" class="btn btn-primary" value="Save"/>
                            </div>
                            <div class="col-xs-4">
                            </div>
                        </div>
                    </div>
    
                </form:form>
            </div>
        </div>
    </div>
    </body>
</html>