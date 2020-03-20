package com.lmy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.lmy.dao.CheckRepository;
import com.lmy.entity.CompanyAnnualCheck;
import com.lmy.service.CompanyAnnualCheckService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class EsTest {

	@Autowired
	CompanyAnnualCheckService companyAnnualCheckService;
	@Autowired
	CheckRepository checkRepository;
	@Test
	public void esTest() {
		PageInfo<CompanyAnnualCheck> selectAll = companyAnnualCheckService.selectAll(1, 500);
		checkRepository.saveAll(selectAll.getList());
		System.err.println("导入es索引库");
	}
}
