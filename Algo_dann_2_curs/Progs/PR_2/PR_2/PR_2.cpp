// PR_2.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include <iostream>
using namespace std;
int main()
{
    setlocale(LC_ALL, "RU");
    int a[100], n, i_mx = -1, i_mn = -1;
    cout << "n? ";
    cin >> n;
    for (int i = 0; i < n; i++)cin >> a[i];
    for (int i = 0; i < n; i++) {
        if (a[i] >= 0) {
            i_mx = i;
            break;
        }
    }
    for (int i = n - 1; i >= 0; i--) {
        if (a[i] <= 0) {
            i_mn = i;
            break;
        }
    }

    if(n < 2 || i_mx == -1 || i_mn == -1){
        cout << "Ошибка";
        return 0;
    }


    for (int i = 0; i < n - i_mn; i++) a[i + 1 + i_mx] = a[i + i_mn];
    for (int i = i_mx + n - i_mn + 1; i < n; i++)a[i] = 0;
    cout << "Получившийся массив:\n";
    for (int i = 0; i < n - (i_mn - i_mx - 1); i++)cout << a[i] << " ";
}
