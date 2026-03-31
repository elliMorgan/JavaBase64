package src;
import java.util.Base64;


class B64Encoding


{


	private String message;


	public B64Encoding()


	{


		this.message = "";


	}  //  public B64Encoding() 


	public B64Encoding(String message)


	{


		this.message = message;


	}  //  public B64Encoding(String message)


	public void update(String addition)


	{


		this.message+=addition;


	}  //  public void update(String addition)


	public void clear()


	{


		this.message = "";


	}  //  public void clear()


	public String encode()


	{


		return Base64.getEncoder().encodeToString(this.message.getBytes());


	}  //  public String encode()


	public String decode()


	{


		return new String(Base64.getDecoder().decode(this.message.getBytes()));


	}  //  public String encode()


}  //  class Encoding

