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
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.component.salesforce.AuthenticationType;
import org.apache.camel.component.salesforce.NotFoundBehaviour;
import org.apache.camel.component.salesforce.SalesforceComponent;
import org.apache.camel.component.salesforce.SalesforceEndpointConfig;
import org.apache.camel.component.salesforce.SalesforceHttpClient;
import org.apache.camel.component.salesforce.SalesforceLoginConfig;
import org.apache.camel.component.salesforce.api.dto.analytics.reports.ReportMetadata;
import org.apache.camel.component.salesforce.api.dto.bulk.ContentType;
import org.apache.camel.component.salesforce.internal.PayloadFormat;
import org.apache.camel.component.salesforce.internal.dto.NotifyForFieldsEnum;
import org.apache.camel.component.salesforce.internal.dto.NotifyForOperationsEnum;
import org.apache.camel.spring.boot.ComponentConfigurationPropertiesCommon;
import org.apache.camel.support.jsse.KeyStoreParameters;
import org.apache.camel.support.jsse.SSLContextParameters;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Communicate with Salesforce using Java DTOs.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
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
     * Salesforce API version.
     */
    private String apiVersion = "56.0";
    /**
     * Backoff interval increment for Streaming connection restart attempts for
     * failures beyond CometD auto-reconnect. The option is a long type.
     */
    private Long backoffIncrement = 1000L;
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
    private Long defaultReplayId = -1L;
    /**
     * ReplayId to fall back to after an Invalid Replay Id response
     */
    private Long fallBackReplayId = -1L;
    /**
     * Payload format to use for Salesforce API calls, either JSON or XML,
     * defaults to JSON. As of Camel 3.12, this option only applies to the Raw
     * operation.
     */
    private PayloadFormat format;
    /**
     * Custom Jetty Http Client to use to connect to Salesforce. The option is a
     * org.apache.camel.component.salesforce.SalesforceHttpClient type.
     */
    private SalesforceHttpClient httpClient;
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
     * HTTP request buffer size. May need to be increased for large SOQL
     * queries.
     */
    private Integer httpRequestBufferSize = 8192;
    /**
     * Timeout value for HTTP requests.
     */
    private Long httpRequestTimeout = 60000L;
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
     * Locator provided by salesforce Bulk 2.0 API for use in getting results
     * for a Query job.
     */
    private String locator;
    /**
     * Maximum backoff interval for Streaming connection restart attempts for
     * failures beyond CometD auto-reconnect. The option is a long type.
     */
    private Long maxBackoff = 30000L;
    /**
     * The maximum number of records to retrieve per set of results for a Bulk
     * 2.0 Query. The request is still subject to the size limits. If you are
     * working with a very large number of query results, you may experience a
     * timeout before receiving all the data from Salesforce. To prevent a
     * timeout, specify the maximum number of records your client is expecting
     * to receive in the maxRecords parameter. This splits the results into
     * smaller sets with this value as the maximum size.
     */
    private Integer maxRecords;
    /**
     * Sets the behaviour of 404 not found status received from Salesforce API.
     * Should the body be set to NULL NotFoundBehaviour#NULL or should a
     * exception be signaled on the exchange NotFoundBehaviour#EXCEPTION - the
     * default.
     */
    private NotFoundBehaviour notFoundBehaviour = NotFoundBehaviour.EXCEPTION;
    /**
     * Notify for fields, options are ALL, REFERENCED, SELECT, WHERE
     */
    private NotifyForFieldsEnum notifyForFields;
    /**
     * Notify for create operation, defaults to false (API version &gt;= 29.0)
     */
    private Boolean notifyForOperationCreate;
    /**
     * Notify for delete operation, defaults to false (API version &gt;= 29.0)
     */
    private Boolean notifyForOperationDelete;
    /**
     * Notify for operations, options are ALL, CREATE, EXTENDED, UPDATE (API
     * version &lt; 29.0)
     */
    private NotifyForOperationsEnum notifyForOperations;
    /**
     * Notify for un-delete operation, defaults to false (API version &gt;=
     * 29.0)
     */
    private Boolean notifyForOperationUndelete;
    /**
     * Notify for update operation, defaults to false (API version &gt;= 29.0)
     */
    private Boolean notifyForOperationUpdate;
    /**
     * Custom Jackson ObjectMapper to use when serializing/deserializing
     * Salesforce objects. The option is a
     * com.fasterxml.jackson.databind.ObjectMapper type.
     */
    private ObjectMapper objectMapper;
    /**
     * In what packages are the generated DTO classes. Typically the classes
     * would be generated using camel-salesforce-maven-plugin. Set it if using
     * the generated DTOs to gain the benefit of using short SObject names in
     * parameters/header values. Multiple packages can be separated by comma.
     */
    private String packages;
    /**
     * Use PK Chunking. Only for use in original Bulk API. Bulk 2.0 API performs
     * PK chunking automatically, if necessary.
     */
    private Boolean pkChunking;
    /**
     * Chunk size for use with PK Chunking. If unspecified, salesforce default
     * is 100,000. Maximum size is 250,000.
     */
    private Integer pkChunkingChunkSize;
    /**
     * Specifies the parent object when you're enabling PK chunking for queries
     * on sharing objects. The chunks are based on the parent object's records
     * rather than the sharing object's records. For example, when querying on
     * AccountShare, specify Account as the parent object. PK chunking is
     * supported for sharing objects as long as the parent object is supported.
     */
    private String pkChunkingParent;
    /**
     * Specifies the 15-character or 18-character record ID to be used as the
     * lower boundary for the first chunk. Use this parameter to specify a
     * starting ID when restarting a job that failed between batches.
     */
    private String pkChunkingStartRow;
    /**
     * Query Locator provided by salesforce for use when a query results in more
     * records than can be retrieved in a single call. Use this value in a
     * subsequent call to retrieve additional records.
     */
    private String queryLocator;
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
    private ReportMetadata reportMetadata;
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
     * If true, streams SOQL query result and transparently handles subsequent
     * requests if there are multiple pages. Otherwise, results are returned one
     * page at a time.
     */
    private Boolean streamQueryResult = false;
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
    private SalesforceEndpointConfig config;
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
     * Maximum size of the thread pool used to handle HTTP responses.
     */
    private Integer workerPoolMaxSize = 20;
    /**
     * Size of the thread pool used to handle HTTP responses.
     */
    private Integer workerPoolSize = 10;
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
     * Composite API option to indicate to rollback all records if any are not
     * successful.
     */
    private Boolean allOrNone = false;
    /**
     * APEX method URL
     */
    private String apexUrl;
    /**
     * Composite (raw) method.
     */
    private String compositeMethod;
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
     * Comma separated list of message headers to include as HTTP parameters for
     * Raw operation.
     */
    private String rawHttpHeaders;
    /**
     * HTTP method to use for the Raw operation
     */
    private String rawMethod;
    /**
     * The portion of the endpoint URL after the domain name. E.g.,
     * '/services/data/v52.0/sobjects/Account/'
     */
    private String rawPath;
    /**
     * Comma separated list of message headers to include as query parameters
     * for Raw operation. Do not url-encode values as this will be done
     * automatically.
     */
    private String rawQueryParameters;
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
     * Value to use for the Audience claim (aud) when using OAuth JWT flow. If
     * not set, the login URL will be used, which is appropriate in most cases.
     */
    private String jwtAudience;
    /**
     * KeyStore parameters to use in OAuth JWT flow. The KeyStore should contain
     * only one entry with private key and certificate. Salesforce does not
     * verify the certificate chain, so this can easily be a selfsigned
     * certificate. Make sure that you upload the certificate to the
     * corresponding connected app. The option is a
     * org.apache.camel.support.jsse.KeyStoreParameters type.
     */
    private KeyStoreParameters keystore;
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
    private SalesforceLoginConfig loginConfig;
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
    private SSLContextParameters sslContextParameters;
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

    public Long getFallBackReplayId() {
        return fallBackReplayId;
    }

    public void setFallBackReplayId(Long fallBackReplayId) {
        this.fallBackReplayId = fallBackReplayId;
    }

    public PayloadFormat getFormat() {
        return format;
    }

    public void setFormat(PayloadFormat format) {
        this.format = format;
    }

    public SalesforceHttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(SalesforceHttpClient httpClient) {
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

    public Integer getHttpRequestBufferSize() {
        return httpRequestBufferSize;
    }

    public void setHttpRequestBufferSize(Integer httpRequestBufferSize) {
        this.httpRequestBufferSize = httpRequestBufferSize;
    }

    public Long getHttpRequestTimeout() {
        return httpRequestTimeout;
    }

    public void setHttpRequestTimeout(Long httpRequestTimeout) {
        this.httpRequestTimeout = httpRequestTimeout;
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

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public Long getMaxBackoff() {
        return maxBackoff;
    }

    public void setMaxBackoff(Long maxBackoff) {
        this.maxBackoff = maxBackoff;
    }

    public Integer getMaxRecords() {
        return maxRecords;
    }

    public void setMaxRecords(Integer maxRecords) {
        this.maxRecords = maxRecords;
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

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public Boolean getPkChunking() {
        return pkChunking;
    }

    public void setPkChunking(Boolean pkChunking) {
        this.pkChunking = pkChunking;
    }

    public Integer getPkChunkingChunkSize() {
        return pkChunkingChunkSize;
    }

    public void setPkChunkingChunkSize(Integer pkChunkingChunkSize) {
        this.pkChunkingChunkSize = pkChunkingChunkSize;
    }

    public String getPkChunkingParent() {
        return pkChunkingParent;
    }

    public void setPkChunkingParent(String pkChunkingParent) {
        this.pkChunkingParent = pkChunkingParent;
    }

    public String getPkChunkingStartRow() {
        return pkChunkingStartRow;
    }

    public void setPkChunkingStartRow(String pkChunkingStartRow) {
        this.pkChunkingStartRow = pkChunkingStartRow;
    }

    public String getQueryLocator() {
        return queryLocator;
    }

    public void setQueryLocator(String queryLocator) {
        this.queryLocator = queryLocator;
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

    public ReportMetadata getReportMetadata() {
        return reportMetadata;
    }

    public void setReportMetadata(ReportMetadata reportMetadata) {
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

    public Boolean getStreamQueryResult() {
        return streamQueryResult;
    }

    public void setStreamQueryResult(Boolean streamQueryResult) {
        this.streamQueryResult = streamQueryResult;
    }

    public Boolean getUpdateTopic() {
        return updateTopic;
    }

    public void setUpdateTopic(Boolean updateTopic) {
        this.updateTopic = updateTopic;
    }

    public SalesforceEndpointConfig getConfig() {
        return config;
    }

    public void setConfig(SalesforceEndpointConfig config) {
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

    public Integer getWorkerPoolMaxSize() {
        return workerPoolMaxSize;
    }

    public void setWorkerPoolMaxSize(Integer workerPoolMaxSize) {
        this.workerPoolMaxSize = workerPoolMaxSize;
    }

    public Integer getWorkerPoolSize() {
        return workerPoolSize;
    }

    public void setWorkerPoolSize(Integer workerPoolSize) {
        this.workerPoolSize = workerPoolSize;
    }

    public Boolean getBridgeErrorHandler() {
        return bridgeErrorHandler;
    }

    public void setBridgeErrorHandler(Boolean bridgeErrorHandler) {
        this.bridgeErrorHandler = bridgeErrorHandler;
    }

    public Boolean getAllOrNone() {
        return allOrNone;
    }

    public void setAllOrNone(Boolean allOrNone) {
        this.allOrNone = allOrNone;
    }

    public String getApexUrl() {
        return apexUrl;
    }

    public void setApexUrl(String apexUrl) {
        this.apexUrl = apexUrl;
    }

    public String getCompositeMethod() {
        return compositeMethod;
    }

    public void setCompositeMethod(String compositeMethod) {
        this.compositeMethod = compositeMethod;
    }

    public Boolean getLazyStartProducer() {
        return lazyStartProducer;
    }

    public void setLazyStartProducer(Boolean lazyStartProducer) {
        this.lazyStartProducer = lazyStartProducer;
    }

    public String getRawHttpHeaders() {
        return rawHttpHeaders;
    }

    public void setRawHttpHeaders(String rawHttpHeaders) {
        this.rawHttpHeaders = rawHttpHeaders;
    }

    public String getRawMethod() {
        return rawMethod;
    }

    public void setRawMethod(String rawMethod) {
        this.rawMethod = rawMethod;
    }

    public String getRawPath() {
        return rawPath;
    }

    public void setRawPath(String rawPath) {
        this.rawPath = rawPath;
    }

    public String getRawQueryParameters() {
        return rawQueryParameters;
    }

    public void setRawQueryParameters(String rawQueryParameters) {
        this.rawQueryParameters = rawQueryParameters;
    }

    public Boolean getAutowiredEnabled() {
        return autowiredEnabled;
    }

    public void setAutowiredEnabled(Boolean autowiredEnabled) {
        this.autowiredEnabled = autowiredEnabled;
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

    public String getJwtAudience() {
        return jwtAudience;
    }

    public void setJwtAudience(String jwtAudience) {
        this.jwtAudience = jwtAudience;
    }

    public KeyStoreParameters getKeystore() {
        return keystore;
    }

    public void setKeystore(KeyStoreParameters keystore) {
        this.keystore = keystore;
    }

    public Boolean getLazyLogin() {
        return lazyLogin;
    }

    public void setLazyLogin(Boolean lazyLogin) {
        this.lazyLogin = lazyLogin;
    }

    public SalesforceLoginConfig getLoginConfig() {
        return loginConfig;
    }

    public void setLoginConfig(SalesforceLoginConfig loginConfig) {
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

    public SSLContextParameters getSslContextParameters() {
        return sslContextParameters;
    }

    public void setSslContextParameters(
            SSLContextParameters sslContextParameters) {
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