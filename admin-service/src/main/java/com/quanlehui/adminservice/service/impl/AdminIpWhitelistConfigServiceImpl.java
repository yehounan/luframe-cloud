package com.quanlehui.adminservice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import com.quanlehui.adminservice.mapper.AdminIpWhitelistConfigMapper;
import com.quanlehui.adminservice.service.AdminIpWhitelistConfigService;
import com.quanlehui.allserviceapi.admin.domain.AdminIpWhitelistConfig;
import com.quanlehui.allserviceapi.admin.param.AdminIpWhitelistConfigPageParam;
import com.quanlehui.allserviceapi.admin.param.AdminIpWhitelistConfigParam;
import com.quanlehui.servicebase.base.exception.ServiceException;
import com.quanlehui.servicebase.base.util.IpUtil;
import com.quanlehui.servicebase.base.util.VOUtils;
import com.quanlehui.servicebase.base.vo.BaseVO;
import com.quanlehui.servicebase.base.vo.CodeEnum;
import com.quanlehui.servicebase.base.vo.ExtendVO;
import com.quanlehui.servicebase.base.vo.PageInfoData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @Description: 白名单service
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Slf4j
@Service
public class AdminIpWhitelistConfigServiceImpl implements AdminIpWhitelistConfigService {

    @Autowired
    private AdminIpWhitelistConfigMapper adminIpWhitelistConfigMapper;

    @Override
    public BaseVO insert(AdminIpWhitelistConfigParam param) {
        String ip=param.getIp();
        if(Strings.isNullOrEmpty(ip)){
            return VOUtils.returnBaseVOError(CodeEnum.ADMIN_USER_IP_ERR);
        }
        boolean flag= IpUtil.isIp(ip);
        if(flag==false){
            return VOUtils.returnBaseVOError(CodeEnum.ADMIN_USER_IP_ERR);
        }

        Example example=new Example(AdminIpWhitelistConfig.class);
        example.and().andEqualTo("ipAddr",ip).andEqualTo("isWhitelist",param.getIsWhitelist());
        List<AdminIpWhitelistConfig> list=adminIpWhitelistConfigMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(list)){
            return VOUtils.returnBaseVOError(CodeEnum.ADMIN_UDER_IP_ISEXIST);
        }

        AdminIpWhitelistConfig config=new AdminIpWhitelistConfig();
        config.setCreateTime(new Date());
        config.setCreator(param.getCreator());
        config.setCreatorId(param.getCreatorId());
        config.setIpAddr(ip);
        config.setIsWhitelist(param.getIsWhitelist());
        adminIpWhitelistConfigMapper.insertSelective(config);
        return VOUtils.returnBaseVOSuccess();
    }


    @Override
    public BaseVO delete(Long id) {
        if(null==id){
            throw new ServiceException(500,"id不能为空");
        }
        adminIpWhitelistConfigMapper.deleteByPrimaryKey(id);
        return VOUtils.returnBaseVOSuccess();
    }


    @Override
    public ExtendVO findByPage(AdminIpWhitelistConfigPageParam param) {
        String ip=param.getIp();
        String beginTime=param.getBeginTime();
        String endTime=param.getEndTime();
        PageHelper.startPage(param.getPageNum(),param.getPageSize());
        Example example=new Example(AdminIpWhitelistConfig.class);
        Example.Criteria criteria=example.and();
        if (!Strings.isNullOrEmpty(ip)){
            criteria.andLike("ipAddr","%"+ip+"%");
        }
        if (!Strings.isNullOrEmpty(beginTime) && !Strings.isNullOrEmpty(endTime)){
            criteria.andGreaterThanOrEqualTo("createTime",beginTime+" 00:00:00").andLessThanOrEqualTo("createTime",endTime+" 23:59:59");
        }
        if(!Strings.isNullOrEmpty(param.getIsWhiteList())){
            criteria.andEqualTo("isWhitelist",param.getIsWhiteList());
        }
        example.orderBy("createTime").desc();
        List<AdminIpWhitelistConfig> list= adminIpWhitelistConfigMapper.selectByExample(example);
        PageInfo<AdminIpWhitelistConfig> pageInfo = new PageInfo<>(list);
        PageInfoData<AdminIpWhitelistConfig> page = new PageInfoData<>();
        page.setList(list);
        page.setTotal(pageInfo.getTotal());
        page.setPages(pageInfo.getPages());
        return VOUtils.returnExtendVOSuccess(page);
    }


    @Override
    public List<AdminIpWhitelistConfig> findAll() {
        List<AdminIpWhitelistConfig> list=adminIpWhitelistConfigMapper.selectAll();
        return list;
    }

    @Override
    public List<String> getIps() {
        List<String> ips= Lists.newArrayList();
        List<AdminIpWhitelistConfig> list=adminIpWhitelistConfigMapper.selectAll();
        list.forEach(s->{
            ips.add(s.getIpAddr());
        });
        return ips;
    }
}
