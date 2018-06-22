package XMLWS.service.dto;

public class MessageDTO {

	private String sender;
	private String receipient;
	private String text;

	public MessageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceipient() {
		return receipient;
	}

	public void setReceipient(String receipient) {
		this.receipient = receipient;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MessageDTO(String sender, String receipient, String text) {
		super();
		this.sender = sender;
		this.receipient = receipient;
		this.text = text;
	}

}
