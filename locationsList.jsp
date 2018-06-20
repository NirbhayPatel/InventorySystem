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
  #locatablee {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 10%;
    height: 100%;
}}
.right {
left: 300px;
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
  <p class="navbar-text pull-right col-xs-2 f-white">Locations</p>
</nav>
<script type="text/javascript">
        $(document).ready(function() {
        	abchits();

        });     
        
        
        function abchits(){
        	var abc = $("#locaname").text();
        	var abc1 = $.trim(abc);
            $('#locaname').click(function()
            {
                $.ajax({
                    type: "get",
                    url: "/rest/location/"+abc1, 
                    dataType: "json",
                 
                     success: function(o){
                    var key0 = Object.keys(o)[0];  
                    var key2 = Object.keys(o)[3];  
					var key = Object.keys(o)[1];
					value = o[key];
					value1 = o[key0];					
					value2 = o[key2];
					$("#another-input").val(value);
					$('.disi_field').val(value2.cwar.toString());
					$("#another-input1").val(value1);
									
					
                    } 
                });
            });        	
        }
    </script>
    
    
    
    
    
<div class="split left">
<table id="locatable" class="table table-bordered">
<col width="10">
    <tr>
        <th>Locations</th>
    </tr>
    <c:forEach items="${locationlist}" var="location">
    <tr>
        <td id="locaname" >
            <c:out value="${location.loca}" />
        </td>
    </tr>
    </c:forEach>
</table>
</div>
<div class="split right">
<div class="tab-content col-md-10">
        <div class="tab-pane active" id="tab_a">
			 <div class="form-group row flex-v-center">
			  <div class="col-xs-4">
					<label for="another-input">Warehouses:</label>
				</div>
				<div class="col-xs-5">
					<input type="text" class="form-control disi_field"/> <br>
				</div>
				</div>
				<div class="form-group row flex-v-center">
				<div class="col-xs-4">
					<label for="another-input">Location:</label>
				</div>
				<div class="col-xs-5">
					<input type="text" id="another-input1" class="form-control"/>
				</div>
				</div>
				<div class="form-group row flex-v-center">
				<div class="col-xs-4">
					<label for="another-input">Description:</label>
				</div>
				<div class="col-xs-5">
					<input type="text" id="another-input" class="form-control"/>
				</div>
			</div>
			
        </div>
        
       
         <div class="row">
	                     <form class="col-md-2"  action="/createLocation">
	                        <div class="btn-group">
	                           <button type="submit" id="sample_editable_1_new" class="btn blue">
	                          	Add New Location <i class="fa fa-plus"></i>
	                           </button>
	                        </div>

						</form>
						</div>
       
</div>

</div>

</body>
</html>


