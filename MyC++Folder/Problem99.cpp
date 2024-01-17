#include <iostream>
#include <chrono>
#include <cmath>
#include <string>
#include <fstream>

int main() {
    auto start = std::chrono::high_resolution_clock::now();

    

    std::ifstream inputFile("C:\\Users\\Darin\\Desktop\\DumbassStuff\\ProjectEulerDownloads\\0099_base_exp.txt");

    int baseExp[1000][2];

    std::string line;

    int index = 0;

    int pos;

    while(std::getline(inputFile, line)){

        pos = line.find(',');

        baseExp[index][0] = std::stoi(line.substr(0, pos));
        baseExp[index][1] = std::stoi(line.substr(pos + 1));

        index++;
    }

    inputFile.close();


    int rows = sizeof(baseExp) / sizeof(baseExp[0]);

    double tempValue;

    double bigValue = 0;

    int result;

    for(int i = 0; i < rows; i++){

        tempValue = baseExp[i][1] * std::log(baseExp[i][0]);
        
        if(tempValue > bigValue){

            bigValue = tempValue;

            result = i;

        }

    }

    std::cout << result + 1 << std::endl;

    auto end = std::chrono::high_resolution_clock::now();
    auto duration = std::chrono::duration_cast<std::chrono::duration<double>>(end - start);
    std::cout << "Execution time: " << duration.count() << " seconds\n";
    return 0;
}
