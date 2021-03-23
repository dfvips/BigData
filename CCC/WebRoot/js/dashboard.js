let toggle=false;
let myChart;
let clickNum=0;
(function($) {
	$.extend({
		sendreq:function(catId,dataRange){
			$.ajax({
				url : "getIndustryTrend?catId="+catId+"&dateRange="+dataRange,
				dataType : "json",
				async : false,
				type : "GET",
				success : function(data) {
					let result = data.result;
					let visitorNumArray = new Array();
					let clickNumArray = new Array();
					let searchNumArray = new Array();
					let dateArray = new Array();
					let catName = data.catName;
					for (let i = 0; i < result.length; i++) {
						let obj = result[i];
						visitorNumArray[i]=obj.visitorNum;
						clickNumArray[i]=obj.clickNum;
						searchNumArray[i]=obj.searchNum;
						dateArray[i]=obj.date;
					}
				  myChart = echarts.init(document.getElementById('main'));
				  $.chartssize(document.getElementById('boxParent'),document.getElementById('main'));
				  let option= {
//					      title: {
//					           text: catName
//					       },
					      tooltip: {
					          trigger: 'axis'
					      },
					      legend: {
					          data: ['访客指数', '搜索指数', '点击指数']
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
					          data: dateArray
					      },
					      yAxis: {
					          type: 'value'
					      },
					      series: [
					          {
					              name: '访客指数',
					              type: 'line',
					              data: visitorNumArray,
					              itemStyle : {
					                  normal : {
					                    color:'#008000',
					                    lineStyle:{
					                      color:'#008000'
					                    }
					                  }
					              }
					          },
					          {
					              name: '搜索指数',
					              type: 'line',
					              data: searchNumArray,
					              itemStyle : {
					                  normal : {
					                    color:'#86CCA0',
					                    lineStyle:{
					                      color:'#86CCA0'
					                    }
					                  }
					              }
					          },
					          {
					              name: '点击指数',
					              type: 'line',
					              data: clickNumArray,
					              itemStyle : {
					                  normal : {
					                    color:'#8884D8',
					                    lineStyle:{
					                      color:'#8884D8'
					                    }
					                  }
					              }
					          }
					      ]
					  }
					  myChart.clear();
					  myChart.setOption(option);
				},
				error : function() {
					//请求出错处理 
					console.log("请求异常");
				}
			});
		},
		chartssize:function(container, charts) {
		      function getStyle(el, name){
		        if (window.getComputedStyle) {
		          return window.getComputedStyle(el, null);
		        } else {
		          return el.currentStyle;
		        }
		      }
		      let wi = getStyle(container, 'width').width;
		      let hi = getStyle(container, 'height').height;
		      charts.style.height = hi;
	    },
	    sendcat3:function(cat1Id,day){
	    	$.ajax({
	    		url : "getCategoryinfo?catId="+cat1Id,
	    		dataType : "json",
	    		async : false,
	    		type : "GET",
	    		success : function(data) {
	    			let array=data.result;
	    			let html="";
	    			for (var i = 0; i < array.length; i++) {
	    				let obj=array[i];
	    				let catId=obj.catId;
	    				let catName=obj.catName;
	    				html+="<li id="+catId+">"+catName+"</li>";
	    			}
//	    			console.log(data);
	    			$("#selectFour").val(array[0].catName);
	    			$("#selectFour").attr("catId",array[0].catId);
	    			$(".selectFour").html(html);
					$.sendreq(array[0].catId, day);
	    			$(".selectFour>li").click(function(){
	    				let catId=$(this).attr("id");
	    				let text = $(this).text();
	    				let id = $(this).parent().attr("class");
	    				$("#"+id).val(text);
	    				$("."+id).css({"visibility":"hidden"});
	    				$("#"+id).attr("catId",catId);
	    				let day=$("#selectOne").attr("day");
	    				$.sendreq(catId, day);
	    			});
	    		},
	    		error : function() {
	    			//请求出错处理 
	    			console.log("请求异常");
	    		}
	    	});
	    },
	    sendcat2:function(){
			$.ajax({
				url : "getCategoryinfo?catId=1",
				dataType : "json",
				async : false,
				type : "GET",
				success : function(data) {
					let array=data.result;
					let html="";
					for (var i = 0; i < array.length; i++) {
						let obj=array[i];
						let cat1Id=obj.cat1Id;
						let cat1Name=obj.cat1Name;
						html+="<li id="+cat1Id+">"+cat1Name+"</li>";
					}
					$(".selectThree").html(html);
					$("#selectThree").val(array[0].cat1Name);
					$("#selectThree").attr("catId",array[0].cat1Id);
					let day=$("#selectOne").attr("day");
					$.sendcat3(array[0].cat1Id,day);	
					$(".selectThree>li").click(function(){
						let catId=$(this).attr("id");
						let text = $(this).text();
						let id = $(this).parent().attr("class");
						$("#"+id).val(text);
						$("."+id).css({"visibility":"hidden"});
						$("#"+id).attr("catId",catId);
						let day=$("#selectOne").attr("day");
						$.sendcat3(catId,day);	
					});
				},
				error : function() {
					//请求出错处理 
					console.log("请求异常");
				}
			});
	    },
	    getHotwordRank:function(catId,type,day){
	    	$.ajax({
	    		url : "getHotwordRank?catId="+catId+"&type="+type+"&day="+day,
	    		dataType : "json",
	    		async : false,
	    		type : "GET",
	    		success : function(data) {
	    			let array=data.result;
	    			let html = "";
	    			for (let i = 0; i < array.length; i++) {
	    				let obj=array[i];
	    				let word=obj.word;
	    				let pv=obj.pv;
	    				let ctr=obj.ctr;
	    				let cvr=obj.cvr;
	    				let competeValue=obj.competeValue;
	    				let imprAvgBid=obj.imprAvgBid;
	    				let clickNum=obj.clickNum;
	    				html += '<tr><td>'+(i+1)+' </td>'+'<td>'+word+' </td><td>'+pv+' </td><td>'+clickNum+' </td><td>'+(ctr*100).toFixed(2)+"%"+' </td><td>'+(cvr*100).toFixed(2)+"%"+' </td><td>'+competeValue+' </td><td>'+(imprAvgBid/1000).toFixed(2)+' </td></tr>';
	    			}
	    			$("#hot>div>table>tbody").html(html);
	    		},
	    		error : function() {
	    			//请求出错处理 
	    			console.log("请求异常");
	    		}
	    	});
	    },	    
	    sendcat5:function(cat1Id,day){
	    	$.ajax({
	    		url : "getCategoryinfo?catId="+cat1Id,
	    		dataType : "json",
	    		async : false,
	    		type : "GET",
	    		success : function(data) {
	    			let array=data.result;
	    			let html="";
	    			for (var i = 0; i < array.length; i++) {
	    				let obj=array[i];
	    				let catId=obj.catId;
	    				let catName=obj.catName;
	    				html+="<li id="+catId+">"+catName+"</li>";
	    			}
//	    			console.log(data);
	    			$("#selectFourTab").val(array[0].catName);
	    			$("#selectFourTab").attr("catId",array[0].catId);
	    			$(".selectFourTab").html(html);
//					$.sendreq(array[0].catId, day);
	    			$.getHotwordRank(array[0].catId,0,day);
	    			$(".selectFourTab>li").click(function(){
	    				let catId=$(this).attr("id");
	    				let text = $(this).text();
	    				let id = $(this).parent().attr("class");
	    				$("#"+id).val(text);
	    				$("."+id).css({"visibility":"hidden"});
	    				$("#"+id).attr("catId",catId);
	    				let day=$("#selectOneTab").attr("day");
	    				$.getHotwordRank(catId,0,day);
	    			});
	    		},
	    		error : function() {
	    			//请求出错处理 
	    			console.log("请求异常");
	    		}
	    	});
	    },
	    sendcat4:function(){
			$.ajax({
				url : "getCategoryinfo?catId=1",
				dataType : "json",
				async : false,
				type : "GET",
				success : function(data) {
					let array=data.result;
					let html="";
					for (var i = 0; i < array.length; i++) {
						let obj=array[i];
						let cat1Id=obj.cat1Id;
						let cat1Name=obj.cat1Name;
						html+="<li id="+cat1Id+">"+cat1Name+"</li>";
					}
					$(".selectThreeTab").html(html);
					$("#selectThreeTab").val(array[0].cat1Name);
					$("#selectThreeTab").attr("catId",array[0].cat1Id);
					let day=$("#selectOneTab").attr("day");
					$.sendcat5(array[0].cat1Id,day);	
					$(".selectThreeTab>li").click(function(){
						let catId=$(this).attr("id");
						let text = $(this).text();
						let id = $(this).parent().attr("class");
						$("#"+id).val(text);
						$("."+id).css({"visibility":"hidden"});
						$("#"+id).attr("catId",catId);
						let day=$("#selectOneTab").attr("day");
						$.sendcat5(catId,day);	
						console.log(catId+"   "+day);
					});
				},
				error : function() {
					//请求出错处理 
					console.log("请求异常");
				}
			});
	    }
	});
})(jQuery);
$("#nav_left").hover(function(){
	$("#logo>.iconfont").addClass("active");
    $("#logo>p").addClass("active");
    $("#nav_left>span").addClass("active");
},function(){
	$("#logo>.iconfont").removeClass("active");
    $("#logo>p").removeClass("active");
    $("#nav_left>span").removeClass("active");
});
$("#search").hover(function(){
	$("#search").addClass("active");
	$("#search>.iconfont").addClass("active");
},function(){
	if($("#search>input").is(':focus')==false){
		$("#search").removeClass("active");
		$("#search>.iconfont").removeClass("active");
	}
});
$("#search>input").focus(function(){
	$("#search").addClass("active");
	$("#search>.iconfont").addClass("active");
});
$("#search>input").blur(function(){
	$("#search").removeClass("active");
	$("#search>.iconfont").removeClass("active");
});
$("#r_right_l").hover(function(){
	$("#r_right_l>span").addClass("active");
},function(){
	$("#r_right_l>span").removeClass("active");
});
$("#home").click(function(){
	window.location.href="/";
});
$("#console").click(function(){
    if(toggle){
        $("aside").addClass("active");
    }else{
        $("aside").removeClass("active");
    }
    toggle=!toggle;
});
$("#inner>p").click(function(){
	$("#inner>p").removeClass("active");
	$(this).addClass("active");
	if($(this).text().indexOf("行业趋势")!=-1){
		$("#hot").css({"display":"none"});
		$("#trend").css({"display":"block"});
//		$.sendreq();
		$.sendcat2();
	}else if($(this).text().indexOf("热词热点")!=-1){
		$("#trend").css({"display":"none"});
		$("#hot").css({"display":"block"});
	}
});
$("#selectBox>div").click(function(){
	let id=$(this).children(1).attr("id");
	if($("."+id).css('visibility') == 'visible') {   
		$("."+id).css({"visibility":"hidden"});
	}else{
		$("#optionBox>ul").css({"visibility":"hidden"});
		$("."+id).css({"visibility":"visible"});
	}
});
$("#options>li").click(function(){
	let text = $(this).text();
	let id = $(this).parent().attr("class");
	$("#"+id).val(text);
	$("."+id).css({"visibility":"hidden"});
});
$("#options>li").click(function(){
	let text = $(this).text();
	let id = $(this).parent().attr("class");
	$("#"+id).val(text);
	$("."+id).css({"visibility":"hidden"});
});
$(".selectOne>li").click(function(){
	let day=$(this).attr("day");
	$("#selectOne").attr("day",day);
	let text = $(this).text();
	let id = $(this).parent().attr("class");
	$("#"+id).val(text);
	$("."+id).css({"visibility":"hidden"});
	let catId=$("#selectFour").attr("catId");
	$.sendreq(catId, day);
});
$(".selectOneTab>li").click(function(){
	let day=$(this).attr("day");
	$("#selectOneTab").attr("day",day);
	let text = $(this).text();
	let id = $(this).parent().attr("class");
	$("#"+id).val(text);
	$("."+id).css({"visibility":"hidden"});
	let catId=$("#selectFourTab").attr("catId");
	$.getHotwordRank(catId,0,day);
});
$("#inner>p").eq(2).click(function(){
	$.getHotwordRank(0,0,1);
	$("#selectThreeTab").val("");
	$("#selectFourTab").val("");
});
$("#pv").click(function(){
	let catId=$("#selectFourTab").attr("catId");
	let day=$("#selectOneTab").attr("day");
	$.getHotwordRank(catId,2,day);
});
$("#clickNum").click(function(){
	let catId=$("#selectFourTab").attr("catId");
	let day=$("#selectOneTab").attr("day");
	$.getHotwordRank(catId,0,day);
});
$("#ctr").click(function(){
	let catId=$("#selectFourTab").attr("catId");
	let day=$("#selectOneTab").attr("day");
	$.getHotwordRank(catId,3,day);
});
$("#cvr").click(function(){
	let catId=$("#selectFourTab").attr("catId");
	let day=$("#selectOneTab").attr("day");
	$.getHotwordRank(catId,4,day);
});
$("#competeValue").click(function(){
	let catId=$("#selectFourTab").attr("catId");
	let day=$("#selectOneTab").attr("day");
	$.getHotwordRank(catId,1,day);
});
$(document).ready(function(){
	$.sendcat2();
	$.sendcat4();
});
window.onresize = function(){
    myChart.resize()
}