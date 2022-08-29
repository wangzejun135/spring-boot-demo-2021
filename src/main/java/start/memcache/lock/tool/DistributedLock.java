package start.memcache.lock.tool;

public interface DistributedLock {
    /**
     * Try distributed lock, only returns true is get lock success
     *
     * @param lockExpireInSeconds Lock expire time in seconds
     * @return result
     * @throws DistributedLockException
     */
    boolean tryLock(int lockExpireInSeconds) throws DistributedLockException;

    /**
     * Try distributed lock, only returns true is get lock success
     *
     * @return result
     * @throws DistributedLockException
     */
    boolean tryLock() throws DistributedLockException;

    /**
     * Release distributed lock
     */
    void unLock();
}
