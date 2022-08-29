package start.service.impl;

import start.mapper.UserMapper;
import start.model.UserDO;
import start.rabbitmq.MsgProducer;
import start.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/3/17 21:52
 */
@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

/*    @Autowired
    private MsgProducer msgProducer;*/


    @Override
    public int deleteByPrimaryKey(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserDO userDO) {
        return userMapper.insert(userDO);
    }

    @Override
    public UserDO selectByPrimaryKey(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updatePhone(Long id, String phone) {
        return userMapper.updatePhone(id, phone);
    }

    @Override
    public void sendMessage() {
        //msgProducer.sendMsg("我是一条消息20210509");
    }
}
