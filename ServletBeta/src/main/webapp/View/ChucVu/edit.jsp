<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/04/2023
  Time: 2:38 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<form method="post" action="../chucvu/update">
    <div class="form-group">
        <div class="row mt-3">
            <div class="col-6">
                <label for="">Mã</label>
                <input type="text" class="form-control" name="ma" value="${cv.ma}"/>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label for="">Tên</label>
                <input type="text" class="form-control" name="ten" value="${cv.ten}"/>
            </div>
        </div>

    </div>

    <div class="row mt-3">
        <div class="col-6">
            <button class="btn btn-primary">Cập Nhập</button>
        </div>
        <div class="col-6"></div>
    </div>


</form>
