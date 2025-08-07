package com.tictactoe;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //создаем сессию
        HttpSession session = req.getSession();
        //инит поле, знач. клеток поля
        Field field = new Field();
//        Map<Integer, Sign> fieldData = field.getField();
        List<Sign> data = field.getFieldData();
        //передаем в сессию
        session.setAttribute("field", field);
        session.setAttribute("data", data);
        //форвардим
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
