<!DOCTYPE html>
<html lang= »fr »>
	<head>
		<meta charset= »UTF-8″>
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
		</style>
	</head>
<body>
    <h2>Résultats de la recherche</h2>
    <%@ page import="org.example.Clothing" %>
	<%@ page import="java.util.List" %>
	

	
	<table>
	    <tr>
	        <th>ID</th>
	        <th>Name</th>
	        <th>Price</th>
	        <th>Popular</th>
	    </tr>

	    <% List<Clothing> searchedClothes = (List<Clothing>) request.getAttribute("liste"); %>
	    <% if (searchedClothes != null && !searchedClothes.isEmpty()) { %>
	        <% for (Clothing clothing : searchedClothes) { %>
	            <tr>
					<td><%= clothing.getId() %>
					 <td><%= clothing.getName() %></td>
					 <td><%= clothing.getPrice() %></td>
					 <td><%= clothing.isPopular() ? "Yes" : "No" %></td>
	            </tr>
	        <% } %>
	    <% } else { %>
	        <tr>
	            <td colspan="4">No results found.</td>
	        </tr>
	    <% } %>

	</table>

</body>
</html>
