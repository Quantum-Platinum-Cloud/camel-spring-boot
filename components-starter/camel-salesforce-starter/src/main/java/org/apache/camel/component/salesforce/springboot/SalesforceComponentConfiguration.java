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
package org.apache.camel.component.salesforce.springboot;

import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;
import org.apache.camel.component.salesforce.AuthenticationType;
import org.apache.camel.component.salesforce.NotFoundBehaviour;
import org.apache.camel.component.salesforce.api.dto.bulk.ContentType;
import org.apache.camel.component.salesforce.internal.PayloadFormat;
import org.apache.camel.component.salesforce.internal.dto.NotifyForFieldsEnum;
import org.apache.camel.component.salesforce.internal.dto.NotifyForOperationsEnum;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Communicate with Salesforce using Java DTOs.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.springboot.maven.SpringBootAutoConfigurationMojo")
@ConfigurationProperties(prefix = "camel.component.salesforce")
public class SalesforceComponentConfiguration
        extends
            ComponentConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the salesforce component. This is
     * enabled by default.
     */
    private Boolean enabled;
    /**
     * APEX method name
     */
    private String apexMethod;
    /**
     * Query params for APEX method
     */
    private Map<String, Object> apexQueryParams;
    /**
     * APEX method URL
     */
    private String apexUrl;
    /**
     * Salesforce API version, defaults to
     * SalesforceEndpointConfig.DEFAULT_VERSION
     */
    private String apiVersion;
    /**
     * Backoff interval increment for Streaming connection restart attempts for
     * failures beyond CometD auto-reconnect.
     */
    private Long backoffIncrement;
    /**
     * Bulk API Batch ID
     */
    private String batchId;
    /**
     * Bulk API content type, one of XML, CSV, ZIP_XML, ZIP_CSV
     */
    private ContentType contentType;
    /**
     * Default replayId setting if no value is found in initialReplayIdMap
     */
    private Long defaultReplayId;
    /**
     * Payload format to use for Salesforce API calls, either JSON or XML,
     * defaults to JSON
     */
    private PayloadFormat format;
    /**
     * Custom Jetty Http Client to use to connect to Salesforce. The option is a
     * org.apache.camel.component.salesforce.SalesforceHttpClient type.
     */
    private String httpClient;
    /**
     * Connection timeout used by the HttpClient when connecting to the
     * Salesforce server.
     */
    private Long httpClientConnectionTimeout = 60000L;
    /**
     * Timeout used by the HttpClient when waiting for response from the
     * Salesforce server.
     */
    private Long httpClientIdleTimeout = 10000L;
    /**
     * Max content length of an HTTP response.
     */
    private Integer httpMaxContentLength;
    /**
     * Include details in Salesforce1 Analytics report, defaults to false.
     */
    private Boolean includeDetails;
    /**
     * Replay IDs to start from per channel name.
     */
    private Map<String, Long> initialReplayIdMap;
    /**
     * Salesforce1 Analytics report execution instance ID
     */
    private String instanceId;
    /**
     * Bulk API Job ID
     */
    private String jobId;
    /**
     * Limit on number of returned records. Applicable to some of the API, check
     * the Salesforce documentation.
     */
    private Integer limit;
    /**
     * Maximum backoff interval for Streaming connection restart attempts for
     * failures beyond CometD auto-reconnect.
     */
    private Long maxBackoff;
    /**
     * Sets the behaviour of 404 not found status received from Salesforce API.
     * Should the body be set to NULL NotFoundBehaviour#NULL or should a
     * exception be signaled on the exchange NotFoundBehaviour#EXCEPTION - the
     * default.
     */
    private NotFoundBehaviour notFoundBehaviour;
    /**
     * Notify for fields, options are ALL, REFERENCED, SELECT, WHERE
     */
    private NotifyForFieldsEnum notifyForFields;
    /**
     * Notify for create operation, defaults to false (API version = 29.0)
     */
    private Boolean notifyForOperationCreate;
    /**
     * Notify for delete operation, defaults to false (API version = 29.0)
     */
    private Boolean notifyForOperationDelete;
    /**
     * Notify for operations, options are ALL, CREATE, EXTENDED, UPDATE (API
     * version 29.0)
     */
    private NotifyForOperationsEnum notifyForOperations;
    /**
     * Notify for un-delete operation, defaults to false (API version = 29.0)
     */
    private Boolean notifyForOperationUndelete;
    /**
     * Notify for update operation, defaults to false (API version = 29.0)
     */
    private Boolean notifyForOperationUpdate;
    /**
     * Custom Jackson ObjectMapper to use when serializing/deserializing
     * Salesforce objects. The option is a
     * com.fasterxml.jackson.databind.ObjectMapper type.
     */
    private String objectMapper;
    /**
     * In what packages are the generated DTO classes. Typically the classes
     * would be generated using camel-salesforce-maven-plugin. Set it if using
     * the generated DTOs to gain the benefit of using short SObject names in
     * parameters/header values.
     */
    private String[] packages;
    /**
     * Use raw payload String for request and response (either JSON or XML
     * depending on format), instead of DTOs, false by default
     */
    private Boolean rawPayload = false;
    /**
     * Salesforce1 Analytics report Id
     */
    private String reportId;
    /**
     * Salesforce1 Analytics report metadata for filtering. The option is a
     * org.apache.camel.component.salesforce.api.dto.analytics.reports.ReportMetadata type.
     */
    private String reportMetadata;
    /**
     * Bulk API Result ID
     */
    private String resultId;
    /**
     * SObject blob field name
     */
    private String sObjectBlobFieldName;
    /**
     * Fully qualified SObject class name, usually generated using
     * camel-salesforce-maven-plugin
     */
    private String sObjectClass;
    /**
     * SObject fields to retrieve
     */
    private String sObjectFields;
    /**
     * SObject ID if required by API
     */
    private String sObjectId;
    /**
     * SObject external ID field name
     */
    private String sObjectIdName;
    /**
     * SObject external ID field value
     */
    private String sObjectIdValue;
    /**
     * SObject name if required or supported by API
     */
    private String sObjectName;
    /**
     * Salesforce SOQL query string
     */
    private String sObjectQuery;
    /**
     * Salesforce SOSL search string
     */
    private String sObjectSearch;
    /**
     * Whether to update an existing Push Topic when using the Streaming API,
     * defaults to false
     */
    private Boolean updateTopic = false;
    /**
     * Global endpoint configuration - use to set values that are common to all
     * endpoints. The option is a
     * org.apache.camel.component.salesforce.SalesforceEndpointConfig type.
     */
    private String config;
    /**
     * Used to set any properties that can be configured on the underlying HTTP
     * client. Have a look at properties of SalesforceHttpClient and the Jetty
     * HttpClient for all available options.
     */
    private Map<String, Object> httpClientProperties;
    /**
     * Used to set any properties that can be configured on the
     * LongPollingTransport used by the BayeuxClient (CometD) used by the
     * streaming api
     */
    private Map<String, Object> longPollingTransportProperties;
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
     * Whether the component should use basic property binding (Camel 2.x) or
     * the newer property binding with additional capabilities
     */
    private Boolean basicPropertyBinding = false;
    /**
     * A list of addresses for which HTTP proxy server should not be used.
     */
    private Set<String> httpProxyExcludedAddresses;
    /**
     * Hostname of the HTTP proxy server to use.
     */
    private String httpProxyHost;
    /**
     * A list of addresses for which HTTP proxy server should be used.
     */
    private Set<String> httpProxyIncludedAddresses;
    /**
     * Port number of the HTTP proxy server to use.
     */
    private Integer httpProxyPort;
    /**
     * If set to true the configures the HTTP proxy to use as a SOCKS4 proxy.
     */
    private Boolean httpProxySocks4 = false;
    /**
     * Explicit authentication method to be used, one of USERNAME_PASSWORD,
     * REFRESH_TOKEN or JWT. Salesforce component can auto-determine the
     * authentication method to use from the properties set, set this property
     * to eliminate any ambiguity.
     */
    private AuthenticationType authenticationType;
    /**
     * OAuth Consumer Key of the connected app configured in the Salesforce
     * instance setup. Typically a connected app needs to be configured but one
     * can be provided by installing a package.
     */
    private String clientId;
    /**
     * OAuth Consumer Secret of the connected app configured in the Salesforce
     * instance setup.
     */
    private String clientSecret;
    /**
     * Used in authentication against the HTTP proxy server, needs to match the
     * URI of the proxy server in order for the httpProxyUsername and
     * httpProxyPassword to be used for authentication.
     */
    private String httpProxyAuthUri;
    /**
     * Password to use to authenticate against the HTTP proxy server.
     */
    private String httpProxyPassword;
    /**
     * Realm of the proxy server, used in preemptive Basic/Digest authentication
     * methods against the HTTP proxy server.
     */
    private String httpProxyRealm;
    /**
     * If set to false disables the use of TLS when accessing the HTTP proxy.
     */
    private Boolean httpProxySecure = true;
    /**
     * If set to true Digest authentication will be used when authenticating to
     * the HTTP proxy, otherwise Basic authorization method will be used
     */
    private Boolean httpProxyUseDigestAuth = false;
    /**
     * Username to use to authenticate against the HTTP proxy server.
     */
    private String httpProxyUsername;
    /**
     * URL of the Salesforce instance used after authentication, by default
     * received from Salesforce on successful authentication
     */
    private String instanceUrl;
    /**
     * KeyStore parameters to use in OAuth JWT flow. The KeyStore should contain
     * only one entry with private key and certificate. Salesforce does not
     * verify the certificate chain, so this can easily be a selfsigned
     * certificate. Make sure that you upload the certificate to the
     * corresponding connected app. The option is a
     * org.apache.camel.support.jsse.KeyStoreParameters type.
     */
    private String keystore;
    /**
     * If set to true prevents the component from authenticating to Salesforce
     * with the start of the component. You would generally set this to the
     * (default) false and authenticate early and be immediately aware of any
     * authentication issues.
     */
    private Boolean lazyLogin = false;
    /**
     * All authentication configuration in one nested bean, all properties set
     * there can be set directly on the component as well. The option is a
     * org.apache.camel.component.salesforce.SalesforceLoginConfig type.
     */
    private String loginConfig;
    /**
     * URL of the Salesforce instance used for authentication, by default set to
     * https://login.salesforce.com
     */
    private String loginUrl = "https://login.salesforce.com";
    /**
     * Password used in OAuth flow to gain access to access token. It's easy to
     * get started with password OAuth flow, but in general one should avoid it
     * as it is deemed less secure than other flows. Make sure that you append
     * security token to the end of the password if using one.
     */
    private String password;
    /**
     * Refresh token already obtained in the refresh token OAuth flow. One needs
     * to setup a web application and configure a callback URL to receive the
     * refresh token, or configure using the builtin callback at
     * https://login.salesforce.com/services/oauth2/success or
     * https://test.salesforce.com/services/oauth2/success and then retrive the
     * refresh_token from the URL at the end of the flow. Note that in
     * development organizations Salesforce allows hosting the callback web
     * application at localhost.
     */
    private String refreshToken;
    /**
     * SSL parameters to use, see SSLContextParameters class for all available
     * options. The option is a
     * org.apache.camel.support.jsse.SSLContextParameters type.
     */
    private String sslContextParameters;
    /**
     * Enable usage of global SSL context parameters
     */
    private Boolean useGlobalSslContextParameters = false;
    /**
     * Username used in OAuth flow to gain access to access token. It's easy to
     * get started with password OAuth flow, but in general one should avoid it
     * as it is deemed less secure than other flows.
     */
    private String userName;

    public String getApexMethod() {
        return apexMethod;
    }

    public void setApexMethod(String apexMethod) {
        this.apexMethod = apexMethod;
    }

    public Map<String, Object> getApexQueryParams() {
        return apexQueryParams;
    }

    public void setApexQueryParams(Map<String, Object> apexQueryParams) {
        this.apexQueryParams = apexQueryParams;
    }

    public String getApexUrl() {
        return apexUrl;
    }

    public void setApexUrl(String apexUrl) {
        this.apexUrl = apexUrl;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public Long getBackoffIncrement() {
        return backoffIncrement;
    }

    public void setBackoffIncrement(Long backoffIncrement) {
        this.backoffIncrement = backoffIncrement;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public Long getDefaultReplayId() {
        return defaultReplayId;
    }

    public void setDefaultReplayId(Long defaultReplayId) {
        this.defaultReplayId = defaultReplayId;
    }

    public PayloadFormat getFormat() {
        return format;
    }

    public void setFormat(PayloadFormat format) {
        this.format = format;
    }

    public String getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(String httpClient) {
        this.httpClient = httpClient;
    }

    public Long getHttpClientConnectionTimeout() {
        return httpClientConnectionTimeout;
    }

    public void setHttpClientConnectionTimeout(Long httpClientConnectionTimeout) {
        this.httpClientConnectionTimeout = httpClientConnectionTimeout;
    }

    public Long getHttpClientIdleTimeout() {
        return httpClientIdleTimeout;
    }

    public void setHttpClientIdleTimeout(Long httpClientIdleTimeout) {
        this.httpClientIdleTimeout = httpClientIdleTimeout;
    }

    public Integer getHttpMaxContentLength() {
        return httpMaxContentLength;
    }

    public void setHttpMaxContentLength(Integer httpMaxContentLength) {
        this.httpMaxContentLength = httpMaxContentLength;
    }

    public Boolean getIncludeDetails() {
        return includeDetails;
    }

    public void setIncludeDetails(Boolean includeDetails) {
        this.includeDetails = includeDetails;
    }

    public Map<String, Long> getInitialReplayIdMap() {
        return initialReplayIdMap;
    }

    public void setInitialReplayIdMap(Map<String, Long> initialReplayIdMap) {
        this.initialReplayIdMap = initialReplayIdMap;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Long getMaxBackoff() {
        return maxBackoff;
    }

    public void setMaxBackoff(Long maxBackoff) {
        this.maxBackoff = maxBackoff;
    }

    public NotFoundBehaviour getNotFoundBehaviour() {
        return notFoundBehaviour;
    }

    public void setNotFoundBehaviour(NotFoundBehaviour notFoundBehaviour) {
        this.notFoundBehaviour = notFoundBehaviour;
    }

    public NotifyForFieldsEnum getNotifyForFields() {
        return notifyForFields;
    }

    public void setNotifyForFields(NotifyForFieldsEnum notifyForFields) {
        this.notifyForFields = notifyForFields;
    }

    public Boolean getNotifyForOperationCreate() {
        return notifyForOperationCreate;
    }

    public void setNotifyForOperationCreate(Boolean notifyForOperationCreate) {
        this.notifyForOperationCreate = notifyForOperationCreate;
    }

    public Boolean getNotifyForOperationDelete() {
        return notifyForOperationDelete;
    }

    public void setNotifyForOperationDelete(Boolean notifyForOperationDelete) {
        this.notifyForOperationDelete = notifyForOperationDelete;
    }

    public NotifyForOperationsEnum getNotifyForOperations() {
        return notifyForOperations;
    }

    public void setNotifyForOperations(
            NotifyForOperationsEnum notifyForOperations) {
        this.notifyForOperations = notifyForOperations;
    }

    public Boolean getNotifyForOperationUndelete() {
        return notifyForOperationUndelete;
    }

    public void setNotifyForOperationUndelete(Boolean notifyForOperationUndelete) {
        this.notifyForOperationUndelete = notifyForOperationUndelete;
    }

    public Boolean getNotifyForOperationUpdate() {
        return notifyForOperationUpdate;
    }

    public void setNotifyForOperationUpdate(Boolean notifyForOperationUpdate) {
        this.notifyForOperationUpdate = notifyForOperationUpdate;
    }

    public String getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(String objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String[] getPackages() {
        return packages;
    }

    public void setPackages(String[] packages) {
        this.packages = packages;
    }

    public Boolean getRawPayload() {
        return rawPayload;
    }

    public void setRawPayload(Boolean rawPayload) {
        this.rawPayload = rawPayload;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportMetadata() {
        return reportMetadata;
    }

    public void setReportMetadata(String reportMetadata) {
        this.reportMetadata = reportMetadata;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getSObjectBlobFieldName() {
        return sObjectBlobFieldName;
    }

    public void setSObjectBlobFieldName(String sObjectBlobFieldName) {
        this.sObjectBlobFieldName = sObjectBlobFieldName;
    }

    public String getSObjectClass() {
        return sObjectClass;
    }

    public void setSObjectClass(String sObjectClass) {
        this.sObjectClass = sObjectClass;
    }

    public String getSObjectFields() {
        return sObjectFields;
    }

    public void setSObjectFields(String sObjectFields) {
        this.sObjectFields = sObjectFields;
    }

    public String getSObjectId() {
        return sObjectId;
    }

    public void setSObjectId(String sObjectId) {
        this.sObjectId = sObjectId;
    }

    public String getSObjectIdName() {
        return sObjectIdName;
    }

    public void setSObjectIdName(String sObjectIdName) {
        this.sObjectIdName = sObjectIdName;
    }

    public String getSObjectIdValue() {
        return sObjectIdValue;
    }

    public void setSObjectIdValue(String sObjectIdValue) {
        this.sObjectIdValue = sObjectIdValue;
    }

    public String getSObjectName() {
        return sObjectName;
    }

    public void setSObjectName(String sObjectName) {
        this.sObjectName = sObjectName;
    }

    public String getSObjectQuery() {
        return sObjectQuery;
    }

    public void setSObjectQuery(String sObjectQuery) {
        this.sObjectQuery = sObjectQuery;
    }

    public String getSObjectSearch() {
        return sObjectSearch;
    }

    public void setSObjectSearch(String sObjectSearch) {
        this.sObjectSearch = sObjectSearch;
    }

    public Boolean getUpdateTopic() {
        return updateTopic;
    }

    public void setUpdateTopic(Boolean updateTopic) {
        this.updateTopic = updateTopic;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Map<String, Object> getHttpClientProperties() {
        return httpClientProperties;
    }

    public void setHttpClientProperties(Map<String, Object> httpClientProperties) {
        this.httpClientProperties = httpClientProperties;
    }

    public Map<String, Object> getLongPollingTransportProperties() {
        return longPollingTransportProperties;
    }

    public void setLongPollingTransportProperties(
            Map<String, Object> longPollingTransportProperties) {
        this.longPollingTransportProperties = longPollingTransportProperties;
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

    public Boolean getBasicPropertyBinding() {
        return basicPropertyBinding;
    }

    public void setBasicPropertyBinding(Boolean basicPropertyBinding) {
        this.basicPropertyBinding = basicPropertyBinding;
    }

    public Set<String> getHttpProxyExcludedAddresses() {
        return httpProxyExcludedAddresses;
    }

    public void setHttpProxyExcludedAddresses(
            Set<String> httpProxyExcludedAddresses) {
        this.httpProxyExcludedAddresses = httpProxyExcludedAddresses;
    }

    public String getHttpProxyHost() {
        return httpProxyHost;
    }

    public void setHttpProxyHost(String httpProxyHost) {
        this.httpProxyHost = httpProxyHost;
    }

    public Set<String> getHttpProxyIncludedAddresses() {
        return httpProxyIncludedAddresses;
    }

    public void setHttpProxyIncludedAddresses(
            Set<String> httpProxyIncludedAddresses) {
        this.httpProxyIncludedAddresses = httpProxyIncludedAddresses;
    }

    public Integer getHttpProxyPort() {
        return httpProxyPort;
    }

    public void setHttpProxyPort(Integer httpProxyPort) {
        this.httpProxyPort = httpProxyPort;
    }

    public Boolean getHttpProxySocks4() {
        return httpProxySocks4;
    }

    public void setHttpProxySocks4(Boolean httpProxySocks4) {
        this.httpProxySocks4 = httpProxySocks4;
    }

    public AuthenticationType getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(AuthenticationType authenticationType) {
        this.authenticationType = authenticationType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getHttpProxyAuthUri() {
        return httpProxyAuthUri;
    }

    public void setHttpProxyAuthUri(String httpProxyAuthUri) {
        this.httpProxyAuthUri = httpProxyAuthUri;
    }

    public String getHttpProxyPassword() {
        return httpProxyPassword;
    }

    public void setHttpProxyPassword(String httpProxyPassword) {
        this.httpProxyPassword = httpProxyPassword;
    }

    public String getHttpProxyRealm() {
        return httpProxyRealm;
    }

    public void setHttpProxyRealm(String httpProxyRealm) {
        this.httpProxyRealm = httpProxyRealm;
    }

    public Boolean getHttpProxySecure() {
        return httpProxySecure;
    }

    public void setHttpProxySecure(Boolean httpProxySecure) {
        this.httpProxySecure = httpProxySecure;
    }

    public Boolean getHttpProxyUseDigestAuth() {
        return httpProxyUseDigestAuth;
    }

    public void setHttpProxyUseDigestAuth(Boolean httpProxyUseDigestAuth) {
        this.httpProxyUseDigestAuth = httpProxyUseDigestAuth;
    }

    public String getHttpProxyUsername() {
        return httpProxyUsername;
    }

    public void setHttpProxyUsername(String httpProxyUsername) {
        this.httpProxyUsername = httpProxyUsername;
    }

    public String getInstanceUrl() {
        return instanceUrl;
    }

    public void setInstanceUrl(String instanceUrl) {
        this.instanceUrl = instanceUrl;
    }

    public String getKeystore() {
        return keystore;
    }

    public void setKeystore(String keystore) {
        this.keystore = keystore;
    }

    public Boolean getLazyLogin() {
        return lazyLogin;
    }

    public void setLazyLogin(Boolean lazyLogin) {
        this.lazyLogin = lazyLogin;
    }

    public String getLoginConfig() {
        return loginConfig;
    }

    public void setLoginConfig(String loginConfig) {
        this.loginConfig = loginConfig;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getSslContextParameters() {
        return sslContextParameters;
    }

    public void setSslContextParameters(String sslContextParameters) {
        this.sslContextParameters = sslContextParameters;
    }

    public Boolean getUseGlobalSslContextParameters() {
        return useGlobalSslContextParameters;
    }

    public void setUseGlobalSslContextParameters(
            Boolean useGlobalSslContextParameters) {
        this.useGlobalSslContextParameters = useGlobalSslContextParameters;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}