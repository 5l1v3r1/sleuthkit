/*
 * Sleuth Kit Data Model
 *
 * Copyright 2015 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
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
package org.sleuthkit.datamodel.timeline.filters;

import java.util.Objects;
import org.sleuthkit.datamodel.TagName;

/**
 * Filter for an individual TagName
 */
public class TagNameFilter extends AbstractFilter {

	private final TagName tagName;

	public TagNameFilter(TagName tagName) {
		this.tagName = tagName;
		setSelected(Boolean.TRUE);
	}

	public TagName getTagName() {
		return tagName;
	}

	@Override
	synchronized public TagNameFilter copyOf() {
		TagNameFilter filterCopy = new TagNameFilter(getTagName());
		filterCopy.setSelected(isSelected());
		filterCopy.setDisabled(isDisabled());
		return filterCopy;
	}

	@Override
	public String getDisplayName() {
		return tagName.getDisplayName();
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 53 * hash + Objects.hashCode(this.tagName);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final TagNameFilter other = (TagNameFilter) obj;
		if (!Objects.equals(this.tagName, other.tagName)) {
			return false;
		}

		return isSelected() == other.isSelected();
	}
}
