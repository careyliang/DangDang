<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
	
	<c:forEach var='s' items="${requestScope.list }">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<img border=0 height="110px" src="../productImages/${s.ddProductImg }" />
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					书名：${s.ddProductName }</a>
				</h3>
				<h4>
					作者：${s.ddProductAuthor }
					<br />
					出版社：${s.ddProductPress }
					出版时间：${s.ddProductPresstime }
				</h4>
				<h5>
					简介：${s.ddProductBrief }
				</h5>
				<h6>
					定价：${s.ddProductPrice }
					当当价：${s.ddProductDdprice }
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
	</c:forEach>
	
	
			
	</div>
</div>

