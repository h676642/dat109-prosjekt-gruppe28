<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <title>Dashbord</title>
    <link rel="stylesheet" href="css.css">
</head>
<body>

<h1>Dashbord</h1>

<div class="modul-container">

    <c:forEach var="modul" items="${moduler}">
        <div class="modul">
            <div class="modul-header" style="background-color: ${modul.farge};"></div>
            <div class="modul-innhold">
                <div class="fagnavn">${modul.navn}</div>
                <div class="kode">${modul.kode}</div>
                <div class="semester">${modul.semester}</div>
                <div class="ikoner">
                    <div class="ikon"></div>
                    <div class="ikon"></div>
                    <div class="ikon"></div>
                </div>
            </div>
        </div>
    </c:forEach>

</div>

</body>
</html>
