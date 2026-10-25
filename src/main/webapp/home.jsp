<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="styles.css">
 <style>
     body {
         font-family: Arial, sans-serif;
         background-color: #f0f2f5;
         margin: 0;
         padding: 20px;
     }
     h1, h2 {
         color: #333;
     }
     form {
         background-color: #fff;
         border-radius: 8px;
         box-shadow: 0 2px 4px rgba(0,0,0,0.1);
         padding: 20px;
         margin-bottom: 20px;
     }
     label {
         display: block;
         font-weight: bold;
         margin-bottom: 5px;
     }
     input[type="text"] {
         width: calc(100% - 22px);
         padding: 8px;
         border-radius: 4px;
         border: 1px solid #ccc;
         margin-bottom: 10px;
     }
     button {
         background-color: #007BFF;
         color: white;
         padding: 10px 20px;
         border: none;
         border-radius: 4px;
         cursor: pointer;
     }
     button:hover {
         background-color: #0056b3;
     }
 </style>

</head>
<body>
<h1>Popular Clothes</h1>
<!-- Display popular clothes here -->
<h2>Recherchez un item</h2>
<div id="Recherche">
<form action="RechercheServlet" method="post">
    <label for="item">Item:</label>
    <input type="text" id="item" name="item" required>
    <button type="submit">Rechercher</button>
</form>
</div>
<div id="ListProduits">
<form action="ProduitsServlet" method="post">
    <label for="item">Afficher la liste des produits</label>
    <button type="submit">Liste Produits</button>
</form>
</div>
</body>
</html>
