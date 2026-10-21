<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
<h1>Popular Clothes</h1>
<!-- Display popular clothes here -->
<h2>Recherchez un item</h2>
<form action="RechercheServlet" method="post">
    <label for="item">Item:</label>
    <input type="text" id="item" name="item" required>
    <button type="submit">Rechercher</button>
</form>
</body>
</html>
