void bubbleSort(int* array, int size);
void quickSort(int* array, int size);
int linearSearch(int* array, int size, int element);
int binarySearch(int* array, int size, int element);

void bubbleSort(int* array, int size) 
{
	for (int i = 0; i < size - 1; i++) 
	{
		for (int j = i + 1; j < size; j++) 
		{
			if (array[i] > array[j]) 
			{
				swap(array[i], array[j]);
			}
		}
	}
}

void quickSortAuxiliary(int* array, int begin, int end)
{
	int pivot = array[rand() % (end - begin + 1) + begin];
	int i = begin;
	int j = end;
	while (i <= j)
	{
		while (array[i] < pivot)
		{
			i++;
		}
		while (array[j] > pivot)
		{
			j--;
		}
		if (i <= j)
		{
			swap(array[i], array[j]);
			i++;
			j--;
		}
	}
	if (i < end)
	{
		quickSortAuxiliary(array, i, end);
	}
	if (j > begin)
	{
		quickSortAuxiliary(array, begin, j);
	}
}

void quickSort(int* array, int size) 
{
	quickSortAuxiliary(array, 0, size - 1);
}

int linearSearch(int* array, int size, int element) 
{
	for (int i = 0; i < size; i++) 
	{
		if (array[i] == element) 
		{
			return i;
		}
	}
	return -1;
}

int binarySearch(int* array, int size, int element) 
{
	int l = 0, r = size - 1;
	while (l <= r) 
	{
		int m = (l + r) / 2;
		if (array[m] == element) 
		{
			return m;
		}
		else if (array[m] > element)
		{
			r = m - 1;
		}
		else
		{
			l = m + 1;
		}
	}
	return -1;
}