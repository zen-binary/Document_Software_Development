<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/04/2023
  Time: 1:29 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<form method="post" action="../chucvu/store">
    <div class="form-group">
        <div class="row mt-3">
            <div class="col-6">
                <label for="">Mã</label>
                <input type="text" class="form-control" name="ma"/>
                <c:if test="${not empty errorMa}">
                    <span class="alert-danger">${errorMa}</span>
                </c:if>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label for="">Tên</label>
                <input type="text" class="form-control" name="ten"/>
                <c:if test="${not empty errorTen}">
                    <span class="alert-danger">${errorTen}</span>
                </c:if>
            </div>
        </div>

    </div>

    <div class="row mt-3">
        <div class="col-6">
            <button class="btn btn-primary">Thêm mới</button>
        </div>
        <div class="col-6"></div>
    </div>


</form>

<div class="table-responsive">

    <table class="table">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên</th>
        </tr>
        </thead>
        <c:if test="${ f:length(lst) == 0 }">
            <h3>Không có dữ liệu</h3>
        </c:if>
        <c:if test="${ f:length(lst) != 0 }">
        <tbody>
        <c:forEach var="cv" items="${lst}" varStatus="i">
            <tr>
                <td>${i.index +1 }</td>
                <td>${cv.ma}</td>
                <td>${cv.ten}</td>
                <td><a class="btn btn-primary" href="../chucvu/edit?ma=${cv.ma}">Cập Nhập</a></td>
                <td><a class="btn btn-danger" href="../chucvu/delete?ma=${cv.ma}">Xóa</a></td>

            </tr>
        </c:forEach>

        </tbody>
    </table>

    </c:if>

</div>

