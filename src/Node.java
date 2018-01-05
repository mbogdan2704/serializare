
public class Node {
Node next;
Nod data;
int exist;
public Node(Nod dataValue)
{
	next = null;
	data = dataValue;
}
public void setExista()
{
	this.exist = 1;
}
public int getExista()
{
	return this.exist;
}
public Node(Nod dataValue, Node nextValue)
{
	next = nextValue;
	data = dataValue;
}
public Nod getData() {
	return data;
}
public void setData(Nod dataValue) {
	data = dataValue;
}
public Node getNext() {
	return next;
}
public void setNext(Node nextValue) {
	next = nextValue;
}
}
