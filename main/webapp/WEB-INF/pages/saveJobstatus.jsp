<!-- <script>
function saveJobStatus(){
	var savejobstatus = {};
	savejobstatus["description"] = $("#description").val();
	 $.ajax({
	        type: "post",
	        contentType : "application/json",
	        url: "saveNewjobstatus", //this is my servlet
	        data : JSON.stringify(savejobstatus),
	        success: function(data){ 
	        	$('#processedData').html(data.successMessage);
				$('#displayDiv').show();
				jobstatus();
	        }
	 });
}
</script> -->

<div id="displayDiv">
	<h3 id="processedData" align="center" style="color: red"></h3>
</div>
<div class="row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-info-sign"></i> Job Status
				</h2>


			</div>


			<div class="box-content row">
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Description</label>
					<input type="text" id="description" name="description"
						class="form-control">
				</div>

			</div>

		</div>
		<div align="center">
			<input type="submit" class="btn btn-success" value=" Add"
				onclick="saveJobStatus()">
		</div>

	</div>

</div>
<script src="resources/dist/js/sidebarmenu.js"></script>
