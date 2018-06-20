<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Ranga Reddy">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Warehouse Information</title>
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
        #locationtype{
        position:absolute;
        right:470px;
        width: 200px;}
        #itemtype{
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
                    Inventory Details
                </h3>
            </div>
            <div class="panel-body">
                <form:form id="warehouseRegisterForm" cssClass="form-horizontal" modelAttribute="inventory" method="post" action="newInventory">
    
                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="clot" >Clot</form:label> </div>
                        <div class="col-xs-6">                   
                            <form:input cssClass="form-control" path="clot"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <div class="control-label col-xs-3"> <form:label path="qhnd" >Quantity On Hand</form:label> </div>
                        <div class="col-xs-6">                   
                            <form:input cssClass="form-control" path="qhnd"/>
                        </div>
                    </div>
    
                    <div class="form-group">
                        <form:label path="qlal" cssClass="control-label col-xs-3">Quantity Allocated</form:label>
                        <div class="col-xs-6">
                            <form:input cssClass="form-control" path="qlal"/>
                        </div>
                    </div>
                 
                 <div class="form-group"> 
                 <form:label path="warehouse" cssClass="control-label col-xs-3">Warehouses</form:label> 
                        <div class="col-lg-12">                      
                    <select class="form-control"  required="" id="warehousetype"> 
                   <option value="">Select Warehouse </option> 
                    <c:forEach items="${warehouselist}" var="warehouse">          
                     <option value ="<c:out value="${warehouse.cwar}"/>">
                     <c:out value="${warehouse.cwar}"/>
                     </option>                                                        
                      </c:forEach>
                  </select> 
                 </div> 
                 </div>
                 
                 <div class="form-group"> 
                 <form:label path="location" cssClass="control-label col-xs-3">Locations</form:label> 
                        <div class="col-lg-12"> 
                        
                    <select class="form-control"  required="" id="locationtype"> 
                   <option value="">Select Location </option> 
                    <c:forEach items="${locationlist}" var="location">          
                     <option value ="<c:out value="${location.cwar}"/>">
                     <c:out value="${location.cwar}"/>
                     </option>                                                        
                      </c:forEach>
                  </select> 
                 </div> 
                 </div>
                 
                 <div class="form-group"> 
                 <form:label path="item1" cssClass="control-label col-xs-3">Items</form:label> 
                        <div class="col-lg-12"> 
                        
                    <select class="form-control"  required="" id="itemtype"> 
                   <option value="">Select Items </option> 
                    <c:forEach items="${itemslist}" var="items">          
                     <option value ="<c:out value="${items.item1}"/>">
                     <c:out value="${items.item1}"/>
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
                                <input type="submit" id="saveInventory" class="btn btn-primary" value="Save"/>
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