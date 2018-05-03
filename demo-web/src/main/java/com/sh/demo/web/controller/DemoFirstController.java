package com.sh.demo.web.controller;

import com.alibaba.fastjson.JSON;
import com.sh.demo.common.base.log.SystemLog;
import com.sh.demo.common.result.ResultCodeEnum;
import com.sh.demo.common.result.ResultResponse;
import com.sh.demo.domain.Author;
import com.sh.demo.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by wuminggu on 2018/4/19.
 */
@RestController
@RequestMapping("/demo")
public class DemoFirstController {
    private final static Logger log = LoggerFactory.getLogger(DemoFirstController.class);
    @Autowired
    private AuthorService authorService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/first/demoFirst", method = RequestMethod.GET)
    public String demoFirst() {
        redisTemplate.opsForValue().set("one","11111");
        return (String) redisTemplate.opsForValue().get("one");
    }

    @RequestMapping(value = "/first/getUserInfo", method = RequestMethod.GET)
    public ResultResponse getUserInfo() {
        if (redisTemplate.opsForValue().get("two") == null || "".equals(redisTemplate.opsForValue().get("two"))) {
            List<Author> result = authorService.searchAuthorList();
            redisTemplate.opsForValue().set("two", result);
            log.error("L44_search list is {}", JSON.toJSONString(result));
        }
        ResultResponse rr = new ResultResponse(ResultCodeEnum.DE_OK, redisTemplate.opsForValue().get("two"));
        return rr;
    }

}
