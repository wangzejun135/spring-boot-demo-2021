/*
 * 文 件 名:  TerminalCodes.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  吴飞00106856
 * 修改时间:  2009-3-17
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.example.springbootdemo2021.util;
/**
 * 服务终端码
 * 
 * @author 吴飞00106856
 * @version [1.0, 2009-3-17]
 * @see [相关类/方法]
 * @since [iRead/Server1.0]
 */
public interface TerminalCodes
{
    /** 成功 */
    public static final int SUCCESS = 0;
    
    /** 加密成功 */
    public static final String SIGN_SUCCESS_DESC = "加密成功";
    
    /** 上传字段错误 */
    public static final int UP_FIELD_ERROR = 201;
    
    /** 上传字段错误 */
    public static final String UP_FIELD_ERROR_DESC = "上传字段错误";
    
    /** 加密失败 */
    public static final int SIGN_FAIL = 202;
    
    /** 加密失败 */
    public static final String SIGN_FAIL_DESC = "加密失败";
    
    /** 根据订单号无法查询订单信息 */
    public static final int NOTQUERY_ORDER = 203;
    
    /** 根据订单号无法查询订单信息 */
    public static final String NOTQUERY_ORDER_DESC = "根据订单号无法查询订单信息";
    
    /** 其他错误 */
    public static final int OTHER_ERROR = 3999;
    
    /** 调用组件获取图书信息错误 */
    public static final int GETBOOK_ERROR = 2015;
    
    /** 调用组件获取图书书劵信息为空 */
    public static final int GETBOOKVOLUMES_ERROR = 2445;
    
    /** 调用组件获取图书书劵数量为空 */
    public static final int GETBOOKVOLUMESCOUNT_ERROR = 2446;
    
    /** 其他错误 */
    public static final String OTHER_ERROR_DESC = "其他错误";
    
    /** 非法的用户标识 */
    public static final int INVALID_USERID = 2002;
    
    /** 非法的客户端异常 */
    public static final int INVALID_CLIENTAGENT = 2003;
    
    /** 非法的请求 */
    public static final int INVALID_REQUEST = 2004;
    
    /** 终端访问受限,版本需要强制更新 */
    public static final int TERMINAL_ACCESS_LIMIT = 2005;
    
    /** 查不到相关笔记 */
    public static final int CANNOT_FIND_NOTE = 2133;
    
    /** 禁止游客访问 */
    public static final int GUEST_LOGIN_REFUSE = 9009;
    
    /** 不支持游客 */
    public static final int GUEST_LOGIN_UNSUPPORTED = 4027;
    
    /**
     * 请求结果成功
     */
    public static final int PAGE_REQUEST_SUCCESS = 200;
    
    /**
     * 请求结果成功 描述语
     */
    public static final String PAGE_REQUEST_SUCCESS_DESC = "请求结果成功";
    
    /**
     * 用户鉴权失败
     */
    public static final int AUTHOR_DRM_FAILED = 4001;
    
    /**
     * 三方账号绑定手机号正在更新中
     */
    public static final int BIND_PHONE_STATUS_BINGDING = 4401;
    
    /**
     * 三方账号绑定手机号账号冲突
     */
    public static final int BIND_PHONE_STATUS_CONFLICT = 4402;
    
    /**
     * ABC账号已绑定手机号，只能用手机号登录
     */
    public static final int BIND_PHONE_STATUS_ABC = 4403;
    
    /**
     * 用户注册失败
     */
    public static final int USER_REGSTER_FAILED = 4002;
    
    /**
     * 当用户请求URL地址和用户流量选择计费URL地址不同时，平台返回“4003”错误码，并在响应消息头中通过“Request-URL”字段返回访问地址 ，消息体为空
     */
    public static final int CLIENT_REJECT = 4003;
    
    /**
     * 不支持邮箱账号
     */
    public static final int EMAIL_CANNOT_BE_BOUND = 4018;
    
    /**
     * 不支持用户名账号绑定错误码
     */
    public static final int ACCOUNTNAME_CANNOT_BE_BOUND = 4019;
    
    /**
     * 超过一月内被绑定次数限制
     */
    public static final int BIND_LIMIT_WITH_MONTH = 4020;
    
    /**
     * 超过一年内被绑定次数限制
     */
    public static final int BIND_LIMIT_WITH_YEAR = 4021;
    
    /**
     * 无效的手机号码
     */
    public static final int IVALID_MSISDN = 2010;
    
    /**
     * 节点ID无效
     */
    public static final int IVALID_NODEID = 2012;
    
    /**
     * 无效的内容标识
     */
    public static final int IVALID_CONTENTID = 2013;
    
    /**
     * 部分章节缺失
     */
    public static final int MISS_CHAPTER = 2014;
    
    /** 用户未订购 */
    public static final int USER_NOT_ORDER = 2016;
    
    /** 重复的记录 */
    public static final int MULTIPLE_RECORD = 2017;
    
    /** 重复收藏 */
    public static final int USER_ADDFAVORITE_DUPLICATE = 2019;
    
    /** 收藏超过最大限制 */
    public static final int USER_ASSFAVORITE_MAX = 7018;
    
    /** 重复预订 */
    public static final int USER_RESERVE_DUPLICATE = 2020;
    
    /** 用户未预订 */
    public static final int USER_RESERVE_NOT = 2021;
    
    /** 分册重复订购 */
    public static final int MULTIPLE_SUBSCRIBE_FASCICULE = 2022;
    
    /** 重复订购：尊敬的用户，您已经订购了本包月专区，请勿重复订购 */
    public static final int MULTIPLE_SUBSCRIBE = 2023;
    
    /** 取消包月定购失败 */
    public static final int UNSUBSCRIBE_FAILED = 2024;
    
    /** 订购后取消，当月还生效，用户再进行订购 */
    public static final int MULTIPLE_UNSUBSCRIBE = 2025;
    
    /** 已取消包月但还未生效用户再次取消包月 */
    public static final int MULTIPLE_UNSUBSCRIBE_MSG = 2026;
    
    /** 业务未开通 */
    public static final int SUBSCRIBE_INVALID = 2027;
    
    /** 该产品暂不支持包月订购 */
    public static final int UNSUBSCRIBE_PRODUCT = 2035;
    
    /** 包月订购正在处理中，不能继续订购 */
    public static final int SUBSCRIBE_PROCESSING = 2040;
    
    /** 专区包月正处理中，不允许取消包月 */
    public static final int UNSUBSCRIBE_PROCESSING = 2043;
    
    /** 批量订购的章节数大于本书剩余章节数 */
    public static final int BATCH_SUBSCRIBE_OVER = 2041;
    
    /** 未完成的图书不支持订购所有章节 */
    public static final int BATCH_SUBSCRIBE_REJECT = 2042;
    
    /** 专区包月退订正处理中，不允许再包月 */
    public static final int SUBSCRIBE_FAILED_UNSUBSCRIBE = 2044;
    
    /** 不能订购已下架图书，提示：您查看的图书正在审核中，无法提供阅读，敬请谅解。 */
    public static final int BOOK_IN_AUDITING = 2045;
    
    /** 消费已达到最大上限 */
    public static final int CONSUME_REACH_MAX = 2049;
    
    /** 不支持的微博类型 */
    public static final int WEIBOTYPE_NOT_SUPPORTED = 2050;
    
    /** 已绑定该微博 */
    public static final int WEIBOTYPE_ALREADY_BINDED = 2051;
    
    /**
     * 批价信息为空
     */
    public static final int GETCONTENTPRODUCTINFO_NULL = 2109;
    
    /**
     * 发送mq消息失败
     */
    public static final int SENDMQMESSAGE_FALL = 2115;
    
    /**
     * 长地址模板为空
     */
    public static final int LONGURL_NULL = 2116;
    
    /**
     * 短地址为空
     */
    public static final int SHORTURL_NULL = 2117;
    
    /**
     * 事物id为空
     */
    public static final int TRANSID_NULL = 2118;
    
    /**
     * 获取用户书券信息失败
     */
    public static final int GETUSERTICKETINFO_FALL = 2119;
    
    /**
     * 用户添加笔记失败
     */
    public static final int ADDUSERNOTES_FALL = 2121;
    
    /**
     * 校验弱密码失败
     */
    public static final int CHECKWEAKPWD_FALL = 2122;
    
    /**
     * 用户拓展属性为空
     */
    public static final int GETUSERATTRRESP_NULL = 2123;
    
    /**
     * 获取用户定制标签失败
     */
    public static final int GETUSERLABEL_FALL = 2124;
    
    /**
     * 更新缓存异常
     */
    public static final int UPDATEUSERPREFERENCE_FALL = 2125;
    
    /**
     * 用户偏好为空
     */
    public static final int PREFERENCEKEYS_NULL = 2126;
    
    /**
     * 获取用户升级信息失败
     */
    public static final int GETPLUGINLISTINFO_FALL = 2127;
    
    /**
     * 获取用户信息失败
     */
    public static final int GETUSERINFO_FALL = 2128;
    
    /**
     * 微信支付免密代扣解约失败
     */
    public static final int UNSIGNWECHATENTRUST_FALL = 2129;
    
    /**
     * 微信支付免密代扣解约失败描述
     */
    public static final String UNSIGNWECHATENTRUST_FALL_DESC = "微信支付免密代扣解约失败";
    
    /**
     * 没有删除用户全部(用户或系统)书签
     */
    public static final int DELETEALLBOOKMARK_IS_NOT = 3101;
    
    /**
     * 删除内容全部用户书签失败
     */
    public static final int DELETECONTENTBOOKMARK_FAIL = 3102;
    
    /**
     * 一本书的书签列表信息记录不存在
     */
    public static final int BOOKMARK_FIND_ONEBOOK_BOOKMARK_IS_NOT_FOUND = 3103;
    
    /**
     * 系统书签信息列表记录不存在
     */
    public static final int BOOKMARK_FIND_SYSBOOKMARKLIST_IS_NOT_FOUND = 3104;
    
    /**
     * 用户书签信息列表记录不存在
     */
    public static final int BOOKMARK_FIND_USERBOOKMARKLIST_IS_NOT_FOUND = 3105;
    
    /**
     * 没有删除书签
     */
    public static final int DELETE_IS_NOT = 3106;
    
    /**
     * 无效的URL
     */
    public static final int IVALID_URL = 3107;
    
    /**
     * 没有获取到解析添加系统书签请求信息
     */
    public static final int GETADDSYSTEMBOOKMARKREQ_IS_NOT = 3108;
    
    /**
     * 没有添加系统书签响应信息
     */
    public static final int GETADDSYSTEMBOOKMARKRSP_IS_NOT = 3109;
    
    /**
     * 没有获取到解析添加用户书签请求信息
     */
    public static final int GETADDUSERBOOKMARKREQ_IS_NOT = 3110;
    
    /**
     * 没有获取到添加用户书签响应信息
     */
    public static final int GETADDUSERBOOKMARKRSP_IS_NOT = 3111;
    
    /**
     * 没有获取到单个内容所有用户书签响应信息
     */
    public static final int GETCONTENTBOOKMARKRSP_IS_NOT = 3112;
    
    /**
     * 没有获取到系统书签响应信息
     */
    public static final int GETSYSTEMBOOKMARKRSP_IS_NOT = 3113;
    
    /**
     * 没有获取到用户书签响应信息
     */
    public static final int GETUSERBOOKMARKRSP_IS_NOT = 3114;
    
    /**
     * 没有下载信息响应
     */
    public static final int GETDOWNLOADCONTENTRSP_IS_NOT = 3115;
    
    /**
     * 没有内容下载书项信息
     */
    public static final int GETDOWNLOADCONTENTBOOKITEM_FAIL = 3116;
    
    /**
     * 没有获取到解析内容搜索请求信息
     */
    public static final int GETSEARCHCONTENTREQ_IS_NOT = 3117;
    
    /**
     * 没有获取到内容搜索响应信息
     */
    public static final int GETSEARCHCONTENTRSP_IS_NOT = 3118;
    
    /**
     * 没有获取会员资费信息响应信息
     */
    public static final int GETMEMBERPRODUCTINFORSP_IS_NOT = 3119;
    
    /**
     * 没有获取指定的排行榜响应信息
     */
    public static final int GETSPECIFIEDRANKRSP_IS_NOT = 3120;
    
    /**
     * 没有获取专区排行首页信息响应信息
     */
    public static final int GetCatalogRankRsp_IS_NOT = 3121;
    
    /**
     * 系统书签没有添加成功
     */
    public static final int ADDSYSTEMBOOKMARK_IS_FAIL = 3122;
    
    /**
     * 用户书签没有添加成功
     */
    public static final int ADDUSERBOOKMARK_IS_FAIL = 3123;
    
    /**
     * 同一位置已经有了用户书签
     */
    public static final int BOOKMARK_HAVE_EXIST_IN_SAME_POSITION = 3124;
    
    /**
     * 用户书签中书的数量达到最大值
     */
    public static final int BOOKMARK_BOOK_COUNT_IS_MAX = 3125;
    
    /**
     * 添加书签的书的是不存在的
     */
    public static final int BOOK_IS_EXIST = 3126;
    
    /**
     * 书下载失败
     */
    public static final int DOWNLOAD_IS_FAIL = 3127;
    
    /**
     * 此专区已经达到当月最大下载次数，或者从server获取已下载次数失败
     */
    public static final int DOWNLOADCOUNT_UP2_MAX = 3128;
    
    /**
     * ttsCatalogType为空
     */
    public static final int TTSCATALOG_TYPE_IS_NULL = 3129;
    
    /**
     * ttsCatalogType不在配置的枚举值范围内
     */
    public static final int TTSCATALOG_TYPE_NON_EXISTENT = 3130;
    
    /**
     * 无效的请求
     */
    public static final int INVALI_URL_REQUEST = 60003;
    
    /**
     * 会员资费信息不存在
     */
    public static final int ASSOCIATORFEEINFO_IS_NULL = 4000;
    
    /**
     * 章节信息不存在
     */
    public static final int CHAPTERITEM_IS_NULL = 4004;
    
    /**
     * 书项标识符无效
     */
    public static final int INVAL_BOOKID = 2013;
    
    /**
     * 系列标示符无效
     */
    public static final int INVAL_SERIALID = 2100;
    
    /**
     * 搜索的内容不存在
     */
    public static final int SEARCHCONTENT_IS_NULL = 4008;
    
    /**
     * 分页开始位置比分页的总数大
     */
    public static final int TOTALPAGECOUNT_MIX = 4008;
    
    /**
     * 出生日期非法,修改失败
     */
    public static final int MODIFY_USERINFO_BIRTHDAY_ILLEGAL = 4182;
    
    /**
     * 无客户端升级信息
     */
    public static final int NO_CLIENT_INFO = 7000;
    
    /**
     * 无用户标识
     */
    public static final int NO_USERID = 7001;
    
    /**
     * 无收藏信息
     */
    public static final int NO_FAVORITE_INFO = 7002;
    
    /**
     * 收藏信息被删除
     */
    public static final int FAVORITEINFO_DELETED = 7003;
    
    /**
     * 添加收藏失败
     */
    public static final int ADD_FAVORITE_FAIL = 7004;
    
    /**
     * 禁止http访问
     */
    public static final int FORBIDDEN_HTTP_REQUEST = 2403;
    
    /**
     * 用户删除全部收藏失败
     */
    public static final int DELETE_ALL_FAVORITE_FAIL = 7005;
    
    /**
     * 删除某一本书收藏失败
     */
    public static final int DELETE_ONE_FAVORITE_FAIL = 7006;
    
    /**
     * 鉴权不成功
     */
    public static final int AUTHENTICATE_FAIL = 7007;
    
    /**
     * 客户端升级失败
     */
    public static final int CLIENT_UPDATE_FAIL = 7008;
    
    /**
     * 客户端注册失败
     */
    public static final int CLIENT_REGISTER_FAIL = 7009;
    
    /**
     * 预定内容失败
     */
    public static final int BOOK_UPDAATE_FAIL = 7010;
    
    /**
     * 取消预定内容失败
     */
    public static final int UNBOOK_UPDATE_FAIL = 7011;
    
    /**
     * 预定图书已完结
     */
    public static final int UNBOOK_IS_FINISH = 7024;
    
    /**
     * 获取预定更新图书列表，start为非整数
     */
    public static final int START_NOT_INT = 7025;
    
    /**
     * 获取预定更新图书列表，count为非整数
     */
    public static final int COUNT_NOT_INT = 7026;
    
    /**
     * 获取预定更新图书列表,contentType输入错误，格式：1;2;3
     */
    public static final int CONTENTTYPE_ERROR = 7027;
    
    /**
     * 得到用户信息失败
     */
    public static final int GET_USERINFO_FAIL = 7012;
    
    /**
     * 修改用户信息失败
     */
    public static final int MODIFY_USERINFO_FAIL = 7013;
    
    /**
     * 无用户信息
     */
    public static final int NO_USERINFO = 7014;
    
    /**
     * 修改用户昵称重复
     */
    public static final int MODIFY_USERINFO_NICKNAME_ALEADY_EXIST = 7015;

    /**
     * 昵称已被咪咕文学网作家使用
     */
    int NICKNAME_IS_USED_BY_MIGU_AUTHOR = 7044;

    /**
     * 用户昵称不符合规范
     */
    public static final int MODIFY_USERINFO_NICKNAME_ILLEGAL = 4101;
     
    /**
     * 用户昵称过长，不符合规范
     */
    public static final int MODIFY_USERINFO_NICKNAME_TOOLONG = 4114;  
    
    /**
     * 用户昵称过短，不符合规范
     */
    public static final int MODIFY_USERINFO_NICKNAME_TOOSHORT = 4115;
    /**
     * 用户昵称为空
     */
    public static final int MODIFY_USERINFO_NICKNAME_EMPTY = 4116;
    
    /**
     * 用户昵称包含敏感词汇
     */
    public static final int MODIFY_USERINFO_NICKNAME_CONTAIN_SENCONTENT = 7028;
    
    /**
     * 用户昵称修改次数超限
     */
    public static final int MODIFY_USERINFO_NICKNAME_UPDATE_LIMIT = 7029;
    
    /**
     * 密保失败次数超过上限
     */
    public static final int REACH_MAX_ANSWER_FAILED_TIMES = 7117;
    
    /**
     * 密保校验失败
     */
    public static final int CHECK_ANSWER_FAILED = 7116;
    
    /**
     * 密码长度不合法
     */
    public static final int CHECK_PASSWORD_FAILED = 7118;
    
    /** 用户名不合法 */
    public static final int VERIFY_USERNAME_FAIL = 7119;
    
    /** 密保问题不合法 */
    public static final int VERIFY_SECURITY_QUESTION_FAIL = 7120;
    
    /** 密保答案不合法 */
    public static final int VERIFY_SECURITY_ANSWER_FAIL = 7121;
    
    /** 用户没设置密保问题 */
    public static final int SECURITY_QUESTION_NO_EXIST = 7155;
    
    /**
     * 无效的参数
     */
    public static final int INVALIED_PARAM = 2006;
    
    /**
     * 未绑定支付号码
     */
    public static final int SUBSCRIBEPHONE_IS_NULL = 9301;
    
    /**
     * 支付方式不支持
     */
    public static final int SUPPORTPAYTYPE_NOT_SUPPORT = 9302;
    
    /**
     * 传参为空
     */
    public static final int PARAM_IS_NULL = 4112;
    
    /**
     * 放通错误
     */
    public static final int PASS_FREEREAD_ERROR = 4901;
    
    /**
     * 账号对应身份下有阅读记录
     */
    public static final int RECORDED_IN_RECENT = 4022;
    
    /**
     * IMEI+IMSI或IDFA为空
     */
    public static final int IMEI_IMSI_IDFA_ISNULL = 4023;
    
    /**
     * 资源异常,漫画版本限制为4。限ios
     */
    public static final int RESOURCE_ERROR = 4029;
    
    /**
     * 当前账号已绑定手机号，无法再次绑定手机
     */
    public static final int ACCOUNT_HAD_BIND_MOBILE = 4110;
    
    /**
     * 验证业务代码非法
     */
    public static final int ILLEGAL_BUSINESS = 4005;
    
    /**
     * 客户端已是最新版本
     */
    public static final int CLIENT_IS_NEWVERSION = 7016;
    
    /**
     * 无效的终端类型
     */
    public static final int INVALID_CLIENT_AGENT = 7017;
    
    /** 用户重复投票 */
    
    public static final int USER_HAVE_ALREADY_VOTE = 2028;
    
    /**
     * 用户当日推荐次数已达到上限
     */
    public static final int REACH_MAX_RECOMMENDED_TIMES = 2029;
    
    /**
     * 用户已是会员
     */
    public static final int IS_MEMBER_ALREADY = 2030;
    
    /**
     * 用户不是会员
     */
    public static final int IS_NOT_MEMBER_YET = 2031;
    
    /**
     * 用户已经退出会员
     */
    public static final int IS_NOT_MEMBER_ALREADY = 2032;
    
    /** 该促销产品不属于用户所在地域 */
    public static final int PRODUCT_NOTIN_USERAREA = 2033;
    
    /**
     * 用户推荐同一本书给同一好友达到一天的最大次数
     */
    public static final int REACH_MAX_RECOMMENDED_TIMES_SAME_PERSON = 2034;
    
    /**
     * 订购促销包时，无法获取该促销包的产品信息
     */
    public static final int NO_PROMOTE_PRODUCTINFO = 2036;
    
    /**
     * 没有要删除的站内消息ID
     */
    public static final int DELETE_MESSAGE_PARAMETER_MISSING = 8000;
    
    /**
     * 没有要上传的阅读记录
     */
    public static final int UPLOAD_READRECORD_PARAMETER_MISSING = 8002;
    
    /** 系统暂不支持此功能 */
    public static final int SYSTEM_NOT_SUPPORT = 3010;
    
    /** 用户反馈不成功* */
    public static final int ADD_FEEDBACK_FAIL = 3011;
    
    /**
     * 预定超过最大次数
     */
    public static final int BOOK_UPDAATE_GREATE_MAX = 7019;
    
    /**
     * 推荐好友业务超过当天最大发送次数
     */
    public static final int RECOMMENDED_GREATE_MAX = 7020;
    
    /**
     * 推荐好友业务失败
     */
    public static final int RECOMMENDED_FAILD = 7021;
    
    /**
     * 推荐好友业务对同一用户达到最大次数
     */
    public static final int RECOMMENDED_GREATE_ONE_USER_FAILD = 7022;
    
    /**
     * 非wap网关IP接入
     */
    public static final int IS_NOT_FROM_WAP = 6000;
    
    /** 不能对自己的评论进行顶或驳 */
    public static final int SUBMIT_COMMENT_VOTE_INVALID = 6100;
    
    /** 用户对同一个评论的顶和驳超过上限 */
    public static final int SUBMIT_COMMENT_VOTE_LIMIT = 6101;
    
    /** 用户顶或驳失败 */
    public static final int SUBMIT_COMMENT_VOTE_FAILED = 6102;
    
    /** 用户顶/驳成功，但是查询失败 */
    public static final int SUBMIT_COMMENT_VOTE_SUCCESS = 6103;
    
    /** 用户提交评论内容为空 */
    public static final int SUBMIT_COMMENT_CONTENT_ISNULL = 6104;
    
    /** 作家回复评论失败 */
    public static final int AUTHER_SUBMIT_COMMENT_FAILED = 6105;
    
    /** 当月包月栏目已经超过下载限制 */
    public static final int DOWNLOAD_CONTENT_MAX = 6201;
    
    /** 用户下载按章计费或按字计费图书是未订购所有章节 */
    public static final int DOWNLOAD_CONTENT_FORBID = 6202;
    
    /** 阅读消息失败 */
    public static final int READ_MESSAGE_FAILED = 6301;
    
    /** 获取消费记录失败 */
    public static final int GETCONSUME_HISTORYLIST_FAIL = 6403;
    
    /** 删除消息失败 */
    public static final int DELETE_ALLMESSAGE_FAIL = 6404;
    
    /** 终端解绑失败 */
    public static final int TERMINAL_UNBIND_IS_FAIL = 6405;
    
    /** 终端解绑处理中 */
    public static final int TERMINAL_UNBIND_IN_DEAL = 6406;
    
    /** 该手机号不在绑定状态 */
    public static final int TERMINAL_NUM_IS_NOT_BIND_STATUS = 6407;
    
    /** 密码错误连续3次，还有2次机会 */
    public static final int PASSWORD_LOGIN_FAIL3 = 6408;
    
    /** 密码错误连续4次，还有1次机会 */
    public static final int PASSWORD_LOGIN_FAIL4 = 6409;
    
    /** 连续错误5次，账号将锁定 */
    public static final int PASSWORD_LOGIN_FAIL5 = 6410;
    
    /** 您已经购买了促销包内的所有图书，无须订购。 */
    public static final int TERMINAL_SUBSCRIBE_CATLOG_ALL = 2046;
    
    /** 订购成功,获取章节信息失败。 */
    public static final int SUBSCRIBE_SUCCESS_UNCHAPTER = 2047;
    
    /** 已经到投票的最大数 */
    public static final int SUBMITVOTE_IS_MAX = 2048;
    
    /** 设置预订更新提醒方式失败 */
    public static final int SET_SERIALUPDATETYPE_FAIL = 7023;
    
    /** 获取区块失败 */
    public static final int GET_BLOCK_FAIL = 7035;
    
    /** 排行榜区块不存在 */
    public static final int BLOCK_RANK_IS_NULL = 7036;
    
    /** 获取登录页面图片url&id失败 */
    public static final int GET_IMAGE_FAIL = 7037;
    
    /** 赠送失败 */
    public static final int BOOK_NOCHARGER_FAIL = 7034;
    
    /**
     * 推荐对象的手机号码非移动号码
     */
    public static final int RECOMMENDED_MOBILE_IS_FALL = 7033;
    
    /**
     * 推荐对象的手机号码格式错误
     */
    public static final int RECOMMENDED_MOBILE_IS_ERROR = 7032;
    
    /** 皮肤列表为空 */
    public static final int GET_SKINLIST_ISNULL = 7038;
    
    /** 客户版本号为空 */
    public static final int CLIENT_VERSION_ISNULL = 7039;
    
    /** 调用包月访问接口失败 */
    public static final int QUERY_MONTH_CATALOG_FAIL = 7054;
    
    /** 调用专区下免费章节话单失败 */
    public static final int GETCHAPTER_CATALOG_FAIL = 7041;
    
    /** 记录下载反馈话单失败 */
    public static final int RECORD_DOWNLANDCONTENTACK__FAIL = 7042;
    
    /** 该促销包不支持门户订购 */
    public static final int SALESPACKAGE_NOT_SUPPORT = 7043;
    
    /** 赠送对象的手机号码非移动号码 */
    public static final int PRESENDED_MOBILE_IS_FALL = 7031;
    
    /** 客户端升级 */
    public static final int CLIENT_UPDATE_CODE = 7070;
    
    /** 用户请求与登录信息一致性校验失败 */
    public static final int CHECK_REQUEST_USERLOGIN = 7071;
    
    /** 用户已注册 */
    public static final int USER_IS_REGISTERED = 7072;
    
    /** 用户未注册 */
    public static final int USER_NO_REGISTER = 7073;
    
    /** 用户已锁定 */
    public static final int USER_IS_LOCKED = 7075;
    
    /** 用户名+密码登录时鉴权失败提示码 */
    public static final int USER_LOGIN_FAIL = 7076;
    
    /** 无MD5(IMSI)、TOKEN 、RANDOM、MSISDN映射关系 */
    public static final int NO_MD5_MAPPING = 9001;
    
    /** 请求的Token摘要与平台的比对不一致 */
    public static final int REQUESTTOKEN_NO_INCONSISTENT = 9002;
    
    /** 中奖信息列表为空 */
    public static final int PRIZEINFO_IS_NULL = 9005;
    
    /** 用户原密码不正确 */
    public static final int OLDPASSWORD_ISNOT_CORRECT = 7074;
    
    /** Token已过期 */
    public static final int TOKE_HAS_EXPIRED = 9003;
    
    /** 无效counter */
    public static final int INVALLID_COUNTER = 9004;
    
    /** 请求超时 */
    public static final int REQUEST_TIMEOUT = 3001;
    
    /** ABC账户未升级,无法使用 */
    public static final int NON_MOBILA_NON_EMAIL_ABC_NOT_UPGRADED = 7084;
    
    /** 用户号码处于暂停状态，消费受限时返回，对应server响应码BOSS_STATUS_SYN_FAIL_PAUSE */
    public static final int BOSS_STATUS_PAUSE = 7087;
    
    /** 用户号码已经销户，消费受限时返回，对应server响应码BOSS_STATUS_SYN_FAIL_UNSUB */
    public static final int BOSS_STATUS_UNSUB = 7088;
    
    /** 用户状态正在同步中，消费受限时返回，对应server响应码BOSS_STATUS_SYN_FAIL_SYNING */
    public static final int BOSS_STATUS_SYNING = 7089;
    
    /** 用户状态同步失败，消费受限时返回，对应server响应码BOSS_STATUS_SYN_FAIL_SYNFAIL */
    public static final int BOSS_STATUS_SYNFAIL = 7090;
    
    /** 重置密码超过次数限制 */
    public static final int TOOMUCH_RESETPASSWORD = 7091;
    
    /** 注册超过次数限制 */
    public static final int TOOMUCH_REGISTER = 7092;
    
    /** 平台包月产品已经过期 */
    public static final int MONTHLY_EXPIRATION = 7093;
    
    /** 用户今天已经报到 */
    public static final int USER_SIGNED_TODAY = 7094;
    
    /** 促销包产品过期响应码 */
    public static final int INVALID_PROMOTIONACTIVITY = 2037;
    
    /**
     * 非移动手机号码
     */
    public static final int MSISDN_IS_NOT_BELONG_CMCC = 3232;
    
    /**
     * 手机号码错误
     */
    public static final int MSISDN_IS_ERROR = 4104;
    
    /**
     * 手机号码为空
     */
    public static final int MSISDN_IS_NONE = 4105;
    
    /**
     * 手机号码为空
     */
    public static final int USERNAME_IS_EXIST = 4113;
    
    /**
     * 绑定失败
     */
    public static final int BIND_MOBILE_FIAL = 4106;
    
    /**
     * 号码已经注册
     */
    public static final int NUMBER_ALREADY_REGISTERED = 4107;
    
    /**
     * 绑定错误
     */
    public static final int SYSTEM_ERROR_BIND = 4108;
    
    /**
     * 参数为空
     */
    public static final int PARAMETER_IS_NULL = 4109;
    
    /** 微博未绑定 */
    public static final int WEIBO_NOT_BINDED = 9006;
    
    /** 解绑定新浪微博失败 */
    public static final int WEIBO_UNBIND_FAILED = 9007;
    
    /** 新浪微博token失效 */
    public static final int WEIBO_TOKEN_DEAD = 26957;
    
    /** 分享内容为空 */
    public static final int WEIBO_SHARECONTENT_NULL = 9008;
    
    /** 该用户已经对这本书打过分，无法再次打分 */
    public static final int USER_ALREADY_ADD_BOOK_SCORE = 7101;
    
    /** 用户等级不够，无法打分 */
    public static final int USER_LEVEL_NOT_ENOUGH = 7102;
    
    /** 用户笔记数量已经达到上限 */
    public static final int USERNOTE_AMOUNT_LIMIT_IS_REACHED = 7103;
    
    /** 读书笔记内容过长,无法保存 */
    public static final int NOTELENGTH_IS_TOO_LONG = 7104;
    
    /** 该图书笔记不存在,无法保存 */
    public static final int NOTES_DOES_NOT_EXIST = 7105;
    
    /** 批量赠送用户数量超过上限 */
    public static final int RECEIVE_MOBILE_OUTOF_LIMIT = 7106;
    
    /** 书券充值失败 */
    public static final int TICKET_PAYMENT_FAILED = 2052;
    
    /** 书券余额不足 */
    public static final int TICKET_NO_ENOUGH = 2053;
    
    /** 重复调用书券 */
    public static final int TICKET_CONFIRM_PAYMENT_REPEAT = 2054;
    
    /** 订购批价档位折扣非法 */
    public static final int ORDER_LEVEL_INVALID = 2056;
    
    /**
     * 用户月票为空
     */
    public static final int NO_MONTHLY_TICKET = 7107;
    
    /**
     * 购买并投月票时，月票码不符
     */
    public static final int MONTHLY_TICKET_VERIFYCODE_ERROR = 7108;
    
    /**
     * 测试用户不允许投月票
     */
    public static final int TEST_MONTHLY_TICKET_FORBIDEN = 2055;
    
    /**
     * 连载未完本内容鉴权，章节ID列表为空
     */
    public static final int CHAPTER_ID_LIST_IS_NULL = 2057;
    
    /**
     * 用户当天投月票达到上限
     */
    public static final int OVER_MONTHLY_TICKET_MAX = 7111;
    
    /**
     * 兑换积分达到每次兑换上限
     */
    public static final int OVER_EXCHANGE_MAX_VALUE = 7112;
    
    /**
     * 积分不足，无法兑换
     */
    public static final int CONSUMER_SCORE_NO_ENOUGH = 7109;
    
    /**
     * 验证码错误
     */
    public static final int VERIFY_CODE_ERROR = 7110;
    
    /**
     * 白名单用户无免费的月票
     */
    public static final int WHITE_USER_MONTHLY_TICKET_FORBIDEN = 7113;
    
    /**
     * 非移动用户月票不足
     */
    public static final int NO_CMCC_MONTHLY_TICKET_NOT_ENOUGH = 7114;
    
    /** BS客户端方案中，客户端通过getChapterInfo2接口获取听书章节内容，门户会返回8001（表示此内容为听书） */
    public static final int VOICE_BOOK_TYPE_PROMPT = 8001;
    
    /**
     * 门户类型 手机终端门户
     */
    public static final String PORTAL_TYPE = "4";
    
    /**
     * 微博类型 新浪微博
     */
    public static final String SINA_WEIBO = "2";
    
    /**
     * 手机阅读首页
     */
    public static final String INDEX_PAGE = "http://wap.cmread.com";
    
    /**
     * 亲情网其他用户订购鉴权状态码
     */
    public static final String KINSHIP_SUB = "18";
    
    /**
     * 绑定失败
     */
    public static final int BIND_FAILE = 7122;
    
    /**
     * 关联手机号码失败
     */
    public static final int TOURIST_BIND_FAILE = 4111;
    
    /**
     * 解绑失败
     */
    public static final int UNBIND_FAILE = 7123;
    
    /**
     * 用户获取验证码次数达到一定时间内可以获取的最大值
     */
    public static final int GET_VERIFYCODE_IS_OVER_LIMIT_IN_TIME = 7124;
    
    /**
     * 用户未适配到包月支付方式
     */
    public static final int NONE_PAYMENT = 7086;
    
    /**
     * 移动号码不支持绑定支付手机号
     */
    public static final int CMCC_CAN_NOT_BIND_CMCC = 7125;
    
    /**
     * 用户未绑定代付费号码，进行解绑操作时返回此响应码
     */
    public static final int USER_HAD_NOT_BIND_TELENUMBER = 7126;
    
    /**
     * 包月确认失败
     */
    public static final int CONFIRM_APPSTORE_SUBSCRIBE_FAILURE = 7085;
    
    /**
     * 保存Token失败
     */
    public static final int SAVE_AOT_TOKEN_FAILURE = 7127;
    
    /**
     * 仅查询用户的内置用户组信息标识
     */
    public static final String QURY_BUILDGROUNP_FLAG = "1";
    
    /**
     * 包月有效状态
     */
    public static final String MONTH_PAY_YES = "1";
    
    /**
     * STOKEN_TPTOKEN不能全为空
     */
    String STOKEN_TPTOKEN_BOTH_EMPTY = "9010";
    
    /**
     * tpauthToken鉴权失败
     */
    String TPAUTOKEN_AUTH_FAIL = "9011";
    
    /**
     * 云书架备份功能暂时被关闭
     */
    public static final int USER_CLOUD_SHELF_BAK_CLOSED = 3233;
    
    /**
     * 云书架同步功能暂时被关闭
     */
    public static final int USER_CLOUD_SHELF_SYNC_CLOSED = 3234;
    
    /**
     * 用户余额不足
     */
    public static final int USER_BALANCE_NOT_ENOUGH = 25939;
    
    /**
     * 达到绑定支付号码限制数
     */
    public static final int UP_BINDING_NUMBER_LIMIT = 8002;
    
    /**
     * 手机号列表非法
     */
    public static final int INVALID_MSISDNLIST = 3235;
    
    /**
     * mm客户端用户登录功能暂时被关闭
     */
    public static final int MM_AUTH_SWITCH_OFF = 3236;
    
    /**
     * 手机号为空
     */
    public static final int MSISDN_IS_NULL = 2010;
    
    /**
     * 手机号为非移号码
     */
    public static final int MSISDN_IS_NOT_CMCC = 3232;
    
    /**
     * 获取mmtoken失败
     */
    public static final int MMTOKENR_IS_NULL = 2006;
    
    /**
     * iserver非移动号码
     */
    public static final String MSISDN_IS_NOT_CMCC_SERVER = "500000";
    
    /**
     * iserver获取mmtoken失败
     */
    public static final String MMTOKENR_IS_NULL_SERVER = "26926";
    
    /**
     * 下发验证码失败
     */
    public static final int GET_VERIFY_CODE_FAIL = 7188;
    
    /**
     * 和阅读业务暂停
     */
    public static final int READ_SERVICE_PAUSE = 7187;
    
    /**
     * migu注册失败
     */
    public static final int MIGU_REGISTER_ERROR = 4009;
    
    /**
     * migu不支持邮箱注册错误
     */
    public static final int MIGU_EMAIL_REGISTER_ERROR = 4017;
    
    /**
     * 密码强度校验不通过
     */
    public static final int MIGU_PASSWORD_TOO_WEEK = 4008;
    
    /**
     * 统一账号会话ID为空
     */
    public static final int USESSIONID_IS_NULL = 4011;
    
    /**
     * 统一账号标识ID为空
     */
    public static final int PASSID_IS_NULL = 4012;
    
    /**
     * 验证码类型错误
     */
    public static final int MIGU_VALID_TYPE_ERROR = 4016;
    
    /**
     * sessionid为空
     */
    public static final int MIGU_SESSIONID_EMPTY = 4010;
    
    /**
     * 咪咕鉴权失败
     */
    public static final int MIGU_AUTHENTICATE_ERROR = 4013;
    
    /**
     * 验证码为空
     */
    public static final int MIGU_VALID_EMPTY = 4015;
    
    /**
     * 业务账号升级失败
     */
    public static final int MIGU_UPGRADE_ERROR = 4014;
    
    /**
     * 用户中心故障放通状态码
     */
    public static final int PASS_CPORTAL_GUEST_FREEREAD_CODE = 7099;
    
    /******* 第三方注册相关 ***********/
    /**
     * weiboUserId长度超过128
     */
    public static final int WEIBO_USERID_LENGTH_OVERLIMIT = 8010;
    
    /**
     * weiboToken长度超过128
     */
    public static final int WEIBO_TOKEN_LENGTH_OVERLIMIT = 8011;
    
    /**
     * 微博类型为空
     */
    public static final int WEIBO_TYPE_IS_NULL = 8012;
    
    /**
     * oauthToken长度超过128
     */
    public static final int WEIBO_OAUTHTOKEN_LENGTH_OVERLIMIT = 8013;
    
    /**
     * 添加微博token失败
     */
    public static final int ADD_WEIBO_TOKEN_FAILED = 8014;
    
    /**
     * oauthTokenSecret长度超过128
     */
    public static final int WEIBO_OAUTHTOKENSECRET_LENGTH_OVERLIMIT = 8015;
    
    /**
     * refresh Token长度超过128
     */
    public static final int WEIBO_REFRESHTOKEN_LENGTH_OVERLIMIT = 8016;
    
    /**
     * weiboUserId 为空
     */
    public static final int WEIBOUSERID_IS_EMPTY = 8017;
    
    /**
     * Token过期时间为空
     */
    public static final int WEIBO_TOKEN_EXPIRETIME_IS_NULL = 8018;
    
    /**
     * Token过期时间类型错误
     */
    public static final int WEIBO_TOKEN_EXPIRETIME_IS_INVALID = 8019;
    
    /**
     * 非移动号码不允许注册
     */
    public static final int NONE_CMCC_USER_CAN_NOT_REGISTER = 8020;
    
    /**
     * 用户名和手机号码不能同时为空
     */
    public static final int REGISTER_NANE_MOBILE_BOTH_EMPTY = 8021;
    
    /**
     * 非号码注册时，用户名不能全为数字
     */
    public static final int REGISTER_USER_NAME_ALL_DIGISTS = 8022;
    
    /**
     * 注册用户名重复
     */
    public static final int REGISTER_USER_NAME_EXIST = 8023;
    
    /**
     * 第三方账户类型为空
     */
    public static final int THIRD_PARTY_TYPE_VALUE_NULL = 8024;
    
    /**
     * token有效时间失效,需重新绑定（仅对淘宝、网易账号）
     */
    public static final int TOKEN_VALID_FALURE = 8025;
    
    /**
     * 已绑定且绑定有效时间有效，无须重新绑定（仅对淘宝、网易账号）
     */
    public static final int TOKEN_IS_VALID = 8026;
    
    /**
     * weiXinUnionid(微信统一账号ID)为空
     */
    public static final int WEIXINUNIONID_IS_NULL = 8027;
    
    /**
     * 用户会员权益不足
     */
    public static final int EQUITY_NOT_ENOUGH = 8100;
    
    /**
     * 第三方url图片上传失败
     */
    public static final int THIRD_IMAGE_UPLOAD_FAIL = 4161;
    
    /******* 第三方注册相关 ***********/
    
    /**
     * 内容鉴权：失败
     */
    public static final int CONTENT_AUTHENTICATE_FAIL = 24500;
    
    /**
     * 重复订购
     */
    public static final int REPEAT_ORDER = 24900;
    
    /**
     * 支付宝支付：没有签约
     */
    public static final int ALIPAY_PAY_FAIL_NO_SIGN = 20;
    
    /**
     * 支付宝支付：没有签约:Cportal经过转换返回给Client错误码
     */
    public static final int ALIPAY_PAY_FAIL_NO_SIGN_TRANSFORMATION = 9102;
    
    /**
     * 支付宝支付：签约失效
     */
    public static final int ALIPAY_PAY_FAIL_INVALID_SIGN = 21;
    
    /**
     * 支付宝支付：签约失效:Cportal经过转换返回给Client错误码
     */
    public static final int ALIPAY_PAY_FAIL_INVALID_SIGN_TRANSFORMATION = 9103;
    
    /**
     * 查询签约失败
     */
    public static final int ALIPAY_QUERY_SIGN_FAIL = 9104;
    
    /**
     * 咪咕一级支付支付宝未签约9105 未签约:Cportal经过转换返回给Client错误码
     */
    public static final int MIGU_GROUP_ALIPAY_NOT_SIGN = 9105;
    
    /**
     * 咪咕一级支付支付宝签约失效9106 签约失效:Cportal经过转换返回给Client错误码
     */
    public static final int MIGU_GROUP_ALIPAY_SIGN_INVALID = 9106;
    
    /**
     * 咪咕一级支付支付宝统一下单接口失败 统一下单失败 调用咪咕一级支付失败
     */
    public static final int MIGU_GROUP_ALIPAY_SIGN_ORDER_FAIL = 9107;
    
    /**
     * 支付宝支付：订购失败::Cportal经过转换返回给Client错误码
     */
    public static final int ALIPAY_PAY_FAIL_ORDER_TRANSFORMATION = 9110;
    
    /**
     * 一级黑名单
     */
    public static final int BLACKLIST_GRADE_ONE = 9112;
    
    /**
     * 二级黑名单
     */
    public static final int BLACKLIST_GRADE_TWO = 9113;
    
    /**
     * 微信微支付未签约
     */
    public static final int WECHAT_NO_SIGN = 4180;
    
    /**
     * 微信微支付签约失效
     */
    public static final int WECHAT_SIGN_INVALID = 4181;
    
    /**
     * 微信一级黑名单
     */
    public static final int WECHAT_BLACKLIST_GRADE_ONE = 9120;
    
    /**
     * 微信二级黑名单
     */
    public static final int WECHAT_BLACKLIST_GRADE_TWO = 9121;
    
    /**
     * 正在扣费
     */
    public static final int BEING_DEDUCTED = 9114;
    
    /**
     * 订单号失效
     */
    public static final int ORDER_NUM_INVALID = 2108;
    
    /**
     * 修改密码失败
     */
    public static final String MODIFY_PASSWORD_FAILE = "4026";
    
    /**
     * 阳光计划二期 订购成功 code 9229
     */
    public static final int SUN_SDK_SUCCESS = 9229;
    
    /**
     * 一级支付系统，一级咪咕币系统订购成功code
     */
    public static final int PAY_MIGU_CURRENCY_SUCCESS = 9230;
    
    /**
     * 一级支付支付宝系统，支付宝订购成功需要轮询订单状态 9231
     */
    public static final int MIGU_GROUP_ALIPAY_ORDER_SUCCESS = 9231;
    
    /**
     * 需要调起咪咕一级收银台支付9232
     */
    public static final int MIGU_CHECKSTAND_PAY = 9232;
    
    /**
     * 用户账号等级为二级账户
     */
    public static String USER_SECOND = "2";
    
    /**
     * 该手机号码已经注册
     */
    public static int PNONENUMBER_IS_BEUSED = 22302;
    
    /**
     * 关联手机号码失败
     */
    public static int ASSOCIATE_IS_FAILED = 22303;
    
    /**
     * 系统异常
     */
    public static int SYSTEM_ERROR = 22304;
    
    /**
     * ios设备号不能绑定手机号码
     */
    public static int IOS_DEVICE_ERROR = 4102;
    
    /**
     * 请求up接口获取参数失败
     */
    public static int UP_REQUEST_ERROR = 4120;
    
    /**
     * 咪咕账号不能关联
     */
    public static int MIGU_REQUEST_ERROR = 4121;
    
    /**
     * 非手机用户不能注册
     */
    public static int ONLY_USER_MOBIL = 4006;
    
    /**
     * 设备编号签名为空
     */
    public static int SDEVICEID_IS_NULL = 4130;
    
    /**
     * 该设备已登录
     */
    public static int SDEVICE_LOGONED = 4162;
    
    /**
     * 随机数为空
     */
    public static int RAND_IS_NULL = 4131;
    
    /**
     * 随机数不正确
     */
    public static int RAND_ERROR = 4163;
    
    /**
     * 随机数过期
     */
    public static int RAND_EXPIRED = 4164;
    
    /**
     * 账号名称为空
     */
    public static int ACCOUNTNAME_IS_NULL = 4132;
    
    /**
     * 账号类型为空
     */
    public static int ACCOUNTTYPE_IS_NULL = 4133;
    
    /**
     * 令牌类型为空
     */
    public static int TOKENTYPE_IS_NULL = 4134;
    
    /**
     * 令牌不存在
     */
    public static int TOKEN_NOT_FIND = 4135;
    
    /**
     * 令牌超时
     */
    public static int TOKEN_OVERTIME = 4136;
    
    /**
     * 随机码无效
     */
    public static int RAND_IS_ERROR = 4137;
    
    /**
     * 令牌类型不匹配
     */
    public static int TOKENTYPE_IS_ERROR = 4138;
    
    /**
     * 客户端内置密码未找到
     */
    public static int NOT_FIND_PASSWORD = 4139;
    
    /**
     * token不匹配
     */
    public static int TOKEN_MISMATCHING = 4140;
    
    /**
     * 创建token时第二个用户扫描二维码返回错误
     */
    public static int SR_IS_EXIST = 4141;
    
    /**
     * stoken为空
     */
    public static int STOKEN_NULL = 4142;
    
    /**
     * counter为空
     */
    public static int COUNTER_NULL = 4143;
    
    /**
     * 客户端版本为空
     */
    public static int CLIENTVERSION_NULL = 4144;
    
    /**
     * portalType为空
     */
    public static int PORTALTYPE_NULL = 4145;
    
    /**
     * 上传文件服务器失败 返回错误码
     */
    public static int UPLOAD_FAIL = 4150;
    
    /**
     * 调iserver上传图片信息失败 错误码
     */
    public static int UPLOAD_USER_DEDINED_HEAD_FAIL = 4151;
    
    /**
     * 上传的图片尺寸不符
     */
    public static int PICTURE_SIZE_ERROR = 4153;
    
    /**
     * 服务器下载图片出错
     */
    public static int DOWNLOAD_IMAGE_ERROR = 4154;
    
    /**
     * iserver 返回 请求网元不可信
     */
    public static int REQUEST_NETWORK_NOT_VALID = 4155;
    
    /**
     * 系统异常（iserver报其他错误）
     */
    public static int UPLOAD_SYSTEM_ERROR = 4156;
    
    /**
     * 获取验证码与校验的间隔过短
     */
    public static int VERIFYCODE_INTERVAL_SHORT_ERROR = 104227;
    
    /**
     * 获取验证码已经达到每日上限或者太过频繁
     */
    public static int VERIFYCODE_CONTINUOUS_REACH_MAXIMUM = 104228;
    
    /**
     * 用户在黑名单
     */
    public static int USER_IN_BLOCKLIST = 104229;
    
    /**
     * 审核不通过
     */
    public static final int AUDIT_NOT_PASSED = 4152;
    
    /**
     * 重复签到
     */
    public static final int SIGNIN_FAILURE = 4028;
    
    /**
     * 该书籍未在任何专区下上架/下架且不满足包月移除规则
     */
    public static final int NODE_ANYZONE_AND_NOT_MEETMONTHLY = 4157;
    
    /**
     * 用户自定义头像不存在
     */
    public static final int USER_DEFINED_HEAD_ISNOT_EXIST = 4158;
    
    /**
     * 系统繁忙
     */
    public static final int SYSTEM_BUSY_ERROR = 4159;
    
    /**
     * 数据库异常
     */
    public static final int DATABASE_ERROR = 4160;
    
    /** 优惠活动文案-默认值对应描述 */
    public static final String PROMOTION_ACTIVITY__DESC_DEFAULT = "特价优惠";
    
    /** 优惠活动类型：0-无优惠 */
    public static final String PROMOTION_TYPE_NONE = "0";
    
    /** 优惠活动类型：3-打折 */
    public static final String PROMOTION_TYPE_SALE = "3";
    
    /** 优惠活动类型：4-特价 */
    public static final String PROMOTION_TYPE_SPECIAL = "4";
    
    /** 优惠活动类型：11-门户独立折扣 */
    public static final String PROMOTION_TYPE_PORTAL = "11";
    
    /** 优惠活动类型：12-会员折扣 */
    public static final String PROMOTION_TYPE_MEMBER = "12";
    
    /**
     * 获取验证码校验太过频繁
     */
    public static final int SEND_SMS_FREQUENTLY = 104230;
    
    /**
     * 微信免密支付 参数错误
     */
    public static final int WECHAT_PARAM_ERROR = 4171;
    
    /**
     * 微信免密支付 参数错误
     */
    public static final String WECHAT_PARAM_ERROR_DESC = "参数错误";
    
    /**
     * 微信免密支付 查询为空
     */
    public static final int WECHAT_ISNULL_ERROR = 4173;
    
    /**
     * 微信免密支付 查询为空
     */
    public static final String WECHAT_ISNULL_ERROR_DESC = "查询为空";
    
    /**
     * 微信免密支付 商户没有权限
     */
    public static final int WECHAT_NOTPOWER_ERROR = 4174;
    
    /**
     * 微信免密支付 商户没有权限
     */
    public static final String WECHAT_NOTPOWER_ERROR_DESC = "商户没有权限";
    
    /**
     * 微信免密支付 未签约
     */
    public static final int WECHAT_NOTSIGN = 4175;
    
    /**
     * 微信正在扣费
     */
    public static final int WECHAT_BEING_DEDUCTED = 4176;
    
    /**
     * 微信正在扣费
     */
    public static final String WECHAT_BEING_DEDUCTED_DESC = "微信正在扣费";
    
    /**
     * 微信二级黑名单
     */
    public static final String WECHAT_BLACKLIST_GRADE_TWO_DESC = "微信二级黑名单";
    
    /**
     * 微信绑定信息为空，未签约
     */
    public static final int WECHAT_NO_CONTRACT = 4178;
    
    /**
     * 微信绑定信息为空
     */
    public static final String WECHAT_NO_CONTRACT_DES = "微信绑定信息为空";
    
    /**
     * 无补丁升级信息
     */
    public static final int NOT_HAVE_PATCH = 7200;
    
    /**
     * 多周期包月产品不能自动续订
     */
    public static final int MORE_CYCLES_MONTHLY_NOT_RENEWABLE = 7177;
    
    /**
     * 表示IOS非自动续订包月产品无法退订
     */
    public static final int SUBSCRIBE_FAIL_IOS_ISNOTATUOSUBSCRIBE = 7178;

    /**
     * 图书处于互动图书黑名单
     */
    public static final String BOOK_IN_SNS_BLACK_INFO = "7222";

    /**
     * 判断identifyId是否已经自动注册 1：是新注册
     */
    public static final String IS_AUTO_REGISTER = "1";
    
    /**
     * 签名种子校验失败
     */
    public static final int SIGN_SEED_FAIL = 9041;
    
    /**
     * 签名种子校验失效
     */
    public static final int SIGN_SEED_NOT_VAILD = 9040;
    
    /**
     * 已经取消预定该图书，不允许重复取消
     */
    public static final int USER_NOT_SUPPORT = 9402;
    
    /**
     * 用户重复预定
     */
    public static final int USER_SUPPORT = 9403;
    
    /**
     * 用户预定图书已达最大值
     */
    public static final int USER_SUPPORT_MAX = 9404;
    
    /**
     * 用户个性签名含有一级敏感词
     */
    public static final int MODIFY_USERINFO_SIG_SENSITIVE_WORDS_ONE_LEVEL = 9047;
    
    /**
     * 用户个性签名超出指定长度
     */
    public static final int MODIFY_USERINFO_SIGNATURE_LENGTH_ILLEGAL = 9046;
    
    /**
     * 评论长度超过限制
     */
    public static final int COMMENT_LENGTH_OVER_LIMIT = 5032;
    
    /**
     * 评论错误
     */
    public static final int COMMENT_ERROR = 5033;
    
    /**
     * 图片数量超过限制
     */
    public static final int IMAGE_NUMBER_OVER_LIMIT = 5034;
    
    /**
     * 任务状态:1-接受
     */
    public static final Integer TASK_STATUS_ACCEPT = 1;
    
    /**
     * 任务状态:3-完成
     */
    public static final Integer TASK_STATUS_FINISH = 3;
    
    /**
     * 下载lrc文件失败
     */
    public static final int DOWNLOAD_LRC_ERROR = 8404;
    
    /**
     * UGC内容不允许下载
     */
    public static final int UGC_DOWNLOAD_ERROR = 6203;
    
    /**
     * 无对应转换资源
     */
    public static final int NO_CORRESPONDING_RESOURCE = 5001;
    
    /**
     * 该时段无运营信息
     */
    public static final int NO_OPER_INFO = 5002;
    
    /**
     * 接口调用一场
     */
    public static final int INTERFACE_ERROR = 0;
    
    /**
     * 不支持其他平台
     */
    public static final int NO_SUPPORT_PLAT = 5003;
    
    /**
     * 咪咕币余额不足
     */
    public static final int MIGU_CURRENCY_NO_ENOUGH = 2099;
    
    /**
     * 屏蔽发送失败
     */
    public static final int BLOCKING_SEND_FAILURE = 8304;
    
    /**
     * 内容包含敏感词
     */
    public static final int CONTENT_CONTAINS_SENSITIVE_WORDS = 8305;
    
    /**
     * 数据库错误
     */
    public static final int DB_ERROR = 8036;
    
    /**
     * 不能屏蔽自己
     */
    public static final int SHIELD_SELF_ERROR = 8037;
    
    /**
     * 屏蔽关系已经存在
     */
    public static final int SHIELD_RELATIONSHIP_REPETITION = 8038;

    /**
     * 不支持该书籍类型
     */
    public static final int NO_SUPPORT_ITEM_TYPE = 1101;
    
    /**
     * 老版本（app）的邮箱注册错误
     */
    public static final int OLDVERSION_EMAIL_REGISTER_ERROR = 2101;
    
    /**
     * 获取支付宝信息失败
     */
    public static final int GET_ALIPAY_FAIL = 2105;
    
    /**
     * 签约失败
     */
    public static final int ALIPAY_SIGN_FAIL = 2104;
    
    /**
     * 添加书签失败
     */
    public static final int ADD_BOOKMARK_FAIL = 2107;
    
    /**
     * 获取章节数为0或失败
     */
    public static final int GET_CHAPTERNUM_FAIL = 2130;
    
    /**
     * 批价信息为空
     */
    public static final int FEEELEMENT_IS_NULL = 2109;
    
    /**
     * 批量章节鉴权失败
     */
    public static final int BATCH_CHAPTER_AUTH_FAIL = 2110;


    /**
     * 偷书书架查询失败
     */
    public static final int QUERY_STEALBOOK_SHELF_FAIL = 2112;
    
    /**
     * kindle电子书用户包月订购失败
     */
    public static final int KINDLE_SUBSCRIBE_FAIL = 2113;    

    /**
     * type错误，站内消息类型无效
     */
    public static final int STATION_MESSAGE_NOT_VALID = 8301;
    
    /**
     * 站内消息删除失败,或者数据库中已经没有需要删除的记录了
     */
    public static final int STATION_MESSAGE_DELETE_FAILED = 8302;
    
    /**
     * 无效id
     */
    public static final int INVALID_ID = 8303;
    
    /**
     * 查询用户阅读时长开关关闭
     */
    public static final int GET_USER_READDUATION_OFF = 3108;
    
    /**
     * 本次操作存在风险,请检查操作环境(ip无法获取有效值)
     */
    public static final int INVALID_IP = 2009;
    
    /**
     * 3865 添加笔记有敏感词 zhengyunjie 
     */
    public static final int ADDUSERNOTES_BE_SENSITIVE = 2120;

    /**
     * BR005659发表漫画吐槽内容包含敏感词
     */
    public static final int ADDCARTOON_CONTENT_SENSITIVE = 7150;

    /**
     * BR005659发表漫画吐槽内容超限最大30字
     */
    public static final int ADDCARTOON_GO_BEYOND_LIMIT = 7151;

    /**
     * BR005659发表漫画吐槽失败
     */
    public static final int ADDCARTOON_FAILE = 7153;

    /**
     * 用户为防刷限制永久黑名单
     */
    public static final int ANTI_BRUSH_PERMANENT_USER = 1001;
    
    /**
     * 用户被加入防刷限制黑名单
     */
    public static final int ADD_INTO_ANTI_BRUSH = 1002;
    
    /**
     * 用户为防刷限制临时黑名单
     */
    public static final int ANTI_BRUSH_TEMPORARY_USER = 1003;
    

    /**
     * 3865 修改笔记有敏感词 zhengyunjie 
     */
    public static final int UPDATEUSERNOTES_BE_SENSITIVE = 2114;
    
    /**
     * 获取热词信息失败
     */
    public static final int GET_HOTWORDS_FAIL = 2154;
    
    /**
     * 公开笔记回复内容存在敏感词
     */
    public static final int REPLAYUSERNOTES_BE_SENSITIVE = 2132;
    
    /**
     * 重复点赞
     */
    public static final int ABET_OR_CANCEL_ABET_AGAIN = 2131;
    
    /**
     * 用户不存在
     */
    public static final int ACCOUNT_IS_NULL = 8502;
    
    /**
     * 参数失败
     */
    public static final int PARAMETER_FAIL = 8503;
    
    /**
     * 第三方账号身份ID不能为空
     */
    public static final int THIRDPARTY_ID_IS_NULL = 8504;
    
    /**
     * 访问鉴权失败，请求网元不可信
     */
    public static final int ACCESS_AUTHENTICATION_FAILED = 8505;
    
    /**
     * 场景不能为空
     */
    public static final int SCENE_IS_NULL = 8506;
    
    /** * 参数为空已经存在 错误码4109 */ 
    
    /**
     * 数据库异常
     */
    public static final int DATABASE_EXCEPTION = 8507;
    
    /**
     * 系统过载
     */
    public static final int SYSTEM_OVERLOAD = 8508;
    
    /**
     * 用户在黑名单或者关注私信黑名单中
     */
    public static final int BLACK_USER = 8306;
    
    /**
     * 查询iServer缓存异常
     */
    public static final int CACHEOPERATION_FAIL = 4404;

    /**
     * 超出今日私信发送上限
     */
    public static final int TODAY_MESSAGE_COUNT_LIMIT = 8300;   
    
    /**
     * 用户输入包含js脚本
     */
    public static final int MODIFY_USERINFO_JS_CHAR_ILLEGAL = 9048;

    /**
     * 置顶图书超过数量限制，最多置顶三本
     */
    public static final int TOP_BOOKSCOUNT_OVERLIMIT = 3017;


    /**
     * 接收方号码列表为空
     */
    public static final int RECMOBILE_IS_EMPTY = 7131;

    /**
     * 书本ID为空
     */
    public static final int BOOKID_IS_EMPTY = 7132;

    /**
     * 书本不存在
     */
    public static final int BOOK_IS_EMPTY = 7133;

    /**
     * 书本未上架
     */
    public static final int BOOK_NOT_ON_SHEIF = 7134;

    /**
     * 非图书类型
     */
    public static final int IS_NOT_BOOK_TYPE = 7135;

    /**
     * 发送号码为非移动号码
     */
    public static final int SENDMOBILE_ILLEGAL= 7136;

    /**
     * 接手号码全部非移动号码或者黑名单
     */
    public static final int ALL_RECMOBILE__ILLEGAL_OR_BLACK= 7137;

    /**
     * 超出发送数量上限
     */
    public static final int SEND_COUNT_LIMIT = 7138;

    /**
     * 该手机号已超出每日发送上限
     */
    public static final int THIS_MOBILE_TODAY_SEND_TIMES_LIMIT = 7139;

    /**
     * 该手机号已超出当月发送上限
     */
    public static final int THIS_MOBILE_MONTH_SEND_TIMES_LIMIT = 7140;

    /**
     * 月发送次数超限
     */
    public static final int MONTH_SEND_TIMES_LIMIT = 7141;

    /**
     * 日发送次数超限
     */
    public static final int DAY_SEND_TIMES_LIMIT = 7142;

    /**
     * 发送号码为非移动号码
     */
    public static final int IS_NOT_MOBILE_NUMBER = 7143;
    
    /**
     * 无答题地址
     */
    public static final int  IS_NOT_EXAMADDRESS  = 3131;

    /**
     * kindle直接分享 引文最大长度限制
     */
    public static final int KINDLE_NOTE_QUOTE_TO_LONG = 7154;
    
    /**
     * resultCode错误
     */
    public static final int RESULTCODE = 7155;

}
