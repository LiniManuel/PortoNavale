import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * La classe rappresenta un processo che restituisce una serie di Barche.
 * @version 1.0.
 * @author Manuel Lini.
 */

public class Porto implements Serializable
{
	//Attributi
	private Nodo head;
	private int elementi;
	
	
	/**
	 * Costruttore. Istanzia un elenco di barche vuoto.
	 */
	public Porto()
	{
		head=null;
		elementi=0;
	}
	/**
	 * Metodo getter che restituisce il numero di elementi inseriti.
	 * @return elementi.
	 */
	public int getElementi()
	{
		return elementi;
	}
	/**
	 * Metodo privato utilizzato all'interno della classe per aggiungere all'elenco.
	 * @param barca è la parte informativa del nodo.
	 * @param link contiene il reference del nodo successivo(collegamento).
	 * @return nodo restituisce il nodo creato.
	 */
	private Nodo creaNodo(Barca barca, Nodo link)
	{
		Nodo nodo= new Nodo(barca);
		nodo.setLink(link);
		return nodo;
	}
	/**
	 * Metodo privato all'interno della classe per ottenere il nodo in una certa posione.
	 * @param posizione posizione da cui ricavare il nodo.
	 * @return p il collegamento ottenuto nella posizione richiesta.
	 * @throws PortoException viene sollevata la seguente eccezione se viene inserito una posizione no valida.
	 */
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
	/**
	 * Metodo che inserisci un nodo in testa alla lista Porto.
	 * @param barca parte informativa del nodo.
	 */
	
	public void inserisciInTesta (Barca barca)
	{
		
		Nodo p=creaNodo(barca, head);
		head=p;
		elementi++;
	}
	/**
	 * Metodo che inserisce una nuova Barca in coda.
	 * @param barca.
	 * @throws PortoException viene sollevata quando il porto è vuoto.
	 */
	public void inserisciInCoda(Barca barca)throws PortoException
	{
		if (elementi==0) 
		{
			inserisciInTesta(barca);
			return;
		}
		Nodo pn=creaNodo(barca, null);
		Nodo p=getLinkPosizione(elementi);
		p.setLink(pn);
		elementi++;
	}
	/**
	 * Metodo toString che restituisce una stringa composta dalle barche con i relativi dati.
	 */
	
	public String toString()
	{
		String risultato="Elenco barche in ordine di arrivo: ";
		if (elementi==0)
			return risultato+="";
		Nodo p=head;
		while (p!=null)
		{
			risultato+='\n'+""+p.getInfo().toString();
			p=p.getLink();
		}
		return risultato;
	}
	/**
	 * Metodo che elimina il nodo che si trova sull'head cioe in testa alla lista Porto.
	 * @throws PortoException viene sollevata quando il porto è vuoto.
	 */
	public void eliminaInTesta() throws PortoException
	{
		if (elementi==0)
			throw new PortoException("Lista vuota");
		head=head.getLink();
		elementi--;
	}
	/**
	 * Metodo che elimina il nodo che in coda alla lista Porto.
	 * @throws PortoException viene sollevata quando il porto è vuoto.
	 */
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
	/**
	 * Metodo con cui possiamo aggiungere una nuova Barca nella posizione da noi scelta.
	 * @param barca indica il nodo che stiamo aggiungendo.
	 * @param posizione indica la posizione all'interno della lista.
	 * @throws PortoException viene sollevato se il porto è vuoto.
	 */
	public void inserisciInposizione(Barca barca,int posizione)throws PortoException
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
	}
	/**
	 * Metodo che elimina il nodo in posizione inserita.
	 * @param posizione serve per verificare se la posizione inserita è valida.
	 * @throws PortoException viene sollevata quando il porto è vuoto o la posizione inserita non esiste.
	 */
	
	public void eliminaInPosizione(int posizione) throws PortoException
	{
		if (elementi==0)
			throw new PortoException("Lista vuota");
		
		if (posizione<0 || posizione>elementi)
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
	/**
	 * 
	 * @param posizione 
	 * @throws PortoException viene sollevata quando il porto è vuoto o la posizione inserita non è valida.
	 */
	public Barca getBarca (int posizione) throws PortoException
	{
		if (elementi==0)
			throw new PortoException("Lista vuota");
		
		if (posizione<=0 || posizione>elementi)
			throw new PortoException("Posizione non valida");
		
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();		
	}
	/**
	 * 
	 * @param nomeFile nome del file su cui esportare le barche.
	 * @throws IOException viene sollevata quando si verificano errori durante la scrittura su file.
	 * @throws PortoException viene sollevata quando il porto è vuoto.
	 * @throws FileException
	 */
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
	/**
	 * Metodo che consente di salvare gli elementi nel porto, salvare le barche su file binario.
	 * @param nomeFile nome del file su cui si salvano le barche.
	 * @throws IOException viene sollevata quando si verificano errori durante la scrittura su file.
	 */
	public void salvaLista(String nomeFile) throws IOException
	{
		FileOutputStream file =new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	/**
	 * Metodo che consente di caricare gli elementi salvati in precedenza su file binario(arrivi.bin) 
	 * per ricaricarli nel Porto.
	 * @param nomeFile nome del file dove si salva la lista Porto.
	 * @return porto ritorna un porto.
	 * @throws IOException viene sollevata quando si verificano errori durante la lettura del file.
	 * @throws ClassNotFoundException viene sollevata quando si verifica un'errore di casting.
	 */
	public Porto caricaLista (String nomeFile) throws IOException, ClassNotFoundException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader= new ObjectInputStream(file);
		
		Porto porto;
		
		porto=(Porto)(reader.readObject());
		file.close();
		return porto;
	}
	/**
	 * Consente di ricavare una barca dal porto, in base alla posione.
	 * @param posizione indica la posizione all'interno del nodo.
	 * @throws PortoException viene sollevata se la posizione non è valida.
	 */
	public Barca getPorto(int posizione) throws PortoException 
	{
		if(elementi==0)
			throw new PortoException("Lista vuota");
		if(posizione<0 || posizione>elementi)
			throw new PortoException("Posizione non valida");
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();
	}
	/**
	 * Metodo che serve per registrare le informazioni di una barca all'interno del porto
	 * @param info contiene le informazioni della barca.
	 */
	public void registraBarca(Barca info)
	{
		Nodo p=creaNodo(info, head);
		head=p;
		elementi++;
	}
	/**
	 * Metodo che serve a visualizzare le barche del porto in base al porto di provenienza.
	 * @param nomePorto nome del Porto.
	 * @return elenco indica l'elenco di barche
	 * @throws PortoException viene sollevata quando il porto è vuoto.
	 */
	public Barca[] visualizzaPorto(String nomePorto) throws PortoException
	{
		Barca[] elenco=new Barca[this.getElementi()];
		for (int i = 1; i < this.getElementi()+1; i++) 
		{
			if (getBarca(i).getPortoProvenienza().compareToIgnoreCase(nomePorto)==0) 
			{
				elenco[i-1]=getBarca(i);
			}
		}
		return elenco;
	}
	/**
	 * Metodo che serve per modiciare l'orario di arrivo di una barca, per selezionare quale barca vuole cambiare orario, inserire il codice identificativo.
	 * @param codice viene inserito per riconoscere quale di quale barca si vuole modificare l'orario.
	 * @throws PortoException viene sollevata quando il porto è vuoto.
	 * @throws NumberFormatException viene sollevata quando viene inserito un formato sbagliato.
	 * @throws IOException viene sollevata quando si verificano errori sulla scrittura del file.
	 */
	public void modificaOrario(int codice,int ora,int minuti) throws PortoException, NumberFormatException, IOException
	{
	
	for (int i = 1; i < this.getElementi()+1; i++) 
	{
		if (getBarca(i).getCodice()==codice) 
		{
			
			getBarca(i).setOrarioArrivo(ora, minuti);
		}
	}
	}
	/**
	 * Elimina la
	 * @param p
	 * @param c
	 * @throws PortoException
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void EliminaBarca(Porto p,int c) throws PortoException, NumberFormatException, IOException, ClassNotFoundException
	{
		if (elementi==0)
		{
			throw new PortoException("Nessuna prenotazione presente");
		}
		
		for (int i = 1; i <= p.getElementi(); i++) 
		{
			if (getBarca(i).getCodice()==c)
			{
				if (i==1)
				{
					eliminaInTesta();
					System.out.println("eliminazione avvenuta con successo");
					return;
				}
				if(i==p.getElementi())
				{
					eliminaInCoda();
					System.out.println("eliminazione avvenuta con successo");
					return;
				}
				eliminaInPosizione(i);
				System.out.println("eliminazione avvenuta con successo");
				return;
			}
		}
		throw new PortoException("Nessuna prenotazione con questo codice identificativo");
	}
	/**
	 * 
	 * @param p
	 * @param codice
	 * @throws PortoException
	 * @throws IOException
	 * @throws FileException
	 * @throws NumberFormatException
	 * @throws ClassNotFoundException
	 */
	public void arrivoBarca(Porto p,int codice) throws PortoException, IOException, FileException, NumberFormatException, ClassNotFoundException
	{
		for (int i = 1; i <= p.getElementi(); i++) 
		{
			if (getBarca(i).getCodice()==codice) 
			{
				System.out.println("BARCA IN ARRIVO NEL PORTO");
				System.out.println("BARCA-->"+getBarca(i).toString());
				esportaCSV("arrivi.txt");
				p.EliminaBarca(p, i);
				return;
			}
		}
		throw new PortoException("nessuna barca presente con questo codice");
	}
	/**
	 * 
	 * @param codice
	 * @throws PortoException
	 */
	public void segnaleSos(int codice) throws PortoException
	{
		System.out.println("ATTENZIONE..SITUAZIONE DI EMERGENZA");
		for (int i = 1; i < this.getElementi(); i++) 
		{
			if (getBarca(i).getCodice()==codice) 
			{
				getBarca(i).setSos(true);
				inserisciInTesta(getBarca(i));
				return;
			}
		}
		throw new PortoException("nessuna barca presente con questo codice");
	}
	/**
	 * 
	 * @return
	 * @throws PortoException
	 */
	public Barca[] array() throws PortoException
	{
		Barca[] arrayp=new Barca[elementi];
		for (int i = 0; i < arrayp.length; i++) 
		{
			Nodo n1=getLinkPosizione(i+1);
			arrayp[i]=n1.getInfo();
		}
		return arrayp;
	}
	/**
	 * 
	 * @param array
	 * @param pos1
	 * @param pos2
	 * @return
	 */
	public static int scambia(Barca[] array, int pos1, int pos2)
	{
		Barca b;
		if(pos1<0 || pos1>=array.length || pos2<0 ||pos2>=array.length)
			return -1;
		b=new Barca(array[pos1]);
		array[pos1]=new Barca(array[pos2]);
		array[pos2]=new Barca(b);
		return 0;
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static String[] copia(String[] array)
	{
		String[] arrayCopia=new String[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
		{
			arrayCopia[i]=array[i];
		}
		
		return arrayCopia;
		
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static Barca[] copia(Barca[] array)
	{
		Barca[] arrayCopia=new Barca[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
		{
			arrayCopia[i]=array[i];	
		}
		return arrayCopia;
	}
	/**
	 * Ordina le barche in ordine crescente passando dall'array.
	 * @return l'array ordinato con le barche ordinate in base all' orario di arrivo.
	 * @throws PortoException viene sollevata se il porto è vuoto.
	 */
	public  Barca[] selectionSortCrescenteOrario(Porto p) throws PortoException
	{
		if (elementi==0)
		{
			throw new PortoException("Nessuna barca presente");
		}
		Barca[] array;
		array=p.array();
		Barca[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if(arrayOrdinato[j].getOrarioArrivo().isBefore(arrayOrdinato[i].getOrarioArrivo()))
					scambia(arrayOrdinato, i, j);
			}
		}
		
		return arrayOrdinato;
	}

	
}
	

