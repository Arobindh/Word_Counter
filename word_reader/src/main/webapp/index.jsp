<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width-device-width">
<link rel="stylesheet" href="/style.css">
<title>Upload File</title>
</head>
<body>
	<header>
		<div class="container">
			<div id="branding">
				<h1>Word Counter</h1>
			</div>
		</div>
	</header>
	<section id="showcase">
		<div class="container">
			<h1>Please upload a .txt file:</h1>
			<form action="/upload" method="Post" enctype="multipart/form-data">
				<input type="file" name="file" accept=".txt" required /><br />
				<button type="" submit" class="button">Upload</button>
			</form>
		</div>
	</section>
</body>
</html>