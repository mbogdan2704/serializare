import java.io.PrintWriter;
/**
 * Clasa de serializare
 * @author root
 *
 */

public class Serializare {
	int [] viz = new int [100]; // Vectorul vizitat
	int numberOfTabs = 2;
	String reference1 = "<Reference class=\"NodA\"";
	String reference2 = "<Reference class=\"NodB\"";
	String reference3 = "<Reference class=\"NodC\"";

	String String1 = "<Object class=\"NodA\"";
	String String2 = "<Object class=\"NodB\"";
	String String3 = "<Object class=\"NodC\"";
	String Version = "Version=";
	String id = "id=";
	String Nume = "<Nume>";
	String Nume2 = "</Nume>";
	/**
	 * Functia care returneaza obiectul corespunzator string-ului lookingFor
	 * @param nod_list vectorul de noduri
	 * @param name_list vectorul cu nume
	 * @param numberOfObjects numarul de obiecte
	 * @param lookingFor stringul cautat
	 * @return
	 */
	public static Object getObiect(Object[] nod_list,String[] name_list, int numberOfObjects,String lookingFor)
	{ 
		
		for(int i=0; i<= numberOfObjects; i++)
			if(name_list[i].equals(lookingFor))
				return nod_list[i];
		return 0;
	}
	
	/**
	 * metoda care parcurge nodurile adiacente unui nod si apeleaza functia afisare(care afiseaza nodurile), dupa care merge in fiecare nod adiacent
	 * @param obj nodul curent
	 * @param out fisierul in care se scrie
	 * @param nod_list vectorul de noduri
	 * @param name_list vectorul de nume
	 * @param numberOfTabs numarul de obiecte
	 */
	public void parcurgereA(Nod obj,PrintWriter out, Nod[] nod_list,String [] name_list,int numberOfTabs)
	{
		
		viz[(obj).getNumber()] = 1;
		for(int i=0; i< numberOfTabs; i++)
			out.print("\t");

		out.print(Nume);
		out.print("\"");
		out.print(name_list[(obj).getNumber()]);
		out.print("\"");
		out.print(Nume2);
		out.print("\n");
		if(obj.getIndice() == 1) {
			for(int j=0;j<numberOfTabs; j++)
				out.print("\t");
			out.print("<LIST>");
			out.print("\n");


			for(int i=0;i<(obj).get_list().getCounter(); i++)
			{
				if(obj.get_list().get(i) != null)
				{
					
					for(int j=0;j<=numberOfTabs-3;j++)
						out.print("\t");
					afisare((obj).get_list().get(i),out,nod_list,name_list); 
				
				} 
			}

			out.println("\n");

			for(int i=0;i<(obj).get_list().getCounter(); i++)
			{

				if(obj.get_list().get(i) != null)
				{
					int idx = (obj).get_list().get(i).getNumber();

					if(viz[idx]==0)
						parcurgereA((obj).get_list().get(i),out,nod_list,name_list,numberOfTabs+1); 
				}
			}
			
			
			for(int j=0;j<numberOfTabs; j++)
				out.print("\t");
			out.print("<\\LIST>");
			out.print("\n");
		}
		
		
		if(obj.getIndice() == 2) {
		
			for(int j=0;j<numberOfTabs; j++)
				out.print("\t");
			out.print("<VECTOR>");
			out.print("\n");
			for(int i=0;i<(obj).get_vector().getCounter(); i++)
			{
				if(obj.get_vector().get(i) != null)
				{
					for(int j=0;j<=numberOfTabs-3;j++)
						out.print("\t");
					afisare(obj.get_vector().get(i),out,nod_list,name_list); 
				}
			}
			out.println("\n");
			for(int i=0;i<(obj).get_vector().getCounter(); i++)
			{
				if(obj.get_vector().get(i) != null)
				{

					int idx = (obj).get_vector().get(i).getNumber();
					if(viz[idx]==0)
						parcurgereA((obj).get_vector().get(i),out,nod_list,name_list,numberOfTabs+1); 
				}
			}
			for(int j=0;j<numberOfTabs; j++)
				out.print("\t");
			out.print("<\\VECTOR>");
			out.print("\n");
		
		
		}
		if(obj.getIndice() == 3) {
			
			
			for(int j=0;j<numberOfTabs; j++)
				out.print("\t");
			out.print("<SET>");
			out.print("\n");
			for(int i=0;i<=(obj).get_set().getCounter(); i++)
			{
				if(obj.get_set().get(i) != null)
				{
					for(int j=0;j<=numberOfTabs-3;j++)
						out.print("\t");
					afisare(obj.get_set().get(i),out,nod_list,name_list); 
				}
			}

			out.println("\n");
			
			for(int i=0;i<=(obj).get_set().getCounter(); i++)
			{
				if(obj.get_set().get(i) != null)
				{

					int idx = (obj).get_set().get(i).getNumber();

					if(viz[idx]==0)
						parcurgereA((obj).get_set().get(i),out,nod_list,name_list,numberOfTabs+1); 

				}

			}
			for(int j=0;j<numberOfTabs; j++)
				out.print("\t");
			out.print("<\\SET>");
			out.print("\n");
		}


	}
 /**
  * Functia care afiseaza nodurile adiacente
  * @param obj nodul curent
  * @param out fisierul in care se scrie
  * @param nod_list vectorul de noduri
  * @param name_list vectorul de nume
  */
	void afisare(Nod obj,PrintWriter out,Nod[] nod_list,String[] name_list) // Functia asta afiseaza nodurile adiacente
	{

		int  numberVersion = (obj).getIndice();
		int idx = (obj).getNumber();
		out.print("\t\t\t");

		if(viz[idx] == 1)
		{
			if(obj instanceof nodA)
				out.print(reference1);
			if(obj instanceof nodB)
				out.print(reference2);
			if(obj instanceof nodC)
				out.print(reference3);
		}
		else
		{ 
			if(obj instanceof nodA)
				out.print(String1);
			if(obj instanceof nodB)
				out.print(String2);
			if(obj instanceof nodC)
				out.print(String3);
		}
		out.print(" " +Version);
		out.print("\"");
		out.print(numberVersion);
		out.print("\" ");
		out.print(id);
		out.print("\"");
		out.print(idx);
		out.print(" <Name=\"");
		out.print(name_list[idx]);
		out.print("\">");
		if(viz[idx] == 0)
		{
			out.print("<\\Object>");
		}
		out.print("\n");

}
	/**
	 * Functia care se apeleaza, care afiseaza nodurile adiacente primului nod, dupa care apeleaza metodata de parcurgere care face acelasi lucru pentru restul nodurilor
	 * @param obj nodul cu care se incepe
	 * @param out fisier
	 * @param name_list vector de nume
	 * @param nod_list vector de noduri
	 */
	public  void ser(Nod obj, PrintWriter out,String [] name_list,Nod[] nod_list)
	{

		if(obj instanceof nodA)
			out.print(String1);
		if(obj instanceof nodB)
			out.print(String2);
		if(obj instanceof nodC)
			out.print(String3);
		out.print(" ");
		out.print(Version);
		int numberVersion = (obj).getIndice();
		out.print("\"");
		out.print(numberVersion);
		out.print("\""+" " + id);
		int idx = (obj).getNumber();
		viz[idx] = 1;
		out.print("\""+ idx + "\""+ " Name=\"");
		out.print(name_list[idx]);
		out.print("\""+ ">"+ "\n"+ "\t" +Nume);
		String numeNod = name_list[idx];
		out.print("\""+numeNod+"\""+Nume2+"\n"+"\t");
		if(numberVersion == 1)
			out.print("<LIST>");
		if(numberVersion == 2)
			out.print("<VECTOR>");
		if(numberVersion == 3)
			out.print("<SET>");
		out.print("\n");


		if(numberVersion == 1)
		{

			for(int i = 0; i< obj.get_list().getCounter(); i++)
			{
				
				if(obj.get_list().get(i) != null)
					afisare(obj.get_list().get(i),out,nod_list,name_list);

			}
			
			out.print("\n\n");
			
			for(int i = 0; i< obj.get_list().getCounter(); i++)
			{
				if(obj.get_list().get(i) != null)
				{
					idx = (obj).get_list().get(i).getNumber();

					if(viz[idx] == 0)
						parcurgereA(obj.get_list().get(i),out,nod_list,name_list,3);
				}	
			}

		}
		
		
		if(numberVersion == 2)
		{

			for(int i = 0; i< obj.get_vector().getCounter(); i++)
			{
			
				if(obj.get_vector().get(i) !=  null)
					afisare(obj.get_vector().get(i),out,nod_list,name_list);

			}
			
			out.print("\n\n");
			
			for(int i = 0; i< obj.get_vector().getCounter(); i++)
			{
				
				if(obj.get_vector().get(i) != null)
				{
					idx = (obj).get_vector().get(i).getNumber();

					if(viz[idx] == 0)
						parcurgereA(obj.get_vector().get(i),out,nod_list,name_list,3);
				
				}	
			}

		}
		
		
		if(numberVersion == 3)
		{

			for(int i = 0; i<= obj.get_set().getCounter(); i++)
			{
				
				if(obj.get_set().get(i) != null)
					afisare(obj.get_set().get(i),out,nod_list,name_list);

			}
			out.print("\n\n");
			for(int i = 0; i<= obj.get_set().getCounter(); i++)
			{
				
				if(obj.get_set().get(i) != null)
				{
					idx = (obj).get_set().get(i).getNumber();

					if(viz[idx] == 0)
						parcurgereA(obj.get_set().get(i),out,nod_list,name_list,3);
				
				}	
			}

		}

		out.print("\t");
		out.print("<\\SET>");
		out.print("\n");
	}

}


