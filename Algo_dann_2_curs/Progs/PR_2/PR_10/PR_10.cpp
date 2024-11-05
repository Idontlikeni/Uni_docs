// PR_10.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
void foo(vector<int>& a, int b) {

}
int main()
{
	int n, a;
	cin >> n;
	vector<int>vec(n);
	sort(vec.begin(), vec.end());
	foo(vec, a);
}