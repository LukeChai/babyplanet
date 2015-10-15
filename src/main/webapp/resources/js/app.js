/**
 * App common functions
 */
var _bpView = '#bp-view';

/**
 * Re-factor a link
 */
function submitA(href, target) {
	if (!target) {
		target = _bpView;
	}
	$.ajax({
		url : href,
		async : true,
		success : function(data) {
			$(target).html(data);
		}
	});
}

/**
 * Re-factor form submit via ajax
 */
function submitForm(form, options, target) {
	if (!options)
		options = {};
	if (!target)
		target = _bpView;
	var callback = function(data) {
		if (options.callback) {
			options.callback(data);
		}
		$(target).html(data);
	};
	options.success = callback;
	$(form).ajaxSubmit(options);
}
