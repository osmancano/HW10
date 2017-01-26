<%@ page import="com.ironyard.data.Agent" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>TIY, HW10</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function(){
            $("table td a").click(function(e){
                e.preventDefault();
                $td= $(this).parents("tr").first().find("td:last");
                $td.children(0).removeClass("hideClass");
            });
        });
    </script>
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
            background-color: #805a41;
        }
        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 450px}
        /* Set black background color, white text and some padding */
        footer {
            background-color: #805a41;
            color: white;
            padding: 15px;
        }
        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height:auto;}
        }
        .hideClass{
            visibility: hidden;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp"><img src="imgs/TIY.png" style="width:40px;height:40px"></a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">

            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/logout">Welcome&nbsp;<span class="badge"><%=request.getSession().getAttribute("user")%></span>&nbsp;<span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-6 text-left">
            <br/>
            <%
                Agent agent = (Agent)request.getSession().getAttribute("agent");
                if(agent != null){%>
                <div class="alert alert-info">
                    <strong>Welcome <span class="label label-danger"><%=agent.getRealName()%></span> to our web page.</strong>
                </div>
            <%}else{%>
                <div class="alert alert-info">
                    <strong>Welcome <span class="label label-danger"><%=request.getSession().getAttribute("user")%></span>, you are not in NOC list</strong>
                </div>
            <%}%>
            <h4>NOC List:</h4>
            <table>
            <%
                ArrayList<Agent> agentList = (ArrayList<Agent>) request.getSession().getAttribute("agentList");
                if(agentList != null){
                    for(int i=0;i < agentList.size(); i++){%>
                    <tr>
                        <td><a href=""><%=agentList.get(i).getCoverName()%></a></td>
                        <td><span class="label label-default hideClass">Real name is:<%=agentList.get(i).getRealName()%></span></td>
                    </tr>
                <%}}%>
            </table>
        </div>
    </div>
</div>

<footer class="container-fluid text-center">
    <p> &copy; Copyright 2015-2017 - The Iron Yard</p>
</footer>

</body>
</html>