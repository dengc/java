import java.util.*;


public class linkedListDemo {

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>();

		list.add(33);
		list.add(94);
		list.add(56);
		list.add(59);

		dupe(list);

		removeLT(list,60);

		printLT(list);

	}

	public static void dupe(LinkedList<Integer> list) {

		ListIterator<Integer> iter = list.listIterator();

		while(iter.hasNext()){

			int i = iter.next();
			iter.add(i);
		}
	}

	public static void removeLT(LinkedList<Integer> list, int threshold) {

		ListIterator<Integer> iter = list.listIterator();

		while(iter.hasNext()){

			int i = iter.next();
			if(i<threshold){
				iter.remove();
			}
		}
	}

	public static void printLT(LinkedList<Integer> list) {

		ListIterator<Integer> iter = list.listIterator();

		while(iter.hasNext()){

			System.out.println(iter.next());
		}
	}

}
