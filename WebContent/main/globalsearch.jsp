<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h2>
	编辑推荐
</h2>

<div id=__bianjituijian/danpin>
	<div class=second_c_02>
	<s:iterator value="searchList">
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='<s:url action="selectByIdProduct" namespace="/Product"/>?id=<s:property value="productId"/>' target='_blank'>
				<img src="../productImages/<s:property value="productImg"/>" border=0 height="110px"/> </a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
	<a href='<s:url action="selectByIdProduct" namespace="/Product"/>?id=<s:property value="productId"/>' target='_blank' title='输赢'>
	书名：<s:property value="productName"/></a>
				</h3>
				<h4>
					作者：<s:property value="productAuthor"/>
					<br />
					出版社：<s:property value="productPress"/>&nbsp;&nbsp;&nbsp;&nbsp;
					出版时间：<s:date name="productPresstime" format="yyyy-MM-dd"/>
				</h4>
				<h5>
					简介：<s:property value="productBrief"/>
				</h5>
				<h6>
					定价：<s:property value="productPrice"/>&nbsp;&nbsp;
					当当价：<s:property value="productDdprice"/>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
		</s:iterator>	
	</div>
</div>

