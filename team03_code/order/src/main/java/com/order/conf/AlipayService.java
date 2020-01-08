package com.order.conf;

import java.io.IOException;

public interface AlipayService {
    /**
     * 支付宝支付调用接口
     * @param response
     * @param request
     * @throws IOException
     * @return
     */
    String aliPay(String a, String b) throws IOException;
}

