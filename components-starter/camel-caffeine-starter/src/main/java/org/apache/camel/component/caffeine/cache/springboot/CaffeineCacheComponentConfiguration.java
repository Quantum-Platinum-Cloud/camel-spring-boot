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
package org.apache.camel.component.caffeine.cache.springboot;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.RemovalListener;
import com.github.benmanes.caffeine.cache.stats.StatsCounter;
import org.apache.camel.component.caffeine.CaffeineConfiguration;
import org.apache.camel.component.caffeine.EvictionType;
import org.apache.camel.component.caffeine.cache.CaffeineCacheComponent;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Perform caching operations using Caffeine Cache.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@ConfigurationProperties(prefix = "camel.component.caffeine-cache")
public class CaffeineCacheComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the caffeine-cache component.
     * This is enabled by default.
     */
    private Boolean enabled;
    /**
     * To configure the default cache action. If an action is set in the message
     * header, then the operation from the header takes precedence.
     */
    private String action;
    /**
     * Automatic create the Caffeine cache if none has been configured or exists
     * in the registry.
     */
    private Boolean createCacheIfNotExist = true;
    /**
     * Set the eviction Type for this cache
     */
    private EvictionType evictionType = EvictionType.SIZE_BASED;
    /**
     * Specifies that each entry should be automatically removed from the cache
     * once a fixed duration has elapsed after the entry's creation, the most
     * recent replacement of its value, or its last read. Access time is reset
     * by all cache read and write operations. The unit is in seconds.
     */
    private Integer expireAfterAccessTime = 300;
    /**
     * Specifies that each entry should be automatically removed from the cache
     * once a fixed duration has elapsed after the entry's creation, or the most
     * recent replacement of its value. The unit is in seconds.
     */
    private Integer expireAfterWriteTime = 300;
    /**
     * Sets the minimum total size for the internal data structures. Providing a
     * large enough estimate at construction time avoids the need for expensive
     * resizing operations later, but setting this value unnecessarily high
     * wastes memory.
     */
    private Integer initialCapacity;
    /**
     * To configure the default action key. If a key is set in the message
     * header, then the key from the header takes precedence.
     */
    private String key;
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
     * Specifies the maximum number of entries the cache may contain. Note that
     * the cache may evict an entry before this limit is exceeded or temporarily
     * exceed the threshold while evicting. As the cache size grows close to the
     * maximum, the cache evicts entries that are less likely to be used again.
     * For example, the cache may evict an entry because it hasn't been used
     * recently or very often. When size is zero, elements will be evicted
     * immediately after being loaded into the cache. This can be useful in
     * testing, or to disable caching temporarily without a code change. As
     * eviction is scheduled on the configured executor, tests may instead
     * prefer to configure the cache to execute tasks directly on the same
     * thread.
     */
    private Integer maximumSize;
    /**
     * Whether autowiring is enabled. This is used for automatic autowiring
     * options (the option must be marked as autowired) by looking up in the
     * registry to find if there is a single instance of matching type, which
     * then gets configured on the component. This can be used for automatic
     * configuring JDBC data sources, JMS connection factories, AWS Clients,
     * etc.
     */
    private Boolean autowiredEnabled = true;
    /**
     * To configure a CacheLoader in case of a LoadCache use. The option is a
     * com.github.benmanes.caffeine.cache.CacheLoader type.
     */
    private CacheLoader cacheLoader;
    /**
     * Sets the global component configuration. The option is a
     * org.apache.camel.component.caffeine.CaffeineConfiguration type.
     */
    private CaffeineConfiguration configuration;
    /**
     * Set a specific removal Listener for the cache. The option is a
     * com.github.benmanes.caffeine.cache.RemovalListener type.
     */
    private RemovalListener removalListener;
    /**
     * Set a specific Stats Counter for the cache stats. The option is a
     * com.github.benmanes.caffeine.cache.stats.StatsCounter type.
     */
    private StatsCounter statsCounter;
    /**
     * To enable stats on the cache
     */
    private Boolean statsEnabled = false;
    /**
     * The cache value type, default java.lang.Object
     */
    private String valueType;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Boolean getCreateCacheIfNotExist() {
        return createCacheIfNotExist;
    }

    public void setCreateCacheIfNotExist(Boolean createCacheIfNotExist) {
        this.createCacheIfNotExist = createCacheIfNotExist;
    }

    public EvictionType getEvictionType() {
        return evictionType;
    }

    public void setEvictionType(EvictionType evictionType) {
        this.evictionType = evictionType;
    }

    public Integer getExpireAfterAccessTime() {
        return expireAfterAccessTime;
    }

    public void setExpireAfterAccessTime(Integer expireAfterAccessTime) {
        this.expireAfterAccessTime = expireAfterAccessTime;
    }

    public Integer getExpireAfterWriteTime() {
        return expireAfterWriteTime;
    }

    public void setExpireAfterWriteTime(Integer expireAfterWriteTime) {
        this.expireAfterWriteTime = expireAfterWriteTime;
    }

    public Integer getInitialCapacity() {
        return initialCapacity;
    }

    public void setInitialCapacity(Integer initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Boolean getLazyStartProducer() {
        return lazyStartProducer;
    }

    public void setLazyStartProducer(Boolean lazyStartProducer) {
        this.lazyStartProducer = lazyStartProducer;
    }

    public Integer getMaximumSize() {
        return maximumSize;
    }

    public void setMaximumSize(Integer maximumSize) {
        this.maximumSize = maximumSize;
    }

    public Boolean getAutowiredEnabled() {
        return autowiredEnabled;
    }

    public void setAutowiredEnabled(Boolean autowiredEnabled) {
        this.autowiredEnabled = autowiredEnabled;
    }

    public CacheLoader getCacheLoader() {
        return cacheLoader;
    }

    public void setCacheLoader(CacheLoader cacheLoader) {
        this.cacheLoader = cacheLoader;
    }

    public CaffeineConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(CaffeineConfiguration configuration) {
        this.configuration = configuration;
    }

    public RemovalListener getRemovalListener() {
        return removalListener;
    }

    public void setRemovalListener(RemovalListener removalListener) {
        this.removalListener = removalListener;
    }

    public StatsCounter getStatsCounter() {
        return statsCounter;
    }

    public void setStatsCounter(StatsCounter statsCounter) {
        this.statsCounter = statsCounter;
    }

    public Boolean getStatsEnabled() {
        return statsEnabled;
    }

    public void setStatsEnabled(Boolean statsEnabled) {
        this.statsEnabled = statsEnabled;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }
}