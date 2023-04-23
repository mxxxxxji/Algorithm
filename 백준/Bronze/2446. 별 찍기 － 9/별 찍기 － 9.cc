#include <iostream>
using namespace std;

int main()
{
	int num;
	int value;

	cin >> num;
	value = num;

	for (int i = 0; i < num; i++) 
	{
		for (int j = 0; j < i; j++)
			cout << " ";
		for (int k = 0; k < value * 2 - 1; k++) {
			cout << "*";
		}
		value--;
		cout << "\n";
	}
		
	value+=2;
	//cout << value;

	for (int i = 1; i < num; i++) {
		for (int j = num - 1; j > i; j--)
			cout << " ";
		for (int k = 1; k <= value * 2 - 1; k++) {
			cout << "*";
			
		}
		value++;
		if (value > num)
		{
			break;
		}
		cout << "\n";
	}

	return 0;
}