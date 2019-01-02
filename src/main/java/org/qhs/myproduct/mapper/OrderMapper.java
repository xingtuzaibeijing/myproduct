package org.qhs.myproduct.mapper;

import org.qhs.myproduct.entity.EntityOrder;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author QianHuaSheng
 * @description 订单映射
 * @className OrderMapper
 * @date 2018/11/17
 */
@Component
public interface OrderMapper extends Mapper<EntityOrder> {
}
