#include <iostream>
#include <chrono>
#include <cmath>

int main() {
    auto start = std::chrono::high_resolution_clock::now();


    long long num = 600851475143;

    int sqrt = static_cast<int>(std::sqrt(static_cast<double>(num)));

    int result;

    for(int i = 2; i < sqrt; i++){

        while(num % i == 0){

            num /= i;

            result = i;
        }

    }
    




    std::cout << result;

    auto end = std::chrono::high_resolution_clock::now();
    auto duration = std::chrono::duration_cast<std::chrono::duration<double>>(end - start);
    std::cout << "Execution time: " << duration.count() << " seconds\n";
    return 0;
}
