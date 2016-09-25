package com.fasm.jdbc.servlets;

import br.com.fasm.jdbc.dao.participante_eventoDAO;
import br.com.fasm.jdbc.modelo.participante_evento;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adicionaParticipante")
public class AdicionaParticipanteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        //cria um objeto da classe contato(POJO)
        participante_evento participante = new participante_evento();

        participante.setNome(request.getParameter("nome"));
        String dataEmTexto = request.getParameter("data_nascimento");
        Calendar dataNascimento = null;
        participante.setTelefone(request.getParameter("telefone"));
        participante.setEmail(request.getParameter("email"));
        participante.setInstituicao(request.getParameter("instituicao"));
        
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
        } catch (Exception e) {

        }
        participante.setData_nascimento(dataNascimento);
        
        participante_eventoDAO dao = new participante_eventoDAO();

        dao.adiciona(participante);

        try (PrintWriter out = response.getWriter()) {
            out.println(request.getParameter("nome") + "registrado meu nobre!");
        }

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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
