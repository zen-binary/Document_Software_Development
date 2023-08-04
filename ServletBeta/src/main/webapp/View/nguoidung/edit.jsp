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

<form method="post" action="../nguoidung/update">
    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Mã</label>
            <input type="text" name="ma" class="form-control" value="${nd.ma}"/>
        </div>
    </div>

    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Tên</label>
            <input type="text" name="ten" class="form-control" value="${nd.ten}"/>
        </div>
    </div>

    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Giới Tính</label>
            <div class="orm-check form-check-inline">
                <input type="radio" name="gioiTinh" value="0" ${nd.gioiTinh == 0?"checked":""} >
                <label>Nam</label>
            </div>
            <div class="orm-check form-check-inline">
                <input type="radio" name="gioiTinh" value="1" ${nd.gioiTinh == 1?"checked":""}>
                <label>Nữ</label>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Ngày Sinh</label>
            <input type="date" name="ngaySinh1" class="form-control" value="${nd.ngaySinh}"/>
        </div>
    </div>
    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Chức Vụ</label>
            <select name="CV">
                <c:forEach var="cv" items="${lstCV}">
                    <option value="${cv.ma}" ${nd.idCV.ten == cv.ten?"selected":""}>${cv.ten}</option>
                </c:forEach>
            </select>


        </div>
    </div>

    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Địa Chỉ</label>
            <input type="text" name="diaChi" class="form-control" value="${nd.diaChi}"/>
        </div>
    </div>

    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Thành Phố</label>
            <select name="thanhPho">
                <option value="hn" ${nd.thanhPho == "hn"?"selected":""} >Hà Nội</option>
                <option value="hcm" ${nd.thanhPho == "hcm"?"selected":""}>Hồ Chí Minh</option>
            </select>
        </div>
    </div>

    <div class="row">
        <div class="mb-3 col-xl-6">
            <label>Mật Khẩu</label>
            <input type="password" name="matKhau" class="form-control" value="${nd.matKhau}"/>
        </div>
    </div>

    <div class="row">
        <div class="mb-3 col-xl-6">
            <button type="submit" class="btn btn-primary">Cập Nhật</button>
        </div>
    </div>
</form>
