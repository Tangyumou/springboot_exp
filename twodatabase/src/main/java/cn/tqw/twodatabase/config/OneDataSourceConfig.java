package cn.tqw.twodatabase.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @program:
 * @description: 数据库配置1
 * @author: Tang Qinwei
 * @create: 2020-12-28 16:42
 **/
@Configuration
@MapperScan(basePackages = "cn.tqw.twodatabase.mapper", sqlSessionFactoryRef = "oneSqlSessionFactory")
public class OneDataSourceConfig {
    @Value("${spring.datasource.one.driver-class-name}")
    String driverClass;
    @Value("${spring.datasource.one.url}")
    String url;
    @Value("${spring.datasource.one.username}")
    String userName;
    @Value("${spring.datasource.one.password}")
    String passWord;



    @Primary
    @Bean(name = "oneDataSource")
    @ConfigurationProperties("spring.datasource.one")
    public DataSource masterDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(passWord);
        return dataSource;
    }

    @Bean(name = "oneSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("oneDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mybatis/mapper/*.xml"));
        sessionFactoryBean.setTypeAliasesPackage("com.tqw.twodatabase.pojo");
        return sessionFactoryBean.getObject();
    }
    @Bean(name = "oneSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionFactoryTemplate(@Qualifier("oneSqlSessionFactory")SqlSessionFactory sqlSessionFactory ) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
