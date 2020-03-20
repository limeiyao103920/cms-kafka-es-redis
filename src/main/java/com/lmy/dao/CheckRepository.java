package com.lmy.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.lmy.entity.CompanyAnnualCheck;

public interface CheckRepository extends ElasticsearchRepository<CompanyAnnualCheck, Integer> {

}
