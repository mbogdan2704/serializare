import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Main
 * @author root
 *
 */
public class Main {
/**
 * Functia care cauta in vectorul de noduri nod_list si returneaza obiectul care are stocat stringul "lookingFor"	
 * @param nod_list vectorul in care am stocat toate obiectele
 * @param name_list vectorul in care am stocat numele obiectelor
 * @param numberOfObjects numarul de obiecte
 * @param lookingFor stringul cautat
 * @return
 */
	public static Nod getObiect(Nod[] nod_list, String[] name_list, //Functia returneaza obiect-ul caruia ii corespunde stringul "lookingFor"
						        int numberOfObjects, String lookingFor) {
		// int i;
		
			for (int i = 0; i < numberOfObjects; i++)
				if (name_list[i].equals(lookingFor))
					return nod_list[i];
	return null;
	}
/**
 * Functia main, in care apelez functiile de serializare, adaugare etc
 * @param args
 */
	public static void main(String args[]) {
// DECLARARE VARIABILE
		
		String fileName = "";
		boolean cast = false;
		int indiceA = 0, indiceB = 0, indiceC = 0;
		String[] name_list = new String[100];
		Nod[] nod_list = new Nod[100];
		BufferedReader in = null;
		PrintWriter out = null;
		PrintWriter cast_file = null;
		BufferedReader des = null;
		int numberOfObjects = 0;
		
		
		try {
			
			String x;
			in = new BufferedReader(new FileReader(args[0]));
			cast_file = new PrintWriter("Deserialize_Cast.log");
			
			while ((x = in.readLine()) != null) { //Citire linii din fisier

				String[] s = x.split(" ");
				if (s[0].equals("Settings") && cast == true) { //Aici verific daca este prima operatie de Settings.In cazul in care nu este trebuie facut cast-ul(daca este nevoie)
					
					int newCast = Integer.parseInt(s[1]);
					int oldIndiceA = indiceA; //Memorez vechiul indice
					int oldIndiceB = indiceB;
					int oldIndiceC = indiceC;

					if (indiceA > newCast)
					{ //Daca vechiul indice este mai mare apare Fail
						
						for (int i = 0; i <= numberOfObjects; i++)
						{
							
							if (nod_list[i] instanceof nodA)
							{
								
								cast_file.print("Fail cast NodA ");
								cast_file.print(name_list[i]);
								cast_file.print(" from Version=");
								cast_file.print("\"");
								cast_file.print(indiceA + "\"");
								cast_file.print(" to " + "\"" + newCast + "\".\n");
							
							}
						}
						indiceA = newCast;
					}
					
					if (indiceA <= newCast) 
					{ //Daca vechiul indice este mai mic apare OK
						for (int i = 0; i <= numberOfObjects; i++) 
						{
							
							if (nod_list[i] instanceof nodA) 
							{
								
								cast_file.print("OK cast NodA ");
								cast_file.print(name_list[i]);
								cast_file.print(" from Version=");
								cast_file.print("\"");
								cast_file.print(indiceA + "\"");
								cast_file.print(" to " + "\"" + newCast + "\".\n");
							}
						}
						indiceA = newCast;
					}
					
					
					newCast = Integer.parseInt(s[2]); //Aceleasi operatii si pentru nodB si nod C
					
					if (indiceB > newCast) 
					{
						
						for (int i = 0; i <= numberOfObjects; i++) 
						{
							
							if (nod_list[i] instanceof nodB) 
							{
								cast_file.print("Fail cast NodB ");
								cast_file.print(name_list[i]);
								cast_file.print(" from Version=");
								cast_file.print("\"");
								cast_file.print(indiceB + "\"");
								cast_file.print(" to " + "\"" + newCast	+ "\".\n");
							
							}
						}
						indiceB = newCast;
					}
					
					if (indiceB <= newCast) {
						
						for (int i = 0; i <= numberOfObjects; i++) 
						{
						
							if (nod_list[i] instanceof nodB) {
								cast_file.print("OK cast NodB ");
								cast_file.print(name_list[i]);
								cast_file.print(" from Version=");
								cast_file.print("\"");
								cast_file.print(indiceB + "\"");
								cast_file.print(" to " + "\"" + newCast + "\".\n");
							}
						}
						indiceB = newCast;
					}
					
				
					
					newCast = Integer.parseInt(s[3]);
					
					
					if (indiceC > newCast) 
					{
					
						for (int i = 0; i <= numberOfObjects; i++) 
						{
						
							if (nod_list[i] instanceof nodC) {
								cast_file.print("Fail cast NodC ");
								cast_file.print(name_list[i]);
								cast_file.print(" from Version=");
								cast_file.print("\"");
								cast_file.print(indiceC + "\"");
								cast_file.print(" to " + "\"" + newCast + "\".\n");
							}
						}
						indiceC = newCast;
					}
					
					if (indiceC <= newCast) 
					{
					
						for (int i = 0; i <= numberOfObjects; i++) 
						{
						
							if (nod_list[i] instanceof nodC) 
							{
								cast_file.print("OK cast NodC ");
								cast_file.print(name_list[i]);
								cast_file.print(" from Version=");
								cast_file.print("\"");
								cast_file.print(indiceC + "\"");
								cast_file.print(" to " + "\"" + newCast + "\".\n");
							}
						}
						indiceC = newCast;
					}
					
				}
				
				
				if (s[0].equals("Settings") && cast == false) 
				{ //Daca nu trebuie facut cast
					
					cast = true;
					indiceA = Integer.parseInt(s[1]);
					indiceB = Integer.parseInt(s[2]);
					indiceC = Integer.parseInt(s[3]);
				
				}

				if (s[0].equals("Add")) {

					if (s[1].equals("NodA"))
						nod_list[numberOfObjects] = new nodA(indiceA); //Creez noduri
					if (s[1].equals("NodB"))
						nod_list[numberOfObjects] = new nodB(indiceB);
					if (s[1].equals("NodC")) {
						nod_list[numberOfObjects] = new nodC(indiceC);
					
						
					}
					
					nod_list[numberOfObjects].setName(s[2]);
					nod_list[numberOfObjects].setNumber(numberOfObjects);
					name_list[numberOfObjects] = s[2];
					
					int inc = 3;
					
					while (inc < s.length) { //Ma duc in toate nodurile de dupa(cele cu care trebuie sa creez muchie)
					
						Nod nod1 = nod_list[numberOfObjects];
						String lookingFor = s[inc];
						Nod nod2 = getObiect(nod_list, name_list, numberOfObjects, lookingFor);
						nod1.createMuchie(nod2);
						nod2.createMuchie(nod1);
						inc++;

					}
					numberOfObjects++;
				}
				
				
				if (s[0].equals("Serialize")) {
					
					out = new PrintWriter(s[2]);
					fileName = s[2];
					String lookingFor = s[1];
					Nod nod = getObiect(nod_list, name_list, numberOfObjects, lookingFor); //vad cu ce nod trebuie sa incep si apelez functia de serializare
					
					Serializare ob = new Serializare();
					ob.ser(nod, out, name_list, nod_list);
					out.close();

				}
				
				
				if (s[0].equals("Deserialize")) { //Apelez functia de deserializare

					des = new BufferedReader(new FileReader(fileName));

					Deserialize deser = new Deserialize();
					deser.deser(nod_list, name_list, numberOfObjects, indiceA,
							indiceB, indiceC, des);
				
				}
				
				
				if (s[0].equals("AddM")) 
				{ // Functia de adaugare muchie
					Nod obiect1 = getObiect(nod_list, name_list, numberOfObjects, s[1]);
					Nod obiect2 = getObiect(nod_list, name_list, numberOfObjects, s[2]);
					obiect1.createMuchie(obiect2);
					obiect2.createMuchie(obiect1);
				}
				
				
				if (s[0].equals("DelM")) { //Functia de distrugere muchie
					
					Nod obiect1 = getObiect(nod_list, name_list, numberOfObjects, s[1]);

					Nod obiect2 = getObiect(nod_list, name_list, numberOfObjects, s[2]);
					//In functia de ce tip e ma duc in lista/vector/set si apelez functia de stergere
					if (obiect1.getIndice() == 1) {
						
						for (int i = 0; i < obiect1.get_list().getCounter(); i++) {
							
							if(obiect1.get_list().get(i) != null)
								if (obiect1.get_list().get(i).getName() == obiect2.getName()) {
									obiect1.get_list().Remove(i);
							
							}
						}
					}
					
					if (obiect1.getIndice() == 2) {
						for (int i = 0; i < obiect1.get_vector().getCounter(); i++) {

							if(obiect1.get_vector().get(i) != null)
									if (obiect1.get_vector().get(i).getName() == obiect2.getName()) {
										obiect1.get_vector().Remove(i);
							
							}
						}
					}
					if (obiect1.getIndice() == 3) {
						for (int i = 0; i <= obiect1.get_set().getCounter(); i++) {
							
							if(obiect1.get_set().get(i) != null)
								if (obiect1.get_set().get(i).getName() == obiect2.getName()) {
									obiect1.get_set().Remove(i);
							
							}
						}
					}
					//La fel si pentru al doilea obiect
					if (obiect2.getIndice() == 1) {

						for (int i = 0; i < obiect2.get_list().getCounter(); i++) {
							

							if(obiect2.get_list().get(i) != null)
								if (obiect2.get_list().get(i).getName() == obiect1.getName()) {
									obiect2.get_list().Remove(i);
							
							}
						}
					}
					
					if (obiect2.getIndice() == 2) {
						
						for (int i = 0; i < obiect2.get_vector().getCounter(); i++) {

							if(obiect2.get_vector().get(i) != null)
								if (obiect2.get_vector().get(i).getName() == obiect1.getName()) {
									obiect2.get_vector().Remove(i);
							
						
							}
						}
					}	
					if (obiect2.getIndice() == 3) {

						for (int i = 0; i <= obiect2.get_set().getCounter(); i++) {
							
							if(obiect2.get_set().get(i) != null)
								if (obiect2.get_set().get(i).getName() == obiect1.getName()) {
									obiect2.get_set().Remove(i);
							
							}
						}
					}

				}
				//Pentru stergere nod
				if (s[0].equals("Del")) {
					String name = s[2];
					Nod obiect = getObiect(nod_list, name_list, numberOfObjects, name);
					if (obiect.getIndice() == 1) {
						
						for (int i = 0; i < obiect.get_list().getCounter(); i++) { //Ma duc in toti copiii si sterg legaturile cu el
							
							
							Nod obiect2 = obiect.get_list().get(i);
							if(obiect2 != null)
							{
								if (obiect2.getIndice() == 1) { //In functie de ce tip e ma uit in lista/vector/set
								
									for (int j = 0; j < obiect2.get_list().getCounter(); j++) {
									
										if (obiect2.get_list().get(j) == obiect) {
											obiect2.get_list().Remove(j);
									
										}
										
									}
								}
								
							
							if (obiect2.getIndice() == 2) {
								
								for (int j = 0; j < obiect2.get_vector().getCounter(); j++) {
									
									if (obiect2.get_vector().get(j) == obiect) {

										obiect2.get_vector().Remove(j);
									}
								}
							}
							
							if (obiect2.getIndice() == 3) {
							
								for (int j = 0; j < obiect2.get_set().getCounter(); j++) {
									
									if (obiect2.get_set().get(j) == obiect) {

										obiect2.get_set().Remove(j);
									}
								}
							}
						}
					}
					}

					if (obiect.getIndice() == 2) {
						for (int i = 0; i < obiect.get_vector().getCounter(); i++) {

							Nod obiect2 = obiect.get_vector().get(i);
							if(obiect2 != null)
							{
								if (obiect2.getIndice() == 1) {

									for (int j = 0; j < obiect2.get_list().getCounter(); j++) {

										if (obiect2.get_list().get(j) == obiect) {

											obiect2.get_list().Remove(j);
										}
									}
								}

								if (obiect2.getIndice() == 2) {

									for (int j = 0; j < obiect2.get_vector().getCounter(); j++) {

										if (obiect2.get_vector().get(j) == obiect) {

											obiect2.get_vector().Remove(j);

										}
									}
								}

								if (obiect2.getIndice() == 3) {

									for (int j = 0; j <= obiect2.get_set().getCounter(); j++) {

										if (obiect2.get_set().get(j) == obiect) {

											obiect2.get_set().Remove(j);

										}
									}
								}
							}
						}
					}

					if (obiect.getIndice() == 3) {

						for (int i = 0; i <= obiect.get_set().getCounter(); i++) {

							Nod obiect2 = obiect.get_set().get(i);
							if(obiect2 != null)
							{
								if (obiect2.getIndice() == 1) {

									for (int j = 0; j < obiect2.get_list().getCounter(); j++) {

										if (obiect2.get_list().get(j) == obiect) {

											obiect2.get_list().Remove(j);
										}
									}
								}
								if (obiect2.getIndice() == 2) {

									for (int j = 0; j < obiect2.get_vector().getCounter(); j++) {

										if (obiect2.get_vector().get(j) == obiect) {

											obiect2.get_vector().Remove(j);

										}
									}
								}
								if (obiect2.getIndice() == 3) {

									for (int j = 0; j <= obiect2.get_set().getCounter(); j++) {

										if (obiect2.get_set().get(j) == obiect) {

											obiect2.get_set().Remove(j);
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {

			cast_file.close();
		}

	}
}
