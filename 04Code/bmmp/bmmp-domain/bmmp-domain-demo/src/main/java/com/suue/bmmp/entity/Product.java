package com.suue.bmmp.entity;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 *  理财产品(Product)实体类
 *
 * @author shuds
 * @since 2022-03-21 18:48:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private static final long serialVersionUID = -74887732245248317L;
    /**
     * ID
     */
    private Long id;
    /**
     * 产品名称
     */
    private String name;
    /**
     * 图片
     */
    private String pic;
    /**
     * 产品介绍
     */
    private String description;
    /**
     * 产品代码
     */
    private String code;
    /**
     * 首笔起点金额
     */
    private Double firstPurchaseMoney;
    /**
     * 递增起点金额
     */
    private Double addPurchaseMoney;
    /**
     * 单笔最高金额
     */
    private Double maxPurchaseMoney;
    /**
     * 年利率
     */
    private Double rate;
    /**
     * 总共售卖
     */
    private Double sumSaleMoney;
    /**
     * 上架状态：0->下架；1->上架
     */
    private Integer isPublish;
    /**
     * 新品状态:0->不是新品；1->新品
     */
    private Integer isNew;
    /**
     * 推荐状态；0->不推荐；1->推荐
     */
    private Integer isRecommand;
    /**
     * 以逗号分隔产品服务：1 保本保息，2 当日起息，3快存快取
     */
    private Integer serviceId;
    /**
     * 逻辑删除（1 表示删除，0表示未删除）
     */
    private Integer isDelete;
    /**
     * 促销开始时间
     */
    private Date promotionStartTime;
    /**
     * 促销结束时间
     */
    private Date promotionEndTime;
    /**
     * 创建时间（添加数据时主动创建）
     */
    private Date createTime;
    /**
     * 更新时间（操作数据时被动更新）
     */
    private Date updateTime;
    /**
     * 产品分类ID（活期、定期、债券基金、偏债基金、FOF基金）
     */
    private Long typeId;
    /**
     * 产品持有时常
     */
    private String purchaseTimeLong;
    /**
     * 风险等级
     */
    private String riskLevel;
    /**
     * 上架时间
     */
    private Date onShelfTime;
    /**
     * 下架时间
     */
    private Date offShelfTime;
    /**
     * 单位净值
     */
    private Double nav;
    /**
     * 发行到今天的总利率
     */
    private Double totalRate;
    /**
     * 删除产品时间
     */
    private Date deleteTime;
    /**
     * 产品分类ID
     */
    private Long categoryId;
    /**
     * 产品详情ID
     */
    private Long detailId;
    /**
     * 产品广告ID
     */
    private Long advertiseId;
    /**
     * 行业ID
     */
    private Long industryId;
    /**
     * 产品周期ID
     */
    private Long timeCycleId;
    /**
     * 发行ID
     */
    private Long isuueId;
    /**
     * 副标题
     */
    private String title;
}


