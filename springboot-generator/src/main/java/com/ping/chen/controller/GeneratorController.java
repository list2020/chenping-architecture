package com.ping.chen.controller;
import com.alibaba.fastjson.JSON;
import com.ping.chen.service.GeneratorService;
import com.ping.chen.utils.PageUtils;
import com.ping.chen.utils.Query;
import com.ping.chen.utils.R;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 代码生成器
 * 
 * @author ping.chen
 * @email 2676455951@qq.com
 * @date 2020年09月05日 下午21:12:58
 */
@Controller
@RequestMapping(value = "generator")
public class GeneratorController {
	@Autowired
	private GeneratorService generatorService;

	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping(value = "list")
	public R list(@RequestParam Map<String, Object> params, HttpServletResponse res) {

		// 查询列表数据
		Query query = new Query(params);
		List<Map<String, Object>> list = generatorService.queryList(query);
		int total = generatorService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(list, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}

	/**
	 * 生成代码
	 */
	@RequestMapping(value = "code")
	public void code(HttpServletRequest request, HttpServletResponse res) throws IOException {
		String[] tableNames = new String[] {};
		String tables = "[" +request.getParameter("tables") + "]";
//		if(StringUtils.isNotEmpty(tables)){
//			if(tables.contains(",")){
//				String[] splits = tables.split(",");
//				tableNames = new String[splits.length];
//				for (int i=0; i< splits.length; i++){
//					tableNames[i] = splits[i];
//				}
//			}else{
//				tableNames = new String[1];
//				tableNames[0] = tables;
//			}
//		}
		tableNames = JSON.parseArray(tables).toArray(tableNames);
		byte[] data = generatorService.generatorCode(tableNames);
		res.setHeader("XDomainRequestAllowed", "1");
		res.setHeader("Content-Disposition", "attachment; filename=\"generator.zip\"");

		IOUtils.write(data, res.getOutputStream());
	}
}
