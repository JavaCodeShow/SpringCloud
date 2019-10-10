package com.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 潇潇暮雨
 * @create 2018-12-04   15:31
 * <p>
 * 自定义Ribbon的执行策略，依旧轮询策略，但是加上新需求，每个服务器要求被调用5次。
 * 也即以前是每台机器一次，现在是每台机器5次。
 */
public class RandomRule_ZY extends AbstractLoadBalancerRule {

    private int total = 0; // 每个服务调用的次数
    private int currnetIndex = 0; // 当前执行的服务的下标

    /**
     * Randomly choose from all living servers
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            /*int index = chooseRandomInt(serverCount);
            server = upList.get(index);*/
            // 采用自定义的算法执行
            if (total < 5) {
                server = upList.get(currnetIndex);
                total++;
            } else {
                total = 1;
                currnetIndex++;
                if (currnetIndex >= serverCount) {
                    currnetIndex = 0;
                }
                server = upList.get(currnetIndex);
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}