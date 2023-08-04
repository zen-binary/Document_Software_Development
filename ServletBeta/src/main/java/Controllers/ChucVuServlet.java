package Controllers;

import Entity.ChucVu;
import Entity.NguoiDung;
import Services.IService;
import Services.Impl.ChucVuService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet(name = "ChucVuServlet", value = {
        "/chucvu/index",
        "/chucvu/create",
        "/chucvu/store",
        "/chucvu/edit",
        "/chucvu/update",
        "/chucvu/delete"
})
public class ChucVuServlet extends HttpServlet {
    IService cvService;

    public ChucVuServlet() {
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
        request.setAttribute("view", "../View/ChucVu/index.jsp");
        request.setAttribute("lst", cvService.getAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("../View/layout.jsp");
        dispatcher.forward(request, response);
    }

    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChucVu cv = new ChucVu();
        HttpSession session = request.getSession();
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");

        if (ma.isEmpty()) {
            session.setAttribute("errorMa", "Vui Lòng Nhập Mã");
            response.sendRedirect("../chucvu/index");
            return;
        } else {
            session.setAttribute("errorMa", "");

        }
        ChucVu cvv = (ChucVu) cvService.getObjByMa(ma);
        if (cvv != null) {
            session.setAttribute("errorMa", "Mã Đã Được Sử dụng");
            response.sendRedirect("../chucvu/index");
            return;
        } else {
            session.setAttribute("errorMa", "");
        }
        if (ten.isEmpty()) {
            session.setAttribute("errorTen", "Vui Lòng Nhập Tên");
            response.sendRedirect("../chucvu/index");
            return;
        } else {
            session.setAttribute("errorTen", "");

        }
        try {
            BeanUtils.populate(cv, request.getParameterMap());


        } catch (Exception e) {
            e.printStackTrace();
        }
        cvService.save(cv);
        response.sendRedirect("../chucvu/index");

    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu cv = (ChucVu) cvService.getObjByMa(ma);
        request.setAttribute("view", "../View/ChucVu/edit.jsp");
        request.setAttribute("cv", cv);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../View/layout.jsp");
        dispatcher.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu cv = (ChucVu) cvService.getObjByMa(ma);
        try {
            BeanUtils.populate(cv, request.getParameterMap());

        } catch (Exception e) {
            e.printStackTrace();
        }
        cvService.update(cv);
        response.sendRedirect("../chucvu/index");

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        ChucVu cv = (ChucVu) cvService.getObjByMa(ma);
        cvService.delete(cv);
        response.sendRedirect("../chucvu/index");

    }
}
