/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package co.elastic.clients.elasticsearch.watcher;

import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.endpoints.SimpleEndpoint;
import co.elastic.clients.util.ApiTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

// typedef: watcher.ack_watch.Request

/**
 * Acknowledges a watch, manually throttling the execution of the watch's
 * actions.
 * 
 * @see <a href="../doc-files/api-spec.html#watcher.ack_watch.Request">API
 *      specification</a>
 */

public class AckWatchRequest extends RequestBase {
	private final List<String> actionId;

	private final String watchId;

	// ---------------------------------------------------------------------------------------------

	private AckWatchRequest(Builder builder) {

		this.actionId = ApiTypeHelper.unmodifiable(builder.actionId);
		this.watchId = ApiTypeHelper.requireNonNull(builder.watchId, this, "watchId");

	}

	public static AckWatchRequest of(Function<Builder, ObjectBuilder<AckWatchRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * A comma-separated list of the action ids to be acked
	 * <p>
	 * API name: {@code action_id}
	 */
	public final List<String> actionId() {
		return this.actionId;
	}

	/**
	 * Required - Watch ID
	 * <p>
	 * API name: {@code watch_id}
	 */
	public final String watchId() {
		return this.watchId;
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link AckWatchRequest}.
	 */

	public static class Builder extends RequestBase.AbstractBuilder<Builder> implements ObjectBuilder<AckWatchRequest> {
		@Nullable
		private List<String> actionId;

		private String watchId;

		/**
		 * A comma-separated list of the action ids to be acked
		 * <p>
		 * API name: {@code action_id}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>actionId</code>.
		 */
		public final Builder actionId(List<String> list) {
			this.actionId = _listAddAll(this.actionId, list);
			return this;
		}

		/**
		 * A comma-separated list of the action ids to be acked
		 * <p>
		 * API name: {@code action_id}
		 * <p>
		 * Adds one or more values to <code>actionId</code>.
		 */
		public final Builder actionId(String value, String... values) {
			this.actionId = _listAdd(this.actionId, value, values);
			return this;
		}

		/**
		 * Required - Watch ID
		 * <p>
		 * API name: {@code watch_id}
		 */
		public final Builder watchId(String value) {
			this.watchId = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link AckWatchRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public AckWatchRequest build() {
			_checkSingleUse();

			return new AckWatchRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code watcher.ack_watch}".
	 */
	public static final Endpoint<AckWatchRequest, AckWatchResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/watcher.ack_watch",

			// Request method
			request -> {
				return "PUT";

			},

			// Request path
			request -> {
				final int _watchId = 1 << 0;
				final int _actionId = 1 << 1;

				int propsSet = 0;

				propsSet |= _watchId;
				if (ApiTypeHelper.isDefined(request.actionId()))
					propsSet |= _actionId;

				if (propsSet == (_watchId)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_watcher");
					buf.append("/watch");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.watchId, buf);
					buf.append("/_ack");
					return buf.toString();
				}
				if (propsSet == (_watchId | _actionId)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_watcher");
					buf.append("/watch");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.watchId, buf);
					buf.append("/_ack");
					buf.append("/");
					SimpleEndpoint.pathEncode(request.actionId.stream().map(v -> v).collect(Collectors.joining(",")),
							buf);
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Request parameters
			request -> {
				return Collections.emptyMap();

			}, SimpleEndpoint.emptyMap(), false, AckWatchResponse._DESERIALIZER);
}
