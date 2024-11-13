#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;
template<typename Type>
void enter_mat(vector<vector<Type>>& vec);
template<typename Type>
void sort_mat(vector<vector<Type>>& vec);
template<typename Type>
void print_mat(vector<vector<Type>>& vec);

int main()
{
	setlocale(LC_ALL, "Ru");
	cout << "1 - матрица из целочисленных чисел, 2 - матрица из строк, 3 - из чисел с точкой: \n";
	int c = -1, n, m;
	while (c != 1 && c != 2 && c != 3)cin >> c;

	cout << "Введите размеры матрицы: \n";
	cin >> n >> m;
	cout << "Введите матрицу: \n";
	if (c == 1) {
		vector<vector<int>>vec(n, vector<int>(m));
		enter_mat(vec);
		sort_mat(vec);
		print_mat(vec);
	}
	else if(c == 2){
		vector<vector<string>>vec(n, vector<string>(m));
		enter_mat(vec);
		sort_mat(vec);
		print_mat(vec);
	}
	else {
		vector<vector<float>>vec(n, vector<float>(m));
		enter_mat(vec);
		sort_mat(vec);
		print_mat(vec);
	}
}

template<typename Type>
void enter_mat(vector<vector<Type>>& vec) {
	int n = vec.size(), m = vec[0].size();
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++) {
			cin >> vec[i][j];
		}
	}
}

template<typename Type>
void sort_mat(vector<vector<Type>>& vec) {
	int m = vec.size();
	if (m == 0) return;
	int n = vec[0].size();
	for (int i = 0; i < m * n - 1; i++) {
		for (int j = i + 1; j < m * n; j++) {
			int row1 = i / n, col1 = i % n;
			int row2 = j / n, col2 = j % n;
			if (vec[row1][col1] > vec[row2][col2]) {
				swap(vec[row1][col1], vec[row2][col2]);
			}
		}
	}
}
template<typename Type>
void print_mat(vector<vector<Type>>& vec) {
	int n = vec.size(), m = vec[0].size();
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++) {
			cout << vec[i][j] << " ";
		}
		cout << "\n";
	}
}