package com.practicalexercises.exercise1.servlets;

import com.practicalexercises.exercise1.logic.Controller;
import com.practicalexercises.exercise1.logic.Party;
import com.practicalexercises.exercise1.logic.VoteStudent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "SvVote", urlPatterns = {"/SvVote"})
public class SvVote extends HttpServlet {

    Controller controller = new Controller();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<VoteStudent> votes = new ArrayList<>();
        List<String> partyNames = new ArrayList<>(Arrays.asList("Party A", "Party B", "Party C"));
        for (String partyName : partyNames) {
            if(controller.searchByName(partyName) == null){
                controller.createParty(partyName,votes);
            }
        }
        List<VoteStudent> votesList = controller.bringVotes();
        List<Party> partiesList = controller.bringParties();
        
        partiesList.sort((party1, party2) -> party1.getPartyName().compareToIgnoreCase(party2.getPartyName()));
        Map<String,Integer> totalVotes = new LinkedHashMap<>();
        partyNames.forEach(party -> totalVotes.put(party, 0));
        
        for (VoteStudent vote : votesList) {
            for (Party party : partiesList) {
                if(vote.getParty().getPartyName().equalsIgnoreCase(party.getPartyName())){
                    int nVotes = totalVotes.get(party.getPartyName()) + 1;                    
                    totalVotes.put(party.getPartyName(), nVotes);
                }
            }
        }
        System.out.println(totalVotes);
        
        HttpSession mySession = request.getSession();
        mySession.setAttribute("votesList", totalVotes);

        System.out.println("----------------------------------------");
//        System.out.println("get votes list");
//        System.out.println(votesList);
//        for (Party party : partiesList) {
//            System.out.println(party + " vote:" +party.getVotes());
//        }
//          for (VoteStudent vote : votesList) {
//              System.out.println("-----------------------------");
//              System.out.println(vote + " party:" + vote.getParty());
//        }
        
        response.sendRedirect("displayParties.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String selectedParty = request.getParameter("parties");

        Party partyName = controller.searchByName(selectedParty);
        List<VoteStudent> votes = new ArrayList<>();
        if (partyName == null) {
            controller.createParty(selectedParty, votes);
            partyName = controller.searchByName(selectedParty);
        }

        controller.createVote(partyName);

        response.sendRedirect("index.jsp");

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
