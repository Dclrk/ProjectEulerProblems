#include <iostream>
#include <chrono>
#include <cmath>
#include <string>

int main() {
    auto start = std::chrono::high_resolution_clock::now();














    auto end = std::chrono::high_resolution_clock::now();
    auto duration = std::chrono::duration_cast<std::chrono::duration<double>>(end - start);
    std::cout << "Execution time: " << duration.count() << " seconds\n";
    return 0;
}
