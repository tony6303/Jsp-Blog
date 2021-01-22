<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.css" />


<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<body>

	<div class="jumbotron text-center">
		<h1>고속버스 조회하기</h1>

	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<h3>출발지</h3>
				<div class="dropdown">
					<button type="button" class="btn btn-primary dropdown-toggle"
						data-toggle="dropdown">Dropdown button</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#" onclick="setBusan()">부산</a> 
						<a class="dropdown-item" href="#">서울</a> 
						<a class="dropdown-item" href="#">광주</a>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<h3>도착지</h3>
				<div class="txc-textbox">
					<!-- Single button -->
					<div id="example" class="btn-group">
						<button type="button" class="btn btn-default dropdown-toggle"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Action <span class="caret"> </span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="javascript:void(0)">Action</a></li>
							<li><a href="javascript:void(0)">Another action</a></li>
							<li><a href="javascript:void(0)">Somethingelse here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="javascript:void(0)">Separated link</a></li>
						</ul>
					</div>
				</div>

			</div>
			<div class="col-sm-4">
				<h3>출발 날짜</h3>
				<input type="text" name="date" id="date3" size="12" />
			</div>
		</div>

		<input type="hidden" id="depPland" readonly="readonly" disabled="disabled"> 
		<input type="hidden" id="arrPland">
		<input type="hidden" type="date" id="depPlandTime">

	</div>
	</div>

	</div>

</body>
</html>

<script>
	$('#example .dropdown-menu li > a').bind(
			'click',
			function(e) {
				var html = $(this).html();
				$('#example button.dropdown-toggle').html(
						html + ' <span class="caret"></span>');
			});

	$("#date3").datepicker({
		changeYear : true,
		changeMonth : true
	});

	function setBusan() {
		$("#depPland").val("부산")
	}
</script>
<script src="js/datepicker-ko.js"></script>
