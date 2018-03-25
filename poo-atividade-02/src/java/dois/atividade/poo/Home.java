/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dois.atividade.poo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JANAINASILVADIAS
 */
@WebServlet(name = "Home", urlPatterns = {"/home.html"})
public class Home extends HttpServlet {

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
       
out.println("<!DOCTYPE html>");
out.println("<html>");
    out.println("<head>");
        out.println("<title>Perfil</title>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        //<!-- scripts -->
        out.println("<script src='js/jquery.min.js'></script>");
        out.println("<script src='js/bootstrap.min.js'></script>");
        out.println("<script src='js/scripts.js'></script>");
        
        out.println("<style>#final{color: black; font-size:12px}</style>");

        //<!-- CSS -->
        out.println("<link href='src/css/bootstrap.css' rel='stylesheet'>");
        
       out.println("</head>");
       out.println("<body>");
   
       out.println("<div class='container-fluid'>");
            out.println("<div class='row'>");
            out.println("<div class='col-md-12'>");
              out.println("<center><h3>Perfil da Equipe</h3></center>");
              out.println("<hr/>");
                out.println("<section>");
                  out.println("<div class='row'>");
                         	out.println("<div class='col-sm-4 col-md-3'>");
                                  out.println("<div class='thumbnail' style='background: # CCC'>");
                                      out.println("<img src='src/images/download.jpg' alt='...' class='img-circle' width='242' height='200'> "); 
                                          out.println("<div class='caption'>");
                                            out.println("<h3 style='color: #006666' align='center'>Ivan Mota</h3>");
                                                  out.println("<p align='center'><b>Github: </b><a href='https://github.com/iFelipeMota' target='_blank'>@iFelipeMota</p></a>");
                                            out.println("</div>");
                                 out.println("</div>");
                        	 out.println("</div>");
                             
                         	out.println("<div class='col-sm-4 col-md-3'>");
                                  	out.println("<div class='thumbnail' style='background:  # CCC'>");
                                      out.println("<img src='src/images/download (1).jpg' alt='...' class='img-circle' width='242' height='200'> ");           
                                          out.println("<div class='caption'>");
                                            out.println("<h3 style='color: #006666' align='center'>Janaina Dias</h3>");
                                                   out.println("<p align='center'><b>Github: </b><a href='https://github.com/janainadias95' target='_blank'>@janainadias95</p></a>");
                                          out.println("</div> ");
                           			out.println("</div>");
                             out.println("</div>");
                             
                          	out.println("<div class='col-sm-4 col-md-3'>");
                                  out.println("<div class='thumbnail' style='background:  # CCC'>");
                                     out.println("<img src='src/images/download.jpg'  alt='...' class='img-circle' width='242' height='200'>");  
                                          out.println("<div class='caption'>");
                                            out.println("<h3 style='color: #006666' align='center'>Joao Soler</h3>");
                                                  out.println("<p align='center'><b>Github: </b><a href='https://github.com/JoaoPauloSoler' target='_blank'>@JoaoPauloSoler</p></a>");
                                          out.println("</div>  ");
                                 out.println("</div>");
                         	out.println("</div>");
                            
                         	out.println("<div class='col-sm-4 col-md-3'>");
                                  out.println("<div class='thumbnail' style='background:  # CCC'>");
                                     out.println("<img src='src/images/download.jpg'  alt='...' class='img-circle' width='242' height='200'>");  
                                          out.println("<div class='caption'>");
                                            out.println("<h3 style='color: #006666' align='center'>Lucas Santana</h3>");
                                                  out.println("<p align='center'><b>Github: </b><a href='https://github.com/lsantanatec' target='_blank'>@lsantanatec</p></a>");
                                          out.println("</div>  ");
                                 out.println("</div>");
                         	out.println("</div>");
              	out.println("</div>    ");
                out.println("</section> ");
                out.println("<hr/> ");
                out.println("<center>");
                out.println("<h3>Aplicação</h3>");
          		
                out.println("<a href='juros-simples.html' target='_blank'>");
                out.println("<b>Cálculo de Juros Simples</b></a>");
                out.println("<p> Juros simples é um acréscimo calculado sobre o valor inicial de um aplicação financeira ou de uma compra feita a crédito, por exemplo. <br/> O valor inicial de uma dívida, empréstimo ou investimento é chamado de <b>capital</b>. A esse valor é aplicada uma correção, chamada de <b>taxa de juros</b>, que  é expressa em porcentagem. Os juros são calculados considerando o período de <b>tempo</b>  em que o capital ficou aplicado ou emprestado.<br/></p>");
                out.println(" <br/>");
                out.println("<a href='juros-compostos.html' target='_blank'>");
                out.println("<b>Cálculo de Juros Compostos</b></a>");
                out.println("<p> Os Juros Compostos são calculados levando em conta a atualização do capital, ou seja, o juro incide não apenas no valor inicial, mas também sobre  os juros acumulados (juros sobre juros). <br/>Esse tipo de juros, chamado também de “capitalização acumulada”, é muito utilizado nas transações comerciais e financeiras (sejam dívidas, empréstimos ou investimentos). </p>");
			out.println("<hr/>");
             out.println(" </center>");
         out.println(" </div>");
	out.println("</div>");
        out.println("</div>");
out.println("</body>");
out.println("<footer>");
    out.println("<center>");
    out.println("<p id= 'final'> Criado por Equipe X.</p>");
    out.println("</center>");
out.println("</footer>");

out.println("</html>");

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
