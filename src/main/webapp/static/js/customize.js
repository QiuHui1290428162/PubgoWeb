//验证登录
function isLogin(id){
	if ( id == null )
	{
		vant.Dialog.alert({
			message: '您还未登录，点击确认跳转到登录界面',
			theme: 'round-button',
		}).then(() => {
			window.location.href='/PubgoWeb/login.html';
		});
	}
}

//验证员工号登录
function isStaffLogin(){
	axios.get('/PubgoWeb/login/getStaff')
	.then( function(response) {
		if( response.data.code != 200 ){
			vant.Dialog.alert({
				message: response.data.msg,
				theme: 'round-button',
			}).then(() => {
				window.location.href='/PubgoWeb/login.html';
			});
		}
	})
	.catch(function (error) {
		// 请求发送失败
   	  	vant.Toast.fail("校检员工号登录错误");
   	    console.error(error);
	});
}


//跳转用户管理界面
function userManage(id){
	//跳转登录界面
	window.location.href='/PubgoWeb/login.html';
}



//格式化日期yyyy-mm-dd
function toDateString(value){
	console.log(11);
	console.log(value);
	let seperator = "-";
	//月份
	let month = value.getMonth() + 1;
	if ( month>=1 && month<=9 ){
		month = "0"+month;
	}
	//日
	let day = value.getDate();
	if ( day>=1 && day<=9 ){
		day = "0"+day;
	}
	var currentDate = value.getFullYear()+seperator+month+seperator+day
	//return currentDate;
	console.log(currentDate);
}

//获取URL参数值
function getQueryString(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}





















 