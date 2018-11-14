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
    <div id="form" class="mini-form" align="top">
        <table class="search-table" align="left" style="width: 100%;color: #1458B4;">
            <tr>
                <td>电脑编号</td>
                <td>电脑名称</td>
                <td>操作系统</td>
                <td>授权设备</td>
                <td>状态</td>
            </tr>
            <tr>
                <td>
                    <input class="mini-textbox" id="jqbh" name="jqbh" maxlength="10">
                </td>
                <td>
                    <input class="mini-textbox" id="jqmc" name="jqmc" maxlength="10">
                </td>
                <td>
                    <input class="mini-textbox" id="czxt" name="czxt" maxlength="10">
                </td>
                <td>
                    <input class="mini-textbox" id="sqsb" name="sqsb" maxlength="10">
                </td>
                <td>
                    <input class="mini-textbox" id="zt" name="zt" maxlength="10">
                </td>
            </tr>
        </table>
    </div>

</fieldset>

</div>
</body>

<script type="text/javascript">
    mini.parse();

</script>

</html>
