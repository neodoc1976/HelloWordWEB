package org.george;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Created by Yulya on 09.04.2016.
 */
public class Sum extends HttpServlet{
    private Walker runner=new Walker();
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {


              String move=request.getParameter ("move");

             if (move .equals("right")) {
                  runner.stepForward();

              }else if(move.equals("left")){
                 runner.stepBackward();

              }else if (move.equals("comeback")) {
                  runner.comeBack();

              }else if (move.equals("print")){






              }


    }
    public void printField(HttpServletResponse response) throws IOException {
        response.getWriter().println("<html>");
        int a=21;

       for (int i = 0; i < a; i++) {
           if (runner.getPosition() == i) {
              response.getWriter().print("*");
            } else {
               response.getWriter().print("|");
           }
       }
       response.getWriter().println();
        response.getWriter().println("<a href='/Hello2?move=right'> <br> right</a>");
    //    response.getWriter().println("<a href='/Hello2?move=left'> <br> left </a>");
    //    response.getWriter().println();
    //    response.getWriter().println("<a href='/Hello2?move=comeback'><br> comeback</a>");
    //    response.getWriter().println("<a href='/Hello2?move=comeback'><br> print</a>");
    //    response.getWriter().println("</html>");


    }
    private void printGorizontaLine(int length) {
        for (int c = 0; c < length; c++) {
            System.out.print("- ");
        }

    }

}
