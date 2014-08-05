/*
 * Copyright (C) 2007 - 2014 Hyperweb2 All rights reserved.
 * GNU General Public License version 3; see www.hyperweb2.com/terms/
 */

package hw2.java.library.common;

/**
 * Custom object class for Canonical methods
 *
 */
public class MyObject {
	@Override
	public boolean equals(Object obj) {
		return obj!=null && obj.getClass()==this.getClass();
	}
}
