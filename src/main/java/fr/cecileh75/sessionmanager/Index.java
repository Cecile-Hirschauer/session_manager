package fr.cecileh75.sessionmanager;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "index", value = "/index")
public class Index extends HttpServlet {

    private String deactivate;
    private String message;


    @Override
    public void init() throws ServletException {
        message = "Activé";
        deactivate = "Désactiver";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (deactivate == "Activer" && message == "Désactivé") req.getRequestDispatcher("/Page2.jsp").forward(req, resp);
        req.getSession().setAttribute("message", message);
        req.getSession().setAttribute("deactivate", deactivate);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        deactivate = (deactivate == "Désactiver") ? "Activer" : "Désactiver";
        message = (message == "Désactivé") ? "Activé": "Désactivé";
        req.getSession().setAttribute("message", message);
        req.getSession().setAttribute("deactivate", deactivate);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}