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
    <style type="text/css">
        body {
            font-size: 10px;
            font-weight: bolder;
        }
    </style>
    <script type="text/javascript">
    $(document).ready(function(){
        $.post('ConfigController',null,function(data, textStatus, jqXHR){
            $('#outRoot').val(data.outRoot);
            $('#username').val(data['jdbc.password']);
            $('#password').val(data['jdbc.username']);
            $('#url').val(data['jdbc.url']);
            $('#driver').val(data['jdbc.driver']);
            $('#basepackage').val(data['basepackage']);
            $('#controller').text(data['basepackage']+'.controller');
            $('#service').text(data['basepackage']+'.service');
            $('#dao').text(data['basepackage']+'.dao');
            $('#model').text(data['basepackage']+'.model');
        },'json');
        
        $('#basepackage').blur(function(){
            var basepackage = $('#basepackage').val();
            $('#controller').text(basepackage+'.controller');
            $('#service').text(basepackage+'.service');
            $('#dao').text(basepackage+'.dao');
            $('#model').text(basepackage+'.model');
        });
        
        $('#dg_table').datagrid({
            url:'TableListController',
            pagination:true,//分页控件 
            rownumbers:true,//行号 
            frozenColumns:[[ 
                            {field:'ck',checkbox:true}
                        ]],
            onDblClickRow: function(rowIndex, rowData){
                $('#dg_column').datagrid({
                    url:'ColumnListController',
                    pagination:true,//分页控件 
                    rownumbers:true,//行号  
                    frozenColumns:[[ 
                                    {field:'ck',checkbox:true}
                                ]],
                    queryParams: {
                        tableName: rowData.sqlName
                    },
                    columns:[[
                              {field:'remarks',title:'remarks'},
                              {field:'sqlName',title:'sqlName'},
                              {field:'javaType',title:'javaType'},
                              {field:'jdbcSqlTypeName',title:'jdbcSqlTypeName'},
                              {field:'pk',title:'pk'},
                              {field:'nullable',title:'nullable'},
                              {field:'unique',title:'unique'}
                          ]]
                });
            },
            columns:[[
                      {field:'tableAlias',title:'表注释',width:100},
                      {field:'sqlName',title:'表名',width:100},
                      {field:'className',title:'Class类名',width:100}
                  ]]
        });
        
        $('#dg_column').datagrid({
            url:'ColumnListController',
            pagination:true,//分页控件 
            rownumbers:true,//行号  
            frozenColumns:[[ 
                            {field:'ck',checkbox:true}
                        ]],
            queryParams: {
                tableName: 'US_ROLE_AUTH'
            },
            columns:[[
                      {field:'remarks',title:'remarks'},
                      {field:'sqlName',title:'sqlName'},
                      {field:'javaType',title:'javaType'},
                      {field:'jdbcSqlTypeName',title:'jdbcSqlTypeName'},
                      {field:'pk',title:'pk'},
                      {field:'nullable',title:'nullable'},
                      {field:'unique',title:'unique'}
                  ]]
        });
        
        $('#butt_generator').bind('click',function(){
            var rows = $('#dg_table').datagrid('getSelections');
            if(rows == null || rows.length <= 0){
                $.messager.alert('提示','请选择一张表');
                return ;
            }
            $.messager.confirm("提示", "确认生产选中的表?", function(r){
                if(r){
                    var tables = '';
                    for(var i=0 ;i<rows.length;i++){
                        tables += rows[i].sqlName+',';
                    }
                    tables = tables.substring(0, tables.length - 1);
                    $.post('GeneratorController',{tables:tables},function(data, textStatus, jqXHR){
                    },'json');
                }else
                    return;
            });
            
        });
        
    });
    </script>
  </head>
  
  <body>
        <div id="main" style="width: 1150px;height: 900px;margin: 0 auto;">
            <div id="main_title" style="background: black;height: 30px;text-align: center;line-height: 30px;color: white;">代码生成器</div>
            <div style="background-color: gray;height: 100%;">
                 <div id="main_sz" style="float: left;">
                     <div id="cssz" style="width: 300px;">
                         <fieldset>
                             <legend>参数设置</legend>
                             <table>
                                 <tr><td>项目根路径</td><td><input id="outRoot" type="text"></td></tr>
                                 <tr><td>Driver</td><td><input id="driver" type="text"></td></tr>
                                 <tr><td>Url</td><td><input id="url" type="text"></td></tr>
                                 <tr><td>用户名</td><td><input id="username" type="text"></td></tr>
                                 <tr><td>密码</td><td><input id="password" type="text"></td></tr>
                             </table>
                          </fieldset>
                      </div>
                     <div id="bsz" style="width: 300px;">
                         <fieldset>
                             <legend>包设置</legend>
                             <table>
                                 <tr><td>BasePackage</td></tr>
                                 <tr style="color: white;"><td><input id="basepackage"></td></tr>
                                 <tr><td>model</td><td><input type="checkbox" ></td></tr>
                                 <tr style="color: white;"><td><div id="model" style="width: 230;"></td></tr>
                                 <tr><td>Service</td><td><input type="checkbox" ></td></tr>
                                 <tr style="color: white;"><td><div id="service" style="width: 230;"></td></tr>
                                 <tr><td>Dao</td></td><td><input type="checkbox" ></td></tr>
                                 <tr style="color: white;"><td><div id="dao" style="width: 230;"></tr>
                                 <tr><td>Controller</td></td><td><input type="checkbox" ></td></tr>
                                 <tr style="color: white;"><td><div id="controller" style="width: 230;"></tr>
                             </table>
                          </fieldset>
                      </div>
                      <div id="cz" style="width: 300px;">
                         <fieldset>
                             <legend>操作</legend>
                             <table>
                                 <tr>
                                    <td><input type="button" value="Refresh"></td>
                                    <td><input id="butt_generator" type="button" value="Generator"></td>
                                 </tr>
                             </table>
                          </fieldset>
                      </div>
                 </div>
                 <div id="main_list" style="float: left;">
                     <div id="main_list_serach" style="width: 800px;">
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
                     <div style="width: 100%;height: 30px;line-height: 30px;">表<input id="butt_table_search" type="button" value="Search" style="float: right;"></div>
                     <div id="table_list" style="width: 800px;border: 1px solid white;">
                        <table id="dg_table"></table>
                     </div>
                     <div style="width: 800px;height: 30px;line-height: 30px;">字段</div>
                     <div id="column_list" style="width: 800px;border: 1px solid white;">
                        <table id="dg_column"></table>
                     </div>
                 </div>
            </div>
            
        </div>
  </body>
</html>
