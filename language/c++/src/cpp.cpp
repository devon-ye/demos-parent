//============================================================================
// Name        : cpp.cpp
// Author      : devon.ye@foxmail.com
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <stdlib.h>
using namespace std;

int main() {
	cout << "please input a number!" <<endl;
	int x = 0;
	cin>> x;
	cout << oct << x <<endl;
	cout << dec << x <<endl;
	cout << hex << x <<endl;
	cout << "please input a bool value (0 or 1)!" << endl;
	bool y = false;
	cin >> y;
	cout << boolalpha << y << endl;
	system("pause");
	return 0;
}
