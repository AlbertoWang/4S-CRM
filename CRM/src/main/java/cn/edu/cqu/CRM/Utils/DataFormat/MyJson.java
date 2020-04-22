package cn.edu.cqu.CRM.Utils.DataFormat;

import java.util.Date;

public class MyJson {

	private boolean status;
	private Object data;
	private String message;
	private Date timestamp;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public MyJson(boolean status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.timestamp = new Date();
	}

	public MyJson(Object data) {
		super();
		this.status = true;
		this.data = data;
		this.timestamp = new Date();
	}

	@Override
	public String toString() {
		return "MyJson [status=" + status + ", data=" + data + ", message=" + message + ", timestamp=" + timestamp
				+ "]";
	}

}
