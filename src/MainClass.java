import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class MainClass 
{

	public static void main(String[] args) throws IOException 
	{
		
		
		ConsoleInput tastiera=new ConsoleInput();
		int ora,minuti;
		
		String[] elenco= {"1-Inserisci nuova barca","2-Arrivo Barca","3-Modificare orario previsto","4-Visualizza elenco barche in base agli orari","5-Situazione d'emergenza", "6-Visualizza barche  proveniente da città specifica"};
		System.out.println("Benvenuto al porto navale di Catania \n");
		Porto p1=new Porto();
		
		Menù m1=new Menù(elenco);
		String nomeFile = "arrivi.bin";
		LocalTime oraAttuale;
		String pp=null;
		
		
		try 
		{
			p1.caricaLista("arrivi.bin");
		} 
		catch (ClassNotFoundException | IOException e) 
		{
			System.out.println("Impossibile caricare la lista");
		}
		
		do
		{
			
		switch (m1.scelta()) 
		{
			case 1:
			System.out.println("Vuoi registrare una nuova barca? 1=Si, 2=No");
			int entrata=0;
			Barca b1=new Barca(1,"Genova",22,13,true);
			entrata=tastiera.readInt();
			
						
			switch (entrata) 
			{
			case 1:
				
				System.out.println("Inserisci codice barca");
				b1.setCodice(tastiera.readInt());
				
				System.out.println("Inserisci il porto di provenienza");
				b1.setPortoProvenienza(tastiera.readString());
			
				System.out.println("Inserisci orario di arrivo");
				System.out.print("Ora:");
				ora=tastiera.readInt();
				System.out.print("minuti:");
				minuti=tastiera.readInt();
				oraAttuale=LocalTime.of(ora,minuti,0);
				b1.setOrarioArrivo(oraAttuale);
				System.out.println("acquisisco l'ora, attendere");
				System.out.println("ora acquisita");

				p1.inserisciBarca(b1);
			
				p1.salvaLista("copia.bin");
				default:
				break;
			}
				
			break;
		case 2:
			System.out.println("Simulare l'arrivo di quale barca: ");
			break;
		case 3:
			System.out.println("Modificare l'arrivo di quale barca: ");
			break;
		case 4:
			System.out.println("Visualizza elenco barche in base agli orari: "+'\n');
			try {
				p1=Ordinatore.selectionSortCrescenteNodi(p1);
				System.out.println("visualizzazione orari barca in ordine di tempo:");
				System.out.println(p1.toString());
			} catch (PortoException e) {
				System.out.println(e.toString());
			} catch (ClassNotFoundException e) {
				System.out.println("Impossibile caricare oggetti di tipo laboratorio");
			} catch (IOException e) {
				System.out.println("Impossibile completare il caricamento degli accessi");
			} catch (FileException e) {
				System.out.println("File non trovato");
			}
			break;
		case 5:
			System.out.println("Quale barca ha la situazione d'emergenza, inserisci il suo codice: ");
			
			break;
		/*case 6:
			System.out.println("Inserisci città delle barche che vuoi visualizzare: ");
			try {
				System.out.print("Porto di provenienza su cui si vuole cercare?: ");
				pp=tastiera.readString();
				}catch (NumberFormatException e) {
				System.out.println("Formato dato inserito errato");
					} catch (IOException e) {
				System.out.println("Impossibile leggere da tastiera");
					
		System.out.println("DATA INSERITA->"+data.toString());
			try {
				//l1.salvaPorto(data);
				l1=l1.CaricaPorto(data);
				System.out.println("Caricamento delle barche in data "+data.toString()+" eseguito con successo");
				System.out.println(l1.toString());
			} catch (ClassNotFoundException e) {
				System.out.println("Impossibile caricare oggetti di tipo porto");
			} catch (IOException e) {
				System.out.println("Impossibile completare il caricamento delle barche");
			}		*/			
		default:
			break;
		}
		}while(m1.scelta()!=0);
		
	}
	
}




