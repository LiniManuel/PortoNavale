package Base;
import java.io.IOException;

public class Ordinatore 
{
	//NODI
	public static void scambia(Porto porto, int pos1, int pos2) throws PortoException 
	{
		if(pos1<=0 || pos1>porto.getElementi() || pos2<=0 ||pos2>porto.getElementi())
			throw new PortoException("Posizioni non valide");
		Barca b1,b2;
		b1=new Barca(porto.getBarca(pos1));
		b2=new Barca(porto.getBarca(pos2));
	
		porto.inserisciInposizione(b1, pos2);
		porto.inserisciInposizione(b2, pos1);
		
		porto.eliminaInPosizione(pos2+2);
		porto.eliminaInPosizione(pos1+1);
	}
	private static Porto copia(Porto porto) throws IOException, ClassNotFoundException 
	{
		Porto l2=new Porto();
		porto.salvaLista("arrivi.bin");
		l2=l2.caricaLista("arrivi.bin");
		return l2;
	}
	public static Porto selectionSortCrescenteNodi(Porto porto) throws ClassNotFoundException, IOException, FileException, PortoException
	{
		Porto portCopia=copia(porto);
		boolean scambioOK;
		do
		{
			scambioOK=false;
			for (int i = 1; i < portCopia.getElementi(); i++) 
			{
				if(portCopia.getBarca(i).getOrarioArrivo().isAfter(portCopia.getBarca(i+1).getOrarioArrivo()))
				{
					scambia(portCopia,i,i+1);
					scambioOK=true;
				}
						
					
			}
		} while (scambioOK==true);
		return portCopia;
	}
	public static Porto selectionSortDecrescenteNodi(Porto porto) throws ClassNotFoundException, IOException, FileException, PortoException
	{
		Porto portCopia=copia(porto);
		boolean scambioOK;
		do
		{
			scambioOK=false;
			for (int i = 1; i < portCopia.getElementi(); i++) 
			{
				if(portCopia.getBarca(i).getOrarioArrivo().isBefore(portCopia.getBarca(i+1).getOrarioArrivo()))
				{
					scambia(portCopia,i,i+1);
					scambioOK=true;
				}
						
					
			}
		} while (scambioOK==true);
		return portCopia;
	}
	public static Barca[] copiaInArray(Porto l) throws PortoException 
	{
		Barca[] arrayCopia=new Barca[l.getElementi()];
		for (int i = 1; i < l.getElementi()+1; i++) 
		{
			arrayCopia[i-1]=l.getBarca(i);	
		}
		
		return arrayCopia;
	}
	
	public static Barca[] copia(Barca[] array)
	{
		Barca[] arrayCopia=new Barca[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
		{
		arrayCopia[i]=array[i];	
		}
		
		return arrayCopia;
	}
	public static Porto creaLista(Barca[] array)
	{
		Porto l1=new Porto();
		for (int i = 0; i < array.length; i++) 
		{
			l1.registraBarca(array[i]);
		}
		
		return l1;
	}
	//ARRAY
	public static int scambia(Barca[] array, int pos1, int pos2)
	{
		Barca a;
		if(pos1<0 || pos1>=array.length || pos2<0 ||pos2>=array.length)
			return -1;
		a=new Barca(array[pos1]);
		array[pos1]=new Barca(array[pos2]);
		array[pos2]=new Barca(a);
		return 0;
	}
	
	public static Porto selectionSortCrescente(Porto porto) throws PortoException
	{
		Barca[] array=copiaInArray(porto);
		Barca[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if(arrayOrdinato[j].getOrarioArrivo().isAfter(arrayOrdinato[i].getOrarioArrivo()))
					scambia(arrayOrdinato, i, j);
				
			}
		}
		
		Porto labOrdinato=creaLista(arrayOrdinato);
		return labOrdinato;
	}
	
	public static Porto selectionSortDecrescente(Porto porto) throws PortoException
	{
		Barca[] array=copiaInArray(porto);
		Barca[] arrayOrdinato=copia(array);
		for (int i = 0; i < arrayOrdinato.length-1; i++) 
		{
			for (int j = i+1; j < arrayOrdinato.length; j++) 
			{
				if(arrayOrdinato[j].getOrarioArrivo().isBefore(arrayOrdinato[i].getOrarioArrivo()))
					scambia(arrayOrdinato, i, j);
				
			}
		}
		
		Porto portOrdinato=creaLista(arrayOrdinato);
		return portOrdinato;
	}
	
}
