package pack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class Servlet extends HttpServlet {
                
    HttpSession sessie;
    String van,naar;
    int actiecode;
    String[ ] plaatsen;
    //@EJB private DaBeanLocal db;
    
    @Override
    public void init() throws ServletException {
        //List S = db.getShows();
        //getServletContext().setAttribute("Shows",S);
        
    }
    
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            naar = request.getParameter("naar");
            sessie = request.getSession(true);
            response.setContentType("text/html;charset=UTF-8");
            
        switch (naar) {
           case "login":
                gotoPage("login.jsp",request,response);
                break;
           case "verkoop":
                gotoPage("verkoop.jsp",request,response);
                break;
           case "registreer":
                gotoPage("registreer.jsp",request,response);
                break;
           case "voorstelling":
               if(request.isUserInRole("Beheerders")){
                   gotoPage("voorstelling_beheerders.jsp",request,response);
                break;
               }  
               else{
                   gotoPage("voorstelling.jsp",request,response);
                   break;
               }
           default:
                break;
        }
    }        
       
        @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            naar = request.getParameter("naar");
            sessie = request.getSession(true);
            response.setContentType("text/html;charset=UTF-8");
            
        switch (naar) {
            
            case "overzicht":
                plaatsen = request.getParameterValues("plaatsid");
                request.setAttribute("plaatsen", plaatsen);
                gotoPage("overzicht.jsp",request,response);
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

 