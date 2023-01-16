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
package org.apache.camel.component.caffeine.load.springboot;

import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

/**
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Configuration(proxyBeanMethods = false)
@ConfigurationPropertiesBinding
@Component
public class CaffeineLoadCacheComponentConverter implements GenericConverter {

    @Autowired
    private ApplicationContext applicationContext;

    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> answer = new LinkedHashSet<>();
        answer.add(new ConvertiblePair(String.class, com.github.benmanes.caffeine.cache.CacheLoader.class));
        answer.add(new ConvertiblePair(String.class, org.apache.camel.component.caffeine.CaffeineConfiguration.class));
        answer.add(new ConvertiblePair(String.class, com.github.benmanes.caffeine.cache.RemovalListener.class));
        answer.add(new ConvertiblePair(String.class, com.github.benmanes.caffeine.cache.stats.StatsCounter.class));
        return answer;
    }

    public Object convert(
            Object source,
            TypeDescriptor sourceType,
            TypeDescriptor targetType) {
        if (source == null) {
            return null;
        }
        String ref = source.toString();
        if (!ref.startsWith("#")) {
            return null;
        }
        ref = ref.startsWith("#bean:") ? ref.substring(6) : ref.substring(1);
        switch (targetType.getName()) {
            case "com.github.benmanes.caffeine.cache.CacheLoader": return applicationContext.getBean(ref, com.github.benmanes.caffeine.cache.CacheLoader.class);
            case "org.apache.camel.component.caffeine.CaffeineConfiguration": return applicationContext.getBean(ref, org.apache.camel.component.caffeine.CaffeineConfiguration.class);
            case "com.github.benmanes.caffeine.cache.RemovalListener": return applicationContext.getBean(ref, com.github.benmanes.caffeine.cache.RemovalListener.class);
            case "com.github.benmanes.caffeine.cache.stats.StatsCounter": return applicationContext.getBean(ref, com.github.benmanes.caffeine.cache.stats.StatsCounter.class);
        }
        return null;
    }
}