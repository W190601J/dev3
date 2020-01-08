package com.order.conf;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101600703564";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCStyf7XXGpn6NvvGMCVSTcXkbsfpNncIbFd8/kbiILL6UUj4OiJzoVXVHhJ9xt1AHaYwr/+8Al2wblUcDinStNZh8HieGENeX+Nv133ZUOR/plxOcAfHq2Z+GqHAWNGXFM2qpWeFITsP2WF4I+iJx0batm4OkVAzivNg62IBpEcE4kF1Zxtxe8L4zWM+mc7VjmKwxiYE3MFwibley2XYJWXaLWARLXMbGCnUCVpfnC0IPh5VnkKrXWVKKfaOLtzQ7SpBcxURiGfLCYmFcL8b4zCqv/AuF63unnMX5xuktq0uH3qbbMKDGwANR5Y9rd9yMQik0ZujzAljKL1H1DQFQjAgMBAAECggEAHyqtYaaOGLyC2Z+pYLt5ox6b7m1NHvI2jwhOr3X94WZzqRR7oBy5KAS0+iGfn+0jn6LemVZ/kQsgQeLGGN3Obxi8irttnspcW06PNcFqgqgjty7G68GFx+31cE+XlkvLV8oz2T6iIPC+Tf4cevBGXC1X9fjdSstuZToUkffr3JG0eb19DxKm9UYt95Tbr6D/evu3BFVk4mSxPOmlowWfp3eaX1z7DsCsgalv08hnkccssfN/4udR4sRBxVQKOxFpyBpxCqcX8yVBPN62un8H61Hu8CYPoZwn53vDGrXYMWnfdsEF3nA2/cjsfjwc0rmUhVY5ZG9+cYlAWq1BI+SpgQKBgQDLFxfL6YPfSijwKlA81uTV5vpG9rjpIF4fo46MswILrc3m+Wi4pp/iVFxg0/ubeS5CxNm9jexE2bJaf+0KuWu206mm+o6eLhBHDeDv7E7BmWiTHz6BOh6lCPZDJ1oTkiqq5NaGlHuoEAFi0c58WDJ3RyPFuU5+VW2D5BUFdsk7AwKBgQC48DP4ME9ak0AuT2G4iHUEq6ZFgvZnNlcOFVwr0LFvItHS5xaZAjMWTMdf3OAvGanukRIyVxFNYsJXPuTsMMhgGH83cqpzrzrw6ci7WxvApfS6k/1PThrSPi/bXoMHWhvJd/NuAvjSepkNtkhp6GUabgjPME0XzYqLyunNBm2oYQKBgFopU2g0sFXmD4ynzF1mLcuEsqHkkKz2sLKtIvD127ehnqKnIUWwu5R4TVazZaVdRBtiVyRfKIBcgWDKIEs9jENrborx+3TgEFvrHmyFZWVvnMyL92zZh5dPBj1D8Cp2HrklxNOUgd1X1bWwXVI4uZbYn1n9bYqKlIcUL/zwAmBPAoGASIf0aedQh/5uUntRoRTrh/xmBqcZSlt2gxB/iLOdky+9yRBWvYWuUZWlMASpa++NxQHieBnLsGUGQT9qevOa8o1I/48aKKrV2/xkfI578O9lbvNxinPgcwpurIOBshV2Bmrj7wZ9Xdc1Rbpy5g598IKtM80Gv0oehzr6vS1DPqECgYEAtG0eM8kvHFcwzcFXLHgfG8Exn2VLcMtzaEZxoat5ganEnRfn08YsK7K0zdRea2bdMTAy/zhXCATLes0HOMe4v822mFQhxnRAxGyUVfJZlrwcLVizW1jAHdEtlYHK5JZs69gP+hVyF9QI3DGLB4fIfmzK7OBqM15y7oANVqsaa64=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApDB/p0nsbC2rHw25J7BmWXBBp/cOW5iFokENRODqVZWhUwUM7Qmc5xTDvBqIgXicUIV+Bj0WpuimehDuc8hZtbIz9FAxKiLGgRQBBNGJONdqn07Z6Ydf1NkWwWirIS1Tgcov/DQ/Ltr5HSUxGTZHzddPtLdwMGDayGN4orOJgAB8OUSrAq/wdrozgfJS8G8jasiuR5ksgP5ok0oHitZLK/x9+VjaioNXtU+U2KDBe5qtdgZnKHeEWZtFPpESW2+gEPAfP9Y3Drz92+c0/MR25Bb4nhowPdwW3xrA1s+S0bHocXXdVQ5Jf9BVb0DFtb289lmZLWf9WJR0wh3dSPlK6QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://kyd.free.idcfengye.com/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://kyd.free.idcfengye.com/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "https://openapi.alipaydev.com/gateway.do";



//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
