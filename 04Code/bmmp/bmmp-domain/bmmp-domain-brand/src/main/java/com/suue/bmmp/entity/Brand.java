package com.suue.bmmp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 品牌表(Brand)实体类
 *
 * @author shuds
 * @since 2022-03-17 21:30:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand implements Serializable {
    private static final long serialVersionUID = -68448401754968188L;
    
    private Long id;
    
    private String name;
    /**
     * 首字母
     */
    private String firstLetter;
    
    private Integer sort;
    /**
     * 是否为品牌制造商：0->不是；1->是
     */
    private Integer factoryStatus;
    
    private Integer showStatus;
    /**
     * 产品数量
     */
    private Integer productCount;
    /**
     * 产品评论数量
     */
    private Integer productCommentCount;
    /**
     * 品牌logo
     */
    private String logo;
    /**
     * 专区大图
     */
    private String bigPic;
    /**
     * 品牌故事
     */
    private String brandStory;
}


