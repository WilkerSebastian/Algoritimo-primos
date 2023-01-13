#include <iostream>
#include <vector>
#include <algorithm>

bool verificarPrimos(int i, std::vector<int> primos);

int main()
{
    std::vector<std::vector<int>> fatorar(int numero, std::vector<int> primos);
    std::vector<int> pegarPrimos(int numero);

    int numero;

    printf("Insira o numero a ser fatorado: ");
    scanf("%i", &numero);

    std::vector<int> primos = pegarPrimos(numero);
    std::vector<std::vector<int>> fatorados = fatorar(numero, primos);

    std::cout<<numero << " = ";

    for (size_t i = 0; i < fatorados.size(); i++)
    {
        for (size_t j = 0; j < 2; j++)
        {
            std::cout<<fatorados[i][j]<<"^";
        }
        std::cout<<"\b * ";    
    }
    std::cout<<"\b\b ";
    
    return 0;
}
std::vector<std::vector<int>> fatorar(int numero, std::vector<int> primos){
    std::vector<int> divisores;
    std::vector<int> expoentes;

    int i = 0;
    while (numero != 1)
    {
        if(numero % primos[i] == 0){
            numero /= primos[i];
            std::vector<int>::iterator itr = std::find(divisores.begin(), divisores.end(), primos[i]);
            if (itr != divisores.cend())
            {
                expoentes[std::distance(divisores.begin(), itr)] +=1;
                
            }
            else{
                divisores.push_back(primos[i]);
                expoentes.push_back(1);
            }
            
        }
        else{
            i++;
        }
    }

    std::vector<std::vector<int>> fatorado;
    for (size_t i = 0; i < divisores.size(); i++)
    {
        fatorado.push_back({divisores[i],expoentes[i]});
    }
    return fatorado;
    

}

std::vector<int> pegarPrimos(int numero)
{
    std::vector<int> primos;
    for (int i = 2; i <= numero; i++)
    {
        if (verificarPrimos(i, primos))
        {
            primos.push_back(i);
        }
        
    }
    return primos;
}
bool verificarPrimos(int i, std::vector<int> primos)
{
    for (int j = 0; j < primos.size(); j++)
    {
        if ( i % primos[j] == 0){
            return false;
        }
    }
    return true;
}