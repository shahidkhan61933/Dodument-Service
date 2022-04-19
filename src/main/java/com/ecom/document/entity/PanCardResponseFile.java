package com.ecom.document.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PanCardResponseFile {
	private String name;
	private String url;
	private String type;
	private long size;

	public PanCardResponseFile(String name, String url, String type) {
		this.name = name;
		this.url = url;
		this.type = type;
		this.size = size;
	}

}
