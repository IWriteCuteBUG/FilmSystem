package com.stylefeng.guns.rest.common.persistence.status;


import javassist.bytecode.SignatureAttribute;

public class StockLogStatus extends SignatureAttribute.BaseType {
    public StockLogStatus(Integer index, String typeName) {
        super(typeName);
    }

    public static StockLogStatus INIT = new StockLogStatus(1, "初始化");
    public static StockLogStatus SUCCESS = new StockLogStatus(2, "成功");
    public static StockLogStatus FAIL = new StockLogStatus(3, "失败");



}
