package com.sh.demo.service;

import com.sh.demo.domain.Author;
import java.util.List;

/**
 * Created by wuminggu on 2018/4/19.
 */
public interface AuthorService {
    /**
     * ȡ���û���Ϣ
     * @return
     */
    public List<Author> searchAuthorList();
}
