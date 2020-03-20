package com.lmy.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lmy.entity.CompanyAnnualCheck;

public interface CompanyAnnualCheckService {

	void insert(CompanyAnnualCheck check);

	PageInfo<CompanyAnnualCheck> selectAll(int pageNum,int pageSize);
	
	int upd(CompanyAnnualCheck check);

	CompanyAnnualCheck toUpd(String id);
}
