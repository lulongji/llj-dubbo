<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">
	<%@ include file="../jsp/compose/head.jsp"%> 
</head>

<body>
	<%@ include file="../jsp/compose/top.jsp"%> 
	
	<section id="slider"><!--slider-->
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div id="slider-carousel" class="carousel slide" data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
							<li data-target="#slider-carousel" data-slide-to="1"></li>
							<li data-target="#slider-carousel" data-slide-to="2"></li>
						</ol>
						
						<div class="carousel-inner">
							<div class="item active">
								<div class="col-sm-6">
									<h1><span>La-La</span>购物</h1>
									<h2>让您体验极致的产品，飞一般的速度。</h2>
									<p>啦啦网为您提供包括流行服装，时尚箱包，品牌时装，生活美食，时尚配饰，极致美护，精品家电等！欢迎您来选择最优的商品，我们会竭诚为您服务。 </p>
									<button type="button" class="btn btn-default get">购买 Let’go！</button>
								</div>
								<div class="col-sm-6">
									<img src="/jsp/images/home/girl1.jpg" class="girl img-responsive" alt="" />
									<img src="/jsp/images/home/pricing.png"  class="pricing" alt="" />
								</div>
							</div>
							<div class="item">
								<div class="col-sm-6">
									<h1><span>La-La</span>购物</h1>
									<h2>让您体验极致的产品，飞一般的速度。</h2>
									<p>啦啦网为您提供包括流行服装，时尚箱包，品牌时装，生活美食，时尚配饰，极致美护，精品家电等！欢迎您来选择最优的商品，我们会竭诚为您服务。 </p>
									<button type="button" class="btn btn-default get">购买 Let’go！</button>
								</div>
								<div class="col-sm-6">
									<img src="/jsp/images/home/girl2.jpg" class="girl img-responsive" alt="" />
									<img src="/jsp/images/home/pricing.png"  class="pricing" alt="" />
								</div>
							</div>
							
							<div class="item">
								<div class="col-sm-6">
									<h1><span>La-La</span>购物</h1>
									<h2>让您体验极致的产品，飞一般的速度。</h2>
									<p>啦啦网为您提供包括流行服装，时尚箱包，品牌时装，生活美食，时尚配饰，极致美护，精品家电等！欢迎您来选择最优的商品，我们会竭诚为您服务。 </p>
									<button type="button" class="btn btn-default get">购买 Let’go！</button>
								</div>
								<div class="col-sm-6">
									<img src="/jsp/images/home/girl3.jpg" class="girl img-responsive" alt="" />
									<img src="/jsp/images/home/pricing.png" class="pricing" alt="" />
								</div>
							</div>
							
						</div>
						
						<a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
							<i class="fa fa-angle-left"></i>
						</a>
						<a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
							<i class="fa fa-angle-right"></i>
						</a>
					</div>
					
				</div>
			</div>
		</div>
	</section><!--/slider-->
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="left-sidebar">
						<h2>商品类别</h2>
						<div class="panel-group category-products" id="accordian"><!--category-productsr-->
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#sportswear">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											运动休闲
										</a>
									</h4>
								</div>
								<div id="sportswear" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="#">Nike </a></li>
											<li><a href="#">Under Armour </a></li>
											<li><a href="#">Adidas </a></li>
											<li><a href="#">Puma</a></li>
											<li><a href="#">ASICS </a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#mens">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											精品男装
										</a>
									</h4>
								</div>
								<div id="mens" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="#">Fendi</a></li>
											<li><a href="#">Guess</a></li>
											<li><a href="#">Valentino</a></li>
											<li><a href="#">Dior</a></li>
											<li><a href="#">Versace</a></li>
											<li><a href="#">Armani</a></li>
											<li><a href="#">Prada</a></li>
											<li><a href="#">Dolce and Gabbana</a></li>
											<li><a href="#">Chanel</a></li>
											<li><a href="#">Gucci</a></li>
										</ul>
									</div>
								</div>
							</div>
							
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordian" href="#womens">
											<span class="badge pull-right"><i class="fa fa-plus"></i></span>
											时尚女装
										</a>
									</h4>
								</div>
								<div id="womens" class="panel-collapse collapse">
									<div class="panel-body">
										<ul>
											<li><a href="#">Fendi</a></li>
											<li><a href="#">Guess</a></li>
											<li><a href="#">Valentino</a></li>
											<li><a href="#">Dior</a></li>
											<li><a href="#">Versace</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">优质童装</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">生活美食</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">时尚箱包</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">极致美护</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">创意饰品</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">精品家电</a></h4>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title"><a href="#">儿童玩具</a></h4>
								</div>
							</div>
						</div>
						<!--/category-products-->
					
						<div class="brands_products"><!--brands_products-->
							<h2>品牌特价</h2>
							<div class="brands-name">
								<ul class="nav nav-pills nav-stacked">
									<li><a href="#"> <span class="pull-right">(50)</span>NIKE</a></li>
									<li><a href="#"> <span class="pull-right">(56)</span>UNDER ARMOUR</a></li>
									<li><a href="#"> <span class="pull-right">(27)</span>ADIDAS</a></li>
									<li><a href="#"> <span class="pull-right">(32)</span>PUMA</a></li>
									<li><a href="#"> <span class="pull-right">(5)</span>ASICS</a></li>
									<li><a href="#"> <span class="pull-right">(9)</span>李宁</a></li>
									<li><a href="#"> <span class="pull-right">(4)</span>杰克琼斯</a></li>
								</ul>
							</div>
						</div><!--/brands_products-->
						
			<!-- 			<div class="price-range">price-range
							<h2>Price Range</h2>
							<div class="well text-center">
								 <input type="text" class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5" data-slider-value="[250,450]" id="sl2" ><br />
								 <b class="pull-left">$ 0</b> <b class="pull-right">$ 600</b>
							</div>
						</div> -->
						<!--/price-range-->
						
						<div class="shipping text-center"><!--shipping-->
							<img src="/jsp/images/home/shipping.jpg" alt="" />
						</div><!--/shipping-->
					
					</div>
				</div>
				
				<div class="col-sm-9 padding-right">
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">特 色 服 饰</h2>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
											<img src="/jsp/images/home/product1.jpg" alt="" />
											<h2>￥78</h2>
											<p>时尚服饰</p>
											<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
										</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/jsp/images/home/product2.jpg" alt="" />
										<h2>￥78</h2>
										<p>时尚服饰</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/jsp/images/home/product3.jpg" alt="" />
										<h2>￥78</h2>
										<p>时尚服饰</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/jsp/images/home/product4.jpg" alt="" />
										<h2>￥78</h2>
										<p>时尚服饰</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
									</div>
									<img src="/jsp/images/home/new.png" class="new" alt="" />
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/jsp/images/home/product5.jpg" alt="" />
										<h2>￥78</h2>
										<p>时尚服饰</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
									</div>
									<img src="/jsp/images/home/sale.png" class="new" alt="" />
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/jsp/images/home/product6.jpg" alt="" />
										<h2>￥78</h2>
										<p>时尚服饰</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						
					</div><!--features_items-->
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">特 色 电 器</h2>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
											<img src="/jsp/images/home/product1.jpg" alt="" />
											<h2>￥78</h2>
											<p>时尚服饰</p>
											<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
										</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/jsp/images/home/product2.jpg" alt="" />
										<h2>￥78</h2>
										<p>时尚服饰</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/jsp/images/home/product3.jpg" alt="" />
										<h2>￥78</h2>
										<p>时尚服饰</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/jsp/images/home/product4.jpg" alt="" />
										<h2>￥78</h2>
										<p>时尚服饰</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
									</div>
									<img src="/jsp/images/home/new.png" class="new" alt="" />
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/jsp/images/home/product5.jpg" alt="" />
										<h2>￥78</h2>
										<p>时尚服饰</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
									</div>
									<img src="/jsp/images/home/sale.png" class="new" alt="" />
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/jsp/images/home/product6.jpg" alt="" />
										<h2>￥78</h2>
										<p>时尚服饰</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						
					</div><!--features_items-->
					<div class="features_items"><!--features_items-->
						<h2 class="title text-center">特 色 食 品</h2>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
										<div class="productinfo text-center">
											<img src="/jsp/images/home/product1.jpg" alt="" />
											<h2>￥78</h2>
											<p>时尚服饰</p>
											<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
										</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/jsp/images/home/product2.jpg" alt="" />
										<h2>￥78</h2>
										<p>时尚服饰</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/jsp/images/home/product3.jpg" alt="" />
										<h2>￥78</h2>
										<p>时尚服饰</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/jsp/images/home/product4.jpg" alt="" />
										<h2>￥78</h2>
										<p>时尚服饰</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
									</div>
									<img src="/jsp/images/home/new.png" class="new" alt="" />
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/jsp/images/home/product5.jpg" alt="" />
										<h2>￥78</h2>
										<p>时尚服饰</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
									</div>
									<img src="/jsp/images/home/sale.png" class="new" alt="" />
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="product-image-wrapper">
								<div class="single-products">
									<div class="productinfo text-center">
										<img src="/jsp/images/home/product6.jpg" alt="" />
										<h2>￥78</h2>
										<p>时尚服饰</p>
										<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
									</div>
								</div>
								<div class="choose">
									<ul class="nav nav-pills nav-justified">
										<li><a href="#"><i class="fa fa-plus-square"></i>加入购物车</a></li>
										<li><a href="#"><i class="fa fa-plus-square"></i>商品比对</a></li>
									</ul>
								</div>
							</div>
						</div>
						
					</div><!--features_items-->
					
					<div class="category-tab">
					<!--category-tab-->
						<div class="col-sm-12">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#tshirt" data-toggle="tab">T-恤</a></li>
								<li><a href="#blazers" data-toggle="tab">运动夹克</a></li>
								<li><a href="#sunglass" data-toggle="tab">太阳眼镜</a></li>
								<li><a href="#kids" data-toggle="tab">儿童服装</a></li>
								<li><a href="#poloshirt" data-toggle="tab">Polo衫</a></li>
								<li><a href="#poloshirt1" data-toggle="tab">Polo衫</a></li>
								<li><a href="#poloshirt2" data-toggle="tab">Polo衫</a></li>
								<li><a href="#poloshirt3" data-toggle="tab">Polo衫</a></li>
							</ul>
						</div>
						<div class="tab-content">
							<div class="tab-pane fade active in" id="tshirt" >
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery1.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery2.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery3.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery4.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
							</div>
							
							<div class="tab-pane fade" id="blazers" >
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery4.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery3.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery2.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery1.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
							</div>
							
							<div class="tab-pane fade" id="sunglass" >
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery3.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery4.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery1.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery2.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
							</div>
							
							<div class="tab-pane fade" id="kids" >
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery1.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery2.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery3.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery4.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
							</div>
							
							<div class="tab-pane fade" id="poloshirt" >
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery2.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery4.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery3.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery1.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="poloshirt1" >
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery2.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery4.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery3.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery1.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="poloshirt2" >
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery2.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery4.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery3.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery1.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
							</div>
							<div class="tab-pane fade" id="poloshirt3" >
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery2.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery4.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery3.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
								<div class="col-sm-3">
									<div class="product-image-wrapper">
										<div class="single-products">
											<div class="productinfo text-center">
												<img src="/jsp/images/home/gallery1.jpg" alt="" />
												<h2>￥78</h2>
												<p>时尚服饰</p>
												<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
											</div>
											
										</div>
									</div>
								</div>
							</div>
							
							
						</div>
					</div>
					<!--/category-tab-->
					
					<div class="recommended_items"><!--recommended_items-->
						<h2 class="title text-center">商 品 推 荐</h2>
						
						<div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
							<div class="carousel-inner">
								<div class="item active">	
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="/jsp/images/home/recommend1.jpg" alt="" />
													<h2>￥78</h2>
													<p>时尚服饰</p>
													<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
												</div>
												
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="/jsp/images/home/recommend2.jpg" alt="" />
													<h2>￥78</h2>
													<p>时尚服饰</p>
													<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
												</div>
												
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="/jsp/images/home/recommend3.jpg" alt="" />
													<h2>￥78</h2>
													<p>时尚服饰</p>
													<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
												</div>
												
											</div>
										</div>
									</div>
								</div>
								<div class="item">	
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="/jsp/images/home/recommend1.jpg" alt="" />
													<h2>￥78</h2>
													<p>时尚服饰</p>
													<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
												</div>
												
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="/jsp/images/home/recommend2.jpg" alt="" />
													<h2>￥78</h2>
													<p>时尚服饰</p>
													<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
												</div>
												
											</div>
										</div>
									</div>
									<div class="col-sm-4">
										<div class="product-image-wrapper">
											<div class="single-products">
												<div class="productinfo text-center">
													<img src="/jsp/images/home/recommend3.jpg" alt="" />
													<h2>￥78</h2>
													<p>时尚服饰</p>
													<a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>点击购买</a>
												</div>
												
											</div>
										</div>
									</div>
								</div>
							</div>
							 <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
								<i class="fa fa-angle-left"></i>
							  </a>
							  <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
								<i class="fa fa-angle-right"></i>
							  </a>			
						</div>
					</div><!--/recommended_items-->
					
				</div>
			</div>
		</div>
	</section>
	<%@ include file="../jsp/compose/foot.jsp"%> 
</body>
</html>