import java.io.BufferedReader;
import java.io.InputStreamReader;

class m1495{
public static void main(String[] args) throws Exception
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String line = br.readLine();
	int n = Integer.parseInt(line);
	int[] ns = new int[n];
	for (int i = 0; i<n; i++)
	{
		line = br.readLine();
		ns[i] = Integer.parseInt(line);
	}

	sort(ns, 0, n-1);
	
	for (int i = 0; i<n; i++)
	{
		System.out.println(ns[i]);
	}
}

public static void sort(int[] array, int start, int end)
{
	if (start >= end) return;
	int p = partition(array, start, end);
	sort(array, start, p-1);
	sort(array, p+1, end);
}

public static int partition(int[] array, int left, int right){
    int pivotIndex = right;
    int pivotValue = array[pivotIndex];
	
	int temp = 0;
    int storeIndex = left;
    for (int i = left; i < right ; i++)
	{
		if (array[i] < pivotValue)
             {	
				temp = array[i];
				array[i] = array[storeIndex];
				array[storeIndex] = temp;
				storeIndex = storeIndex + 1;
			 }
	}
    temp = array[storeIndex]; 
	array[storeIndex] = array[right];
	array[right] = temp;	 // Move pivot to its final place
    return storeIndex;
}
}