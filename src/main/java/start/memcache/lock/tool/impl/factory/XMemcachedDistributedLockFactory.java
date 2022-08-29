package start.memcache.lock.tool.impl.factory;

import start.memcache.lock.tool.DistributedLock;
import start.memcache.lock.tool.DistributedLockException;
import start.memcache.lock.tool.DistributedLockFactory;
import net.rubyeye.xmemcached.MemcachedClient;

/**
 * XMemcached distributed lock factory implement
 */
public class XMemcachedDistributedLockFactory implements DistributedLockFactory {
    private static final String XMEMCACHED_DISTRIBUTED_LOCK_FACTORY_PREFIX = "__xmemcached_distributed_lock_factory_prefix:";
    private static final String XMEMCACHED_DISTRIBUTED_LOCK_FACTORY_DEFAULT_VALUE = "x";

    private int defaultLockExpireInSeconds = 10 * 60;
    private MemcachedClient client;

    public XMemcachedDistributedLockFactory(MemcachedClient client) {
        this.client = client;
    }

    public XMemcachedDistributedLockFactory(MemcachedClient client, int defaultLockExpireInSeconds) {
        this.client = client;
        this.defaultLockExpireInSeconds = defaultLockExpireInSeconds;
    }

    @Override
    public DistributedLock createDistributedLock(String lockId) {
        final String theLockId = XMEMCACHED_DISTRIBUTED_LOCK_FACTORY_PREFIX + lockId;
        return new DistributedLock() {
            @Override
            public boolean tryLock(int lockExpireInSeconds) {
                try {
                    return client.add(theLockId, lockExpireInSeconds, XMEMCACHED_DISTRIBUTED_LOCK_FACTORY_DEFAULT_VALUE);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override
            public boolean tryLock() throws DistributedLockException {
                return tryLock(defaultLockExpireInSeconds);
            }

            @Override
            public void unLock() {
                try {
                    client.delete(theLockId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
