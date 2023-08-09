<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
		<%@ taglib uri='http://java.sun.com/jsp/jstl/sql' prefix='sql'%>
		<TITLE>Welcome To The World Of JSP Standard Tag Library</TITLE>
		<SCRIPT LANGUAGE='JavaScript'>
			function setMode()
			{
				document.frmAuth.txtName.value = '';
				document.frmAuth.txtDegree.value = '';
				document.frmAuth.txtSpecialization.value = '';
				document.frmAuth.txtBirthdate.value = '';
			}

			function setDelMode() 
			{
				document.frmAuth.hidMode.value = 'D';
				formDeleteValues('hidSelDel');
			}

			function formDeleteValues(hidden)
			{
				var selValues = '';
				for (i=0;i<document.forms[0].elements.length;i++)
				{
					if(document.forms[0].elements[i].type == "checkbox")
					{
						if (document.forms[0].elements[i].checked == true)
						{
							selValues = selValues + document.forms[0].elements[i].value + ",";
						}
					}
				}
				if (selValues.length < 1)
				{
					alert("Please choose records you wish to delete.");
				}
				else
				{
					selValues = selValues.substring(0,selValues.length-1);
					eval("document.forms[0]." + hidden + ".value = '" + selValues + "';");
					document.forms[0].submit();
				}
			}

			function setEditMode(AuthorID, Name, Degree, Specialization, Birthdate)
			{
				document.frmAuth.hidAuthorID.value = AuthorID;
				document.frmAuth.txtName.value = Name;
				document.frmAuth.txtDegree.value = Degree;
				document.frmAuth.txtSpecialization.value = Specialization;
				document.frmAuth.txtBirthdate.value = Birthdate;
				document.frmAuth.hidMode.value = 'U';
			}
		</SCRIPT>
	</HEAD>
	<BODY BGCOLOR='pink'>
	<%-- Setting the data source for the JSP page --%>
	<%--	<sql:setDataSource url='jdbc:mysql://localhost/test' driver='com.mysql.jdbc.Driver' user='root' password='ompandey'/> --%>
<sql:setDataSource dataSource="jdbc/test"/>

		<c:if test='${param.hidMode == "D"}'>
			<c:forEach var="item" items='${param.hidSelDel}'>
				<sql:update var='query'>
					DELETE FROM AuthorMaster WHERE AuthorID IN (${item})
				</sql:update>
			</c:forEach>
					</c:if>

		<c:if test='${param.hidMode == "U"}'>
			<sql:update var='query'>
				UPDATE AuthorMaster SET Name = ?, Degree = ?, Specialization = ?, Birthdate = ? WHERE AuthorID = ?
				<sql:param value='${param.txtName}'/>
				<sql:param value='${param.txtDegree}'/>
				<sql:param value='${param.txtSpecialization}'/>
				<sql:param value='${param.txtBirthdate}'/>
				<sql:param value='${param.hidAuthorID}'/>
			</sql:update>
		<%--	<c:redirect url='${param.page}'/> --%>
		</c:if>

		<c:if test='${param.hidMode == "I"}'>
			<sql:update var='query'>
				INSERT INTO AuthorMaster (Name, Degree, Specialization, BirthDate) VALUES (?,?,?,?)
				<sql:param value='${param.txtName}'/>
				<sql:param value='${param.txtDegree}'/>
				<sql:param value='${param.txtSpecialization}'/>
				<sql:param value='${param.txtBirthdate}'/>
			</sql:update>
		<%-- <c:redirect url='${param.page}'/> --%>
		</c:if>

		<FORM ACTION='AuthorMaster.jsp' METHOD='post' NAME='frmAuth'>
			<INPUT NAME='hidMode' TYPE='hidden' VALUE='I'>
			<INPUT NAME='hidSelDel' TYPE='hidden'>
			<INPUT NAME='hidAuthorID' TYPE='hidden'>
			<TABLE ALIGN='center' BGCOLOR='pink' CELLPADDING='0' CELLSPACING='0' NAME='tblouter' WIDTH='50%'>
				<TR HEIGHT='200' VALIGN='top'>
					<TD ALIGN='center' COLSPAN='10'>
						<TABLE ALIGN='center' BGCOLOR='pink' BORDER='1' BORDERCOLOR='maroon' CELLPADDING='2' CELLSPACING='0' NAME='tblFirstChild' WIDTH='100%'>
							<TR>
								<TD ALIGN='left' COLSPAN='2' BGCOLOR='maroon'>
									<FONT COLOR='pink'>Author Master</FONT>
								</TD>
							</TR>
							<TR>
								<TD ALIGN='right' WIDTH='25%'>Author Name</TD>
								<TD ALIGN='left'>
									<INPUT MAXLENGTH='35' NAME='txtName' TYPE='text' SIZE='25'>
								</TD>
							</TR>
							<TR>
								<TD ALIGN='right' WIDTH='25%'>Degree</TD>
								<TD ALIGN='left'>
									<INPUT MAXLENGTH='255' NAME='txtDegree' TYPE='text' SIZE='42'>
								</TD>
							</TR>
							<TR>
								<TD ALIGN='right' WIDTH='25%'>Speciality</TD>
								<TD ALIGN='left'>
									<INPUT MAXLENGTH='255' NAME='txtSpecialization' TYPE='text' SIZE='42'>
								</TD>
							</TR>
							<TR>
								<TD ALIGN='right' WIDTH='25%'>Date Of Birth</TD>
								<TD ALIGN='left'>
									<INPUT MAXLENGTH='255' NAME='txtBirthdate' TYPE='text' SIZE='20'>
								</TD>
							</TR>
							<TR>
								<TD COLSPAN='2' ALIGN='right'>
									<INPUT NAME='cmdSubmit' TYPE='submit' VALUE='Save'>
									<INPUT NAME='cmdCancel' onclick='setMode();' TYPE='button' VALUE='Cancel'>
								</TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>

			<sql:query var='query'>
				SELECT * FROM AuthorMaster
			</sql:query>
                        <br>
			<TABLE ALIGN='center' BORDER='1' WIDTH='50%' BORDERCOLOR='skyblue' CELLPADDING='0' CELLSPACING='0' NAME='tblSecondChild'>
				<TR BGCOLOR='black'>
					<TD WIDTH='12%' ALIGN='center'><INPUT NAME='cmdDelete' TYPE='button' VALUE='Delete' onClick='setDelMode();'></TD>
					<TD><FONT COLOR='#FFFFFF'>Author Name</FONT></TD>
					<TD><FONT COLOR='#FFFFFF'>Degree</FONT></TD>
					<TD><FONT COLOR='#FFFFFF'>Specialization</FONT></TD>
					<TD><FONT COLOR='#FFFFFF'>Date Of Birth</FONT></TD>
				</TR>

				<c:if test='${query.rowCount >0}'>
					<c:forEach var='row' items='${query.rowsByIndex}'>
						<TR>
							<TD>
								<INPUT TYPE='checkbox' NAME='chk<c:out value="${row[0]}"/>' VALUE='<c:out value="${row[0]}"/>'>
							</TD>
							<TD STYLE="cursor:pointer" onMouseDown="setEditMode('<c:out value="${row[0]}"/>', '<c:out value="${row[1]}"/>', '<c:out value="${row[2]}"/>', '<c:out value="${row[3]}"/>', '<c:out value="${row[4]}"/>');">
								<c:out value='${row[1]}'/>
							</TD>
							<TD STYLE="cursor:pointer" onMouseDown="setEditMode('<c:out value="${row[0]}"/>', '<c:out value="${row[1]}"/>', '<c:out value="${row[2]}"/>', '<c:out value="${row[3]}"/>', '<c:out value="${row[4]}"/>');">
								<c:out value='${row[2]}'/>
							</TD>
							<TD STYLE="cursor:pointer" onMouseDown="setEditMode('<c:out value="${row[0]}"/>', '<c:out value="${row[1]}"/>', '<c:out value="${row[2]}"/>', '<c:out value="${row[3]}"/>', '<c:out value="${row[4]}"/>');">
								<c:out value='${row[3]}'/>
							</TD>
							<TD STYLE="cursor:pointer" onMouseDown="setEditMode('<c:out value="${row[0]}"/>', '<c:out value="${row[1]}"/>', '<c:out value="${row[2]}"/>', '<c:out value="${row[3]}"/>', '<c:out value="${row[4]}"/>');">
								<c:out value='${row[4]}'/>
							</TD>
						</TR>
					</c:forEach>
				</c:if>
			</TABLE>
		</FORM>
	</BODY>
</HTML>