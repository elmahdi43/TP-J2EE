/*
  authors : Oukhamou El Mahdi, Benfarj Wassim
    date : 15-01-2023
 */

package imt.nordeurope.j2ee.tp.oukhamou.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


import java.util.Map;
import java.util.Objects;

@WebServlet(name = "SimplePid", value = "/SimplePid")
public class SimplePIBServlet extends HttpServlet
{
    private String message;
    private Map<String,Integer> paysPID;
    private String selected;

    public void init() {
        message = "Salut, voici le PID de votre pays (milliards d'euros): ";
        paysPID = Map.of("France", 29000, "Allemagne", 30000, "Belgique", 28000, "Espagne", 28000, "Italie", 28000);
        selected = "Sélectionnez un pays!!";
    }



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String parameter = request.getParameter("pays");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<center>");
        out.println("<h1>" + message + " " + parameter + "</h1>");

        out.println("<form action=\"SimplePid\" method=\"post\">\n");
        out.println("<select name=\"pays\">\n");
        for (Map.Entry<String, Integer> pair : paysPID.entrySet()) {
            if (Objects.equals(selected, pair.getKey())) {
                out.println("  <option value=\"" + pair.getValue() + "\" selected>" + pair.getKey() + "</option>\n");
            } else {
                out.println("  <option value=\"" + pair.getValue() + "\">" + pair.getKey() + "</option>\n");
            }
        }
        out.println("</select>");
        out.println("    <button type=\"submit\">Afficher et rafraîchir</button>");
        out.println("</form>");
        // L'affichage du l'image du GraphicPid servlet
        out.println("<img src=\"GraphicPid\" alt=\"PIB\" width=\"700\" height=\"495\">");
        out.println("</center>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        selected = req.getParameter("pays");
        doGet(req, resp);
    }
    public void destroy() {

    }
}
