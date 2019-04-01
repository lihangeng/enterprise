<%@ page import="com.enterprise.entity.Classic" %><%--
  Created by IntelliJ IDEA.
  User: Cesiumai
  Date: 2016/6/17
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; UTF-8"
         pageEncoding="UTF-8" %>

<%@include file="/front/common/common.jsp" %>
<body>
<%@include file="/front/common/navigation.jsp" %>
<div class="banner" style="background-image: url(<%=path%>/resource/images/banner.jpg)">

</div>
<div class="warp_main">
    <div class="warp_left">
        <div class="warp_left_box">
            <h3>典型案例</h3>
            <ul>
                <c:forEach var="item" items="<%=SystemManage.getInstance().getClassic()%>">
                    <li <c:if test="${!empty id && id eq item.id}">class="active"</c:if> ><a href="<%=path%>/classic/${item.id}">${item.title}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="warp_right">
        <div class="breadcrumb">
            <a href="<%=path%>/index">首页</a>
            >
            <a href="<%=path%>/classic">典型案例</a>
            <%
                String id = (String)request.getAttribute("id");
                    for (Classic ac : SystemManage.getInstance().getClassic()) {
                        if ((String.valueOf(ac.getId())).equals(id)) {
            %>
            ><a href="<%=path%>/classic/<%=ac.getId()%>"><%=ac.getTitle()%>
        </a>
            <%
                            break;
                        }
                }
            %>
        </div>
        <div style="overflow: hidden;">
            <div class="article_content">
                <%
                    for (Classic ac : SystemManage.getInstance().getClassic()) {
                        System.out.println(id);
                        if ((String.valueOf(ac.getId())).equals(id)) {
                        	System.out.println(ac.getId());
                        	System.out.println(ac.getContentHtml());
                %>
                        <%=ac.getContentHtml()%>
                <%
                            break;
                        }else{
                        	System.out.println(ac.getId());
                        %>
                <% 
                            }
                    }
                %>
            </div>
        </div>
    </div>
</div>


<%@include file="/front/common/foot.jsp"%>