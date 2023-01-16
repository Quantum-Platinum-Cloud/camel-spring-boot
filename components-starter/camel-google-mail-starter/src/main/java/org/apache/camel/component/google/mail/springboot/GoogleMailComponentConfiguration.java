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
package org.apache.camel.component.google.mail.springboot;

import java.util.Collection;
import org.apache.camel.component.google.mail.GoogleMailClientFactory;
import org.apache.camel.component.google.mail.GoogleMailConfiguration;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Manage messages in Google Mail.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@ConfigurationProperties(prefix = "camel.component.google-mail")
public class GoogleMailComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the google-mail component. This
     * is enabled by default.
     */
    private Boolean enabled;
    /**
     * Google mail application name. Example would be camel-google-mail/1.0
     */
    private String applicationName;
    /**
     * Client ID of the mail application
     */
    private String clientId;
    /**
     * To use the shared configuration. The option is a
     * org.apache.camel.component.google.mail.GoogleMailConfiguration type.
     */
    private GoogleMailConfiguration configuration;
    /**
     * Delegate for wide-domain service account
     */
    private String delegate;
    /**
     * GMail scopes
     */
    private Collection<String> scopes;
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
    /**
     * To use the GoogleCalendarClientFactory as factory for creating the
     * client. Will by default use BatchGoogleMailClientFactory. The option is a
     * org.apache.camel.component.google.mail.GoogleMailClientFactory type.
     */
    private GoogleMailClientFactory clientFactory;
    /**
     * OAuth 2 access token. This typically expires after an hour so
     * refreshToken is recommended for long term usage.
     */
    private String accessToken;
    /**
     * Client secret of the mail application
     */
    private String clientSecret;
    /**
     * OAuth 2 refresh token. Using this, the Google Calendar component can
     * obtain a new accessToken whenever the current one expires - a necessity
     * if the application is long-lived.
     */
    private String refreshToken;
    /**
     * Service account key in json format to authenticate an application as a
     * service account. Accept base64 adding the prefix base64:
     */
    private String serviceAccountKey;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public GoogleMailConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(GoogleMailConfiguration configuration) {
        this.configuration = configuration;
    }

    public String getDelegate() {
        return delegate;
    }

    public void setDelegate(String delegate) {
        this.delegate = delegate;
    }

    public Collection<String> getScopes() {
        return scopes;
    }

    public void setScopes(Collection<String> scopes) {
        this.scopes = scopes;
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

    public GoogleMailClientFactory getClientFactory() {
        return clientFactory;
    }

    public void setClientFactory(GoogleMailClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getServiceAccountKey() {
        return serviceAccountKey;
    }

    public void setServiceAccountKey(String serviceAccountKey) {
        this.serviceAccountKey = serviceAccountKey;
    }
}