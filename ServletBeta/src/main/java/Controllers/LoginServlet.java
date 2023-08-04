package Controllers;

import Entity.NguoiDung;
import Reposetories.Impl.NguoiDungReposetory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login/index")
public class LoginServlet extends HttpServlet {
    NguoiDungReposetory ndRepo;

    public LoginServlet() {
        ndRepo = new NguoiDungReposetory();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "../View/login.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("../View/layout.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String matKhau = request.getParameter("matKhau");
        NguoiDung nd = ndRepo.getNguoiDungLogin(ma, matKhau);

        HttpSession session = request.getSession();
        if (nd == null) {
            session.setAttribute("errorMessage", "Sai tài khoản hoặc mật khẩu");
            response.sendRedirect("../login/index");
        } else {
            session.setAttribute("nd", nd);
            response.sendRedirect("../nguoidung/index");
        }
    }
}
