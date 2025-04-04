package com.project.ecommerce.dto.CMS;


import com.project.ecommerce.mbg.model.Article;
import com.project.ecommerce.mbg.model.ArticleImage;
import com.project.ecommerce.mbg.model.ArticleQa;
import com.project.ecommerce.mbg.model.ArticleVideo;
import lombok.Data;

import java.util.List;

@Data
public class Articles {
    private Article article;
    private List<ArticleQa> QA;
    private List<ArticleImage> images;
    private List<ArticleVideo> videos;
}
