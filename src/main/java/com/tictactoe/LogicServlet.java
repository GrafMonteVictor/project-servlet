package com.tictactoe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = getIndex(req);
        resp.sendRedirect("/index.jsp");
    }

    private int getIndex(HttpServletRequest req) {
        String indexStr = req.getParameter("click");
        boolean isDigit = indexStr.chars().allMatch(Character::isDigit);
        return isDigit ? Integer.parseInt(indexStr) : 0;
    }

}
