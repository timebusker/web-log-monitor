var lognum = 0, times = 0, maxpoint = 30, maxlognum = 2000;

$(document).ready(function() {
	// 创建闪动节点
	addsprainpoint(30);
	// 隐藏所有子节点
	$("span.sprain-point").find("img").hide();
	// 控制 元素跳动
	window.setInterval(doRay, 1000);
	// 通过iframe异步加载日志
	var url = "log/monitor";
	$("#log-frame")[0].src = url;

	function doRay() {
		times++;
		// sprain-point
		$("span.sprain-point").find("img").eq(times).show();
		// sprain-line
		if(times % 2 != 0)
			$("#ray").hide();
		else if(times % 2 == 0)
			$("#ray").show();
		if(times >= $('span.sprain-point').children('img').length) {
			times = 0;
			$("span.sprain-point").find("img").hide();
		}
	}

	function addsprainpoint(num) {
		var parent = $("span.sprain-point");
		for(i = 0; i < num; i++) {
			parent.append("<img alt=\"log-point\" id=\"sprain-point\" src=\"static/img/point.png\" />")
		}
	}
});

// 此方法由window.parent.append进行调用
function append(data) {
	console.info(data);
	var log = "<div class=\"log\">" + data + "</div>";
	if (lognum > maxlognum) {
		var removenum = lognum - maxlognum;
		$(".log").eq(removenum).remove();
	}
	if ($('.logs-content').children('div').length > maxlognum) {
		$('.logs-content').html();
		lognum = 0;
	}
	$(".log").eq(lognum).after(log);
	lognum++;
	var content = document.getElementById("logs-content");
	content.scrollTop = content.scrollHeight;
}