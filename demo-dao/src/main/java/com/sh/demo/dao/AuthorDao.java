package com.sh.demo.dao;

import java.util.List;
import com.sh.demo.domain.Author;

/**
 * Created by wuminggu on 2018/4/19.
 */
public interface AuthorDao {
    /**
     * ��ѯ�û���Ϣ
     * @return
     */
    List<Author> searchAuthorList();
}
