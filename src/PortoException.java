
public class PortoException extends Exception
{
	private String messaggio;
	
	public PortoException(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString()
	{
		return messaggio;
	}
}
