<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24/04/2023
  Time: 3:11 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<form method="post" action="../nguoidung/store">
    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Mã</label>
            <input type="text" name="ma" class="form-control"/>
        </div>
    </div>

    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Tên</label>
            <input type="text" name="ten" class="form-control"/>
        </div>
    </div>

    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Giới Tính</label>
            <div class="orm-check form-check-inline">
                <input type="radio" name="gioiTinh">
                <label>Nam</label>
            </div>
            <div class="orm-check form-check-inline">
                <input type="radio" name="gioiTinh">
                <label>Nữ</label>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Ngày Sinh</label>
            <input type="date" name="ngaySinh1" class="form-control"/>
        </div>
    </div>
    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Chức Vụ</label>
            <select name="CV">
                <c:forEach var="cv" items="${lstCV}">
                    <option value="${cv.ma}">${cv.ten}</option>
                </c:forEach>
            </select>


        </div>
    </div>

    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Địa Chỉ</label>
            <input type="text" name="diaChi" class="form-control"/>
        </div>
    </div>

    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Thành Phố</label>
            <select name="thanhPho">
                <option value="hn">Hà Nội</option>
                <option value="hcm">HCM</option>
            </select>
        </div>
    </div>

    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Mật Khẩu</label>
            <input type="password" name="matKhau" class="form-control"/>
        </div>
    </div>

    <div class="row">
        <div class="mb-3 col-xl-6">
            <button type="submit" class="btn btn-primary">Thêm Mới</button>
        </div>
    </div>
</form>

<div class="table-responsive">
    <table class="table">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Giới Tính</th>
            <th>Ngày Sinh</th>
            <th>Chức Vụ</th>
            <th>Địa Chỉ</th>
            <th>Thành Phố</th>
            <th>Mật Khẩu</th>
        </tr>
        </thead>
        <c:if test="${ f:length(lst) == 0 }">
            <h3>Không có dữ liệu</h3>
        </c:if>
        <c:if test="${ f:length(lst) != 0 }">
            <tbody>
            <c:forEach var="nd" items="${lst}" varStatus="i">
                <tr>
                    <td>${i.index + 1}</td>
                    <td>${nd.ma}</td>
                    <td>${nd.ten}</td>
                    <td>${nd.gioiTinh == 0?"Nam":"Nữ"}</td>
                    <td>${nd.ngaySinh}</td>
                    <td>${nd.idCV}</td>
                    <td>${nd.diaChi}</td>
                    <td>${nd.thanhPho == "hn"?"Hà Nội":"Hồ Chí Minh"}</td>
                    <td>${nd.matKhau}</td>
                    <td><a class="btn btn-primary" href="../nguoidung/edit?ma=${nd.ma}">Cập Nhập</a></td>
                    <td><a class="btn btn-danger" href="../nguoidung/delete?ma=${nd.ma}">Xóa</a></td>
                </tr>
            </c:forEach>

            </tbody>
        </c:if>
    </table>
</div>