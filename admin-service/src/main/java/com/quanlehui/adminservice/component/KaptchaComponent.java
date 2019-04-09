package com.quanlehui.adminservice.component;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @Description: 验证码组件
 * @Author: yezi
 * @Date: 2019/4/8 21:11
 */
@Component
public class KaptchaComponent {

    @Bean
    public DefaultKaptcha getDefaultKaptcha() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 图片边框，合法值：yes , no
        properties.setProperty("kaptcha.border", "yes");
        // 边框颜色，合法值： r,g,b (and optional alpha) 或者white,black,blue
        properties.setProperty("kaptcha.border.color", "blue");
        // 边框厚度，合法值：>0
        properties.setProperty("kaptcha.border.thickness", "1");
        // 图片宽 110
        properties.setProperty("kaptcha.image.width", "110");
        // 图片高40
        properties.setProperty("kaptcha.image.height", "40");
        // properties.setProperty("kaptcha.session.key", "KAPTCHA_SESSION_KEY")
        // 图片实现类
        properties.setProperty("kaptcha.producer.impl", "com.google.code.kaptcha.impl.DefaultKaptcha");
        // 文本实现类
        properties.setProperty("kaptcha.textproducer.impl", "com.google.code.kaptcha.text.impl.DefaultTextCreator");
        // 文本集合，验证码值从此集合中获取
        properties.setProperty("kaptcha.textproducer.char.string", "1234567890");
        // 验证码长度 3
        properties.setProperty("kaptcha.textproducer.char.length", "2");
        // 文字间隔 2
        properties.setProperty("kaptcha.textproducer.char.space", "2");
        // 字体 Arial, Courier
        properties.setProperty("kaptcha.textproducer.font.names", "Arial, Courier");
        // 字体大小 40px
        properties.setProperty("kaptcha.textproducer.font.size", "40");
        // 字体颜色，合法值： r,g,b 或者 white,black,blue
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        // 文字渲染器
        properties.setProperty("kaptcha.word.impl", "com.google.code.kaptcha.text.impl.DefaultWordRenderer");
        // 干扰实现类
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.DefaultNoise");
        // 干扰颜色，合法值： r,g,b 或者 white,black,blue
        properties.setProperty("kaptcha.noise.color", "blue");
        // 图片样式：水纹com.google.code.kaptcha.impl.WaterRipple,鱼眼com.google.code.kaptcha.impl.FishEyeGimpy,阴影com.google.code.kaptcha.impl.ShadowGimpy
        properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.WaterRipple");
        // 背景实现类
        properties.setProperty("kaptcha.background.impl", "com.google.code.kaptcha.impl.DefaultBackground");
        // 背景颜色渐变，开始颜色
        properties.setProperty("kaptcha.background.clear.from", "yellow");
        // 背景颜色渐变，结束颜色
        properties.setProperty("kaptcha.background.clear.to", "white");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

    public static void main(String[] args) {
        try {
            FileOutputStream jpegOutputStream = new FileOutputStream("D:\\temp\\test.jpg");
            DefaultKaptcha captchaProducer = new KaptchaComponent().getDefaultKaptcha();
            //生产验证码字符串并保存到缓存中
            String createText = captchaProducer.createText();
            int createTextInsert = createText.length() / 2;
            int add1 = Integer.parseInt(createText.substring(0, createTextInsert));
            int add2 = Integer.parseInt(createText.substring(createTextInsert));
            int value = Integer.valueOf(add1) + Integer.valueOf(add2);
            System.out.println(value);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = captchaProducer.createImage(add1 + "+" + add2 + "=?");
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}