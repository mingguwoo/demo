package com.sh.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.sh.demo.common.base.log.SystemLog;
import com.sh.demo.dao.AuthorDao;
import com.sh.demo.domain.Author;
import com.sh.demo.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by wuminggu on 2018/4/19.
 */
@Repository("AuthorService")
public class AuthorServiceImpl implements AuthorService {
    private final static Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

    @Autowired
    private AuthorDao authorDao;

    @SystemLog(description = "查询用户信息")
    @Override
    public List<Author> searchAuthorList() {
        List<Author> res = authorDao.searchAuthorList();
        return res;
    }
}
