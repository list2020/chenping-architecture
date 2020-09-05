package com.ping.chen.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 代码生成器
 *
 * @author ping.chen
 * @email 2676455951@qq.com
 * @date 2020年09月05日 下午21:12:58
 */
@Mapper
public interface GeneratorDao {
	
	List<Map<String, Object>> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	Map<String, String> queryTable(String tableName);
	
	List<Map<String, String>> queryColumns(String tableName);
}
