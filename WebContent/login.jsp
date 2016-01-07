<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.List"%>
<%@page import="location.master.dao.*"%>
<%@page import="location.master.services.*"%>
<%@page import="location.master.requetes.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Location Auto</title>

<!-- CSS -->
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" media="screen" href="style/css/ie6.css" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" type="text/css" media="screen" href="style/css/ie7.css" /><![endif]-->

<!-- JavaScripts-->
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/jNice.js"></script>
<script type="text/javascript">
<!--
function MM_jumpMenu(targ,selObj,restore){ //v3.0
  eval(targ+".location='"+selObj.options[selObj.selectedIndex].value+"'");
  if (restore) selObj.selectedIndex=0;
}
//-->
</script>
</head>

<body>
    <div align="left"><img src="style/img/transdmin-light.gif" height="40" style="margin-top:5%;margin-bottom:10px;margin-left:27%" />    </div>
<div id="wrapper">
						<%
							Authentification liste= new Authentification();		
						    String test=null;
						 %>

						 <%
							int i = 0;
							while (i < liste.utilisateurs(null,null,0).size()) {
							Utilisateur _util = new Utilisateur();
							_util = liste.utilisateurs(null,null,0).get(i);
							test=_util.getlogin();
							i++;
							}
						 %>      
						 <%
						 if(test==null)
						 {
						 %>
						 <%@include file="init_connect.jsp" %> 
<%
						 }
						 else
						 {
					     %>
					     <%@include file="authentif.jsp" %> 
<% 
						 }
						 %>
        
        <p id="footer">Mini projet : Dévlopement J2EE avec le modèle MVC 3 tièrs - Réalisé par Zakaria Rachid , Nacer Ben Soussi et Aoujil Mohamed<br />ENSAT de Tanger - Master Réseaux et Systèmes<a href="http://www.perspectived.com"></a></p>
</div>
    <!-- // #wrapper -->
</body>
</html>