package com.hzit.consumer.config;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IRuleConfig {


    @Bean
    public IRule iRule() {

        //返回具体体的实现类
//        - RoundRobinRule：轮询（默认方法）
//        - RandomRule：随机
//        - AvailabilityFilteringRule：先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数量超过阈值的服务，然后对剩余的服务进行轮询
//        - WeightedResponseTimeRule：根据平均响应时间计算服务的权重。统计信息不足时会按照轮询，统计信息足够会按照响应的时间选择服务
//        - RetryRule：正常时按照轮询选择服务，若过程中有服务出现故障，在轮询一定次数后依然故障，则会跳过故障的服务继续轮询。
//        - BestAvailableRule：先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
//        - ZoneAvoidanceRule：默认规则，符合判断server所在的区域的性能和server的可用性选择服务
//
//                切换规则方法

        //return new RandomRule(); //随机负载均衡算法
        return  new BestAvailableRule(); //去掉异常的服务,选择并发量小的服务
    }

}
