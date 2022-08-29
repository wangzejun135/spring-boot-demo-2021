package start.service;

import start.model.UserDO;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/3/17 21:50
 */
public interface IUserService {

    int deleteByPrimaryKey(Long id);

    int insert(UserDO userDO);

    UserDO selectByPrimaryKey(Long id);

    int updatePhone(Long id, String phone);

    /**
     * 发送MQ
     */
    void sendMessage();
}
