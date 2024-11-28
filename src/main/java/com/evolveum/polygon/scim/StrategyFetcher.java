/*
 * Copyright (c) 2016 Evolveum
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.evolveum.polygon.scim;
import org.identityconnectors.common.logging.Log;

/**
 * @author Macik
 *
 *         Methods used to pick the right strategy depending form the connected
 *         service.
 *
 */
public class StrategyFetcher {

	private static final String SALESFORCE = "salesforce";
	private static final String SLACK = "slack";
	private static final Log LOG = Log.getLog(StrategyFetcher.class);

	public HandlingStrategy fetchStrategy(String providerName) {
		LOG.info("Fetching strategy for provider: {0}", providerName);

		HandlingStrategy strategy;

		if (SALESFORCE.equals(providerName)) {
			LOG.info("Salesforce provider detected");
			strategy = new SalesforceHandlingStrategy();
		} else if (SLACK.equals(providerName)) {
			LOG.info("Slack provider detected");
			strategy = new SlackHandlingStrategy();
		} else {
			LOG.info("Standard SCIM Handling Strategy used");
			strategy = new StandardScimHandlingStrategy();
		}

		return strategy;
	}

}
