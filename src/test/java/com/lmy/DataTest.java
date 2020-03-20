package com.lmy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lmy.entity.CompanyAnnualCheck;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class DataTest {

	@Autowired
	RedisTemplate redisTemplate;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	@Test
	public void testData() throws Exception {
		File file = new File("C:\\Users\\DELL\\Desktop\\data.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line=null;
		br.readLine();
		ArrayList<CompanyAnnualCheck> list=new ArrayList<CompanyAnnualCheck>();
		while((line=br.readLine())!=null) {
			CompanyAnnualCheck check = new CompanyAnnualCheck();
			String[] split = line.split("	");
			check.setId(Integer.parseInt(split[0]));
			check.setKeywords(split[1]);
			check.setDescription(split[2]);
			check.setCompanyName(split[3]);
			check.setMainBusinessProducts(split[4]);
			check.setAddress(split[5]);
			check.setRegisteredCapital(split[6]);
			Date date = new SimpleDateFormat("yyyy/MM/dd").parse(split[7]);
			check.setFoundingTime(date);
			String da=split[8];
			check.setAnnualCheckStatus(split[9]);
			
			list.add(check);
		}
		redisTemplate.opsForList().leftPushAll("check_list", list.toArray());
		System.out.println("保存到redis");
		kafkaTemplate.send("check", "check_list");
		System.out.println("吧redis的key发送到kafka");
	}
}
