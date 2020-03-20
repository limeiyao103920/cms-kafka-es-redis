package com.lmy.kafka;

import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.listener.MessageListener;

import com.lmy.entity.CompanyAnnualCheck;
import com.lmy.service.CompanyAnnualCheckService;

public class MsgListener implements MessageListener<String,String> {

	@Autowired
	CompanyAnnualCheckService companyAnnualCheckService;
	@Autowired
	RedisTemplate redisTemplate;
	@SuppressWarnings("unchecked")
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		String key = data.value();
		System.err.println("收到了消息"+key);
		List<CompanyAnnualCheck> list = redisTemplate.opsForList().range(key, 0, -1);
		for (CompanyAnnualCheck check : list) {
			
			companyAnnualCheckService.insert(check);
			System.err.println(check.getId()+"导入完毕");
		}
		redisTemplate.delete(key);
	}

}
