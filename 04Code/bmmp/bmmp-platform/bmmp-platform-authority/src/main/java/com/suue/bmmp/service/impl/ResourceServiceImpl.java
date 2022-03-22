package com.suue.bmmp.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.suue.bmmp.constant.RedisConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 资源与角色匹配关系管理业务类
 * Created by shuds on 2022/3/1
 **/
@Service
public class ResourceServiceImpl {
    private Map<String, List<String>> resourceRolesMap;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @PostConstruct
    public void initData() {
        resourceRolesMap = new TreeMap<>();
//        resourceRolesMap.put("/api/hello", CollUtil.toList("ADMIN"));
        resourceRolesMap.put("/api/sso/hello", CollUtil.toList("ADMIN"));
        resourceRolesMap.put("/api/sso/login", CollUtil.toList("ADMIN"));
        resourceRolesMap.put("/api/sso/getCurrentUserInfo", CollUtil.toList("ADMIN"));
        resourceRolesMap.put("/api/user/currentUser", CollUtil.toList("ADMIN", "TEST"));
        redisTemplate.opsForHash().putAll(RedisConstant.RESOURCE_ROLES_MAP, resourceRolesMap);
    }
}
