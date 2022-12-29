<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Form</title>
</head>
<body>
	<form action="UploadServlet" method="post" enctype="multipart/form-data" >
		<div>
			<label>Select Image</label>
			<input type="file" name="image" >
		</div>
		<button type="submit" >Upload</button>
	</form>
</body>
</html>