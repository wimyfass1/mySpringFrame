package book30.ch06._3._4.learning;

public class Message {
	String text;
	
	private Message(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public static Message newMessage(String text) {
		return new Message(text);
	}
}
