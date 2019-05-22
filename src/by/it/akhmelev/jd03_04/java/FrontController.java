package by.it.akhmelev.jd03_04.java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req,resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        try {
            Cmd cmd = Actions.defineCommand(req);
            Cmd next = cmd.execute(req);
            if (next==cmd || next==null){
                getServletContext().
                        getRequestDispatcher(cmd.getJsp()).
                        forward(req, resp);
            }
            else
            {
                resp.getWriter().print(next+" redirect");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
