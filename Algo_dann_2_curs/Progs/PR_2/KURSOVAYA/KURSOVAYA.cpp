// KURSOVAYA.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include <iostream>
#include <fstream>
#include <string>
#include <map>
using namespace std;
struct info {
    string fio[3];
    int number, series;
    info(string *f, int number, int series) {
        for (int i = 0; i < 3; i++)fio[i] = f[i];
        this->number = number;
        this->series = series;
    }
};

bool operator<(const info& t1, const info& t2)
{
    string s1 = "", s2 = "";
    for (int i = 0; i < 3; i++)
    {
        s1 += t1.fio[i];
        s2 += t2.fio[i];
    }
    return (s1 < s2);
}

int main()
{
    ifstream fin;
    ofstream fout;
    setlocale(LC_ALL, "Ru");
    cout << "Введите путь к текстовому файлу: ";
    string path;
    cin >> path;
    fin.open(path);
    map<string, info> mp;
    if (!fin.is_open()) {
        cout << "Не удалось открыть файл";
    }
    else {
        while (!fin.eof()) {
            string phone;
            string fio[3];
            int number, series;
            fin >> phone >> fio[0] >> fio[1] >> fio[2] >> number >> series;
            mp[phone] = info(fio, number, series);
        }
    }
    return 0;
}