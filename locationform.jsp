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
    <title>Location Information</title>
    <!-- Bootstrap CSS -->
    <%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <style type="text/css">
        .myrow-container{
            margin: 20px;
        }
        #warehousetype{
        position:absolute;
        right:470px;
        width: 200px;}
    </style>
</head>
<body class=".container-fluid">
    <div class="container myrow-container">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">
                    Location Details
                </h3>
            </div>
            
            <div class="panel-body">
                <form:form id="locationRegisterForm" cssClass="form-horizontal" modelAttribute="location" method="post" action="newLocation">
    
                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="loca" >Location</form:label> </div>
                        <div class="col-xs-6">                   
                            <form:input cssClass="form-control" path="loca"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <form:label path="dsca" cssClass="control-label col-xs-3">Description</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="dsca"/>
                        </div>
                    </div>
                    <div class="form-group">
                    <form:label path="dsca" cssClass="control-label col-xs-3">Warehouses</form:label> 
                        <div class="col-lg-5">                        
                    <select class="form-control"  required="" id="warehousetype"> 
                   <option value="">Select Warehouse </option> 
                    <c:forEach items="${warehouselist}"  var="warehouse">          
                     <option>
                     <c:out value="${warehouse.cwar}"/>
                     </option>                                                        
                      </c:forEach>
                  </select> 
                 </div> 
                 </div>
    
                    <div class="form-group">
                        <div class="row">
                            <div class="col-xs-4">
                            </div>
                            <div class="col-xs-4">
                                <input type="submit" id="saveLocation" class="btn btn-primary" value="Save"/>
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