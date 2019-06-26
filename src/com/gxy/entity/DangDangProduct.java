package com.gxy.entity;

public class DangDangProduct {
	  private int ddProductId;//主键
	  private String ddProductName;//图书名称
	  private String ddProductAuthor;//作者
	  private String ddProductImg;//图片路径
	  private String ddProductPress;//出版社
	  private String ddProductPresstime;//出版时间
	  private String ddProductEdition;//版本号
	  private String ddProductPrinttime;//印刷时间
	  private int ddProductPrintcount;//印刷数量
	  private String ddProductIsbn;//ISBN
	  private String ddProductWordcount;//总字数
	  private String ddProductPagecount;//总页数
	  private String ddProductFormat;//页面规格
	  private String ddProductPaper;//纸张
	  private String ddProductPack;//包装
	  private int ddProductPrice;//定价
	  private int ddProductDdprice;//当当价
	  private int ddProductCount;//图书销量 
	  private String ddProductAddtime;//上架时间
	  private String ddProductRecommend;//推荐评语
	  private String ddProductBrief;//图书简介
	  private String ddProductAuthorbrief;//作者简介
	  private String ddProductDirectory;//目录
	  private String ddProductMediacomment;//媒体评论推荐
	  private String ddProductExcerpt;//图书标记
	  private int ddCategory2Id;//图书分类，分类2外键
	  private String ddProductCreateDate;//时间戳
	public DangDangProduct() {
		super();
	}
	public DangDangProduct(int ddProductId, String ddProductName, String ddProductAuthor, String ddProductImg,
			String ddProductPress, String ddProductPresstime, String ddProductEdition, String ddProductPrinttime,
			int ddProductPrintcount, String ddProductIsbn, String ddProductWordcount, String ddProductPagecount,
			String ddProductFormat, String ddProductPaper, String ddProductPack, int ddProductPrice,
			int ddProductDdprice, int ddProductCount, String ddProductAddtime, String ddProductRecommend,
			String ddProductBrief, String ddProductAuthorbrief, String ddProductDirectory, String ddProductMediacomment,
			String ddProductExcerpt, int ddCategory2Id, String ddProductCreateDate) {
		super();
		this.ddProductId = ddProductId;
		this.ddProductName = ddProductName;
		this.ddProductAuthor = ddProductAuthor;
		this.ddProductImg = ddProductImg;
		this.ddProductPress = ddProductPress;
		this.ddProductPresstime = ddProductPresstime;
		this.ddProductEdition = ddProductEdition;
		this.ddProductPrinttime = ddProductPrinttime;
		this.ddProductPrintcount = ddProductPrintcount;
		this.ddProductIsbn = ddProductIsbn;
		this.ddProductWordcount = ddProductWordcount;
		this.ddProductPagecount = ddProductPagecount;
		this.ddProductFormat = ddProductFormat;
		this.ddProductPaper = ddProductPaper;
		this.ddProductPack = ddProductPack;
		this.ddProductPrice = ddProductPrice;
		this.ddProductDdprice = ddProductDdprice;
		this.ddProductCount = ddProductCount;
		this.ddProductAddtime = ddProductAddtime;
		this.ddProductRecommend = ddProductRecommend;
		this.ddProductBrief = ddProductBrief;
		this.ddProductAuthorbrief = ddProductAuthorbrief;
		this.ddProductDirectory = ddProductDirectory;
		this.ddProductMediacomment = ddProductMediacomment;
		this.ddProductExcerpt = ddProductExcerpt;
		this.ddCategory2Id = ddCategory2Id;
		this.ddProductCreateDate = ddProductCreateDate;
	}
	@Override
	public String toString() {
		return "DangDangProduct [ddProductId=" + ddProductId + ", ddProductName=" + ddProductName + ", ddProductAuthor="
				+ ddProductAuthor + ", ddProductImg=" + ddProductImg + ", ddProductPress=" + ddProductPress
				+ ", ddProductPresstime=" + ddProductPresstime + ", ddProductEdition=" + ddProductEdition
				+ ", ddProductPrinttime=" + ddProductPrinttime + ", ddProductPrintcount=" + ddProductPrintcount
				+ ", ddProductIsbn=" + ddProductIsbn + ", ddProductWordcount=" + ddProductWordcount
				+ ", ddProductPagecount=" + ddProductPagecount + ", ddProductFormat=" + ddProductFormat
				+ ", ddProductPaper=" + ddProductPaper + ", ddProductPack=" + ddProductPack + ", ddProductPrice="
				+ ddProductPrice + ", ddProductDdprice=" + ddProductDdprice + ", ddProductCount=" + ddProductCount
				+ ", ddProductAddtime=" + ddProductAddtime + ", ddProductRecommend=" + ddProductRecommend
				+ ", ddProductBrief=" + ddProductBrief + ", ddProductAuthorbrief=" + ddProductAuthorbrief
				+ ", ddProductDirectory=" + ddProductDirectory + ", ddProductMediacomment=" + ddProductMediacomment
				+ ", ddProductExcerpt=" + ddProductExcerpt + ", ddCategory2Id=" + ddCategory2Id
				+ ", ddProductCreateDate=" + ddProductCreateDate + "]";
	}
	public int getDdProductId() {
		return ddProductId;
	}
	public void setDdProductId(int ddProductId) {
		this.ddProductId = ddProductId;
	}
	public String getDdProductName() {
		return ddProductName;
	}
	public void setDdProductName(String ddProductName) {
		this.ddProductName = ddProductName;
	}
	public String getDdProductAuthor() {
		return ddProductAuthor;
	}
	public void setDdProductAuthor(String ddProductAuthor) {
		this.ddProductAuthor = ddProductAuthor;
	}
	public String getDdProductImg() {
		return ddProductImg;
	}
	public void setDdProductImg(String ddProductImg) {
		this.ddProductImg = ddProductImg;
	}
	public String getDdProductPress() {
		return ddProductPress;
	}
	public void setDdProductPress(String ddProductPress) {
		this.ddProductPress = ddProductPress;
	}
	public String getDdProductPresstime() {
		return ddProductPresstime;
	}
	public void setDdProductPresstime(String ddProductPresstime) {
		this.ddProductPresstime = ddProductPresstime;
	}
	public String getDdProductEdition() {
		return ddProductEdition;
	}
	public void setDdProductEdition(String ddProductEdition) {
		this.ddProductEdition = ddProductEdition;
	}
	public String getDdProductPrinttime() {
		return ddProductPrinttime;
	}
	public void setDdProductPrinttime(String ddProductPrinttime) {
		this.ddProductPrinttime = ddProductPrinttime;
	}
	public int getDdProductPrintcount() {
		return ddProductPrintcount;
	}
	public void setDdProductPrintcount(int ddProductPrintcount) {
		this.ddProductPrintcount = ddProductPrintcount;
	}
	public String getDdProductIsbn() {
		return ddProductIsbn;
	}
	public void setDdProductIsbn(String ddProductIsbn) {
		this.ddProductIsbn = ddProductIsbn;
	}
	public String getDdProductWordcount() {
		return ddProductWordcount;
	}
	public void setDdProductWordcount(String ddProductWordcount) {
		this.ddProductWordcount = ddProductWordcount;
	}
	public String getDdProductPagecount() {
		return ddProductPagecount;
	}
	public void setDdProductPagecount(String ddProductPagecount) {
		this.ddProductPagecount = ddProductPagecount;
	}
	public String getDdProductFormat() {
		return ddProductFormat;
	}
	public void setDdProductFormat(String ddProductFormat) {
		this.ddProductFormat = ddProductFormat;
	}
	public String getDdProductPaper() {
		return ddProductPaper;
	}
	public void setDdProductPaper(String ddProductPaper) {
		this.ddProductPaper = ddProductPaper;
	}
	public String getDdProductPack() {
		return ddProductPack;
	}
	public void setDdProductPack(String ddProductPack) {
		this.ddProductPack = ddProductPack;
	}
	public int getDdProductPrice() {
		return ddProductPrice;
	}
	public void setDdProductPrice(int ddProductPrice) {
		this.ddProductPrice = ddProductPrice;
	}
	public int getDdProductDdprice() {
		return ddProductDdprice;
	}
	public void setDdProductDdprice(int ddProductDdprice) {
		this.ddProductDdprice = ddProductDdprice;
	}
	public int getDdProductCount() {
		return ddProductCount;
	}
	public void setDdProductCount(int ddProductCount) {
		this.ddProductCount = ddProductCount;
	}
	public String getDdProductAddtime() {
		return ddProductAddtime;
	}
	public void setDdProductAddtime(String ddProductAddtime) {
		this.ddProductAddtime = ddProductAddtime;
	}
	public String getDdProductRecommend() {
		return ddProductRecommend;
	}
	public void setDdProductRecommend(String ddProductRecommend) {
		this.ddProductRecommend = ddProductRecommend;
	}
	public String getDdProductBrief() {
		return ddProductBrief;
	}
	public void setDdProductBrief(String ddProductBrief) {
		this.ddProductBrief = ddProductBrief;
	}
	public String getDdProductAuthorbrief() {
		return ddProductAuthorbrief;
	}
	public void setDdProductAuthorbrief(String ddProductAuthorbrief) {
		this.ddProductAuthorbrief = ddProductAuthorbrief;
	}
	public String getDdProductDirectory() {
		return ddProductDirectory;
	}
	public void setDdProductDirectory(String ddProductDirectory) {
		this.ddProductDirectory = ddProductDirectory;
	}
	public String getDdProductMediacomment() {
		return ddProductMediacomment;
	}
	public void setDdProductMediacomment(String ddProductMediacomment) {
		this.ddProductMediacomment = ddProductMediacomment;
	}
	public String getDdProductExcerpt() {
		return ddProductExcerpt;
	}
	public void setDdProductExcerpt(String ddProductExcerpt) {
		this.ddProductExcerpt = ddProductExcerpt;
	}
	public int getDdCategory2Id() {
		return ddCategory2Id;
	}
	public void setDdCategory2Id(int ddCategory2Id) {
		this.ddCategory2Id = ddCategory2Id;
	}
	public String getDdProductCreateDate() {
		return ddProductCreateDate;
	}
	public void setDdProductCreateDate(String ddProductCreateDate) {
		this.ddProductCreateDate = ddProductCreateDate;
	}
	  
}
