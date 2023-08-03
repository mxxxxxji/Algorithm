#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int num1, num2;
	int i = 0;
	do {
		cin >> num1;
		cin >> num2;
		if (num1 < 10 && num1>0 && num2 < 10 && num2>0)
			cout << num1 + num2 << "\n";
		i++;
	} while (num1 != 0 && num2 != 0);

}