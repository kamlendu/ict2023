<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
		<%@ taglib uri='http://java.sun.com/jsp/jstl/sql' prefix='sql'%>
		<TITLE>Welcome To The World Of JSP Standard Tag Library</TITLE>
		<SCRIPT LANGUAGE='JavaScript'>
			function setMode()
			{
				document.frmBook.txtBookName.value = '';
				document.frmBook.txtSynopsis.value = '';
				document.frmBook.txtAuthorName.value = '';
				document.frmBook.txtPublisherName.value = '';
			}

			function setDelMode()
			{
				document.frmBook.hidMode.value='D';
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

			function setEditMode(BookID, BookName, Synopsis, AuthorName, PublisherName)
			{
				document.frmBook.hidBookID.value = BookID;
				document.frmBook.txtBookName.value = BookName;
				document.frmBook.txtSynopsis.value = Synopsis;
				document.frmBook.txtAuthorName.value = AuthorName;
				document.frmBook.txtPublisherName.value = PublisherName;
				document.frmBook.hidMode.value = 'U';
			}
		</SCRIPT>
		<TITLE>Welcome To The World Of JSP Standard Tag Library</TITLE>
	</HEAD>
	<BODY BGCOLOR='pink'>
	
<sql:setDataSource dataSource="jdbc/mysql"/>

		<c:if test='${param.hidMode == "D"}'>
			<c:forEach var="item" items='${param.hidSelDel}'>
		
                        <sql:update var='query'>
					DELETE FROM BookMaster WHERE BookID = ?
			<sql:param value='${item}'/>
                        </sql:update>
			</c:forEach>
			<c:redirect url='BooksMaster.jsp' />
		</c:if>

		<c:if test='${param.hidMode == "U"}'>
			<sql:update var='query'>
				UPDATE BookMaster SET BookName = ?, Synopsis = ?, AuthorName = ?, PublisherName = ? WHERE BookID = ?
				<sql:param value='${param.txtBookName}'/>
				<sql:param value='${param.txtSynopsis}'/>
				<sql:param value='${param.txtAuthorName}'/>
				<sql:param value='${param.txtPublisherName}'/>
				<sql:param value='${param.hidBookID}'/>
			</sql:update>
			<c:redirect url='BooksMaster.jsp' />
		</c:if>

		<c:if test='${param.hidMode == "I"}'>
			<sql:update var='query'>
				INSERT INTO BookMaster (BookName, Synopsis, AuthorName, PublisherName) VALUES (?,?,?,?)
				<sql:param value='${param.txtBookName}'/>
				<sql:param value='${param.txtSynopsis}'/>
				<sql:param value='${param.txtAuthorName}'/>
				<sql:param value='${param.txtPublisherName}'/>
			</sql:update>
			<c:redirect url='BooksMaster.jsp' />
		</c:if>

		<FORM ACTION='BooksMaster.jsp' METHOD='post' NAME='frmBook'>
			<INPUT NAME='hidMode' TYPE='hidden' VALUE='I'>
			<INPUT NAME='hidSelDel' TYPE='hidden'>
			<INPUT NAME='hidBookID' TYPE='hidden'>
			<TABLE ALIGN='center' BGCOLOR='pink' BORDER='0' CELLPADDING='0' CELLSPACING='0' NAME='tblouter' WIDTH='50%'>
				<TR HEIGHT='200' VALIGN='top'>
					<TD ALIGN='center' COLSPAN='10'>
						<TABLE ALIGN='center' BGCOLOR='pink' BORDER='1' BORDERCOLOR='maroon' CELLPADDING='2' CELLSPACING='0' NAME='tblFirstChild' WIDTH='100%'>
							<TR>
								<TD ALIGN='left' COLSPAN='2' BGCOLOR='maroon'>
									<FONT COLOR='pink'>Book Master</FONT>
								</TD>
							</TR>
							<TR>
								<TD ALIGN='right' WIDTH='25%'>Book Name</TD>
								<TD ALIGN='left'>
									<INPUT MAXLENGTH='35' NAME='txtBookName' TYPE='text' SIZE='25'>
								</TD>
							</TR>
							<TR>
								<TD ALIGN='right' WIDTH='25%'>Synopsis</TD>
								<TD ALIGN='left'>
									<INPUT MAXLENGTH='255' NAME='txtSynopsis' TYPE='text' SIZE='42'>
								</TD>
							</TR>
							<TR>
								<TD ALIGN='right' WIDTH='25%'>Author Name</TD>
								<TD ALIGN='left'>
									<INPUT MAXLENGTH='255' NAME='txtAuthorName' TYPE='text' SIZE='42'>
								</TD>
							</TR>
							<TR>
								<TD ALIGN='right' WIDTH='25%'>Publisher Name</TD>
								<TD ALIGN='left'>
									<INPUT MAXLENGTH='255' NAME='txtPublisherName' TYPE='text' SIZE='20'>
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
				SELECT * FROM BookMaster
			</sql:query>
			<TABLE ALIGN='center' BORDER='1' BORDERCOLOR='skyblue' CELLPADDING='0' CELLSPACING='0' WIDTH='50%' NAME='tblSecondChild'>
				<TR BGCOLOR='black'>
					<TD WIDTH='12%' ALIGN='center'><INPUT NAME='cmdDelete' TYPE='button' VALUE='Delete' onClick='setDelMode();'></TD>
					<TD><FONT COLOR='#FFFFFF'>Book Name</FONT></TD>
					<TD><FONT COLOR='#FFFFFF'>Synopsis</FONT></TD>
					<TD><FONT COLOR='#FFFFFF'>Author Name</FONT></TD>
					<TD><FONT COLOR='#FFFFFF'>Publisher Name</FONT></TD>
				</TR>

				<c:if test='${query.rowCount >0}'>
					<c:forEach var='row' items='${query.rowsByIndex}'>
						<TR>
							<TD>
								<INPUT TYPE='checkbox' NAME='chk<c:out value="${row[4]}"/>' VALUE='<c:out value="${row[4]}"/>'>
							</TD>
							<TD STYLE="cursor:pointer" onMouseDown="setEditMode('<c:out value="${row[4]}"/>', '<c:out value="${row[0]}"/>', '<c:out value="${row[3]}"/>', '<c:out value="${row[1]}"/>', '<c:out value="${row[2]}"/>');">
								<c:out value="${row[0]}"/>
							</TD>
							<TD STYLE="cursor:pointer" onMouseDown="setEditMode('<c:out value="${row[4]}"/>', '<c:out value="${row[0]}"/>', '<c:out value="${row[3]}"/>', '<c:out value="${row[1]}"/>', '<c:out value="${row[2]}"/>');">
								<c:out value="${row[3]}"/>
							</TD>
							<TD STYLE="cursor:pointer" onMouseDown="setEditMode('<c:out value="${row[4]}"/>', '<c:out value="${row[0]}"/>', '<c:out value="${row[3]}"/>', '<c:out value="${row[1]}"/>', '<c:out value="${row[2]}"/>');">
								<c:out value="${row[1]}"/>
							</TD>
							<TD STYLE="cursor:pointer" onMouseDown="setEditMode('<c:out value="${row[4]}"/>', '<c:out value="${row[0]}"/>', '<c:out value="${row[3]}"/>', '<c:out value="${row[1]}"/>', '<c:out value="${row[2]}"/>');">
								<c:out value="${row[2]}"/>
							</TD>
						</TR>
					</c:forEach>
				</c:if>
			</TABLE>
		</FORM>
                <c:out value="${param.hidSelDel}" />
       <c:out value="${param.hidMode}" />
        </BODY>
</HTML>