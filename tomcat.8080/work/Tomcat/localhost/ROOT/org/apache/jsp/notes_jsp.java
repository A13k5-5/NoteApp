/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/11.0.4
 * Generated at: 2025-03-16 23:16:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import org.example.Classes.StorageItems.Note;
import java.util.List;
import org.example.Classes.StorageItems.Directory;
import org.example.Classes.StorageItems.StorageItem;
import org.example.Classes.StorageItems.Directory;

public final class notes_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/bootstrapConnect.jsp", Long.valueOf(1741448653618L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1742166922700L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(6);
    _jspx_imports_classes.add("org.example.Classes.StorageItems.StorageItem");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("org.example.Classes.StorageItems.Directory");
    _jspx_imports_classes.add("org.example.Classes.StorageItems.Note");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Notes</title>\n");
      out.write("    ");
      out.write("<link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write('\r');
      out.write('\n');
      out.write("<link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">");
      out.write('\r');
      out.write('\n');

    Directory curDir = (Directory) request.getAttribute("curDir");

      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <a class=\"navbar-brand\" href=\"#\">NoteApp</a>\r\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("        </button>\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n");
      out.write("            <ul class=\"navbar-nav\">\r\n");
      out.write("                <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"nav-link\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/\">Show Notes</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"nav-link\" href=\"addNote.html\">Add Note</a>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"nav-link\" href=\"addDirectory.html\">Add Dir</a>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            ");
 if (curDir != null) {
      out.write("\r\n");
      out.write("                <div class=\"nav-link ml-auto\">Current directory: ");
      out.print( curDir.getName() );
      out.write("</div>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>");
      out.write("\n");
      out.write("<form class=\"container mt-3\" action=\"search\">\n");
      out.write("    <div class=\"form-row align-items-center\">\n");
      out.write("        <div class=\"col-auto\">\n");
      out.write("            <input class=\"form-control mb-2\" type=\"text\" name=\"keywords\" placeholder=\"Search\">\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-auto\">\n");
      out.write("            <input type=\"submit\" class=\"btn btn-primary mb-2\" value=\"Search\">\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</form>\n");
      out.write("<form class=\"container mt-3\" action=\"sort\">\n");
      out.write("    <input type=\"submit\" class=\"btn btn-primary mt-3\" value=\"Sort\">\n");
      out.write("</form>\n");
      out.write("<div class=\"container mt-3\">\n");
      out.write("    ");
if (!curDir.isRoot()) {
      out.write("\n");
      out.write("        <a href=\"goBack.html\" class=\"btn btn-primary mt-3\">Go Back</a>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("    <table class=\"table table-striped\">\n");
      out.write("        <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th>Directories</th>\n");
      out.write("        </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("        ");
 for(Directory d : curDir.getDirectories()) { 
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                <h5>");
      out.print( d.getName() );
      out.write("</h5>\n");
      out.write("                <a href=\"changeCurDir.html?newDirId=");
      out.print( d.getId() );
      out.write("\" class=\"btn btn-primary mt-3\">Open</a>\n");
      out.write("                <a href=\"editDir?dirId=");
      out.print( d.getId() );
      out.write("\" class=\"btn btn-primary mt-3\">Edit</a>\n");
      out.write("                <a href=\"delete?id=");
      out.print( d.getId() );
      out.write("&type=dir\" class=\"btn btn-danger mt-3\">Delete</a>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("</div>\n");
      out.write("<div class=\"container mt-3\">\n");
      out.write("    <table class=\"table table-striped\">\n");
      out.write("        <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th>Notes</th>\n");
      out.write("        </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("        ");
 for (Note n : curDir.getNotes()) { 
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>\n");
      out.write("                <h5>");
      out.print( n.getName() );
      out.write("</h5>\n");
      out.write("                <a href=\"viewNote.html?id=");
      out.print( n.getId() );
      out.write("\" class=\"btn btn-primary mt-3\">View</a>\n");
      out.write("                <a href=\"editNote.html?id=");
      out.print( n.getId() );
      out.write("\" class=\"btn btn-primary mt-3\">Edit</a>\n");
      out.write("                <a href=\"delete?id=");
      out.print( n.getId() );
      out.write("&type=note\" class=\"btn btn-danger mt-3\">Delete</a>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
