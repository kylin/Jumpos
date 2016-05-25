package com.june.common.model.input;

import com.june.implemented.common.application.Process;

public abstract class AbstractInput implements Input {

	public AbstractInput() {

	}

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	protected Process process;

}
