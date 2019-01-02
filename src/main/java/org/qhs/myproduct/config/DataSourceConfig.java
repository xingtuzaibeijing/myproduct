//package org.qhs.myproduct.config;
//
///**
// * @author QianHuaSheng
// * @version V1.0
// * @description
// * @date 2018/11/18
// */
//
//import com.dangdang.ddframe.rdb.sharding.api.rule.BindingTableRule;
//import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
//import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
//import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
//import com.dangdang.ddframe.rdb.sharding.keygen.DefaultKeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import tk.mybatis.spring.annotation.MapperScan;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * 数据源及分表配置
// * Created by Kane on 2018/1/17.
// */
//@Configuration
//@MapperScan(basePackages = "org.qhs.myproduct")
//public class DataSourceConfig {
//
//
//	/**
//	 * 配置数据源0，数据源的名称最好要有一定的规则，方便配置分库的计算规则
//	 *
//	 * @return
//	 */
////	@Bean(name = "dataSource0")
////	@ConfigurationProperties(prefix = "spring.datasource.test1")
////	public DataSource dataSource0() {
////		return DataSourceBuilder.create().build();
////	}
////
////	/**
////	 * 配置数据源1，数据源的名称最好要有一定的规则，方便配置分库的计算规则
////	 *
////	 * @return
////	 */
////	@Bean(name = "dataSource1")
////	@ConfigurationProperties(prefix = "spring.datasource.test2")
////	public DataSource dataSource1() {
////		return DataSourceBuilder.create().build();
////	}
////
////	/**
////	 * 配置数据源规则，即将多个数据源交给sharding-jdbc管理，并且可以设置默认的数据源，
////	 * 当表没有配置分库规则时会使用默认的数据源
////	 *
////	 * @param dataSource0
////	 * @param dataSource1
////	 * @return
////	 */
////	@Bean
////	public DataSourceRule dataSourceRule(@Qualifier("dataSource0") DataSource dataSource0,
////										 @Qualifier("dataSource1") DataSource dataSource1) {
////		Map<String, DataSource> dataSourceMap = new HashMap<>(); //设置分库映射
////		dataSourceMap.put("dataSource0", dataSource0);
////		dataSourceMap.put("dataSource1", dataSource1);
////		return new DataSourceRule(dataSourceMap, "dataSource0"); //设置默认库，两个库以上时必须设置默认库。默认库的数据源名称必须是dataSourceMap的key之一
////	}
//
//	/**
//	 * 配置数据源策略和表策略，具体策略需要自己实现
//	 * @return
//	 */
//	@Bean
//	public ShardingRule shardingRule() {
//		//具体分库分表策略
//		TableRule orderTableRule = TableRule.builder("t_order")
//				.actualTables(Arrays.asList("t_order_0", "t_order_1"))
//				.tableShardingStrategy(new TableShardingStrategy("rid", new ModuloTableShardingAlgorithm()))
////				.dataSourceRule(dataSourceRule)
//				.build();
//
//		//绑定表策略，在查询时会使用主表策略计算路由的数据源，因此需要约定绑定表策略的表的规则需要一致，可以一定程度提高效率
//		List<BindingTableRule> bindingTableRules = new ArrayList<BindingTableRule>();
//		bindingTableRules.add(new BindingTableRule(Arrays.asList(orderTableRule)));
//		DefaultKeyGenerator keyGenerator=new DefaultKeyGenerator();
//		return ShardingRule.builder()
////				.dataSourceRule(dataSourceRule)
//				.tableRules(Arrays.asList(orderTableRule))
//				.bindingTableRules(bindingTableRules)
////				.databaseShardingStrategy(new DatabaseShardingStrategy("user_id", new ModuloDatabaseShardingAlgorithm()))
//				.tableShardingStrategy(new TableShardingStrategy("rid", new ModuloTableShardingAlgorithm()))
////				.keyGenerator(keyGenerator.getClass())
//				.build();
//	}
//
////	/**
////	 * 创建sharding-jdbc的数据源DataSource，MybatisAutoConfiguration会使用此数据源
////	 *
////	 * @param shardingRule
////	 * @return
////	 * @throws SQLException
////	 */
////	@Bean(name = "dataSource")
////	public DataSource shardingDataSource( shardingRule) throws SQLException {
////		return ShardingDataSourceFactory.createDataSource(shardingRule);
////	}
//
////	/**
////	 * 需要手动配置事务管理器
////	 *
////	 * @param dataSource
////	 * @return
////	 */
////	@Bean
////	public DataSourceTransactionManager transactitonManager(@Qualifier("dataSource") DataSource dataSource) {
////		return new DataSourceTransactionManager(dataSource);
////	}
////
////	@Bean(name = "test1SqlSessionFactory")
////	@Primary
////	public SqlSessionFactory testSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
////		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
////		bean.setDataSource(dataSource);
////		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml"));
////		return bean.getObject();
////	}
//
////	@Bean(name = "test1SqlSessionTemplate")
////	@Primary
////	public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
////		return new SqlSessionTemplate(sqlSessionFactory);
////	}
//}
