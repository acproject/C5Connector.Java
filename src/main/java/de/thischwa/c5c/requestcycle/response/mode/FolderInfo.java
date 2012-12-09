/*
 * C5Connector.Java - The Java backend for the filemanager of corefive.
 * It's a bridge between the filemanager and a storage backend and 
 * works like a transparent VFS or proxy.
 * Copyright (C) Thilo Schwarz
 * 
 * == BEGIN LICENSE ==
 * 
 * Licensed under the terms of any of the following licenses at your
 * choice:
 * 
 *  - GNU General Public License Version 2 or later (the "GPL")
 *    http://www.gnu.org/licenses/gpl.html
 * 
 *  - GNU Lesser General Public License Version 2.1 or later (the "LGPL")
 *    http://www.gnu.org/licenses/lgpl.html
 * 
 *  - Mozilla Public License Version 1.1 or later (the "MPL")
 *    http://www.mozilla.org/MPL/MPL-1.1.html
 * 
 * == END LICENSE ==
 */
package de.thischwa.c5c.requestcycle.response.mode;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.thischwa.c5c.requestcycle.response.Response;

/**
 * Holds the data of a FolderInfo response.
 */
public final class FolderInfo extends Response {

	private Map<String, FileInfo> folderItems;

	FolderInfo() {
		folderItems = new HashMap<String, FileInfo>();
	}

	void add(final FileInfo fileInfo) {
		folderItems.put(fileInfo.getPath(), fileInfo);
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		// overridden because it's just a collection of FolderInfo
		try {
			String jsonStr = mapper.writeValueAsString(folderItems);
			return jsonStr;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
