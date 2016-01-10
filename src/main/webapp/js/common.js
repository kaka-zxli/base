function sendGET(_url, _requestJson, _successFun, _errorFun, _async) {
	send("GET", _url, _requestJson, _successFun, _errorFun, _async)
}

function sendPOST(_url, _requestJson, _successFun, _errorFun, _async) {
	send("POST", _url, _requestJson, _successFun, _errorFun, _async)
}

/**
 * Ajax提交
 * 
 * @param _url
 * @param _requestJson
 * @param _successFun
 * @param _errorFun
 */
function send(_method, _url, _requestJson, _successFun, _errorFun, _async) {
	if (!_requestJson) {
		_requestJson = {};
	}
	if (_requestJson == null) {
		_requestJson = {
			_ : new Date().getTime()
		};
	} else {
		_requestJson["_"] = new Date().getTime();
	}

	$.ajax({
				url : _url,
				traditional : true,
				data : _requestJson,
				type : _method,
				dataType : 'json',
				async : _async == null ? true : _async,
				timeout : 10 * 60 * 1000,
				success : function(response) {
					// 返回结果失败，提示错误信息
					if (response.code != 0) {
						if (response.code == 403) {
							window.location.href = response.msg;
							return;
						}
						showMsg(response.msg);
					} else {
						_successFun(response.data);
					}
				},
				error : function(response) {
					if (_errorFun == null) {
						if (response.responseText == null || response.responseText == undefined
								|| response.responseText == "") {

						} else {
							showMsg(response.responseText);
						}
					} else {
						_errorFun(response);
					}
				}
			});
}

function showMsg(msg) {
	$.messager.alert('提示', msg);
}

/**
 * 扩展字符串的trim方法
 */
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
};
