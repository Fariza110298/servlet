package kz.kaznitu.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ParameterTest2Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String title=" Reading All Form Parameters";
        String docType="<!doctype html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title +"</title></head>\n" +
                "<body bgcolor =\"#f0f0f0\">\n" +
                "<h1 align =\"center\">"+title+"</h1>\n"+
                "<table width=\"center\">" + title+"</h1>\n"+
                "tr bgcolor=\"#949494\">\n"+
                "<th>Param Name</th>\n"+
                "<th>Param Value(s)</th>\n"+
                "</tr>\n");
        Enumeration paramNames=req.getParameterNames();
        while (paramNames.hasMoreElements()){
            String paramName=(String)paramNames.nextElement();
            out.print("<tr><td>"+paramName+"</td>\n<td>");
            String[]paramValues=req.getParameterValues(paramName);
            if(paramValues.length==1){
                String paramValue=paramValues[0];
                if(paramValue.length()==0)
                    out.println("<i>No Value</i>");
                else {
                    out.println("<ul>");
                    for (int i=0; i<paramValues.length; i++){
                        out.println("<li>"+paramValues[i]);
                    }
                    out.println("</ul>");
                }
            }
            out.println("</tr>\n</table>\n</body></html>");
        }
    }}

