<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JSP + JSTL MVC Topics</title>
    <style>
        body { font-family: system-ui, sans-serif; margin: 2rem; background: #f8fafc; }
        table { border-collapse: collapse; width: 100%; max-width: 640px; background: #fff; }
        th, td { border: 1px solid #cbd5e1; padding: 0.75rem; text-align: left; }
        th { background: #1e293b; color: #fff; }
    </style>
</head>
<body>
    <h2>Java EE Topics (Rendered via JSP + JSTL on Port 8402)</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Topic</th>
                <th>Category</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="t" items="${topics}">
                <tr>
                    <td><c:out value="${t.id()}"/></td>
                    <td><c:out value="${t.title()}"/></td>
                    <td><c:out value="${t.category()}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
