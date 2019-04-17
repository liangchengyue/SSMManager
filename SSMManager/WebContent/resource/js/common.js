/**
 * 将日期转换为字符串
 * 
 * @param now
 *            日期
 * @param mask
 *            日期格式（yyyy-MM-dd,yy-MM-dd-dd hh:mm:ss...）
 * @returns 字符串日期
 */
function Format(now, mask) {
	var d = now;
	var zeroize = function(value, length) {
		if (!length)
			length = 2;
		value = String(value);
		for (var i = 0, zeros = ''; i < (length - value.length); i++) {
			zeros += '0';
		}
		return zeros + value;
	};

	return mask
			.replace(
					/"[^"]*"|'[^']*'|\b(?:d{1,4}|m{1,4}|yy(?:yy)?|([hHMstT])\1?|[lLZ])\b/g,
					function($0) {
						switch ($0) {
						case 'd':
							return d.getDate();
						case 'dd':
							return zeroize(d.getDate());
						case 'ddd':
							return [ 'Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri',
									'Sat' ][d.getDay()];
						case 'dddd':
							return [ 'Sunday', 'Monday', 'Tuesday',
									'Wednesday', 'Thursday', 'Friday',
									'Saturday' ][d.getDay()];
						case 'M':
							return d.getMonth() + 1;
						case 'MM':
							return zeroize(d.getMonth() + 1);
						case 'MMM':
							return [ 'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
									'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec' ][d
									.getMonth()];
						case 'MMMM':
							return [ 'January', 'February', 'March', 'April',
									'May', 'June', 'July', 'August',
									'September', 'October', 'November',
									'December' ][d.getMonth()];
						case 'yy':
							return String(d.getFullYear()).substr(2);
						case 'yyyy':
							return d.getFullYear();
						case 'h':
							return d.getHours() % 12 || 12;
						case 'hh':
							return zeroize(d.getHours() % 12 || 12);
						case 'H':
							return d.getHours();
						case 'HH':
							return zeroize(d.getHours());
						case 'm':
							return d.getMinutes();
						case 'mm':
							return zeroize(d.getMinutes());
						case 's':
							return d.getSeconds();
						case 'ss':
							return zeroize(d.getSeconds());
						case 'l':
							return zeroize(d.getMilliseconds(), 3);
						case 'L':
							var m = d.getMilliseconds();
							if (m > 99)
								m = Math.round(m / 10);
							return zeroize(m);
						case 'tt':
							return d.getHours() < 12 ? 'am' : 'pm';
						case 'TT':
							return d.getHours() < 12 ? 'AM' : 'PM';
						case 'Z':
							return d.toUTCString().match(/[A-Z]+$/);
							// Return quoted strings with the surrounding quotes
							// removed
						default:
							return $0.substr(1, $0.length - 2);
						}
					});
}

//获取下拉列表
function SelectInfo(url, seleteId) {
	$.ajax({
		url : url,
		success : function(data) {
			data = JSON.parse(data);
			$(data).each(
					function() {
						$(seleteId).append(
								'<option value="'+this.value+'">'
										+ this.name + '</option>');
					});
			$(seleteId).selectpicker('render');
			$(seleteId).selectpicker('refresh');
		}
	});
}
/**
 * 在新标签中打开页面
 * @param url 网址
 * @param title 标题
 * @returns
 */
function page(url, title) {
	var nav = $(window.parent.document).find(
			'.J_menuTabs .page-tabs-content ');
	$(window.parent.document).find('.J_menuTabs .page-tabs-content ')
			.find(".J_menuTab.active").removeClass("active");
	$(window.parent.document).find('.J_mainContent').find("iframe")
			.css("display", "none");
	var iframe = '<iframe class="J_iframe" name="iframe10000" width="100%" height="100%" src="'
			+ url
			+ '" frameborder="0" data-id="'
			+ url
			+ '" seamless="" style="display: inline;"></iframe>';
	$(window.parent.document)
			.find('.J_menuTabs .page-tabs-content ')
			.append(
					' <a href="javascript:;" class="J_menuTab active" data-id="'+url+'">'
							+ title
							+ ' <i class="fa fa-times-circle"></i></a>');
	$(window.parent.document).find('.J_mainContent').append(iframe);
}