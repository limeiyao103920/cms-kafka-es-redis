package com.lmy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmy.dao.CompanyAnnualCheckDao;
import com.lmy.entity.CompanyAnnualCheck;

@Service
public class CompanyAnnualCheckServiceImpl implements CompanyAnnualCheckService{

	@Autowired
	CompanyAnnualCheckDao companyAnnualCheckDao;
	@Override
	public void insert(CompanyAnnualCheck check) {
		
		companyAnnualCheckDao.insert(check);
	}
	@Override
	public PageInfo<CompanyAnnualCheck> selectAll(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<CompanyAnnualCheck>(companyAnnualCheckDao.selectAll());
	}
	@Override
	public int upd(CompanyAnnualCheck check) {
		// TODO Auto-generated method stub
		
		return companyAnnualCheckDao.upd(check);
	}
	@Override
	public CompanyAnnualCheck toUpd(String id) {
		// TODO Auto-generated method stub
		return companyAnnualCheckDao.toUpd(id);
	}

}
