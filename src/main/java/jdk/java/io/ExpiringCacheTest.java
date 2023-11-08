package jdk.java.io;

/**
 * 带过期时间的LRU缓存
 * <p>
 * 1、LinkedHashMap实现LRU，最大节点数200
 * 2、支持过期删除，每get/put超过300次，遍历map删除过期的节点
 * <p>
 * // @see ExpiringCache
 */
public class ExpiringCacheTest {
}
