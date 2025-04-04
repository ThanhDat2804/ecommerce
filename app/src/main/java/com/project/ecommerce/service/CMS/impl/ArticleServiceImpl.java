package com.project.ecommerce.service.CMS.impl;

import com.project.ecommerce.dao.CMS.ArticleDao;
import com.project.ecommerce.dto.CMS.Articles;
import com.project.ecommerce.service.CMS.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleDao articleDao;

    @Override
    public List<Articles> getAllArticles() {
        //  TODO: it works but too much query to database
        return articleDao.getAllArticles();
    }

    @Override
    public Articles getArticle(int articleId) {
        return articleDao.getArticle(articleId);
    }
}