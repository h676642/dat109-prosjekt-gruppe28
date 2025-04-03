<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css.css">
<title>Innlogging</title>
</head>

<body>

	<form action="" method="post">

  
			<h2>Innlogging</h2> 

			Studentnummer/lærernummer(?) (8 siffer):<br> 
			<input type="text" name="mobil" id="mobil" value="" required pattern="^[0-9]{8}$"><br>
			<br>
			
			Passord<br> 
			<input type="password" name="passord" id="passord" required><br>
			<br>
			
			<button type="submit">Logg Inn</button>
	</form>
</body>
</html>
