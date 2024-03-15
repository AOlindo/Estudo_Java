package br.com.olindo.estoquelivraria.exceptions;

public class Error {

	private Long timestamp;
	private Integer status;
	private String msg;
	private String path;

	public Error(Long timestamp, Integer status, String msg, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.msg = msg;
		this.path = path;

	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}