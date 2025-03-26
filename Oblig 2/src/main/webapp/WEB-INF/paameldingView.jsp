<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="no">
<head>
<link href="simple.css" rel="stylesheet" type="text/css" />
<!--  <script src="js/myscript.js" defer></script>-->
<title>P�melding</title>
</head>

<body>
	<fieldset style="width:50px">
		<h2>P�melding</h2>
		<p style="color: red;">${feilmeldinger}</p>

		<form action="/paamelding" method="post" id="person">
			Fornavn<br> <input type="text" name="fornavn" pattern="^[A-Z���][a-z���A-Z���\- ]{1,19}$" required
			title="Fornavn m� v�re 2-20 tegn og begynne med en stor bokstav."><br>
			
			Etternavn <br><input type="text" name="etternavn" pattern="^[A-Z���][a-z���A-Z���\-]{1,19}$" required
			title="Etternavn m� v�re 2-20 tegn og begynne med en stor bokstav. Kan ikke inneholde mellomrom"><br> 
			
			Mobil<br><input type="text" name="mobil" pattern="^\d{8}$" required
			title="Mobilnummeret m� best� av 8 siffre"><br> 
			
			Passord <br><input type="password" name="passord" id="passord" minlength="6" required>
			<br>
			
			Passord repetert <br><input type="password" name="passordRepetert" id="passordRepetert" required
			title="Passordet m� v�re likt som passordet som ble skrevet over">
			<br> 
			
					
			<label for="kjonn">Kj�nn:</label>
			<input type="radio" id="mann" name="kjonn" value="Mann" required>
			Mann <input type="radio" id="kvinne" name="kjonn" value="Kvinne" required> Kvinne <br> <input type="submit" value="Meld meg p�" />
		</form>
	</fieldset>

</body>
</html>
