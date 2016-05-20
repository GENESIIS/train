<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery Editable Select Plugin Examples</title>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet" />
<link href="dist/editablesearch/source/jquery.editable-select.min.css"
	rel="stylesheet" />
<link href="dist/editablesearch/source/jquerysctipttop.css"
	rel="stylesheet" type="text/css">
</head>
<body>

	<div class="container" style="margin-top: 150px;">
		<h2>jQuery Editable Select Plugin Examples</h2>
		<hr />

		<div class="row-fluid">
			<div class="span6">
				<h3>Basic example</h3>
				<div class="row-fluid">
					<div class="span4">Into this</div>
					<div class="span7">
						<select id="basic">
							<option>Alfa Romeo</option>
							<option>Audi</option>
							<option>BMW</option>
							<option>Citroen</option>
							<option>Fiat</option>
							<option>Ford</option>
							<option>Jaguar</option>
							<option>Jeep</option>
							<option>Lancia</option>
							<option>Land Rover</option>
							<option>Mercedes</option>
							<option>Mini</option>
							<option>Nissan</option>
							<option>Opel</option>
							<option>Peugeot</option>
							<option>Porsche</option>
							<option>Renault</option>
							<option selected="selected">Smart</option>
							<option>Volkswagen</option>
							<option>Volvo</option>
						</select>
					</div>
				</div>
			</div>
		</div>


		<script src="dist/editablesearch/source/jquery-latest.min.js"></script>
		<script src="dist/editablesearch/source/jquery.editable-select.js"></script>
		<script>
			$.ajaxPrefilter(function(options, originalOptions, jqXHR) {
				options.async = true;
			});
			window.onload = function() {
				$('#basic').editableSelect();
			}
		</script>
	</div>
</body>
</html>
