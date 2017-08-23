package com.jvmtest;

import java.util.ArrayList;

public class HeapOOM {

	static class OOMObject {

	}

	public static void main(String[] args) {

		ArrayList<OOMObject> list = new ArrayList<OOMObject>();

		while (true) {

			list.add(new OOMObject());

		}

	}

}
