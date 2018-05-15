import java.io.Serializable;

public class Nodo implements Serializable
{
	private Barca info;
	private Nodo link;
	
	public Nodo (Barca barca)
	{
		setInfo(barca);
		link=null;
	}

	public Barca getInfo() 
	{
		return info;
	}

	public void setInfo(Barca info) 
	{
		this.info = new Barca(info);
	}

	public Nodo getLink() 
	{
		return link;
	}

	public void setLink(Nodo link) 
	{
		this.link = link;
	}

}
