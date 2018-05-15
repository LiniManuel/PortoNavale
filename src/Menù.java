import java.io.IOException;

public class Menù 
{
	private int numeroVoci;
	private String[] elencoVoci;
	
	public void Menu(String[] elenco)
	{
		numeroVoci=elenco.length;
		elencoVoci=new String[numeroVoci];
		for (int i = 0; i < numeroVoci; i++) 
		{
			elencoVoci[i]=elenco[i];
		}
	}
	public void VisualizzaMenu()
	{
		for(int i=0;i<numeroVoci;i++)
		{
			System.out.println(elencoVoci[i]);
		}
	}
	public int scelta()
	{
		ConsoleInput tastiera=new ConsoleInput();
		int voceScelta=-1;
		do
		{
		VisualizzaMenu();
		System.out.println("Scegli...");
		  
		 try
			{	
				voceScelta=tastiera.readInt();
			}
			catch(NumberFormatException e)
			{
				System.out.println("inserimento non valido...");
			}
			catch(IOException e)
			{
				System.out.println("errore lettura dati...");
			}
		}while(voceScelta<0 || voceScelta>numeroVoci);
		return voceScelta;
	}
}
