package util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import servlet.queryGoodsRank;

// "{"status":"success","code":200,"api":"wdetail","v":"6.0","data":{"seller":{"shopCard":"本店共113件宝贝在热卖","shopName":"施耐德电气官方旗舰店","evaluates":[{"score":"4.9 ","tmallLevelTextColor":"#999999","level":"1","levelText":"高","levelBackgroundColor":"#EEEEEE","levelTextColor":"#999999","title":"宝贝描述","type":"desc","tmallLevelBackgroundColor":"#EEEEEE"},{"score":"4.8 ","tmallLevelTextColor":"#999999","level":"0","levelText":"平","levelBackgroundColor":"#EEEEEE","levelTextColor":"#999999","title":"卖家服务","type":"serv","tmallLevelBackgroundColor":"#EEEEEE"},{"score":"4.8 ","tmallLevelTextColor":"#999999","level":"0","levelText":"平","levelBackgroundColor":"#EEEEEE","levelTextColor":"#999999","title":"物流服务","type":"post","tmallLevelBackgroundColor":"#EEEEEE"}],"entranceList":[{"borderColor":"#59ffffff","backgroundColor":"#59000000","action":[{"params":{"url":"//shop.m.taobao.com/shop/shop_index.htm?user_id=1132886103&item_id=546416107509&currentClickTime=-1"},"key":"open_url"},{"params":{"trackParams":{"spm":"a.2141.7631564.shoppage"},"trackName":"Button-NewShopcard-ShopPage"},"key":"user_track"}],"text":"进店逛逛","textColor":"#ffffff"},{"borderColor":"#59ffffff","backgroundColor":"#59000000","action":[{"params":{"url":"//shop.m.taobao.com/shop/shop_index.htm?user_id=1132886103&item_id=546416107509&shop_navi=allitems"},"key":"open_url"},{"params":{"trackParams":{"spm":"a.2141.7631564.allitem"},"trackName":"Button-NewShopcard-AllItem"},"key":"user_track"}],"text":"全部宝贝","textColor":"#ffffff"}],"showShopLinkIcon":false,"simpleShopDOStatus":"1","fbt2User":"施耐德电气官方旗舰店","taoShopUrl":"//shop.m.taobao.com/shop/shop_index.htm?user_id=1132886103&item_id=546416107509","creditLevel":"16","evaluates2":[{"score":"4.9 ","titleColor":"#ffffff","level":"1","scoreTextColor":"#ffffff","levelText":"高","levelTextColor":"#f0f0f0","title":"宝贝描述","type":"desc"},{"score":"4.8 ","titleColor":"#ffffff","level":"0","scoreTextColor":"#ffffff","levelText":"平","levelTextColor":"#f0f0f0","title":"卖家服务","type":"serv"},{"score":"4.8 ","titleColor":"#ffffff","level":"0","scoreTextColor":"#ffffff","levelText":"平","levelTextColor":"#f0f0f0","title":"物流服务","type":"post"}],"atmosphereMaskColor":"#59000000","allItemCount":"113","creditLevelIcon":"//gw.alicdn.com/tfs/TB1QoJUIwmTBuNjy1XbXXaMrVXa-84-36.png?getAvatar=avatar","atmosphereColor":"#ffffff","shopId":"102024564","starts":"2013-01-21 16:14:08","brandIconRatio":"7.3","sellerNick":"施耐德电气官方旗舰店","goodRatePercentage":"100.00%","shopIcon":"//img.alicdn.com/imgextra//f4/d1/TB1peoWPFXXXXb7XVXXSutbFXXX.jpg","shopUrl":"tmall://page.tm/shop?item_id=546416107509&shopId=102024564","userId":"1132886103","brandIcon":"//gw.alicdn.com/tfs/TB10YPrjbj1gK0jSZFOXXc7GpXa-368-52.png?getAvatar=avatar","shopVersion":"0","fans":"31.7万","atmophereMask":true,"atmosphereImg":"https://img.alicdn.com/imgextra/i2/1132886103/O1CN01xSdsEQ1uxDgghYKir_!!1132886103.jpg","shopType":"B","sellerType":"B","shopTextColor":"#ffffff"},"propsCut":"品牌 型号 额定电流 灭弧方式 漏电保护器类型 极数 ","item":{"images":["//img.alicdn.com/imgextra/i3/1132886103/O1CN01StFQKz1uxDoSd7xNb_!!0-item_pic.jpg","//img.alicdn.com/imgextra/i1/1132886103/O1CN01OgHPam1uxDmKp3aOv_!!0-item_pic.jpg","//img.alicdn.com/imgextra/i3/1132886103/TB2wt8NkHZnBKNjSZFKXXcGOVXa_!!1132886103.jpg","//img.alicdn.com/imgextra/i3/1132886103/O1CN01eFSsRM1uxDguiclHS_!!1132886103.jpg","//img.alicdn.com/imgextra/i4/1132886103/O1CN01zFORuc1uxDkU8TXtT_!!1132886103.jpg"],"tmallDescUrl":"//mdetail.tmall.com/templates/pages/desc?id=546416107509","moduleDescUrl":"//hws.m.taobao.com/d/modulet/v5/WItemMouldDesc.do?id=546416107509&f=TB1rLoHkzMZ7e4jSZFO8qt7epla","favcount":"22668","countMultiple":[],"cartUrl":"https://h5.m.taobao.com/awp/base/cart.htm","exParams":{},"title":"施耐德A9空气开关1P断路器1P+N家用2P63A（可选购带漏电保护器）","openDecoration":false,"rootCategoryId":"50020579","commentCount":"14224","itemId":"546416107509","skuText":"请选择极数 额定电流 ","moduleDescParams":{"f":"i1/540/410/546416107509/TB1rLoHkzMZ7e4jSZFO8qt7epla","id":"546416107509"},"brandValueId":"9959902","subtitle":"购买带漏电保护器型号，可咨询客服","taobaoDescUrl":"//h5.m.taobao.com/app/detail/desc.html?_isH5Des=true#!id=546416107509&type=0&f=TB10zZRWpT7gK0jSZFp8quTkpla&sellerType=B","h5moduleDescUrl":"//mdetail.tmall.com/templates/pages/itemDesc?id=546416107509","taobaoPcDescUrl":"//h5.m.taobao.com/app/detail/desc.html?_isH5Des=true#!id=546416107509&type=1&f=TB185tXlaNj0u4jSZFy8qtgMVla&sellerType=B","categoryId":"50021028"},"debug":{"app":"alidetail","host":"detail011181127037.center.na620@11.181.127.37"},"resource":{"entrances":{"askAll":{"icon":"https://img.alicdn.com/tps/TB1tVU6PpXXXXXFaXXXXXXXXXXX-102-60.png","link":"//market.m.taobao.com/app/mtb/questions-and-answers/pages/list/index.html?refId=546416107509","text":"\"施耐德和公牛的价格相差有点大，怎么选啊？求专业人士推荐\""}}},"vertical":{"askAll":{"showNum":"2","askIcon":"https://img.alicdn.com/tps/TB1tVU6PpXXXXXFaXXXXXXXXXXX-102-60.png","askText":"施耐德和公牛的价格相差有点大，怎么选啊？求专业人士推荐","modelList":[{"askText":"施耐德和公牛的价格相差有点大，怎么选啊？求专业人士推荐","answerCountText":"12个回答"},{"askText":"1P+N又是什么意思呢？？？","answerCountText":"4个回答"}],"questNum":"43","linkUrl":"//market.m.taobao.com/app/mtb/questions-and-answers/pages/list/index.html?refId=546416107509","model4XList":[{"askIcon":"//gw.alicdn.com/tfs/TB1lneilZLJ8KJjy0FnXXcFDpXa-36-36.png","askText":"施耐德和公牛的价格相差有点大，怎么选啊？求专业人士推荐","askTextColor":"#162B36","answerCountText":"12个回答"},{"askIcon":"//gw.alicdn.com/tfs/TB1lneilZLJ8KJjy0FnXXcFDpXa-36-36.png","askText":"1P+N又是什么意思呢？？？","askTextColor":"#162B36","answerCountText":"4个回答"}],"title":"问大家(43)"}},"params":{"trackParams":{"brandId":"9959902","BC_type":"B","categoryId":"50021028"}},"apiStack":[{"name":"esi","value":{"feature":{"makeup":"false","isVirtualRechargeItem":"false","isDonateItem":"false","promotion2019":"true","bSeller":"true","promotion2018":"true","useMeiLiHuiPrice":"false","o2O":"false","showCommonBanner":"false","guessYouLike":"false","isXiaXuan":"false","isJuPinTuan":"false","showGroupChat":"true","sellCountAntiCreep":"true","nabundleItem":"false","hasSku":"true","bundleItem":"false","taobao2018":"true","wygProtect":"true","hasCartRecommend":"false","openNewSku":"true","bigMarkDownWarm":"true","hasBrandScene":"false","fmcgRecommend":"false","superActTime":"false","isXinxuan":"false","labelPro":"true","notUseVip95CardBar":"false","hasApparelIcon":"false","openGradient":"true","isCloudChanger":"false","bybtForTmall":"true","showshopRecommendItems":"true","overSeaBuy":"false","wygItem":"false","hasIntervalPrice":"true","isDamai":"false","waitForStart":"false","newAddress":"true","hideSMww":"false","useNewRate":"false","renovation":"false","hasAddCartCoudan":"false","showCuntaoTag":"false","showInteractionBarRecommend":"true","recommendReason":"false","switchToOldApp":"false","isNewShareGift":"false","hideShopDsr":"false","newPrice":"true","pricedCoupon":"false","hasCoupon":"false","buhuo":"true","cainiaoNoramal":"true","xinxuanRec":"false","showNewPersonBag":"false","showSku":"true","showShopCard":"false","showYaoDai":"false","useBenifitNew":"false","isXXSale":"false","enableDpbModule":"false","showLiteAppRec":"false","customSkuImage":"false","showTmallApp":"false","showEncyclopedia":"false","hasNewCombo":"true","noShareGroup":"true","showInteractionBar":"true","enableBusiness2020":"true","showSkuProRate":"true","hasAddTmallCartCoudan":"false","useVip95CardStyle":"false","multistage":"false","hasQualification":"false","showShopV4":"false","isTspace":"false","hasBrandevent":"false","series":"false","isTTSale":"false","hardPrice":"true","hideDsrNew":"false","newIndicator":"true","shareGroup":"false","showSMww":"false","smSpeBottomBar":"false","isShopVipMember":"false","includeSkuData":"true"},"trade":{"outerCartParam":{},"isWap":"false","buyEnable":"true","cartEnable":"true","cartParam":{"areaId":"440103"},"cartConfirmEnable":"true","tradeParams":{},"useWap":"false","cartJumpUrl":"https://h5.m.taobao.com/awp/base/cart.htm","buyParam":{"areaId":"440103"}},"item":{"extraMap":{},"deliveryLocationInfo":"配送至:荔湾区","infoText":{},"descType":"2","videoDetail":{"url":"https://cloud.video.taobao.com/play/u/1132886103/p/2/e/6/t/1/262991893420.mp4?appKey=38829","type":"3","videoThumbnailURL":"https://img.alicdn.com/imgextra/i2/1132886103/O1CN01bHKeph1uxDoXI8BrT_!!1132886103.jpg","spatialVideoDimension":"3:4","videoId":"262991893420","interactiveInfo":{"interactiveId":"781406347","userId":"1132886103"},"mainPicList":["https://img.alicdn.com/imgextra/i2/1132886103/O1CN01bHKeph1uxDoXI8BrT_!!1132886103.jpg","https://img.alicdn.com/imgextra/i3/1132886103/O1CN01hbPm7j1uxDnXC8DRr_!!1132886103.jpg","https://img.alicdn.com/imgextra/i1/1132886103/O1CN011uxDelLVL36CFSE_!!1132886103.jpg","https://img.alicdn.com/imgextra/i1/1132886103/O1CN011uxDeleab5ts4qY_!!1132886103.jpg","https://img.alicdn.com/imgextra/i3/1132886103/O1CN011uxDemDocQPvg5S_!!1132886103.jpg"]},"titleIcon":"//img.alicdn.com/tfs/TB1SMG7nnvI8KJjSspjXXcgjXXa-78-36.png?getAvatar=avatar","itemPoint":"17","sellCount":"1万+","vagueSellCount":"1万+","skuText":"配送至:荔湾区,请选择极数/额定电流","videos":[{"url":"https://cloud.video.taobao.com/play/u/1132886103/p/2/e/6/t/1/262991893420.mp4?appKey=38829","type":"3","videoThumbnailURL":"https://img.alicdn.com/imgextra/i2/1132886103/O1CN01bHKeph1uxDoXI8BrT_!!1132886103.jpg","spatialVideoDimension":"3:4","videoId":"262991893420","interactiveInfo":{"interactiveId":"781406347","userId":"1132886103"},"weexRecommendUrl":"https://market.m.taobao.com/apps/market/detailrax/recommend-items.html?spm=a2116h.app.0.0.16d957e9U2bxVj&wh_weex=true&itemId=546416107509"}],"images":["https://img.alicdn.com/imgextra/i2/1132886103/O1CN01bHKeph1uxDoXI8BrT_!!1132886103.jpg","https://img.alicdn.com/imgextra/i3/1132886103/O1CN01hbPm7j1uxDnXC8DRr_!!1132886103.jpg","https://img.alicdn.com/imgextra/i1/1132886103/O1CN011uxDelLVL36CFSE_!!1132886103.jpg","https://img.alicdn.com/imgextra/i1/1132886103/O1CN011uxDeleab5ts4qY_!!1132886103.jpg","https://img.alicdn.com/imgextra/i3/1132886103/O1CN011uxDemDocQPvg5S_!!1132886103.jpg"],"skuInfo":"极数/额定电流","itemId":"546416107509","spuId":"807163279","title":"施耐德A9空气开关1P断路器1P+N家用2P63A（可选购带漏电保护器）"},"buyer":{"tmallMemberLevel":"0"},"price":{"shopProm":[{"activityId":"7299352053","iconText":"促销","title":"全店包邮","period":"2020.09.29-2020.12.31","content":["满199元,享包邮"],"actionUrl":"//h5.m.taobao.com/shopb/shopactivity.html?activityId=7299352053&sellerId=1132886103&source=2&spm=W-a211f8.10431435&scm=20140619.detail.dpb.0","uuid4Cal":"7299352053","type":"3"}],"transmitPrice":{"priceText":"35.31-283.66","priceTitle":"国庆价","showTitle":"true","sugProm":"false"},"shopPromTitle":"促销","superMarketShopProm":[],"newExtraPrices":[{"priceText":"48.11-386.53","priceTitle":"价格","showTitle":"true","lineThrough":"true","sugProm":"false"}],"extraPrices":[{"priceText":"48.11-386.53","priceTitle":"价格","showTitle":"true","lineThrough":"true","sugProm":"false"}],"priceTag":[{"icon":"//img.alicdn.com/tfs/TB1hPpbUYY1gK0jSZTEXXXDQVXa-160-36.png","bigmarkdownTag":"true"}],"price":{"priceText":"35.31-283.66","priceTitle":"国庆价","showTitle":"true","sugProm":"false"}},"consumerProtection":{"serviceProtection":{"basicService":{"id":"204","name":"基础保障","services":[{"serviceId":"3838","name":"假一赔四","desc":["正品保障，假一赔四"],"icon":"//img.alicdn.com/tfs/TB1_YjSjeL2gK0jSZPhXXahvXXa-54-54.png","priority":"12900"},{"serviceId":"3851","name":"退货运费险","desc":["卖家投保退货运费险，负担一定金额退货运费（保单生效以下单显示为准）"],"icon":"//img.alicdn.com/tfs/TB1_YjSjeL2gK0jSZPhXXahvXXa-54-54.png","priority":"6580"},{"serviceId":"5319","name":"三年质保","desc":["交易成功15天后的三年内出现质量问题，商家在规定时间内通过免费维修或免费更换商品或免费补寄零配件或补偿质保基金等方式保障消费者权益"],"icon":"//img.alicdn.com/tfs/TB1_YjSjeL2gK0jSZPhXXahvXXa-54-54.png","priority":"6550"},{"serviceId":"2973","name":"七天无理由退换","desc":["满足相应条件时，消费者可申请 “七天无理由退换货”"],"icon":"//img.alicdn.com/tfs/TB1_YjSjeL2gK0jSZPhXXahvXXa-54-54.png","priority":"5130"}]}},"passValue":"none","channel4X":{},"items":[{"serviceId":"3838","title":"假一赔四","desc":"正品保障，假一赔四","type":"0","priority":"12900"},{"serviceId":"3851","title":"退货运费险","desc":"卖家投保退货运费险，负担一定金额退货运费（保单生效以下单显示为准）","type":"0","priority":"6580"},{"serviceId":"5319","title":"三年质保","desc":"交易成功15天后的三年内出现质量问题，商家在规定时间内通过免费维修或免费更换商品或免费补寄零配件或补偿质保基金等方式保障消费者权益","type":"0","priority":"6550"},{"serviceId":"2973","title":"七天无理由退换","desc":"满足相应条件时，消费者可申请 “七天无理由退换货”","type":"0","priority":"5130"}],"params":"204:3838,3851,5319,2973","strength":"normal"},"resource":{"indexCouponData":{},"entrances":{},"entrancesBizsContent":"","share":{"name":"分享","iconType":"1","params":{"iconFont":"ꄪ","iconColor":"#999999"}},"promsCalcInfo":{"cheapestMoney":"3531","hasCoupon":"false","needReqCouDan":"false"}},"vertical":{"interactionBar":{"kapContain":{"suffix":"点赞","count":"0","likeList":"https://pages.tmall.com/wow/malldetail/act/detail-likelist?wh_biz=tm&wh_weex=true&itemId=546416107509","dashangRecommendInfo":{"clickUrl":"https://market.m.taobao.com/app/mtb/ytq/pages/item-detail-young-tag?wh_weex=true","ruweiItemTag":"1272322","ruweiConfigDefault":{"tipClickUrl":"https://market.m.taobao.com/app/mtb/ytq/pages/item-detail-young-faq?wh_weex=true","rightIcon":"https://gw.alicdn.com/tfs/TB1J38IkkL0gK0jSZFxXXXWHVXa-38-38.png?getAvatar=avatar","tipIcon":"https://gw.alicdn.com/tfs/TB1FOJxsuH2gK0jSZFEXXcqMpXa-194-52.png?getAvatar=avatar","tipText1":"有好货·","tipText2":"已入围 推荐TA上大赏"},"youhaohuoSwitch":"1","detailYigou":{"tipClickUrl":"https://market.m.taobao.com/app/mtb/ytq/pages/item-detail-young-faq?wh_weex=true","rightIcon":"https://gw.alicdn.com/tfs/TB1J38IkkL0gK0jSZFxXXXWHVXa-38-38.png?getAvatar=avatar","tipIcon":"https://gw.alicdn.com/tfs/TB1FOJxsuH2gK0jSZFEXXcqMpXa-194-52.png?getAvatar=avatar","tipText1":"买过的宝贝怎么样？推荐宝贝上有好货·","tipText2":""},"rubangItemTag":"758210","rubangConfig":{"tipClickUrl":"https://market.m.taobao.com/app/mtb/ytq/pages/item-detail-young-faq?wh_weex=true","rightIcon":"https://gw.alicdn.com/tfs/TB1J38IkkL0gK0jSZFxXXXWHVXa-38-38.png?getAvatar=avatar","tipIcon":"https://gw.alicdn.com/tfs/TB1FOJxsuH2gK0jSZFEXXcqMpXa-194-52.png?getAvatar=avatar","tipText1":"有好货·","tipText2":" 获得%s大赏第%s名"},"hasRecommendIcon":"https://gw.alicdn.com/tfs/TB1lwaYvrj1gK0jSZFOXXc7GpXa-80-80.png?getAvatar=avatar","recommendIcon":"https://gw.alicdn.com/tfs/TB1unuRvpT7gK0jSZFpXXaTkpXa-80-80.png?getAvatar=avatar","interactBarShare":{"leftIcon":"https://gw.alicdn.com/tfs/TB1kSgxKQY2gK0jSZFgXXc5OFXa-36-42.png?getAvatar=avatar","tipIcon":"https://img.alicdn.com/tfs/TB1Hyggakcx_u4jSZFlXXXnUFXa-192-46.png?getAvatar=avatar","tipText2":" "}},"kaplist":[{"selected":"false","icon":"https://gw.alicdn.com/tfs/TB1rGtkvpzqK1RjSZFvXXcB7VXa-90-90.png?getAvatar=avatar","selectIcon":"https://gw.alicdn.com/tfs/TB193NrvAzoK1RjSZFlXXai4VXa-90-90.png?getAvatar=avatar","listIcon":"https://gw.alicdn.com/tfs/TB1eHavyAvoK1RjSZFDXXXY3pXa-90-90.png","title":"赞","key":"thumbUp"},{"selected":"false","icon":"https://gw.alicdn.com/tfs/TB10dFlvCzqK1RjSZFHXXb3CpXa-90-90.png?getAvatar=avatar","selectIcon":"https://gw.alicdn.com/tfs/TB1H8FkvwTqK1RjSZPhXXXfOFXa-90-90.png?getAvatar=avatar","listIcon":"https://gw.alicdn.com/tfs/TB1H8FkvwTqK1RjSZPhXXXfOFXa-90-90.png?getAvatar=avatar","title":"买买买","key":"buy"},{"selected":"false","icon":"https://gw.alicdn.com/tfs/TB1pct8xmzqK1RjSZPxXXc4tVXa-90-90.png?getAvatar=avatar","selectIcon":"https://gw.alicdn.com/tfs/TB1kTewxhnaK1RjSZFBXXcW7VXa-90-90.png?getAvatar=avatar","listIcon":"https://gw.alicdn.com/tfs/TB1pct8xmzqK1RjSZPxXXc4tVXa-90-90.png?getAvatar=avatar","title":"种个草","key":"longFor"},{"selected":"false","icon":"https://gw.alicdn.com/tfs/TB10kVkvCzqK1RjSZFjXXblCFXa-90-90.png?getAvatar=avatar","selectIcon":"https://gw.alicdn.com/tfs/TB12pJnvAvoK1RjSZFNXXcxMVXa-90-90.png?getAvatar=avatar","listIcon":"https://gw.alicdn.com/tfs/TB12pJnvAvoK1RjSZFNXXcxMVXa-90-90.png?getAvatar=avatar","title":"震惊了","key":"shock"}]},"bubbles":[{"title":"帮我选","icon":"https://gw.alicdn.com/tfs/TB1NL9dvMDqK1RjSZSyXXaxEVXa-90-90.png?getAvatar=avatar","action":"https://market.m.taobao.com/app/bwx/bwx/pages/create?wh_weex=true&itemId=546416107509&itemPic=i3/1132886103/O1CN01StFQKz1uxDoSd7xNb_!!0-item_pic.jpg"}]},"groupChat":{"image":"//gw.alicdn.com/tfs/TB1Kg_MdoGF3KVjSZFmXXbqPXXa-164-52.png","fansCount":"多","title":"群主不定时发放专享福利","url":"//h5.m.taobao.com/global/open_group_chat/index.html?from=default_detailcard&mixSellerId=vCMIv8cSPHx4vCPIP0ZeMmvuMmRhMGlIMm*IOHc0vC8T","desc":"加入群"},"askAll":{"askIcon":"https://img.alicdn.com/tps/TB1tVU6PpXXXXXFaXXXXXXXXXXX-102-60.png","askText":"施耐德和公牛的价格相差有点大，怎么选啊？求专业人士推荐","model4XList":[{"askText":"施耐德和公牛的价格相差有点大，怎么选啊？求专业人士推荐","answerCountText":"12个回答","askIcon":"//gw.alicdn.com/tfs/TB1lneilZLJ8KJjy0FnXXcFDpXa-36-36.png","askTextColor":"#162B36"},{"askText":"1P+N又是什么意思呢？？？","answerCountText":"4个回答","askIcon":"//gw.alicdn.com/tfs/TB1lneilZLJ8KJjy0FnXXcFDpXa-36-36.png","askTextColor":"#162B36"}],"showNum":"2","questNum":"43","linkUrl":"//market.m.taobao.com/app/mtb/questions-and-answers/pages/list/index.html?refId=546416107509","title":"问大家(43)","modelList":[{"askText":"施耐德和公牛的价格相差有点大，怎么选啊？求专业人士推荐","answerCountText":"12个回答"},{"askText":"1P+N又是什么意思呢？？？","answerCountText":"4个回答"}]},"consumeMedical":{},"buyerAlbum":{"linkUrl":"https://market.m.taobao.com/app/mtb/item-buyer-show/pages/index?wh_weex=true&itemId=546416107509","title":"买家秀","modelList":[{"picUrl":"//gw.alicdn.com/tfscom/O1CN01yZdfmK1yjGCaKIB4F_!!0-rate.jpg"},{"picUrl":"//gw.alicdn.com/tfscom/O1CN01hBVFNF1Wer9NAbqop_!!0-rate.jpg"},{"picUrl":"//gw.alicdn.com/tfscom/O1CN01bvTS7v24bN4ZpDPPO_!!0-rate.jpg"},{"picUrl":"//gw.alicdn.com/tfscom/O1CN018hFxLA1NjahZr6hdu_!!0-tbbala.jpg","videoIcon":"//gw.alicdn.com/tfs/TB1WOWFmlfH8KJjy1XbXXbLdXXa-66-66.png"}],"count":"70"},"freshFood":{"nationalFlag":"//g.alicdn.com/mui/flag-img/circle@2x/CN.png"},"tmallLeaseData":{"rentOfficialPriceFen":"0","rentGuaranteePriceFen":"0","zhiMaSigned":"false"},"vipComment":{"beehive_content_aggre_name":"好物点评团","beehive_content_account_icon":"//gw.alicdn.com/tfs/TB1UD3BaCFRMKJjy0FhXXX.xpXa-168-168.png","beehive_content_cover":"//img.alicdn.com/imgextra/i1/279628378/O1CN01xfnhTM2BlAkcPP8Rn_!!279628378-2-beehive-scenes.png","beehive_content_type":"ContentPost","beehive_content_account_pic":"//img.alicdn.com/imgextra/i2/279628378/TB2fPSAlS8mpuFjSZFMXXaxpVXa_!!279628378-0-beehive-scenes.jpg","beehive_content_title":"家居安防好物，为你打造安全居家环境","beehive_content_summary":"家是陪伴我们一辈子的伙伴，所以打造出一个舒适安全的家居环境，是每个人共同的目标。而想要达到这个目的，我们在所难免的需要布置上几款优质的好物。那么这些家居好物，我们该如何选择呢？","beehive_content_id":"222583203733","beehive_content_detail_url":"https://market.m.taobao.com/apps/market/content/index.html?wh_weex=true&wx_navbar_transparent=true&source=itemdetail_itemdetail&wx_navbar_hidden=true&contentId=222583203733","beehive_content_account_name":"格调汇"}},"delivery":{"addressWeexUrl":"https://market.m.taobao.com/apps/market/detailrax/address-picker.html?spm=a2116h.app.0.0.16d957e9nDYOzv&wh_weex=true","postage":"快递: 免运费","completedTo":"广州市 荔湾区","overseaContraBandFlag":"false","to":"荔湾区","areaSell":"true","areaId":"440103","from":"上海","extras":{}},"skuBase":{"skus":[{"skuId":"3902012990223","propPath":"147760936:4003332;10066392:3277918"},{"skuId":"3902012990232","propPath":"147760936:4003332;10066392:3358852"},{"skuId":"3902012990225","propPath":"147760936:4003332;10066392:3312673"},{"skuId":"3902012990241","propPath":"147760936:4003332;10066392:3623193"},{"skuId":"3902012990230","propPath":"147760936:4003332;10066392:3349655"},{"skuId":"3902012990248","propPath":"147760936:4003332;10066392:4526843"},{"skuId":"3902012990236","propPath":"147760936:4003332;10066392:3418358"},{"skuId":"3902012990244","propPath":"147760936:4003332;10066392:3955950"},{"skuId":"3902012990222","propPath":"147760936:34257334;10066392:3277918"},{"skuId":"3902012990231","propPath":"147760936:34257334;10066392:3358852"},{"skuId":"3902012990224","propPath":"147760936:34257334;10066392:3312673"},{"skuId":"3902012990238","propPath":"147760936:34257334;10066392:3623193"},{"skuId":"3902012990227","propPath":"147760936:34257334;10066392:3349655"},{"skuId":"3902012990246","propPath":"147760936:34257334;10066392:4526843"},{"skuId":"3809569281748","propPath":"147760936:3681680;10066392:3277918"},{"skuId":"3809569281754","propPath":"147760936:3681680;10066392:3358852"},{"skuId":"3809569281751","propPath":"147760936:3681680;10066392:3312673"},{"skuId":"3902012990239","propPath":"147760936:3681680;10066392:3623193"},{"skuId":"3902012990228","propPath":"147760936:3681680;10066392:3349655"},{"skuId":"3333748169337","propPath":"147760936:3681680;10066392:4526843"},{"skuId":"3902012990234","propPath":"147760936:3681680;10066392:3418358"},{"skuId":"3466466187270","propPath":"147760936:3681680;10066392:3955950"},{"skuId":"3809569281749","propPath":"147760936:3684495;10066392:3277918"},{"skuId":"3809569281755","propPath":"147760936:3684495;10066392:3358852"},{"skuId":"3809569281752","propPath":"147760936:3684495;10066392:3312673"},{"skuId":"3902012990240","propPath":"147760936:3684495;10066392:3623193"},{"skuId":"3902012990229","propPath":"147760936:3684495;10066392:3349655"},{"skuId":"3902012990247","propPath":"147760936:3684495;10066392:4526843"},{"skuId":"3902012990235","propPath":"147760936:3684495;10066392:3418358"},{"skuId":"3902012990243","propPath":"147760936:3684495;10066392:3955950"},{"skuId":"3809569281747","propPath":"147760936:3331158;10066392:3277918"},{"skuId":"3809569281753","propPath":"147760936:3331158;10066392:3358852"},{"skuId":"3809569281750","propPath":"147760936:3331158;10066392:3312673"},{"skuId":"3902012990237","propPath":"147760936:3331158;10066392:3623193"},{"skuId":"3902012990226","propPath":"147760936:3331158;10066392:3349655"},{"skuId":"3902012990245","propPath":"147760936:3331158;10066392:4526843"},{"skuId":"3902012990233","propPath":"147760936:3331158;10066392:3418358"},{"skuId":"3902012990242","propPath":"147760936:3331158;10066392:3955950"}],"props":[{"pid":"147760936","name":"极数","values":[{"vid":"4003332","name":"1P","sortOrder":"0"},{"vid":"34257334","name":"1P+N","sortOrder":"9"},{"vid":"3681680","name":"2P","sortOrder":"10"},{"vid":"3684495","name":"3P","sortOrder":"11"},{"vid":"3331158","name":"4p","sortOrder":"12"}]},{"pid":"10066392","name":"额定电流","values":[{"vid":"3277918","name":"10A","sortOrder":"1"},{"vid":"3358852","name":"16A","sortOrder":"2"},{"vid":"3312673","name":"20A","sortOrder":"3"},{"vid":"3623193","name":"25A","sortOrder":"4"},{"vid":"3349655","name":"32A","sortOrder":"5"},{"vid":"4526843","name":"40A","sortOrder":"6"},{"vid":"3418358","name":"50A","sortOrder":"7"},{"vid":"3955950","name":"63A","sortOrder":"8"}]}]},"skuCore":{"skuItem":{"showAddress":"true","hideQuantity":"false","location":"荔湾区"},"sku2info":{"0":{"price":{"priceMoney":"3531","priceText":"35.31-283.66","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3902012990240":{"price":{"priceMoney":"14901","priceText":"149.01","showTitle":"false","sugProm":"false"},"quantity":"23","quantityText":"有货"},"3902012990246":{"price":{"priceMoney":"6814","priceText":"68.14","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3902012990224":{"price":{"priceMoney":"5239","priceText":"52.39","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3809569281755":{"price":{"priceMoney":"13759","priceText":"137.59","showTitle":"false","sugProm":"false"},"quantity":"10","quantityText":"库存紧张"},"3902012990245":{"price":{"priceMoney":"23412","priceText":"234.12","showTitle":"false","sugProm":"false"},"quantity":"2","quantityText":"库存紧张"},"3902012990223":{"price":{"priceMoney":"3531","priceText":"35.31","showTitle":"false","sugProm":"false"},"quantity":"109","quantityText":"有货"},"3902012990248":{"price":{"priceMoney":"4837","priceText":"48.37","showTitle":"false","sugProm":"false"},"quantity":"76","quantityText":"有货"},"3809569281753":{"price":{"priceMoney":"18445","priceText":"184.45","showTitle":"false","sugProm":"false"},"quantity":"8","quantityText":"库存紧张"},"3902012990226":{"price":{"priceMoney":"19868","priceText":"198.68","showTitle":"false","sugProm":"false"},"quantity":"13","quantityText":"有货"},"3902012990247":{"price":{"priceMoney":"17726","priceText":"177.26","showTitle":"false","sugProm":"false"},"quantity":"3","quantityText":"库存紧张"},"3902012990225":{"price":{"priceMoney":"3531","priceText":"35.31","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3809569281754":{"price":{"priceMoney":"8651","priceText":"86.51","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3902012990242":{"price":{"priceMoney":"28366","priceText":"283.66","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3809569281751":{"price":{"priceMoney":"8651","priceText":"86.51","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3902012990241":{"price":{"priceMoney":"3967","priceText":"39.67","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3809569281752":{"price":{"priceMoney":"13759","priceText":"137.59","showTitle":"false","sugProm":"false"},"quantity":"4","quantityText":"库存紧张"},"3902012990244":{"price":{"priceMoney":"6391","priceText":"63.91","showTitle":"false","sugProm":"false"},"quantity":"190","quantityText":"有货"},"3902012990222":{"price":{"priceMoney":"5239","priceText":"52.39","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3902012990243":{"price":{"priceMoney":"21294","priceText":"212.94","showTitle":"false","sugProm":"false"},"quantity":"20","quantityText":"有货"},"3809569281750":{"price":{"priceMoney":"18445","priceText":"184.45","showTitle":"false","sugProm":"false"},"quantity":"0","quantityText":"无货"},"3902012990228":{"price":{"priceMoney":"9498","priceText":"94.98","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3902012990227":{"price":{"priceMoney":"5967","priceText":"59.67","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3902012990229":{"price":{"priceMoney":"14901","priceText":"149.01","showTitle":"false","sugProm":"false"},"quantity":"26","quantityText":"有货"},"3466466187270":{"price":{"priceMoney":"14053","priceText":"140.53","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3809569281748":{"price":{"priceMoney":"8651","priceText":"86.51","showTitle":"false","sugProm":"false"},"quantity":"173","quantityText":"有货"},"3809569281749":{"price":{"priceMoney":"13759","priceText":"137.59","showTitle":"false","sugProm":"false"},"quantity":"8","quantityText":"库存紧张"},"3809569281747":{"price":{"priceMoney":"18445","priceText":"184.45","showTitle":"false","sugProm":"false"},"quantity":"0","quantityText":"无货"},"3902012990235":{"price":{"priceMoney":"19868","priceText":"198.68","showTitle":"false","sugProm":"false"},"quantity":"17","quantityText":"有货"},"3902012990234":{"price":{"priceMoney":"13196","priceText":"131.96","showTitle":"false","sugProm":"false"},"quantity":"108","quantityText":"有货"},"3902012990237":{"price":{"priceMoney":"19868","priceText":"198.68","showTitle":"false","sugProm":"false"},"quantity":"13","quantityText":"有货"},"3902012990236":{"price":{"priceMoney":"5827","priceText":"58.27","showTitle":"false","sugProm":"false"},"quantity":"25","quantityText":"有货"},"3902012990231":{"price":{"priceMoney":"5239","priceText":"52.39","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3902012990230":{"price":{"priceMoney":"3967","priceText":"39.67","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3902012990233":{"price":{"priceMoney":"26237","priceText":"262.37","showTitle":"false","sugProm":"false"},"quantity":"1","quantityText":"库存紧张"},"3902012990232":{"price":{"priceMoney":"3531","priceText":"35.31","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3333748169337":{"price":{"priceMoney":"11641","priceText":"116.41","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3902012990239":{"price":{"priceMoney":"9498","priceText":"94.98","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"},"3902012990238":{"price":{"priceMoney":"5967","priceText":"59.67","showTitle":"false","sugProm":"false"},"quantity":"200","quantityText":"有货"}},"abSwitch":{"enableShowPic":"false","enableShowProtection":"false"},"atmosphere":{}},"promotionFloatingData":{"promotionName":"国庆","promotionText":"国庆价￥35.31起","detailPromotionTimeDO":{"warmUpStartTime":"2020-09-16 00:00:00","warmUpEndTime":"2020-09-19 00:00:00","effectiveTime":"2020-09-19 00:00:00","unEffectiveTime":"2020-10-07 23:59:59","promotionType":"BIGMARKDOWN"},"downGradeReason":"ABTest","skuMoney":{"skuId":"3902012990225","cent":"3531"},"buyEnable":"true"},"skuVertical":{},"weappData":{"wapComboId01":{"params":{"jumpUrl":"https://h5.m.taobao.com/cm/collocation.html?itemId=546416107509&sellerId=1132886103&type=taobao"},"mtopModel":{"API_NAME":"mtop.collocation.detail.query","VERSION":"1.0"}}},"params":{"trackParams":{"shop_id":"102024564","spm":"a21bo.2017.201874-sales.29","bizParams_V2":"shopActivity_current,interaction_bar_test","detailabtestdetail":"30056_6146.62601_24786","serverAbTest":"detail_main_video_test_base","detailUniqueId":"93f301a3bb135466c3e2bfbcc8ea5d98"},"umbParams":{"aliBizName":"YWxpLmNoaW5hLnRtYWxs","detail_categoryid":"50020579.50021027.50021028","aliBizCode":"ali.china.tmall"},"utParam":"[{\"abtest\":\"30056_6146\",\"component\":\"interaction_product_abtest\",\"releaseId\":30056,\"module\":\"2018\",\"cm\":\"interaction_product_abtest_2018\",\"bucketId\":6146,\"pageName\":[\"Page_Detail\"],\"trackConfigs\":\"[{\\\"eventIds\\\":[2001,2101,2201],\\\"pageNames\\\":[\\\"Page_Detail\\\"]}]\"}]"},"skuTransform":{"skuContents":[{"text":"1P"},{"text":"1P+N"},{"text":"2P"}],"extraText":"共5种极数可选"},"priceSectionData":{"mainBelt":{"priceBeltImg":"https://img.alicdn.com/tfs/TB19z_HlA9l0K4jSZFKXXXFjpXa-1125-210.png","priceBeltColor":"#f11c14","bizType":"0","styleType":"2","rightBelt":{"countdown":"1","countDownStatus":"1","countDownBackgroundColor":"#000000","now":"1601998253326","startTime":"1600444800000","endTime":"1602086399000","text":"距优惠结束","textColor":"#FFFFFF","extraTextColor":"#FFFFFF"}},"promotion":{"entranceTip":"查看","items":[{"textColor":"#FD5F20","content":"满199享包邮","type":"default","bgImage":"https://gw.alicdn.com/tfs/TB1.dqZSgHqK1RjSZJnXXbNLpXa-40-40.png","scontent":"满199享包邮","sbgImage":"https://gw.alicdn.com/tfs/TB12R2Oerj1gK0jSZFuXXcrHpXa-302-80.png"}],"entranceUrl":"https://pages.tmall.com/wow/malldetail/act/detail-quan?wh_weex=true&wh_biz=tm","promotionBeltColor":"#f11c14"},"price":{"priceMoney":"3531","priceText":"35.31","priceTail":"起","priceTitle":"国庆价"},"extraPrice":{"priceMoney":"4811","priceText":"48.11","priceTail":"起","priceTitle":"价格","priceColor":"#FFFFFF","lineThrough":"true"},"styleTye":"2","bizType":"p-bigMarkdown-*-online","priceType":"line_price"},"otherInfo":{"bucketId":"16","systemTime":"1601998253351"},"hybrid":{"shopRecommendItems":{"url":"http://market.m.taobao.com/apps/market/detailrax/recommend-shop-bigpage.html?spm=a2116h.app.0.0.16d957e9U9efo0&wh_weex=true&selfRmdFlag=true&itemId=546416107509&sellerId=1132886103&detail_v=8.0.0","height":"445","hasSyncTask":"true"}},"diversion":{"detailTopSearch":{"url":"https://s.m.taobao.com/h5entry?g_channelSrp=detail&g_historyOn=true&showText=气垫粉底&placeholder=气垫粉底&g_csearchdoor_spm=a2141.13130650&itemId=546416107509&detailShopId=102024564"}},"layout":{"config":{"dependComponentConfigID":"TB1pw4VcQ9E3KVjSZFGhA319XXa","dependActionConfigID":"TB1Llk4UwHqK1RjSZFEhA3GMXXa","dependThemeConfigID":"TB1MfiMsQyWBuNjy0FphA1ssXXa"},"hierarchyData":{"hierarchy":{"root":"detail","structure":{"detailHome":["detailInfo","divisionDesc","detailDesc","divisionDescRecmd","descRecmd","divisionEnd"],"detail":["navibar","detailHome"],"naviTabs":["naviTabInfo","naviTabRate","naviTabDesc","naviTabDescRecmd"],"navibar":["naviItemLeft","naviItemCenter","naviItemCustom","naviItemRight","naviTabs"]}},"components":{"naviItemCenter":{"name":"naviItemCenter","type":"detailNaviItem","payload":{"accessHint":"图片","positionKey":"center","value":"${item.images[0]}","itemType":"2"},"actions":["naviShowBigPic","utNaviShowBigPic"]},"naviItemCustom":{"name":"naviItemCustom","type":"detailNaviItem","payload":{"accessHint":"购物车","positionKey":"custom","value":"ꁍ","titleSizeRatio":"0.375"},"actions":["utGotoCart","openPageCart"]},"divisionDescRecmd":{"name":"divisionDescRecmd","type":"division","payload":{"iconUrl":"//img.alicdn.com/tps/TB1PGyPOVXXXXa8aXXXXXXXXXXX","height":"5","displayType":"gone","bgcolor":"0xf4f4f4"},"locatorId":"divisionDescRecmd"},"naviTabInfo":{"name":"naviTabInfo","type":"detailNaviTabItem","payload":{"iconUrl":"//img.alicdn.com/tps/TB1ZGAeOFXXXXa6XXXXXXXXXXXX","title":"宝贝"},"actions":["gotoDetailInfo","utClickDetailInfo"],"style":"tab"},"detailHome":{"name":"detailHome","type":"detailHome","locatorId":"detailHome"},"detailInfo":{"name":"detailInfo","type":"detailInfo","locatorId":"detailInfo"},"divisionEnd":{"name":"divisionEnd","type":"division","payload":{"title":"已经到底了","displayType":"text","fgcolor":"0x999999"}},"naviTabDescRecmd":{"name":"naviTabDescRecmd","type":"detailNaviTabItem","payload":{"iconUrl":"//img.alicdn.com/tps/TB1ZGAeOFXXXXa6XXXXXXXXXXXX","title":"推荐"},"actions":["gotoDescRecommend","utClickDescRecommend"],"style":"tab"},"naviTabs":{"name":"naviTabs","type":"detailNaviTabs"},"navibar":{"name":"navibar","type":"detailNavibar"},"naviItemLeft":{"name":"naviItemLeft","type":"detailNaviItem","payload":{"accessHint":"返回","positionKey":"left","value":"ꁽ","titleSizeRatio":"0.375","secondActions":[{"type":"go_detail_home","eventToken":"${eventToken}","domain":"detail"}]},"actions":["gotoPreviewPage"]},"detailDesc":{"name":"detailDesc","type":"detailDesc","payload":{"userId":"${seller.userId}","shopId":"${seller.shopId}","itemId":"${item.itemId}","moduleDescParams":"${item.moduleDescParams}","taobaoDescUrl":"${item.taobaoDescUrl}","taobaoPcDescUrl":"${item.taobaoPcDescUrl}"},"actions":["utExposureDetailDesc"],"style":"detailDesc"},"naviTabRate":{"name":"naviTabRate","type":"detailNaviTabItem","payload":{"iconUrl":"//img.alicdn.com/tps/TB1ZGAeOFXXXXa6XXXXXXXXXXXX","title":"评价","pageName":"Page_DetailComments","secondActions":[{"type":"goto_rate_top","eventToken":"${eventToken}","domain":"detail"}]},"actions":["gotoDetailRate","utClickDetailRate","utExposureDetailRate"],"style":"tab"},"divisionDesc":{"name":"divisionDesc","type":"division","payload":{"iconUrl":"","title":"宝贝详情","displayType":"text","fgcolor":"0x666666"},"locatorId":"divisionDesc"},"naviTabDesc":{"name":"naviTabDesc","type":"detailNaviTabItem","payload":{"iconUrl":"//img.alicdn.com/tps/TB1ZGAeOFXXXXa6XXXXXXXXXXXX","title":"详情"},"actions":["gotoDetailDesc","utClickDetailDesc"],"style":"tab"},"descRecmd":{"name":"descRecmd","type":"descRecmd","payload":{"userId":"${seller.userId}","itemId":"${item.itemId}"},"actions":["utExposureDescRecommend"],"style":"shopRecommend"},"detail":{"name":"detail","type":"detail"},"naviItemRight":{"name":"naviItemRight","type":"detailNaviItem","payload":{"accessHint":"更多","positionKey":"right","value":"ꁭ","titleSizeRatio":"0.375"},"actions":["showMenu"]}},"actions":{"utClickDetailInfo":{"type":"user_track","event":"click","params":{"trackNamePre":"Button-","trackName":"GotoDetailHome"}},"openPageCartForInter":{"type":"open_url","params":{"urlParams":{"itemId":"${item.itemId}","cartfrom":"detail"},"url":"https://pages.tmall.com/wow/trade/act/cart?wh_weex=true"}},"utExposureDetailRate":{"type":"ut_exposure","params":{"spm":"a2141.7631564.2737664","trackPage":"Page_Detail_Show_Detail"}},"utExposureDescRecommend":{"type":"ut_exposure","params":{"spm":"a2141.7631564.2737766","trackPage":"Page_Detail_Show_Recommend"}},"openPageSearch":{"type":"open_url","params":{"urlParams":{"tpId":"${vertical.supermarket.tpId}","cartfrom":"tmall_supermarket"},"url":"https://s.m.tmall.com/m/searchbar.htm"}},"utGotoCart":{"type":"user_track","params":{"trackNamePre":"Button-","trackName":"ShoppingCart"}},"utClickDetailDesc":{"type":"user_track","event":"click","params":{"trackNamePre":"Button-","trackName":"GotoDetailDesc"}},"naviShowBigPic":{"type":"show_big_pic"},"utClickDescRecommend":{"type":"user_track","event":"click","params":{"trackNamePre":"Button-","trackName":"GotoShopRecommend"}},"gotoDetailRate":{"type":"locator","event":"click","params":{"locatorId":"divisionRate"}},"gotoUserTalk":{"type":"locator","event":"click","params":{"locatorId":"userSay"}},"gotoDescRecommend":{"type":"locator","event":"click","params":{"locatorId":"divisionDescRecmd"}},"utClickDetailRate":{"type":"user_track","event":"click","params":{"trackNamePre":"Button-","trackName":"GotoDetailRate"}},"showMenu":{"type":"show_menu"},"utNaviShowBigPic":{"type":"user_track","params":{"trackNamePre":"Button-","trackName":"NaviShowBigPic"}},"utExposureDetailDesc":{"type":"ut_exposure","params":{"spm":"a2141.7631564.1999077549","trackPage":"Page_Detail_Show_ProductDetail","scm":""}},"openPageCart":{"type":"open_url","params":{"urlParams":{"itemId":"${item.itemId}","cartfrom":"detail"},"url":"https://h5.m.taobao.com/awp/base/cart.htm"}},"gotoPreviewPage":{"type":"go_back"},"utGotoSearch":{"type":"user_track","params":{"trackParams":{"tpId":"${vertical.supermarket.tpId}"},"trackNamePre":"Button-","trackName":"Search"}},"gotoDetailInfo":{"type":"locator","event":"click","params":{"locatorId":"detailInfo"}},"gotoDetailDesc":{"type":"locator","event":"click","params":{"locatorId":"divisionDesc"}}}},"detailTemplateData":{"homePage":[{"key":"navi_bar","ruleId":"","id":"navi_bar","ID":"navi_bar"},{"key":"pic_gallery","ruleId":"","id":"pic_gallery","ID":"pic_gallery"},{"key":"sys_list","ruleId":"","children":[{"key":"uniform_price","ruleId":"TB_default"},{"key":"dinamic","ruleId":"tb_detail_price_cheapie_shadow"},{"key":"dinamic","ruleId":"tb_detail_price_ttsale_shadow"},{"key":"dinamic","ruleId":"TB_jhs_main_Belt_shadow"},{"key":"dinamic","ruleId":"TB_detail_handprice_coupon"},{"key":"tip","ruleId":"TB_presaleTmall2"},{"key":"tip","ruleId":"TB_priceTip2"},{"key":"tip","ruleId":"TB_pricedCouponTip2"},{"key":"tip","ruleId":"TB_shipTime2"},{"key":"dinamic","ruleId":"TB_coupon_promotion2019"},{"key":"dinamic","ruleId":"TB_detail_black_card_brand_info"},{"key":"dinamic","ruleId":"TB_detail_brand_info"},{"key":"dinamic","ruleId":"TB_detail_title_normal"},{"key":"dinamic","ruleId":"TB_detail_title_tmallMarket"},{"key":"dinamic","ruleId":"TB_detail_title_xinxuan"},{"key":"dinamic","ruleId":"TB_detail_kernel_params"},{"key":"dinamic","ruleId":"TB_detail_small_activity"},{"key":"dinamic","ruleId":"TB_detail_KAP_bar"},{"key":"dinamic","ruleId":"TB_detail_entrance_artascope"},{"key":"dinamic","ruleId":"TB_detail_KAP_subInfo_default"},{"key":"dinamic","ruleId":"TB_detail_appointment_store3"},{"key":"dinamic","ruleId":"TB_detail_appointment_store"},{"key":"dinamic","ruleId":"TB_detail_pick"},{"key":"dinamic","ruleId":"TB_detail_redpacket"},{"key":"dinamic","ruleId":"TB_detail_coupon"},{"key":"dinamic","ruleId":"TB_detail_promotion"},{"key":"dinamic","ruleId":"TB_detail_new_lingquan"},{"key":"dinamic","ruleId":"TB_detail_share"},{"key":"dinamic","ruleId":"TB_jk_detail_coupon_share"},{"key":"dinamic","ruleId":"TB_detail_tmallfeature"},{"key":"dinamic","ruleId":"TB_detail_cuntao_pinchegou"},{"key":"dinamic","ruleId":"TB_detail_creditbuy"},{"key":"dinamic","ruleId":"TB_detail_divider"},{"key":"dinamic","ruleId":"TB_msfx_tmall_banner"},{"key":"dinamic","ruleId":"TB_detail_sub_logistics"},{"key":"dinamic","ruleId":"TB_detail_tax"},{"key":"dinamic","ruleId":"TB_detail_trade_guarantee"},{"key":"dinamic_o2o","ruleId":"TB_detail_o2o"},{"key":"dinamic","ruleId":"TB_wyg_divider"},{"key":"dinamic","ruleId":"TB_detail_divider"},{"key":"dinamic","ruleId":"TB_guarantee_and_delivery"},{"key":"dinamic","ruleId":"TB_wyg_divider"},{"key":"dinamic","ruleId":"TB_detail_divider"},{"key":"dinamic","ruleId":"TB_detail_divider"},{"key":"dinamic","ruleId":"TB_detail_sku_cross_upgrade"},{"key":"xsku","ruleId":"TB_Default"},{"key":"dinamic","ruleId":"TB_detail_sku_transform"},{"key":"dinamic","ruleId":"TB_detail_product_props"},{"key":"vessel","ruleId":"TB_guess_u_like_promotion"},{"key":"dinamic","ruleId":"TB_detail_miniapp_diliver"},{"key":"dinamic","ruleId":"TB_detail_miniapp_rmd"},{"key":"dinamic","ruleId":"TB_detail_divider_rateLocator"},{"key":"dinamic","ruleId":"TB_detail_comment_empty"},{"key":"dinamic","ruleId":"TB_detail_comment_head"},{"key":"dinamic","ruleId":"TB_detail_comment_tag"},{"key":"dinamic","ruleId":"TB_detail_comment_single_hot"},{"key":"dinamic","ruleId":"TB_detail_buyer_photo"},{"key":"dinamic","ruleId":"TB_detail_ask_all_no_question"},{"key":"dinamic","ruleId":"TB_detail_ask_all_two_questions"},{"key":"dinamic","ruleId":"TB_detail_ask_all_aliMedical"},{"key":"dinamic","ruleId":"TB_detail_vipComment"},{"key":"dinamic","ruleId":"TB_detail_medical_official_case_card"},{"key":"vessel","ruleId":"TB_guess_u_like"},{"key":"dinamic","ruleId":"TB_detail_divider"},{"key":"dinamic","ruleId":"TB_detail_shop"},{"key":"dinamic","ruleId":"TB_detail_endorsement"},{"key":"dinamic_async","ruleId":"TB_tblive_detail"},{"key":"vessel","ruleId":"TB_shop_recommend"}],"id":"main_layout","ID":"main_layout"},{"key":"bottom_bar","ruleId":"TB_promo2019_coupon_after_cart","id":"bottom_bar","ID":"bottom_bar"}]}},"traceDatas":{"dinamic+TB_detail_ask_all_two_questions":{"module":"tb_detail_ask_all_two_questions"},"dinamic+TB_detail_brand_info":{"module":"tb_detail_brand_info"},"dinamic+TB_detail_endorsement":{"module":"tb_detail_endorsement"},"dinamic+TB_detail_tip_presale":{"module":"tb_detail_tip_presale"},"dinamic+TB_detail_subInfo_superMarket":{"module":"tb_detail_subInfo_superMarket"},"dinamic+TB_detail_ask_all_no_question":{"module":"tb_detail_ask_all_no_question"},"dinamic+TB_detail_kernel_params":{"module":"tb_detail_kernel_params"},"dinamic_o2o+TB_detail_o2o":{"module":"TB_detail_o2o"},"dinamic+TB_detail_subInfo_jhs_normal":{"module":"tb_detail_subInfo_jhs_normal"},"dinamic+TB_detail_new_person_bag_banner":{"module":"tb_detail_new_person_bag_banner"},"dinamic+TB_detail_title_tmallMarket":{"module":"tb_detail_title_tmallMarket"},"dinamic+TB_detail_buyer_photo":{"module":"tb_detail_buyer_photo"},"dinamic+TB_detail_subInfo_preSellForTaobaoB":{"module":"tb_detail_subInfo_preSellForTaobaoB"},"dinamic+TB_detail_title_xinxuan":{"module":"tb_detail_title_xinxuan"},"dinamic+TB_detail_subInfo_preSellForTaobaoC":{"module":"tb_detail_subInfo_preSellForTaobaoC"},"dinamic+TB_detail_tmallfeature":{"module":"tb_detail_tmallfeature"},"dinamic+TB_detail_sub_logistics":{"module":"tb_detail_sub_logistics"},"dinamic+TB_detail_price_coupon":{"module":"tb_detail_price_coupon"},"dinamic+TB_detail_coupon":{"module":"tb_detail_coupon"},"dinamic+TB_detail_tip_presale2":{"module":"tb_detail_tip_presale2"},"dinamic+TB_detail_tip_price":{"module":"tb_detail_tip_price"},"dinamic+TB_detail_delivery":{"module":"tb_detail_delivery"},"dinamic+TB_detail_ship_time":{"module":"tb_detail_ship_time"},"dinamic+TB_detail_ask_all_aliMedical":{"module":"tb_detail_ask_all_aliMedical"},"dinamic+TB_detail_priced_coupon":{"module":"tb_detail_priced_coupon"},"dinamic+TB_detail_tax":{"module":"tb_detail_tax"},"dinamic+TB_detail_comment_empty":{"module":"tb_detail_comment_empty"},"dinamic+TB_detail_logistics":{"module":"tb_detail_logistics"}},"modules":[]}}],"props":{"groupProps":[{"基本信息":[{"品牌":"Schneider Electric/施耐德"},{"型号":"A9V53263+A9F18263"},{"额定电流":"10A 16A 20A 25A 32A 40A 50A 63A"},{"灭弧方式":"磁吹断路器"},{"漏电保护器类型":"2P"},{"极数":"1P 1P+N 2P 3P 4p"}]}]},"mockData":{"delivery":{},"trade":{"buyEnable":true,"cartEnable":true},"feature":{"hasSku":true,"showSku":true},"price":{"price":{"priceText":"48.11"}},"skuCore":{"sku2info":{"0":{"price":{"priceMoney":4811,"priceText":"48.11","priceTitle":"价格"},"quantity":3800},"3902012990229":{"price":{"priceMoney":20305,"priceText":"203.05","priceTitle":"价格"},"quantity":100},"3902012990228":{"price":{"priceMoney":12943,"priceText":"129.43","priceTitle":"价格"},"quantity":100},"3902012990231":{"price":{"priceMoney":7140,"priceText":"71.40","priceTitle":"价格"},"quantity":100},"3902012990230":{"price":{"priceMoney":5405,"priceText":"54.05","priceTitle":"价格"},"quantity":100},"3902012990225":{"price":{"priceMoney":4811,"priceText":"48.11","priceTitle":"价格"},"quantity":100},"3902012990224":{"price":{"priceMoney":7140,"priceText":"71.40","priceTitle":"价格"},"quantity":100},"3902012990227":{"price":{"priceMoney":8132,"priceText":"81.32","priceTitle":"价格"},"quantity":100},"3902012990226":{"price":{"priceMoney":27073,"priceText":"270.73","priceTitle":"价格"},"quantity":100},"3902012990237":{"price":{"priceMoney":27073,"priceText":"270.73","priceTitle":"价格"},"quantity":100},"3902012990236":{"price":{"priceMoney":7940,"priceText":"79.40","priceTitle":"价格"},"quantity":100},"3902012990239":{"price":{"priceMoney":12943,"priceText":"129.43","priceTitle":"价格"},"quantity":100},"3902012990238":{"price":{"priceMoney":8132,"priceText":"81.32","priceTitle":"价格"},"quantity":100},"3902012990233":{"price":{"priceMoney":35751,"priceText":"357.51","priceTitle":"价格"},"quantity":100},"3902012990232":{"price":{"priceMoney":4811,"priceText":"48.11","priceTitle":"价格"},"quantity":100},"3902012990235":{"price":{"priceMoney":27073,"priceText":"270.73","priceTitle":"价格"},"quantity":100},"3902012990234":{"price":{"priceMoney":17982,"priceText":"179.82","priceTitle":"价格"},"quantity":100},"3333748169337":{"price":{"priceMoney":15863,"priceText":"158.63","priceTitle":"价格"},"quantity":100},"3902012990223":{"price":{"priceMoney":4811,"priceText":"48.11","priceTitle":"价格"},"quantity":100},"3902012990222":{"price":{"priceMoney":7140,"priceText":"71.40","priceTitle":"价格"},"quantity":100},"3466466187270":{"price":{"priceMoney":19149,"priceText":"191.49","priceTitle":"价格"},"quantity":100},"3809569281747":{"price":{"priceMoney":25133,"priceText":"251.33","priceTitle":"价格"},"quantity":100},"3809569281748":{"price":{"priceMoney":11788,"priceText":"117.88","priceTitle":"价格"},"quantity":100},"3809569281749":{"price":{"priceMoney":18749,"priceText":"187.49","priceTitle":"价格"},"quantity":100},"3809569281750":{"price":{"priceMoney":25133,"priceText":"251.33","priceTitle":"价格"},"quantity":100},"3809569281751":{"price":{"priceMoney":11788,"priceText":"117.88","priceTitle":"价格"},"quantity":100},"3809569281752":{"price":{"priceMoney":18749,"priceText":"187.49","priceTitle":"价格"},"quantity":100},"3809569281753":{"price":{"priceMoney":25133,"priceText":"251.33","priceTitle":"价格"},"quantity":100},"3809569281754":{"price":{"priceMoney":11788,"priceText":"117.88","priceTitle":"价格"},"quantity":100},"3809569281755":{"price":{"priceMoney":18749,"priceText":"187.49","priceTitle":"价格"},"quantity":100},"3902012990245":{"price":{"priceMoney":31902,"priceText":"319.02","priceTitle":"价格"},"quantity":100},"3902012990244":{"price":{"priceMoney":8707,"priceText":"87.07","priceTitle":"价格"},"quantity":100},"3902012990247":{"price":{"priceMoney":24154,"priceText":"241.54","priceTitle":"价格"},"quantity":100},"3902012990246":{"price":{"priceMoney":9285,"priceText":"92.85","priceTitle":"价格"},"quantity":100},"3902012990241":{"price":{"priceMoney":5405,"priceText":"54.05","priceTitle":"价格"},"quantity":100},"3902012990240":{"price":{"priceMoney":20305,"priceText":"203.05","priceTitle":"价格"},"quantity":100},"3902012990243":{"price":{"priceMoney":29016,"priceText":"290.16","priceTitle":"价格"},"quantity":100},"3902012990242":{"price":{"priceMoney":38653,"priceText":"386.53","priceTitle":"价格"},"quantity":100},"3902012990248":{"price":{"priceMoney":6591,"priceText":"65.91","priceTitle":"价格"},"quantity":100}},"skuItem":{"hideQuantity":true}}},"rate":{"keywords":[{"count":"396","attribute":"180071001-11","type":"1","word":"商家服务好"},{"count":"206","attribute":"180141000-11","type":"1","word":"质量不错"},{"count":"98","attribute":"180201000-11","type":"1","word":"是名牌"},{"count":"33","attribute":"180061000-11","type":"1","word":"物流服务好"},{"count":"31","attribute":"180231000-11","type":"1","word":"性价比高"},{"count":"34","attribute":"180231000-13","type":"-1","word":"性价比一般"}],"rateList":[{"dateTime":"2020-10-04","feedId":"1102473712246","memberLevel":"5","createTimeInterval":"2天前","userName":"w**0","headPic":"//wwc.alicdn.com/avatar/getAvatar.do?userIdStr=vFkSPFHuXH*evF8LPmHSXmIuvmgWvG7IPFvGvC*IvH80vGI4v88bP88Yvkc0vCMh&width=40&height=40&type=sns","skuInfo":"极数:1P;额定电流:25A","content":"产品功能：轻快的好 外观材质：好 商品品质：好 ","isVip":"false","tmallMemberLevel":"0"},{"dateTime":"2020-07-10","feedId":"1101705016484","memberLevel":"2","createTimeInterval":"2个月前","userName":"困**蔡","headPic":"//wwc.alicdn.com/avatar/getAvatar.do?userIdStr=vGNuOHcWv88YXF-HPmvbM0cWvGkuMChzMHg0vC8GvGI0XH8GM8kyMGcbPmZhXH7e&width=40&height=40&type=sns","skuInfo":"极数:2P;额定电流:40A","content":"同样的东西，比苏宁贵不说，出了问题一口咬定不肯换，不肯退，售后半天才回一句，说要检测，产品没有问题我会找你吗，为甚么重新换了一个，又通电了？不是质量问题是什么","isVip":"false","tmallMemberLevel":"0"}],"utFeedId":"1102473712246_1101705016484","totalCount":"14224"},"props2":{},"skuBase":{"skus":[{"propPath":"10066392:3277918;147760936:4003332","skuId":"3902012990223"},{"propPath":"10066392:3358852;147760936:4003332","skuId":"3902012990232"},{"propPath":"10066392:3312673;147760936:4003332","skuId":"3902012990225"},{"propPath":"10066392:3623193;147760936:4003332","skuId":"3902012990241"},{"propPath":"10066392:3349655;147760936:4003332","skuId":"3902012990230"},{"propPath":"10066392:4526843;147760936:4003332","skuId":"3902012990248"},{"propPath":"10066392:3418358;147760936:4003332","skuId":"3902012990236"},{"propPath":"10066392:3955950;147760936:4003332","skuId":"3902012990244"},{"propPath":"10066392:3277918;147760936:34257334","skuId":"3902012990222"},{"propPath":"10066392:3358852;147760936:34257334","skuId":"3902012990231"},{"propPath":"10066392:3312673;147760936:34257334","skuId":"3902012990224"},{"propPath":"10066392:3623193;147760936:34257334","skuId":"3902012990238"},{"propPath":"10066392:3349655;147760936:34257334","skuId":"3902012990227"},{"propPath":"10066392:4526843;147760936:34257334","skuId":"3902012990246"},{"propPath":"10066392:3277918;147760936:3681680","skuId":"3809569281748"},{"propPath":"10066392:3358852;147760936:3681680","skuId":"3809569281754"},{"propPath":"10066392:3312673;147760936:3681680","skuId":"3809569281751"},{"propPath":"10066392:3623193;147760936:3681680","skuId":"3902012990239"},{"propPath":"10066392:3349655;147760936:3681680","skuId":"3902012990228"},{"propPath":"10066392:4526843;147760936:3681680","skuId":"3333748169337"},{"propPath":"10066392:3418358;147760936:3681680","skuId":"3902012990234"},{"propPath":"10066392:3955950;147760936:3681680","skuId":"3466466187270"},{"propPath":"10066392:3277918;147760936:3684495","skuId":"3809569281749"},{"propPath":"10066392:3358852;147760936:3684495","skuId":"3809569281755"},{"propPath":"10066392:3312673;147760936:3684495","skuId":"3809569281752"},{"propPath":"10066392:3623193;147760936:3684495","skuId":"3902012990240"},{"propPath":"10066392:3349655;147760936:3684495","skuId":"3902012990229"},{"propPath":"10066392:4526843;147760936:3684495","skuId":"3902012990247"},{"propPath":"10066392:3418358;147760936:3684495","skuId":"3902012990235"},{"propPath":"10066392:3955950;147760936:3684495","skuId":"3902012990243"},{"propPath":"10066392:3277918;147760936:3331158","skuId":"3809569281747"},{"propPath":"10066392:3358852;147760936:3331158","skuId":"3809569281753"},{"propPath":"10066392:3312673;147760936:3331158","skuId":"3809569281750"},{"propPath":"10066392:3623193;147760936:3331158","skuId":"3902012990237"},{"propPath":"10066392:3349655;147760936:3331158","skuId":"3902012990226"},{"propPath":"10066392:4526843;147760936:3331158","skuId":"3902012990245"},{"propPath":"10066392:3418358;147760936:3331158","skuId":"3902012990233"},{"propPath":"10066392:3955950;147760936:3331158","skuId":"3902012990242"}],"props":[{"values":[{"vid":"3277918","name":"10A"},{"vid":"3358852","name":"16A"},{"vid":"3312673","name":"20A"},{"vid":"3623193","name":"25A"},{"vid":"3349655","name":"32A"},{"vid":"4526843","name":"40A"},{"vid":"3418358","name":"50A"},{"vid":"3955950","name":"63A"}],"name":"额定电流","pid":"10066392"},{"values":[{"vid":"4003332","name":"1P"},{"vid":"34257334","name":"1P+N"},{"vid":"3681680","name":"2P"},{"vid":"3684495","name":"3P"},{"vid":"3331158","name":"4p"}],"name":"极数","pid":"147760936"}]},"desc":{"api":"mtop.taobao.detail.getdesc","v":"6.0","ret":["SUCCESS::调用成功"],"data":{"sellerId":"1132886103","wdescContent":{"summary":[],"pages":["//img.alicdn.com/imgextra/i3/1132886103/O1CN01btdTZq1uxDoJfhfjF_!!1132886103.jpg","//img.alicdn.com/imgextra/i1/1132886103/O1CN01ihj4q21uxDoMMrtiM_!!1132886103.jpg","//img.alicdn.com/imgextra/i4/1132886103/O1CN01IJ1MWi1uxDoNqSnmf_!!1132886103.jpg","//img.alicdn.com/imgextra/i3/1132886103/O1CN01Mc1yj81uxDoJJXhKU_!!1132886103.jpg","//img.alicdn.com/imgextra/i3/1132886103/O1CN01IYSpAg1uxDoKCFP3c_!!1132886103.jpg","//img.alicdn.com/imgextra/i1/1132886103/O1CN01Rn9VB41uxDoKJyH98_!!1132886103.jpg","//img.alicdn.com/imgextra/i4/1132886103/O1CN01q2rVU31uxDoNBY3rh_!!1132886103.jpg","//img.alicdn.com/imgextra/i1/1132886103/O1CN01RXFaTL1uxDoOzsag4_!!1132886103.jpg","//img.alicdn.com/imgextra/i2/1132886103/O1CN017AHw5F1uxDoHcO8YU_!!1132886103.jpg","//img.alicdn.com/imgextra/i1/1132886103/O1CN01yi3lwM1uxDoJfhjuc_!!1132886103.jpg","//img.alicdn.com/imgextra/i3/1132886103/O1CN018HshA71uxDoKJxbam_!!1132886103.jpg","//img.alicdn.com/imgextra/i3/1132886103/O1CN01GfaqM11uxDoBQ3r4A_!!1132886103.jpg","//img.alicdn.com/imgextra/i2/1132886103/O1CN01Cb9EJu1uxDoOzrie1_!!1132886103.jpg","//img.alicdn.com/imgextra/i2/1132886103/TB2iibfencCL1FjSZFPXXXZgpXa_!!1132886103.jpg","//img.alicdn.com/imgextra/i3/1132886103/O1CN01x8c81H1uxDoNBZny4_!!1132886103.jpg","//img.alicdn.com/imgextra/i2/1132886103/O1CN01RBgc7P1uxDoKJwbBU_!!1132886103.jpg","//img.alicdn.com/imgextra/i4/1132886103/O1CN01XLZ4uo1uxDoMMrQd6_!!1132886103.jpg","//img.alicdn.com/imgextra/i4/1132886103/O1CN01jBJAdE1uxDoHcNbI6_!!1132886103.jpg","//img.alicdn.com/imgextra/i3/1132886103/O1CN01M1dhKl1uxDoLPrwOd_!!1132886103.jpg","//img.alicdn.com/imgextra/i3/1132886103/O1CN01QJa17C1uxDoJJXtnh_!!1132886103.jpg","//img.alicdn.com/imgextra/i4/1132886103/TB2xaprr9xjpuFjSszeXXaeMVXa_!!1132886103.jpg","//img.alicdn.com/imgextra/i4/1132886103/TB21nwpbYWJ.eBjSspdXXXiXFXa_!!1132886103.jpg","https://gw.alicdn.com/tfs/TB1uHSkyrPpK1RjSZFFXXa5PpXa-1125-231.png"],"audios":[]},"itemProperties":[{"name":"品牌","value":"Schneider Electric/施耐德 "},{"name":"型号","value":"A9V53263+A9F18263 "},{"name":"额定电流","value":"10A 16A 20A 25A 32A 40A 50A 63A "},{"name":"灭弧方式","value":"磁吹断路器 "},{"name":"漏电保护器类型","value":"2P "},{"name":"极数","value":"1P 1P+N 2P 3P 4p "}]}}},"ret":["SUCCESS::调用成功"],"timestamp":1601998253082,"description":"Powered By DreamFly."}";

//creatNew ——> 
//get_signature ——> store_image ——> create ——> queryFileDetail
public class upload {

	public static String uploadGoods(String org_goods_id, Integer catId) {
		JsonObject obj = upload.creatNew();
		if (obj.get("goods_commit_id") != null) {
			String goods_commit_id = obj.get("goods_commit_id").getAsString();
			String goods_id = obj.get("goods_id").getAsString();
			return upload.saveEdit(goods_id, goods_commit_id, org_goods_id, catId);
		} else {
			return obj.toString();
		}
//		return obj.toString();
	}

	// 修改模板数据
	public static String getCommitIdByEdit(String goodId) {
		String api = "https://mms.pinduoduo.com/glide/v2/mms/edit/commit/create_by_sn";
		String postdata = "{\"goods_id\":" + goodId + "}";
		String refer = "https://mms.pinduoduo.com/goods/goods_list";
		String json = Api(api, postdata, refer);
		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
		String goods_commit_id = obj.get("result").getAsJsonObject().get("goods_commit_id").getAsString();
		return goods_commit_id;
	}

	// 新建商品
	public static JsonObject creatNew() {
		String api = "https://mms.pinduoduo.com/glide/v2/mms/edit/commit/create_new";
		String refer = "https://mms.pinduoduo.com/goods/goods_list";
		String postdata = "{}";
		String json = Api(api, postdata, refer);
		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
		if (obj.get("result") != null) {
			String goods_commit_id = obj.get("result").getAsJsonObject().get("goods_commit_id").getAsString();
			String goods_id = obj.get("result").getAsJsonObject().get("goods_id").getAsString();
			JsonObject res = new JsonObject();
			res.addProperty("goods_commit_id", goods_commit_id);
			res.addProperty("goods_id", goods_id);
			return res;
		} else {
			return obj;
		}
	}

	// 保存模板
	public static String saveEdit(String goods_id, String goods_commit_id, String org_goods_id, Integer catId) {
		String api = "https://mms.pinduoduo.com/glide/mms/goodsCommit/action/edit";
		// String time = String.valueOf(new Date().getTime());
//		String postdata = "{\"goods_id\":" + goods_id + ",\"goods_commit_id\":\"" + goods_commit_id
//				+ "\",\"check_status\":0,\"tiny_name\":\"\",\"goods_name\":\"【保密发货】【买2送1 买4送2】男士精油外用护理调理油30ml\",\"carousel_video\":[],\"detail_video\":[],\"goods_desc\":\"【保密发货】【买2送1 买4送2】男士精油外用护理调理油30ml\",\"warm_tips\":\"\",\"cat_id\":18681,\"cats\":[\"美容护肤/美体/精油\",\"男士护理\",\"男士精油\",null],\"image_url\":\"\",\"oversea_goods\":{},\"spu\":{},\"isbn_properties_related\":{\"isInit\":false},\"propertys_standard\":[],\"is_draft\":true,\"goods_name_prefix\":\"\",\"size_spec_id\":null,\"is_gold_price_matched\":null,\"hasBatchEnter\":false,\"third_type\":0,\"cat_ids\":[18637,18672,18681,0],\"bad_fruit_claim\":0,\"booking_notes\":{},\"shoes_template_id\":null,\"service_time\":1601316934826,\"electric_status\":0,\"propertys_tid\":27570,\"spu_cate_type\":0,\"decorationPreview\":\"https://mobile.yangkeduo.com/comm_goods_decoration_preview.html?goods_id=181880834795&amp;_oak_decoration_token=uuUEKv1a/TN091WY+iN59gU5lKgl90WZ9ONmYPWigtJKCzXlU5Ap9GYt9n+bTZeSKwH5PHeRiseirJ+daKRSGg==\",\"size_parent_spec_id\":null,\"is_shop\":1,\"goods_type\":1,\"invoice_status\":0,\"invoice_mode\":null,\"zhi_huan_bu_xiu\":0,\"quan_guo_lian_bao\":0,\"second_hand\":0,\"is_pre_sale\":0,\"pre_sale_time\":\"\",\"country_id\":\"0\",\"origin_country_id\":0,\"warehouse\":\"\",\"customs\":\"\",\"is_customs\":0,\"shipment_limit_second\":172800,\"cost_template_id\":169790735914261,\"weight\":\"\",\"groups\":{\"single_price\":0,\"group_price\":0,\"carnival_price\":null,\"customer_num\":2,\"buy_limit\":999999,\"order_limit\":999999,\"regular_limit\":null,\"regular_limit_duration\":null,\"min_num_of_order\":null},\"is_folt\":1,\"is_refundable\":1,\"lack_of_weight_claim\":0,\"goods_pattern\":0,\"customizable\":0,\"local_service_id_list\":null,\"shop_group_id\":0,\"schedule_sale\":{\"sale_type\":0},\"card_verification_list\":[],\"origin_is_pre_sale\":0,\"isCoupon\":false,\"cost_template_error\":null,\"elec_goods_attributes\":null,\"delivery_one_day\":0,\"mai_jia_zi_ti\":null,\"shang_men_an_zhuang\":null,\"song_huo_an_zhuang\":null,\"song_huo_ru_hu\":null,\"goods_srv_templates\":[{\"type\":7,\"id\":null}],\"skus\":[{\"id\":1138414096393,\"sku_id\":699427368975,\"limit_quantity\":999999,\"out_sku_sn\":\"\",\"is_onsale\":1,\"multi_price_in_yuan\":\"16.90\",\"price_in_yuan\":\"18.90\",\"multi_price\":1690,\"price\":1890,\"quantity_delta\":2000,\"thumb_url\":\"https://img.pddpic.com/mms-material-img/2020-09-28/9931c546-074e-4892-a691-648ab10cf967.jpeg.a.jpeg\",\"thumb_url_file_id\":1303140940,\"weight\":0,\"spec\":[{\"parent_id\":2774,\"parent_name\":\"组合\",\"spec_id\":424073632,\"spec_name\":\"一瓶【体验装】\"}],\"length\":null,\"oversea_sku\":{\"specifications\":null,\"measurement_unit\":null,\"taxation\":null},\"sku_srv_templates\":\"\"},{\"id\":1138414096394,\"sku_id\":699427368976,\"limit_quantity\":999999,\"out_sku_sn\":\"\",\"is_onsale\":1,\"multi_price_in_yuan\":\"33.80\",\"price_in_yuan\":\"35.80\",\"multi_price\":3380,\"price\":3580,\"quantity_delta\":2000,\"thumb_url\":\"https://img.pddpic.com/mms-material-img/2020-09-28/9931c546-074e-4892-a691-648ab10cf967.jpeg.a.jpeg\",\"thumb_url_file_id\":1303140940,\"weight\":0,\"spec\":[{\"parent_id\":2774,\"parent_name\":\"组合\",\"spec_id\":5002323850,\"spec_name\":\"适用18-40岁【3瓶】买二送一\"}],\"length\":null,\"oversea_sku\":{\"specifications\":null,\"measurement_unit\":null,\"taxation\":null},\"sku_srv_templates\":\"\"},{\"id\":1138414096395,\"sku_id\":699427368977,\"limit_quantity\":999999,\"out_sku_sn\":\"\",\"is_onsale\":1,\"multi_price_in_yuan\":\"67.60\",\"price_in_yuan\":\"69.60\",\"multi_price\":6760,\"price\":6960,\"quantity_delta\":2000,\"thumb_url\":\"https://img.pddpic.com/mms-material-img/2020-09-28/9931c546-074e-4892-a691-648ab10cf967.jpeg.a.jpeg\",\"thumb_url_file_id\":1303140940,\"weight\":0,\"spec\":[{\"parent_id\":2774,\"parent_name\":\"组合\",\"spec_id\":5002343320,\"spec_name\":\"适用41-50岁【6瓶】买四送二\"}],\"length\":null,\"oversea_sku\":{\"specifications\":null,\"measurement_unit\":null,\"taxation\":null},\"sku_srv_templates\":\"\"}],\"market_price_in_yuan\":\"71.00\",\"market_price\":7100,\"out_goods_sn\":\"\",\"dead_line_seconds\":86399,\"gold_price_template_id\":0,\"processing_charges\":0,\"processing_charges_in_yuan\":\"0\",\"gallery\":[{\"url\":\"https://img.pddpic.com/goods/images/2020-03-18/0529c6c0-c960-46f5-b9a5-1f00259e771f.jpg\",\"type\":1,\"file_id\":1303209400},{\"url\":\"https://img.pddpic.com/goods/images/2020-03-15/f2043232-ac74-43ea-859c-5846f6cf44b5.jpg\",\"type\":1,\"file_id\":1303155881},{\"url\":\"https://img.pddpic.com/goods/images/2020-03-15/bc2a765a-2bbc-419b-9d9a-adb047ab664f.jpg\",\"type\":1,\"file_id\":1303206458},{\"url\":\"https://img.pddpic.com/goods/images/2020-06-30/11ef5a8a-1406-4c08-b9bb-9c38f172d690.jpg\",\"type\":1,\"file_id\":1303206449},{\"url\":\"https://img.pddpic.com/goods/images/2020-03-18/4e4fe459-74de-418d-8bff-c50f2f7a0c81.jpg\",\"type\":1,\"file_id\":1303181702},{\"url\":\"https://img.pddpic.com/goods/images/2020-03-18/faddcae1-eb75-4880-b44f-2818e850c3ca.jpg\",\"type\":1,\"file_id\":1303143961},{\"url\":\"https://img.pddpic.com/goods/images/2020-03-18/2511348b-b84f-4b92-a009-c4f38ba06a09.jpg\",\"type\":1,\"file_id\":1303198614},{\"url\":\"https://img.pddpic.com/goods/images/2020-03-18/12679f34-4709-4403-bfd6-2306d564bfd9.jpg\",\"type\":1,\"file_id\":1303211422},{\"url\":\"https://img.pddpic.com/goods/images/2020-03-15/0f51eecb-1a46-49b4-a9f7-d5ef78d643b4.jpg\",\"type\":1,\"file_id\":1303197598},{\"file_id\":1303205432,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/71274d7e-8962-49e1-ab27-2c2e2ffd183f.jpg\",\"type\":2},{\"file_id\":1303182665,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/a52250be-72f6-489a-a833-e8cf9d3d02af.jpg\",\"type\":2},{\"file_id\":1303178709,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/db1a7842-62fb-4122-8c53-766730757b53.jpg\",\"type\":2},{\"file_id\":1303205431,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/124df5dd-d8d7-4241-9087-f76550c08f59.jpg\",\"type\":2},{\"file_id\":1303213290,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/d860ec9c-523a-4022-92eb-c3d3fb2a99fe.jpg\",\"type\":2},{\"file_id\":1303212437,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/399630bf-4ab4-45dc-9b8c-8044c471d3ca.jpg\",\"type\":2},{\"file_id\":1303159821,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/65b7c9de-f1c3-4d35-a0ef-f801ff617de4.jpg\",\"type\":2},{\"file_id\":1303171782,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/5cc279d9-e3a6-44ca-9f8b-6fa1af6709f2.jpg\",\"type\":2},{\"file_id\":1303158860,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/b2c6de1b-45c0-45a3-9040-a8bc6d6c9802.jpg\",\"type\":2},{\"file_id\":1303181704,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/9c6950d3-09ef-4fa1-b6f3-5bed1eb9bb1c.jpg\",\"type\":2},{\"file_id\":1303203523,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/777fbb15-3109-476d-8be0-29276ca45489.jpg\",\"type\":2},{\"file_id\":1303224145,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/ffb714e5-8274-47be-8ef9-8f0636f9a8ee.jpg\",\"type\":2},{\"file_id\":1303196602,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/158638fa-3f7e-48b7-a6fe-6894280a12b8.jpg\",\"type\":2},{\"file_id\":1303181703,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/9b7493e9-031e-47db-8aa3-9d390b0aca60.jpg\",\"type\":2},{\"file_id\":1303191682,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/e21c528f-3194-4c61-87d0-4f0f58cd8c75.jpg\",\"type\":2},{\"file_id\":1303184662,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/3a09c818-8ee3-42ee-9cdc-f81ac5cf5452.jpg\",\"type\":2},{\"file_id\":1303145944,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/22a5687d-b8c0-40df-981a-1af7b2fb24b6.jpg\",\"type\":2},{\"file_id\":1303187682,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/9538e9ae-cb30-4874-9191-78f14424999f.jpg\",\"type\":2},{\"file_id\":1311042755,\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-03-15/09ed12c0-d508-4235-973e-4026d5cc9368.jpg\",\"type\":2}],\"is_group_pre_sale\":0,\"goods_properties\":[{\"template_pid\":163882,\"template_module_id\":33513,\"ref_pid\":310,\"pid\":5,\"vid\":80018,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163883,\"template_module_id\":33513,\"ref_pid\":351,\"pid\":34,\"vid\":83615,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163883,\"template_module_id\":33513,\"ref_pid\":351,\"pid\":34,\"vid\":327016,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163883,\"template_module_id\":33513,\"ref_pid\":351,\"pid\":34,\"vid\":83763,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163884,\"template_module_id\":33513,\"ref_pid\":1211,\"pid\":338,\"vid\":83618,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163885,\"template_module_id\":33513,\"ref_pid\":482,\"pid\":93,\"vid\":24044,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163886,\"template_module_id\":33513,\"ref_pid\":1563,\"pid\":453,\"vid\":325892,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163887,\"template_module_id\":33513,\"ref_pid\":1471,\"pid\":323,\"vid\":0,\"value_unit\":\"\"}],\"is_auto_save\":false,\"validate_message\":\"9e94fb2305685a419976de10fbdf5e51c47bfbb2e4d5db61b8a2730f242d8327\",\"crawlerInfo\":\""
//				+ queryGoodsRank.getkey() + "\"}";
		String postdata = "";
		if (catId != null) {
			postdata = save(org_goods_id, goods_commit_id, org_goods_id, catId);
		} else {
			postdata = save(goods_id, goods_commit_id, org_goods_id);
		}
		System.out.println(postdata);

//		String postdata = "{\"goods_id\":\"546416107509\",\"goods_commit_id\":\"52565455263\",\"check_status\":0,\"tiny_name\":\"\",\"goods_name\":\"施耐德A9空气开关1P断路器1P+N家用2P63A（可选购带漏电保护器）\",\"carousel_video\":[],\"detail_video\":[],\"goods_desc\":\"施耐德A9空气开关1P断路器1P+N家用2P63A（可选购带漏电保护器）\",\"warm_tips\":\"\",\"cat_id\":9581,\"cats\":[\"电子/电工\",\"断路器\",\"漏电保护器\",null],\"image_url\":\"\",\"oversea_goods\":{},\"spu\":{},\"isbn_properties_related\":{\"isInit\":false},\"propertys_standard\":[],\"is_draft\":true,\"goods_name_prefix\":\"\",\"size_spec_id\":null,\"is_gold_price_matched\":null,\"hasBatchEnter\":false,\"third_type\":0,\"cat_ids\":[9314,9353,9581,0],\"bad_fruit_claim\":0,\"booking_notes\":{},\"shoes_template_id\":null,\"service_time\":1602116678643,\"electric_status\":0,\"propertys_tid\":27570,\"spu_cate_type\":0,\"decorationPreview\":\"https://mobile.yangkeduo.com/comm_goods_decoration_preview.html?goods_id=546416107509&amp;_oak_decoration_token=uuUEKv1a/TN091WY+iN59gU5lKgl90WZ9ONmYPWigtJKCzXlU5Ap9GYt9n+bTZeSKwH5PHeRiseirJ+daKRSGg==\",\"size_parent_spec_id\":null,\"is_shop\":1,\"goods_type\":1,\"invoice_status\":0,\"invoice_mode\":null,\"zhi_huan_bu_xiu\":0,\"quan_guo_lian_bao\":0,\"second_hand\":0,\"is_pre_sale\":0,\"pre_sale_time\":\"\",\"country_id\":\"0\",\"origin_country_id\":0,\"warehouse\":\"\",\"customs\":\"\",\"is_customs\":0,\"shipment_limit_second\":172800,\"cost_template_id\":131252166328701,\"weight\":\"\",\"groups\":{\"single_price\":0,\"group_price\":0,\"carnival_price\":null,\"customer_num\":2,\"buy_limit\":999999,\"order_limit\":999999,\"regular_limit\":null,\"regular_limit_duration\":null,\"min_num_of_order\":null},\"is_folt\":1,\"is_refundable\":1,\"lack_of_weight_claim\":0,\"goods_pattern\":0,\"customizable\":0,\"local_service_id_list\":null,\"shop_group_id\":0,\"schedule_sale\":{\"sale_type\":0},\"card_verification_list\":[],\"origin_is_pre_sale\":0,\"isCoupon\":false,\"cost_template_error\":null,\"elec_goods_attributes\":null,\"delivery_one_day\":0,\"mai_jia_zi_ti\":null,\"shang_men_an_zhuang\":null,\"song_huo_an_zhuang\":null,\"song_huo_ru_hu\":null,\"goods_srv_templates\":[{\"type\":7,\"id\":null}],\"skus\":[{\"id\":1138414096393,\"sku_id\":699427368975,\"limit_quantity\":999999,\"out_sku_sn\":\"\",\"is_onsale\":1,\"multi_price_in_yuan\":\"29.99\",\"price_in_yuan\":\"29.99\",\"multi_price\":2999,\"price\":2999,\"quantity_delta\":2000,\"thumb_url\":\"\",\"thumb_url_file_id\":0,\"weight\":0,\"spec\":[{\"parent_id\":2774,\"parent_name\":\"极数\",\"spec_id\":424073632,\"spec_name\":\"1P\"},{\"parent_id\":2774,\"parent_name\":\"伏特\",\"spec_id\":424073632,\"spec_name\":\"5V\"}],\"length\":null,\"oversea_sku\":{\"specifications\":null,\"measurement_unit\":null,\"taxation\":null},\"sku_srv_templates\":\"\"}],\"market_price_in_yuan\":\"50.00\",\"market_price\":5000,\"out_goods_sn\":\"\",\"dead_line_seconds\":86399,\"gold_price_template_id\":0,\"processing_charges\":0,\"processing_charges_in_yuan\":\"0\",\"gallery\":[{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/11d497bc-9d4d-43ec-9313-d8d5c4f4fcca.jpeg.a.jpeg\",\"type\":2,\"file_id\":1365014329},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/ab60d82b-86a1-4fc5-9037-aa50ed1bf9e3.jpeg.a.jpeg\",\"type\":2,\"file_id\":1364971709},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/3625a2a6-b630-400c-a57e-514c3eea915c.jpeg.a.jpeg\",\"type\":2,\"file_id\":1365019241},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/8bc26e54-ea17-4919-9827-dfe6a4f84a83.jpeg.a.jpeg\",\"type\":2,\"file_id\":1364993524},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/93758dde-45a6-49b0-9d0d-8664c63ed4e1.jpeg.a.jpeg\",\"type\":2,\"file_id\":1364946922},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/bbfcb883-057b-46cd-a0b8-d9cccfe9196a.jpeg.a.jpeg\",\"type\":2,\"file_id\":1364997525},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/748b5ed6-4b69-45fe-990d-9460fbb27ccc.jpeg.a.jpeg\",\"type\":2,\"file_id\":1365006462},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/5a807694-3a89-4ce7-be15-6a7e23d13c4c.jpeg.a.jpeg\",\"type\":2,\"file_id\":1364960790},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/501b3a71-38d3-415d-af8f-4510269d4d62.jpeg.a.jpeg\",\"type\":2,\"file_id\":1364966759},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/0b158707-68ce-451f-80b9-26daeb4b2cc5.jpeg.a.jpeg\",\"type\":2,\"file_id\":1365005424},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/d22b2e43-4bdc-4cdc-9973-35ecb6f805ba.jpeg.a.jpeg\",\"type\":2,\"file_id\":1364949861},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/5ea8e283-c3d3-41dc-96d4-a51c9aeee003.jpeg.a.jpeg\",\"type\":2,\"file_id\":1365000461},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/222537e4-bdcf-412b-9bfd-54f0bd446659.jpeg.a.jpeg\",\"type\":2,\"file_id\":1364973736},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/01190990-eec0-49da-9c04-2f832b8af8c9.jpeg.a.jpeg\",\"type\":2,\"file_id\":1365023206},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/449e324b-74f6-4bc7-87f8-8c7e01999d6f.jpeg.a.jpeg\",\"type\":2,\"file_id\":1364944964},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/0cbca105-35c6-4945-84c6-608b7026c083.jpeg.a.jpeg\",\"type\":2,\"file_id\":1365007411},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/4959f151-3f0f-4af9-a776-887bf720836e.jpeg.a.jpeg\",\"type\":2,\"file_id\":1365029145},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/0cf40683-2a4e-49a0-829a-f967d0e0696b.jpeg.a.jpeg\",\"type\":2,\"file_id\":1364960799},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/3d6c6e5c-45ce-4125-9cdd-15a4125ea00a.jpeg.a.jpeg\",\"type\":2,\"file_id\":1365038011},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/6c990912-97ed-42ad-a679-862d35c8331a.jpeg.a.jpeg\",\"type\":2,\"file_id\":1364953904},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/7121d5d4-69f4-4aa0-8bd1-37fc15c643f8.jpeg.a.jpeg\",\"type\":2,\"file_id\":1364972702},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/3fbe9871-ad8d-463a-9973-3e391d0bdd53.jpeg.a.jpeg\",\"type\":2,\"file_id\":1365029150},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/9612b4e8-4dc2-4272-b0d4-4d2d538249ef.jpeg.a.jpeg\",\"type\":1,\"file_id\":1364961814},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/93d9f429-6cbe-436d-b3fb-1a881b693786.jpeg.a.jpeg\",\"type\":1,\"file_id\":1364968734},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/ebfdfd0d-eb51-4cd4-8723-f7d25892adca.jpeg.a.jpeg\",\"type\":1,\"file_id\":1364964773},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/fff7040d-5bfd-460a-8102-14345fa788d4.jpeg.a.jpeg\",\"type\":1,\"file_id\":1365002400},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-10-08/9c38ecf6-cd96-4990-b8d3-2831e177d578.jpeg.a.jpeg\",\"type\":1,\"file_id\":1364976708}],\"is_group_pre_sale\":0,\"goods_properties\":[{\"template_pid\":163882,\"template_module_id\":33513,\"ref_pid\":310,\"pid\":5,\"vid\":80018,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163883,\"template_module_id\":33513,\"ref_pid\":351,\"pid\":34,\"vid\":83615,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163883,\"template_module_id\":33513,\"ref_pid\":351,\"pid\":34,\"vid\":327016,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163883,\"template_module_id\":33513,\"ref_pid\":351,\"pid\":34,\"vid\":83763,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163884,\"template_module_id\":33513,\"ref_pid\":1211,\"pid\":338,\"vid\":83618,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163885,\"template_module_id\":33513,\"ref_pid\":482,\"pid\":93,\"vid\":24044,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163886,\"template_module_id\":33513,\"ref_pid\":1563,\"pid\":453,\"vid\":325892,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163887,\"template_module_id\":33513,\"ref_pid\":1471,\"pid\":323,\"vid\":0,\"value_unit\":\"\"}],\"is_auto_save\":false,\"validate_message\":\"9e94fb2305685a419976de10fbdf5e51c47bfbb2e4d5db61b8a2730f242d8327\",\"crawlerInfo\":\"0aoAfxnUvOGoY9TV_uDG32RTgsFgTHt-cq-jZVstF1ytBfGOWSZxzDpaBJcpDukr8QNfk3iZZ9mhCnMq5oXSjU9jZmYdXYd81v4nFvCOdPdo5lkaXngxMfjD2VenOQGnPR-VeGlZHoTap5npxHAKwvMmFZfNUi8k7zkeFWKyJDtUZG5xC0zUdCkHGaSo2I9GUIb5-jeI-RkhcceI-8D8VsyZd-K38SinpyEwdMECgj9QeTfq4QWPVBfD2PB6MvE_GU1lI6eEULg1T7GkX1Y0jvySBosGkEPn6V9UhuhZqSvP59mMA0NjJ4Fc_a-xT-iqZd7z97JDS26-2tulZAJA5hjDfYmJghlfSvVgU1dtl311inZE7oQJw2NqQe6ewp-qUzTU3oMxOspLIRPsSRf-DxbWL7LGqTNWLp1Ck7kmRMRN5k1JHYRho2G1fo0DtsChMsvHEhcTJHQkBRE3JHMGb-oqI5uRCfhvEmv\"}";
		String refer = "https://mms.pinduoduo.com/goods/goods_add/index?id=" + goods_commit_id + "&type=add";
		Api(api, postdata, refer);
//		json = submit(goods_commit_id);
		return "https://mms.pinduoduo.com/goods/goods_add/index?id=" + goods_commit_id + "&type=edit";
//		return postdata;
	}

	// {"goods_id":"","goods_commit_id":"","check_status":0,"tiny_name":"","goods_name":"【保密发货】【买2送1
	// 买4送2】男士精油外用护理调理油30ml","carousel_video":[],"detail_video":[],"goods_desc":"【保密发货】【买2送1
	// 买4送2】男士精油外用护理调理油30ml","warm_tips":"","cat_id":18681,"cats":["美容护肤/美体/精油","男士护理","男士精油",null],"image_url":"","oversea_goods":{},"spu":{},"isbn_properties_related":{"isInit":false},"propertys_standard":[],"is_draft":true,"goods_name_prefix":"","size_spec_id":null,"is_gold_price_matched":null,"hasBatchEnter":false,"third_type":0,"cat_ids":[18637,18672,18681,0],"bad_fruit_claim":0,"booking_notes":{},"shoes_template_id":null,"service_time":1601316934826,"electric_status":0,"propertys_tid":27570,"spu_cate_type":0,"decorationPreview":"https://mobile.yangkeduo.com/comm_goods_decoration_preview.html?goods_id=181880834795&amp;_oak_decoration_token=uuUEKv1a/TN091WY+iN59gU5lKgl90WZ9ONmYPWigtJKCzXlU5Ap9GYt9n+bTZeSKwH5PHeRiseirJ+daKRSGg==","size_parent_spec_id":null,"is_shop":1,"goods_type":1,"invoice_status":0,"invoice_mode":null,"zhi_huan_bu_xiu":0,"quan_guo_lian_bao":0,"second_hand":0,"is_pre_sale":0,"pre_sale_time":"","country_id":"0","origin_country_id":0,"warehouse":"","customs":"","is_customs":0,"shipment_limit_second":172800,"cost_template_id":169790735914261,"weight":"","groups":{"single_price":0,"group_price":0,"carnival_price":null,"customer_num":2,"buy_limit":999999,"order_limit":999999,"regular_limit":null,"regular_limit_duration":null,"min_num_of_order":null},"is_folt":1,"is_refundable":1,"lack_of_weight_claim":0,"goods_pattern":0,"customizable":0,"local_service_id_list":null,"shop_group_id":0,"schedule_sale":{"sale_type":0},"card_verification_list":[],"origin_is_pre_sale":0,"isCoupon":false,"cost_template_error":null,"elec_goods_attributes":null,"delivery_one_day":0,"mai_jia_zi_ti":null,"shang_men_an_zhuang":null,"song_huo_an_zhuang":null,"song_huo_ru_hu":null,"goods_srv_templates":[{"type":7,"id":null}],"skus":[{"id":1138414096393,"sku_id":699427368975,"limit_quantity":999999,"out_sku_sn":"","is_onsale":1,"multi_price_in_yuan":"16.90","price_in_yuan":"18.90","multi_price":1690,"price":1890,"quantity_delta":2000,"thumb_url":"https://img.pddpic.com/mms-material-img/2020-09-28/9931c546-074e-4892-a691-648ab10cf967.jpeg.a.jpeg","thumb_url_file_id":1303140940,"weight":0,"spec":[{"parent_id":2774,"parent_name":"组合","spec_id":424073632,"spec_name":"一瓶【体验装】"}],"length":null,"oversea_sku":{"specifications":null,"measurement_unit":null,"taxation":null},"sku_srv_templates":""},{"id":1138414096394,"sku_id":699427368976,"limit_quantity":999999,"out_sku_sn":"","is_onsale":1,"multi_price_in_yuan":"33.80","price_in_yuan":"35.80","multi_price":3380,"price":3580,"quantity_delta":2000,"thumb_url":"https://img.pddpic.com/mms-material-img/2020-09-28/9931c546-074e-4892-a691-648ab10cf967.jpeg.a.jpeg","thumb_url_file_id":1303140940,"weight":0,"spec":[{"parent_id":2774,"parent_name":"组合","spec_id":5002323850,"spec_name":"适用18-40岁【3瓶】买二送一"}],"length":null,"oversea_sku":{"specifications":null,"measurement_unit":null,"taxation":null},"sku_srv_templates":""},{"id":1138414096395,"sku_id":699427368977,"limit_quantity":999999,"out_sku_sn":"","is_onsale":1,"multi_price_in_yuan":"67.60","price_in_yuan":"69.60","multi_price":6760,"price":6960,"quantity_delta":2000,"thumb_url":"https://img.pddpic.com/mms-material-img/2020-09-28/9931c546-074e-4892-a691-648ab10cf967.jpeg.a.jpeg","thumb_url_file_id":1303140940,"weight":0,"spec":[{"parent_id":2774,"parent_name":"组合","spec_id":5002343320,"spec_name":"适用41-50岁【6瓶】买四送二"}],"length":null,"oversea_sku":{"specifications":null,"measurement_unit":null,"taxation":null},"sku_srv_templates":""}],"market_price_in_yuan":"71.00","market_price":7100,"out_goods_sn":"","dead_line_seconds":86399,"gold_price_template_id":0,"processing_charges":0,"processing_charges_in_yuan":"0","gallery":[{"url":"https://img.pddpic.com/goods/images/2020-03-18/0529c6c0-c960-46f5-b9a5-1f00259e771f.jpg","type":1,"file_id":1303209400},{"url":"https://img.pddpic.com/goods/images/2020-03-15/f2043232-ac74-43ea-859c-5846f6cf44b5.jpg","type":1,"file_id":1303155881},{"url":"https://img.pddpic.com/goods/images/2020-03-15/bc2a765a-2bbc-419b-9d9a-adb047ab664f.jpg","type":1,"file_id":1303206458},{"url":"https://img.pddpic.com/goods/images/2020-06-30/11ef5a8a-1406-4c08-b9bb-9c38f172d690.jpg","type":1,"file_id":1303206449},{"url":"https://img.pddpic.com/goods/images/2020-03-18/4e4fe459-74de-418d-8bff-c50f2f7a0c81.jpg","type":1,"file_id":1303181702},{"url":"https://img.pddpic.com/goods/images/2020-03-18/faddcae1-eb75-4880-b44f-2818e850c3ca.jpg","type":1,"file_id":1303143961},{"url":"https://img.pddpic.com/goods/images/2020-03-18/2511348b-b84f-4b92-a009-c4f38ba06a09.jpg","type":1,"file_id":1303198614},{"url":"https://img.pddpic.com/goods/images/2020-03-18/12679f34-4709-4403-bfd6-2306d564bfd9.jpg","type":1,"file_id":1303211422},{"url":"https://img.pddpic.com/goods/images/2020-03-15/0f51eecb-1a46-49b4-a9f7-d5ef78d643b4.jpg","type":1,"file_id":1303197598},{"file_id":1303205432,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/71274d7e-8962-49e1-ab27-2c2e2ffd183f.jpg","type":2},{"file_id":1303182665,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/a52250be-72f6-489a-a833-e8cf9d3d02af.jpg","type":2},{"file_id":1303178709,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/db1a7842-62fb-4122-8c53-766730757b53.jpg","type":2},{"file_id":1303205431,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/124df5dd-d8d7-4241-9087-f76550c08f59.jpg","type":2},{"file_id":1303213290,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/d860ec9c-523a-4022-92eb-c3d3fb2a99fe.jpg","type":2},{"file_id":1303212437,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/399630bf-4ab4-45dc-9b8c-8044c471d3ca.jpg","type":2},{"file_id":1303159821,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/65b7c9de-f1c3-4d35-a0ef-f801ff617de4.jpg","type":2},{"file_id":1303171782,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/5cc279d9-e3a6-44ca-9f8b-6fa1af6709f2.jpg","type":2},{"file_id":1303158860,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/b2c6de1b-45c0-45a3-9040-a8bc6d6c9802.jpg","type":2},{"file_id":1303181704,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/9c6950d3-09ef-4fa1-b6f3-5bed1eb9bb1c.jpg","type":2},{"file_id":1303203523,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/777fbb15-3109-476d-8be0-29276ca45489.jpg","type":2},{"file_id":1303224145,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/ffb714e5-8274-47be-8ef9-8f0636f9a8ee.jpg","type":2},{"file_id":1303196602,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/158638fa-3f7e-48b7-a6fe-6894280a12b8.jpg","type":2},{"file_id":1303181703,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/9b7493e9-031e-47db-8aa3-9d390b0aca60.jpg","type":2},{"file_id":1303191682,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/e21c528f-3194-4c61-87d0-4f0f58cd8c75.jpg","type":2},{"file_id":1303184662,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/3a09c818-8ee3-42ee-9cdc-f81ac5cf5452.jpg","type":2},{"file_id":1303145944,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/22a5687d-b8c0-40df-981a-1af7b2fb24b6.jpg","type":2},{"file_id":1303187682,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/9538e9ae-cb30-4874-9191-78f14424999f.jpg","type":2},{"file_id":1311042755,"url":"https://t00img.yangkeduo.com/goods/images/2020-03-15/09ed12c0-d508-4235-973e-4026d5cc9368.jpg","type":2}],"is_group_pre_sale":0,"goods_properties":[{"template_pid":163882,"template_module_id":33513,"ref_pid":310,"pid":5,"vid":80018,"value":"","value_unit":""},{"template_pid":163883,"template_module_id":33513,"ref_pid":351,"pid":34,"vid":83615,"value":"","value_unit":""},{"template_pid":163883,"template_module_id":33513,"ref_pid":351,"pid":34,"vid":327016,"value":"","value_unit":""},{"template_pid":163883,"template_module_id":33513,"ref_pid":351,"pid":34,"vid":83763,"value":"","value_unit":""},{"template_pid":163884,"template_module_id":33513,"ref_pid":1211,"pid":338,"vid":83618,"value":"","value_unit":""},{"template_pid":163885,"template_module_id":33513,"ref_pid":482,"pid":93,"vid":24044,"value":"","value_unit":""},{"template_pid":163886,"template_module_id":33513,"ref_pid":1563,"pid":453,"vid":325892,"value":"","value_unit":""},{"template_pid":163887,"template_module_id":33513,"ref_pid":1471,"pid":323,"vid":0,"value_unit":""}],"is_auto_save":false,"validate_message":"9e94fb2305685a419976de10fbdf5e51c47bfbb2e4d5db61b8a2730f242d8327","crawlerInfo":""}

	public static String save(String goods_id, String goods_commit_id, String org_goods_id) {
		String json = "{\"goods_id\":\"\",\"goods_commit_id\":\"\",\"check_status\":0,\"tiny_name\":\"\",\"goods_name\":\"\",\"carousel_video\":[],\"detail_video\":[],\"goods_desc\":\"\",\"warm_tips\":\"\",\"cat_id\":\"\",\"cats\":[],\"image_url\":\"\",\"oversea_goods\":{},\"spu\":{},\"isbn_properties_related\":{\"isInit\":false},\"propertys_standard\":[],\"is_draft\":true,\"goods_name_prefix\":\"\",\"size_spec_id\":null,\"is_gold_price_matched\":null,\"hasBatchEnter\":false,\"third_type\":0,\"cat_ids\":[],\"bad_fruit_claim\":0,\"booking_notes\":{},\"shoes_template_id\":null,\"service_time\":"
				+ new Date().getTime()
				+ ",\"electric_status\":0,\"propertys_tid\":27570,\"spu_cate_type\":0,\"decorationPreview\":\"https://mobile.yangkeduo.com/comm_goods_decoration_preview.html?goods_id=\\\"\\\"&amp;_oak_decoration_token=uuUEKv1a/TN091WY+iN59gU5lKgl90WZ9ONmYPWigtJKCzXlU5Ap9GYt9n+bTZeSKwH5PHeRiseirJ+daKRSGg==\",\"size_parent_spec_id\":null,\"is_shop\":1,\"goods_type\":1,\"invoice_status\":0,\"invoice_mode\":null,\"zhi_huan_bu_xiu\":0,\"quan_guo_lian_bao\":0,\"second_hand\":0,\"is_pre_sale\":0,\"pre_sale_time\":\"\",\"country_id\":\"0\",\"origin_country_id\":0,\"warehouse\":\"\",\"customs\":\"\",\"is_customs\":0,\"shipment_limit_second\":172800,\"cost_template_id\":\"\",\"weight\":\"\",\"groups\":{\"single_price\":0,\"group_price\":0,\"carnival_price\":null,\"customer_num\":2,\"buy_limit\":999999,\"order_limit\":999999,\"regular_limit\":null,\"regular_limit_duration\":null,\"min_num_of_order\":null},\"is_folt\":1,\"is_refundable\":1,\"lack_of_weight_claim\":0,\"goods_pattern\":0,\"customizable\":0,\"local_service_id_list\":null,\"shop_group_id\":0,\"schedule_sale\":{\"sale_type\":0},\"card_verification_list\":[],\"origin_is_pre_sale\":0,\"isCoupon\":false,\"cost_template_error\":null,\"elec_goods_attributes\":null,\"delivery_one_day\":0,\"mai_jia_zi_ti\":null,\"shang_men_an_zhuang\":null,\"song_huo_an_zhuang\":null,\"song_huo_ru_hu\":null,\"goods_srv_templates\":[{\"type\":7,\"id\":null}],\"skus\":[],\"market_price_in_yuan\":\"\",\"market_price\":\"\",\"out_goods_sn\":\"\",\"dead_line_seconds\":86399,\"gold_price_template_id\":0,\"processing_charges\":0,\"processing_charges_in_yuan\":\"0\",\"gallery\":[],\"is_group_pre_sale\":0,\"goods_properties\":[{\"template_pid\":163882,\"template_module_id\":33513,\"ref_pid\":310,\"pid\":5,\"vid\":80018,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163883,\"template_module_id\":33513,\"ref_pid\":351,\"pid\":34,\"vid\":83615,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163883,\"template_module_id\":33513,\"ref_pid\":351,\"pid\":34,\"vid\":327016,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163883,\"template_module_id\":33513,\"ref_pid\":351,\"pid\":34,\"vid\":83763,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163884,\"template_module_id\":33513,\"ref_pid\":1211,\"pid\":338,\"vid\":83618,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163885,\"template_module_id\":33513,\"ref_pid\":482,\"pid\":93,\"vid\":24044,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163886,\"template_module_id\":33513,\"ref_pid\":1563,\"pid\":453,\"vid\":325892,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163887,\"template_module_id\":33513,\"ref_pid\":1471,\"pid\":323,\"vid\":0,\"value_unit\":\"\"}],\"is_auto_save\":false,\"validate_message\":\"9e94fb2305685a419976de10fbdf5e51c47bfbb2e4d5db61b8a2730f242d8327\",\"crawlerInfo\":\""
				+ queryGoodsRank.getkey() + "\"}";
		JsonObject jobj = new JsonParser().parse(json).getAsJsonObject();
		jobj.addProperty("goods_id", goods_id);
		jobj.addProperty("goods_commit_id", goods_commit_id);
		String goodJson = servlet.detail.gethtml(org_goods_id);
		// String goodJson =
		// "{\"goods\":{\"serverTime\":1601817853,\"serverTimeTen\":16018178530,\"catID\":18671,\"country\":\"\",\"goodsID\":167979795253,\"brandId\":523283,\"goodsName\":\"深层清洁泥膜去黑头收缩毛孔涂抹式面膜美白补水绿茶面膜泥学生女\",\"shareDesc\":\"【极速退款】深层清洁泥膜去黑头收缩毛孔涂抹式面膜美白补水绿茶面膜泥学生女\",\"goodsType\":1,\"localGroups\":[],\"hasLocalGroup\":0,\"bannerHeight\":375,\"topGallery\":[{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/64e6531f-8b0a-4a42-bbe6-85ed6b4a0c16.jpeg.a.jpeg\",\"id\":415005460716},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-20/2b851910-8df5-4f57-852a-b67bfb24e687.jpeg.a.jpeg\",\"id\":415005460717},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-20/730f871c-be67-4b86-9d68-e40325309f3a.jpeg.a.jpeg\",\"id\":415005460718},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-20/4d6cb1c8-dfc3-4891-88e8-d4489ac520c1.jpeg.a.jpeg\",\"id\":415005460719},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-20/68a389e5-501e-4c5f-81d1-f669aaaa00f1.jpeg.a.jpeg\",\"id\":415005460720},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-20/4ad31103-e591-486a-b63f-8030e044ae95.jpeg.a.jpeg\",\"id\":415005460721},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-20/ec5d8c8f-cc6c-4689-b631-80274d574b47.jpeg.a.jpeg\",\"id\":415005460722},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-20/0b28333a-8e16-48d5-a794-a95a41c1cf16.jpeg.a.jpeg\",\"id\":415005460723},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-20/84f7960c-34bb-48db-aab7-e81008c6a66a.jpeg.a.jpeg\",\"id\":415005460724},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-23/d0553f8b-25c8-4aec-b0a6-5cd10ff22b23.jpeg.a.jpeg\",\"id\":415005460725}],\"viewImageData\":[\"https://img.pddpic.com/mms-material-img/2020-08-21/64e6531f-8b0a-4a42-bbe6-85ed6b4a0c16.jpeg.a.jpeg\",\"https://img.pddpic.com/mms-material-img/2020-08-20/2b851910-8df5-4f57-852a-b67bfb24e687.jpeg.a.jpeg\",\"https://img.pddpic.com/mms-material-img/2020-08-20/730f871c-be67-4b86-9d68-e40325309f3a.jpeg.a.jpeg\",\"https://img.pddpic.com/mms-material-img/2020-08-20/4d6cb1c8-dfc3-4891-88e8-d4489ac520c1.jpeg.a.jpeg\",\"https://img.pddpic.com/mms-material-img/2020-08-20/68a389e5-501e-4c5f-81d1-f669aaaa00f1.jpeg.a.jpeg\",\"https://img.pddpic.com/mms-material-img/2020-08-20/4ad31103-e591-486a-b63f-8030e044ae95.jpeg.a.jpeg\",\"https://img.pddpic.com/mms-material-img/2020-08-20/ec5d8c8f-cc6c-4689-b631-80274d574b47.jpeg.a.jpeg\",\"https://img.pddpic.com/mms-material-img/2020-08-20/0b28333a-8e16-48d5-a794-a95a41c1cf16.jpeg.a.jpeg\",\"https://img.pddpic.com/mms-material-img/2020-08-20/84f7960c-34bb-48db-aab7-e81008c6a66a.jpeg.a.jpeg\",\"https://img.pddpic.com/mms-material-img/2020-08-23/d0553f8b-25c8-4aec-b0a6-5cd10ff22b23.jpeg.a.jpeg\"],\"detailGallery\":[{\"url\":\"https://t00img.yangkeduo.com/goods/images/2020-08-21/6b5f15bf-1ec6-48dc-af78-f6d483644eea.png\",\"width\":750,\"height\":160},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-23/33a4c659-da3e-4a8b-a4f1-adf43490a198.jpeg.a.jpeg\",\"width\":800,\"height\":800},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/2b9d378b-1ce4-436e-8821-594ffdb82c9d.jpeg.a.jpeg\",\"width\":790,\"height\":958},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/0e996a6c-b4cc-46b4-858f-619d240da0ee.jpeg.a.jpeg\",\"width\":790,\"height\":1073},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/3cdc4dec-15c2-47af-b446-78748a265014.jpeg.a.jpeg\",\"width\":750,\"height\":687},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/19652902-2729-4898-b2db-8ef7d0346d9d.jpeg.a.jpeg\",\"width\":750,\"height\":688},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/3ef987af-316a-4c43-8d08-41f2da8fea7c.jpeg.a.jpeg\",\"width\":750,\"height\":688},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/b949fe2c-cebb-4f1e-aadd-8e2d1dfeecda.jpeg.a.jpeg\",\"width\":750,\"height\":688},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/aca07180-efec-49d4-b846-4fc33dd68910.jpeg.a.jpeg\",\"width\":750,\"height\":688},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/62a8505a-9abd-4e4a-9df1-3d6b76e73666.jpeg.a.jpeg\",\"width\":750,\"height\":687},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/1d9b75b9-6fef-4ee2-bb9e-1ac3346aec07.jpeg.a.jpeg\",\"width\":750,\"height\":688},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/a4731add-2173-4bb0-9b00-90e364113f32.jpeg.a.jpeg\",\"width\":750,\"height\":688},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/2b740c21-3080-4d77-992c-eefa5cd2196f.jpeg.a.jpeg\",\"width\":750,\"height\":688},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/9457c61c-470b-4051-aac1-d044e8b65b22.jpeg.a.jpeg\",\"width\":750,\"height\":688},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/c42aa1c1-1d3b-4d84-9a6b-3429394fa96c.jpeg.a.jpeg\",\"width\":750,\"height\":687},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/64f5dc1a-4f4f-4b55-8c39-7bbbd268bfd1.jpeg.a.jpeg\",\"width\":750,\"height\":688},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/220aaeac-eb90-44b5-bb96-3c4df4c52db1.jpeg.a.jpeg\",\"width\":750,\"height\":688},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/06433ae1-f632-4f4d-8db3-9b9c6390e0bf.jpeg.a.jpeg\",\"width\":790,\"height\":871},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/9f02001f-9b35-4220-adba-faa3b8680a17.jpeg.a.jpeg\",\"width\":800,\"height\":800},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/5c29705a-cd4c-4a00-96bb-95faf6e86a59.jpeg.a.jpeg\",\"width\":792,\"height\":1149},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/76086ac9-83dd-40ad-ae1c-ab27f426663f.jpeg.a.jpeg\",\"width\":790,\"height\":1110},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/8aa8992f-4e20-4fa3-871b-322a92b15e03.jpeg.a.jpeg\",\"width\":800,\"height\":800},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/303ec634-2696-4b3a-9b18-71ee560f1608.jpeg.a.jpeg\",\"width\":776,\"height\":1200},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/33fd025b-bac2-43a3-9906-f46f355e4461.jpeg.a.jpeg\",\"width\":774,\"height\":1200},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/605b96ff-3efa-4b9f-94f5-f414df58edc9.jpeg.a.jpeg\",\"width\":750,\"height\":688},{\"url\":\"https://img.pddpic.com/mms-material-img/2020-08-21/2c30662c-2314-401d-b008-927ee5d33e7e.jpeg.a.jpeg\",\"width\":790,\"height\":532}],\"videoGallery\":[],\"descVideoGallery\":[],\"mallID\":274628870,\"groupTypes\":[{\"requireNum\":\"1\",\"price\":\"0\",\"totalPrice\":\"0\",\"groupID\":40796840872,\"startTime\":1451577600,\"endTime\":2082729600,\"orderLimit\":999999},{\"requireNum\":\"2\",\"price\":\"0\",\"totalPrice\":\"0\",\"groupID\":40796840873,\"startTime\":1451577600,\"endTime\":2082729600,\"orderLimit\":999999}],\"skus\":[{\"skuId\":665990805837,\"goodsId\":167979795253,\"thumbUrl\":\"https://img.pddpic.com/mms-material-img/2020-08-21/64e6531f-8b0a-4a42-bbe6-85ed6b4a0c16.jpeg.a.jpeg\",\"initQuantity\":0,\"quantity\":735,\"limitQuantity\":999999,\"soldQuantity\":0,\"defaultQuantity\":100,\"isOnsale\":1,\"spec\":\"4576777648\",\"specs\":[{\"spec_key\":\"容量\",\"spec_value\":\"绿茶冰肌清洁面膜1瓶（送粉刺针一支）\",\"spec_key_id\":1287,\"spec_value_id\":4576777648}],\"price\":0,\"normalPrice\":\"22.9\",\"groupPrice\":\"22.9\",\"oldGroupPrice\":2290,\"marketPrice\":0,\"weight\":0,\"previewPriority\":0,\"startTime\":0,\"endTime\":0,\"staticLimitQuantity\":999999,\"attribute\":\"{}\",\"skuID\":665990805837,\"isOnSale\":1,\"skuExpansionPrice\":\"0\",\"groupSkuUnitPrice\":\"\",\"normalSkuUnitPrice\":\"\"}],\"thumbUrl\":\"https://t00img.yangkeduo.com/goods/images/2020-08-21/fbb5c5d81118a3acf249b24962d06ec9.jpeg\",\"hdThumbUrl\":\"https://t00img.yangkeduo.com/goods/images/2020-08-21/6593bd9c8c5c80c3251b2c8b56e12b36.jpeg\",\"eventType\":0,\"isApp\":0,\"isFreshmanApp\":0,\"sideSalesTip\":\"已拼1533件\",\"bottomSalesTip\":\"\",\"catID1\":18637,\"catID2\":18668,\"catID3\":18671,\"catID4\":0,\"spuID\":0,\"eventComing\":false,\"isSpike\":false,\"isTodaySpike\":false,\"isTomorrowSpike\":false,\"isSpikeComing\":false,\"overseaType\":0,\"gpv\":null,\"quickRefund\":false,\"rv\":true,\"maxNormalPrice\":\"22.9\",\"minNormalPrice\":\"22.9\",\"maxGroupPrice\":\"22.9\",\"minGroupPrice\":\"22.9\",\"maxOnSaleGroupPrice\":\"22.9\",\"minOnSaleGroupPrice\":\"22.9\",\"maxOnSaleGroupPriceInCent\":2290,\"minOnSaleGroupPriceInCent\":2290,\"maxOnSaleNormalPrice\":\"22.9\",\"minOnSaleNormalPrice\":\"22.9\",\"oldMinOnSaleGroupPriceInCent\":2290,\"skipGoodsIDs\":[\"0\"],\"tag\":null,\"icon\":null,\"tagIcon\":[],\"isSecondHand\":0,\"promotionBanner\":{\"serverTime\":1601817853},\"appClientOnly\":0,\"isColdGoods\":0,\"goodsProperty\":[{\"key\":\"品牌\",\"values\":[\"兰恬纪\"],\"ref_pid\":310,\"reference_id\":523283},{\"key\":\"功能\",\"values\":[\"收缩毛孔\",\"去黑头\",\"深层清洁\"],\"ref_pid\":351,\"reference_id\":0},{\"key\":\"适用肤质\",\"values\":[\"任何肤质\"],\"ref_pid\":1210,\"reference_id\":0},{\"key\":\"规格类型\",\"values\":[\"常规单品\"],\"ref_pid\":1211,\"reference_id\":0},{\"key\":\"是否孕妇可用\",\"values\":[\"是\"],\"ref_pid\":1562,\"reference_id\":0},{\"key\":\"面膜类型\",\"values\":[\"乳霜状\"],\"ref_pid\":1218,\"reference_id\":0},{\"key\":\"产地\",\"values\":[\"中国大陆\"],\"ref_pid\":482,\"reference_id\":0},{\"key\":\"是否为特殊用途化妆品\",\"values\":[\"否\"],\"ref_pid\":1563,\"reference_id\":0}],\"linePrice\":\"49\",\"priceStyle\":0,\"quicklyExpire\":{},\"userNoticeDynamic\":{\"notice\":\"\",\"notice_type\":0,\"priority\":1},\"defaultProvinceId\":0,\"goodsExpansionPrice\":\"0\",\"beforeRemindSeconds\":300,\"shareTitle\":\"深层清洁泥膜去黑头收缩毛孔涂抹式面膜美白补水绿茶面膜泥学生女\",\"bottomBanner\":null,\"isAppFlow\":true,\"isPersonalFav\":0,\"groupNumFull\":false,\"showHistoryGroup\":1,\"shareLink\":\"goods1.html?goods_id=167979795253&page_from=0\",\"promptExplain\":\"请严格按照产品说明要求操作。使用前务必先进行过敏测试，如有过敏反应的，请立即停止使用。如有疑问，请咨询商家客服。\",\"isAbnormalStatus\":false,\"statusExplain\":\"\",\"checkQuantity\":1,\"destinationUrl\":\"order_checkout.html\",\"hideMall\":false,\"isMallRec\":true,\"status\":1,\"isGoodsOnSale\":true,\"isSkuOnSale\":true,\"isOnSale\":true,\"quantity\":735,\"propertyCardClick\":0,\"goodsPropertyType\":0,\"showRecTitle\":1,\"showRec\":1,\"options\":[54,9],\"eventTime\":1601817853,\"mallService\":{\"service\":[{\"id\":24,\"type\":\"极速退款\",\"dialog_type\":\"极速退款\",\"desc\":\"拼单成功6小时内，待发货状态下，提交退款申请将立即退款\",\"top\":1,\"top_type\":11,\"navigation\":0,\"navigation_url\":\"\",\"detail_hidden\":0},{\"id\":1,\"type\":\"全场包邮\",\"dialog_type\":\"全场包邮\",\"desc\":\"所有商品包邮（偏远地区除外）\",\"top\":0,\"top_type\":0,\"navigation\":0,\"navigation_url\":\"\",\"detail_hidden\":0},{\"id\":2,\"type\":\"7天无理由退货\",\"dialog_type\":\"7天无理由退货\",\"desc\":\"满足相应条件（未拆封）时，消费者可申请7天无理由退货\",\"top\":0,\"top_type\":0,\"navigation\":0,\"navigation_url\":\"\",\"detail_hidden\":0},{\"id\":13,\"type\":\"48小时发货\",\"dialog_type\":\"48小时发货\",\"desc\":\"若超时未发货，消费者将会收到至少3元无门槛代金券\",\"top\":0,\"top_type\":0,\"navigation\":0,\"navigation_url\":\"\",\"detail_hidden\":0},{\"id\":15,\"type\":\"假一赔十\",\"dialog_type\":\"假一赔十\",\"desc\":\"若收到商品是假冒品牌，可获得十倍现金券赔偿\",\"top\":0,\"top_type\":0,\"navigation\":0,\"navigation_url\":\"\",\"detail_hidden\":0}],\"vipService\":{},\"honorService\":{}},\"ui\":{\"title_section\":{\"green_icon\":{\"id\":24,\"type\":\"极速退款\",\"desc\":\"拼单成功6小时内，待发货状态下，提交退款申请将立即退款\"}},\"live_section\":{\"on_live\":0},\"bubble_section\":{\"show_bubble\":1},\"sku_section\":{\"view_style\":0,\"view_style_v2\":0},\"bottom_buying_section\":{\"type\":\"normal\"},\"more_pop_navi_button\":{\"navi_list\":[{\"icon_id\":\"59210\",\"text\":\"常见问题\",\"url\":\"questions.html\"},{\"icon_id\":\"59213\",\"text\":\"意见反馈\",\"url\":\"personal_feedback.html\"},{\"icon_id\":\"59212\",\"text\":\"举报商品\",\"url\":\"comm_goods_complaint.html?goods_id=167979795253\"}]},\"pane_section\":{\"icon\":\"https://t13img.yangkeduo.com/mobile_live/2020-04-23/1ee46c71-2e04-4352-929a-7cab253e2ff9.gif\",\"title\":\"99+个直播间正在讲解「超好用的面膜」\",\"jump_url\":\"/live_list_goods_detail.html?goodsId=167979795253&keyword=%E3%80%8C%E8%B6%85%E5%A5%BD%E7%94%A8%E7%9A%84%E9%9D%A2%E8%86%9C%E3%80%8D%E7%9B%B4%E6%92%AD%E9%97%B4\",\"live_count\":182},\"price_explain_section\":{\"pulldown_title\":\"点击查看商品价格说明\"}},\"neighborGroup\":{\"neighbor_status\":1,\"neighbor_data\":{\"local_group\":{},\"history_group\":{},\"history_visitor\":{}}},\"control\":{},\"contextData\":{\"isNativePlatform\":false,\"hostname\":\"mobile.yangkeduo.com\",\"isMiniProgram\":false},\"DDType\":false,\"isDuoDuoSingleGroup\":false,\"isDuoDuoDoubleGroup\":false,\"hasDDCoupon\":false,\"historyVistorInfo\":{\"historyVistors\":[],\"historyVistorsTotal\":0},\"historyGroupInfo\":{\"historyGroups\":[],\"historyMemberCount\":0,\"hasDoubleMember\":false,\"hasSingleMember\":false},\"localGroupInfo\":{\"showGroup\":null,\"localGroups\":[],\"localGroupsTotal\":0},\"userGroup\":null,\"userHistoryGroup\":null,\"nowTime\":1601817853,\"isABTestGoodsPrerenderOC\":false,\"isABPriceDecimalSizeDecrease\":false,\"isABPriceSubsidyJump\":false,\"isABPriceSpikeJump\":false,\"isABGoodsRecOffset\":false,\"isABGoodsSoldOutRec\":true,\"allowOcHosts\":[\"mobile.pinduoduo.com\"],\"isABRegions\":true,\"selectedFailingGroup\":null,\"upTime\":\"2020-08-20\"},\"mall\":{\"mallId\":\"274628870\",\"mallName\":\"阿古朵美妆小店\",\"mallShowType\":0,\"mallTransferType\":0,\"salesTip\":\"已拼:
		// 300件\",\"mallLogo\":\"http://t16img.yangkeduo.com/pdd_ims/img_check/v2/E6EDFF2D6EE40020200112155452281/02b862e4193b4369b7edb6753b2de83a.png\",\"goodsNum\":1,\"goodsNumDesc\":\"商品数量:
		// 1\",\"pddRoute\":\"mall_page.html?mall_id=274628870&msn=uxh657caeqf2wjt2ebp66k7c7a_axbuy&mall_info=%7B%22mall_name%22%3A%22%E9%98%BF%E5%8F%A4%E6%9C%B5%E7%BE%8E%E5%A6%86%E5%B0%8F%E5%BA%97%22%7D\",\"pddRouteName\":\"进店逛逛\",\"mallServiceTag\":\"客服\",\"isFlagShip\":false,\"logoList\":[],\"mallLogoList\":[],\"dsr\":{\"descScore\":0,\"descStatus\":0,\"logisticsScore\":0,\"logisticsStatus\":0,\"serviceScore\":0,\"serviceStatus\":0,\"descRankPercent\":0,\"logisticsRankPercent\":0,\"serviceRankPercent\":0,\"descRankStatus\":0,\"logisticsRankStatus\":0,\"serviceRankStatus\":0,\"hideRankInfo\":1,\"mallStar\":4,\"isShowMallStar\":true},\"isGuideMall\":false,\"extras\":{\"2\":false,\"3\":false,\"4\":false,\"5\":1},\"msn\":\"uxh657caeqf2wjt2ebp66k7c7a_axbuy\",\"merchantType\":1,\"mallPageHeadShowTagVolist\":[],\"mallID\":\"274628870\",\"logo\":\"https://t16img.yangkeduo.com/pdd_ims/img_check/v2/E6EDFF2D6EE40020200112155452281/02b862e4193b4369b7edb6753b2de83a.png\"},\"liveInfo\":null,\"lisbonInfo\":{\"inviteAppCoupon\":null,\"appNewbieCoupon\":null,\"appCoupon\":null,\"promotionPriceActivity\":null,\"limitedFreeOrder\":null,\"multiGoodsEvent\":null,\"mallCoupons\":[],\"treasureCoupon\":null,\"specialUserCoupon\":null,\"promotionPriceInfo\":{\"copyWriting\":{\"activityCopyWriting\":\"\",\"copyWritingWithoutPriceStartFrom\":\"\",\"skuCopyWritings\":[]},\"promoDisplayItems\":[],\"promoDisplayItemsWithSuffix\":[],\"fbSendAmount\":0}},\"shareUserInfo\":null,\"authenticatedInfo\":null,\"queries\":{\"goods_id\":\"167979795253\"},\"isIOS\":false,\"isSystemIOS\":true,\"isABNewChannelIcon\":false,\"guideConfig\":{\"waitTime\":20000,\"presentTime\":5000},\"userAgent\":\"Mozilla/5.0
		// (iPhone CPU iPhone OS 10_1 like Mac OS X) AppleWebKit/602.2.14 (KHTML, like
		// Gecko) Version/10.0 MQQBrowser/8.8.2 Mobile/14B72c Safari/602.1 MttCustomUA/2
		// QBWebViewType/1
		// WKType/1\",\"webp\":true,\"oakData\":{\"activityCollection\":{},\"ui\":{\"titleSection\":{\"greenIcon\":{\"id\":24,\"type\":\"极速退款\",\"desc\":\"拼单成功6小时内，待发货状态下，提交退款申请将立即退款\"}},\"liveSection\":{\"onLive\":0},\"bubbleSection\":{\"showBubble\":1},\"skuSection\":{\"viewStyle\":0,\"viewStyleV2\":0},\"bottomBuyingSection\":{\"type\":\"normal\"},\"morePopNaviButton\":{\"naviList\":[{\"iconId\":\"59210\",\"text\":\"常见问题\",\"url\":\"questions.html\"},{\"iconId\":\"59213\",\"text\":\"意见反馈\",\"url\":\"personal_feedback.html\"},{\"iconId\":\"59212\",\"text\":\"举报商品\",\"url\":\"comm_goods_complaint.html?goods_id=167979795253\"}]},\"paneSection\":{\"icon\":\"https://t13img.yangkeduo.com/mobile_live/2020-04-23/1ee46c71-2e04-4352-929a-7cab253e2ff9.gif\",\"title\":\"99+个直播间正在讲解「超好用的面膜」\",\"jumpUrl\":\"/live_list_goods_detail.html?goodsId=167979795253&keyword=%E3%80%8C%E8%B6%85%E5%A5%BD%E7%94%A8%E7%9A%84%E9%9D%A2%E8%86%9C%E3%80%8D%E7%9B%B4%E6%92%AD%E9%97%B4\",\"liveCount\":182},\"priceExplainSection\":{\"pulldownTitle\":\"点击查看商品价格说明\"}},\"goods\":{},\"control\":{},\"review\":{\"reviewNum\":31,\"reviewMergeOuterNum\":0,\"reviewNumText\":\"商品评价(31)\",\"reviewMergeOuterNumText\":\"\",\"reviewInfoList\":[{\"reviewId\":308736341235614500,\"comment\":\"下午收到清洁泥膜，晚上迫不及待打开用了，淡绿色的，淡淡的香味，很好闻，抹到脸上冰冰凉凉的，很舒服，100克满满一盒，很划算，容易清洗，清洁效果很好，感觉脸都白了，干净了！用完了还来买！\",\"specs\":\"[{\\\"spec_key\\\":\\\"容量\\\",\\\"spec_value\\\":\\\"绿茶冰肌清洁面膜1瓶（送粉刺针一支）\\\"}]\",\"time\":1598794559,\"avatar\":\"https://avatar2.pddpic.com/a/Q05pSllLUEt3Rk9RVGEwNkhLSTVndWtjTVZ5RGRIckNxQT09djA0-1600000691?imageMogr2/thumbnail/100x\",\"name\":\"好好的\",\"anonymous\":0,\"orderNumText\":\"\",\"pxqFriendTag\":false,\"isMyReview\":false},{\"reviewId\":307416101062656830,\"comment\":\"昨天刚刚到的，包装很精致，打开之后有淡淡的抹茶味，很好闻，上脸不拔干，对混油皮真的是太好了，用了一下明显感觉黑头减少了，发现了这么好的宝贝，一定要和好朋友分享下的，已经给朋友们发链接了，等用完了下次还会回购的。\",\"specs\":\"[{\\\"spec_key\\\":\\\"容量\\\",\\\"spec_value\\\":\\\"绿茶冰肌清洁面膜1瓶（送粉刺针一支）\\\"}]\",\"time\":1598165020,\"avatar\":\"https://avatar2.pddpic.com/a/Q0l2UnVUSkJmVkY5UG9OVHV2bk1ObWhka0JHQmdPTHUrZz09djA0-1599883712?imageMogr2/thumbnail/100x\",\"name\":\"Carl\",\"anonymous\":0,\"orderNumText\":\"\",\"pxqFriendTag\":false,\"isMyReview\":false}],\"labels\":[],\"merchantQaNumText\":\"\",\"merchantQaTitleText\":\"商品答疑\",\"outerPositiveReviewNumText\":\"\",\"mergeReviewWithOuterReview\":1,\"mallReviewEntranceInfo\":{\"label_list\":[{\"id\":\"8dca4177d45400652107277dbacb87b1\",\"name\":\"效果好\",\"num\":5,\"positive\":1,\"text\":\"效果好(5)\",\"view\":{\"label_type\":0,\"back_color\":\"#FDEFEE\",\"click_back_color\":\"#F7D7D5\",\"select_back_color\":\"#E02E24\",\"text_color\":\"#58595B\",\"click_text_color\":\"#7C7372\",\"select_text_color\":\"#FFFFFF\"}},{\"id\":\"d2f60bef8f00f71e038c5f2ff07d89cb\",\"name\":\"敷舒服\",\"num\":3,\"positive\":1,\"text\":\"敷舒服(3)\",\"view\":{\"label_type\":0,\"back_color\":\"#FDEFEE\",\"click_back_color\":\"#F7D7D5\",\"select_back_color\":\"#E02E24\",\"text_color\":\"#58595B\",\"click_text_color\":\"#7C7372\",\"select_text_color\":\"#FFFFFF\"}},{\"id\":\"4321de561007156245a82d6da365bf0d\",\"name\":\"划算\",\"num\":10,\"positive\":1,\"text\":\"划算(10)\",\"view\":{\"label_type\":0,\"back_color\":\"#FDEFEE\",\"click_back_color\":\"#F7D7D5\",\"select_back_color\":\"#E02E24\",\"text_color\":\"#58595B\",\"click_text_color\":\"#7C7372\",\"select_text_color\":\"#FFFFFF\"}},{\"id\":\"f9a541b2b525faf59aa2a0c5aacc7510\",\"name\":\"贴上很舒服\",\"num\":3,\"positive\":1,\"text\":\"贴上很舒服(3)\",\"view\":{\"label_type\":0,\"back_color\":\"#FDEFEE\",\"click_back_color\":\"#F7D7D5\",\"select_back_color\":\"#E02E24\",\"text_color\":\"#58595B\",\"click_text_color\":\"#7C7372\",\"select_text_color\":\"#FFFFFF\"}},{\"id\":\"0ad8c17dc30f2e42283d0fa81163d64c\",\"name\":\"物流很快\",\"num\":5,\"positive\":1,\"text\":\"物流很快(5)\",\"view\":{\"label_type\":0,\"back_color\":\"#FDEFEE\",\"click_back_color\":\"#F7D7D5\",\"select_back_color\":\"#E02E24\",\"text_color\":\"#58595B\",\"click_text_color\":\"#7C7372\",\"select_text_color\":\"#FFFFFF\"}},{\"id\":\"232a85c70c5abca5c34cd5cd5eea800d\",\"name\":\"包装很好\",\"num\":4,\"positive\":1,\"text\":\"包装很好(4)\",\"view\":{\"label_type\":0,\"back_color\":\"#FDEFEE\",\"click_back_color\":\"#F7D7D5\",\"select_back_color\":\"#E02E24\",\"text_color\":\"#58595B\",\"click_text_color\":\"#7C7372\",\"select_text_color\":\"#FFFFFF\"}},{\"id\":\"a00d04d240a1674261402753bd6d9c7c\",\"name\":\"干净\",\"num\":3,\"positive\":1,\"text\":\"干净(3)\",\"view\":{\"label_type\":0,\"back_color\":\"#FDEFEE\",\"click_back_color\":\"#F7D7D5\",\"select_back_color\":\"#E02E24\",\"text_color\":\"#58595B\",\"click_text_color\":\"#7C7372\",\"select_text_color\":\"#FFFFFF\"}}],\"title_text\":\"该商品所属店铺评价\",\"exps\":{\"mall_functional_label\":{\"strategy_name\":\"V2.3.01\",\"bucket\":4,\"timestamp\":1601817853142}}},\"exps\":{\"label_info\":{\"strategy_name\":\"N\",\"bucket\":16,\"timestamp\":1601817853097},\"mall_functional_label\":{\"strategy_name\":\"V2.3.01\",\"bucket\":4,\"timestamp\":1601817853142},\"goods_detail_perfect_pic\":{\"strategy_name\":\"V2.10\",\"bucket\":17,\"timestamp\":1601817853092},\"goods_detail\":{\"strategy_name\":\"N\",\"bucket\":10,\"timestamp\":1601817853097}},\"goodsID\":167979795253,\"detailList\":[{\"reviewId\":308736341235614500,\"comment\":\"下午收到清洁泥膜，晚上迫不及待打开用了，淡绿色的，淡淡的香味，很好闻，抹到脸上冰冰凉凉的，很舒服，100克满满一盒，很划算，容易清洗，清洁效果很好，感觉脸都白了，干净了！用完了还来买！\",\"specs\":\"[{\\\"spec_key\\\":\\\"容量\\\",\\\"spec_value\\\":\\\"绿茶冰肌清洁面膜1瓶（送粉刺针一支）\\\"}]\",\"time\":1598794559,\"avatar\":\"https://avatar2.pddpic.com/a/Q05pSllLUEt3Rk9RVGEwNkhLSTVndWtjTVZ5RGRIckNxQT09djA0-1600000691?imageMogr2/thumbnail/100x\",\"name\":\"好好的\",\"anonymous\":0,\"orderNumText\":\"\",\"pxqFriendTag\":false,\"isMyReview\":false},{\"reviewId\":307416101062656830,\"comment\":\"昨天刚刚到的，包装很精致，打开之后有淡淡的抹茶味，很好闻，上脸不拔干，对混油皮真的是太好了，用了一下明显感觉黑头减少了，发现了这么好的宝贝，一定要和好朋友分享下的，已经给朋友们发链接了，等用完了下次还会回购的。\",\"specs\":\"[{\\\"spec_key\\\":\\\"容量\\\",\\\"spec_value\\\":\\\"绿茶冰肌清洁面膜1瓶（送粉刺针一支）\\\"}]\",\"time\":1598165020,\"avatar\":\"https://avatar2.pddpic.com/a/Q0l2UnVUSkJmVkY5UG9OVHV2bk1ObWhka0JHQmdPTHUrZz09djA0-1599883712?imageMogr2/thumbnail/100x\",\"name\":\"Carl\",\"anonymous\":0,\"orderNumText\":\"\",\"pxqFriendTag\":false,\"isMyReview\":false}],\"isMergeReview\":1,\"outerPositiveReviewList\":[]}},\"isABRafLoadJS\":true,\"isABBackVisibility\":false,\"isABfastGroupBuyScorll\":false}";
		JsonObject goodObj = new JsonParser().parse(goodJson).getAsJsonObject();
		if (goodObj.get("data") != null) {
			JsonObject goods = goodObj.get("data").getAsJsonObject().get("goods").getAsJsonObject();
			String goodsName = goods.get("goodsName").getAsString();
			Integer catID = goods.get("catID").getAsInt();
			Integer catID1 = goods.get("catID1").getAsInt();
			Integer catID2 = goods.get("catID2").getAsInt();
			Integer catID3 = goods.get("catID3").getAsInt();
			Integer catID4 = goods.get("catID4").getAsInt();
			Integer searchId = catID3;
			if (catID3.equals(0)) {
				searchId = catID2;
				if (catID2.equals(0)) {
					searchId = catID1;
				}
			}
			jobj.addProperty("goods_name", goodsName);
			jobj.addProperty("goods_desc", goodsName);
			jobj.addProperty("cat_id", catID);
			jobj.addProperty("decorationPreview",
					"https://mobile.yangkeduo.com/comm_goods_decoration_preview.html?goods_id=" + goods_id
							+ "&_oak_decoration_token=uuUEKv1a/TN091WY+iN59gU5lKgl90WZ9ONmYPWigtJKCzXlU5Ap9GYt9n+bTZeSKwH5PHeRiseirJ+daKRSGg==");
			jobj.addProperty("service_time", new Date().getTime());
			jobj.addProperty("cost_template_id", getList());
//			jobj.addProperty("cost_template_id", "12131");
			JsonArray gallery = jobj.get("gallery").getAsJsonArray();
			JsonArray viewImageData = goods.get("viewImageData").getAsJsonArray();
			JsonArray detailGallery = goods.get("detailGallery").getAsJsonArray();
			for (int i = 0; i < viewImageData.size(); i++) {
				String url = viewImageData.get(i).getAsString();
				String jsons = store_image(url, goods_commit_id);
				JsonObject result = new JsonParser().parse(jsons).getAsJsonObject().get("result").getAsJsonObject();
				Long id = result.get("id").getAsLong();
				String nurl = result.get("url").getAsString();
				JsonObject viewobj = new JsonObject();
				viewobj.addProperty("url", nurl);
				viewobj.addProperty("type", 1);
				viewobj.addProperty("file_id", id);
				gallery.add(viewobj);
			}
			for (JsonElement jsonElement : detailGallery) {
				JsonObject current = jsonElement.getAsJsonObject();
				String url = current.get("url").getAsString();
				String jsons = store_image(url, goods_commit_id);
				JsonObject result = new JsonParser().parse(jsons).getAsJsonObject().get("result").getAsJsonObject();
				Long id = result.get("id").getAsLong();
				String nurl = result.get("url").getAsString();
				JsonObject viewobj = new JsonObject();
				viewobj.addProperty("url", nurl);
				viewobj.addProperty("type", 2);
				viewobj.addProperty("file_id", id);
				gallery.add(viewobj);
			}
			JsonArray cat_ids = new JsonArray();
			cat_ids.add(catID1);
			cat_ids.add(catID2);
			cat_ids.add(catID3);
			cat_ids.add(catID4);
			jobj.add("gallery", gallery);
			jobj.add("cat_ids", cat_ids);
			String detail = detail(searchId);
			JsonObject catObj = new JsonParser().parse(detail).getAsJsonObject().get("result").getAsJsonObject();
			String cat_id_1_name = catObj.get("cat_id_1_name").getAsString();
			String cat_id_2_name = catObj.get("cat_id_2_name").getAsString();
			String cat_id_3_name = catObj.get("cat_id_3_name").getAsString();
			String cat_id_4_name = catObj.get("cat_id_4_name").getAsString();
			if (cat_id_2_name.equals("")) {
				cat_id_2_name = null;
			}
			if (cat_id_3_name.equals("")) {
				cat_id_3_name = null;
			}
			if (cat_id_4_name.equals("")) {
				cat_id_4_name = null;
			}
			JsonArray cats = new JsonArray();
			cats.add(cat_id_1_name);
			cats.add(cat_id_2_name);
			cats.add(cat_id_3_name);
			cats.add(cat_id_4_name);
			jobj.add("cats", cats);
//			String maxNormalPrice = "29.9";
			Integer market_price = 2990;
//			DecimalFormat df = new DecimalFormat("#.00");
			String market_price_in_yuan = "29.9";
			JsonArray skus = goods.get("skus").getAsJsonArray();
			JsonArray nskus = new JsonArray();
			for (JsonElement jsonElement : skus) {
				String skutemplete = "{\"id\":\"\",\"sku_id\":\"\",\"limit_quantity\":999999,\"out_sku_sn\":\"\",\"is_onsale\":1,\"multi_price_in_yuan\":\"\",\"price_in_yuan\":\"\",\"multi_price\":\"\",\"price\":\"\",\"quantity_delta\":2000,\"thumb_url\":\"\",\"thumb_url_file_id\":\"\",\"weight\":0,\"spec\":[{\"parent_id\":\"\",\"parent_name\":\"\",\"spec_id\":\"\",\"spec_name\":\"\"}],\"length\":null,\"oversea_sku\":{\"specifications\":null,\"measurement_unit\":null,\"taxation\":null},\"sku_srv_templates\":\"\"}";
				JsonObject nsku = new JsonParser().parse(skutemplete).getAsJsonObject();
				JsonObject current = jsonElement.getAsJsonObject();
				Long skuId = current.get("skuId").getAsLong();
				String thumbUrl = current.get("thumbUrl").getAsString();
				Integer quantity = current.get("quantity").getAsInt();
				JsonArray specs = current.get("specs").getAsJsonArray();
				JsonArray newspec = new JsonArray();
				for (JsonElement jsonElement2 : specs) {
					JsonObject spec = jsonElement2.getAsJsonObject();
					String spec_key = spec.get("spec_key").getAsString();
					String spec_value = spec.get("spec_value").getAsString();
					Long spec_key_id = spec.get("spec_key_id").getAsLong();
					Long spec_value_id = spec.get("spec_value_id").getAsLong();
					JsonObject nspec = new JsonObject();
					nspec.addProperty("parent_id", spec_key_id);
					nspec.addProperty("parent_name", spec_key);
					nspec.addProperty("spec_id", spec_value_id);
					nspec.addProperty("spec_name", spec_value);
					newspec.add(nspec);
				}
				String multi_price_in_yuan = "19.9";
//				String price_in_yuan = current.get("normalPrice").getAsString();
				Integer multi_price = 1990;
//				Integer price = new Double(Double.parseDouble(price_in_yuan)*100).intValue();

				String jsons = store_image(thumbUrl, goods_commit_id);
				JsonObject result = new JsonParser().parse(jsons).getAsJsonObject().get("result").getAsJsonObject();
				Long id = result.get("id").getAsLong();
				String nurl = result.get("url").getAsString();

				nsku.addProperty("id", new Date().getTime());
				nsku.addProperty("sku_id", skuId);
				nsku.addProperty("thumb_url", nurl);
				nsku.addProperty("thumb_url_file_id", id);
				nsku.addProperty("quantity", quantity);
				nsku.add("spec", newspec);
				nsku.addProperty("multi_price_in_yuan", multi_price_in_yuan);
				nsku.addProperty("price_in_yuan", multi_price_in_yuan);
				nsku.addProperty("multi_price", multi_price);
				nsku.addProperty("price", multi_price);
				nskus.add(nsku);
			}
			jobj.add("skus", nskus);
			jobj.addProperty("market_price_in_yuan", market_price_in_yuan);
			jobj.addProperty("market_price", market_price);
			return jobj.toString();
		} else {
			return null;
		}
//		JsonObject groups = obj.get("groups").getAsJsonObject();
//		String single_price = goods.get("minNormalPrice").getAsString();
//		String group_price = goods.get("minGroupPrice").getAsString();

//		System.out.println(obj.get("goods_id").getAsString());
	}

	public static String save(String goods_id, String goods_commit_id, String itemId, Integer catID) {
		String json = "{\"goods_id\":\"\",\"goods_commit_id\":\"\",\"check_status\":0,\"tiny_name\":\"\",\"goods_name\":\"\",\"carousel_video\":[],\"detail_video\":[],\"goods_desc\":\"\",\"warm_tips\":\"\",\"cat_id\":\"\",\"cats\":[],\"image_url\":\"\",\"oversea_goods\":{},\"spu\":{},\"isbn_properties_related\":{\"isInit\":false},\"propertys_standard\":[],\"is_draft\":true,\"goods_name_prefix\":\"\",\"size_spec_id\":null,\"is_gold_price_matched\":null,\"hasBatchEnter\":false,\"third_type\":0,\"cat_ids\":[],\"bad_fruit_claim\":0,\"booking_notes\":{},\"shoes_template_id\":null,\"service_time\":"
				+ new Date().getTime()
				+ ",\"electric_status\":0,\"propertys_tid\":27570,\"spu_cate_type\":0,\"decorationPreview\":\"https://mobile.yangkeduo.com/comm_goods_decoration_preview.html?goods_id=\\\"\\\"&amp;_oak_decoration_token=uuUEKv1a/TN091WY+iN59gU5lKgl90WZ9ONmYPWigtJKCzXlU5Ap9GYt9n+bTZeSKwH5PHeRiseirJ+daKRSGg==\",\"size_parent_spec_id\":null,\"is_shop\":1,\"goods_type\":1,\"invoice_status\":0,\"invoice_mode\":null,\"zhi_huan_bu_xiu\":0,\"quan_guo_lian_bao\":0,\"second_hand\":0,\"is_pre_sale\":0,\"pre_sale_time\":\"\",\"country_id\":\"0\",\"origin_country_id\":0,\"warehouse\":\"\",\"customs\":\"\",\"is_customs\":0,\"shipment_limit_second\":172800,\"cost_template_id\":\"\",\"weight\":\"\",\"groups\":{\"single_price\":0,\"group_price\":0,\"carnival_price\":null,\"customer_num\":2,\"buy_limit\":999999,\"order_limit\":999999,\"regular_limit\":null,\"regular_limit_duration\":null,\"min_num_of_order\":null},\"is_folt\":1,\"is_refundable\":1,\"lack_of_weight_claim\":0,\"goods_pattern\":0,\"customizable\":0,\"local_service_id_list\":null,\"shop_group_id\":0,\"schedule_sale\":{\"sale_type\":0},\"card_verification_list\":[],\"origin_is_pre_sale\":0,\"isCoupon\":false,\"cost_template_error\":null,\"elec_goods_attributes\":null,\"delivery_one_day\":0,\"mai_jia_zi_ti\":null,\"shang_men_an_zhuang\":null,\"song_huo_an_zhuang\":null,\"song_huo_ru_hu\":null,\"goods_srv_templates\":[{\"type\":7,\"id\":null}],\"skus\":[],\"market_price_in_yuan\":\"\",\"market_price\":\"\",\"out_goods_sn\":\"\",\"dead_line_seconds\":86399,\"gold_price_template_id\":0,\"processing_charges\":0,\"processing_charges_in_yuan\":\"0\",\"gallery\":[],\"is_group_pre_sale\":0,\"goods_properties\":[{\"template_pid\":163882,\"template_module_id\":33513,\"ref_pid\":310,\"pid\":5,\"vid\":80018,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163883,\"template_module_id\":33513,\"ref_pid\":351,\"pid\":34,\"vid\":83615,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163883,\"template_module_id\":33513,\"ref_pid\":351,\"pid\":34,\"vid\":327016,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163883,\"template_module_id\":33513,\"ref_pid\":351,\"pid\":34,\"vid\":83763,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163884,\"template_module_id\":33513,\"ref_pid\":1211,\"pid\":338,\"vid\":83618,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163885,\"template_module_id\":33513,\"ref_pid\":482,\"pid\":93,\"vid\":24044,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163886,\"template_module_id\":33513,\"ref_pid\":1563,\"pid\":453,\"vid\":325892,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163887,\"template_module_id\":33513,\"ref_pid\":1471,\"pid\":323,\"vid\":0,\"value_unit\":\"\"}],\"is_auto_save\":false,\"validate_message\":\"9e94fb2305685a419976de10fbdf5e51c47bfbb2e4d5db61b8a2730f242d8327\",\"crawlerInfo\":\""
				+ queryGoodsRank.getkey() + "\"}";
		JsonObject jobj = new JsonParser().parse(json).getAsJsonObject();
		jobj.addProperty("goods_id", goods_id);
		jobj.addProperty("goods_commit_id", goods_commit_id);
		String goodJson = api(itemId);
		JsonObject obj = new JsonParser().parse(goodJson).getAsJsonObject();
		JsonObject desc = obj.get("data").getAsJsonObject().get("desc").getAsJsonObject();
		JsonArray array = desc.get("data").getAsJsonObject().get("wdescContent").getAsJsonObject().get("pages")
				.getAsJsonArray();
		JsonObject apiStack = obj.get("data").getAsJsonObject().get("apiStack").getAsJsonArray().get(0)
				.getAsJsonObject();
		JsonObject item = null;
		JsonElement skuBase = null;
		try {
			item = apiStack.get("value").getAsJsonObject().get("item").getAsJsonObject();
			skuBase = apiStack.get("value").getAsJsonObject().get("skuBase");

		} catch (Exception e) {
			// TODO: handle exception
			item = obj.get("data").getAsJsonObject().get("item").getAsJsonObject();
		}
		JsonArray props = null;
		if (!(skuBase == null)) {
			skuBase = apiStack.get("value").getAsJsonObject().get("skuBase").getAsJsonObject();
			props = skuBase.getAsJsonObject().get("props").getAsJsonArray();
		} else {
			props = new JsonParser().parse(
					"[{\"pid\":\"10066392\",\"name\":\"规格\",\"values\":[{\"vid\":\"3277918\",\"name\":\"一只装\"}]}]")
					.getAsJsonArray();
		}
		Integer market_price = 5000;
		String market_price_in_yuan = "50.00";
		String skutemplete = "{\"id\":\"\",\"sku_id\":\"\",\"limit_quantity\":999999,\"out_sku_sn\":\"\",\"is_onsale\":1,\"multi_price_in_yuan\":\"\",\"price_in_yuan\":\"\",\"multi_price\":\"\",\"price\":\"\",\"quantity_delta\":2000,\"thumb_url\":\"\",\"thumb_url_file_id\":\"\",\"weight\":0,\"spec\":[{\"parent_id\":\"\",\"parent_name\":\"\",\"spec_id\":\"\",\"spec_name\":\"\"}],\"length\":null,\"oversea_sku\":{\"specifications\":null,\"measurement_unit\":null,\"taxation\":null},\"sku_srv_templates\":\"\"}";
		Integer quantity = 9999;
		JsonArray nskus = new JsonArray();
		JsonArray values = new JsonArray();
		for (JsonElement prop : props) {
			JsonArray value = prop.getAsJsonObject().get("values").getAsJsonArray();
			for (JsonElement jsonElement : value) {
				JsonObject O = new JsonObject();
				String vid = jsonElement.getAsJsonObject().get("vid").getAsString();
				String cname = jsonElement.getAsJsonObject().get("name").getAsString();
				O.addProperty("vid", vid);
				O.addProperty("cname", cname);
				values.add(O);
			}
		}
		for (int i = 0; i < values.size(); i++) {
			if (i > 0) {
				break;
			}
			System.out.println(values.get(i));
			System.out.println(values);
			JsonObject nsku = new JsonParser().parse(skutemplete).getAsJsonObject();
			String multi_price_in_yuan = "29.99";
			Integer multi_price = 2999;
			Random r = new Random();
			nsku.addProperty("id", new Date().getTime());
			nsku.addProperty("sku_id",
					Long.parseLong(String.valueOf(new Date().getTime() + r.nextInt(999)).substring(1)));
			nsku.addProperty("thumb_url", "");
			nsku.addProperty("thumb_url_file_id", 0);
			nsku.addProperty("quantity", quantity);
			nsku.addProperty("multi_price_in_yuan", multi_price_in_yuan);
			nsku.addProperty("price_in_yuan", multi_price_in_yuan);
			nsku.addProperty("multi_price", multi_price);
			nsku.addProperty("price", multi_price);
			for (JsonElement cprop : props) {
				JsonArray newspec = new JsonArray();
				JsonObject nspec = new JsonObject();
				String name = cprop.getAsJsonObject().get("name").getAsString();
				String pid = cprop.getAsJsonObject().get("pid").getAsString();
				System.out.println(name);
				System.out.println(pid);
				nspec.addProperty("parent_id", Integer.parseInt(pid.substring(0, 4)));
				nspec.addProperty("parent_name", name);
				nspec.addProperty("spec_id",
						Integer.parseInt(String.valueOf(new Date().getTime() + new Random().nextInt(10)).substring(4)));
				nspec.addProperty("spec_name", values.get(i).getAsJsonObject().get("cname").getAsString());
				newspec.add(nspec);
				nsku.add("spec", newspec);
			}
			nskus.add(nsku);
		}
		JsonArray gallery = jobj.get("gallery").getAsJsonArray();
		String title = "";
		try {
			title = item.get("title").getAsString();
		} catch (Exception e) {
			// TODO: handle exception
			item = obj.get("data").getAsJsonObject().get("item").getAsJsonObject();
			title = item.get("title").getAsString();
		}
		System.out.println(item);
		jobj.addProperty("goods_name", title);
		jobj.addProperty("goods_desc", title);
		jobj.addProperty("cat_id", catID);
		jobj.addProperty("decorationPreview",
				"https://mobile.yangkeduo.com/comm_goods_decoration_preview.html?goods_id=" + goods_id
						+ "&_oak_decoration_token=uuUEKv1a/TN091WY+iN59gU5lKgl90WZ9ONmYPWigtJKCzXlU5Ap9GYt9n+bTZeSKwH5PHeRiseirJ+daKRSGg==");
		jobj.addProperty("service_time", new Date().getTime());
		jobj.addProperty("cost_template_id", getList());
		for (JsonElement jsonElement : array) {
			String imgurl = jsonElement.getAsString();
			imgurl = "https:" + imgurl;
			if (imgurl.contains("gw.alicdn.com") || !imgurl.contains("//")) {
				continue;
			}
			String jsons = store_image(imgurl, goods_commit_id);
			JsonObject result = new JsonParser().parse(jsons).getAsJsonObject().get("result").getAsJsonObject();
			Long id = result.get("id").getAsLong();
			String nurl = result.get("url").getAsString();
			JsonObject viewobj = new JsonObject();
			viewobj.addProperty("url", nurl);
			viewobj.addProperty("type", 2);
			viewobj.addProperty("file_id", id);
			gallery.add(viewobj);
		}
		JsonArray images = null;
		try {
			images = item.get("images").getAsJsonArray();
		} catch (Exception e) {
			// TODO: handle exception
			item = obj.get("data").getAsJsonObject().get("item").getAsJsonObject();
			images = item.get("images").getAsJsonArray();
		}
		for (JsonElement jsonElement : images) {
			String url = jsonElement.getAsString();
			if (url.startsWith("http") == false) {
				url = "https:" + url;
			}
			String jsons = store_image(url, goods_commit_id);
			JsonObject result = new JsonParser().parse(jsons).getAsJsonObject().get("result").getAsJsonObject();
			Long id = result.get("id").getAsLong();
			String nurl = result.get("url").getAsString();
			JsonObject viewobj = new JsonObject();
			viewobj.addProperty("url", nurl);
			viewobj.addProperty("type", 1);
			viewobj.addProperty("file_id", id);
			gallery.add(viewobj);
		}
		jobj.add("gallery", gallery);
		String detail = detail(catID);
		JsonObject catObj = new JsonParser().parse(detail).getAsJsonObject().get("result").getAsJsonObject();
		String cat_id_1_name = catObj.get("cat_id_1_name").getAsString();
		String cat_id_2_name = catObj.get("cat_id_2_name").getAsString();
		String cat_id_3_name = catObj.get("cat_id_3_name").getAsString();
		String cat_id_4_name = catObj.get("cat_id_4_name").getAsString();
		Integer cat_id_1 = catObj.get("cat_id_1").getAsInt();
		Integer cat_id_2 = catObj.get("cat_id_2").getAsInt();
		Integer cat_id_3 = catObj.get("cat_id_3").getAsInt();
		Integer cat_id_4 = catObj.get("cat_id_4").getAsInt();

		if (cat_id_2_name.equals("")) {
			cat_id_2_name = null;
		}
		if (cat_id_3_name.equals("")) {
			cat_id_3_name = null;
		}
		if (cat_id_4_name.equals("")) {
			cat_id_4_name = null;
		}
		JsonArray cat_ids = new JsonArray();
		cat_ids.add(cat_id_1);
		cat_ids.add(cat_id_2);
		cat_ids.add(cat_id_3);
		cat_ids.add(cat_id_4);
		jobj.add("cat_ids", cat_ids);
		JsonArray cats = new JsonArray();
		cats.add(cat_id_1_name);
		cats.add(cat_id_2_name);
		cats.add(cat_id_3_name);
		cats.add(cat_id_4_name);
		jobj.add("cats", cats);
		jobj.add("skus", nskus);
		jobj.addProperty("market_price_in_yuan", market_price_in_yuan);
		jobj.addProperty("market_price", market_price);
		return jobj.toString();
	}
	
	public static String save(String goods_id, String goods_commit_id, String itemId, Integer catID,boolean isali) {
		String ali = "{\"data\":{\"data\":{\"offerdetail_ditto_title\":{\"customIconUrlTag\":\"\",\"subject\":\"秋冬欧美女装速卖通时尚纯色打底毛衣长袖弹力修身高领针织连衣裙\",\"iconClassName\":\"\",\"useDefaultStyle\":\"true\",\"customIconJudgeTag\":\"false\",\"isConsignPCPage\":\"false\",\"extends\":{\"buyerProtection\":\"[\\\"jqbz\\\",\\\"swtbh\\\",\\\"czbz\\\"]\",\"detail_url\":[\"https://cbu01.alicdn.com/img/ibank/2019/535/732/11815237535_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/958/139/13126931859_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/665/096/11761690566_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/659/876/11761678956_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/907/486/11761684709_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/220/627/11761726022_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/069/575/11793575960_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/250/117/11761711052_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/932/026/11725620239_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/509/276/11761672905_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/230/417/11761714032_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/281/236/11725632182_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/156/275/11793572651_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/002/096/11761690200_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/670/807/11761708076_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/969/065/11793560969_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/919/966/11761669919_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/550/060/13047060055_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/690/750/13047057096_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/537/107/13085701735_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/152/679/13126976251_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/755/707/13085707557_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/388/989/11725989883_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/086/329/11793923680_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/855/410/11762014558_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/228/800/11762008822_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/164/620/11762026461_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/953/017/12368710359_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/530/827/12368728035_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/614/125/12331521416_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/058/194/12331491850_237947431.jpg\",\"https://cbu01.alicdn.com/img/ibank/2019/934/117/12404711439_237947431.jpg\"],\"consign_price\":\"4200998533716:38.0;4200998533717:38.0;4200998533718:38.0;4200998533719:38.0;4200998533712:38.0;4200998533713:38.0;4200998533714:38.0;4200998533715:38.0;4200998533720:38.0;4200998533721:38.0;4200998533722:38.0;4200998533700:38.0;4200998533701:38.0;4200998533702:38.0;4200998533703:38.0;4200998533696:38.0;4200998533697:38.0;4200998533698:38.0;4200998533699:38.0;4200998533708:38.0;4200998533709:38.0;4200998533710:38.0;4200998533711:38.0;4200998533704:38.0;4200998533705:38.0;4200998533706:38.0;4200998533707:38.0;4200998533684:38.0;4200998533685:38.0;4200998533686:38.0;4200998533687:38.0;4200998533683:38.0;4200998533692:38.0;4200998533693:38.0;4200998533694:38.0;4200998533695:38.0;4200998533688:38.0;4200998533689:38.0;4200998533690:38.0;4200998533691:38.0;\",\"productlineId\":\"[-1]\",\"pmFactoryName\":\"萝蔓特莱迪娅\",\"tradeTemplateId\":\"[]\",\"seocontent\":\"高领针织连衣裙_秋冬欧美女装纯色打底毛衣长袖弹力高领针织 - 阿里巴巴\\u0001高领针织连衣裙@@修身针织连衣裙@@修身连衣裙@@欧美女装@@时尚打底毛衣\",\"TAGS\":\"270850,1448449,1861377,2356225,3353345,3778561,3760385,3793921,3791361,3791873,3750657,3775489,3780097,3789057,3756801,3747841,3705857,3889665,3878657,3889153,3873025,3889409,3880449,3824129,3823361,3823873,3823617,3823105,3833857,3825665,3820289,3810817,3822849,3824641,3824385,3824897,3825153,3825409,3997697,4020225,4016129,3953153,3937537,2105409,3767873,3784257,3795521,3748161,3752513,3753793,3750721,3778625,3768385,3760449,3763265,3765825,3881793,3889729,3824193,3825729,3823937,3823681,3828289,3833921,3823425,3820097,3823169,3822913,3819841,3803201,3825217,3825473,3824961,3824449,3824705,4001345,4020801,3957569,3950401,3977281,3983425,3945793,271234,271746,286850,3779201,3768961,3763329,3760513,3770753,3754113,3786113,3790721,3791233,3784321,3747969,3913345,3873409,3889793,3924609,3913089,3923329,3921537,3872385,3824001,3825281,3825537,3823489,3823233,3823745,3833985,3833729,3825793,3828353,3822977,3820417,3822721,3824513,3824257,3824769,3825025,3819393,3810689,3954561,3953025,3948929,3937409,286914,3775425,3778241,3760321,3759809,3778497,3778753,3788993,3786177,3768001,3768769,3765185,3761345,3791297,3800001,3792321,3696321,3889601,3926721,3881409,3823809,3823553,3823297,3822785,3823041,3824065,3824321,3825857,3849921,3833793,3828417,3832001,3825601,3825345,3819713,3801793,3811777,3819969,3820225,3820993,3824577,3825089,3824833,4016065,3954625,3966913,3937473,3964865,3982273\",\"detail_template_info\":\"[{\\\"contentUrl\\\":\\\"https://img.alicdn.com/tfscom/TB1VEFLz1L2gK0jSZPhXXahvXXa\\\",\\\"id\\\":\\\"0\\\",\\\"title\\\":\\\"图文详情\\\"}]\"},\"cssUrl\":\"\",\"offerIcon\":\"\",\"showType\":\"type-1\",\"labels2show\":[{\"tagName\":\"一件代发\"}],\"newStyle\":\"newtag\",\"staticServer\":\"https://astyle-src.alicdn.com/app/dsc\"},\"offerdetail_common_report\":{\"surveyURL\":\"http://survey.china.alibaba.com/index.php\",\"isMicroSupply\":\"false\",\"editOfferTarget\":\"offer/post/fillProductInfo.htm\",\"isOfferEditable\":false,\"uuidString\":\"4572A3C8D7C64DE6A39E534041137515\",\"cssUrl\":\"\",\"authenticatedName\":\"萝蔓特莱迪娅源头厂家\",\"editOfferDomain\":\"https://offer.1688.com\",\"offerModule\":\"https://exodus.1688.com/offer\",\"offerId\":600830894051,\"showType\":\"type-1\",\"isVIPMallOffer\":false,\"staticServer\":\"https://astyle-src.alicdn.com/app/dsc\",\"levitServer\":\"http://levit.1688.com\",\"offerwebServer\":\"https://offer.1688.com\",\"memberId\":\"b2b-2899251206a37e2\"},\"offerdetail_ditto_serviceDesc\":{\"sevenDaysRefundCategorySupport\":true,\"cssUrl\":\"\",\"showType\":\"type-1\",\"useDefaultStyle\":\"true\",\"sevenDaysRefundOfferSupport\":true,\"staticServer\":\"https://astyle-src.alicdn.com/app/dsc\"},\"offerdetail_ditto_preferential\":{\"isSupportMix\":true,\"isOfferSupportOnlineTrade\":true,\"show\":true,\"showTickets\":\"true\",\"mixNumber\":1,\"userId\":2899251206,\"unit\":\"件\",\"isActivityTime\":false,\"pageType\":\"\",\"companySiteLink\":\"//shop1464628156742.1688.com\",\"cssUrl\":\"\",\"isFanli\":false,\"aggregatePromotionInfo\":[{\"detailPromotionModels\":[{\"bizType\":1,\"canApply\":false,\"mixNumber\":1,\"promotionDisplayName\":\"混批\",\"promotionInfoDetail\":\"本店部分商品满1件可混批采购\",\"promotionInfoSummary\":\"本店部分商品满1件可混批采购\",\"promotionInfoType\":\"MIX_WHOLESALE\",\"promotionLabel\":\"混批\",\"wholesaleDetail\":\"\"}],\"promotionExtend\":{\"uiType\":\"CARD\"},\"promotionName\":\"混批\",\"promotionType\":\"MIX_WHOLESALE\"}],\"isCzbz\":true,\"baseActivityUrl\":\"https://shop1464628156742.1688.com/page/promotion.htm?activityId=\",\"showType\":\"type-1\",\"offerId\":600830894051,\"staticServer\":\"https://astyle-src.alicdn.com/app/dsc\"},\"offerdetail_ditto_postage\":{\"showDestinationArea\":true,\"unitWeight\":0.59999999999999997779553950749686919152736663818359375,\"note\":\"\",\"isTgcSKUOffer\":false,\"offerExtends\":{\"$ref\":\"$.data.data.offerdetail\\\\_ditto\\\\_title.extends\"},\"currentCity\":\"\",\"isGlobalOffer\":false,\"currentCountry\":\"CN_1001\",\"cssUrl\":\"\",\"price\":\"40.00\",\"beginAmount\":2,\"spsServiceNames\":[\"jqbz\",\"swtbh\",\"czbz\"],\"showType\":\"type-1\",\"excludeAreaCode4FreePostage\":\"ALL\",\"freightLocation\":\"广东省 东莞市\",\"cashOnDeliveryOffer\":false,\"flow\":\"general\",\"staticServer\":\"https://astyle-src.alicdn.com/app/dsc\",\"freightTemplateId\":10029587,\"targetCode\":\"\",\"laputaServer\":\"https://laputa.1688.com\",\"countdown\":0,\"isPromotionOffer4PC\":false,\"showFreightCost\":true,\"unit\":\"件\",\"deliveryFee\":\"TEMPLATED\",\"isForbidden\":false,\"hasPromotion\":\"true\",\"showPromotionFree\":false,\"freeDeliverFee\":false,\"freightCost\":[{\"costItems\":[{\"code\":\"freight\",\"name\":\"运费\",\"value\":7.00}],\"subTemplateName\":\"快递\",\"subTemplateType\":0,\"totalCost\":7.00}],\"currentProvince\":\"\"},\"offerdetail_ditto_offerSatisfaction\":{\"saleTotal\":200,\"payOrder30DayStr\":\"8000+\",\"invokeRateSucess\":true,\"isOfferSupportOnlineTrade\":true,\"unit\":\"件\",\"rateCount\":5,\"offerRemarkStar\":\"https://rate.1688.com/remark/offerDetail/basicStatistics.json\",\"rateCountStr\":\"5\",\"cssUrl\":\"\",\"saleTotalStr\":\"200+\",\"offerId\":600830894051,\"showType\":\"type-1\",\"starLevel\":45,\"isIndustryOffer\":false,\"staticServer\":\"https://astyle-src.alicdn.com/app/dsc\"},\"offerdetail_w1190_guarantee\":{\"issuingInfo\":{\"marketName\":\"\",\"stallNum\":\"\",\"contactWangWang\":\"\",\"contactPhone\":\"\",\"floor\":\"\",\"stallName\":\"\"},\"isShowCharge\":\"true\",\"showGuarantee\":true,\"showFinanceLogo\":true,\"showSubGuarantee\":\"true\",\"isSLSJ\":true,\"pageType\":\"\",\"cssUrl\":\"\",\"stdProtectionList\":[{\"longDescription\":\"卖家在承诺买家保障服务的基础上，自愿选择向买家提供“交期保障”服务。卖家向买家承诺，买家通过在线交易方式成功下单付款后，卖家将在双方确定的交期内（不可抗力因素除外），发送买家所购实物商品的服务，否则向买家进行赔付\",\"logoUrl_64_64\":\"https://cbu01.alicdn.com/cms/upload/2015/077/805/2508770_1964054271.png\",\"serviceLink\":\"https://page.1688.com/buyerprotection/buyer.html\",\"serviceCode\":\"jqbz\",\"logoUrl_16_16\":\"https://cbu01.alicdn.com/cms/upload/2015/508/605/2506805_1964054271.png\",\"description\":\"该卖家已开通交期保障服务，承诺会在双方确定的交期内发货。\",\"serviceName\":\"交期保障\"},{\"longDescription\":\"卖家在承诺买家保障服务的基础上，自愿选择向买家提供“15天包换”的服务。当买家通过支付宝担保交易购买支持“15天包换 ”服务的商品，签收货物后15天内，对无人为损坏的商品提供更换服务。如卖家未履行前述承诺，买家可在指定期限内发起维权，并申请赔付。\",\"logoUrl_64_64\":\"https://cbu01.alicdn.com/cms/upload/2015/810/615/2516018_1964054271.png\",\"serviceLink\":\"https://page.1688.com/buyerprotection/buyer.html\",\"serviceCode\":\"swtbh\",\"logoUrl_16_16\":\"https://cbu01.alicdn.com/cms/upload/2015/577/505/2505775_1964054271.png\",\"description\":\"该卖家已开通15天包换服务，您可在签收货物后的15天内更换商品。\",\"serviceName\":\"15天包换\"},{\"longDescription\":\"卖家在承诺买家保障服务的基础上，自愿选择向买家提供的保障服务。卖家承诺该款产品均符合与买家事先协商确认的材质要求，否则将按照货款金额的20%（但最高不超过10000元）对买家进行赔偿。\",\"logoUrl_64_64\":\"https://cbu01.alicdn.com/cms/upload/2015/340/415/2514043_1964054271.png\",\"serviceLink\":\"https://show.1688.com/dacu/common/rcxhdczbzfwbzsmkt.html?pageId=22018&amp;cms_id=22018\",\"serviceCode\":\"czbz\",\"logoUrl_16_16\":\"https://cbu01.alicdn.com/cms/upload/2015/539/305/2503935_1964054271.png\",\"description\":\"卖家承诺该款产品符合与买家事先协商确认的材质要求，否则将对买家进行赔偿。\",\"serviceName\":\"材质保障\"}],\"isShowInsList\":\"true\",\"showType\":\"type-1\",\"staticServer\":\"https://astyle-src.alicdn.com/app/dsc\",\"financeLogoList\":[{\"creditSource\":\"creditbuy_seller\",\"link\":\"https://rongzi.1688.com/creditbuy/index.htm?role=buyer&amp;tracelog=ces_offerdetail_wkt\",\"hoverMsg\":\"该产品已支持诚e赊最长38天账期\",\"serviceName\":\"免费赊账\",\"logoUrl\":\"https://cbu01.alicdn.com/cms/upload/2015/188/805/2508881_1265251585.png\"}],\"productInsList\":[],\"offerSign\":{\"aegisTrade\":true,\"alipaySupported\":true,\"batchOffer\":false,\"bestOffer\":false,\"brandAuth\":false,\"bt\":false,\"carefreeIssuingOffer\":false,\"cautionOffer\":false,\"centralized\":false,\"cod\":false,\"consignAuthoffer\":false,\"consignMarketOffer\":true,\"consignOffer\":true,\"crazyShopPromotionOffer\":false,\"crossBorderDistributionOffer\":true,\"crossBorderOffer\":true,\"cuntaoOffer\":false,\"dailySpecialPriceOffer\":false,\"easyOffer\":false,\"flashSale\":false,\"hasFreightTemplate\":true,\"hasProcessCapacity\":false,\"hasSendGoodsAddress\":true,\"hasStockFabric\":false,\"hasUseSpu\":false,\"hpDaoPiOffer\":false,\"hxpOffer\":false,\"iECOffer\":false,\"industryStandardOffer\":false,\"installmentOffer\":false,\"is94VoucherOffer\":false,\"issuing\":false,\"kd\":false,\"ladderGroupOffer\":false,\"limitedGroup\":false,\"lstOffer\":false,\"microSupply\":false,\"microSupplyoffer\":false,\"mobileOffer\":false,\"nPorcessingOffer\":false,\"nProcessingSampleOffer\":false,\"nyg\":false,\"oneCentSampleOffer\":false,\"optimizationOffer\":false,\"picAuthOffer\":false,\"plasticSPU\":false,\"priceAuthOffer\":false,\"processingOffer\":false,\"productionLine\":false,\"promotionOffer\":false,\"rangePriceSku\":false,\"regionalSaleOffer\":false,\"retailOffer\":false,\"sKUOffer\":true,\"sample\":false,\"sellerHotRecommendOffer\":false,\"sevenDaysRefund\":true,\"signs\":{\"isBuyerProtection\":true,\"isConsignMarketOffer\":true,\"isCrossBorderOffer\":true,\"isSupportMix\":true,\"isWholesaleOffer\":true,\"hasFreightTemplate\":true,\"isGovCouponOfferInOD\":false,\"isYtdfOffer\":true,\"hasSearchPicture\":true,\"hasWhitePicInOffer\":true,\"sevenDaysRefund\":true,\"hasOrder\":true,\"isTbDistributionOffer\":true,\"isAegisTrade\":true,\"isDgcdhbOffer\":true,\"isSkuTradeSupported\":true,\"isSearchOffer\":true,\"isCBDistribution\":true,\"isZeroWholesaleOffer\":true,\"isAlipaySupported\":true,\"isSupportStock\":true,\"isSwtbh\":true,\"isSupportVideo\":true,\"hasSendGoodsAddress\":true,\"isAvailableForTm\":true},\"skuTradeSupported\":true,\"sourceIssuingOffer\":true,\"specialSupply\":false,\"stdProductOffer\":false,\"supportMix\":true,\"supportReserveOffer\":false,\"supportStock\":true,\"surprintOffer\":false,\"tgcKbOrder\":false,\"tgcSKUOffer\":false,\"tmallPurchaseOffer\":false,\"toCPlatformOffer\":false,\"traceSourceQualityGuarantee\":false,\"ump\":false,\"vIPMallOffer\":false,\"wholesaleCenterOffer\":false}},\"offerdetail_w1190_tradeWay\":{\"isAccountPeriod\":true,\"isSample\":false,\"isSupportMix\":true,\"showInstallmentInfo\":false,\"isTgcSKUOffer\":false,\"isOfferSupportOnlineTrade\":true,\"tradeConfigServer\":\"https://tradeconfig.1688.com\",\"isJinPiaoPay\":true,\"isSupportCreditCard\":true,\"mixNumber\":1,\"isArrivalCycle\":true,\"unit\":\"件\",\"sellerId\":2899251206,\"names\":[\"担保交易\",\"银行转账\"],\"isForbidden\":false,\"cssUrl\":\"\",\"showType\":\"type-1\",\"isNetBizBank\":false,\"cashOnDeliveryOffer\":false,\"staticServer\":\"https://astyle-src.alicdn.com/app/dsc\"},\"offerdetail_ditto_whosaleself\":{\"isBestOffer\":false,\"majorRecommendOfferInfos\":[{\"saleAmount\":150314,\"publishTime\":1464928405000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":false,\"bigPromotion\":false,\"title\":\"亚马逊 速卖通 女装性感背心长裙经典时尚连衣裙多码多色个性\",\"unit\":\"件\",\"price\":18.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2018/178/137/9125731871_237947431.jpg\",\"offerId\":532988015620,\"publishWithin7days\":false},{\"saleAmount\":31833,\"publishTime\":1464928382000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":true,\"bigPromotion\":false,\"title\":\"欧美热销亚马逊 速卖通 女装性感背心长裙时尚长袖个性连衣裙\",\"unit\":\"件\",\"price\":24.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2018/177/709/9670907771_237947431.jpg\",\"offerId\":533049522005,\"publishWithin7days\":false},{\"saleAmount\":32068,\"publishTime\":1464928359000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":true,\"bigPromotion\":false,\"title\":\"欧美外贸平台不规则新款女装 ebay亚马逊新款性感纯色打底衫现货\",\"unit\":\"件\",\"price\":15.5,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2020/536/911/13869119635_237947431.jpg\",\"offerId\":533048558336,\"publishWithin7days\":false},{\"saleAmount\":59662,\"publishTime\":1482062547000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":false,\"bigPromotion\":false,\"title\":\"Ebay亚马逊Wish货源性感热卖女装 12色长袖高领修身百搭连体裤冬\",\"unit\":\"件\",\"price\":17.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2019/303/028/12195820303_237947431.jpg\",\"offerId\":543423727465,\"publishWithin7days\":false},{\"saleAmount\":21997,\"publishTime\":1559800679000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":true,\"bigPromotion\":false,\"title\":\"ebay速卖通外贸女装 欧美时尚纯色长裙 长袖弹力修身高领连衣裙\",\"unit\":\"件\",\"price\":25.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2020/691/506/13635605196_237947431.jpg\",\"offerId\":596081397109,\"publishWithin7days\":false},{\"saleAmount\":13380,\"publishTime\":1550985662000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":true,\"bigPromotion\":false,\"title\":\"速卖通ebay性感深V领松紧腰印花连衣裙 度假家居服加大码女装\",\"unit\":\"件\",\"price\":28.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2019/092/117/10438711290_237947431.jpg\",\"offerId\":587835851111,\"publishWithin7days\":false},{\"saleAmount\":10032,\"publishTime\":1480748774000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":true,\"bigPromotion\":false,\"title\":\"欧洲站性感纯色无袖深V领松紧腰连衣裙 外贸加大码女装家居服\",\"unit\":\"件\",\"price\":25.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2019/613/741/10856147316_237947431.jpg\",\"offerId\":542684708527,\"publishWithin7days\":false},{\"saleAmount\":78611,\"publishTime\":1464928369000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":true,\"bigPromotion\":false,\"title\":\"欧洲站速卖通亚马逊 13色性感长袖夜店打底裙裤 秋季新款外贸女装\",\"unit\":\"件\",\"price\":16.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2020/480/003/13785300084_237947431.jpg\",\"offerId\":533047922616,\"publishWithin7days\":false},{\"saleAmount\":33598,\"publishTime\":1468155758000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":false,\"bigPromotion\":false,\"title\":\"速卖通 wish夏季新款圆领修身褶皱裙收腰包臀无袖大摆开叉连衣裙\",\"unit\":\"件\",\"price\":24.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2016/930/313/3218313039_237947431.jpg\",\"offerId\":535418159997,\"publishWithin7days\":false},{\"saleAmount\":46433,\"publishTime\":1464928354000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":false,\"bigPromotion\":false,\"title\":\"欧美外贸速卖通女装ebay性感wish高腰V领阔腿裤不规则套装带腰带\",\"unit\":\"条\",\"price\":29.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2016/712/533/3105335217_237947431.jpg\",\"offerId\":533048126513,\"publishWithin7days\":false}],\"detailServer\":\"https://detail.1688.com\",\"offerExtends\":{\"$ref\":\"$.data.data.offerdetail\\\\_ditto\\\\_title.extends\"},\"showType\":\"type-1\",\"relationRecommendOfferInfos\":[],\"sellerRecommendOfferInfo\":{\"majorRecommendOfferInfos\":[{\"saleAmount\":150314,\"publishTime\":1464928405000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":false,\"bigPromotion\":false,\"title\":\"亚马逊 速卖通 女装性感背心长裙经典时尚连衣裙多码多色个性\",\"unit\":\"件\",\"price\":18.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2018/178/137/9125731871_237947431.jpg\",\"offerId\":532988015620,\"publishWithin7days\":false},{\"saleAmount\":31833,\"publishTime\":1464928382000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":true,\"bigPromotion\":false,\"title\":\"欧美热销亚马逊 速卖通 女装性感背心长裙时尚长袖个性连衣裙\",\"unit\":\"件\",\"price\":24.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2018/177/709/9670907771_237947431.jpg\",\"offerId\":533049522005,\"publishWithin7days\":false},{\"saleAmount\":32068,\"publishTime\":1464928359000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":true,\"bigPromotion\":false,\"title\":\"欧美外贸平台不规则新款女装 ebay亚马逊新款性感纯色打底衫现货\",\"unit\":\"件\",\"price\":15.5,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2020/536/911/13869119635_237947431.jpg\",\"offerId\":533048558336,\"publishWithin7days\":false},{\"saleAmount\":59662,\"publishTime\":1482062547000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":false,\"bigPromotion\":false,\"title\":\"Ebay亚马逊Wish货源性感热卖女装 12色长袖高领修身百搭连体裤冬\",\"unit\":\"件\",\"price\":17.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2019/303/028/12195820303_237947431.jpg\",\"offerId\":543423727465,\"publishWithin7days\":false},{\"saleAmount\":21997,\"publishTime\":1559800679000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":true,\"bigPromotion\":false,\"title\":\"ebay速卖通外贸女装 欧美时尚纯色长裙 长袖弹力修身高领连衣裙\",\"unit\":\"件\",\"price\":25.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2020/691/506/13635605196_237947431.jpg\",\"offerId\":596081397109,\"publishWithin7days\":false},{\"saleAmount\":13380,\"publishTime\":1550985662000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":true,\"bigPromotion\":false,\"title\":\"速卖通ebay性感深V领松紧腰印花连衣裙 度假家居服加大码女装\",\"unit\":\"件\",\"price\":28.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2019/092/117/10438711290_237947431.jpg\",\"offerId\":587835851111,\"publishWithin7days\":false},{\"saleAmount\":10032,\"publishTime\":1480748774000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":true,\"bigPromotion\":false,\"title\":\"欧洲站性感纯色无袖深V领松紧腰连衣裙 外贸加大码女装家居服\",\"unit\":\"件\",\"price\":25.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2019/613/741/10856147316_237947431.jpg\",\"offerId\":542684708527,\"publishWithin7days\":false},{\"saleAmount\":78611,\"publishTime\":1464928369000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":true,\"bigPromotion\":false,\"title\":\"欧洲站速卖通亚马逊 13色性感长袖夜店打底裙裤 秋季新款外贸女装\",\"unit\":\"件\",\"price\":16.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2020/480/003/13785300084_237947431.jpg\",\"offerId\":533047922616,\"publishWithin7days\":false},{\"saleAmount\":33598,\"publishTime\":1468155758000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":false,\"bigPromotion\":false,\"title\":\"速卖通 wish夏季新款圆领修身褶皱裙收腰包臀无袖大摆开叉连衣裙\",\"unit\":\"件\",\"price\":24.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2016/930/313/3218313039_237947431.jpg\",\"offerId\":535418159997,\"publishWithin7days\":false},{\"saleAmount\":46433,\"publishTime\":1464928354000,\"cornerIcon\":\"\",\"promotionBenefitInfos\":[],\"bestOffer\":false,\"bigPromotion\":false,\"title\":\"欧美外贸速卖通女装ebay性感wish高腰V领阔腿裤不规则套装带腰带\",\"unit\":\"条\",\"price\":29.0,\"imageUrl\":\"https://cbu01.alicdn.com/img/ibank/2016/712/533/3105335217_237947431.jpg\",\"offerId\":533048126513,\"publishWithin7days\":false}],\"relationRecommendOfferInfos\":[]},\"staticServer\":\"https://astyle-src.alicdn.com/app/dsc\"}}},\"success\":true,\"message\":\"\"}";
		JsonObject aliObject = new JsonParser().parse(ali).getAsJsonObject();
		System.out.println(aliObject);
		return aliObject.toString();
//		String json = "{\"goods_id\":\"\",\"goods_commit_id\":\"\",\"check_status\":0,\"tiny_name\":\"\",\"goods_name\":\"\",\"carousel_video\":[],\"detail_video\":[],\"goods_desc\":\"\",\"warm_tips\":\"\",\"cat_id\":\"\",\"cats\":[],\"image_url\":\"\",\"oversea_goods\":{},\"spu\":{},\"isbn_properties_related\":{\"isInit\":false},\"propertys_standard\":[],\"is_draft\":true,\"goods_name_prefix\":\"\",\"size_spec_id\":null,\"is_gold_price_matched\":null,\"hasBatchEnter\":false,\"third_type\":0,\"cat_ids\":[],\"bad_fruit_claim\":0,\"booking_notes\":{},\"shoes_template_id\":null,\"service_time\":"
//				+ new Date().getTime()
//				+ ",\"electric_status\":0,\"propertys_tid\":27570,\"spu_cate_type\":0,\"decorationPreview\":\"https://mobile.yangkeduo.com/comm_goods_decoration_preview.html?goods_id=\\\"\\\"&amp;_oak_decoration_token=uuUEKv1a/TN091WY+iN59gU5lKgl90WZ9ONmYPWigtJKCzXlU5Ap9GYt9n+bTZeSKwH5PHeRiseirJ+daKRSGg==\",\"size_parent_spec_id\":null,\"is_shop\":1,\"goods_type\":1,\"invoice_status\":0,\"invoice_mode\":null,\"zhi_huan_bu_xiu\":0,\"quan_guo_lian_bao\":0,\"second_hand\":0,\"is_pre_sale\":0,\"pre_sale_time\":\"\",\"country_id\":\"0\",\"origin_country_id\":0,\"warehouse\":\"\",\"customs\":\"\",\"is_customs\":0,\"shipment_limit_second\":172800,\"cost_template_id\":\"\",\"weight\":\"\",\"groups\":{\"single_price\":0,\"group_price\":0,\"carnival_price\":null,\"customer_num\":2,\"buy_limit\":999999,\"order_limit\":999999,\"regular_limit\":null,\"regular_limit_duration\":null,\"min_num_of_order\":null},\"is_folt\":1,\"is_refundable\":1,\"lack_of_weight_claim\":0,\"goods_pattern\":0,\"customizable\":0,\"local_service_id_list\":null,\"shop_group_id\":0,\"schedule_sale\":{\"sale_type\":0},\"card_verification_list\":[],\"origin_is_pre_sale\":0,\"isCoupon\":false,\"cost_template_error\":null,\"elec_goods_attributes\":null,\"delivery_one_day\":0,\"mai_jia_zi_ti\":null,\"shang_men_an_zhuang\":null,\"song_huo_an_zhuang\":null,\"song_huo_ru_hu\":null,\"goods_srv_templates\":[{\"type\":7,\"id\":null}],\"skus\":[],\"market_price_in_yuan\":\"\",\"market_price\":\"\",\"out_goods_sn\":\"\",\"dead_line_seconds\":86399,\"gold_price_template_id\":0,\"processing_charges\":0,\"processing_charges_in_yuan\":\"0\",\"gallery\":[],\"is_group_pre_sale\":0,\"goods_properties\":[{\"template_pid\":163882,\"template_module_id\":33513,\"ref_pid\":310,\"pid\":5,\"vid\":80018,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163883,\"template_module_id\":33513,\"ref_pid\":351,\"pid\":34,\"vid\":83615,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163883,\"template_module_id\":33513,\"ref_pid\":351,\"pid\":34,\"vid\":327016,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163883,\"template_module_id\":33513,\"ref_pid\":351,\"pid\":34,\"vid\":83763,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163884,\"template_module_id\":33513,\"ref_pid\":1211,\"pid\":338,\"vid\":83618,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163885,\"template_module_id\":33513,\"ref_pid\":482,\"pid\":93,\"vid\":24044,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163886,\"template_module_id\":33513,\"ref_pid\":1563,\"pid\":453,\"vid\":325892,\"value\":\"\",\"value_unit\":\"\"},{\"template_pid\":163887,\"template_module_id\":33513,\"ref_pid\":1471,\"pid\":323,\"vid\":0,\"value_unit\":\"\"}],\"is_auto_save\":false,\"validate_message\":\"9e94fb2305685a419976de10fbdf5e51c47bfbb2e4d5db61b8a2730f242d8327\",\"crawlerInfo\":\""
//				+ queryGoodsRank.getkey() + "\"}";
//		JsonObject jobj = new JsonParser().parse(json).getAsJsonObject();
//		jobj.addProperty("goods_id", goods_id);
//		jobj.addProperty("goods_commit_id", goods_commit_id);
//		String goodJson = api(itemId);
//		JsonObject obj = new JsonParser().parse(goodJson).getAsJsonObject();
//		JsonObject desc = obj.get("data").getAsJsonObject().get("desc").getAsJsonObject();
//		JsonArray array = desc.get("data").getAsJsonObject().get("wdescContent").getAsJsonObject().get("pages")
//				.getAsJsonArray();
//		JsonObject apiStack = obj.get("data").getAsJsonObject().get("apiStack").getAsJsonArray().get(0)
//				.getAsJsonObject();
//		JsonObject item = null;
//		JsonElement skuBase = null;
//		try {
//			item = apiStack.get("value").getAsJsonObject().get("item").getAsJsonObject();
//			skuBase = apiStack.get("value").getAsJsonObject().get("skuBase");
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			item = obj.get("data").getAsJsonObject().get("item").getAsJsonObject();
//		}
//		JsonArray props = null;
//		if (!(skuBase == null)) {
//			skuBase = apiStack.get("value").getAsJsonObject().get("skuBase").getAsJsonObject();
//			props = skuBase.getAsJsonObject().get("props").getAsJsonArray();
//		} else {
//			props = new JsonParser().parse(
//					"[{\"pid\":\"10066392\",\"name\":\"规格\",\"values\":[{\"vid\":\"3277918\",\"name\":\"一只装\"}]}]")
//					.getAsJsonArray();
//		}
//		Integer market_price = 5000;
//		String market_price_in_yuan = "50.00";
//		String skutemplete = "{\"id\":\"\",\"sku_id\":\"\",\"limit_quantity\":999999,\"out_sku_sn\":\"\",\"is_onsale\":1,\"multi_price_in_yuan\":\"\",\"price_in_yuan\":\"\",\"multi_price\":\"\",\"price\":\"\",\"quantity_delta\":2000,\"thumb_url\":\"\",\"thumb_url_file_id\":\"\",\"weight\":0,\"spec\":[{\"parent_id\":\"\",\"parent_name\":\"\",\"spec_id\":\"\",\"spec_name\":\"\"}],\"length\":null,\"oversea_sku\":{\"specifications\":null,\"measurement_unit\":null,\"taxation\":null},\"sku_srv_templates\":\"\"}";
//		Integer quantity = 9999;
//		JsonArray nskus = new JsonArray();
//		JsonArray values = new JsonArray();
//		for (JsonElement prop : props) {
//			JsonArray value = prop.getAsJsonObject().get("values").getAsJsonArray();
//			for (JsonElement jsonElement : value) {
//				JsonObject O = new JsonObject();
//				String vid = jsonElement.getAsJsonObject().get("vid").getAsString();
//				String cname = jsonElement.getAsJsonObject().get("name").getAsString();
//				O.addProperty("vid", vid);
//				O.addProperty("cname", cname);
//				values.add(O);
//			}
//		}
//		for (int i = 0; i < values.size(); i++) {
//			if (i > 0) {
//				break;
//			}
//			System.out.println(values.get(i));
//			System.out.println(values);
//			JsonObject nsku = new JsonParser().parse(skutemplete).getAsJsonObject();
//			String multi_price_in_yuan = "29.99";
//			Integer multi_price = 2999;
//			Random r = new Random();
//			nsku.addProperty("id", new Date().getTime());
//			nsku.addProperty("sku_id",
//					Long.parseLong(String.valueOf(new Date().getTime() + r.nextInt(999)).substring(1)));
//			nsku.addProperty("thumb_url", "");
//			nsku.addProperty("thumb_url_file_id", 0);
//			nsku.addProperty("quantity", quantity);
//			nsku.addProperty("multi_price_in_yuan", multi_price_in_yuan);
//			nsku.addProperty("price_in_yuan", multi_price_in_yuan);
//			nsku.addProperty("multi_price", multi_price);
//			nsku.addProperty("price", multi_price);
//			for (JsonElement cprop : props) {
//				JsonArray newspec = new JsonArray();
//				JsonObject nspec = new JsonObject();
//				String name = cprop.getAsJsonObject().get("name").getAsString();
//				String pid = cprop.getAsJsonObject().get("pid").getAsString();
//				System.out.println(name);
//				System.out.println(pid);
//				nspec.addProperty("parent_id", Integer.parseInt(pid.substring(0, 4)));
//				nspec.addProperty("parent_name", name);
//				nspec.addProperty("spec_id",
//						Integer.parseInt(String.valueOf(new Date().getTime() + new Random().nextInt(10)).substring(4)));
//				nspec.addProperty("spec_name", values.get(i).getAsJsonObject().get("cname").getAsString());
//				newspec.add(nspec);
//				nsku.add("spec", newspec);
//			}
//			nskus.add(nsku);
//		}
//		JsonArray gallery = jobj.get("gallery").getAsJsonArray();
//		String title = "";
//		try {
//			title = item.get("title").getAsString();
//		} catch (Exception e) {
//			// TODO: handle exception
//			item = obj.get("data").getAsJsonObject().get("item").getAsJsonObject();
//			title = item.get("title").getAsString();
//		}
//		System.out.println(item);
//		jobj.addProperty("goods_name", title);
//		jobj.addProperty("goods_desc", title);
//		jobj.addProperty("cat_id", catID);
//		jobj.addProperty("decorationPreview",
//				"https://mobile.yangkeduo.com/comm_goods_decoration_preview.html?goods_id=" + goods_id
//						+ "&_oak_decoration_token=uuUEKv1a/TN091WY+iN59gU5lKgl90WZ9ONmYPWigtJKCzXlU5Ap9GYt9n+bTZeSKwH5PHeRiseirJ+daKRSGg==");
//		jobj.addProperty("service_time", new Date().getTime());
//		jobj.addProperty("cost_template_id", getList());
//		for (JsonElement jsonElement : array) {
//			String imgurl = jsonElement.getAsString();
//			imgurl = "https:" + imgurl;
//			if (imgurl.contains("gw.alicdn.com") || !imgurl.contains("//")) {
//				continue;
//			}
//			String jsons = store_image(imgurl, goods_commit_id);
//			JsonObject result = new JsonParser().parse(jsons).getAsJsonObject().get("result").getAsJsonObject();
//			Long id = result.get("id").getAsLong();
//			String nurl = result.get("url").getAsString();
//			JsonObject viewobj = new JsonObject();
//			viewobj.addProperty("url", nurl);
//			viewobj.addProperty("type", 2);
//			viewobj.addProperty("file_id", id);
//			gallery.add(viewobj);
//		}
//		JsonArray images = null;
//		try {
//			images = item.get("images").getAsJsonArray();
//		} catch (Exception e) {
//			// TODO: handle exception
//			item = obj.get("data").getAsJsonObject().get("item").getAsJsonObject();
//			images = item.get("images").getAsJsonArray();
//		}
//		for (JsonElement jsonElement : images) {
//			String url = jsonElement.getAsString();
//			if (url.startsWith("http") == false) {
//				url = "https:" + url;
//			}
//			String jsons = store_image(url, goods_commit_id);
//			JsonObject result = new JsonParser().parse(jsons).getAsJsonObject().get("result").getAsJsonObject();
//			Long id = result.get("id").getAsLong();
//			String nurl = result.get("url").getAsString();
//			JsonObject viewobj = new JsonObject();
//			viewobj.addProperty("url", nurl);
//			viewobj.addProperty("type", 1);
//			viewobj.addProperty("file_id", id);
//			gallery.add(viewobj);
//		}
//		jobj.add("gallery", gallery);
//		String detail = detail(catID);
//		JsonObject catObj = new JsonParser().parse(detail).getAsJsonObject().get("result").getAsJsonObject();
//		String cat_id_1_name = catObj.get("cat_id_1_name").getAsString();
//		String cat_id_2_name = catObj.get("cat_id_2_name").getAsString();
//		String cat_id_3_name = catObj.get("cat_id_3_name").getAsString();
//		String cat_id_4_name = catObj.get("cat_id_4_name").getAsString();
//		Integer cat_id_1 = catObj.get("cat_id_1").getAsInt();
//		Integer cat_id_2 = catObj.get("cat_id_2").getAsInt();
//		Integer cat_id_3 = catObj.get("cat_id_3").getAsInt();
//		Integer cat_id_4 = catObj.get("cat_id_4").getAsInt();
//
//		if (cat_id_2_name.equals("")) {
//			cat_id_2_name = null;
//		}
//		if (cat_id_3_name.equals("")) {
//			cat_id_3_name = null;
//		}
//		if (cat_id_4_name.equals("")) {
//			cat_id_4_name = null;
//		}
//		JsonArray cat_ids = new JsonArray();
//		cat_ids.add(cat_id_1);
//		cat_ids.add(cat_id_2);
//		cat_ids.add(cat_id_3);
//		cat_ids.add(cat_id_4);
//		jobj.add("cat_ids", cat_ids);
//		JsonArray cats = new JsonArray();
//		cats.add(cat_id_1_name);
//		cats.add(cat_id_2_name);
//		cats.add(cat_id_3_name);
//		cats.add(cat_id_4_name);
//		jobj.add("cats", cats);
//		jobj.add("skus", nskus);
//		jobj.addProperty("market_price_in_yuan", market_price_in_yuan);
//		jobj.addProperty("market_price", market_price);
//		return jobj.toString();
	}
	
	// 提交模板
	public static String submit(String goods_commit_id) {
		String api = "https://mms.pinduoduo.com/glide/v2/mms/edit/commit/submit";
		String postdata = "{\"goods_commit_id\":\"" + goods_commit_id
				+ "\",\"is_onsale\":true,\"third_type\":0,\"crawlerInfo\":\"" + queryGoodsRank.getkey() + "\"}";
		String refer = "https://mms.pinduoduo.com/goods/goods_add/index?id=" + goods_commit_id + "&type=edit";
		String json = Api(api, postdata, refer);
		System.out.println(json);
		return json;
	}

	// 获取签名
	public static String getSignature(String goods_commit_id) {
		String api = "https://mms.pinduoduo.com/galerie/business/get_signature";
		String postdata = "{\"bucket_tag\":\"mms-material-img\"}";
		String refer = "https://mms.pinduoduo.com/goods/goods_add/index?type=add&from=category&id=" + goods_commit_id;
		String json = Api(api, postdata, refer);
		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
		JsonObject result = obj.get("result").getAsJsonObject();
		String signature = result.get("signature").getAsString();
		return signature;
	}

	// 读取图片
	public static String readImage(String path) {
		File file = null;
		String dir = null;
		try {
			System.out.println(path);
			URL url = new URL(path);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
			httpURLConnection.setConnectTimeout(1000 * 5);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("Charset", "UTF-8");
			httpURLConnection.connect();
			URLConnection con = url.openConnection();
			con.connect();
			BufferedInputStream bin = new BufferedInputStream(httpURLConnection.getInputStream());
			String name = path.substring(path.lastIndexOf("/"), path.length())
					.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5，,。？“”]+", "");
			if (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png")) {
				name = path.substring(path.lastIndexOf("/") + 1, path.length());
			} else {
				name = path.substring(path.lastIndexOf("/") + 1, path.length()) + ".jpg";
			}
			dir = getWebPaths(null) + name;
			file = new File(dir);
			OutputStream out = new FileOutputStream(file);
			int size = 0;
			byte[] buf = new byte[2048];
			while ((size = bin.read(buf)) != -1) {
				out.write(buf, 0, size);
			}
			bin.close();
			out.close();
			return dir;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// System.out.println("download error");
			return null;
		}
	}

	// 上传图片
	public static String store_image(String path, String goods_commit_id) {
		String cookie = queryGoodsRank.getcookie("upload");
		int beginIndex = path.lastIndexOf("/") + 1;
		int endIndex = path.lastIndexOf(".");
		String name = "";
		try {
			name = path.substring(beginIndex, endIndex);
		} catch (Exception e) {
			// TODO: handle exception
			name = "aaa";
		}
		path = path.replace("https:https:", "https:");
		String binary = upload.readImage(path);
		String api = "https://file.pinduoduo.com/v3/store_image";
		try {
			OkHttpClient client = new OkHttpClient().newBuilder().build();
			@SuppressWarnings("unused")
			MediaType mediaType = MediaType
					.parse("multipart/form-data;boundary=----WebKitFormBoundaryY5BEtOz7HqtQvf92");
			RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
					.addFormDataPart("pic_operations",
							"{\"rules\":[{\"rule\":\"imageMogr2/format/jpeg/quality/80|imageView2/2/w/2000/h/2000\"}]}")
					.addFormDataPart("upload_sign", getSignature(goods_commit_id)).addFormDataPart("image", name,
							RequestBody.create(MediaType.parse("application/octet-stream"), new File(binary)))
					.build();
			Request request = new Request.Builder().url(api).method("POST", body)
					.addHeader("anti-content", queryGoodsRank.getkey()).addHeader("cookie", cookie)
					.addHeader("content-type", "multipart/form-data;boundary=----WebKitFormBoundaryY5BEtOz7HqtQvf92")
					.addHeader("referer",
							"https://mms.pinduoduo.com/goods/goods_add/index?id=" + goods_commit_id + "&type=edit")
					.addHeader("x-b3-trace", "false")
					.addHeader("User-Agent",
							"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0")
					.build();
			String json = "";
			try {
				Response response = client.newCall(request).execute();
				json = response.body().string();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File file = new File(binary);
			file.delete();
			// System.out.println(api);
			// System.out.println(json);
			JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
			if (obj.get("url") != null) {
				String url = obj.get("url").getAsString();
				JsonObject res = create(path, goods_commit_id, url);
				String imgid = res.get("id").getAsString();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				url = queryFileDetail(path, goods_commit_id, url, imgid);
//				url = list(goods_commit_id);
				return url;
			} else {
				return store_image(path, goods_commit_id);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return store_image(path, goods_commit_id);
		}

	}

	// 查询图片信息
	public static JsonObject create(String path, String goods_commit_id, String url) {
		int beginIndex = url.lastIndexOf("/") + 1;
		int endIndex = url.lastIndexOf(".");
		String name = url.substring(beginIndex, endIndex);
		String api = "https://mms.pinduoduo.com/garner/mms/file/create";
		String postdata = "{\"url\":\"" + url + "\",\"name\":\"" + name + "\",\"extension\":\"jpeg\",\"create_time\":"
				+ new Date().getTime() + "}";
		String refer = "https://mms.pinduoduo.com/goods/goods_add/index?type=add&from=category&id=" + goods_commit_id;
		String json = Api(api, postdata, refer);
		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
		if (obj.get("result") != null) {
			String imgid = obj.get("result").getAsString();
			JsonObject result = new JsonObject();
			result.addProperty("id", imgid);
			result.addProperty("url", url);
			return result;
		} else {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JsonObject result = create(path, goods_commit_id, url);
			return result;
		}

	}

	// 预览图
	public static String preview(String goods_commit_id, String goods_id) {
		String api = "https://mms.pinduoduo.com/gorse/mms/goods/decoration/preview";
		String postdata = "{\"goods_commit_id\":" + goods_commit_id + ",\"goods_id\":" + goods_id + "}";
		String refer = "https://mms.pinduoduo.com/goods/goods_add/index?type=add&from=category&id=" + goods_commit_id;
		String json = Api(api, postdata, refer);
		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
		JsonObject result = obj.get("result").getAsJsonObject();
		String preview_url = result.get("preview_url").toString();
		return preview_url;
	}

	// 获取类目信息
	public static String detail(Integer catId) {
		String api = "https://mms.pinduoduo.com/vodka/v2/mms/category/detail?catId=" + catId;
		String json = Api(api);
//		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
//		JsonObject result = obj.get("result").getAsJsonObject();
//		String preview_url = result.get("preview_url").toString();
		return json;
	}

	// 获取图片信息
	public static String queryFileDetail(String path, String goods_commit_id, String url, String id) {
		String api = "https://mms.pinduoduo.com/garner/mms/file/queryFileDetail";
		String postdata = "{\"file_id\":" + id + ",\"file_url\":\"" + url + "\"}";
		String refer = "https://mms.pinduoduo.com/goods/goods_add/index?type=add&from=category&id=" + goods_commit_id;
		String json = Api(api, postdata, refer);
		return json;
//		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
//		JsonObject result = obj.get("result").getAsJsonObject();
//		if (result.get("check_comment") != null) {
//			String check_comment = result.get("check_comment").getAsString();
//			if (check_comment.equals("通过")) {
//				return url;
//			} else {
//				return null;
//			}
//		} else {
//			return null;
//		}
	}

	// 查询图片仓库信息
	public static String list(String goods_commit_id) {
		String api = "https://mms.pinduoduo.com/garner/mms/file/list";
		String postdata = "{\"order_by\":\"create_time desc\",\"page\":1,\"page_size\":100,\"size_range\":[{\"end\":1048576}],\"width_range\":[{\"start\":480}],\"wh_ratio_range\":[{\"start\":0.3333333333333333,\"end\":null}],\"file_type_desc\":\"pic\",\"wh_ratio\":[],\"file_extension\":[],\"check_status_list\":[2,1],\"height_range\":[{}],\"video_duration_range\":[]}";
		String refer = "https://mms.pinduoduo.com/goods/goods_add/index?id=" + goods_commit_id;
		String json = Api(api, postdata, refer);
		return json;
	}

	public static Long getList() {
		String api = "https://mms.pinduoduo.com/express_inf/cost_template/get_list";
		String postdata = "{\"pageNo\":1,\"pageSize\":10,\"sourceKey\":\"MMS\"}";
		String refer = "https://mms.pinduoduo.com/orders/order/carriage/list";
		String json = Api(api, postdata, refer);
		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
		Long costTemplateId = null;
		if (obj.get("result") != null) {
			JsonArray list = obj.get("result").getAsJsonObject().get("list").getAsJsonArray();
			for (JsonElement jsonElement : list) {
				JsonObject jobj = jsonElement.getAsJsonObject();
				Long costTemplateIds = jobj.get("costTemplateId").getAsLong();
				String costTemplateName = jobj.get("costTemplateName").getAsString();
				if (costTemplateName.contains("非偏远包邮默认模板")) {
					costTemplateId = costTemplateIds;
					break;
				}
			}
		}
		return costTemplateId;
	}

	public static String getWebPaths(String fileName) {
		// file:/D:/JavaWeb/.metadata/.me_tcat/webapps/TestBeanUtils/WEB-INF/classes/
		String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
		// 去掉返回路径中各种不需要的东西
		path = path.replace('/', '\\'); // 将/换成\
		path = path.replace("file:", ""); // 去掉file:
		// path = path.replace("classes\\", ""); // 去掉class\
		path = path.substring(1); // 去掉第一个\,如 \D:\JavaWeb...

		// 如果有文件名，则在路径上加入文件名
		if (fileName != null) {
			if (fileName.isEmpty() == false) {
				path += fileName;
			}
		}
		return path.replace("%20", " ").replace("\\classes", "");
	}

	public static String Api(String api, String postdata, String refer) {
		String cookie = queryGoodsRank.getcookie("upload");
		Document doc = null;
		// System.out.println(api);
		Connection connection = Jsoup.connect(api);
		connection = connection.requestBody(postdata);
		connection = connection.header("Cookie", cookie);
		connection = connection.header("Content-Type", "application/json;charset=UTF-8");
		connection = connection.header("anti-content", queryGoodsRank.getkey());
		connection = connection.header("Referer", refer);
		try {
			doc = connection
					.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0")
					.timeout(50000).ignoreContentType(true).post();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json = doc.body().text();
		System.out.println(json);
		return json;
	}

	public static String Api(String api) {
		String cookie = queryGoodsRank.getcookie("upload");
		Document doc = null;
		// System.out.println(api);
		Connection connection = Jsoup.connect(api);
		connection = connection.header("Cookie", cookie);
		connection = connection.header("Content-Type", "application/json;charset=UTF-8");
		connection = connection.header("anti-content", queryGoodsRank.getkey());
		try {
			doc = connection
					.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0")
					.timeout(50000).ignoreContentType(true).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json = doc.body().text();
		System.out.println(json);
		return json;
	}

	public static String api(String itemId) {
		String sdata = "%7B%22id%22%3A%22" + itemId
				+ "%22%2C%22ali_refid%22%3A%22a3_430406_1007%3A30392848%3AJ%3A7959121852737021697_0_1361066346%3Acab3829f345dbd70c679d098f55b8315%22%2C%22ali_trackid%22%3A%2285_cab3829f345dbd70c679d098f55b8315%22%2C%22spm%22%3A%22a21bo.2017.201874-sales.29%22%2C%22itemNumId%22%3A%22"
				+ itemId + "%22%2C%22itemId%22%3A%22" + itemId + "%22%2C%22exParams%22%3A%22%7B%5C%22id%5C%22%3A%5C%22"
				+ itemId
				+ "%5C%22%2C%5C%22ali_refid%5C%22%3A%5C%22a3_430406_1007%3A30392848%3AJ%3A7959121852737021697_0_1361066346%3Acab3829f345dbd70c679d098f55b8315%5C%22%2C%5C%22ali_trackid%5C%22%3A%5C%2285_cab3829f345dbd70c679d098f55b8315%5C%22%2C%5C%22spm%5C%22%3A%5C%22a21bo.2017.201874-sales.29%5C%22%7D%22%2C%22detail_v%22%3A%228.0.0%22%2C%22utdid%22%3A%221%22%7D";
		String api = "https://h5api.m.taobao.com/h5/mtop.taobao.detail.getdetail/6.0/?jsv=2.6.0&appKey=12574478&t="
				+ new Date().getTime()
				+ "&sign=97ea6c138f920bc758801e89d60f650a&api=mtop.taobao.detail.getdetail&v=6.0&isSec=0&ecode=0&AntiFlood=true&AntiCreep=true&H5Request=true&ttid=2018%40taobao_h5_9.9.9&type=jsonp&dataType=json&data="
				+ sdata;
		String referer = "https://h5.m.taobao.com/awp/core/detail.htm?id=" + itemId
				+ "&ali_refid=a3_430406_1007:30392848:J:7959121852737021697_0_1361066346:cab3829f345dbd70c679d098f55b8315&ali_trackid=85_cab3829f345dbd70c679d098f55b8315&spm=a21bo.2017.201874-sales.29";
		Document doc = null;
		Connection connection = Jsoup.connect(api);
		String reString = "";
		connection = connection.header("referer", referer);
		connection = connection.header("p3p",
				"CP='CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR'");
		connection = connection.header("s", "STATUS_NORMAL");
		connection = connection.header("Content-Type", "application/json;charset=UTF-8");
		connection = connection.header("user-agent",
				"Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1");
		try {
			doc = connection.timeout(500000000).ignoreContentType(true).get();
			reString = doc.text();
			System.out.println(reString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonObject json = new JsonObject();
		json.addProperty("status", "success");
		json.addProperty("code", 200);
		JsonObject result = new JsonParser().parse(reString).getAsJsonObject();
		String sapi = result.get("api").getAsString();
		String v = result.get("v").getAsString();
		JsonArray ret = result.get("ret").getAsJsonArray();
		json.addProperty("api", sapi);
		json.addProperty("v", v);
		if (result != null) {
			JsonObject data = result.get("data").getAsJsonObject();
			String smockData = null;
			if (data.get("mockData") != null) {
				smockData = data.get("mockData").getAsString();
				JsonObject mockData = new JsonParser().parse(smockData).getAsJsonObject();
				data.add("mockData", mockData);
			}
			if (data.get("apiStack") != null) {
				try {
					JsonArray apiStack = data.get("apiStack").getAsJsonArray();
					JsonArray newapiStack = new JsonArray();
					for (JsonElement jsonElement : apiStack) {
						JsonObject current = jsonElement.getAsJsonObject();
						String svalue = current.get("value").getAsString();
						JsonObject value = new JsonParser().parse(svalue).getAsJsonObject();
						current.add("value", value);
						newapiStack.add(current);
					}
					data.add("apiStack", newapiStack);
				} catch (Exception e) {
					// TODO: handle exception

				}
			}
			String desc = getDesc(itemId);
			JsonObject des = new JsonParser().parse(desc).getAsJsonObject();
			data.add("desc", des);
			json.add("data", data);
		}
		json.add("ret", ret);
		json.addProperty("timestamp", new Date().getTime());
		json.addProperty("description", "Powered By DreamFly.");
		System.out.println(json);
		return json.toString();
	}

	public static String getDesc(String itemId) {
		String api = "https://h5api.m.taobao.com/h5/mtop.taobao.detail.getdesc/6.0/?data=%7b%22id%22%3a%22" + itemId
				+ "%22%2c%22type%22%3a%220%22%7d";
		Document doc = null;
		Connection connection = Jsoup.connect(api);
		String json = "";
		connection = connection.header("referer", "https://detail.m.tmall.com/item.htm?id=" + itemId);
		try {
			doc = connection
					.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:74.0) Gecko/20100101 Firefox/74.0")
					.timeout(50000).ignoreContentType(true).get();
			json = doc.text();
			System.out.println(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	public static JsonArray memory(JsonObject a, JsonObject b) {
		JsonArray all = new JsonArray();
		for (int j = 0; j < a.get("values").getAsJsonArray().size(); j++) {
			JsonObject c = a.get("values").getAsJsonArray().get(j).getAsJsonObject();
			String cname = a.get("name").getAsString();
			String cid = a.get("pid").getAsString();
			c.addProperty("pid", cid);
			c.addProperty("pname", cname);
			for (int i = 0; i < b.size(); i++) {
				JsonArray arr = new JsonArray();
				String pname = b.get("name").getAsString();
				String pid = b.get("pid").getAsString();
				JsonObject d = b.get("values").getAsJsonArray().get(i).getAsJsonObject();
				d.addProperty("pid", pid);
				d.addProperty("pname", pname);
				arr.add(c);
				arr.add(d);
				all.add(arr);
			}
		}
		return all;
	}

	public static String Api(String offerId, boolean isali) {
		String api = "https://laputa.1688.com/offer/ajax/widgetList.do?callback=jQuery1720" + getTraceId.randomNum(12)
				+ "_" + new Date().getTime()
				+ "&blocks=&data=offerdetail_ditto_title%2Cofferdetail_common_report%2Cofferdetail_ditto_serviceDesc%2Cofferdetail_ditto_preferential%2Cofferdetail_ditto_postage%2Cofferdetail_ditto_offerSatisfaction%2Cofferdetail_w1190_guarantee%2Cofferdetail_w1190_tradeWay%2Cofferdetail_ditto_whosaleself&offerId="
				+ offerId + "&pageId=laputa20140721212446";
		String json = getApi(api);
		json = getTraceId.toJson(json);
		JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
		JsonObject data = obj.get("data").getAsJsonObject().get("data").getAsJsonObject();
		String detail_url = data.get("offerdetail_ditto_title").getAsJsonObject().get("extends").getAsJsonObject().get("detail_url").getAsString();
		String detail = getApi(detail_url);
		String regx = "http.*?img.*?(?=\\\\&quot;\"><br>)";
		JsonArray imgs = getimgurl(regx, detail);
		obj.get("data").getAsJsonObject().get("data").getAsJsonObject().get("offerdetail_ditto_title").getAsJsonObject().get("extends").getAsJsonObject().add("detail_url", imgs);
		return obj.toString();
	}

	public static String getApi(String api) {
		Document doc = null;
		Connection connection = Jsoup.connect(api);
		connection = connection.header("accept", "*/*");
		connection = connection.header("accept-encoding", "gzip, deflate, br");
		connection = connection.header("accept-language", "zh-CN,zh;q=0.9");
		connection = connection.header("referer", "https://detail.1688.com/");
		connection = connection.header("sec-fetch-dest", "script");
		connection = connection.header("sec-fetch-mode", "no-cors");
		connection = connection.header("sec-fetch-site", "same-site");
		connection = connection.header("user-agent", RandomUa.getRandomUa());
		connection = connection.header("x-forwarded-for", RandomIp.getRandomIp());

		try {
			doc = connection.timeout(50000).ignoreContentType(true).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json = doc.body().html();
		return json;
	}

	public static JsonArray getimgurl(String rex, String str) {
		Pattern p = Pattern.compile(rex); // 编译对象
		Matcher m = p.matcher(str); // 进行匹配
		JsonArray arr = new JsonArray();
		while (m.find()) {
			arr.add(m.group().replaceAll("\\\\.*", ""));
		}
		return arr;
	}

}
