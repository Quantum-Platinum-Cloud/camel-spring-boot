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
package org.apache.camel.component.consul.springboot.cloud;

import org.apache.camel.cloud.ServiceDiscovery;
import org.apache.camel.model.cloud.springboot.ConsulServiceCallServiceDiscoveryConfigurationProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsulServiceDiscoveryTest {
    @Test
    public void testConsulServiceDiscoveryDisabled() {
        new ApplicationContextRunner()
            .withUserConfiguration(TestConfiguration.class)
            .withPropertyValues(
                "spring.main.banner-mode=off",
                "camel.cloud.consul.service-discovery.enabled=false")
            .run(
                context -> {
                    assertThat(context).doesNotHaveBean(ConsulServiceCallServiceDiscoveryConfigurationProperties.class);
                    assertThat(context).getBeans(ServiceDiscovery.class).doesNotContainKeys("consul-service-discovery");
                }
            );
    }

    @Test
    public void testConsulServiceDiscoveryEnabled() {
        new ApplicationContextRunner()
            .withUserConfiguration(TestConfiguration.class)
            .withPropertyValues(
                "spring.main.banner-mode=off",
                "camel.cloud.consul.service-discovery.enabled=true")
            .run(
                context -> {
                    assertThat(context).hasSingleBean(ConsulServiceCallServiceDiscoveryConfigurationProperties.class);
                    assertThat(context).getBeans(ServiceDiscovery.class).containsKeys("consul-service-discovery");
                }
            );
    }

    @EnableAutoConfiguration
    @Configuration
    public static class TestConfiguration {
    }
}
