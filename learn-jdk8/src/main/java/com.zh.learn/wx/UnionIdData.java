package com.zh.learn.wx;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 * <p>
 * Author: zhuanghuang
 * Date: 2019-01-15
 */

@Data
@Accessors(chain = true)
@ToString
public class UnionIdData implements Serializable {

    private static final long serialVersionUID = -4280855694804552287L;

    private int subscribe;
    private String openid;
    private String unionId;
}
