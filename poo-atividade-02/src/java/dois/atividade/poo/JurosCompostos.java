/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dois.atividade.poo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.apache.el.lang.ELArithmetic.isNumber;

/**
 *
 * @author JANAINASILVADIAS
 * @author Ivan Felipe Miranda da Mota 24/03/2018
 */
@WebServlet(name = "JurosCompostos", urlPatterns = {"/juros-compostos.html"})
public class JurosCompostos extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
        out.println("<head>");
            out.println("<title>Juros Composto</title>");
       out.println("</head>");
            out.println("<body>");
            out.println("<div class='col-md-12'>");
            out.println("<center><h3>Juros Composto</h3></center>");
            out.println("<hr/>");
            out.println("<form>");
            out.println("Capital Aplicado: <input type='number' name='vrC'/>");
            out.println("<br/>");
            out.println("Taxa de Juros: <input type='number' step=',01' name='vrI'/>");
            out.println("<br/>");
            out.println("Tempo de Aplicação: <input type='number' name='vrN'/>");
            out.println("<br/>");
            out.println("<input type='submit' value='Calcular'/>");
            out.println("<hr/>");
            out.println("</form>");
            double vrC=0;
            double vrI=0;
            Integer vrN=0;
            try {
                vrC = Double.parseDouble(request.getParameter("vrC"));
                vrI = Double.parseDouble(request.getParameter("vrI"));
                vrN = Integer.parseInt(request.getParameter("vrN"));
            } catch (Exception e) {}
            out.println(retornarMontanteEJuros(vrC, (vrI/100), vrN));
            out.println("<br/>");
            out.println(gerarTabelaDeJuros(vrC, (vrI/100), vrN));
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public double calcularMontante(Double prC, Double prI, Integer prN){
        double vrM = prC*Math.pow((1 + prI),prN);
        return vrM;
    }
    
    public String retornarMontanteEJuros(Double prC, Double prI, Integer prN){
        String retorno;
        double vrM = calcularMontante(prC, prI, prN);
        double vrJ = vrM - prC;
        if (isNumber(vrM) && vrM != 0){
            retorno = "<p>Ao longo de " + prN + " meses à uma taxa de " + NumberFormat.getPercentInstance().format(prI) + ", o montante acumulado sobre o capital aplicado é " + NumberFormat.getCurrencyInstance().format(vrM) + ", gerando um juros de " + NumberFormat.getCurrencyInstance().format(vrJ) + ".</p>";
        }
        else{
            retorno = "";
        }
        return retorno;
    }
    
    public String gerarTabelaDeJuros(Double prC, Double prI, Integer prN){
        String retorno;
            retorno = "<table border='1'><tr><th>Mês</th><th>Montante Inicial</th><th>Juros</th><th>Montante Final</th></tr>";
            double vrC = prC;
            for(int i =1; i<=prN; i++){
                double vrM = calcularMontante(prC, prI, i);
                retorno += "<tr align='center'><td>"+i+"</td><td>"+NumberFormat.getCurrencyInstance().format(vrC)+"</td><td>"+NumberFormat.getCurrencyInstance().format(vrM-vrC)+"</td><td>"+NumberFormat.getCurrencyInstance().format(vrM)+"</td></tr>";
                vrC = vrM;
            }
            retorno += "</table";
            if(prC == 0){
                retorno = "";
            }
        return retorno;
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
