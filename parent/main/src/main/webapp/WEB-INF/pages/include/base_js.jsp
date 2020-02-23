<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="jquery/jquery-2.1.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="script/docs.min.js"></script>
<script src="script/back-to-top.js"></script>
<script src="layer/layer.js"></script>
<script type="text/javascript" src="ztree/jquery.ztree.all-3.5.min.js"></script>

<script type="text/javascript">
    <%--菜单展开加高亮显示--%>
    var item_a = $(".list-group li a:contains('${pageName}')");//找到当前的菜单
    item_a.css("color", "orange");//将其高亮显示
    item_a.parents("ul:hidden").toggle();//将父菜单展开
    item_a.parents(".list-group-item").removeClass("tree-closed");//移除class

    <%--退出登录--%>
    function logout() {
        layer.confirm("你确定要退出吗？", {title:"退出确认"}, function (idx) {
            layer.close(idx);
            //修改地址栏地址，浏览器会自动向新地址发起请求
            window.location = "${PATH}/admin/logout";
        })
    }
</script>


