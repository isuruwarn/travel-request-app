<html>
<head>
<title>Itinerary</title>
<link type="text/css" rel="stylesheet" href="css/stylesheet.css"/>
</head>


<script type="text/javascript">
	
	function mainPage() {
		document.mainForm.action = "/TravelRequestApp/";
		document.mainForm.submit();
	}
	
</script>


<body>
<form name=mainForm method=POST>

<br><br>

<table width=350 class=box align=center border=0 cellpadding=5 cellspacing=1 bgcolor=#DCDCDC>
	
	<tr bgcolor=#ADBECE><td colspan=3 class=heading>Itinerary</td></tr>
	
	<tr><td colspan=2><b>&nbsp;</b></td></tr>
	
	<tr>
		<td class="tableDataBold" width=45%>Number of Passengers:</td>
		<td align=left class="tableData">&nbsp;<%=request.getAttribute("NoOfPassengers")!=null?request.getAttribute("NoOfPassengers"):""%></td>
	</tr>
	
	<tr>
		<td class="tableDataBold">From:</td>
		<td align=left class="tableData">&nbsp;<%=request.getAttribute("Origin")!=null?request.getAttribute("Origin"):""%></td>
	</tr>
	
	<tr>
		<td class="tableDataBold">To:</td>
		<td align=left class="tableData">&nbsp;<%=request.getAttribute("Destination")!=null?request.getAttribute("Destination"):""%></td>
	</tr>
	
	<tr>
		<td class="tableDataBold">Departing:</td>
		<td align=left class="tableData">&nbsp;<%=request.getAttribute("Departing")!=null?request.getAttribute("Departing"):""%></td>
	</tr>
	
	<tr>
		<td class="tableDataBold">Returning:</td>
		<td align=left class="tableData">&nbsp;<%=request.getAttribute("Returning")!=null?request.getAttribute("Returning"):""%></td>
	</tr>
	
	<tr>
		<td colspan=2 align=center class=tableDataBold><input class=cmdButton type=button value=BACK onclick="mainPage()"></td>
	</tr>
	
</table>

<br><br>

<center><span class=tableData><font color=red><b><%=request.getAttribute("StatusMsg")!=null?request.getAttribute("StatusMsg"):""%></b></font></span></center>

</form>
</body>
</html>