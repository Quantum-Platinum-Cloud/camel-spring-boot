/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.jpa.springboot;

import java.util.Map;
import jakarta.persistence.EntityManagerFactory;
import org.apache.camel.component.jpa.TransactionStrategy;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Store and retrieve Java objects from databases using Java Persistence API
 * (JPA).
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@ConfigurationProperties(prefix = "camel.component.jpa")
public class JpaComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the jpa component. This is
     * enabled by default.
     */
    private Boolean enabled;
    /**
     * Maps an alias to a JPA entity class. The alias can then be used in the
     * endpoint URI (instead of the fully qualified class name).
     */
    private Map<String, Class<Object>> aliases;
    /**
     * To use the EntityManagerFactory. This is strongly recommended to
     * configure. The option is a jakarta.persistence.EntityManagerFactory type.
     */
    private EntityManagerFactory entityManagerFactory;
    /**
     * The camel-jpa component will join transaction by default. You can use
     * this option to turn this off, for example if you use LOCAL_RESOURCE and
     * join transaction doesn't work with your JPA provider. This option can
     * also be set globally on the JpaComponent, instead of having to set it on
     * all endpoints.
     */
    private Boolean joinTransaction = true;
    /**
     * Whether to use Spring's SharedEntityManager for the consumer/producer.
     * Note in most cases joinTransaction should be set to false as this is not
     * an EXTENDED EntityManager.
     */
    private Boolean sharedEntityManager = false;
    /**
     * To use the PlatformTransactionManager for managing transactions. The
     * option is a org.springframework.transaction.PlatformTransactionManager
     * type.
     */
    @Deprecated
    private PlatformTransactionManager transactionManager;
    /**
     * To use the TransactionStrategy for running the operations in a
     * transaction. The option is a
     * org.apache.camel.component.jpa.TransactionStrategy type.
     */
    private TransactionStrategy transactionStrategy;
    /**
     * Allows for bridging the consumer to the Camel routing Error Handler,
     * which mean any exceptions occurred while the consumer is trying to pickup
     * incoming messages, or the likes, will now be processed as a message and
     * handled by the routing Error Handler. By default the consumer will use
     * the org.apache.camel.spi.ExceptionHandler to deal with exceptions, that
     * will be logged at WARN or ERROR level and ignored.
     */
    private Boolean bridgeErrorHandler = false;
    /**
     * Whether the producer should be started lazy (on the first message). By
     * starting lazy you can use this to allow CamelContext and routes to
     * startup in situations where a producer may otherwise fail during starting
     * and cause the route to fail being started. By deferring this startup to
     * be lazy then the startup failure can be handled during routing messages
     * via Camel's routing error handlers. Beware that when the first message is
     * processed then creating and starting the producer may take a little time
     * and prolong the total processing time of the processing.
     */
    private Boolean lazyStartProducer = false;
    /**
     * Whether autowiring is enabled. This is used for automatic autowiring
     * options (the option must be marked as autowired) by looking up in the
     * registry to find if there is a single instance of matching type, which
     * then gets configured on the component. This can be used for automatic
     * configuring JDBC data sources, JMS connection factories, AWS Clients,
     * etc.
     */
    private Boolean autowiredEnabled = true;

    public Map<String, Class<Object>> getAliases() {
        return aliases;
    }

    public void setAliases(Map<String, Class<Object>> aliases) {
        this.aliases = aliases;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(
            EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public Boolean getJoinTransaction() {
        return joinTransaction;
    }

    public void setJoinTransaction(Boolean joinTransaction) {
        this.joinTransaction = joinTransaction;
    }

    public Boolean getSharedEntityManager() {
        return sharedEntityManager;
    }

    public void setSharedEntityManager(Boolean sharedEntityManager) {
        this.sharedEntityManager = sharedEntityManager;
    }

    @Deprecated
    @DeprecatedConfigurationProperty
    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    @Deprecated
    public void setTransactionManager(
            PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public TransactionStrategy getTransactionStrategy() {
        return transactionStrategy;
    }

    public void setTransactionStrategy(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    public Boolean getBridgeErrorHandler() {
        return bridgeErrorHandler;
    }

    public void setBridgeErrorHandler(Boolean bridgeErrorHandler) {
        this.bridgeErrorHandler = bridgeErrorHandler;
    }

    public Boolean getLazyStartProducer() {
        return lazyStartProducer;
    }

    public void setLazyStartProducer(Boolean lazyStartProducer) {
        this.lazyStartProducer = lazyStartProducer;
    }

    public Boolean getAutowiredEnabled() {
        return autowiredEnabled;
    }

    public void setAutowiredEnabled(Boolean autowiredEnabled) {
        this.autowiredEnabled = autowiredEnabled;
    }
}