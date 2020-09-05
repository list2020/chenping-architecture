function aceSwitch(cellvalue, options, cell) {
	setTimeout(function() {
		$(cell).find('input[type=checkbox]').wrap('<label class="inline" />')
				.addClass('ace ace-switch ace-switch-5').after(
						'<span class="lbl"></span>');
	}, 0);
}

function stateFormatter(cellvalue, options, rowObject) {
	if (cellvalue == 0) {
		return "启动";
	} else if (cellvalue == 1) {
		return "禁止";
	} else {
		return cellvalue;
	}
}

function getPageSize() {
	// http://www.blabla.cn/js_kb/javascript_pagesize_windowsize_scrollbar.html
	var winW, winH;
	if (window.innerHeight) {// all except IE
		winW = window.innerWidth;
		winH = window.innerHeight;
	} else if (document.documentElement
			&& document.documentElement.clientHeight) {// IE 6 Strict Mode
		winW = document.documentElement.clientWidth;
		winH = document.documentElement.clientHeight;
	} else if (document.body) { // other
		winW = document.body.clientWidth;
		winH = document.body.clientHeight;
	} // for small pages with total size less then the viewport
	return {
		WinW : winW,
		WinH : winH
	};
}

//replace icons with FontAwesome icons like above
function updatePagerIcons(table) {
	var replacement = {
		'ui-icon-seek-first' : 'icon-double-angle-left bigger-140',
		'ui-icon-seek-prev' : 'icon-angle-left bigger-140',
		'ui-icon-seek-next' : 'icon-angle-right bigger-140',
		'ui-icon-seek-end' : 'icon-double-angle-right bigger-140'
	};
	$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon')
			.each(
					function() {
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace(
								'ui-icon', ''));

						if ($class in replacement)
							icon.attr('class', 'ui-icon '
									+ replacement[$class]);
					})
}

function enableTooltips(table) {
	$('.navtable .ui-pg-button').tooltip({
		container : 'body'
	});
	$(table).find('.ui-pg-div').tooltip({
		container : 'body'
	});
}