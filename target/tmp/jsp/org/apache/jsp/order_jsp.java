/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.16.v20190411
 * Generated at: 2019-04-22 12:19:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class order_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/../common.jsp", Long.valueOf(1555934466112L));
    _jspx_dependants.put("jar:file:/D:/repository/org/apache/taglibs/taglibs-standard-impl/1.2.5/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425949870000L));
    _jspx_dependants.put("file:/D:/repository/org/apache/taglibs/taglibs-standard-impl/1.2.5/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1555218603255L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
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

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write(" \n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(basePath );
      out.write("js/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html >\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(basePath);
      out.write("assets/css/layui.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.print(basePath);
      out.write("assets/css/view.css\"/>\n");
      out.write("    <script src=\"https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("    <link rel=\"icon\" href=\"/favicon.ico\">\n");
      out.write("    <title>管理后台</title>\n");
      out.write("</head>\n");
      out.write("<body class=\"layui-view-body\">\n");
      out.write("     <div class=\"layui-content\" id=\"box\" style=\"display:none\">\n");
      out.write("          \n");
      out.write("     </div>\n");
      out.write("    <div class=\"layui-content\">\n");
      out.write("        <div class=\"layui-page-header\">\n");
      out.write("            <div class=\"pagewrap\">\n");
      out.write("                <span class=\"layui-breadcrumb\">\n");
      out.write("                  <a>首页</a>\n");
      out.write("                  <a>用户管理</a>\n");
      out.write("                </span>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"layui-row\">\n");
      out.write("            <div class=\"layui-card\">\n");
      out.write("                <div class=\"layui-card-body\">\n");
      out.write("                     <div class=\"demoTable\">\n");
      out.write("                          XXXX：\n");
      out.write("                      <div class=\"layui-inline\">\n");
      out.write("                         <input type=\"text\" id=\"demoReload\" name=\"phone\" lay-verify=\"required\" autocomplete=\"off\" placeholder=\"请输入联系电话\" class=\"layui-input\">  \n");
      out.write("                      </div>\n");
      out.write("                      <button class=\"layui-btn\" data-type=\"reload\">查询</button>\n");
      out.write("                    </div>\n");
      out.write("                    <table id=\"demo\" lay-filter=\"demo\" ></table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("   </div>\n");
      out.write("    <script src=\"https://heerey525.github.io/layui-v2.4.3/layui-v2.4.5/layui.js\"></script>\n");
      out.write("    \n");
      out.write("    <script type=\"text/html\" id=\"barDemo\">\n");
      out.write("      <a class=\"layui-btn layui-btn-danger layui-btn-xs\" lay-event=\"del\">删除</a>\n");
      out.write("    </script>\n");
      out.write("   \n");
      out.write("    <script>\n");
      out.write("    \n");
      out.write("   \n");
      out.write("    layui.use('table', function(){\n");
      out.write("    \t var table = layui.table,form = layui.form,$=layui.$;\n");
      out.write("    \t\n");
      out.write("       \n");
      out.write("        \n");
      out.write("    \n");
      out.write("    \n");
      out.write("       //展示已知数据\n");
      out.write("       table.render({\n");
      out.write("           elem: '#demo'\n");
      out.write("          ,toolbar: '#toolbarDemo'\n");
      out.write("          ,url:'");
      out.print(basePath);
      out.write("swork/myWork'\n");
      out.write("          ,cols: [[ //标题栏\n");
      out.write("             {field: 'committime', title: '提交时间', }\n");
      out.write("            ,{field: 'status', title: '批改状态'}\n");
      out.write("            ,{field: 'teachername', title: '老师名字'}\n");
      out.write("            ,{field: 'score', title: '分数'}\n");
      out.write("            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}\n");
      out.write("         ]]\n");
      out.write("        ,id:'testReload'\n");
      out.write("        ,skin: 'line' //表格风格\n");
      out.write("        ,even: true\n");
      out.write("        ,page: true //是否显示分页\n");
      out.write("        ,limits: [5, 7, 10]\n");
      out.write("        ,limit: 5 //每页默认显示的数量\n");
      out.write("       });\n");
      out.write("       var  active = {\n");
      out.write("    \t       reload: function(){\n");
      out.write("    \t         var demoReload = $('#demoReload');\n");
      out.write("    \t         \n");
      out.write("    \t         //执行重载\n");
      out.write("    \t         table.reload('testReload', {\n");
      out.write("    \t           page: {\n");
      out.write("    \t             curr: 1 //重新从第 1 页开始\n");
      out.write("    \t           }\n");
      out.write("    \t           ,where: {\n");
      out.write("    \t             key: demoReload.val()\n");
      out.write("    \t           }\n");
      out.write("    \t         });\n");
      out.write("    \t       }\n");
      out.write("    \t     };\n");
      out.write("    \t     \n");
      out.write("    \t     $('.demoTable .layui-btn').on('click', function(){\n");
      out.write("    \t       var type = $(this).data('type');\n");
      out.write("    \t       active[type] ? active[type].call(this) : '';\n");
      out.write("    \t     });\n");
      out.write("       \n");
      out.write("    \n");
      out.write("      \n");
      out.write("     \n");
      out.write("       //监听行工具事件\n");
      out.write("       table.on('tool(demo)', function(obj){\n");
      out.write("         var data = obj.data;\n");
      out.write("         //console.log(obj)\n");
      out.write("         if(obj.event === 'del'){\n");
      out.write("           layer.confirm('真的删除行么', function(index){\n");
      out.write("        \t  $.ajax({\n");
      out.write("                   url:\"");
      out.print(basePath);
      out.write("swork/delete\",\n");
      out.write("                   type:'post',//method请求方式，get或者post\n");
      out.write("                   dataType:'json',//预期服务器返回的数据类型\n");
      out.write("                   data:JSON.stringify({id:data.id}),\n");
      out.write("                   contentType: \"application/json; charset=utf-8\",\n");
      out.write("                   success:function(res){//res为相应体,function为回调函数\n");
      out.write("                \t   obj.del();\n");
      out.write("                       layer.close(index);\n");
      out.write("                       $(\".layui-laypage-btn\")[0].click();\n");
      out.write("                    \n");
      out.write("                   },\n");
      out.write("                   error:function(){\n");
      out.write("                       layer.alert('操作失败！！！',{icon:5});\n");
      out.write("                   }\n");
      out.write("                 });\n");
      out.write("           \n");
      out.write("           });\n");
      out.write("         } \n");
      out.write("       });\n");
      out.write("     \n");
      out.write("});\n");
      out.write("   </script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
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