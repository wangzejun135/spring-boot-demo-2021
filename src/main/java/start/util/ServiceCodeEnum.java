package start.util;

/**
 * 服务响应码枚举值
 */
public enum ServiceCodeEnum {

    SUCCESS("0", "请求成功"),
    ERROR("1", "请求失败"),
    PARAMETER_IS_NULL("1001", "参数为空"),
    PARAMETER_INVALID("1002", "参数无效");

    private String code;
    private String message;

    ServiceCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static String getMessageByCode(String code) {
        for (ServiceCodeEnum c : ServiceCodeEnum.values()) {
            if (code.equals(c.getCode())) {
                return c.getMessage();
            }
        }
        return null;
    }

    public static String getCodeByMessage(String message) {
        for (ServiceCodeEnum c : ServiceCodeEnum.values()) {
            if (message.equals(c.getMessage())) {
                return c.getCode();
            }
        }
        return null;
    }
}
