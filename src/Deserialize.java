import java.io.BufferedReader;
import java.io.IOException;
/**
 * Clasa de deserializare
 * @author root
 *
 */

public class Deserialize {
	/**
	 * Functia care cauta in vectorul de obiecte stringul lookingFor
	 * @param nod_list vectorul de obiecte
	 * @param name_list vectorul in care am numele stocate
	 * @param numberOfObjects numarul de obiecte
	 * @param lookingFor stringul cautat
	 * @return
	 */
	public static Nod getObject(Nod[] nod_list,String[] name_list, int numberOfObjects,String lookingFor)
	{ 
		
		for(int i=0; i<= numberOfObjects; i++)
			if(name_list[i].equals(lookingFor))
				return nod_list[i];
		return null;
	}
	/**
	 * Functia care realizeaza deserializarea. Pentru fiecare nod, parcurg liniile urmatoare si creez muchiile intre linii. Ma opresc atunci cand dau peste un nou tag <Nume>,asta insemnand ca am trecut intr-un nou nod.
	 * @param nod_list vectorul de noduri
	 * @param name_list vector cu numele
	 * @param numberOfObjects numarul de obiecte
 	 * @param indiceA indicele pt nodA
	 * @param indiceB indicele pt nodB
	 * @param indiceC indicele pt nodC
	 * @param des fisierul din care citesc
	 * @throws IOException
	 */
	public void deser(Nod[] nod_list,String[] name_list,int numberOfObjects,int indiceA,int indiceB,int indiceC,BufferedReader des) throws IOException
	{
		
		for(int i=0; i<= numberOfObjects ;i++)
		{
			nod_list[i] = null;
			name_list[i] = null;
		}
		
		numberOfObjects = 0;
		String name;
		String line = des.readLine();
		String[] s = line.split("\"");
		
		if(s[1].equals("NodA"))
		{
			nod_list[numberOfObjects] = new nodA(indiceA);
			name_list[numberOfObjects] = s[7]; }
		
		if(s[1].equals("NodB"))
		{
			nod_list[numberOfObjects] = new nodB(indiceB);
			name_list[numberOfObjects] = s[7]; }

		if(s[1].equals("NodC"))
		{
			nod_list[numberOfObjects] = new nodC(indiceC);
			name_list[numberOfObjects] = s[7]; 
		}
		
		nod_list[0].setName(s[7]);
		nod_list[0].setNumber(0);
		numberOfObjects ++;
		line = des.readLine();
		s = line.split("\"");
		name = s[1];

		Nod obiect = getObject(nod_list,name_list,numberOfObjects,name);
		line = des.readLine();
		
		while((line = des.readLine()) != null) {


			line = line.replaceAll("\\s+", "");
			if(!(line.equals("")) && !(line.equals("<\\LIST>")) && !(line.equals("<\\SET>")) && !(line.equals("<\\VECTOR>")))
			{
				s = line.split("\"");
				if(s[0].equals("<Nume>"))
				{
					obiect = getObject(nod_list,name_list,numberOfObjects,s[1]);
					line = des.readLine();
					line = des.readLine();

					line = line.replaceAll("\\s+", "");
					s = line.split("\"");
				}

				if(getObject(nod_list,name_list,numberOfObjects -1 , s[6]) == null)
				{


					if(s[1].equals("NodA"))
					{
						nod_list[numberOfObjects] = new nodA(indiceA);
						name_list[numberOfObjects] = s[6]; }
					
					if(s[1].equals("NodB"))
					{

						nod_list[numberOfObjects] = new nodB(indiceB);
						name_list[numberOfObjects] = s[6]; }

					if(s[1].equals("NodC"))
					{
						nod_list[numberOfObjects] = new nodC(indiceC);
						name_list[numberOfObjects] = s[6]; 
					}

					nod_list[numberOfObjects].setName(s[6]);
					nod_list[numberOfObjects].setNumber(numberOfObjects);

					obiect.createMuchie(nod_list[numberOfObjects]);
					numberOfObjects ++;
				}
				else
				{

					Nod obiect2 = getObject(nod_list,name_list,numberOfObjects, s[6]);
					obiect.createMuchie(obiect2);
				}


			}
		}

	}
}

