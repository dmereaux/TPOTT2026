<!DOCTYPE html>
<html lang= »fr »>
	<head>
		<meta charset= »UTF-8″>
	    <title>Résultat</title>
		<link rel="stylesheet" type="text/css" href="styles.css">
	    <style>
	        table {
	            width: 100%;
	            border-collapse: collapse;
	        }
	        th, td {
	            padding: 8px;
	            text-align: left;
	            border-bottom: 1px solid #ddd;
	        }
	        tr:hover {background-color: #f5f5f5;}
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
