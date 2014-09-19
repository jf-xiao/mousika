<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <jsp:include page="WEB-INF/common/common_js&css.jsp"></jsp:include>
    <base href="<%=basePath%>">
    <title>代码生成器主界面</title>
    <script type="text/javascript">

    </script>
  </head>
  
  <body>
<<<<<<< HEAD
        <div id="main" style="width: 900px;height: 600px;margin: 0 auto;">
            <div id="main_title" style="background: black;height: 30px;text-align: center;line-height: 30px;color: white;">代码生成器</div>
            <div style="background-color: gray;height: 100%;">
                 <div id="main_sz" style="float: left;">
                     <div id="cssz" style="width: 270px;">
                         <fieldset>
                             <legend>参数设置</legend>
                             <table>
                                 <tr><td>项目根路径</td><td><input type="text"></td></tr>
                                 <tr><td>数据库类型</td><td><input type="text"></td></tr>
                                 <tr><td>URL</td><td><input type="text"></td></tr>
                                 <tr><td>用户名</td><td><input type="text"></td></tr>
                                 <tr><td>密码</td><td><input type="text"></td></tr>
                             </table>
                          </fieldset>
                      </div>
                     <div id="bsz" style="width: 270px;">
                         <fieldset>
                             <legend>包设置</legend>
                             <table>
                                 <tr><td>JavaBean</td><td><input type="text"></td><td><input type="checkbox" ></td></tr>
                                 <tr><td>Service</td><td><input type="text"></td><td><input type="checkbox" ></td></tr>
                                 <tr><td>Dao</td><td><input type="text"></td><td><input type="checkbox" ></td></tr>
                                 <tr><td>Controller</td><td><input type="text"></td><td><input type="checkbox" ></td></tr>
                             </table>
                          </fieldset>
                      </div>
                      <div id="cz" style="width: 270px;margin-top: 226px;">
                         <fieldset>
                             <legend>操作</legend>
                             <table>
                                 <tr>
                                    <td><input type="button" value="Refresh"></td>
                                    <td><input type="button" value="Generator"></td>
                                 </tr>
                             </table>
                          </fieldset>
                      </div>
                 </div>
                 <div id="main_list" style="float: left;">
                     <div id="main_list_serach" style="width: 100%;">
                         <fieldset>
                             <legend>查询</legend>
                             <table>
                                 <tr>
                                     <td>Category Name</td><td><input type="text"></td>
                                     <td>Table Name</td><td><input type="text"></td>
                                 </tr>
                             </table>
                          </fieldset>
                     </div>
                     <div style="width: 100%;height: 30px;line-height: 30px;">表</div>
                     <div id="table_list" style="width: 100%;border: 1px solid white;height: 200px;">
                     </div>
                     <div style="width: 100%;height: 30px;line-height: 30px;">字段</div>
                     <div id="column_list" style="width: 100%;border: 1px solid white;height: 250px;">
                     </div>
                 </div>
            </div>
            
        </div>
=======
    这是代码生成器 顶顶顶顶顶顶顶顶顶顶顶顶顶顶大大大    <br>
>>>>>>> origin/master
  </body>
</html>
