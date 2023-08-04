package Controllers;

import Entity.ChucVu;
import Entity.NguoiDung;
import Services.IService;
import Services.Impl.ChucVuService;
import Services.Impl.NguoiDungService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "NguoiDungServlet", value = {
        "/nguoidung/index",
        "/nguoidung/create",
        "/nguoidung/store",
        "/nguoidung/edit",
        "/nguoidung/update",
        "/nguoidung/delete"
})
public class NguoiDungServlet extends HttpServlet {
    IService ndService;
    IService cvService;

    public NguoiDungServlet() {
        ndService = new NguoiDungService();
        cvService = new ChucVuService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("edit")) {
            edit(request, response);
        } else if (uri.contains("delete")) {
            delete(request, response);
        } else {
            index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            store(request, response);
        } else if (uri.contains("update")) {
            update(request, response);
        } else {
            index(request, response);
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "../View/nguoidung/index.jsp");
        request.setAttribute("lst", ndService.getAll());
        request.setAttribute("lstCV", cvService.getAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("../View/layout.jsp");
        dispatcher.forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NguoiDung nd = new NguoiDung();
        try {
            BeanUtils.populate(nd, request.getParameterMap());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse(request.getParameter("ngaySinh1"));
            nd.setNgaySinh(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChucVu cv = (ChucVu) cvService.getObjByMa(request.getParameter("CV"));
        nd.setIdCV(cv);
        ndService.save(nd);
        response.sendRedirect("../nguoidung/index");

    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NguoiDung nd = (NguoiDung) ndService.getObjByMa(ma);
        request.setAttribute("view", "../View/nguoidung/edit.jsp");
        request.setAttribute("lstCV", cvService.getAll());
        request.setAttribute("nd", nd);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../View/layout.jsp");
        dispatcher.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NguoiDung nd = (NguoiDung) ndService.getObjByMa(request.getParameter("ma"));
        try {
            BeanUtils.populate(nd, request.getParameterMap());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date d = sdf.parse(request.getParameter("ngaySinh1"));
            nd.setNgaySinh(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ChucVu cv = (ChucVu) cvService.getObjByMa(request.getParameter("CV"));
        nd.setIdCV(cv);
        ndService.update(nd);
        response.sendRedirect("../nguoidung/index");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        NguoiDung nd = (NguoiDung) ndService.getObjByMa(ma);
        ndService.delete(nd);
        response.sendRedirect("../nguoidung/index");
    }


}
