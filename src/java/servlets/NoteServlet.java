

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

public class NoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

        String title = br.readLine();
        String content = "";

        String line = br.readLine();
        // Read each line and append it to content until EOF is reached.
        while (line != null) {
            content += line;
            line = br.readLine();
        }
        
        // Populate our note object with the data parsed.
        Note note = new Note(title, content);
        request.setAttribute("note", note);
        
        br.close();

        /*
         * Check and see whether the user has selected the option to edit the note.
         * If so, forward the proper URL.
         */
        String edit = request.getParameter("edit");
        if (edit != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        pw.println(title);
        pw.println(content);

        Note note = new Note(title, content);
        request.setAttribute("note", note);

        pw.close();

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}