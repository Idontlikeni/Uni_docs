// KURSOVAYA.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include <iostream>
#include <fstream>
#include <string>
#include <map>
using namespace std;
struct info {
    string f, i, o;
    int number, series;
    bool operator<(const info& other) const
    {
        string s1 = "", s2 = "";
        s1 += this->f + this->i + this->o;
        s2 += other.f + other.i + other.o;
        return (s1 < s2);
    }
};

//bool operator<(const info& t1, const info& t2)
//{
//    string s1 = "", s2 = "";
//    for (int i = 0; i < 3; i++)
//    {
//        s1 += t1.fio[i];
//        s2 += t2.fio[i];
//    }
//    return (s1 < s2);
//}

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
    string f[] = {"a", "b", "c"};
    if (!fin.is_open()) {
        cout << "Не удалось открыть файл";
    }
    else {
        while (!fin.eof()) {
            string phone;
            string fio[3];
            int number, series;
            fin >> phone >> fio[0] >> fio[1] >> fio[2] >> number >> series;
            mp[phone] = info{ fio[0], fio[1], fio[2], number, series };
        }
        fout.open("output.txt");
        for (const auto& element : mp) {
            fout << element.first << " " << element.second.f << " " << element.second.i << " " << element.second.o << " " << element.second.number << " " << element.second.series << "\n";
        }
    }
    return 0;
}