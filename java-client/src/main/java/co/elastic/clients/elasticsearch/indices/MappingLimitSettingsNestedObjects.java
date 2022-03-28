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

package co.elastic.clients.elasticsearch.indices;

import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.util.ObjectBuilder;
import co.elastic.clients.util.WithJsonObjectBuilderBase;
import jakarta.json.stream.JsonGenerator;
import java.lang.Integer;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nullable;

// typedef: indices._types.MappingLimitSettingsNestedObjects

/**
 *
 * @see <a href=
 *      "../doc-files/api-spec.html#indices._types.MappingLimitSettingsNestedObjects">API
 *      specification</a>
 */
@JsonpDeserializable
public class MappingLimitSettingsNestedObjects implements JsonpSerializable {
	@Nullable
	private final Integer limit;

	// ---------------------------------------------------------------------------------------------

	private MappingLimitSettingsNestedObjects(Builder builder) {

		this.limit = builder.limit;

	}

	public static MappingLimitSettingsNestedObjects of(
			Function<Builder, ObjectBuilder<MappingLimitSettingsNestedObjects>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * The maximum number of nested JSON objects that a single document can contain
	 * across all nested types. This limit helps to prevent out of memory errors
	 * when a document contains too many nested objects.
	 * <p>
	 * API name: {@code limit}
	 */
	@Nullable
	public final Integer limit() {
		return this.limit;
	}

	/**
	 * Serialize this object to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartObject();
		serializeInternal(generator, mapper);
		generator.writeEnd();
	}

	protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {

		if (this.limit != null) {
			generator.writeKey("limit");
			generator.write(this.limit);

		}

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link MappingLimitSettingsNestedObjects}.
	 */

	public static class Builder extends WithJsonObjectBuilderBase<Builder>
			implements
				ObjectBuilder<MappingLimitSettingsNestedObjects> {
		@Nullable
		private Integer limit;

		/**
		 * The maximum number of nested JSON objects that a single document can contain
		 * across all nested types. This limit helps to prevent out of memory errors
		 * when a document contains too many nested objects.
		 * <p>
		 * API name: {@code limit}
		 */
		public final Builder limit(@Nullable Integer value) {
			this.limit = value;
			return this;
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link MappingLimitSettingsNestedObjects}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public MappingLimitSettingsNestedObjects build() {
			_checkSingleUse();

			return new MappingLimitSettingsNestedObjects(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json deserializer for {@link MappingLimitSettingsNestedObjects}
	 */
	public static final JsonpDeserializer<MappingLimitSettingsNestedObjects> _DESERIALIZER = ObjectBuilderDeserializer
			.lazy(Builder::new, MappingLimitSettingsNestedObjects::setupMappingLimitSettingsNestedObjectsDeserializer);

	protected static void setupMappingLimitSettingsNestedObjectsDeserializer(
			ObjectDeserializer<MappingLimitSettingsNestedObjects.Builder> op) {

		op.add(Builder::limit, JsonpDeserializer.integerDeserializer(), "limit");

	}

}
