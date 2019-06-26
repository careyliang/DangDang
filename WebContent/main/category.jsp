<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		<!--1级分类开始-->
		<c:forEach var='c1' items="${requestScope.list }">
			<div class="bg_old" onmouseover="this.className = 'bg_white';" onmouseout="this.className = 'bg_old';">
				<h3>
					<!-- 根据以及分级加载图书 --><!-- parentId更改 -->
					[<a href='${pageContext.request.contextPath}/product/selectProductAndCategory.do?id=${c1.ddCategory1Id}'>
						${c1.ddCategory1Name }
					</a>]
					
				</h3>
				<ul class="ul_left_list">
					<!--2级分类开始-->
					<c:forEach var='c2'  items="${c1.listCategory2 }">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href='${pageContext.request.contextPath}/product/selectProductAndCategory.do?id=${c2.ddCategory2Id}'>
							${c2.ddCategory2Name} 
						</a>
						<br/>
					</c:forEach>
					<!--2级分类结束-->
				</ul>
				<div class="empty_left"></div>
			</div>
		</c:forEach>
		
		<!-- 扩展功能可以写在这里面 -->
		<div class="more2"></div>

		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
