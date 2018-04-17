<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.summer.shopping.*" %>
<%@ page import="java.util.*" %>

<%!
private StringBuffer getSecondCategories(List<Category> categories,Category parentCategory) {
	StringBuffer buf = new StringBuffer();
	Category c = null;
	int childCount = 1;
	
	buf.append("category2.options[0].text ='ѡ�������ƷĿ¼';\n");
	buf.append("category2.options[0].value ='-1';\n");
	for(int i=0; i<categories.size(); i++) {
		c = categories.get(i);
		if(c.getPid() == parentCategory.getId()) {
			buf.append("category2.options["+childCount+"].text ='"+c.getName()+"';\n");
			buf.append("category2.options["+childCount+"].value ='"+c.getId()+"';\n");
			
			childCount ++;
		}
	}
	
	buf.insert(0,"category2.length = "+childCount+";\n");
	buf.insert(0,"if(category1.options[category1.selectedIndex].text == '"+parentCategory.getName()+"') {\n");
	buf.append("category2.selectedIndex = 0;\n");
	buf.append("}\n");

	return buf;
}
%>
<%
List<Category> categories = Category.getCategories();
List<Category> topCategories = new ArrayList<Category>();
Category c = null;
for(int i=0; i<categories.size(); i++) {
	c = categories.get(i);
	if(c.getGrade() == 1) {
		topCategories.add(c);
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<!--����ģ���������ʹ��HTML5�ı�׼DOCTYPE����-->
<meta name="generator" content="ecstore.b2c" />
<title>�̳���ҳ</title>
<link rel='icon' href='' type='image/x-icon' />

<script src="app/lang.js?2ddefa"></script>
<link href="app/typical.css?2ddefa" rel="stylesheet" media="screen, projection" />

<link href="app/base.css?2ddefa" rel="stylesheet" media="screen, projection" />
<link href="app/theme.css?2ddefa" rel="stylesheet" media="screen, projection" />
<script src="app/lang.js?2ddefa"></script>
<script>
var Shop = {"url":{"shipping":"\/cart-shipping","total":"\/cart-total","region":"\/tools-selRegion","payment":"\/cart-payment","purchase_shipping":"\/cart-purchase_shipping","purchase_def_addr":"\/cart-purchase_def_addr","purchase_payment":"\/cart-purchase_payment","get_default_info":"\/cart-get_default_info","diff":"\/product-diff","fav_url":"\/member-ajax_fav","datepicker":"http:\/\/www.cc5igo.com\/public\/app\/site\/statics\/js","placeholder":"http:\/\/www.cc5igo.com\/public\/app\/b2c\/statics\/images\/imglazyload.gif"},"base_url":"\/"};
</script>

    <script src="app/browserstore.js?2ddefa"></script>
	<script src="app/shoptools.js?2ddefa"></script>
<link rel="stylesheet" type="text/css" href="app/getcss.css" />
<link rel="stylesheet" type="text/css" href="app/css.css?7" />
<!--[if IE 6]>
<script type="text/javascript" src="http://cc5igo-images.s3.mall.ekaidian.com/themes/1419933922/images/DD_belatedPNG_0.0.8a.js?7"></script>
<script type="text/javascript">DD_belatedPNG.fix('.fixpng');</script>
<![endif]-->
</head>
<body>
<div class="header">
  <div class="toolbar">
    <div class="wrap">
      <div class="l"><a href="javascript:;">�ղر�վ</a></div>
      <div class="links r"><a href="">�ҵĶ���</a>
<a href="">�ҵ���ҳ</a>
<a href="">�ͷ�13055527472</a>
<a href="">�ͷ�059122896334</a>
</div>
      <div class="member r">


<span id="loginBar_32" style="" class="ie-bug">
  ���ã���ӭ����У԰ i �������̳ǣ�<a href="login.jsp">[��¼]</a>|<a href="register.jsp">[ע��]</a>
</span>
<span id="memberBar_32" style="display:none">
    ����<span id="uname_32"></span>��
  <a href="/member">[��Ա����]</a>&nbsp;&nbsp;
  <a href="/passport-logout">[�˳�]</a>
</span>

<script>
/* (function(){
    var loginBtn=$('loginBar_32').getElements('.trust__login'),timer;
	$$(loginBtn,$('accountlogin')).addEvents({'mouseenter':function(){
			if(timer)clearTimeout(timer);
			$('accountlogin').setStyles({'display':'block','top':'20','left':'10'});
		},'mouseleave':function(){
			timer=function(){$('accountlogin').setStyle('display','none')}.delay(200);
		}
	});
	// $('accountlogin').addEvent('click',function(e){loginBtn.fireEvent('click');})
})(); */
</script>

<script>
var e = Cookie.read('UNAME')?Cookie.read('UNAME'):'';
/*
	new Request({
		url:'/passport-getuname',
		method:'post',
		onComplete:function(e){
		*/
			if(e){
				$("uname_32").innerHTML = e;
				$("memberBar_32").setStyle('display','block');
				if($("loginBar_32"))
				$("loginBar_32").setStyle('display','none');
			}
			else{
				$("loginBar_32").setStyle('display','block');
				if($("memberBar_32"))
				$("memberBar_32").setStyle('display','none');
			}
		/*
		},
		data:''
		}).send();
		*/
</script>


</div>
    </div>
  </div>
  <div class="wrap">
    <div class="banner">
<div class="ad-pic">
    <a href="" target="_blank">
		<img src='images/20130813_1ec4d6ede3660ce09ce9NxAg8I0E7rpf.jpg' alt="" width='1200'height='90' />
	</a>
</div>

</div>
    <div class="nav clearfix">
      <div class="logo l"><a href="./"><img alt="У԰i ��" src="http://cc5igo-images.s3.mall.ekaidian.com/96/e5/b1/7970df146b64f0a9e0a755e3c2614bc1.jpg?1420644954#w" border="0"/></a></div>
      <div class="inner l"><a href="index.jsp">�̳���ҳ</a>
<a href="">����Сʳ</a>
<a href="">ʱ����ʳ</a>
<a href="">����ǻ�</a>
<a href="">������ֽ</a>
<a href="">��������</a>
<a href="">�����̳�</a>
<a href="">��������</a>
</div>
      <div class="t-ad r">
<div class="ad-pic">
    <a href="" target="_blank">
		<img src='' alt="" width='300'height='70' />
	</a>
</div>

</div>
    </div>
  </div>
  <div class="selecter">
    <div class="wrap">
      <div class="cart r">
<div id="shop_cart_mini_28" class="shop-cart-mini">
  <dl>
    <dt>
      <ul>
        <li class="clearing"><a href="">ȥ����</a></li>
        <li>
          <a href="/cart"  class="title-str"><span>���ﳵ</span></a>
        </li>
        
        
        <li>
          <em class="s-cart-number" data-cookiemap="S[CART_NUMBER]">0</em>��
        </li>
        
        
      </ul>
    </dt>
    <dd>
      <div class="cart-mini-container">
      </div>
    </dd>
  </dl>
</div>
<script type="text/javascript">
  window.addEvent('domready',function(){
    updateCartInfo();
    var widget = $('shop_cart_mini_28');
    var numEls = widget.getElements('dt em');
    var cartMiniContainer = widget.getElement('div.cart-mini-container').set('load',{
      onRequest:function(){
        
      },
      onSuccess:function(){
        cartMiniContainer.store('cache_status',numEls.get('text').join(''));
        try{
            updateCartInfo();
            fixImageSize($$('img[data-img-zoom]'));
        }catch(e){}

        if(cartMiniContainer.getElement('.no-information')){
          cartMiniContainer.addClass('cart-empty');
        }else{
          cartMiniContainer.removeClass('cart-empty');

          cartMiniContainer.getElements('.action-delete').addEvent('click',function(e){
            e.stop();
            var _item = this.getParent('.goods-item');
            //_item.highlight();
            new Request({
              url:this.href,
              data:_item.toQueryString()+'&response_type=true',
              onSuccess:function(){
                cartMiniContainer.load("/cart-view");
                updateCartInfo();
              }
            }).post();

          });
        }
      }
    });
    (function(){
      numEls.each(function(em){
        em.set('text',Cookie.read(em.get('data-cookiemap'))||0);
      });
      arguments.callee.delay(1500);
    })();
    var _t1= 0,_t2=0;
    widget.addEvents({
      mouseenter:function(nodelay){
        clearTimeout(_t2);
        _t1 = (function(){
          this.getElement('dl').addClass('enter');
          if(cartMiniContainer.retrieve('cache_status') == numEls.get('text').join(''))return;
          cartMiniContainer.empty().adopt(new Element('div.loading-box',{text:'���ڼ���...'}));
          cartMiniContainer.load("/cart-view");
        }).delay(200,this);
      },
      mouseleave:function(){
        clearTimeout(_t1);
        _t2 = (function(){
          this.getElement('dl').removeClass('enter');
        }).delay(500,this);
        
      }
    });
  });
</script></div>

<div class="category l">
<table>
    <th>
    <h2 id="cat_ex_t82"><a href="">������Ʒ����</a></h2>
    </th>
    
    <tr>
    	<td>
        <select id="category1" onChange="changeCategory()">
        <option value="0" selected>ѡ��һ��Ŀ¼</option>
        <%
        StringBuffer str = new StringBuffer();
        for(int i=0; i<topCategories.size(); i++) {
        	c = topCategories.get(i);
        	str.append(getSecondCategories(categories,c));
        %>
        	<option value="<%=c.getId() %>"><%=c.getName() %></option>
        <%	
        }
        %>
        </select>
        </td>
        
        <td>
        <select id="category2" hidden="true">
        </select>
        </td>
    </tr>
</table>
</div>

<script type="text/javascript">
	var req;
	function changeCategory() {
		var category1 = document.getElementById("category1");
		var category2 = document.getElementById("category2");
		
		if(category1.selectedIndex == 0) {
			category2.hidden = true;
			return;
		} else {
			category2.hidden = false;
		}
		
		var categoryId = category1.options[category1.selectedIndex].value;
		var url = "getchildcategories.jsp?categoryid="+categoryId;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			req = new XMLHttpRequest();
		} else {// code for IE6, IE5
			req = new ActiveXObject("Microsoft.XMLHTTP");
		}
		req.open("GET",	url, true);
		req.onreadystatechange = callback;
		req.send(null);
	}
	
	function callback() {
		if(req.readyState == 4) {
			if(req.status == 200) {
				var msg = req.responseText;
				msg = msg.replace(/(^\s*)|(\s*$)/g,"");
				parse(msg);
			}
		}
	}
	
	function parse(msg) {
		if(!msg || msg==null || new String(msg)=="") {
			category2.length = 1;
			category2.options[0].text = "ѡ�����Ŀ¼";
			category2.options[0].value = "-1";
			return;
		}
		categories = msg.split("_");
		category2.length = categories.length;
		category2.options[0].text = "ѡ�����Ŀ¼";
		category2.options[0].value = "-1";
		
		for(var i=0; i<categories.length; i++) {
			categoryprops = categories[i].split(",");
			var id = categoryprops[0];
			var name = categoryprops[1];
			
			category2.options[i].text = name;
			category2.options[i].value = id;
		}
	}
</script>


      <div class="search l">
<div class="clearfix">
  <form class="SearchBar searchBar_" action="productserachsimple.jsp" method="post">
  <input type="hidden" name="action" value="productserchsimple"/>
  <div class="search_label">
     <input type="text" name="keyword" value="" autocompleter="associate_autocomplete_goods:name,goods_id" ac_options="{}" class="keywords"  />
     <input type="submit" value="" class="btn_search" onfocus='this.blur();'/>
  </div>
  </form>


  <div class="hot-keywords">
    <h3>���Źؼ��ʣ�</h3>
      <a href="">�������</a>
      <a href="">ů����Ʒ</a>
      <a href="">ʱ����ʳ</a>
      <a href="">��������</a>
    </div>
</div>
</div>
    </div>
  </div>
</div>
<div id="AllWrap">
  <div class="wrap">
    <div class="clearfix">
      <div class="index-left l">
        <div class="banner"></div>
      </div>
      <div class="index-main l">
        <div class="slide">
<div class="ex-slide1-box" style="width:770px;height:250px;">
  
</div>
<script>
    new Switchable('ex_slide_72',{
        effect:'scrollx',
        autoplay:true
    });
</script>
</div>
        <div class="goods-show">


<div class="newegg-prohot">
<h2>������ѡ</h2>
<div class="neweggcarousel auto-bind-widget"  data-widget-type="Switchable"  data-widget-config="{effect:'scrollx',
    viewSize: [720,150],
    hasTriggers:false,
    autoplay:false,
    steps:4,
    disableCls:'disable',
    haslrbtn:true
  }">
    <span class="prev disable"></span>
    <span class="next"></span>
  <div class="view-content">
      <div class="view-cut">
    <ul class="switchable-content">
    
    <%
    List<Product> lastestProducts = ProductMgr.getInstance().getLatestProducts(10);
    Product p = new Product();
    int index = 1;
    for(Iterator<Product> it=lastestProducts.iterator();it.hasNext();index++) {
    	p = it.next();
    %>
   
                <li class="class-<%= index %>">
            <div class="demo-pic">
              <a target="_blank" href="showproductdetail.jsp?id=<%= p.getId() %>">
                                  <img src="<%="images/"+p.getId()+".jpg"%>" alt="<%= p.getName() %>"  />
                              </a>
            </div>
            <h6>
              <a target="_blank" href="showproductdetail.jsp?id=<%= p.getId() %>">
                <%= p.getName() %>...              </a>
            </h6>
            <p>
              <i class="mktprice"><%= p.getNormalPrice() %></i>
              <i class="saleprice"><%= p.getMemberPrice() %></i>
            </p>
          </li>
     <%
     }
     %>      
            </ul>
    </div>
  </div>

</div>

</div>
</div>
      </div>
      <div class="index-right r">
        <div class="banner">
<div class="ad-pic">
    <a href="" target="_blank">
		<img src='images/jxs.jpg' alt="" width='205'height='150' />
	</a>
</div>

</div>
        <div class="news mt10"><div class="content-node-list">
        <div class="content-node-list-title">
                    <a href="" ><span>����֪ͨ����</span></a>
            </div> 
        <ul class="content-node-list-body">
                    </ul> 
</div>
</div>
        <div class="banner mt10">
<div class="ad-pic">
    <a href="" target="_blank">
		<img src='images/jxs.jpg' alt="" width='205'height='205' />
	</a>
</div>

</div>
      </div>
    </div><!--
    <div class="index-banner mt10"></div>-->
    <div class="goods-box">
      <div class="title"><p class="more_link">
		<a href="">���ɸ��</a>
		<a href="">�������</a>
		<a href="">ů����Ʒ</a>
		<a href="">ɳ����</a>
	</p>
<h2>�����ѡ</h2>
</div>
      <div class="clearfix">
        <div class="box-side l">
<div class="ad-pic">
    <a href="" target="_blank">
		<img src='images/jxs.jpg' alt="" width='200'height='200' />
	</a>
</div>

</div>
        <div class="box-main l"><div id="goods_ex_list_52" class="goods-ex-list ">
	<dl>
		
		<dd class="goods-ex-list-body clearfix">
						<div class="item first line-first">
				<div class="p">
										<a href="/product-28" target="_blank"><img src="images/jxs.jpg" /></a>
				</div>
				<div class="i">
					<h3>
						
						<a href="/product-28" target="_blank">�����ز������ڼ��� ��...</a>
					</h3>
					
					
					<div class="gel-spec">
						<ul>
														<li><span></span></li>
													</ul>
					</div>
					
					
					<ul>
						
						<li class="gel-mktprice">
							<label>�г��ۣ�</label>
							<del>��5.80</del>
						</li>
						
						
						<li class="gel-price">
							<label>���ۼۣ�</label>
							<em>��4.80</em>
						</li>
						
						
						
					</ul>
				</div>
			</div>
						<div class="item">
				<div class="p">
										<a href="/product-26" target="_blank"><img src=images/jxs.jpg /></a>
				</div>
				<div class="i">
					<h3>
						
						<a href="/product-26" target="_blank">�����ز��̶�����ڼ�...</a>
					</h3>
					
					
					<div class="gel-spec">
						<ul>
														<li><span></span></li>
													</ul>
					</div>
					
					
					<ul>
						
						<li class="gel-mktprice">
							<label>�г��ۣ�</label>
							<del>��5.80</del>
						</li>
						
						
						<li class="gel-price">
							<label>���ۼۣ�</label>
							<em>��4.80</em>
						</li>
						
						
						
					</ul>
				</div>
			</div>
						<div class="item">
				<div class="p">
										<a href="/product-111" target="_blank"><img src="images/jxs.jpg" /></a>
				</div>
				<div class="i">
					<h3>
						
						<a href="/product-111" target="_blank">�츣�� ������ ��Ũ����...</a>
					</h3>
					
					
					<div class="gel-spec">
						<ul>
														<li><span></span></li>
													</ul>
					</div>
					
					
					<ul>
						
						<li class="gel-mktprice">
							<label>�г��ۣ�</label>
							<del>��6.00</del>
						</li>
						
						
						<li class="gel-price">
							<label>���ۼۣ�</label>
							<em>��6.60</em>
						</li>
						
						
						
					</ul>
				</div>
			</div>
						<div class="item last line-last">
				<div class="p">
										<a href="/product-110" target="_blank"><img src="images/jxs.jpg" /></a>
				</div>
				<div class="i">
					<h3>
						
						<a href="/product-110" target="_blank">�츣�� ������ ���²�ݮ...</a>
					</h3>
					
					
					<div class="gel-spec">
						<ul>
														<li><span></span></li>
													</ul>
					</div>
					
					
					<ul>
						
						<li class="gel-mktprice">
							<label>�г��ۣ�</label>
							<del>��6.00</del>
						</li>
						
						
						<li class="gel-price">
							<label>���ۼۣ�</label>
							<em>��6.60</em>
						</li>
						
						
						
					</ul>
				</div>
			</div>
					</dd>
	</dl>
</div>

		


<script type="text/javascript">

		var AutoSize = AutoSize||(new Class({
			    initialize: function(elements, hw) {
			        this.elements = $$(elements);
			        this.doAuto(hw);
			    },
			    doAuto: function(hw) {
			        if (!hw) {
			            hw = 'height';
			        }
			        var max = 0,
			            prop = (!Browser.ie6 ? 'min-': '') + hw, //ie6 ftl
			            offset = 'offset' + hw.capitalize();
			        this.elements.each(function(element, i) {
			            var calc = element[offset];
			            if (calc > max) {
			                max = calc;
			            }
			        }, this);
			        this.elements.each(function(element, i) {
			            element.setStyle(prop, max - (element[offset] - element.getStyle(hw).toInt()));
			        });
			        return max;
			    }
		}));

	addEvent('domready',function() {
		var lineLimit = 4;
		var container = $('goods_ex_list_52');
		var mouseTimer = 0;
		var items = container.getElements('.item').addEvents({
			mouseenter:function(){
				mouseTimer = this.addClass.delay(200,this,['enter']);
			},	
			mouseleave:function(){
				clearTimeout(mouseTimer);
				this.removeClass('enter');
			}
		});
		var loop = 0;
		var do_items = items.slice(loop,loop = (loop+lineLimit));
		while(do_items.length){
			
			
				new AutoSize($$(do_items).getElement('.gel-spec'),'height');
			
			new AutoSize($$(do_items).getElement('h3'),'height');
			do_items = items.slice(loop,loop = (loop+lineLimit));
		}

	});

</script></div>
        <div class="box-side r">
<div class="ad-pic">
    <a href="" target="_blank">
		<img src='images/jxs.jpg' alt="" width='200'height='200' />
	</a>
</div>

</div>
      </div>
    </div>
    <div class="goods-box">
      <div class="title"><p class="more_link">
		<a href="http://www.cc5igo.com/gallery-29">������</a>
		<a href="http://www.cc5igo.com/gallery-30">������Ʒ</a>
		<a href="http://www.cc5igo.com/gallery-31">��צ</a>
	</p>
<h2>����Сʳ</h2>
<p class="more_link">
		<a href="http://www.cc5igo.com/gallery-2">�ǹ�/�ɿ���</a>
		<a href="http://www.cc5igo.com/gallery-5">�ɹ�/�۽�</a>
		<a href="http://www.cc5igo.com/gallery-6">��ʳƷ</a>
		<a href="http://www.cc5igo.com/gallery-16">���ӻ���</a>
		<a href="http://www.cc5igo.com/gallery-23">����</a>
		<a href="http://www.cc5igo.com/gallery-22">��̦</a>
		<a href="http://www.cc5igo.com/gallery-24">����</a>
	</p>
<h2>ʱ����ʳ</h2>
</div>
      <div class="clearfix">
        <div class="box-side l">
<div class="ad-pic">
    <a href="http://www.cc5igo.com/product-174" target="_blank">
		<img src='images/jxs.jpg' alt="" width='200'height='200' />
	</a>
</div>

</div>
        <div class="box-main l"><div id="goods_ex_list_53" class="goods-ex-list ">
	<dl>
		
		<dd class="goods-ex-list-body clearfix">
						<div class="item first line-first">
				<div class="p">
										<a href="/product-31" target="_blank"><img src="images/jxs.jpg" /></a>
				</div>
				<div class="i">
					<h3>
						
						<a href="/product-31" target="_blank">�������� ���Ƹʲݹ���227g</a>
					</h3>
					
					
					<div class="gel-spec">
						<ul>
														<li><span></span></li>
													</ul>
					</div>
					
					
					<ul>
						
						<li class="gel-mktprice">
							<label>�г��ۣ�</label>
							<del>��9.90</del>
						</li>
						
						
						<li class="gel-price">
							<label>���ۼۣ�</label>
							<em>��9.00</em>
						</li>
						
						
						
					</ul>
				</div>
			</div>
						<div class="item">
				<div class="p">
										<a href="/product-194" target="_blank"><img src="images/jxs.jpg" /></a>
				</div>
				<div class="i">
					<h3>
						
						<a href="/product-194" target="_blank">�ֹ�è����100g</a>
					</h3>
					
					
					<div class="gel-spec">
						<ul>
														<li><span></span></li>
													</ul>
					</div>
					
					
					<ul>
						
						<li class="gel-mktprice">
							<label>�г��ۣ�</label>
							<del>��3.00</del>
						</li>
						
						
						<li class="gel-price">
							<label>���ۼۣ�</label>
							<em>��1.50</em>
						</li>
						
						
						
					</ul>
				</div>
			</div>
						<div class="item">
				<div class="p">
										<a href="/product-193" target="_blank"><img src="images/jxs.jpg" /></a>
				</div>
				<div class="i">
					<h3>
						
						<a href="/product-193" target="_blank">������ �϶�250g</a>
					</h3>
					
					
					<div class="gel-spec">
						<ul>
														<li><span></span></li>
													</ul>
					</div>
					
					
					<ul>
						
						<li class="gel-mktprice">
							<label>�г��ۣ�</label>
							<del>��6.80</del>
						</li>
						
						
						<li class="gel-price">
							<label>���ۼۣ�</label>
							<em>��5.00</em>
						</li>
						
						
						
					</ul>
				</div>
			</div>
						<div class="item last line-last">
				<div class="p">
										<a href="/product-79" target="_blank"><img src="images/jxs.jpg" /></a>
				</div>
				<div class="i">
					<h3>
						
						<a href="/product-79" target="_blank">������ ��Ը �㿾ԭζ 104g</a>
					</h3>
					
					
					<div class="gel-spec">
						<ul>
														<li><span></span></li>
													</ul>
					</div>
					
					
					<ul>
						
						<li class="gel-mktprice">
							<label>�г��ۣ�</label>
							<del>��9.50</del>
						</li>
						
						
						<li class="gel-price">
							<label>���ۼۣ�</label>
							<em>��9.00</em>
						</li>
						
						
						
					</ul>
				</div>
			</div>
					</dd>
	</dl>
</div>

		


<script type="text/javascript">

		var AutoSize = AutoSize||(new Class({
			    initialize: function(elements, hw) {
			        this.elements = $$(elements);
			        this.doAuto(hw);
			    },
			    doAuto: function(hw) {
			        if (!hw) {
			            hw = 'height';
			        }
			        var max = 0,
			            prop = (!Browser.ie6 ? 'min-': '') + hw, //ie6 ftl
			            offset = 'offset' + hw.capitalize();
			        this.elements.each(function(element, i) {
			            var calc = element[offset];
			            if (calc > max) {
			                max = calc;
			            }
			        }, this);
			        this.elements.each(function(element, i) {
			            element.setStyle(prop, max - (element[offset] - element.getStyle(hw).toInt()));
			        });
			        return max;
			    }
		}));

	addEvent('domready',function() {
		var lineLimit = 4;
		var container = $('goods_ex_list_53');
		var mouseTimer = 0;
		var items = container.getElements('.item').addEvents({
			mouseenter:function(){
				mouseTimer = this.addClass.delay(200,this,['enter']);
			},	
			mouseleave:function(){
				clearTimeout(mouseTimer);
				this.removeClass('enter');
			}
		});
		var loop = 0;
		var do_items = items.slice(loop,loop = (loop+lineLimit));
		while(do_items.length){
			
			
				new AutoSize($$(do_items).getElement('.gel-spec'),'height');
			
			new AutoSize($$(do_items).getElement('h3'),'height');
			do_items = items.slice(loop,loop = (loop+lineLimit));
		}

	});

</script></div>
        <div class="box-side r">
<div class="ad-pic">
    <a href="http://www.cc5igo.com/gallery?scontent=n,����" target="_blank">
		<img src='images/jxs.jpg' alt="" width='220'height='220' />
	</a>
</div>

</div>
      </div>
    </div>
    <div class="goods-box">
      <div class="title"><p class="more_link">
	</p>
<h2></h2>
</div>
      <div class="clearfix">
        <div class="box-side l">
<div class="ad-pic">
    <a href="http://www.cc5igo.com/gallery?scontent=n,��ܽ" target="_blank">
		<img src='images/jxs.jpg' alt="" width='220'height='220' />
	</a>
</div>

</div>
        <div class="box-main l"><div id="goods_ex_list_89" class="goods-ex-list ">
	<dl>
		
		<dd class="goods-ex-list-body clearfix">
						<div class="item first line-first">
				<div class="p">
										<a href="/product-221" target="_blank"><img src="images/jxs.jpg" /></a>
				</div>
				<div class="i">
					<h3>
						
						<a href="/product-221" target="_blank">������SUNSSI����ʳƷ ����...</a>
					</h3>
					
					
					
					<ul>
						
						<li class="gel-mktprice">
							<label>�г��ۣ�</label>
							<del>��5.00</del>
						</li>
						
						
						<li class="gel-price">
							<label>���ۼۣ�</label>
							<em>��4.50</em>
						</li>
						
						
						
					</ul>
				</div>
			</div>
						<div class="item">
				<div class="p">
										<a href="/product-113" target="_blank"><img src="images/jxs.jpg" /></a>
				</div>
				<div class="i">
					<h3>
						
						<a href="/product-113" target="_blank">��Խի ����Q�� ����̨��...</a>
					</h3>
					
					
					
					<ul>
						
						<li class="gel-mktprice">
							<label>�г��ۣ�</label>
							<del>��6.00</del>
						</li>
						
						
						<li class="gel-price">
							<label>���ۼۣ�</label>
							<em>��4.80</em>
						</li>
						
						
						
					</ul>
				</div>
			</div>
						<div class="item">
				<div class="p">
										<a href="/product-112" target="_blank"><img src="images/jxs.jpg" /></a>
				</div>
				<div class="i">
					<h3>
						
						<a href="/product-112" target="_blank">��Խի �춹�� ����̨��...</a>
					</h3>
					
					
					
					<ul>
						
						<li class="gel-mktprice">
							<label>�г��ۣ�</label>
							<del>��6.00</del>
						</li>
						
						
						<li class="gel-price">
							<label>���ۼۣ�</label>
							<em>��4.80</em>
						</li>
						
						
						
					</ul>
				</div>
			</div>
						<div class="item last line-last">
				<div class="p">
										<a href="/product-89" target="_blank"><img src="images/jxs.jpg" /></a>
				</div>
				<div class="i">
					<h3>
						
						<a href="/product-89" target="_blank">ϲ֮������ʱ�⺣̦ 4.5g</a>
					</h3>
					
					
					
					<ul>
						
						<li class="gel-mktprice">
							<label>�г��ۣ�</label>
							<del>��4.00</del>
						</li>
						
						
						<li class="gel-price">
							<label>���ۼۣ�</label>
							<em>��3.50</em>
						</li>
						
						
						
					</ul>
				</div>
			</div>
					</dd>
	</dl>
</div>

		


<script type="text/javascript">

		var AutoSize = AutoSize||(new Class({
			    initialize: function(elements, hw) {
			        this.elements = $$(elements);
			        this.doAuto(hw);
			    },
			    doAuto: function(hw) {
			        if (!hw) {
			            hw = 'height';
			        }
			        var max = 0,
			            prop = (!Browser.ie6 ? 'min-': '') + hw, //ie6 ftl
			            offset = 'offset' + hw.capitalize();
			        this.elements.each(function(element, i) {
			            var calc = element[offset];
			            if (calc > max) {
			                max = calc;
			            }
			        }, this);
			        this.elements.each(function(element, i) {
			            element.setStyle(prop, max - (element[offset] - element.getStyle(hw).toInt()));
			        });
			        return max;
			    }
		}));

	addEvent('domready',function() {
		var lineLimit = 4;
		var container = $('goods_ex_list_89');
		var mouseTimer = 0;
		var items = container.getElements('.item').addEvents({
			mouseenter:function(){
				mouseTimer = this.addClass.delay(200,this,['enter']);
			},	
			mouseleave:function(){
				clearTimeout(mouseTimer);
				this.removeClass('enter');
			}
		});
		var loop = 0;
		var do_items = items.slice(loop,loop = (loop+lineLimit));
		while(do_items.length){
			
			
			new AutoSize($$(do_items).getElement('h3'),'height');
			do_items = items.slice(loop,loop = (loop+lineLimit));
		}

	});

</script></div>
        <div class="box-side r">
<div class="ad-pic">
    <a href="http://www.cc5igo.com/gallery?scontent=n,������" target="_blank">
		<img src='images/jxs.jpg' alt="" width='220'height='220' />
	</a>
</div>

</div>
      </div>
    </div>
    
<script type="text/javascript" src="http://v3.jiathis.com/code/jiathis_r.js?btn=r3.gif" charset="utf-8"></script>


<script type="text/javascript" src="http://v1.ujian.cc/code/ujian.js?type=slide"></script>

</body></html>
