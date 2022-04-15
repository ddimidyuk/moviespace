package com.ddimidyuk.moviespace.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import javax.sql.DataSource


@Configuration
@EnableJdbcRepositories(basePackages = ["com.ddimidyuk.moviespace"])
class DataSourceConfig {

    @Bean
    fun namedParameterJdbcOperations(dataSource: DataSource) = NamedParameterJdbcTemplate(dataSource)

    @Bean
    fun transactionManager(dataSource: DataSource) = DataSourceTransactionManager(dataSource)

}