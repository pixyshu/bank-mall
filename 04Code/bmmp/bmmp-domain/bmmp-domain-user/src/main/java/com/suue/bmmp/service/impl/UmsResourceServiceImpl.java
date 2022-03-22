package com.suue.bmmp.service.impl;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suue.bmmp.constant.AuthConstant;
import com.suue.bmmp.dao.UmsRoleDao;
import com.suue.bmmp.dao.UmsRoleResourceRelationDao;
import com.suue.bmmp.entity.UmsResource;
import com.suue.bmmp.dao.UmsResourceDao;
import com.suue.bmmp.entity.UmsRole;
import com.suue.bmmp.entity.UmsRoleResourceRelation;
import com.suue.bmmp.service.RedisService;
import com.suue.bmmp.service.UmsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.Resource;

/**
 * 后台资源表(UmsResource)表服务实现类
 *
 * @author shuds
 * @since 2022-03-21 19:50:58
 */
@Service("umsResourceService")
public class UmsResourceServiceImpl implements UmsResourceService {
    @Resource
    private UmsResourceDao resourceDao;
    @Autowired
    private UmsRoleDao roleMapper;
    @Autowired
    private UmsRoleResourceRelationDao roleResourceRelationMapper;
    @Autowired
    private RedisService redisService;
    @Value("${spring.application.name}")
    private String applicationName;


    @Override
    public int create(UmsResource umsResource) {
        umsResource.setCreateTime(new Date());
        int count = resourceDao.insert(umsResource);
        initResourceRolesMap();
        return count;
    }

    @Override
    public int update(Long id, UmsResource umsResource) {
        umsResource.setId(id);
        int count = resourceDao.update(umsResource);
        initResourceRolesMap();
        return count;
    }

    @Override
    public UmsResource getItem(Long id) {
        return resourceDao.queryById(id);
    }

    @Override
    public int delete(Long id) {
        int count = resourceDao.deleteById(id);
        initResourceRolesMap();
        return count;
    }

    @Override
    public List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        return resourceDao.selectAllByNameAndUrl(categoryId, nameKeyword, urlKeyword);
    }

    @Override
    public List<UmsResource> listAll() {
        return resourceDao.queryAll(new UmsResource());
    }


    @Override
    public Map<String,List<String>> initResourceRolesMap() {
        Map<String,List<String>> resourceRoleMap = new TreeMap<>();
        List<UmsResource> resourceList = resourceDao.queryAll(new UmsResource());
        List<UmsRole> roleList = roleMapper.queryAll(new UmsRole());
        List<UmsRoleResourceRelation> relationList = roleResourceRelationMapper.queryAll(new UmsRoleResourceRelation());

        for (UmsResource resource : resourceList) {
            Set<Long> roleIds = relationList.stream()
                    .filter(item -> item.getResourceId()
                            .equals(resource.getId()))
                    .map(UmsRoleResourceRelation::getRoleId)
                    .collect(Collectors.toSet());

            List<String> roleNames = roleList.stream()
                    .filter(item -> roleIds.contains(item.getId()))
                    .map(item -> item.getId() + "_" + item.getName())
                    .collect(Collectors.toList());
            resourceRoleMap.put("/"+applicationName+resource.getUrl(),roleNames);
        }

        redisService.del(AuthConstant.RESOURCE_ROLES_MAP_KEY);
        redisService.hSetAll(AuthConstant.RESOURCE_ROLES_MAP_KEY, resourceRoleMap);
        return resourceRoleMap;

    }
}
