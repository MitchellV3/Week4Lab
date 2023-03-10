
package servlets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Mitchell
 */
public class NoteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String notePath = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        Note note = new Note(notePath);
        request.setAttribute("note", note);
        
        String edit = request.getParameter("edit");
        String view = request.getParameter("view");
        
        if (edit != (null)) {
          getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response);
        } else if (view != (null)){
          getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);         
        } else {
          getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String notePath = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        String title = request.getParameter("title");
        String body = request.getParameter("body");
        
        Note note = new Note(title, body);
        request.setAttribute("note", note);
        
        try ( 
                PrintWriter file = new PrintWriter(new BufferedWriter(new FileWriter(notePath, false)))) {
            file.println(title);
            file.println(body);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Controls the title and body of the note";
    }// </editor-fold>

}
