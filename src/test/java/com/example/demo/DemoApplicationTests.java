package com.example.demo;

import com.example.demo.repository.User.TeacherDao;
import com.example.demo.repository.info.CompetitionInfoDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private CompetitionInfoDao competitionInfoDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TeacherDao teacherDao;

    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("test","success");
        System.out.println(redisTemplate.opsForValue().get("test"));
    }

    @Test
    void test(){
        PageRequest pageRequest = PageRequest.of(0, 5);

        String name = "";

        System.out.println(teacherDao.getAllAuthorizedByNameLike("%"+name+"%", pageRequest).getContent());
    }

    @Test
    void tes (){
        PageRequest pageRequest = PageRequest.of(0, 10);

        String name = "";

        System.out.println(competitionInfoDao.getAllCompetitionItemByFatherId("%"+name+"%",1,pageRequest).getContent());
    }

}
