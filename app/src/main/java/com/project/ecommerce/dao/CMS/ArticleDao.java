package com.project.ecommerce.dao.CMS;

import com.project.ecommerce.dto.CMS.Articles;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {

    @ApiModelProperty(value = "get all articles and its media content")
    List<Articles> getAllArticles();

    @ApiModelProperty(value = "get one article and its media content")
    Articles getArticle(@Param("id") int id);

}
