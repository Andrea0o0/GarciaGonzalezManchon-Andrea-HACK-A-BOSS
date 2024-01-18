<%-- 
    Document   : index
    Created on : Jan 16, 2024, 2:12:03 PM
    Author     : andre
--%>

<%@ page import="com.practicalexercises.exercise1.logic.Party" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Party Vote Exercise 1</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>

        <div class="container mt-4">
            <h1 class="mb-4">Votes</h1>

            <form action="SvVote" method="POST">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="parties" id="1" value="Party A" checked>
                    <label class="form-check-label" for="1">
                        Party A
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="parties" id="2" value="Party B">
                    <label class="form-check-label" for="2">
                        Party B
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="parties" id="3" value="Party C">
                    <label class="form-check-label" for="3">
                        Party C
                    </label>
                </div>
                <button type="submit" class="btn btn-primary mt-3">Vote</button>
            </form>

            <form action="SvVote" method="GET">
                <button type="submit" class="btn btn-success mt-3">Show Results</button>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

    </body>
</html>