package kz.mun.m2.servlet;

import kz.mun.m2.db.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Main", value = "/main")
public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager.connectToDB();
        request.setAttribute("blogs", DBManager.getAllBlogs());
        request.getRequestDispatcher("/index.jsp").forward(request, response);

//        if (request.getParameter("search") != null) {
//            String keyWord = request.getParameter("keyWord");
//            request.setAttribute("blogs", DBManager.getBlogsByKeyWord(keyWord));
//        } else {
//            request.setAttribute("blogs", DBManager.getAllBlogs());
//        }
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String keyWord = request.getParameter("keyWord");
        request.setAttribute("blogs", DBManager.getBlogsByKeyWord(keyWord));
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
