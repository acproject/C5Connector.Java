/*
 * C5Connector.Java - The Java backend for the filemanager of corefive.
 * It's a bridge between the filemanager and a storage backend and 
 * works like a transparent VFS or proxy.
 * Copyright (C) Thilo Schwarz
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package codes.thischwa.c5c.util;

import static org.junit.Assert.*;

import org.junit.Test;

import codes.thischwa.c5c.util.VirtualFile;

public class VirtualFileTest {

	@Test
	public void testFile01() {
		VirtualFile vf = new VirtualFile("/tmp/folder/img.png", false, false);
		assertEquals("/tmp/folder/", vf.getFolder());
		assertEquals("img.png", vf.getName());
		assertEquals("png", vf.getExtension());
		assertEquals(VirtualFile.Type.file, vf.getType());
	}

	@Test
	public void testFile02() {
		VirtualFile vf = new VirtualFile("/img.png", false, false);
		assertEquals("/", vf.getFolder());
		assertEquals("img.png", vf.getName());
		assertEquals("png", vf.getExtension());
		assertEquals(VirtualFile.Type.file, vf.getType());
	}

	@Test
	public void testFile03() {
		VirtualFile vf = new VirtualFile("img.png", false, false);
		assertEquals("/", vf.getFolder());
		assertEquals("img.png", vf.getName());
		assertEquals("png", vf.getExtension());
		assertEquals(VirtualFile.Type.file, vf.getType());
	}

	@Test
	public void testDir01() {
		VirtualFile vf = new VirtualFile("/tmp/folder/", true, false);
		assertEquals("/tmp/", vf.getFolder());
		assertEquals("folder", vf.getName());
		assertNull(vf.getExtension());
		assertEquals(VirtualFile.Type.directory, vf.getType());
	}
	
	@Test
	public void testDir02() {
		VirtualFile vf = new VirtualFile("/tmp/folder", true, false);
		assertEquals("/tmp/", vf.getFolder());
		assertEquals("folder", vf.getName());
		assertNull(vf.getExtension());
		assertEquals(VirtualFile.Type.directory, vf.getType());
	}
	
	@Test
	public void testDir03() {
		VirtualFile vf = new VirtualFile("/tmp/folder.sub", true, true);
		assertEquals("/tmp/", vf.getFolder());
		assertEquals("folder.sub", vf.getName());
		assertNull(vf.getExtension());
		assertEquals(VirtualFile.Type.directory, vf.getType());
		assertTrue(vf.isProtect());
	}
}
