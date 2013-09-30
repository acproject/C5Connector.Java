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
 *  - GNU Lesser General Public License Version 3.0 or later (the "LGPL")
 *    http://www.gnu.org/licenses/lgpl-3.0.html
 * 
 *  - Mozilla Public License Version 2.0 or later (the "MPL")
 *    http://www.mozilla.org/MPL/2.0/
 * 
 * == END LICENSE ==
 */
package de.thischwa.c5c.resource.filemanager;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the type <code>options</code> of the JSON configuration of the filemanager. 
 */
public class Options {

	public enum FILE_SORTING {
		DEFAULT, NAME_ASC, NAME_DESC, TYPE_ASC, TYPE_DESC, MODIFIED_ASC, MODIFIED_DESC;
	};

	private String culture;
	private String lang;
	private String defaultViewMode;
	private boolean autoload;
	private boolean showFullPath;
	private boolean browseOnly;
	private boolean showConfirmation;
	private boolean showThumbs;
	private boolean generateThumbnails;
	private boolean searchBox;
	private boolean listFiles;
	private FILE_SORTING fileSorting;

	@JsonProperty("chars_only_latin")
	private boolean charsOnlyLatin;

	private String dateFormat;
	private boolean serverRoot;
	private String fileRoot;
	private boolean relPath;
	private boolean logger;
	private Set<String> plugins;

	Options() {
	}
	
	public String getCulture() {
		return culture;
	}

	public void setCulture(String culture) {
		this.culture = culture;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getDefaultViewMode() {
		return defaultViewMode;
	}

	public void setDefaultViewMode(String defaultViewMode) {
		this.defaultViewMode = defaultViewMode;
	}

	public boolean isAutoload() {
		return autoload;
	}

	public void setAutoload(boolean autoload) {
		this.autoload = autoload;
	}

	public boolean isShowFullPath() {
		return showFullPath;
	}

	public void setShowFullPath(boolean showFullPath) {
		this.showFullPath = showFullPath;
	}

	public boolean isBrowseOnly() {
		return browseOnly;
	}

	public void setBrowseOnly(boolean browseOnly) {
		this.browseOnly = browseOnly;
	}

	public boolean isShowConfirmation() {
		return showConfirmation;
	}

	public void setShowConfirmation(boolean showConfirmations) {
		this.showConfirmation = showConfirmations;
	}

	public boolean isShowThumbs() {
		return showThumbs;
	}

	public void setShowThumbs(boolean showThumbs) {
		this.showThumbs = showThumbs;
	}

	public boolean isGenerateThumbnails() {
		return generateThumbnails;
	}

	public void setGenerateThumbnails(boolean generateThumbnails) {
		this.generateThumbnails = generateThumbnails;
	}

	public boolean isSearchBox() {
		return searchBox;
	}

	public void setSearchBox(boolean searchBox) {
		this.searchBox = searchBox;
	}

	public boolean isListFiles() {
		return listFiles;
	}

	public void setListFiles(boolean listFiles) {
		this.listFiles = listFiles;
	}

	public FILE_SORTING getFileSorting() {
		return fileSorting;
	}

	public void setFileSorting(FILE_SORTING fileSorting) {
		this.fileSorting = fileSorting;
	}

	@JsonProperty("fileSorting")
	public void setFileSorting(String fsStr) {
		for(FILE_SORTING fs : FILE_SORTING.values()) {
			if(fs.toString().equalsIgnoreCase(fsStr)) {
				fileSorting = fs;
				return;
			}
		}
		throw new IllegalArgumentException(String.format("Unknown fileSorting value: %s", fsStr));
	}

	public boolean isCharsOnlyLatin() {
		return charsOnlyLatin;
	}

	public void setCharsOnlyLatin(boolean charsOnlyLatin) {
		this.charsOnlyLatin = charsOnlyLatin;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public boolean isServerRoot() {
		return serverRoot;
	}

	public void setServerRoot(boolean serverRoot) {
		this.serverRoot = serverRoot;
	}

	public String getFileRoot() {
		return fileRoot;
	}

	public void setFileRoot(String fileRoot) {
		this.fileRoot = fileRoot;
	}

	public boolean isRelPath() {
		return relPath;
	}

	public void setRelPath(boolean relPath) {
		this.relPath = relPath;
	}

	public boolean isLogger() {
		return logger;
	}

	public void setLogger(boolean logger) {
		this.logger = logger;
	}

	public Set<String> getPlugins() {
		return plugins;
	}

	public void setPlugins(Set<String> plugins) {
		this.plugins = plugins;
	}

}