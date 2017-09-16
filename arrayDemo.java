import java.io.*;

public class arrayDemo {

	private int [] array1 = new int [50];

	private int size = 10;

	public void generateArray(){

		for(int i=0;i<size;i++){

			array1[i]=(int)(Math.random()*10)+10;
		}
	}

	public void printArray(){

		System.out.println("----------");

		for(int i=0;i<size;i++){

			System.out.println(i+" ---> "+array1[i]);
			System.out.println("----------");
		}

	}

	public int getValueAtIndex(int index){

		if(index<size){

			return array1[index];
		}

		return 0;
	}

	public int getFirstIndexForValue(int value){

		boolean flag = false;
		int i = 0;
		for(i=0;i<size;i++){

			if(array1[i]==value){

				flag = true;
				return i;
			}
		}
		if(flag==false) return 1111;
		else return i;
	}

	public void deleteAtIndex(int index){

		if(index<size){

			for(int i=index;i<(size-1);i++){

				array1[i]=array1[i+1];
			}

			size--;
		}

		else{

			System.out.println("Should be smaller than "+size);
		}

	}

	public void insertValue(int value){

		if(size<50){

			array1[size]=value;

			size++;
		}

	}

	public void linearSearch(int value){

		System.out.println("Indexes of the value are: ");

		boolean flag = false;
		int index;

		for(index=0;index<size;index++){

			if(array1[index]==value){

				System.out.println(index);
				flag=true;
			}
		}
		if(!flag){

			System.out.println("None");
		}

	}

	public void binarySearch(int value){

		int low=0;
		int high=size-1;

		while(low<=high){

			int middle=(high+low)/2;

			if(array1[middle]<value){

				low=middle+1;
			}
			else if(array1[middle]>value){

				high=middle-1;
			}
			else{

				System.out.println("Index is: "+middle);
				low=high+1;
			}
		}
	}

	public void swapValue(int a, int b){

		int c=array1[a];
		array1[a]=array1[b];
		array1[b]=c;
	}

	public void bubbleSort(){

		for(int j=size-1;j>0;j--){

			for(int i=0;i<j;i++){

				if(array1[i]>array1[i+1]){

					swapValue(i,i+1);
				}
			}
		}
	}

	public void selectionSort(){

		for(int i=0;i<size;i++){

			int min=i;

			for(int j=i;j<size;j++){

				if(array1[min]>array1[j]){

					min=j;
				}
			}

			swapValue(i,min);
		}
	}

	public void insertionSort(){

		for(int i=1;i<size;i++){

			int j=i;
			int toInsert=array1[i];

			while((j>0)&&(array1[j-1]>toInsert)){

				array1[j]=array1[j-1];
				j--;
			}
			array1[j]=toInsert;
		}
	}

	public static void main(String[] args) {

		array newArray1 = new array();

		newArray1.generateArray();

		newArray1.printArray();

		System.out.println(newArray1.getValueAtIndex(4));

		System.out.println(newArray1.getFirstIndexForValue(15));

		newArray1.deleteAtIndex(5);

		newArray1.printArray();

		newArray1.insertValue(9);;

		newArray1.printArray();

		newArray1.linearSearch(14);

		newArray1.bubbleSort();

		newArray1.printArray();

		newArray1.binarySearch(15);
	}


}
