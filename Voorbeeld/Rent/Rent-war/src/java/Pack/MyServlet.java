/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack;

import Beans.*;
import Java.Locaties;
import Java.Wagens;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author student
 */
public class MyServlet extends HttpServlet {
    Wagens W;
    Locaties L;
    HttpSession sessie;
    String van;
    int actiecode;
    @EJB 
    private BoonLessRemote bl; 
    private BoonFullRemote bf;
    
    public void init() throws ServletException {
        W = new Wagens();
        L = new Locaties(); 
        getServletContext().setAttribute("wagens",W.getWag());
        getServletContext().setAttribute("locaties",L.getLoc());
        actiecode = 0;
    }
    
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            van = request.getParameter("van");
            sessie = request.getSession(true);
            response.setContentType("text/html;charset=UTF-8");
            
        switch (van) {
            case "index":
                sessie.setAttribute("nr",Integer.parseInt(request.getParameter("nr")));
                gotoPage("reserveer.jsp",request,response);
                break;
            case "klant":
                gotoPage("reserveer.jsp",request,response);                
                sessie.setAttribute("nr",172);
                break;
            case "reserveer":
                int duur = Integer.parseInt(request.getParameter("duur"));                    
                int prijs = bl.calcPrijs(15, duur, actiecode);
                bf.addTot(prijs);
                request.setAttribute("prijs",prijs);
                request.setAttribute("tprijs",bf.getTotprijs());
                request.setAttribute("taant",bf.getTotaant());
                gotoPage("overzicht.jsp",request,response);
                break;
            case "logout":
                sessie.invalidate();
                gotoPage("afgemeld.jsp",request,response);
                break;
            case "overzicht":
                gotoPage("reserveer.jsp",request,response);
                break;
            default:
                break;
        }
        }
    protected void gotoPage (String link, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                RequestDispatcher view = request.getRequestDispatcher(link);
                view.forward(request, response);   
        
        }
    
    }

 