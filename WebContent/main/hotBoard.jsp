<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="NewProduct_1_o_t" onmouseover="">
	<ul>
		<!-- 热销榜 -->
		<c:forEach var='s' items="${requestScope.list }">
			<li>
				<a 
				href="${pageContext.request.contextPath }/product/selectById.do?ddProductId=${s.ddProductId}" target='_blank'>
				${s.ddProductName }
				</a>
			</li>
		</c:forEach>	
	</ul>
</div>
