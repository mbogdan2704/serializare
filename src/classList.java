/**
 * Clasa in care am implementat lista
 * @author root
 *
 */
public class classList {
private Node head;
private int counter;
classList() {
}
/**
 * Metoda care adauga in lista
 * @param data obiectul care trebuie introdus
 */
public void add(Nod data) {
	//.out.println("HERE");
	if(head == null) {
		head = new Node(data);
	}
	else
	{
	Node temp = new Node(data);
	Node current = head;
	if(current != null)
	{
		
		while(current.getNext() != null) //Parcurgem pana la ultimul
		{
			
			current = current.getNext();
		}
		
		current.setNext(temp); // Dupa ultimul il punem pe temp;
	}
	}
incrementCounter();	
}
/**
 * clasa de afisare lista
 */
public void showList()
{
	
	Node current = head;
	
	if(current != null)
	{
		while(current != null)
		{
			System.out.println(current.getData());
			current = current.getNext();
		}
	}
}
/**
 * incrementeaza counter-ul
 */
void incrementCounter() {
	counter ++;
}
/**
 * obtine counter-ul
 * @return
 */
int getCounter() {
	return counter;
}
/**
 * decrementeaza counter-ul
 */
void decrementCounter() {
	counter --;
}
/**
 * Obtine obiectul cu indicele "i" din lista
 * @param index indexul
 * @return
 */
Nod get(int index)
{
	if(index < 0 )
		return null;
	Node current = null;
	if(head != null)
	{
		current = head;
		for(int i = 0; i< index;i++) {
			if(current == null)
				return null;
			current = current.getNext();
		}
	}
	if(current != null)
	if(current.getExista() == 0)
		return current.getData();
	else
		return null;
	return null;
} 

/**
 * Sterge obiectul cu indicele i din lista
 * @param index
 */
void Remove(int index)
{
	Node current = null;
	if(head != null)
	{
		current = head;
		for(int i = 0; i< index;i++) {
			//System.out.println("AICI");

			current = current.getNext();
		}
	}
		current.setExista();
	
}
}
