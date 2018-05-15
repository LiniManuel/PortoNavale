import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Porto implements Serializable
{

	private Nodo head;
	private int elementi;
	
	public Porto()
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
			p=p.getLink();	
			n++;
		}
		
		return p;
	}
	
	public void inserisciInTesta (Barca barca)
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
	
	public void inserisciInCoda(Barca barca) throws PortoException
	{
		if(elementi==0)
		{
			inserisciInTesta(barca);
			return;
		}
		
		Nodo pn=creaNodo(barca, null);
		Nodo p=getLinkPosizione(elementi);
		p.setLink(pn);
		elementi++;	
	}
	
	public void inseriscInPosizione(Barca barca,int posizione) throws PortoException
	{
		if (posizione<=1)
		{
			inserisciInTesta(barca);
			return;
		}
		if (posizione>elementi)
		{
			inserisciInCoda(barca);
			return;
		}
		
		Nodo pn=creaNodo(barca, getLinkPosizione(posizione));
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(pn);
		elementi++;
	}
	
	public void eliminaInTesta() throws PortoException
	{
		if (elementi==0)
			throw new PortoException("Lista vuota");
		head=head.getLink();
		elementi--;
	}
	
	public void eliminaInCoda() throws PortoException
	{
		if (elementi==0)
			throw new PortoException("Lista vuota");
		if (elementi==1)
		{
			eliminaInTesta();
			return;
		}
		
		Nodo p=getLinkPosizione(elementi-1);
		p.setLink(null);
		elementi--;
	}
	
	public void eliminaInPosizione(int posizione) throws PortoException
	{
		if (elementi==0)
			throw new PortoException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new PortoException("Posizione non valida");
	
		if (posizione==1)
		{
			eliminaInTesta();
			return;
		}
		if (posizione==elementi)
		{
			eliminaInCoda();
			return;
		}
		
		Nodo p;
		p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
		
	}
	
	public String visita (int posizione) throws PortoException
	{
		if (elementi==0)
			throw new PortoException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new PortoException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo().toString();		
	}
	
	public Barca getBarca (int posizione) throws PortoException
	{
		if (elementi==0)
			throw new PortoException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new PortoException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();		
	}
	
	public void esportaCSV (String nomeFile) throws IOException, PortoException, FileException
	{
		TextFile file= new TextFile (nomeFile,'W');
		String barcaCSV;
		Barca barca;
		
		for (int i = 1; i <= getElementi(); i++) 
		{
			barca=getBarca(i);
			barcaCSV=barca.getCodice()+";"+barca.getPortoProvenienza()+";"+barca.getOrarioArrivo()+";"+barca.getSos()+";";
			file.toFile(barcaCSV);
		}
		file.closeFile();
		
	}
	public void salvaPorto(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	
	public Porto caricaPorto (String nomeFile) throws IOException, ClassNotFoundException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		
		Porto porto;
		
		porto=(Porto)(reader.readObject());
		file.close();
		return porto;
	}
}
