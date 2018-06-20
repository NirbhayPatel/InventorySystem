<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html lang="en">
<head>
  <title>InventorySystem</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
	.navbar-inverse {background-color:#2361a9;}
	.f-white{color:#fff !important;}
.split {
position: absolute;
}

.left {
  left: 0;
  #inventable {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 10%;
    height: 100%;
}}
.right {
left: 450px;
  right: 0;
}
#sample_editable_1_new {
    
     left: 350px; 
    top: 50px;

}
  </style>

</head>
<body>

<nav class="navbar navbar-inverse">
  <p class="navbar-text pull-right col-xs-2 f-white">Inventorys</p>
</nav>
<script type="text/javascript">
        $(document).ready(function() {
        	abchits();

        });     
        
        
        function abchits(){
        	var abc = $("#invenname").text();
        	var abc1 = $.trim(abc);
            $('#invenname').click(function()
            {
                $.ajax({
                    type: "get",
                    url: "/rest/inventory/"+abc1, 
                    dataType: "json",
                 
                     success: function(o){
                    	 var key0 = Object.keys(o)[0];   
     					var key1 = Object.keys(o)[1];
     					var key2 = Object.keys(o)[2];
     					var key3 = Object.keys(o)[3];
     					var key4 = Object.keys(o)[4];
     					var key5 = Object.keys(o)[5];
     					value = o[key0];
     					value1 = o[key1];					
     					value2 = o[key2];
     					value3= o[key3];
     					value4=o[key4];
     					value5=o[key5];
     					$('.disi_field').val(value3.cwar.toString());
     					$("#another-input").val(value4.loca.toString());
     					$("#another-input2").val(value);
     					$("#another-input3").val(value1);
     					$("#another-input4").val(value2);
     					$("#another-input1").val(value5.items1.toString());
     					
                
					
                    } 
                });
            });        	
        }
    </script>
    
    
    
    
    
<div class="split left">
<table id="inventable" class="table table-bordered">
<col width="10">
    <tr>
        <th>Inventorys</th>
    </tr>
    <c:forEach items="${inventorylist}" var="inventory">
    <tr>
        <td id="invenname" >
            <c:out value="${inventory.clot}" />
        </td>
    </tr>
    </c:forEach>
</table>
</div>
<div class="split right">
<div class="tab-content col-md-10">
        <div class="tab-pane active" id="tab_a">
			 <div class="form-group row flex-v-center">
			  <div class="col-xs-3">
					<label for="another-input">Warehouses:</label>
				</div>
				<div class="col-xs-5">
					<input type="text" class="form-control disi_field"/>
				</div>
				</div>
				<div class="form-group row flex-v-center">
				<div class="col-xs-3">
					<label for="another-input">Locations:</label>
				</div>
				<div class="col-xs-5">
					<input type="text" id="another-input" class="form-control"/>
				</div>
				</div>
				<div class="form-group row flex-v-center">
				<div class="col-xs-3">
					<label for="another-input">Items:</label>
				</div>
				<div class="col-xs-5">
					<input type="text" id="another-input1" class="form-control" />
				</div>
				</div>
				<div class="form-group row flex-v-center">
				<div class="col-xs-3">
					<label for="another-input">Lot:</label>
				</div>
				<div class="col-xs-5">
					<input type="text" id="another-input2" class="form-control"/>
				</div>
				</div>
				<div class="form-group row flex-v-center">
				<div class="col-xs-3">
					<label for="another-input">Quantity On Hand:</label>
				</div>
				<div class="col-xs-5">
					<input type="text" id="another-input3" class="form-control"/>
				</div>
				</div>
				<div class="form-group row flex-v-center">
				<div class="col-xs-3">
					<label for="another-input">Quantity Allocated:</label>
				</div>
				<div class="col-xs-5">
					<input type="text" id="another-input4" class="form-control"/>
				</div>
			</div>
        </div>
        
       
         <div class="row">
	      <form class="col-md-2"  action="/createinventory">
	      <div class="btn-group">
	      <button type="submit" id="sample_editable_1_new" class="btn blue">
	       Add New Inventory <i class="fa fa-plus"></i>
	       </button>
	       </div>

		</form>
		</div>
       
</div>

</div>

</body>
</html>