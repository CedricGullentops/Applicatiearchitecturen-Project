/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack;

import Beans.DataBeanRemote;
import Java.Locaties;
import Java.Wagens;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
    HttpSession sessie;
    String van;
    int korting;
    
    @EJB private BoonLessRemote bl; 
    @EJB private BoonFullRemote bf;
    @EJB private DataBeanRemote db;
    
    public void init() throws ServletException {
        List L = db.getLocaties();
        List W = db.getWagens(); 
        getServletContext().setAttribute("locaties",L);
        getServletContext().setAttribute("wagens",W);
        korting = Integer.parseInt(getServletConfig().getInitParameter("korting"));
        getServletContext().setAttribute("korting",korting);
    }
    
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            van = request.getParameter("van");
            sessie = request.getSession(true);
            response.setContentType("text/html;charset=UTF-8");
            
            if(van.equals("index")){
                sessie.setAttribute("nr",Integer.parseInt(request.getParameter("nr")));
                gotoPage("reserveer.jsp",request,response);
            }
            else if(van.equals("klant")){                 
                String naam = request.getParameter("naam");
                String adres = request.getParameter("adres");
                int postcode = Integer.parseInt(request.getParameter("postcode"));
                String gemeente = request.getParameter("gemeente");
                sessie.setAttribute("nr",db.addKlant(postcode,naam,adres,gemeente));
                gotoPage("reserveer.jsp",request,response);
                
            }
            else if(van.equals("reserveer")){
                int duur = Integer.parseInt(request.getParameter("duur"));                    
                int prijs = bl.calcPrijs(15, duur, korting);
                bf.addTot(prijs);
                request.setAttribute("prijs",prijs);
                request.setAttribute("tprijs",bf.getTotprijs());
                request.setAttribute("taant",bf.getTotaant());
                
                int nr = Integer.parseInt(request.getParameter("nr"));
                String datumv = request.getParameter("datum");
                
                
                
                db.addReservatie(nr,duur,wnr,lnrv,lnrn,datumv);
                gotoPage("overzicht.jsp",request,response);
            }
            else if(van.equals("logout")){
                sessie.invalidate();
                gotoPage("afgemeld.jsp",request,response);
            }
            else if(van.equals("overzicht")){
                gotoPage("reserveer.jsp",request,response);
            }
        }
    protected void gotoPage (String link, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                RequestDispatcher view = request.getRequestDispatcher(link);
                view.forward(request, response);   
        
        }
    
    }

 