package com.sh.demo.service;

import com.sh.demo.domain.Author;
import java.util.List;

/**
 * Created by wuminggu on 2018/4/19.
 */
public interface AuthorService {
    /**
     * 取得用户信息
     * @return
     */
    public List<Author> searchAuthorList();
}
