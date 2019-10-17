package com.stylefeng.guns.core.base.tips;

/**
 * 返回给前台的错误提示
 *
 * @author fengshuonan
 * @date 2016年11月12日 下午5:05:22
 */
public class ErrorTip extends Tip {

    private Integer status;
    public ErrorTip(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
    public ErrorTip(int code, String message, Integer status) {
        super();
        this.code = code;
        this.message = message;
        this.status = status;
    }
    public ErrorTip(String message, Integer status) {
        super();
        this.message = message;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
