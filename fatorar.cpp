#include <iostream>
#include <vector>
#include <algorithm>
#include <thread>
#include <thread>
#include <Windows.h>

bool verificarPrimos(int i, std::vector<unsigned long int> primos);
bool rodando = true;

void loading()
{
    while (rodando)
    {
        std::cout << ".";
        Sleep(1000);
        std::cout << ".";
        Sleep(1000);
        std::cout << ".";
        Sleep(1000);
        std::cout << "\b\b\b   ";
    }
}

int main()
{
    std::vector<std::vector<unsigned long int>> fatorar(unsigned long int numero, std::vector<unsigned long int> primos);
    std::vector<unsigned long int> pegarPrimos(unsigned long int numero);   

    unsigned long int numero;

    printf("Insira o numero a ser fatorado: ");
    std::cin >> numero;
    std::thread t1(loading);

    std::vector<unsigned long int> primos = pegarPrimos(numero);
    std::vector<std::vector<unsigned long int>> fatorados = fatorar(numero, primos);
    rodando = false;

    t1.join();
    std::cout << "\b\b\b" << numero << " = ";

    for (size_t i = 0; i < fatorados.size(); i++)
    {
        for (size_t j = 0; j < 2; j++)
        {
            std::cout << fatorados[i][j] << "^";
        }
        std::cout << "\b * ";
    }
    std::cout << "\b\b ";

    return 0;
}
std::vector<std::vector<unsigned long int>> fatorar(unsigned long int numero, std::vector<unsigned long int> primos)
{
    std::vector<unsigned long int> divisores;
    std::vector<int> expoentes;

    int i = 0;
    while (numero != 1)
    {
        if (numero % primos[i] == 0)
        {
            numero /= primos[i];
            std::vector<unsigned long int>::iterator itr = std::find(divisores.begin(), divisores.end(), primos[i]);
            if (itr != divisores.cend())
            {
                expoentes[std::distance(divisores.begin(), itr)] += 1;
            }
            else
            {
                divisores.push_back(primos[i]);
                expoentes.push_back(1);
            }
        }
        else
        {
            i++;
        }
    }

    std::vector<std::vector<unsigned long int>> fatorado;
    for (size_t i = 0; i < divisores.size(); i++)
    {
        fatorado.push_back({divisores[i], (unsigned long int)expoentes[i]});
    }
    return fatorado;
}

std::vector<unsigned long int> pegarPrimos(unsigned long int numero)
{
    std::vector<unsigned long int> primos;
    for (unsigned long int i = 2; i <= numero; i++)
    {
        if (verificarPrimos(i, primos))
        {
            primos.push_back(i);
        }
    }
    return primos;
}
bool verificarPrimos(int i, std::vector<unsigned long int> primos)
{
    for (unsigned long int j = 0; j < primos.size(); j++)
    {
        if (i % primos[j] == 0)
        {
            return false;
        }
    }
    return true;
}