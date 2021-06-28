<!-- for save gradelist -->
<script>
	function saveGradeList() {
		var saveGrade = {};
		saveGrade["code"] = $("#code").val();
		saveGrade["description"] = $("#description").val();
		saveGrade["cadrecode"] = $("#cadrecode").val();
		$.ajax({
			type : "post",
			contentType : "application/json",
			url : "saveNewGrade", //this is my servlet
			data : JSON.stringify(saveGrade),
			success : function(data) {
				$('#processedData').html(data.successMessage);
				$('#displayDiv').show();

				gradesList();
			}
		});
	}
</script>

<div id="displayDiv">
	<h3 id="processedData" align="center" style="color: red"></h3>
</div>
<div class="row">
	<div class="box col-md-12">
		<div class="box-inner">
			<div class="box-header well">
				<h2>
					<i class="glyphicon glyphicon-info-sign"></i> GradeList
				</h2>


			</div>


			<div class="box-content row">
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Code</label> <input
						type="text" id="code" name="code" class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">Description</label>
					<input type="text" id="description" name="description"
						class="form-control">
				</div>
				<div class="form-group has-warning col-md-4">
					<label class="control-label" for="inputWarning1">CadreCode</label>
					<input type="text" id="cadrecode" name="cadrecode"
						class="form-control">
				</div>

			</div>

		</div>
		<div align="center">
			<input type="submit" class="btn btn-success" value=" Add"
				onclick="saveGradeList()">
		</div>

	</div>

</div>
<script src="resources/dist/js/sidebarmenu.js"></script>
