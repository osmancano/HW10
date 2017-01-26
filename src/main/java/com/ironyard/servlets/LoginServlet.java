package com.ironyard.servlets;

import com.ironyard.data.Agent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.activation.ActivationGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by osmanidris on 1/25/17.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        if (username != null) {
            ArrayList<Agent> agentList = Agent.loadPattern();
            request.getSession().setAttribute("agentList",agentList);
            request.getSession().setAttribute("user", username);
            Agent agent = findAgent(username.trim());
            request.getSession().setAttribute("agent", agent);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            request.setAttribute("error", "Unknown login, try again");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public Agent findAgent(String coverName){
        Agent agent = null;
        ArrayList<Agent> agentList = Agent.loadPattern();
        for(int i=0; i< agentList.size();i++){
            if(agentList.get(i).getCoverName().trim().equals(coverName)){
                agent = agentList.get(i);
                break;
            }
        }
        return agent;
    }
}
