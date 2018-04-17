<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="com.summer.shopping.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<!--↑↑模板中请务必使用HTML5的标准DOCTYPE↑↑-->
<meta name="generator" content="ecstore.b2c" />
<title>商城首页</title>
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
      <div class="l"><a href="javascript:;">收藏本站</a></div>
      <div class="links r"><a href="">我的订单</a>
<a href="">我的主页</a>
<a href="">客服13055527472</a>
<a href="">客服059122896334</a>
</div>
      <div class="member r">


<span id="loginBar_32" style="" class="ie-bug">
  您好，欢迎光临校园 i 购网上商城！<a href="login.jsp">[登录]</a>|<a href="register.jsp">[注册]</a>
</span>
<span id="memberBar_32" style="display:none">
    您好<span id="uname_32"></span>！
  <a href="/member">[会员中心]</a>&nbsp;&nbsp;
  <a href="/passport-logout">[退出]</a>
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
      <div class="logo l"><a href="./"><img alt="校园i 购" src="http://cc5igo-images.s3.mall.ekaidian.com/96/e5/b1/7970df146b64f0a9e0a755e3c2614bc1.jpg?1420644954#w" border="0"/></a></div>
      <div class="inner l"><a href="index.jsp">商城首页</a>
<a href="">方便小食</a>
<a href="">时尚零食</a>
<a href="">身体呵护</a>
<a href="">生活用纸</a>
<a href="">电子数码</a>
<a href="">积分商城</a>
<a href="">整点抢购</a>
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
        <li class="clearing"><a href="">去结算</a></li>
        <li>
          <a href="/cart"  class="title-str"><span>购物车</span></a>
        </li>
        
        
        <li>
          <em class="s-cart-number" data-cookiemap="S[CART_NUMBER]">0</em>件
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
          cartMiniContainer.empty().adopt(new Element('div.loading-box',{text:'正在加载...'}));
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
<h2 id="cat_ex_t82"><a href="">所有商品分类</a></h2>
<div id="cat_ex_level_82" >
  <ul class="cat-ex-level clearfix">
    
    <li class="cat-item site-home first">
      <div class="cat-root-box">
        <a  href="index.jsp" target="_blank">
          <span>首页</span>
        </a>
      </div>
    </li>
    
      <li class="cat-item lv1 "
      data-catid="28"
      data-typeid="1"
      data-typename="通用商品类型">
      <div class="cat-root-box">
        <a  href="/gallery-28" target="_blank">
          <span>方便小食</span>
        </a>
      </div>
            <div class="cat-children-box cfx">
        
        <div class="cat-link">
                            </div>
                  
      </div>
                </li>
      <li class="cat-item lv1 "
      data-catid="12"
      data-typeid="1"
      data-typename="通用商品类型">
      <div class="cat-root-box">
        <a  href="/gallery-12" target="_blank">
          <span>时尚零食</span>
        </a>
      </div>
            <div class="cat-children-box cfx">
        
        <div class="cat-link">
                            </div>
                  
      </div>
                </li>
      <li class="cat-item lv1 "
      data-catid="32"
      data-typeid="1"
      data-typename="通用商品类型">
      <div class="cat-root-box">
        <a  href="/gallery-32" target="_blank">
          <span>饮料/酒</span>
        </a>
      </div>
            <div class="cat-children-box cfx">
        
        <div class="cat-link">
                            </div>
                  
      </div>
                </li>
      <li class="cat-item lv1 "
      data-catid="7"
      data-typeid="1"
      data-typename="通用商品类型">
      <div class="cat-root-box">
        <a  href="/gallery-7" target="_blank">
          <span>身体呵护</span>
        </a>
      </div>
            <div class="cat-children-box cfx">
        
        <div class="cat-link">
                            </div>
                  
      </div>
                </li>
      <li class="cat-item lv1 "
      data-catid="13"
      data-typeid="1"
      data-typename="通用商品类型">
      <div class="cat-root-box">
        <a  href="/gallery-13" target="_blank">
          <span>生活用纸</span>
        </a>
      </div>
            <div class="cat-children-box cfx">
        
        <div class="cat-link">
                            </div>
                  
      </div>
                </li>
      <li class="cat-item lv1 "
      data-catid="36"
      data-typeid="1"
      data-typename="通用商品类型">
      <div class="cat-root-box">
        <a  href="/gallery-36" target="_blank">
          <span>衣物洗涤</span>
        </a>
      </div>
            <div class="cat-children-box cfx">
        
        <div class="cat-link">
                            </div>
                  
      </div>
                </li>
      <li class="cat-item lv1 "
      data-catid="42"
      data-typeid="1"
      data-typename="通用商品类型">
      <div class="cat-root-box">
        <a  href="/gallery-42" target="_blank">
          <span>韩国饰品</span>
        </a>
      </div>
            <div class="cat-children-box cfx">
        
        <div class="cat-link">
                            </div>
                  
      </div>
                </li>
      <li class="cat-item lv1 "
      data-catid="53"
      data-typeid="1"
      data-typename="通用商品类型">
      <div class="cat-root-box">
        <a  href="/gallery-53" target="_blank">
          <span>数码电子</span>
        </a>
      </div>
            <div class="cat-children-box cfx">
        
        <div class="cat-link">
                            </div>
                  
      </div>
                </li>
      <li class="cat-item lv1 last"
      data-catid="35"
      data-typeid="1"
      data-typename="通用商品类型">
      <div class="cat-root-box">
        <a  href="/gallery-35" target="_blank">
          <span>情趣用品</span>
        </a>
      </div>
            <div class="cat-children-box cfx">
        
        <div class="cat-link">
                            </div>
                  
      </div>
                </li>
    </ul>

  <div style="display:none;">
    
              <dl class="cat-item lv2"
                  data-catpid="28"
                  data-catid="29"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-29" target="_blank"><span>方便面</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="28"
                  data-catid="30"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-30" target="_blank"><span>火腿制品</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="28"
                  data-catid="31"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-31" target="_blank"><span>凤爪</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="12"
                  data-catid="2"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-2" target="_blank"><span>糖果/巧克力</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="12"
                  data-catid="3"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-3" target="_blank"><span>饼干糕点</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="12"
                  data-catid="23"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-23" target="_blank"><span>果冻</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="12"
                  data-catid="4"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-4" target="_blank"><span>面包蛋糕</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="12"
                  data-catid="5"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-5" target="_blank"><span>干果蜜饯</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="12"
                  data-catid="6"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-6" target="_blank"><span>膨化食品</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="12"
                  data-catid="15"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-15" target="_blank"><span>暖冬饮品</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="12"
                  data-catid="16"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-16" target="_blank"><span>瓜子花生</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="12"
                  data-catid="25"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-25" target="_blank"><span>沙琪玛</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="12"
                  data-catid="22"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-22" target="_blank"><span>海苔</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="12"
                  data-catid="24"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-24" target="_blank"><span>麻薯</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="12"
                  data-catid="34"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-34" target="_blank"><span>曲奇/蛋卷</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="32"
                  data-catid="47"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-47" target="_blank"><span>功能饮料</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="32"
                  data-catid="48"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-48" target="_blank"><span>碳酸饮料</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="32"
                  data-catid="51"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-51" target="_blank"><span>水/果汁</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="32"
                  data-catid="50"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-50" target="_blank"><span>进口饮料</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="32"
                  data-catid="49"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-49" target="_blank"><span>啤酒/气泡酒/鸡尾酒</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="32"
                  data-catid="40"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-40" target="_blank"><span>奶制品</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="32"
                  data-catid="52"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-52" target="_blank"><span>即饮咖啡/茶饮料</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="7"
                  data-catid="10"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-10" target="_blank"><span>沐浴用品</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="7"
                  data-catid="11"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-11" target="_blank"><span>洗发用品</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="7"
                  data-catid="41"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-41" target="_blank"><span>润发/护发</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="13"
                  data-catid="14"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-14" target="_blank"><span>抽纸</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="13"
                  data-catid="21"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-21" target="_blank"><span>卷纸</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="13"
                  data-catid="19"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-19" target="_blank"><span>手帕纸</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="13"
                  data-catid="9"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-9" target="_blank"><span>女士卫生</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="36"
                  data-catid="37"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-37" target="_blank"><span>洗衣皂</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="36"
                  data-catid="38"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-38" target="_blank"><span>洗衣粉</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="36"
                  data-catid="39"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-39" target="_blank"><span>洗衣液</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="42"
                  data-catid="43"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-43" target="_blank"><span>耳钉</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="42"
                  data-catid="44"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-44" target="_blank"><span>耳坠</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="42"
                  data-catid="45"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-45" target="_blank"><span>项链</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="42"
                  data-catid="46"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-46" target="_blank"><span>戒指</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
              <dl class="cat-item lv2"
                  data-catpid="53"
                  data-catid="54"
                  data-typeid="1"
                  data-typename="通用商品类型">
          <dt>
            <a href="/gallery-54" target="_blank"><span>U盘</span></a>
          </dt>
          
          <dd>
          </dd>
          
        </dl>
                      <a href="/gallery-17" class="cat-item lv3"
                  data-catpid="9"
                  data-catid="17"
                  data-typeid="1"
                  data-typename="通用商品类型" target="_blank"><span>夜用</span></a>
                      <a href="/gallery-18" class="cat-item lv3"
                  data-catpid="9"
                  data-catid="18"
                  data-typeid="1"
                  data-typename="通用商品类型" target="_blank"><span>日用</span></a>
                      <a href="/gallery-26" class="cat-item lv3"
                  data-catpid="9"
                  data-catid="26"
                  data-typeid="1"
                  data-typename="通用商品类型" target="_blank"><span>护垫</span></a>
          
  </div>
</div>


<script type="text/javascript">

  addEvent('domready',function(){
    //var _t = $time();

    var container = $('cat_ex_level_82');

    var t = location.href.split('/');
    if( t = t[t.length-1] ) t = /\b\w+/.exec(t);
    if(!t || t=='index'){
      $$('.index-left')[0].setStyle('padding-top',container.getHeight());
      container.setStyle('top',40);
    }else{
      container.getParent().addEvents({
        'mouseenter':function(){
          container.setStyle('top',40);
        },
        'mouseleave':function(){
          container.setStyle('top',-9999);
        }
      })
    }

        var containerParentNode = container.parentNode;
          while(containerParentNode!=document.body){

            $(containerParentNode).setStyle('overflow','visible');


            containerParentNode = containerParentNode.parentNode;
          }
    var containerPos = container.getPosition([window]);
    var mousEenterTimer = 0,mouseLeaveTimer = 0;
    
    container.getElements('li.lv1').each(function(item){

            var ccbEl = item.getElement('div.cat-children-box');
      
      
      var catLv1ID =item.get('data-catid');
      var dls = container.getElements('dl[data-catpid='+catLv1ID+']');
      var ccEl  = new Element('div.cat-children').inject(ccbEl, 'top').adopt(dls).addClass('cfx');
      var dls_length = dls.length;
      if(dls&&dls_length>1){
        dls[0].addClass('first');
        dls[dls_length-1].addClass('last');
      }else{
        return;
      }
      

                       item.addEvents({
        'mouseenter':function(){
          clearTimeout(mousEenterTimer);
          clearTimeout(this.retrieve('mouseLeaveTimer'));
          mousEenterTimer =(function(){
            this.addClass('mouseenter-cat');

            

              var brandMaxH =  item.retrieve('brandMaxH');
              var brandItems = item.getElements('.cat-link-brand-item');
              if(!brandMaxH){
                brandItems.each(function(brand){
                  brandMaxH = Math.max(brandMaxH,brand.getSize().y);
                });
              }
              if(brandItems&&brandItems.length)
              brandItems.setStyles({height:brandMaxH,overflow:'hidden'});


            


            // var _pos1 = window.getScrollLeft() - containerPos.x;
            // var _pos2 =this.retrieve('_pos2');
            // if(!_pos2)_pos2 =  this.getPosition().x+this.getSize().x;
            // ccbEl.setStyle('left',_pos1>0?_pos1:0);
            // var _pos3 = ccbEl.getPosition().x+ccbEl.getSize().x;
            // var _limit = _pos3 - _pos2;
            // var flexDeviate = 4;
            // if(_limit<0){
            //  ccbEl.setStyle('left',ccbEl.getStyle('left').toInt()+Math.abs(_limit));
            //  flexDeviate = (-flexDeviate);
            // }

          }).delay(200,this);
        },
        'mouseleave':function(){
          clearTimeout(mousEenterTimer);
          this.store('mouseLeaveTimer',
            mouseLeaveTimer =  this.removeClass.delay(150,this,['mouseenter-cat'])
            );
        }
      });
      
    });

    
    container.getElements('.lv2 dd').each(function(item){
      var catLv2ID = item.getParent('.lv2').get('data-catid');
      item.adopt(container.getElements('a[data-catpid='+catLv2ID+']'));
    });
    





    //console.info($time()-_t);


  });//end domready
</script>




</div>
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
    <h3>热门关键词：</h3>
      <a href="">懒人早餐</a>
      <a href="">暖冬饮品</a>
      <a href="">时尚零食</a>
      <a href="">体贴姨妈</a>
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
        <div class="slide"><script>
    new Switchable('ex_slide_72',{
        effect:'scrollx',
        autoplay:true
    });
</script>
</div>
        <div class="goods-show"></div>
      </div>
      <div class="index-right r">
        <div class="banner">
<div class="ad-pic"></div>

</div>
        <div class="news mt10"><div class="content-node-list">
          <ul class="content-node-list-body">
          </ul> 
</div>
</div>
        <div class="banner mt10">
<div class="ad-pic"></div>

</div>
      </div>
    </div><!--
    <div class="index-banner mt10"></div>--><script type="text/javascript" src="http://v3.jiathis.com/code/jiathis_r.js?btn=r3.gif" charset="utf-8"></script>

<div class="section"><div id="main" class="clearfix">

<%
request.setCharacterEncoding("gb2312");
int id;
try {
	id = Integer.parseInt(request.getParameter("id"));
} catch(NumberFormatException e) {
	e.printStackTrace();
	out.println("显示商品出错！");
	return;
}

Product p = ProductMgr.getInstance().loadById(id);
%>
  <!-- 商品详情 -->
  <div class="page-maincontent">
    <div id="product_container" class="product-container clearfix">
      <!-- 标题简介 -->
<div class="product-titles">
  <h2> <%= p.getName() %>  </h2>
  </div>
<form action="buy.jsp" method="post" target="_dialog_minicart">
  <input type="hidden" name="id" value="<%= p.getId() %>">
  <div class="product-side" style="width:302px;">
    <!-- 商品相册 -->
<div id="product_album" class="product-album">
  <div class="product-album-preview clearfix">
    <div class="product-album-pic" style="width:300px;height:300px;line-height:298px;*font-size:270px;">
      <a href="http://cc5igo-images.s3.mall.ekaidian.com/46/61/9b/3cdfe9b2e16fe9767ec97c07464fb59c.jpg?1426139599#h" class="album-preview-container" id="op_product_zoom"><img src="http://cc5igo-images.s3.mall.ekaidian.com/4f/00/f7/09e0a29b0a08da1d70157bd2ccedbb9b.jpg?1426139599#h" alt="" class="small-pic" style="max-width:300px;max-height:300px;"></a>
    </div>
    <img class="loading" app="b2c" src="http://www.cc5igo.com/public/app/b2c/statics/images/loading.gif" alt="正在加载大图..." style="display:none;" />    <div class="product-album-zoom"><a href="/product-albums-215" title="点击查看大图" target="_blank" class="icon">&#x4a;</a></div>
      </div>
  <div class="product-album-thumb product-album-thumb-bottom">
    <div class="flip prev forward over"><a href="javascript:void(0);" class="icon">&#x34;</a></div>
    <div class="thumbnail-list" style="width:268px;">
      <ul class="clearfix">
                  <li class="active">
            <div class="arrow arrow-top"><i class="below"></i></div>
            <div class="thumbnail"><a href="http://cc5igo-images.s3.mall.ekaidian.com/46/61/9b/3cdfe9b2e16fe9767ec97c07464fb59c.jpg?1426139599#h" rel="op_product_zoom" rev="http://cc5igo-images.s3.mall.ekaidian.com/4f/00/f7/09e0a29b0a08da1d70157bd2ccedbb9b.jpg?1426139599#h"><img src="http://cc5igo-images.s3.mall.ekaidian.com/60/37/90/614b79f2ce84af9880d8243d85ceca84.jpg?1426139599#h" alt="" width="60" height="60"></a></div>
          </li>
                    <li >
            <div class="arrow arrow-top"><i class="below"></i></div>
            <div class="thumbnail">
            <a href="http://cc5igo-images.s3.mall.ekaidian.com/69/7a/16/f8b1375a628cf63ac5798074b57247ae.jpg?1426139599#h" rel="op_product_zoom" rev="http://cc5igo-images.s3.mall.ekaidian.com/75/8e/f3/ec279d345d73596d3d2d4f1844d42717.jpg?1426139599#h">
            <img src="http://cc5igo-images.s3.mall.ekaidian.com/a7/3b/ce/7c6fc05f64f3bd9de729676d91510315.jpg?1426139599#h" alt="" width="60" height="60">
            </a></div>
          </li>
                </ul>
    </div>
    <div class="flip next backward over"><a href="javascript:void(0);" class="icon">&#x35;</a></div>
  </div>
</div>
    <!-- 分享推荐收藏 -->
    <div class="share-recommend" id="share_recommend">
    <!-- share -->
  <span class="share pop-wrapper">
    <button type="button" class="btn btn-rounded action-handle"><span><span><i class="icon icon-share">&#x58;</i><i class="text">分享</i><i class="icon arrow">&#x37;</i></span></span></button>
    <div class="pop-body" style="display:none">
      <div class="share-mini">
                <a href="http://service.weibo.com/share/share.php?srcUrl=http%3A%2F%2Fwww.cc5igo.com%2Fproduct-226&pic=http%3A%2F%2Fcc5igo-images.s3.mall.ekaidian.com%2Fe5%2Fb1%2Ff3%2F11faa132592a15959f6224b544568eef.jpg%3F1426139599%23h%2Chttp%3A%2F%2Fcc5igo-images.s3.mall.ekaidian.com%2Fdd%2Fe7%2Fad%2F3e3c2464695cb6a66aeb655079f504f6.jpg%3F1426139599%23h&title=%E3%80%90%E5%8F%8C%E6%B1%87%E7%81%AB%E8%85%BF%E8%82%A0%E6%B3%A1%E9%9D%A2%E6%8B%8D%E6%A1%A345g+%E4%BC%91%E9%97%B2%E9%9B%B6%E9%A3%9F%E5%B0%8F%E5%90%83+%E9%85%8D%E6%96%B9%E4%BE%BF%E9%9D%A2+%E9%A6%99%E8%82%A0%E3%80%91%EF%BC%8C%E9%94%80%E5%94%AE%E4%BB%B71.100%EF%BC%88%E5%88%86%E4%BA%AB%E8%87%AA+%E6%A0%A1%E5%9B%ADi%E8%B4%AD%EF%BC%89&appkey=h&" target="_blank" class="sina"><i class="icon"></i>新浪微博</a>
              </div>
    </div>
  </span>
    <!-- recommend -->
  <span class="recommend pop-wrapper">
    <button type="button" class="btn btn-rounded action-handle"><span><span><i class="icon icon-recommend">&#x40;</i><i class="text">推荐</i><i class="icon arrow">&#x37;</i></span></span></button>
    <div class="pop-body" style="display:none;">
      <div class="pop-title">
          <h3>将商品推荐给好友</h3>
        <div class="close"><button type="button" class="btn pop-close icon">&#xd7;</button></div>
      </div>
      <div class="pop-content">
                <div class="notice">您还没有登录，请先            <a href="/passport-login" class="lnklike">登录</a> 或            <a href="/passport-signup" class="lnklike">注册</a> 后推荐给好友。</div>
                <!-- <form action="" method="post"> -->
          <ul class="form" id="op_recommend_form">
            <li class="form-item">
            <label for="" class="form-label">发件人：</label>
            <span class="form-act"><i class="not-login">(登录后显示)</i></span>
            </li>
            <li class="form-item">
            <label for="" class="form-label">收件人：</label>
              <span class="form-act"><textarea name="email" id="" cols="30" rows="3" placeholder="填写多个地址请用逗号“,”隔开。" vtype="required&amp;&amp;emaillist" data-caution="请填写正确邮箱地址" disabled></textarea></span>
            </li>
            <li class="form-item">
            <label for="" class="form-label">内容：</label>
              <span class="form-act"><textarea name="content" id="" cols="30" rows="6" vtype="required" data-caution="请填写邮件内容" disabled></textarea></span>
            </li>
            <li class="form-item form-item-last">
              <label for="" class="form-label"></label>
              <span class="form-act">
                <a class="btn btn-caution disabled" rel="_request" href="/product-recommend-215-226" data-ajax-config="{method:'post',data:$('op_recommend_form').toQueryString(),onSuccess:function(rs){notice.success('邮件发送成功，可继续推荐给好友', $('op_recommend_form'), 'before');}}"><span><span>发送</span></span></a>
              </span>
            </li>
          </ul>
        <!-- </form> -->
      </div>
    </div>
  </span>
    <!-- favarite -->
  <a href="/passport-login" class="btn btn-rounded btn-addfav"><span><span><i class="icon icon-fav">&#x2e;</i><i class="text">收藏</i></span></span></a>
  </div>
  </div>
  <div class="product-main clearfix" style="margin-left:320px;">
    <!-- 商品基本信息 -->
    <div id="product_information" class="product-information">
      <!--商品价格 and 商品评分-->
       <div class="product-concerns">
    <ul>
      <li class="item">
      <span class="label">会员价：</span>
        <span class="detail">
            <b class="price"><ins class="action-price"></ins></b>
            <i class="minor"><span class="action-saveprice"><%= p.getMemberPrice() %></span></i>        </span>
      </li>
            <li class="item">
      <span class="label">销售价：</span>
        <span class="detail">
          <i class="minor"><del class="action-mktprice"><%= p.getNormalPrice() %></del></i>
        </span>
      </li>
          </ul>
</div>
      <!-- 赠品和促销 -->
        <div class="product-promotion clearfix auto-switchable" id="product_promotion">
  <ul class="tabs clearfix switchable-triggerBox">
        <li class="active"><em>订单促销</em></li>
      </ul>
  <!-- <div class="bd"> -->
    <div class="switchable-panel" >
    <div class="panel-top" >
      <ul>
                <li><em class="label-alert">包邮</em><span class="name">满12元包邮</span></li>
              </ul>
    </div>
      </div>
    <!-- </div> -->
</div>
         <!--判断是预售商品-->
        
            <!-- 扩展属性 -->
      <div class="product-params">
  <table width="100%">
    <tbody>
      <tr>
                <td class="label"><div class="text-nowrap">货品编号：</div></td>
        <td width="45%">P550129CE69E56</td>
              </tr>
          </tbody>
  </table>
</div>
      <!-- 购买区 -->
      <div class="product-buy">
        <!-- 商品规格 -->
                <div class="product-action">
          <ul>
                        <!--商品库存-->
              <li class="product-buy-quantity">
  <label class="item-label" for="for_quantity_input">数量：</label>
  <span class="item-content">
    <span class="p-quantity"><a href="javascript:void(0);" class="btn-decrease">-</a><input type="text" name="goods[num]" id="for_quantity_input" class="action-quantity-input" value="1" min="1" max=""><a href="javascript:void(0);" class="btn-increase">+</a></span>     <span class="p-store"></span>
    <input type="hidden" name="stock" value="">
  </span>
</li>

              <!--购买按钮-->
              <li class="product-buy-action">
  <button type="submit" class="btn btn-import btn-huge action-buynow" rel="_request"><span><span>立即购买</span></span></button>
<!--判断是否是预售商品和预售商品的时间判断-->
<button type="submit" class="btn btn-major btn-huge action-addtocart" rel="_request"><span><span>加入购物车</span></span></button>  <button type="button" class="btn btn-caution btn-huge action-notify hide"><span><span>到货通知</span></span></button>
  <span class="pop-wrapper action-scanbuy">
    <button type="button" class="btn action-handle">扫一扫购买 <i class="icon icon-qrcode">&#x69;</i></button>
    <div class="pop-body" style="display:none;">
      <img src="http://cc5igo-images.s3.mall.ekaidian.com/cb/32/e8/fb7e44535175edeb461b75d1a4506e63.png?1429074610#h" alt="商品二维码" width="148" height="148">
    </div>
  </span>
  </li>
              <!--判断是预售商品-->
                      </ul>
        </div>
      </div>
    </div>
  </div>
</form>

<img src="/product-cron-215" width="1" border="none" height="1">


<div id="product_notify" class="product-notify" style="display:none;">
  <p class="desc">该货品暂时缺货，请在下面输入您的邮箱地址或手机号码，当我们有现货供应时，我们会发送邮件通知您！</p>
  <form class="form" method="post" action="/product-toNotify">
    <input type="hidden" name="item[0][goods_id]" value="215">
    <input type="hidden" name="item[0][product_id]" value="226">
    <ul>
      <li class="form-item">
        <label for="" class="form-label">邮箱地址：</label>
        <span class="form-act">
          <!--
          <input class="x-input" type="text" name="email" id="dom_el_2eff5b0" size="30" vtype="required&&email" />          -->
            <input type="text" name="email" id="" size="30" />
        </span>
      </li>
      <li class="form-item">
        <label for="" class="form-label">手机号码：</label>
        <span class="form-act">
            <!--
            <input class="x-input" type="text" name="cellphone" id="dom_el_2eff5b1" size="30" vtype="required" />            -->
            <input type="text" name="cellphone" id="" size="30" />
        </span>
      </li>
      <li class="form-item form-item-last">
        <label for="" class="form-label"></label>
        <span class="form-act">
          <button type="submit" class="btn btn-caution" rel="_request"><span><span>提交</span></span></button>        </span>
      </li>
    </ul>
  </form>
</div>

    </div>

    <!-- 配件套餐 -->
    
    <div id="product_section">
      <div id="product_detail" class="product-section product-detail">
        <h2 class="tags-hd active"><a href="#detail">商品详情</a></h2>
        <div class="product-attributes">
  <ul class="clearfix">
    <li>所属分类：<%= p.getCategory().getName() %></li>
      </ul>
</div>
<div class="detail-content">
  <textarea class="action-lazyload hide"><img src="http://cc5igo-images.s3.mall.ekaidian.com/0d/6d/08/0049a882436c88273b1f70730ea227e4.jpg?1426139539#w">
<img src="http://cc5igo-images.s3.mall.ekaidian.com/49/89/16/e2e6167ace3dfc39e3f449a4e11acced.jpg?1426139548#w">
<img src="http://cc5igo-images.s3.mall.ekaidian.com/ed/a1/93/95a3062b3fb574f21064569aef79f283.jpg?1426139561#w">
<img src="http://cc5igo-images.s3.mall.ekaidian.com/8c/1a/f0/133333ba9c5c93f8f21bcf010ba6152d.jpg?1426139572#w"></textarea>
</div>

<div id="product_comment_init" class="product-comment" data-sync-type="product_comment_init">
</div>
<div id="product_consult_init" class="product-consult" data-sync-type="product_consult_init">
</div>
      </div>
            <div id="product_comment" class="product-section product-comment" data-sync-type="product_comment" style="display:none;">
        <h2 class="tags-hd tag-comment"><a href="#recomment">商品评论</a></h2>
      </div>
            <div id="product_consult" class="product-section product-consult" data-sync-type="product_consult" style="display:none;">
          <h2 class="tags-hd tag-consult"><a href="#consult">商品咨询</a></h2>
      </div>
            <div id="product_related" class="product-related" data-widget-type="Switchable" data-sync-type="product_related">
      </div>
    </div>
  </div>
</div>
<script src="http://www.cc5igo.com/public/app/b2c/statics/js/product.js?2ddefa"></script><script>
var main = $('main');
var container = $('product_container');
var section = $('product_section');
priceControl.spec = {"decimals":"2","dec_point":".","thousands_sep":"","fonttend_decimal_type":"0","fonttend_decimal_remain":"2","sign":"\uffe5"};
//请求库存和价格
var Router = {
    price: function(id){
        return '/product-ajax_product_price-'+id+'';
    },
    stock: function(id) {
        return '/product-ajax_product_store-'+id+'';
    },
    basic: function(id) {
        return '/product-ajax_product_basic-'+id+'';
    }
};


var Query = function(url, options) {
    var self = this;
    this.send = function(url, options) {
        options = Object.merge({
            url: url,
            method: 'post',
            link: 'chain'
        }, options || {});
        return new Request(options).send();
    };
    this.update = function (url, update, options) {
        options = Object.merge({
            url: url,
            update: update,
            method: 'post',
            link: 'chain'
        }, options || {});
        new Request.HTML(options).send();
    };
    this.price = function(options) {
        options = Object.merge({
            method: 'get',
            onSuccess:function(rs) {
                rs = JSON.decode(rs);

                if(rs && Object.getLength(rs)) {
                    if(rs.error) {
                        return Message.error(rs.error);
                    }
                                        Object.each(rs, function(v, k) {
                        if(typeOf(v) === 'array') {
                            var s = '';
                            v.each(function(vi){
                                s += '<li>' + vi.name + '：' + priceControl.format(vi.price) + '</li>';
                            });
                            v = '<ul>' + s + '</ul>';
                        }
                        else {
                            v = priceControl.format(v);
                        }
                        var el = main.getElement('.action-' + k);
                        if(el) {
                            if(!v) el.getParent().hide();
                            else el.set('html', v);
                        }
                    });
                }
            }
        }, options || {});
        var url = Router.price(options.id);
        this.send.delay(0, this, [url, options]);
    };
    this.stock = function(options) {
        if(!container.getElement('.product-buy-quantity')) return;
        options = Object.merge({
            method: 'get',
            onSuccess:function(rs) {
                rs = JSON.decode(rs);
                if(rs && Object.getLength(rs)) {
                    if(rs.error) {
                        return Message.error(rs.error);
                    }
                    var tpl = '<span class="p-quantity"><a href="javascript:void(0);" class="btn-decrease">-</a><input type="text" name="goods[num]" class="action-quantity-input" value="1" min="1" max="{store}"><a href="javascript:void(0);" class="btn-increase">+</a></span> <span class="p-store">{title}</span><input type="hidden" name="stock" value="{store}">';
                    container.getElement('.product-buy-quantity .item-content').innerHTML = tpl.substitute(rs);
                    if(!rs.store) {
                        container.getElement('.action-quantity-input').disabled = true;
                        container.getElement('.product-buy-quantity').addClass('hide');
                        container.getElements('.action-buynow, .action-addtocart').addClass('hide');
                        container.getElement('.action-notify').removeClass('hide');
                                                container.getElement('.action-scanbuy').hide();
                                            }
                    else {
                                            }
                    if(!rs.title) {
                        container.getElements('.p-store').addClass('hide');
                    }
                }
            }
        }, options || {});
        var url = Router.stock(options.id);
        this.send.delay(300, this, [url, options]);
    };
};
Query = new Query;

attachAction('226');
bindQuantityEvent(container,setQuantity);

//== 为数量选择框绑定事件
function bindQuantityEvent(elements, callback) {
    elements = document.id(elements) || $$(elements);
    if(!elements && !elements.length) return;
    var value = '';
    elements.addEvents({
        //= 数量按钮
        'click:relay(.btn-decrease,.btn-increase)': function(e) {
            var input = this.getParent().getElement('.action-quantity-input');
            value = +input.value;
            input.value = this.hasClass('btn-decrease') ? value - 1 : value + 1;
            callback && callback(input, value);
        },
        //= 数量输入框
        'focus:relay(.action-quantity-input)': function(e){
            value = +this.value;
        },
        'change:relay(.action-quantity-input)': function(e) {
            callback && callback(this, value);
        }
    });
}
//== 获取商品数量值
function getQuantity(el, type) {
    return el.getElement('input[name=' + type + ']').value;
}
//== 设置商品数量
function setQuantity(input, value) {
    var type = 'product';
    var p = input.getParent('li');
    inputCheck(input, {min: input.get('min'), max: input.get('max'), 'default': value, store: getQuantity(p, 'stock'), callback: window.quantityCallback});
}
//== 商品数量输入框正确性检测
function inputCheck(input, options) {
    if(!input) return false;
    options = options || {};
    if(isNaN(options.min)) options.min = 1;
    if(isNaN(options.max)) options.max = 999999;
    options['default'] = options['default'] || options.min;
    var value = +input.value;
    var tips = new Tips(input);
    var pre = '';
    var msg = '';
    if(options.store && options.store - value <= 0) {
        pre = '库存有限，';
    }
    if(value < options.min) {
        input.value = options.min;
        msg = '此商品的最小购买数量为' + options.min + '件';
    }
    else if(value > options.max){
        input.value = options.max;
        msg = pre + '此商品最多只能购买' + options.max + '件';
    }
    else if(isNaN(value)) {
        input.value = options['default'];
        msg = '只允许输入数字';
    }
    if (msg) {
        tips.show(msg);
        return false;
    }
    tips.hide();
    if(options.callback) options.callback(input, options['default']);
    return true;
}

//== 商品详情图片延迟加载，并缩放到合适大小
var sectionWidth = section.getStyle('width').toInt();
new DataLazyLoad({containers: section,textarea:'action-lazyload',onCallback:function(){
    section.getElements('img').each(function(img){
        img.zoomImg(sectionWidth);
    });
}});

//== 异步加载商品详情tab
var param = {
        goodsDiscussInit:{update:section,name:'product_comment_init', onSuccess: function(){
        storeAjaxConfig('product_comment_init','.action-submit-reply', '.reply-list');
    }},
        goodsConsultInit:{update:section,name:'product_consult_init', onSuccess: function(){
        storeAjaxConfig('product_consult_init','.action-submit-reply', '.answer-list');
    }},
        goodsDiscuss:{append:section,name:'product_comment',require:'product_comment_init', onSuccess: function(){
        storeAjaxConfig('product_comment','.action-submit-reply', '.reply-list');
    }},
        goodsConsult:{append:section,name:'product_consult',require:'product_comment', onSuccess: function(){
        storeAjaxConfig('product_consult','.action-submit-reply', '.answer-list');
        storeAjaxConfig('product_consult','.action-submit-post', 'consult_content', true);
    }},
        goodsLink:{append:section,name:'product_related',require:'product_consult'}
},queue_items = [];
Object.each(param,function(v,k){
    queue_items.push(Object.append({
        url:'/product-'+k+'-215'
    },v));
});

var lazyload = new LayoutRequest(queue_items);

//== 为商品详情生成tab
section.getElements('.tags-hd').inject(new Element('.product-tags.clearfix').inject(section,'before'));
new Tabs('main', {
    eventType: 'click',
    triggersBox: '.product-tags',
    panels: '.product-section',
    onSwitch: function(e){
        queue_items.each(function(q){
            if(q.name === this.panels[e.currentIndex].id) {
                lazyload.request.call(lazyload, q);
            }
        }, this);
    }
});

//== 处理评论咨询回复异步请求
function storeAjaxConfig(cont,handle, area, type){
    // $(cont).getElements(trigger).each(function(handle){
        var update;
        var element = $(cont).getElement(handle);
        element.retrieve('_ajax_config') || element.store('_ajax_config', {
            onSuccess:function(rs) {
                rs = rs[0];
                if(rs&&rs.success&&rs.data){
                    update = $(area);
                    if(!update) {
                        var active = element.getParent('.mod').getElement('.active-handle');
                        update = active.getParent(area);
                        closeReply(element);
                    }
                    rs.html = rs.data.stripScripts(function(script){
                        rs.javascript = script;
                    });
                    update.set('html', rs.html);
                    Browser.exec(rs.javascript);

                    Message.success(rs.success);

                    if(type) location.href = '#' + cont;
                    resetForm(element.getParent('form'));
                    storeAjaxConfig(cont,handle, area, type);
                }
            }
        });
    // });
}
//== 重置提交表单
function resetForm(form) {
    form.reset();
    form.blur();
    try{
        form.getElement('img.verify-code').addClass('hide');
    }catch(e){}
}
//== 处理商品基本信息交互
function attachAction(id) {
    //== 价格和库存异步加载
    Query.price({id: id});
    Query.stock({id: id});
        //== 商品相册图放大镜
    window.addEvent('domready', function(){
        new AlbumZoom(container, {
                        zoomsSize:{
                x:400,
                y:300            }
        });
    });
    }

var ajax;
var state;
container.addEvents({
    'click:relay(.action-slidedown)': function(e){
        var panel = this.getParent('.switchable-panel');
        var top = panel.getElement('.panel-top');
        var cont = this.getParent('.product-promotion');
        if(!panel.hasClass('unfold')) {
            top && top.setStyle('height', 'auto');
            panel.addClass('unfold');
        }
        else {
            top && top.setStyle('height', 82);
            panel.removeClass('unfold');
        }

        toggleText(this.getElement('.icon'));
        toggleText(this.getElement('.text'));
    },
    'mouseenter:relay(.action-handle)': function(e){
        var menu = this.getNext('.pop-body');
        if(menu) {
            clearTimeout(menu.timer);
            this.addClass('active');
            menu.show();
        }
    },
    'mouseenter:relay(.pop-body)': function(e){
        clearTimeout(this.timer);
    },
    'mouseleave:relay(.pop-wrapper)': function(e) {
        var menu = this.getElement('.pop-body');
        menu.timer = (function(){
            this.getElement('.active').removeClass('active');
            menu.hide();
        }).delay(200,this);
    },
    'click:relay(.pop-close)': function(e) {
        this.getParent('.pop-body').hide();
    },
    'click:relay(.action-buynow)': function(e) {
        var form = this.getParent('form');
        form.getElement('input[name=btype]').value = 'is_fastbuy';
        form.store('target', form.target).target = '';
                this.retrieve('_ajax_config') || this.store('_ajax_config', {
            progress: function(rs) {
                if(rs.error) {
                    return Message.error(rs.error);
                }
                miniPassport('/cart-loginBuy-true', function(dialog){
                    this.removeClass('disabled');
                }.bind(this));
            }.bind(this)
        });
            },
    'click:relay(.action-addtocart)': function () {
        var form = this.getParent('form');
        var target = form.retrieve('target');
        form.getElement('input[name=btype]').value = '';
        if(target) form.target = target;
    },
    'click:relay(.action-notify)': function(e) {
        var dialog = new Dialog($('product_notify').wrapped(), {
            title:'到货通知',
            width: 400,
            modal: {
                'class': 'cover'
            },
            onLoad: function(){
                var content = this.content;
                content.getElement('[rel=_request]').store('_ajax_config',{onSuccess:function(rs){
                    if(rs && rs[0]) {
                        if(rs[0]['true']) {
                            content.getElement('.product-notify').innerHTML = '<div class="success"><i class="icon">&#x25;</i>联系方式已经成功提交，到货后会立刻通知您。</div>';
                            dialog.hide.delay(3000, dialog);
                        }
                    }
                }});
            }
        });
    },
    'click:relay(.spec-attr)': function(e){
        if(this.hasClass('selected')) return;
        var a = this.getElement('a');
        var url = a.href;
        var id = a.rel;
        if(!id) return;
        if (window.history && history.pushState) {
            e.stop();
            /*html5 history manage*/
            if(ajax){
                ajax.cancel();
            }
            else {
                state = {title: document.title, html: container.innerHTML, url: location.href, id: id};
            }
            ajax = Query.send(Router.basic(id), {
                method: 'post',
                onSuccess: function(rs) {
                    try{
                        rs = JSON.decode(rs);
                        if(rs.error) {
                            return Message.error(rs.error);
                        }
                    }catch(e) {
                        updateBasic(rs, id, url);
                    }
                }
            });
        }
    }
});
if ('onpopstate' in window) {
    window.onpopstate = function(event){
        if(ajax == null) return;
        var data;
        if(event && event.state){
            data = event.state;
        }else{
            data = state;
        }
        document.title = data.title;
        updateBasic(data.html, data.id);
    }
}

function updateBasic(rs, id, url) {
    container.innerHTML = rs;
    attachAction(id);
        url && history.pushState({url: url, title: document.title, html: rs, id:id}, document.title, url);
    //迷你购物车
    formToCart();
}

$(document.body).addEvents({
    'click:relay(.btn-caution)': function(e) {
        if(this.hasClass('disabled')) return;
        var data = this.getParent('.form');
        if(!validate(data, 'all')) {
            e.stop();
            return;
        }
    },
    'click:relay(.inter-handle)': function(e) {
        e.preventDefault();
        var parent = this.getParent('.mod');
        var item = this.getParent('.comment-item') || this.getParent('.consult-item');
        var action = this.getParent('.reply-action') || this.getParent('.answer-action');
        var active = action.hasClass('active-handle');
        var reply = parent.getElement('.action-post-reply');
        var toggle = parent.getElement('.active-handle');
        if(toggle) {
            closeReply(toggle);
        }
        var id = item.getElement('input[name=id]').value;
        reply.getElement('input[name=id]').value = id;
        reply.removeClass('hide').setStyles({
            width: action.getSize().x - reply.getPatch('padding','border').x
        }).position({
            target:this,
            from: 'rt',
            to: 'rb',
            offset:{
                y: 8
            },
            intoView: true
        });
        if(active){
            closeReply(this);
            // reply.addClass('hide');
        }
        else{
            openReply(this);
        }

        /*var parent = this.getParent('.comment-list') || this.getParent('.consult-content');
        var item = this.getParent('.comment-item') || this.getParent('.consult-item');
        var cont = item.getElement('.action-post-reply') || this.getParent('.mod').getElement('.action-post-reply').inject(this.getParent(), 'after');
        var act = this.hasClass('active-handle');
        var id = item.getElement('input[name=id]').value;
        parent.getElement('.active-handle') && parent.getElement('.active-handle').removeClass('active-handle');
        cont.getElement('input[name=id]').value = id;
        if(act) {
            cont.addClass('hide');
        }else {
            this.addClass('active-handle');
            cont.removeClass('hide');
        }*/
    },
    'click:relay(.action-close-reply)': function(e) {
        e && e.preventDefault();
        closeReply(this);
    },
    'focus:relay(.action-code-form)': function(e) {
        var code = this.getElement('img.verify-code');
        if(code && !code.isVisible()) {
            code.removeClass('hide');
                    }
    },
    'click:relay(.auto-change-verify-handle)': function(e){
        e.stop();
        changeVerify(this);
    },
    'click:relay(.pageview .flip)': function(e){
        e.stop();
        Query.update(this.href, this.getParent('.action-content-list'));
    },
    'inputchange:relay(.action-filled-textarea)': function(){
        var p = this.getParent();
        var max = getVal(p, '.word-limit');
        var cur = p.getElement('.word-count .current');
        if(this.value.length > max) {
            this.value = this.value.substr(0, max);
            Message.error('内容最多输入' + max + '字');
        }
        cur.set('text', this.value.length);
    },
    'click:relay(.action-consult-trigger)': function(e){
        e.preventDefault();
    }
});

function openReply(el) {
    var parent = el.getParent('.mod');
    var action = el.getParent('.reply-action') || el.getParent('.answer-action');
    var reply = parent.getElement('.action-post-reply');
    reply.removeClass('hide');
    action.addClass('active-handle');
    action.setStyle('height', parseInt(action.getStyle('height')) + reply.getSize().y);
}
function closeReply(el) {
    var parent = el.getParent('.comment-list') || el.getParent('.mod');
    var reply = parent.getElement('.action-post-reply');
    var action = parent.getElement('.active-handle');
    reply.addClass('hide');
    if(action) {
        action.removeClass('active-handle');
        action.setStyle('height', '');
    }
}

function notice(msg, inject, where, type) {
    var el = new Element('div.notice' + (type ? '.' + type : ''), {html:msg}).inject(inject, where);
    el.destroy.delay(3000,el);
}
notice.success = function(msg, inject, where) {
    notice('<q class="icon">&#x25;</q>' + msg, inject, where, 'success');
};

function getVal(p,c,i) {
    if(!c) return $(p).get('text');
    p = $(p).getElement(c).get('text');
    if(!i) return p;
    return Number.from(p);
}
function toggleText(el, attr) {
    attr = attr || 'data-toggle';
    var a = el.get(attr);
    var b = el.get('text');
    el.set(attr, b).set('text', a);
}

withBrowserStore(function(browserStore){
    browserStore.get('history',function(history){
        history=JSON.decode(history);
        if(!history||typeOf(history)!=='array') history=[];
        if(history.length>=40) history.pop();
        price = '1.100';
        if( price > 0 ) {
        	price = '￥1.10';
        }else{
        	price = '￥1.10';
        }
        var newHst = {
            'goodsId':'226',
            'goodsName':'双汇火腿肠泡面拍档45g 休闲零食小吃 配方便面 香肠',
            'goodsImg':'http://cc5igo-images.s3.mall.ekaidian.com/60/37/90/614b79f2ce84af9880d8243d85ceca84.jpg?1426139599#h',
            'price':price,
            'viewTime':+new Date()
        };
        if(history.length) {
            for(var i = history.length; i --;) {
                if(history[i]['goodsId'] == newHst['goodsId']) {
                    history.splice(i, 1);
                    break;
                }
            }
        }
        history.unshift(newHst);

        browserStore.set('history', JSON.encode(history));
    });
});
</script>
</div>
	</div>
</div>

<script type="text/javascript" src="http://v1.ujian.cc/code/ujian.js?type=slide"></script>

</body></html>
