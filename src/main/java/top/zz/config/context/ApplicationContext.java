package top.zz.config.context;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * Created by X-man on 2017/3/30.
 */
@Configuration
public class ApplicationContext {

    @Bean
    public DefaultKaptcha defaultKaptcha(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.border","yes");
        properties.setProperty("kaptcha.border.color","221,221,221");
        properties.setProperty("kaptcha.textproducer.font.color","0,0,0");
        properties.setProperty("kaptcha.image.width","100");
        properties.setProperty("kaptcha.textproducer.font.size","30");
        properties.setProperty("kaptcha.image.height","38");
        properties.setProperty("kaptcha.session.key","captchaCode");
        properties.setProperty("kaptcha.noise.impl","com.google.code.kaptcha.impl.NoNoise");
        properties.setProperty("kaptcha.textproducer.char.length","4");
        properties.setProperty("kaptcha.textproducer.font.names","microsoft yahei,Arial");
        properties.setProperty("kaptcha.background.clear.from","246,246,246");
        properties.setProperty("kaptcha.word.impl","com.google.code.kaptcha.text.impl.MyWordRenderer");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
