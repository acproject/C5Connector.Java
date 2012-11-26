/*
 * C5Connector.Java - The Java backend for the filemanager of corefive.
 * It provides a simple object for creating an editor instance.
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
package de.thischwa.c5c.requestcycle;

import javax.servlet.http.HttpServletRequest;

/**
 * An interface for user action control. In particular, this interface gives
 * you fine-grained control over the File Browser commands.
 * <p>
 * <strong>Note:</strong> You are free to implement this interface the way you
 * need it, in other words your return values can be global, regardless of the
 * request, or on a per-request basis.
 * </p>
 */
public interface C5UserAction {

	/**
	 * Checks if FILE upload is enabled/allowed.
	 * 
	 * @param request
	 *            current user request instance
	 * @return {@code true} if FILE upload is enabled/allowed, else {@code
	 *         false}
	 */
	public boolean isFileUploadEnabled(final HttpServletRequest request);
	
	/**
	 * Checks if folder creation is enabled/allowed. 
	 * 
	 * @param request
	 *            current user request instance
	 * @return {@code true} if folder creation is enabled/allowed, else {@code
	 *         false}
	 */
	public boolean isCreateFolderEnabled(final HttpServletRequest request);

}