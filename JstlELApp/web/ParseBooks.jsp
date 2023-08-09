<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
	<HEAD>
		<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
		<%@ taglib uri='http://java.sun.com/jsp/jstl/xml' prefix='x'%>
		<TITLE>Welcome To The World Of JSP Standard Tag Library</TITLE>
	</HEAD>
	<BODY BGCOLOR='pink'>
	<%-- Importing the book.xml file --%>
		<c:import var='bookxml' url='/book.xml'/>
	<%-- Parsing the book.xml file --%>
		<x:parse var='document' doc='${bookxml}'/>
		There are <x:out select='count($document//bookname)'/> books in the book.xml file.
		<HR/>
	<%-- For each author in the book.xml file --%>
        <x:out select="$document//details/publishername"/><br/>
		<x:forEach select='$document//details'>
			<TABLE border = "1">
				<TR>
					<TD>Book Name:</TD>
					<TD><x:out select='bookname'/></TD>
				</TR>
				
                                <TR>
					<TD>Synopsis:</TD>
					<TD><x:out select='synopsis'/></TD>
				</TR>
				<TR>
					<TD>Author Name:</TD>
					<TD><x:out select='authorname'/></TD>
				</TR>
				<TR>
					<TD>Publisher Name:</TD>
					<TD><x:out select='publishername'/></TD>
				</TR>
                                
			</TABLE>
			<HR/>
		</x:forEach>
                <x:out select="$document//simple/@x"/><br/>
                     <x:out select="$document//simple"/>
	</BODY>
</HTML>