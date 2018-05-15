import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Lista implements Serializable
{
	private Barca[] elencoBarche;
	private final int MAX_NUM_BARCHE=100;
	
	private Nodo head;
	private int elementi;
	
	public Lista()
	{
		head=null;
		elementi=0;
	}
	public void inserisciBarca (Barca barca)
	{
		
		Nodo p=creaNodo(barca, head);
		head=p;
		elementi++;
	}
	
	public void eliminaBarca(int posizione) 
	{
		
		Nodo p;
		p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
		
	}
	
	public Barca getBarca (int posizione) 
	{
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();		
	}
	
	
	
	private Nodo creaNodo(Barca persona, Nodo link)
	{
		Nodo nodo= new Nodo(persona);
		nodo.setLink(link);
		return nodo;
	}
	
	private Nodo getLinkPosizione(int posizione) 
	{
		
		Nodo p;
		int n;
		p=head;
		n=1;

		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();	//p va a puntare al nodo successivo
			n++;
		}
		
		return p;
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
	
	public void salvaLista(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	
	public Lista caricaLista (String nomeFile) throws IOException, ClassNotFoundException 
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		
		Lista l1;
		
		l1=(Lista)(reader.readObject());
		file.close();
		return l1;
	}
	
	
	public int getElementi() 
	{
		return elementi;
	}

	public Barca[] getElencoBarche() 
	{
		return elencoBarche;
	}

	public void setElencoBarche(Barca[] elencoBarche) 
	{
		this.elencoBarche = elencoBarche;
	}

	public int getMAX_NUM_BARCHE()
	{
		return MAX_NUM_BARCHE;
	}
}
