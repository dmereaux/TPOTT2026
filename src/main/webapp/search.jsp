<!DOCTYPE html>
<html>
<head>
    <title>Search Results</title>
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
<h2>Search Results for "<%= request.getParameter("query") %>"</h2>

<%@ page import="java.util.List" %>
<%@ page import="org.example.Clothing" %>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Popular</th>
    </tr>

    <% List<Clothing> searchedClothes = (List<Clothing>) request.getAttribute("searchedClothes"); %>
    <% if (searchedClothes != null && !searchedClothes.isEmpty()) { %>
        <% for (Clothing clothing : searchedClothes) { %>
            <tr>
				<td>6666</td>
				<td>jupe</td>
				<td>45</td>
            </tr>
        <% } %>
    <% } else { %>
        <tr>
            <td colspan="4">No results found.</td>
        </tr>
    <% } %>

</table>

<br/>
<a href="home">Back to Home</a>
</body>
</html>
