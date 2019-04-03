package com.rcloud.spellminiprogram.job;

import com.rcloud.spellminiprogram.contorller.BaseController;
import com.rcloud.spellutils.utils.WXMiniProgramUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author xuchenguang
 * @since 2019.01.09
 */
@Component
public class JobAccessToken extends BaseController {


    /**
     * 获取getAccessToken 中控服务
     *
     * @throws InterruptedException
     */
    @Scheduled(fixedRate = 7000000)
    public void reportCurrentTimeCron() throws Exception {
        loggerInfo("获取getAccessToken 中控服务");
        //获取getAccessToken
        String accessToken = WXMiniProgramUtils.getAccessToken(appId, secret);

        System.out.println(accessToken);
    }
}
