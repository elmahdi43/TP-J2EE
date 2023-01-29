/*
  authors : Oukhamou El Mahdi, Benfarj Wassim
    date : 15-01-2023
 */

package imt.nordeurope.j2ee.tp.oukhamou.servlet;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;



@WebServlet(name = "GraphicPid", value = "/GraphicPid")
public class GraphicPIBServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

            response.setContentType("image/jpeg");
            ServletOutputStream out;
            out = response.getOutputStream();

            // Soyez sûr que le fichier existe dans le répertoire
            FileInputStream fin = new FileInputStream("C:\\Users\\Oukhm\\OneDrive\\Images\\Saved Pictures\\PIB-France.png");

            BufferedInputStream bin = new BufferedInputStream(fin);
            BufferedOutputStream bout = new BufferedOutputStream(out);
            int ch =0; ;
            while((ch=bin.read())!=-1)
            {
                bout.write(ch);
            }

            bin.close();
            fin.close();
            bout.close();
            out.close();





    }




}
