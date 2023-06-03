package com.pubgo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.youzan.cloud.open.sdk.core.client.core.DefaultYZClient;
import com.youzan.cloud.open.sdk.core.client.core.YouZanClient;


//spring 容器管理
@Configuration
public class YouZanClientConfig {


	//有赞YouZanClient全局唯一
    @Bean
    public YouZanClient yzClient() {
        return  new DefaultYZClient();
    }
}
