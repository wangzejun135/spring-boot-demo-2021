package start.memcache.lock.tool;

public interface DistributedLockFactory {
    DistributedLock createDistributedLock(String lockId);
}
