
import Beans.DataBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
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
    @EJB private DataBeanLocal db;
    ArrayList<BigDecimal> rcodes;
    String show;
    int showid;
    
    @Override
    public void init() throws ServletException {
        List S = db.getShowNames();
        getServletContext().setAttribute("Shownames",S); 
        List D = db.getShowDates();
        getServletContext().setAttribute("Showdates",D);         
        rcodes = new ArrayList<>();
        boolean[] Fullshows = new boolean[S.size()];
        for(int i = 0;i<Fullshows.length;i++){
            Fullshows[i] = db.testShowFull((String)S.get(i));
        }
        getServletContext().setAttribute("Fullshows",Fullshows); 
        List P = db.getPrijs((String)S.get(0));
        getServletContext().setAttribute("prijzen",P); 
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
                request.setAttribute("bestaatal","");
                gotoPage("registreer.jsp",request,response);
                break;
           case "voorstelling":
             show = request.getParameter("voorstelling");
             request.setAttribute("voorstelling", show);
             showid = db.getShowid(show);
             request.setAttribute("voorstellingid", showid);
             List<BigDecimal> P = (List<BigDecimal>) db.getOpenSeats(showid);
             request.setAttribute("seats", P);
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
                request.setAttribute("voorstelling", show);
                gotoPage("overzicht.jsp",request,response);
                break;
                
            case "tickets":                
                plaatsen = request.getParameterValues("besteld");
                for (String p : plaatsen) {
                    BigDecimal pid = new BigDecimal(Integer.parseInt(p));
                    BigDecimal rcode = db.addReservatie("null",pid,showid);
                    rcodes.add(rcode);                         
                }
                request.setAttribute("codes", rcodes);
                gotoPage("ticketoverzicht.jsp",request,response);
                break;
                
            case "verkoop":
                String email = request.getParameter("email");
                String naam = request.getParameter("naam");
                String pwd = request.getParameter("password");
                email = email.toLowerCase();
                if(db.getKlant(email)){
                    db.addKlant(email,naam,pwd);
                    gotoPage("verkoop.jsp",request,response);
                } 
                else {
                    request.setAttribute("bestaatal","Deze email is reeds geregistreerd. Probeer een ander of log in.");
                    gotoPage("registreer.jsp",request,response);
                 }
                
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

 