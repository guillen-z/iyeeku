<%--
  Created by IntelliJ IDEA.
  User: yq180
  Date: 2018/9/13
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/tag_res.jsp"%>
<html>
<head>
    <title>Title</title>
    <sec:csrfMetaTags/>
    <%@ include file="../common/jscss_res.jsp"%>
</head>
<body>

<fieldset style="border: solid 1px #aaa;">
    <div id="form1" class="mini-form" align="top">
        <table class="search-table" align="left" style="width: 100%;color: #1458B4;">
            <tr>
                <td width="170px;">电脑编号</td>
                <td width="170px;">电脑名称</td>
                <td width="170px;">操作系统</td>
                <td width="170px;">授权设备</td>
                <td width="170px;">状态</td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td>
                    <input class="mini-textbox" id="jqbh" name="jqbh" maxlength="10" style="width: 160px;">
                </td>
                <td>
                    <input class="mini-textbox" id="dnmc" name="dnmc" maxlength="10" style="width: 160px;">
                </td>
                <td>
                    <input class="mini-combobox" id="czxt" name="czxt" style="width: 160px;" showNullItem="true" nullItemText="请选择"
                           textField="text" valueField="id"  url="${pageContext.request.contextPath}/directory/loadDict/opSystem">
                </td>
                <td>
                    <input class="mini-textbox" id="sbbh" name="sbbh" maxlength="255" style="width: 160px;">
                </td>
                <td>
                    <input class="mini-combobox" id="zt" name="zt" showNullItem="true" nullItemText="请选择" style="width: 160px;"
                           textField="text" valueField="id"  url="${pageContext.request.contextPath}/directory/loadDict/machineStatus">
                </td>
                <td colspan="2" style="text-align: right;">
                    <a class="mini-button" iconCls="icon-search" onclick="search()">查询</a>
                    <a class="mini-button" style="margin-left: 10px;" iconCls="icon-reload" onclick="reset()">重置</a>
                </td>
            </tr>
        </table>
    </div>
</fieldset>

<div class="mini-toolbar" style="padding:2px;" borderStyle="border-top:0px;border-bottom:0px;">
    <table style="width:100%;">
        <tr>
            <td align="left">
            </td>
            <td align="right">
                <a id="shutdownMac" class="mini-button" iconCls="icon-tip" onclick="">关机</a>
                <a id="modifyAuth" class="mini-button" iconCls="icon-tip" onclick="">权限调整</a>
                <a id="goView" class="mini-button" iconCls="icon-tip" onclick="">查看/修改</a>
            </td>
        </tr>
    </table>
</div>


<div class="mini-fit">
    <div id="datagrid_machine" datafld="data" class="mini-datagrid" style="width:100%;height:100%;"
         url="${pageContext.request.contextPath}/machine/query"
         multiSelect="false" allowSortColumn="true" sortMode="client" pageSize="10"
    >
        <div property="columns">
            <div type="indexcolumn" width="30" headerAlign="center">序号</div>
            <div field="zj" width="50" headerAlign="center" visible="false">业务主键</div>
            <div field="jqbh" width="80" headerAlign="center" allowSort="false" visible="true">电脑编号</div>
            <div field="dnmc" width="100" headerAlign="center" autoEscape="true" allowSort="true">电脑名称</div>
            <div field="czxt" width="120" headerAlign="center" autoEscape="true" allowSort="true">操作系统</div>
            <div field="sbbh" width="120" headerAlign="center" allowSort="true">授权设备名称</div>
            <div field="zt" width="60" headerAlign="center" allowSort="true" renderer="ztRenderer">状态</div>
            <div field="sfyxjk" width="70" headerAlign="center" allowSort="true" renderer="yesOrNoRenderer">是否允许监控</div>
            <div field="attr1" width="50" headerAlign="center" allowSort="true" renderer="yesOrNoRenderer">操作权限1</div>
            <div field="attr2" width="50" headerAlign="center" allowSort="true" renderer="yesOrNoRenderer">操作权限2</div>
            <div field="attr3" width="50" headerAlign="center" allowSort="true" renderer="yesOrNoRenderer">操作权限3</div>
            <div field="attr4" width="50" headerAlign="center" allowSort="true" renderer="yesOrNoRenderer">操作权限4</div>
            <div field="attr5" width="50" headerAlign="center" allowSort="true" renderer="yesOrNoRenderer">操作权限5</div>
            <div field="attr6" width="50" headerAlign="center" allowSort="true" renderer="yesOrNoRenderer">操作权限6</div>
            <div field="attr7" width="50" headerAlign="center" allowSort="true" renderer="yesOrNoRenderer">操作权限7</div>
        </div>
    </div>
</div>

</body>

<script type="text/javascript">
    mini.parse();

    var grid = mini.get("datagrid_machine");
    var form1;

    $(function (){
        form1 = new mini.Form("#form1");
        grid.load();
    });

    
    function search() {
        var jqbh = mini.get("jqbh").getValue();
        var dnmc = mini.get("dnmc").getValue();
        var czxt = mini.get("czxt").getValue();
        var sbbh = mini.get("sbbh").getValue();
        var zt = mini.get("zt").getValue();

        grid.load(form1.getData(),function (data) {
           // TODO
        });
    }
    
    function reset() {
        form1.reset();
    }

    var machineStatus;
    $.getJSON("/directory/loadDict/machineStatus",null,function (data) {machineStatus = data;});

    function ztRenderer(e) {
        for ( var i = 0 , l = machineStatus.length ; i < l ; i++){
            var v = machineStatus[i];
            if(v.id == e.value) return v.text;
        }
        return "";
    }

    function yesOrNoRenderer(e) {
        return e.value == '1'? "是" : "否";
    }

</script>

</html>
