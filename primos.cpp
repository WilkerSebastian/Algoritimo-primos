#include <iostream>
#include <vector>

int main()
{
    bool verificar(int i, std::vector<int> primos);
    int ultimo;
    std::vector<int> primos;

    printf("Insira ultimo a ser procurado: ");
    scanf("%i", &ultimo);

    for (int i = 2; i <= ultimo; i++)
    {
        if (verificar(i, primos))
        {
            primos.push_back(i);
        }
        
    }
    printf("[");
    for (size_t i = 0; i < primos.size(); i++)
    {
        printf("%i,",primos[i]);
    }
    printf("\b]");
    

    return 0;
}

bool verificar(int i, std::vector<int> primos)
{
    for (int j = 0; j < primos.size(); j++)
    {
        if ( i % primos[j] == 0){
            return false;
        }
    }
    return true;
}