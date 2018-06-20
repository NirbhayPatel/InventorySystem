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
  #waretable {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 10%;
    height: 100%;
}}
.right {
  right: 0;
}
#sample_editable_1_new {
    position:absolute;
     left: 202px; 
    top: 50px;

}
  </style>

</head>
<body>

<nav class="navbar navbar-inverse">
  <p class="navbar-text pull-right col-xs-2 f-white">Warehouses</p>
</nav>
<script type="text/javascript">
	$(document).ready(function() {
        		var abc = $("#warename").text();
             	var abc1 = $.trim(abc);
             	$( "#warename" ).on( "click", function() 
            {
            
                $.ajax({
                    type: "get",
                    url: "/rest/warehouse/"+abc1, 
                    dataType: "json",
                    
                     success: function(o){
                    var key0 = Object.keys(o)[0];  
                    var key2 = Object.keys(o)[2];  
					var key = Object.keys(o)[1];
					value0 = o[key0];
					$('.disi_field').val(value0);					
					value2 = o[key2];
					$("#another-input").val(value2);
					value = o[key];
					if (value === true){
						$('.locaiotn_ckbox').attr('checked','true')
					}else{
						$('.locaiotn_ckbox').attr('checked','false')
					}					
					
                    } 
                
                });
                alert(abc1);
            });        	
         });
    </script>
    
    
<div class="split left">
<table id="waretable" class="table table-bordered">
<col width="10">
    <tr>
        <th>warehouses</th>
    </tr>
    <c:forEach items="${warehouselist}" var="warehouse">
    <tr>
        <td id="warename">
            <c:out value="${warehouse.cwar}" />
        </td>
    </tr>
    </c:forEach>
</table>
</div>

<div class="split right">
<div class="tab-content col-md-12" >
        <div class="tab-pane active" id="tab_a">
			 <div class="form-group row flex-v-center">
			  <div class="col-xs-2" >
					<label for="another-input" >Warehouses:</label>
				</div>
				<div class="col-xs-3">
					<input type="text" class="form-control disi_field" />
				</div>
				<div class="col-xs-5">
					<input type="text" id="another-input" class="form-control" />
				</div>
			</div>
			<label>
			 Location Controlled <input class="locaiotn_ckbox" type="checkbox" >
			</label>
        </div>       
     </div>
<div class="row" >
	                     <form class="col-md-5"  action="/createWarehouse">
	                        <div class="btn-group" >
	                           <button type="submit" id="sample_editable_1_new" class="btn blue">
	                          	Add New Warehouse <i class="fa fa-plus"></i>
	                           </button>
	                        </div>

						</form>
						</div>
</div>
</body>
</html>