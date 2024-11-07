// PR_11.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <algorithm>
#include <stdio.h>
using namespace std;
struct bill {
    int number, money_sum;
    string date, time;
    bill(int n, int m, string d, string t) {
        number = n;
        money_sum = m;
        date = d;
        time = t;
    }
    string info() {
        return to_string(number) + " " + to_string(money_sum) + " " + date + " " + time;
    }
};

bool comp(bill &a, bill &b) {
    return a.number < b.number;
}

int bin_search(vector<bill>& a, const int& b) {
    int l = 0, r = a.size() - 1;
    while (1) {
        int mid = (r + l) / 2;
        //cout << l << " " << r << " " << mid << "\n";
        if (a[mid].number > b)r = mid - 1;
        else if (a[mid].number < b) l = mid + 1;
        else if (a[mid].number == b)return mid;
        if (l > r)return -1;
    }
}

int main()
{
    ifstream fin("input.txt");
    ofstream fout("person_data.bin");
    vector<bill>vec;
    if (!fin) {
        cout << "File is not open!";
        return 0;
    }
    else {
        while (!fin.eof()) {
            int n, money;
            string date, time;
            fin >> n >> money >> date >> time;
            vec.push_back(bill(n, money, date, time));
        }
        sort(vec.begin(), vec.end(), comp);
        /*FILE* file;
        fopen_s(&file, "person_data.bin", "wb");*/
        for (auto a : vec) {
            cout << a.info() << "\n";
            string temp = a.info();
            fout.write(a.info().c_str(), sizeof(a.info()));
            //fout.write((char*)a, sizeof(a));
        }
    }
}

// Запуск программы: CTRL+F5 или меню "Отладка" > "Запуск без отладки"
// Отладка программы: F5 или меню "Отладка" > "Запустить отладку"

// Советы по началу работы 
//   1. В окне обозревателя решений можно добавлять файлы и управлять ими.
//   2. В окне Team Explorer можно подключиться к системе управления версиями.
//   3. В окне "Выходные данные" можно просматривать выходные данные сборки и другие сообщения.
//   4. В окне "Список ошибок" можно просматривать ошибки.
//   5. Последовательно выберите пункты меню "Проект" > "Добавить новый элемент", чтобы создать файлы кода, или "Проект" > "Добавить существующий элемент", чтобы добавить в проект существующие файлы кода.
//   6. Чтобы снова открыть этот проект позже, выберите пункты меню "Файл" > "Открыть" > "Проект" и выберите SLN-файл.
