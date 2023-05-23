#include<iostream>
#define MAX 10001
using namespace std;
int d(int);
int main()
{
	bool check[MAX] = { false };
	for (int i = 0; i < MAX; i++)
	{
		int num = d(i);
		if (num < MAX)
			check[num] = true;
		if (!check[i])
			cout << i <<"\n";
	}
	
	return 0;
}
int d(int n)
{
	int sum = n;
	while (n != 0) {
		sum += n % 10;
		n = n / 10;
	}
	return sum;
}