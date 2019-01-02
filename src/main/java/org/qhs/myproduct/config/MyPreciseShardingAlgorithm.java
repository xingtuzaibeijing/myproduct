package org.qhs.myproduct.config;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/11/18
 */
@Configuration
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {

	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {
		for (String tableName : availableTargetNames) {
			if (tableName.endsWith(shardingValue.getValue() % 2 + "")) {
				return tableName;
			}
		}
		throw new IllegalArgumentException();
	}

}