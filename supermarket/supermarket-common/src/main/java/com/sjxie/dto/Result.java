package com.sjxie.dto;
import java.io.Serializable;

/**
 * 返回结果
 * <p>
 * 1、对返回结果进行包装<br/>
 * 2、code表示返回码 1:成功  其它:错误码<br/>
 * 3、message表示错误信息<br/>
 * 4、data 成功结果<br/>
 * </p>
 *
 * @author dongzhou2@iflytek.com on 2018/1/15.
 */
public class Result<T> implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 成功时返回 1
     */
    private static final String SUCCESS_CODE = "1";

    /**
     * 返回码
     * <p>
     * 1:成功  默认成功<br/>
     * 其它:错误码<br/>
     * </p>
     */
    private String code = SUCCESS_CODE;
    /**
     * 错误信息
     */
    private String message = "success";
    /**
     * 成功结果
     */
    private T data;

    /**
     * 分页数据
     */
    private Page Page;
    
    public Result() {
    }

    /**
     * 成功时构造器(建议)
     *
     * @param data
     */
    public Result(T data) {
        this.data = data;
    }

    /**
     * 失败时构造器(建议)
     *
     * @param code
     * @param message
     */
    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public Result(Integer code, String message) {
        this(String.valueOf(code),message);
    }

    public Result(String code, String message, T data,Page page) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.Page = page;
    }


    /**
     * 判断是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        return SUCCESS_CODE.equals(this.code);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    private void setPage(Page page) {
    	this.Page = page;
    }

    public void setPage(int pageNum,int pageSize,int pageCount,int dataCount) {
    	Page pageHelper = new Page(pageNum,pageSize,pageCount,dataCount);
    	setPage(pageHelper);
    }
    public Page getPage() {
    	return this.Page;
    }

	@Override
	public String toString() {
		return "Result [code=" + code + ", message=" + message + ", data=" + data + ", Page=" + Page + "]";
	}
    
    
}
