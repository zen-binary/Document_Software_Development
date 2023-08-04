<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/04/2023
  Time: 1:03 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<c:if test="${ not empty errorMessage }">
    <div class="alert alert-danger">${ errorMessage }</div>
</c:if>

<form action="../login/index" method="post">
    <div class="mt-3">
        <label>Mã</label>
        <input type="text" name="ma" class="form-control"/>
    </div>
    <div class="mt-3">
        <label>Mật khẩu</label>
        <input type="password" name="matKhau" class="form-control"/>
    </div>
    <div class="mt-3">
        <button class="btn btn-primary">Đăng nhập</button>
    </div>
</form>