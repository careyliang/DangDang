<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>
	<span class="more"><a href="${pageContext.request.contextPath}/main/main.jsp?itemN=17" >更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">
	
	<!--热销图书A开始-->
	<c:forEach var='s' items="${requestScope.list }">
		<div class="second_d_wai">
			<div class="img">
				<a 
					href="${pageContext.request.contextPath }/product/selectById.do?ddProductId=${s.ddProductId}" target='_blank'> 
					<img border=80  src="../productImages/${s.ddProductImg }" /> 
				</a>
			</div>
			<div class="shuming">
				<a 
					href="${pageContext.request.contextPath }/product/selectById.do?ddProductId=${s.ddProductId}" target='_blank'> 
					${s.ddProductName }
				</a>
			</div>
			<div class="price">
				定价：${s.ddProductPrice }
			</div>
			<div class="price">
				当当价:${s.ddProductDdprice }
			</div>
		</div>
			
		<div class="book_c_xy_long"></div>
	</c:forEach>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>