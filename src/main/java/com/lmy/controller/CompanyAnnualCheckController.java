package com.lmy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lmy.entity.CompanyAnnualCheck;
import com.lmy.service.CompanyAnnualCheckService;
import com.lmy.util.HLUtils;

@Controller
public class CompanyAnnualCheckController {

	@Autowired
	ElasticsearchTemplate elasticsearchTemplate;
	@Autowired
	CompanyAnnualCheckService companyAnnualCheckService;
	@RequestMapping("list")
	public String selectAll(Model model,@RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "8")int pageSize) {
		PageInfo<CompanyAnnualCheck> info = companyAnnualCheckService.selectAll(pageNum, pageSize);
		model.addAttribute("info", info);
		return "list";
	}
	
	@RequestMapping("search")
	public String search(Model model,String key,@RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "8")int pageSize) {
		PageInfo<CompanyAnnualCheck> findByHighLight = (PageInfo<CompanyAnnualCheck>) HLUtils.findByHighLight(elasticsearchTemplate, CompanyAnnualCheck.class, pageNum, pageSize, new String[] {"keywords","companyName"}, "id", key);
		model.addAttribute("info", findByHighLight);
		System.err.println(findByHighLight);
		model.addAttribute("key",key );
		return "list";
	}
	
	@RequestMapping("toUpd")
	public String toUpd(Model model,String id) {
		CompanyAnnualCheck check=companyAnnualCheckService.toUpd(id);
		model.addAttribute("check",check );
		return "toUpd";
	}
	
	@RequestMapping("upd")
	public String upd(Model model,CompanyAnnualCheck check) {
		System.err.println("111111111111111111111");
		int i=companyAnnualCheckService.upd(check);
		
		if(i>0) {
			model.addAttribute("msg", "修改成功");
			return "redirect:list";
		}else {
			model.addAttribute("msg", "修改失败");
			return "redirect:toUpd?id="+check.getId();
		}
		
	}
}
