<html>
<head>
<title>Travel Form</title>
<link type="text/css" rel="stylesheet" href="css/stylesheet.css"/>


<script type="text/javascript">
	
	function funSubmit() {
		
		var origin = document.mainForm.txtOrigin.value;
		var destination = document.mainForm.txtDestination.value;
		var departureMonth = document.mainForm.departureMM.value;
		var departureDate = document.mainForm.departureDD.value;
		var departureYear = document.mainForm.departureYY.value;
		var departureTime = document.mainForm.departureTime.value;
		var returnMonth = document.mainForm.returnMM.value;
		var returnDate = document.mainForm.returnDD.value;
		var returnYear = document.mainForm.returnYY.value;
		var returnTime = document.mainForm.returnTime.value;
		var noOfPassengers = document.mainForm.passengerCount.value;
		
		
		if(origin=='') {
			alert('Please enter a From location');
		}
		else if(destination=='') {
			alert('Please enter a To location');
		}
		else if(departureMonth=='select') {
			alert('Please select month of departure');
		}
		else if(departureDate=='select') {
			alert('Please select date of departure');
		}
		else if(departureYear=='select') {
			alert('Please select year of departure');
		}
		else if(returnMonth=='select') {
			alert('Please select month of return');
		}
		else if(returnDate=='select') {
			alert('Please select date of return');
		}
		else if(returnYear=='select') {
			alert('Please select year of return');
		}
		else {
			/*confirm('Number of Passengers: ' + noOfPassengers + '\n' +
					'From: ' + origin + '\n' +
					'To: ' + destination + '\n' +
					'Departing: ' + departureMonth + ' ' + departureDate + ' ' + departureYear + ' ' + departureTime + '\n' +
					'Returning: ' + returnMonth + ' ' + returnDate + ' ' + returnYear + ' ' + returnTime + '\n'
					);*/
			
			document.mainForm.action = "/TravelRequestApp/travel_request_main?mode=submit";
			document.mainForm.submit();
		}
		
	}
	

	function funRefresh() {
		document.mainForm.action = "/TravelRequestApp/";
		document.mainForm.submit();
	}
	
</script>

</head>


<body>

<form name=mainForm method=post>

<br><br>


<table width=570 class=box align=center border=0 cellpadding=5 cellspacing=1 bgcolor=#DCDCDC>
	
	<tr bgcolor=#ADBECE><td colspan=5 class=heading>Travel Form</td></tr>
	
	<tr><td colspan=5><b>&nbsp;</b></td></tr>
	
	<tr>
		<td class=tableDataBold>From</td>
		<td colspan=2 align=left><input class=tableData size=50 type=textbox value='<%=request.getAttribute("Origin")!=null?request.getAttribute("Origin"):""%>' name=txtOrigin id=txtOrigin></td>
	</tr>
	
	<tr>
		<td class=tableDataBold>To</td>
		<td colspan=2 align=left><input class=tableData size=50 type=textbox value='<%=request.getAttribute("Destination")!=null?request.getAttribute("Destination"):""%>' name=txtDestination id=txtDestination></td>
	</tr>
	
	<tr>
		<td class=tableDataBold>Departure Date</td>
		<td align=left width=50%>
			<select name=departureMM class=tableData>
				<option value="select">Seletct Month</option>
				<%
				if(request.getAttribute("NumOfMonthValues")!=null) {
					
					String month = "";
					String selected = "";
					int intMotnhs = ((Integer)request.getAttribute("NumOfMonthValues")).intValue();
					
					for(int i=0; i<intMotnhs; i++) {
						
						month = String.valueOf( request.getAttribute("MonthValue"+i) );
						selected = month.equals(request.getParameter("departureMM"))?"selected":"";
				%>
						<option value="<%=month%>" <%=selected%>><%=month%></option>
				<%
					}
				}
				%>
			</select>
			<select name=departureDD class=tableData>
				<option value="select">Seletct Date</option>
				<%
				if(request.getAttribute("NumOfDateValues")!=null) {
					
					String date = "";
					String selected = "";
					int intDates = ((Integer)request.getAttribute("NumOfDateValues")).intValue();
					
					for(int i=0; i<intDates; i++) {
						
						date = String.valueOf( request.getAttribute("DateValue"+i) );
						selected = date.equals(request.getParameter("departureDD"))?"selected":"";
				%>
						<option value="<%=date%>" <%=selected%>><%=date%></option>
				<%
					}
				}
				%>
			</select>
			<select name=departureYY class=tableData>
				<option value="select">Seletct Year</option>
				<%
				if(request.getAttribute("NumOfYearValues")!=null) {
					
					String year = "";
					String selected = "";
					int intYears = ((Integer)request.getAttribute("NumOfYearValues")).intValue();
					
					for(int i=0; i<intYears; i++) {
						
						year = String.valueOf( request.getAttribute("YearValue"+i) );
						selected = year.equals(request.getParameter("departureYY"))?"selected":"";
				%>
						<option value="<%=year%>" <%=selected%>><%=year%></option>
				<%
					}
				}
				%>
			</select>
		</td>
		<td>
			<select name=departureTime class=tableData>
			<%
			if(request.getAttribute("NumOfTimeValues")!=null) {
				
				String time = "";
				String selected = "";
				int intTimeValues = ((Integer)request.getAttribute("NumOfTimeValues")).intValue();
				
				for(int i=0; i<intTimeValues; i++) {
					
					time = String.valueOf( request.getAttribute("TimeValue"+i) );
					selected = time.equals(request.getParameter("departureTime"))?"selected":"";
			%>
					<option value="<%=time%>" <%=selected%>><%=time%></option>
			<%
				}
			}
			%>
			</select>
		</td>
	</tr>
	
	<tr>
		<td class=tableDataBold>Return Date</td>
		<td align=left>
			<select name=returnMM class=tableData>
				<option value="select">Seletct Month</option>
				<%
				if(request.getAttribute("NumOfMonthValues")!=null) {
					
					String month = "";
					String selected = "";
					int intMotnhs = ((Integer)request.getAttribute("NumOfMonthValues")).intValue();
					
					for(int i=0; i<intMotnhs; i++) {
						
						month = String.valueOf( request.getAttribute("MonthValue"+i) );
						selected = month.equals(request.getParameter("returnMM"))?"selected":"";
				%>
						<option value="<%=month%>" <%=selected%>><%=month%></option>
				<%
					}
				}
				%>
			</select>
			<select name=returnDD class=tableData>
				<option value="select">Seletct Date</option>
				<%
				if(request.getAttribute("NumOfDateValues")!=null) {
					
					String date = "";
					String selected = "";
					int intDates = ((Integer)request.getAttribute("NumOfDateValues")).intValue();
					
					for(int i=0; i<intDates; i++) {
						
						date = String.valueOf( request.getAttribute("DateValue"+i) );
						selected = date.equals(request.getParameter("returnDD"))?"selected":"";
				%>
						<option value="<%=date%>" <%=selected%>><%=date%></option>
				<%
					}
				}
				%>
			</select>
			<select name=returnYY class=tableData>
				<option value="select">Seletct Year</option>
				<%
				if(request.getAttribute("NumOfYearValues")!=null) {
					
					String year = "";
					String selected = "";
					int intYears = ((Integer)request.getAttribute("NumOfYearValues")).intValue();
					
					for(int i=0; i<intYears; i++) {
						
						year = String.valueOf( request.getAttribute("YearValue"+i) );
						selected = year.equals(request.getParameter("returnYY"))?"selected":"";
				%>
						<option value="<%=year%>" <%=selected%>><%=year%></option>
				<%
					}
				}
				%>
			</select>
		</td>
		<td>
			<select name=returnTime class=tableData>
			<%
			if(request.getAttribute("NumOfTimeValues")!=null) {
				
				String time = "";
				String selected = "";
				int intTimeValues = ((Integer)request.getAttribute("NumOfTimeValues")).intValue();
				
				for(int i=0; i<intTimeValues; i++) {
					
					time = String.valueOf( request.getAttribute("TimeValue"+i) );
					selected = time.equals(request.getParameter("returnTime"))?"selected":"";
			%>
					<option value="<%=time%>" <%=selected%>><%=time%></option>
			<%
				}
			}
			%>
			</select>
		</td>
	</tr>
	
	<tr>
		<td class=tableDataBold>Passengers</td>
		<td align=left>
			<select name=passengerCount class=tableData>
			<%
			if(request.getAttribute("NumOfPassengerValues")!=null) {
				
				String passengerValue = "";
				String selected = "";
				int intPassengers = ((Integer)request.getAttribute("NumOfPassengerValues")).intValue();
				
				for(int i=0; i<intPassengers; i++) {
					
					passengerValue = String.valueOf( request.getAttribute("PassengerValue"+i) );
					selected = passengerValue.equals(request.getParameter("passengerCount"))?"selected":"";
			%>
					<option value="<%=passengerValue%>" <%=selected%>><%=passengerValue%></option>
			<%
				}
			}
			%>
			</select>
		</td>
		<td>&nbsp;</td>
	</tr>
	
	<tr><td colspan=5><b>&nbsp;</b></td></tr>
	
	<tr>
		<td align=center colspan=4>
			<input class=cmdButton type=button value=SUBMIT  name=submitButton id=submitButton onclick=funSubmit()>
			<!--input class=cmdButton type=button value=CLEAR name=clear id=clear onclick=funClear()-->
			<input class=cmdButton type=button value=REFRESH name=refresh id=refresh onclick=funRefresh()>
		</td>
	</tr>
	
</table>

<br><br>

<center><span class=tableData><font color=red><b><%=request.getAttribute("StatusMsg")!=null?request.getAttribute("StatusMsg"):""%></b></font></span></center>

</form>
</body>
</html>