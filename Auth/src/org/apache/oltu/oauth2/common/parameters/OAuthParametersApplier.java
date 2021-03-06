/**
 *       Copyright 2010 Newcastle University
 *
 *          http://research.ncl.ac.uk/smart/
 *
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

package org.apache.oltu.oauth2.common.parameters;

import java.util.Map;

import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthMessage;

/**
 * Applies given org.apache.oltu.oauth2.parameters to the OAuth org.apache.oltu.oauth2.message.
 * Provided implementations include OAuth org.apache.oltu.oauth2.parameters in one of those:
 * <ul>
 * <li>HTTP org.apache.oltu.oauth2.as.request URI Query</li>
 * <li>HTTP org.apache.oltu.oauth2.as.request entity-body with application/x-www-form-urlencoded encoding</li>
 * <li>HTTP org.apache.oltu.oauth2.as.request entity-body with application/json encoding</li>
 * <li>HTTP org.apache.oltu.oauth2.as.request Authorization/WWW-Authenticate header</li>
 * </ul>
 * <p/>
 * Additional implementations can be provided.
 *
 *
 *
 *
 */
public interface OAuthParametersApplier {

    OAuthMessage applyOAuthParameters(OAuthMessage message, Map<String, Object> params) throws
        OAuthSystemException;
}
