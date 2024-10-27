// PR_7.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//
#define _USE_MATH_DEFINES
#include <iostream>
#include <cmath>
using namespace std;

double method(double a, double b, double(*f)(double x)) {
    float x, z, n = 4, h;
    h = (b - a) / n;
    z = h / 4;
    x = 2 * z * (7 * f(a) + 32 * f(a + z) + 12 * f(a + 2*z) + 32 * f(a + 3*z) + 7 * f(a + 4*z)) / 45;

    return x;
}

double f(double x) {
    return sin(M_PI * x * x / 2);
}

int main()
{
    double a = 0;
    double b[] = {0.5, 1.0, 1.5, 2.0};
     for (int i = 0; i < 4; i++)
    {
        std::cout << "a: " << a << " b: " << b[i] << " x: " << method(a, b[i], f) << "\n";
    }
    /*double b = 1.0;
    std::cout << method(a, b, eps, f) << "\n";*/
    
}
