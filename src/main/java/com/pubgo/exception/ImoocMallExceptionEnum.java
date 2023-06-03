package com.pubgo.exception;

/**
 *   异常枚举
 * @author Administrator
 *
 */
public enum ImoocMallExceptionEnum {

	NEED_USER_NAME( 10001, "用户名不能为空"),
	NOT_USER_EXIST( 10002, "该账号不存在"),
	NOT_USER_LOG( 10003, "用户未登录" ),
	NOT_STAFF_LOG(10004, "请用员工号登录，再使用该功能"),
	REQUEST_PARAM_ERROR(10005,"校检请求参数时发生错误"),
	NOT_DATE(10006,"开始时间大于结束时间"),
	NOT_TEl_FORMAT(10007,"手机号不是11位数字，请重新输入"),
	NOT_VIPNURSINGCARD_EXIST(10008,"该会员未办理护理卡，请在电脑端会员程序办理续卡"),
	NOT_DELETE(10009,"删除失败，请刷新重试"),
	NOT_UPDATE(10009,"信息更新失败，请刷新重试"),
	NOT_IMAGE_COMPRESSION(10010,"图像压缩失败，请重新提交"),
	ERROR_CUSTOMER_PERMISSION(10011,"查询店铺许可权限错误"),
	ERROR_DATE_HAS_BEEN_DELETED(10012, "数据已被删除，请刷新重试"),
	ERROR_STEP_CHANGED(10013, "洗护进度已变动，请刷新重试"),
	NOT_ID(10013, "为查询到该订单ID，请刷新重试"),
	ORDER_CONFIRMED(10014, "订单已被确认，请刷新重试"),
	YZ_ERROR_UNKNOWN_TEPY(10015, "未知的推送消息类型"),
	FAILED_ADD_VIP(10016, "会员新增失败"),
	FAILED_EXISTS_VIP(10017, "会员已存在"),
	NOT_SMSSEND(10100,"短信发送失败"),
	SYSTEM_ERROR(20000,"系统出现异常，请联系管理员");
	
	
	
	
	//异常码
	private Integer code;
	//异常信息
	private String msg;
	
	ImoocMallExceptionEnum( Integer code, String msg ) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}













