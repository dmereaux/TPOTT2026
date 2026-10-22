<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Résultat</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
	<style>
	        body {
	            font-family: Arial, sans-serif;
	            background-color: #f0f2f5;
	            margin: 0;
	            padding: 20px;
	        }
	        h2 {
	            color: #333;
	        }
	        table {
	            width: 100%;
	            border-collapse: collapse;
	            background-color: #fff;
	            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
	            margin-bottom: 20px;
	        }
	        th, td {
	            padding: 8px;
	            text-align: left;
	            border-bottom: 1px solid #ddd;
	        }
	        tr:hover {
	            background-color: #f5f5f5;
	        }
	        th {
	            background-color: #007BFF;
	            color: white;
	        }
	        button {
	            background-color: #007BFF;
	            color: white;
	            padding: 10px 20px;
	            border: none;
	            border-radius: 4px;
	            cursor: pointer;
	            margin-top: 10px;
	        }
	        button:hover {
	            background-color: #0056b3;
	        }
	    </style>
</head>
<body>
    <h2>Résultats de la recherche</h2>
    <%@ page import="org.example.Clothing" %>
    <%@ page import="java.util.List" %>

    <table id="clothingTable">
        <tr>
            <th></th>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Popular</th>
        </tr>

        <% List<Clothing> allClothes = (List<Clothing>) request.getAttribute("liste"); %>
        <% if (allClothes != null && !allClothes.isEmpty()) { %>
            <% for (Clothing clothing : allClothes) { %>
                <tr>
                    <td><input type="checkbox" class="clothingCheckbox" data-price="<%= clothing.getPrice() %>"></td>
                    <td><%= clothing.getId() %></td>
                    <td><%= clothing.getName() %></td>
                    <td><%= clothing.getPrice() %></td>
                    <td><%= clothing.isPopular() ? "Yes" : "No" %></td>
                </tr>
            <% } %>
        <% } else { %>
            <tr>
                <td colspan="5">No results found.</td>
            </tr>
        <% } %>

    </table>
    <button type="button" onclick="calculateTotal()">Calculer</button>
    <p id="totalPrice">Total Price: 0</p>

    <script>
        function calculateTotal() {
            const checkboxes = document.querySelectorAll('.clothingCheckbox');
            let totalPrice = 0;
            checkboxes.forEach(checkbox => {
                if (checkbox.checked) {
                    totalPrice += parseFloat(checkbox.getAttribute('data-price'));
                }
            });
            document.getElementById('totalPrice').innerText = 'Total Price: ' + totalPrice.toFixed(2);
        }
    </script>

</body>
</html>
