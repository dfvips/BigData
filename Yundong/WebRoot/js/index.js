(function($) {
	$.extend({
		changecss:function(){
			  if($.IsPC()==false){
			    $("#mycss").attr("href",'css/m.index.css');
			    $("#bgbg").attr("src",'images/m.background.png');
			  }else{
			    $("#mycss").attr("href",'css/index.css');
			    $("#bgbg").attr("src",'images/background.png');
			  }
		},
		IsPC:function(){
		    let userAgentInfo = navigator.userAgent;
		    let Agents = ["Android", "iPhone",
		                "SymbianOS", "Windows Phone", "iPod"];
		    let flag = true;
		    for (let v = 0; v < Agents.length; v++) {
		        if (userAgentInfo.indexOf(Agents[v]) > 0) {
		            flag = false;
		            break;
		        }
		    }
		    return flag;
		},
		initEchart:function(lang){
		  let myChart = echarts.init(document.getElementById('main'));
		  let name1;
		  let name2;
		  let name3;
		  let name4;
		  let stack;
		  if(lang=="zh"){
		    name1='纯露';
		    name2='复方精油';
		    name3='爽身粉';
		    name4='男士面膜';
		    stack='访客指数';
		  }else{
		    name1='Chunlu';
		    name2='Compound essential oil';
		    name3='Talcum powder';
		    name4='Men\'s Mask';
		    stack='Visitor index';
		  }
		  let option= {
		      // title: {
		      //     text: '行业趋势'
		      // },
		      tooltip: {
		          trigger: 'axis'
		      },
		      legend: {
		          data: [name1, name2, name3, name4]
		      },
		      grid: {
		          left: '3%',
		          right: '4%',
		          bottom: '3%',
		          containLabel: true
		      },
		      // toolbox: {
		      //     feature: {
		      //         saveAsImage: {}
		      //     }
		      // },
		      xAxis: {
		          type: 'category',
		          boundaryGap: false,
		          data: ['08-03', '08-04', '08-05', '08-06', '08-07', '08-08', '08-09']
		      },
		      yAxis: {
		          type: 'value'
		      },
		      series: [
		          {
		              name: name1,
		              type: 'line',
		              stack: stack,
		              data: [242819, 207258, 216149, 216325, 230734, 236069, 252099]
		          },
		          {
		              name: name2,
		              type: 'line',
		              stack: stack,
		              data: [787849,802183, 879331, 923533, 884106, 861436, 894252]
		          },
		          {
		              name: name3,
		              type: 'line',
		              stack: stack,
		              data: [139050, 127837, 122427, 118256, 107827, 97435, 101187]
		          },
		          {
		              name: name4,
		              type: 'line',
		              stack: stack,
		              data: [421577, 388704, 432994, 430857, 411841, 386209, 429151]
		          }
		      ]
		  }
		  myChart.clear();
		  myChart.setOption(option);
		},
		changlang:function(lang){
		 if(lang=="zh"){
		       $(".translate:eq(0)").attr("id","en");
		       // $("#main2").css("display","none");
		       // $("#main1").css("display","block");
		       $("#abab").css("margin-top","0");
		      if($.IsPC()==false){
		        $("#content>h1").css({"font-size":"1.2em"});
		        $("#content>p").css({"font-size":".68em"});
		      }
		      $.initEchart("zh");
		   }else{
		       $(".translate:eq(0)").attr("id","zh");
		       // $("#main1").css("display","none");
		       // $("#main2").css("display","block");
		        if($.IsPC()==true){
		            $("#abab").css("margin-top","80px");
		        }
		       if($.IsPC()==false){
		        $("#content>h1").css({"font-size":".9em"});
		        $("#content>p").css({"font-size":".58em"});
		      }
		      $.initEchart("en");
		   }
		}
	});
})(jQuery);
let appLang = {
  "en": {
    "Website": "YunDong Data",
    "Language": "Chinese",
    "About": "About Us",
    "Des": "Analysis of tiktok short live video and live goods data",
    "Content": "By using big data to locate the vertical field of popular goods, live broadcast, effectively help <br>e-commerce operations, content positioning, forecasting burst and optimize goods.",
    "Start": "Start",
    "Showadv":"Advantage display",
    "Box1_1":"Data visualization",
    "Box1_2":"The massive data will be converted into visual charts,<br>more convenient, fast to read.",
    "Box2_1":"Functional modularization",
    "Box2_2":"Breaking down data into smaller units is<br>more efficient and maintainable.",
    "Box3_1":"Update real-time",
    "Box3_2":"After a period of time, the data will be automatically updated to ensure that the data is timely, accurate and reliable.",
    "Slog":"Entrepreneurship is not easy<br>YunDong will do all we can to assist you",
    "tip1":"Easy to find explosive <br> e-commerce data",
    "li1_1":"Intuitive sales data",
    "li1_2":"Excavate high quality commodities",
    "li1_3":"Analyze industry wind direction",
    "li1_4":"In-depth optimization of goods",
    "tip2":"Multi-dimensional and <br> multi-index ranking",
    "li2_1":"Subdivide 96 categories ranking",
    "li2_2":"Discover potential products",
    "li2_3":"Hot goods list and buy group <br>&nbsp&nbsp soaring list",
    "para":"YunDong Data is a big data analysis platform, in data mining, data analysis, <br>data processing and other aspects of the adoption of a new concept,<br> Provide multi-dimensional and multi-index e-commerce industry data <br>and automated data monitoring, update, for e-commerce operations, <br>product selection, product optimization to provide guiding proposal.",
    "t1":"Rank",
    "t2":"Product Name",
    "t3":"Order index",
    "t4":"Trading promotion index",
    "t5":"Visitor index",
    "td1":"Green tea cleansing mask mud to black shrink pores deep clean mud film smear mask students",
    "td2":"Medical beauty cold apply medical mask whitening moisturizing acne anti-sensitive muscle repair swelling anti-inflammatory students and girls",
    "td3":"【loss of low price】 whitening mask moisturizing moisturizing contraction pores tight spots dilute pockmarked India students and girls",
    "td4":"Natural 1000g small particles seaweed mask whitening moisturizing oil control Clean shrink pores acne freckle students",
    "td5":"【buy 1 get 2】 collagen good night frozen film lazy people do not wash smear sleep mask female night moisturizing hydrating",
    "td6":"Collagen good night frozen film moisturizing nourishing repair light lines wrinkle compact free wash lazy sleep mask",
    "td7":"&lt;Stay up late necessary&gt;Good night Frozen film Lazy people Wash-free sleep collagen mask essence Whitening Hydrating Repair",
    "td8":"Cucumber moisturizing mask whitening spot oil control to blackhead desalination pock marks contraction pores students men and women"
  },
  "zh": {
    "Website": "云洞数据",
    "Language": "英文",
    "About": "关于我们",
    "Des": "抖音短视频、直播带货数据分析",
    "Content": "运用大数据定位垂直领域热门商品、直播，有效助力<br>电商运营、内容定位，预测爆款，优化商品。",
    "Start": "从此起步",
    "Showadv":"优势展示",
    "Box1_1":"数据可视化",
    "Box1_2":"将海量的数据整理转换成可视化的<br>图表，更方便、快速读懂",
    "Box2_1":"功能模块化",
    "Box2_2":"将众多数据拆分成一个个小功能的单元<br>更高效、可维护",
    "Box3_1":"更新实时化",
    "Box3_2":"数据经过一段时间后，将自动进行更新<br>保障数据即时、准确、可靠",
    "Slog":"创业实不易，云洞来助力",
    "tip1":"轻松发现爆款电商数据",
    "li1_1":"直观销量数据",
    "li1_2":"挖掘优质商品",
    "li1_3":"分析行业风向",
    "li1_4":"深度优化商品",
    "tip2":"多维度多指标排行榜",
    "li2_1":"细分96个类目排行",
    "li2_2":"发现潜力产品",
    "li2_3":"热门商品榜、拼团飙升榜",
    "para":"云洞数据是一个大数据分析的平台，<br>在数据挖掘、数据分析、数据处理等方面都采用了全新的理念，<br>提供多维度多指标电商行业数据和自动化数据监控、更新，<br>为电商运营、选品、产品优化提供指导性建议。",
    "t1":"排名",
    "t2":"商品名称",
    "t3":"订单指数",
    "t4":"交易提升指数",
    "t5":"访客指数",
    "td1":"绿茶清洁面膜泥去黑头收缩毛孔深层清洁泥膜涂抹式面膜学生",
    "td2":"医美冷敷贴医用面膜美白补水保湿祛痘抗敏感肌修复红肿消炎学生女",
    "td3":"【亏本低价】美白面膜补水保湿收缩毛孔紧致淡斑淡化痘印学生女",
    "td4":"天然1000g小颗粒海藻面膜美白补水控油清洁收缩毛孔祛痘祛斑学生",
    "td5":"【买1送2】胶原蛋白晚安冻膜懒人免洗涂抹睡眠面膜女夜间保湿补水",
    "td6":"胶原蛋白晚安冻膜补水保湿滋养修护淡纹抗皱紧致免洗懒人睡眠面膜",
    "td7":"&lt;熬夜必备&gt;晚安冻膜懒人免洗睡眠胶原蛋白面膜精华美白补水修护",
    "td8":"小黄瓜补水保湿面膜美白淡斑控油去黑头淡化痘印收缩毛孔学生男女"
  }
};
$('.animate').scrolla({
    mobile: true, 
    once: true
});
let lang = "zh";
if('localStorage' in window){
   lang = localStorage.getItem('lang') || navigator.language.slice(0, 2);
   if (!Object.keys(appLang).includes(lang)) lang = 'en';
   $.changlang(lang);
}

$(document).ready(function() {
  $(".lang").each(function(index, element) {
    $(this).html(appLang[lang][$(this).attr("key")]);
    $.changecss();
    $.initEchart(lang);
  });
});

// get/set the selected language
$(".translate").click(function() {
  let lang = $(this).attr("id");
  $.changlang(lang);
  // update localStorage key
  if('localStorage' in window){
    localStorage.setItem('lang', lang);
  }

  $(".lang").each(function(index, element) {
    $(this).html(appLang[lang][$(this).attr("key")]);
  });
});

$("#content>button").click(function(){
	window.location.href="dashboard";
});

$("#title_bar>p").hover(function(){
	$(this).addClass("active");
    $("#title_bar>span:nth-child(1)").addClass("active");
},function(){
	$(this).removeClass("active");
    $("#title_bar>span:nth-child(1)").removeClass("active");
});
$("#title_bar>span:nth-child(1)").hover(function(){
	$(this).addClass("active");
    $("#title_bar>p").addClass("active");
},function(){
	$(this).removeClass("active");
    $("#title_bar>p").removeClass("active");
});
$(document).scroll(function() {
   let scroH = $(document).scrollTop(); //滚动高度
   let viewH = $(window).height(); //可见高度
   let contentH = $(document).height(); //内容高度
   let h=100;
   if($.IsPC()==false){
    h=10
   }
   if(scroH >h){ //距离顶部大于100px时
	   	$("#title_bar").addClass("scroll");
	   	$("#title_bar>p").addClass("scroll");
	   	$(".bar_right>span").addClass("scroll");
    }else{
	   	$("#title_bar").removeClass("scroll");
	   	$("#title_bar>p").removeClass("scroll");
	   	$(".bar_right>span").removeClass("scroll");
    }
});
$("#about").click(function(){
  $("html,body").animate({scrollTop:$("#des").offset().top},500);
});
// $(window).resize(function(){
//   changecss();
// })