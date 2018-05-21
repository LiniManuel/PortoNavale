package Base;
import java.io.IOException;
import java.io.NotSerializableException;
import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.Scanner;

public class MainClass 
{

	public static void main(String[] args) throws IOException 
	{
		
		
		ConsoleInput tastiera=new ConsoleInput();
		int ora,minuti;
		
		String[] elenco= {"1-Inserisci nuova barca",
						  "2-Arrivo Barca",
						  "3-Modificare orario previsto",
						  "4-Visualizza elenco barche in base agli orari",
						  "5-Situazione d'emergenza", 
						  "6-Visualizza barche  proveniente da città specifica"};

		System.out.println("Benvenuto al porto navale di Catania,\nCosa desidera fare?\nSeleziona una delle voci sottostanti.\n");
		Porto p1=new Porto();
		
		Menù m1=new Menù(elenco);
		String nomeFile = "porto.bin";
		LocalTime oraAttuale = null;
		String pp=null;
		int sceltamenu=0;
		
		
		try 
		{
			p1=p1.caricaLista("porto.bin");
		} 
		catch (ClassNotFoundException | IOException e) 
		{
			System.out.println("Impossibile caricare la lista");
		}
		
		do
		{
		sceltamenu=m1.scelta();
		switch (sceltamenu) 
		{
			case 1:
			System.out.println("Vuoi registrare una nuova barca? 1=Si, 2=No");
			int entrata=0;
			Barca b1=new Barca();
			entrata=tastiera.readInt();
			
						
			switch (entrata) 
			{
			case 1:
				
				System.out.println("-Inserisci codice barca: ");
				try {
					b1.setCodice(tastiera.readInt());
				}
				catch(NumberFormatException n)
				{
					System.out.println('\n'+"Formato non disponibile, riprova inserendo un numero..."+'\n');	
				}
				
				System.out.println("-Inserisci il porto di provenienza: ");
				try {
					b1.setPortoProvenienza(tastiera.readString());
				}
				catch(NumberFormatException n)
				{
					System.out.println('\n'+"Formato non disponibile, riprova inserendo una stringa..."+'\n');	
				}
			
				System.out.println("-Inserisci orario di arrivo: ");
				System.out.print('\t'+"-Ora:");
				ora=tastiera.readInt();
				System.out.print('\t'+"-Minuti:");
				minuti=tastiera.readInt();
				
				try
				{
					oraAttuale=LocalTime.of(ora,minuti,0);
					b1.setOrarioArrivo(oraAttuale);
				}
				catch(DateTimeException dt)
				{
					System.out.println('\n'+"Orario non inserito correttamente, torna al menu peincipale..."+'\n');
				}

					p1.registraBarca(b1);
					System.out.println('\n'+"Barca registrata nel nostro software, desidera altro: "+'\n');
				try
				{
					p1.salvaLista("porto.bin");
				}
				catch(NotSerializableException n)
				{
					System.out.println("\n"+"Salvataggio porto non avvenuto con successo"+'\n');
					break;
				}
				
				
			}
				
			break;
		case 2:
			int c=0;
			System.out.println("inserire il codice della barca in arrivo: ");
			c=tastiera.readInt();
			try 
			{
				p1.arrivoBarca(p1,c);
			} 
			catch (NumberFormatException e2) 
			{
				System.out.println("formato inserito errato");
			} 
			catch (ClassNotFoundException e2) 
			{
				System.out.println("classe non trovata");
			} 
			catch (PortoException e2) 
			{
				System.out.println(e2.toString());
			} 
			catch (FileException e2) {
			
				System.out.println("impossibile scrivere sul file");
			}
			try
			{
				p1.salvaLista("porto.bin");
			}
			catch(NotSerializableException n)
			{
				System.out.println("\n"+"Salvataggio porto non avvenuto con successo"+'\n');
				break;
			}
			break;
		case 3:
			int codice=0;
			int ora1=0;
			int minuti1=0;
			System.out.println("Inserisci il codice identificativo della barca da modificare: ");
			codice=tastiera.readInt();
			System.out.println("inserire ora: ");
			ora1=tastiera.readInt();
			System.out.println("inserire minuti: ");
			minuti1=tastiera.readInt();
			try 
			{
				p1.modificaOrario(codice,ora1,minuti1);
			} 
			catch (NumberFormatException e1) 
			{
				System.out.println("Formato dato inserito errato");
			} 
			catch (PortoException e1) 
			{
				System.out.println(e1.toString());
			}
			try
			{
				p1.salvaLista("porto.bin");
			}
			catch(NotSerializableException n)
			{
				System.out.println("\n"+"Salvataggio porto non avvenuto con successo"+'\n');
				break;
			}
			break;
		case 4:
			System.out.println("Visualizza elenco barche in base agli orari: "+'\n');
			try {
				Barca[] arrayordinato=new Barca[p1.getElementi()];
				arrayordinato=p1.selectionSortCrescenteOrario(p1);
				System.out.println("visualizzazione orari barca in ordine di tempo:");
				for (int i = 0; i < arrayordinato.length; i++) 
				{
					System.out.println(arrayordinato[i].toString());
				}
			}
			catch (PortoException e)
			{
				System.out.println(e.toString());
				break;
			}
			break;
		case 5:
			int c1=0;
			System.out.println("Quale barca ha la situazione d'emergenza, inserisci il suo codice: ");
			c=tastiera.readInt();
			try 
			{
				p1.segnaleSos(c);
			} 
			catch (PortoException e1) 
			{
				System.out.println(e1.toString());
			}
			break;
		case 6:
			System.out.println("Di che città proveniente vuoi visualizzare la serie di barche: ");
			String nome=tastiera.readString();
			Barca[] elencoBarche;
			try {
				elencoBarche=p1.visualizzaPorto(nome);
				for (int i = 0; i < elencoBarche.length; i++) 
				{
					System.out.println(elencoBarche[i].toString());
				}
			} catch (PortoException e)
			{
				e.toString();
			}
			 catch (NullPointerException e)
			{
				System.out.println('\n'+"Nessuna barca è in arrivo da "+nome+'\n');
	
			}
			
			
		default:
			break;
		}
		}while(sceltamenu!=0);
		
	}
	
}




