package com.jty.tx.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author :jty
 * @date :20-11-2
 */
@Configuration
public class DruidConfig {
        private static Logger log = LoggerFactory.getLogger(DruidConfig.class);
        @Bean
        @ConfigurationProperties(prefix="spring.datasource")
        public DataSource druid() {
            return new DruidDataSource();
        }
        /**
         * 配置druid管理页面的访问控制
         * 访问网址: http://127.0.0.1:8080/druid
         * @return
         */
        @Bean
        public ServletRegistrationBean<Servlet> druidServlet() {
            log.info("init Druid Servlet Configuration");
            ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>();
            //配置一个控制台拦截器
            servletRegistrationBean.setServlet(new StatViewServlet());
            //指定拦截器只拦截druid管理页面的请求
            servletRegistrationBean.addUrlMappings("/druid/*");
            HashMap<String, String> initParam = new HashMap<String,String>();
            //登录druid管理页面的用户名
            initParam.put("loginUsername", "admin");
            //是否允许重置druid的统计信息
            initParam.put("loginPassword", "admin");
            //是否允许重置druid的统计信息
            initParam.put("resetEnable", "true");
            //ip白名单，如果没有设置或为空，则表示允许所有访问
            initParam.put("allow", "");
            servletRegistrationBean.setInitParameters(initParam);
            return servletRegistrationBean;
        }

        @Bean
        public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
            FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>();
            filterRegistrationBean.setFilter(new WebStatFilter());
            filterRegistrationBean.addUrlPatterns("/*");
            filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
            return filterRegistrationBean;
        }

}
