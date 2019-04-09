package com.quanlehui.adminservice.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;

import com.quanlehui.allserviceapi.admin.constant.URIConstants;
import com.quanlehui.servicebase.base.cache.RedisCache;
import com.quanlehui.servicebase.base.constant.RedisKeyConstants;
import com.quanlehui.servicebase.base.constant.TimeConstants;
import com.quanlehui.servicebase.base.util.VOUtils;
import com.quanlehui.servicebase.base.vo.BaseVO;
import com.quanlehui.servicebase.base.vo.CodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 公共资源控制器
 *
 * @author yezi
 * @date 2019/1/25 10:41
 */
@Slf4j
@RestController
public class CommonController {

    @Autowired
    DefaultKaptcha defaultKaptcha;

    @Autowired
    RedisCache redisCache;

    /**
     * 获取图片验证码
     */
    @RequestMapping(value = URIConstants.COMMON_IMGCODE, method = RequestMethod.GET)
    public BaseVO getImgCode() {
        try {
            String imgCodeId = UUID.randomUUID().toString().replace("-", "").toUpperCase();
            ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
            // 产生验证码字符串并保存到缓存中
            String createText = defaultKaptcha.createText();
            int createTextInsert = createText.length() / 2;
            int add1 = Integer.parseInt(createText.substring(0, createTextInsert));
            int add2 = Integer.parseInt(createText.substring(createTextInsert, createText.length()));
            int value = Integer.valueOf(add1) + Integer.valueOf(add2);
            redisCache.setCacheValue(RedisKeyConstants.USER_IMAGE_CDOE + imgCodeId, value + "", TimeConstants.TIME_TEN_MINUTE);
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(add1 + "+" + add2 + "=?");
            ImageIO.write(challenge, "jpg", jpegOutputStream);
            // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
            byte[] captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
            Map<String, String> data = new HashMap<>(4);
            data.put("code", new String(Base64.encodeBase64(captchaChallengeAsJpeg)));
            data.put("imgCodeId", imgCodeId);
            return VOUtils.returnExtendVOSuccess(data);
        } catch (Exception e) {
            log.error("图片验证码生成失败", e);
            return VOUtils.returnBaseVODynamic(CodeEnum.DYNAMIC_CODE, "图片验证生成失败");
        }
    }

}
