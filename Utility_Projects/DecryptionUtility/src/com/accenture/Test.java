package com.accenture;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Test 
{
//	2014-02-26 13:31:04
//	EID-UID-CSV-31102013
//	EID-UID-CSV-30112013
//	EID-UID-CSV-31122013
	
	public static void main(String[] args) {
		Path path = FileSystems.getDefault().getPath("C:/D/AudioFile");
		System.out.println(path.ge);
	}
}
