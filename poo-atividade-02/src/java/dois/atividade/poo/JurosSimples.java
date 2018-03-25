/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dois.atividade.poo;


import java.io.IOException;
import java.io.PrintWriter;
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
 */
@WebServlet(name = "JurosSimples", urlPatterns = {"/juros-simples.html"})
public class JurosSimples extends HttpServlet {

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
            out.println("<title> Cálculo Juros Simples</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='col-md-12'>");
            out.println("<center><h3>Juros Simples</h3></center>");
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
           
            
            double varCap=0;
            double varI=0;
            Integer varN=0;
            
                   try {
                varCap = Double.parseDouble(request.getParameter("vrC"));
                varI = Double.parseDouble(request.getParameter("vrI"));
                varN = Integer.parseInt(request.getParameter("vrN"));
                   
                       } catch (NumberFormatException e) {}
            out.println(calcularMontante(varCap, (varI/100), varN));
            out.println("<br/>");
            out.println(TabelaDeJuros(varCap, (varI/100), varN));
            out.println("</body>");
            out.println("</html>");
        }
    }
                   
    
        
     public double calcularJuros(Double prCap, Double prI, Integer prN){
        double varJ = prCap*prI;
        varJ=varJ*prN;
        return varJ;
    }
     
     public String calcularMontante(Double prCap, Double prI, Integer prN){
         String retorno;
        double varJuros=calcularJuros(prCap,prI,prN);
        double varM = prCap*(1+prI*prN);
                if (isNumber(varJuros) && varJuros != 0){
            retorno = "<p>Ao longo de " + prN + " meses à uma taxa de " + NumberFormat.getPercentInstance().format(prI) + ", o montante acumulado sobre o capital aplicado é " + NumberFormat.getCurrencyInstance().format(varM) + ", gerando um juros de " + NumberFormat.getCurrencyInstance().format(varJuros) + ".</p>";
        }
        else{
            retorno = "";
        }
        return retorno;
    }
     
     public String TabelaDeJuros(Double prCap, Double prI, Integer prN){
        String retorno;
            retorno = "<table border='1'><tr><th>Mês</th><th>Montante Inicial</th><th>Juros</th><th>Montante Final</th></tr>";
            double varCap = prCap;
            for(int i =1; i<=prN; i++){
                double varM = calcularJuros(prCap, prI, i);
                double varFinal = varM+varCap;
                retorno += "<tr align='center'><td>"+i+"</td><td>"+NumberFormat.getCurrencyInstance().format(varCap)+"</td><td>"+NumberFormat.getCurrencyInstance().format(varM)+"</td><td>"+NumberFormat.getCurrencyInstance().format(varFinal)+"</td></tr>";
                
            }
            retorno += "</table";
            if(prCap == 0){
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
