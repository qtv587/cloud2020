package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: XiaoDu
 * @CreateTime: 2023/5/4 20:58
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
    private Integer code;
    private String message;
    private T data;

}
