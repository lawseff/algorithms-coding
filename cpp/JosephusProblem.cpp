#include "LinkedList.h"

int getSurvivor(int n, int k)
{
	list::LinkedList<int> list;
	for (int i = 1; i <= n; i++)
	{
		list.addLast(i);
	}
	
	int i = k - 1;
	int length;
	while ((length = list.getLength()) > 1)
	{
		int removed = 0;
		for (; i < length; i += k)
		{
			auto *executee = list.get(i - removed++);
			list.remove(executee);
		}
		i -= length;
	}
	
	return list.getHead()->value;
}