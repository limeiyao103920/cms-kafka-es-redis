package com.lmy.dao;

import java.util.List;

import com.lmy.entity.CompanyAnnualCheck;

public interface CompanyAnnualCheckDao {

	int insert(CompanyAnnualCheck check);
	
	List<CompanyAnnualCheck> selectAll();
	
	int upd(CompanyAnnualCheck check);

	CompanyAnnualCheck toUpd(String id);
}
