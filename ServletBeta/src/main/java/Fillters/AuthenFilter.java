package Fillters;

import Entity.NguoiDung;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "ApplicationFilter", value = {
        "/nguoidung/*"
})
public class AuthenFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        NguoiDung nd = (NguoiDung) session.getAttribute("nd");

        if (nd == null) {
            res.sendRedirect("../login/index");
        } else {
            chain.doFilter(req, res);
        }
    }
}
