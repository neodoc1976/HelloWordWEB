package org.george.labyrynth;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static org.george.labyrynth.Field.*;

/**
 * Created by Yulya on 17.04.2016.
 */
public class LabyrinthServlet extends HttpServlet {

    private Field field = new Field();



    {
        Cell[][] cells = {
                {new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R),new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R)},
                {new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(T), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R),new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R)},
                {new Cell(R), new Cell(R), new Cell(R), new Cell(W), new Cell(W), new Cell(W), new Cell(W), new Cell(W), new Cell(W), new Cell(W), new Cell(W), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R),new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R)},
                {new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R),new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R)},
                {new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R),new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R)},
                {new Cell(R), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(P), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(W), new Cell(W), new Cell(W), new Cell(W), new Cell(W), new Cell(R), new Cell(R),new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R)},
                {new Cell(W), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R),new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R)},
                {new Cell(W), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(T), new Cell(W), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(W), new Cell(M), new Cell(R),new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R)},
                {new Cell(W), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R),new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R)},
                {new Cell(W), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R),new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R)},
                {new Cell(W), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(T), new Cell(W), new Cell(R), new Cell(R),new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R)},
                {new Cell(R), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(W), new Cell(W), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R),new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R)},
                {new Cell(R), new Cell(R), new Cell(R), new Cell(W), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(W), new Cell(W), new Cell(R), new Cell(R), new Cell(R),new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R)},
                {new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(M), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(W), new Cell(W), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R),new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R)},
                {new Cell(T), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R),new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R), new Cell(R)},
        };
        field.setCells(cells);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        response.getWriter().println("<html> <body bgcolor=#c0c0c0>");

        String move = request.getParameter("move");

        PrintWriter out = response.getWriter();
        if (move != null) {
            switch (move) {
                case ("right"):
                    field.move(Walker.RIGHT, out);
                    break;
                case ("left"):
                    field.move(Walker.LEFT, out);
                    break;
                case ("up"):
                    field.move(Walker.UP, out);
                    break;
                case ("down"):
                    field.move(Walker.DOWN, out);
                    break;
                case ("turn right"):
                   field.turningPoint(Walker.RIGHT,out);
                    break;
                case ("turn left"):
                    field.turningPoint(Walker.LEFT,out);
                    break;
                case ("turn up"):
                    field.turningPoint(Walker.UP,out);
                    break;
                case ("turn down"):
                    field.turningPoint(Walker.DOWN,out);
                    break;





            }

        }



        field.printField(out);


        response.getWriter().print("<a href='/Robo?move=right'><button><big><strong>Step RIGHT</strong></big></button></a>");
        response.getWriter().print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
        response.getWriter().print("<a href='/Robo?move=left'><button><big><strong>Step LEFT</strong></big></button></a>");
        response.getWriter().print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
        response.getWriter().print("<a href='/Robo?move=up'><button><big><strong>Step UP</strong></big></button></a>");
        response.getWriter().print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
        response.getWriter().print("<a href='/Robo?move=down'><button><big><strong>Step DOWN</strong></big></button></a>");
        response.getWriter().println("<p><br>");
        response.getWriter().println("<a href='/Robo?move=turn right'><button><big><strong>Turn RIGHT</strong></big></button></a>");
        response.getWriter().print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
        response.getWriter().println("<a href='/Robo?move=turn left'><button><big><strong>Turn LEFT</strong></big></button></a>");
        response.getWriter().print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
        response.getWriter().println("<a href='/Robo?move=turn up'><button><big><strong>Turn UP</strong></big></button></a>");
        response.getWriter().print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp");
        response.getWriter().println("<a href='/Robo?move=turn down'><button><big><strong>Turn DOWN</strong></big></button></a>");
        response.getWriter().println("</html></body>");


    }


}

