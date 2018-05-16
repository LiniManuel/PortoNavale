import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class MainClass 
{

	public static void main(String[] args) throws IOException 
	{
		
		
		ConsoleInput tastiera=new ConsoleInput();
		//Scanner tastiera=new Scanner(System.in);
		
		String[] elenco= {"1-Inserisci nuova barca","2-Arrivo Barca","3-Modificare orario previsto","4-Visualizza elenco barche in base agli orari","5-Situazione d'emergenza", "6-Visaulizza barche  proveniente da città specifica"};
		System.out.println("Benvenuto al porto navale di Catania \n");
		Lista l1=new Lista();
		Menù m1=new Menù(elenco);
		String nomeFile = "arrivi.txt";
		
		
		try 
		{
			l1.caricaLista(nomeFile);
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
			
				System.out.println("inserisci orario di arrivo");
				b1.setOrarioArrivo(tastiera.readInt());
				System.out.println("acquisisco l'ora, attendere");
				LocalTime oraAttuale=LocalTime.now();
				System.out.println("ora acquisita");
				int vuoiBarca;
				vuoiBarca=tastiera.readInt();
		
				
				switch (vuoiBarca) 
				{
				case 1:
					l1.inserisciBarca(b1);
					break;
				case 2:
					System.out.println("ok");
				default:
					break;
				}
				
				
				l1.salvaLista(nomeFile);
				break;
				
			case 2:
				System.out.println("allora niente");

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
			break;
		case 5:
			System.out.println("Quale barca ha la situazione d'emergenza");
			break;
		case 6:
			System.out.println("Inserisci città delle barche che vuoi visualizzare: ");
		default:
			break;
		}
		}while(m1.scelta()!=0);
		
	}
	
}




