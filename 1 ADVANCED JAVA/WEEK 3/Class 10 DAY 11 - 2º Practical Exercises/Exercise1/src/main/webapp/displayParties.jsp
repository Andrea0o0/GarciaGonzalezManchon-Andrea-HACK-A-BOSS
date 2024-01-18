<%-- 
    Document   : displayParties
    Created on : Jan 17, 2024, 8:20:30 AM
    Author     : andre
--%>

<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="com.practicalexercises.exercise1.logic.Party"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <%
            Map<String, Integer> partiesVotesList = (HashMap<String, Integer>) request.getSession().getAttribute("votesList");
        %>
        <div class="container mt-4">
            <h2 class="mb-4">Party Votes</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Party Name</th>
                        <th>Number of Votes</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Entry<String, Integer> party : partiesVotesList.entrySet()) {%>
                    <tr>
                        <td><%=party.getKey()%></td>
                        <td><%=party.getValue()%></td>
                    </tr>    
                    <% }%>
                </tbody>
            </table>
            <button class="btn btn-success" onclick="returnToIndex()">Return Home</button>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <script>
            function returnToIndex() {
                window.location.href = 'index.jsp';
            }
        </script>
    </body>
</html>
