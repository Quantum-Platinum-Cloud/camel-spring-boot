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
package org.apache.camel.jsonpath.springboot;

import org.apache.camel.CamelContext;
import org.apache.camel.jsonpath.JsonPathLanguage;
import org.apache.camel.spi.Language;
import org.apache.camel.spi.LanguageCustomizer;
import org.apache.camel.spring.boot.CamelAutoConfiguration;
import org.apache.camel.spring.boot.LanguageConfigurationProperties;
import org.apache.camel.spring.boot.util.CamelPropertiesHelper;
import org.apache.camel.spring.boot.util.ConditionalOnCamelContextAndAutoConfigurationBeans;
import org.apache.camel.spring.boot.util.ConditionalOnHierarchicalProperties;
import org.apache.camel.spring.boot.util.HierarchicalPropertiesEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(CamelAutoConfiguration.class)
@Conditional(ConditionalOnCamelContextAndAutoConfigurationBeans.class)
@EnableConfigurationProperties({LanguageConfigurationProperties.class,JsonPathLanguageConfiguration.class})
@ConditionalOnHierarchicalProperties({"camel.language", "camel.language.jsonpath"})
public class JsonPathLanguageAutoConfiguration {

    @Autowired
    private ApplicationContext applicationContext;
    private final CamelContext camelContext;
    @Autowired
    private JsonPathLanguageConfiguration configuration;

    public JsonPathLanguageAutoConfiguration(
            org.apache.camel.CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    @Lazy
    @Bean
    public org.apache.camel.spi.LanguageCustomizer configureJsonPathLanguage() {
        return new LanguageCustomizer() {
            @Override
            public void configure(String name, Language target) {
                CamelPropertiesHelper.copyProperties(camelContext, configuration, target);
            }
            @Override
            public boolean isEnabled(String name, Language target) {
                return HierarchicalPropertiesEvaluator.evaluate(
                        applicationContext,
                        "camel.language.customizer",
                        "camel.language.jsonpath.customizer")
                    && target instanceof JsonPathLanguage;
            }
        };
    }
}