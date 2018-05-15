import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

public class MainClass 
{

	public static void main(String[] args) throws IOException 
	{
		/*Porto p1=new Porto();
		Barca b1=new Barca(1,"Milano",10,true);
		
		try
		{
			p1=p1.caricaPorto("arrivi.bin");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Impossibile salvare oggetti di tipo porto");
		} catch (IOException e) 
		{
			System.out.println("Impossibile leggere dal file");
		}
		
		System.out.println(p1.toString());
	
		System.out.println(p1.toString());
		try 
		{
			p1.esportaCSV("arrivi.txt");
			System.out.println("esportazione eseguita correttamente");
		} 
		catch (IOException e) 
		{
			System.out.println("Impossibile scrivere sul file");
		} 
		catch (PortoException e) 
		{
			System.out.println(e.toString());
		} 
		catch (FileException e) 
		{
			System.out.println(e.toString());
		} */
		
		ConsoleInput console=new ConsoleInput();
		Scanner tastiera=new Scanner(System.in);
		
		String[] elenco= {"Inserisci nuova barca","Arrivo Barca","Modificare orario previsto","Visualizza elenco barche in base agli orari","Situazione d'emergenza", "Visaulizza barche  proveniente da città specifica"};
		System.out.println("Benvenuto al porto navale di Catania \n");
		Lista l1=new Lista();
		Menù m1=new Menù();
		String nomeFile = "arrivi.txt";
		
		try 
		{
			l1.caricaLista(nomeFile);
		} 
		catch (ClassNotFoundException | IOException e) 
		{
			System.out.println("Impossibile caricare la lista");
		}
		
		switch (m1.scelta()) 
		{
			case 1:
			System.out.println("Vuoi registrare una nuova barca? 1=Si, 2=No");
			int entrata=0;
			Barca b1=new Barca(1,"Genova",22,13,true);
			entrata=tastiera.nextInt();
			
			
			switch (entrata) 
			{
			case 1:
				
				System.out.println("Inserisci codice barca");
				b1.setCodice(tastiera.nextInt());
				
				System.out.println("Inserisci il porto di provenienza");
				b1.setPortoProvenienza(tastiera.nextLine());
				System.out.println("inserisci orario di arrivo");
				b1.setCodice(tastiera.nextInt());
				System.out.println("acquisisco l'ora, attendere");
				LocalTime oraAttuale=LocalTime.now();
				System.out.println("ora acquisita");
				int vuoiBarca;
				vuoiBarca=tastiera.nextInt();
				
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
			System.out.println("Simula?");
			
		case 3:
			System.out.println("Visualizza ordine alfabetico");

		case 4:
			System.out.println("Visualizza in ordine di tempo");
			
		case 6:
			System.out.println("verifica presenza nella lista");

		default:
			break;
			}
		}
	}





