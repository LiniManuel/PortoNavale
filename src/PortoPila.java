
public class PortoPila 
{
	private Nodo head;
	private int elementi;
	
	public PortoPila()
	{
		head=null;
		elementi=0;
	}
	
	public int getElementi()
	{
		return elementi;
	}
	
	private Nodo creaNodo(Barca barca, Nodo link)
	{
		Nodo nodo= new Nodo(barca);
		nodo.setLink(link);
		return nodo;
	}
	
	private Nodo getLinkPosizione(int posizione) throws PortoException
	{
		
		Nodo p;
		int n;
		p=head;
		n=1;
		
		if (posizione<1 || posizione>getElementi())
			throw new PortoException("Posizione non valida");
		if (elementi==0)
			throw new PortoException("Lista vuota");
			
		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();	//p va a puntare al nodo successivo
			n++;
		}
		
		return p;
	}
	
	public void push (Barca barca)
	{
		
		Nodo p=creaNodo(barca, head);
		head=p;
		elementi++;
	}
	
	public String toString()
	{
		String risultato="Head";
		if (elementi==0)
			return risultato+="-->";
		Nodo p=head;
		while (p!=null)
		{
			risultato+="-->"+p.getInfo().toString();
			p=p.getLink();
		}
		return risultato;
	}
	

	public Barca pop() throws PortoException
	{
		if (elementi==0)
			throw new PortoException("Lista vuota");
		Nodo p=head;
		head=head.getLink();
		elementi--;
		return p.getInfo();
	}
}
