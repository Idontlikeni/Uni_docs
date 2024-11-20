// PR_10.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int bin_find(vector<int>& a, const int &b, int c = -1, int d = -1) {
	int l, r;
	if(c == -1 && d == -1){
		l = 0, r = a.size() - 1;
	}
	else {
		l = c, r = d;
	}
	int mid = (r + l) / 2;
	if (a[mid] > b)r = mid - 1;
	else if (a[mid] < b) l = mid + 1;
	else if (a[mid] == b)return mid;
	if (l > r)return -1;
	return bin_find(a, b, l, r);
}

int main()
{
	int n, a;
	cin >> n;
	vector<int>vec(n);
	for (int i = 0; i < n; i++)
	{
		cin >> vec[i];
	}
	cin >> a;
	sort(vec.begin(), vec.end());
	//cout << foo(vec, a) << "\n";
	cout << bin_find(vec, a);
}