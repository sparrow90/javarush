<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>CRUD</title>
</head>
<body>

<form action="" method="get" id="searchForm">
    <input type="hidden" name="page" value="${param.page}"  id="page">
    <input type="text" name="q" value="${param.q}" placeholder="Search..."><br/>
    <input type="submit" value="Search">
</form>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Role</th>
        <th>#</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <td colspan="6">
            <a href="/create">Add</a>
        </td>
    </tr>
    <tr>
        <td colspan="6">
            <c:forEach begin="1" end="${page.totalPages}" var="p">
                <a href="#" class="page" data-id="${p}">${p}</a>&nbsp;
            </c:forEach>
        </td>
    </tr>
    </tfoot>
    <tbody>
    <c:forEach items="${page.content}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.admin}</td>
            <td>${user.createDate}</td>
            <td>
                <a href="/${user.id}">Edit</a>
                <a href="/delete/${user.id}" class="btn-delete" data-id="${user.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script type="text/javascript" src="/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
    $(function() {
        $('.btn-delete').on('click', function (e) {
            if (!confirm('Are you sure?')) {
                e.preventDefault();
            }
        });
        $('.page').on('click', function() {
            $('#page').val($(this).data('id'));
            $('#searchForm').submit();
        })
    });
</script>

</body>
</html>
