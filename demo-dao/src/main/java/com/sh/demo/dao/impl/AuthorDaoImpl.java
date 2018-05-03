package com.sh.demo.dao.impl;

import com.sh.demo.dao.AuthorDao;
import com.sh.demo.domain.Author;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by wuminggu on 2018/4/19.
 */
@Repository("AuthorDao")
public class AuthorDaoImpl implements AuthorDao {
    private final static Logger log = LoggerFactory.getLogger(AuthorDaoImpl.class);

    @Autowired
    private SqlSessionTemplate demoSqlSession;

    @Override
    public List<Author> searchAuthorList() {
        return demoSqlSession.selectList("Author.searchAuthorList");
    }
}
