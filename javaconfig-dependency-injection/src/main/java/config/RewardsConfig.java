/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import rewards.internal.account.AccountRepository;
import rewards.internal.account.JdbcAccountRepository;
import rewards.internal.restaurant.RestaurantRepository;
import rewards.internal.restaurant.JdbcRestaurantRepository;
import rewards.internal.reward.RewardRepository;
import rewards.internal.reward.JdbcRewardRepository;
import rewards.internal.RewardNetworkImpl;

/**
 *
 * @author admin
 */
@Configuration
public class RewardsConfig {
    
    @Autowired
    DataSource dataSource;
    
    @Bean
    @Description("The Reward Network")
    public RewardNetworkImpl rewardNetwork(DataSource dataSource) {
        return new RewardNetworkImpl(accountRepository(dataSource), restaurantRepository(dataSource), rewardRepository(dataSource));
    }

    @Bean
    @Description("The Account Repository")
    public AccountRepository accountRepository(DataSource dataSource) {
        JdbcAccountRepository jdbcAccountRepository = new JdbcAccountRepository();
        jdbcAccountRepository.setDataSource(dataSource);
        return jdbcAccountRepository;
    }
    
    @Bean
    @Description("The Restaurant Repository")
    public RestaurantRepository restaurantRepository(DataSource dataSource) {
        JdbcRestaurantRepository jdbcRestaurantRepository = new JdbcRestaurantRepository();
        jdbcRestaurantRepository.setDataSource(dataSource);
        return jdbcRestaurantRepository;
    }
    
    @Bean
    @Description("The Reward Repository")
    public RewardRepository rewardRepository(DataSource dataSource) {
        JdbcRewardRepository jdbcRewardRepository = new JdbcRewardRepository();
        jdbcRewardRepository.setDataSource(dataSource);
        return jdbcRewardRepository;
    }
}
