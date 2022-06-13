
#include <stdio.h>
#include <iostream>
#include <ctime>
using namespace std;

// создание массива
int* Arr() {
    srand (time(NULL));
    int* arr = new int[7];
    for (int i = 0; i < sizeof(arr); i++) {
        arr[i] = rand() % 20 + 1;
    }
    return arr;
}

// пузырьковая сортировка массива
void Bubble_sort(int *array) {
    cout << "Изначальный массив: " << endl;
    for (int i = 0; i < sizeof(array); i++) {
        cout << array[i] << " ";
	}
    int gg;
    for (int i = 0; i < sizeof(array); i++) {
		for (int j = 0; j < sizeof(array); j++) {
			if (array[j] > array[j+1]) {
				gg = array[j];
				array[j] = array[j+1];
				array[j+1] = gg;
			}
		}
	}
	cout << " \n Отсортированный массив. Пузырьковая сортировка" << endl;
	for (int i = 0; i < sizeof(array); i++) {
        cout << array[i] << " ";
	}
}
    
// Быстрая сортировка массива

void Fast_sort(int *array ,int size) {
    int left = 0;
    int right = sizeof(array)-1;
    int mid = array[(left + right) / 2];
    do {
        while (array[left] <  mid) {
            left++;
        }
        while (array[right] > mid){
            right--;
        }
        if (left <= right) {
            int gg = array[left];
            array[left] = array[right];
            array[right] = gg;
            
            left++;
            right--;
        }
    } while (left <= right); 
    if (right > 0) {
        Fast_sort(array, right+1);
    }
    if (left < sizeof(array)) {
        Fast_sort(array, size - left);
    }
    cout << " \n Отсортированный массив. Быстрая сортировка" << endl;
	for (int i = 0; i < sizeof(array); i++) {
        cout << array[i] << " ";
	}
}

int main()
{   
    setlocale(LC_ALL, "rus");
    Bubble_sort(Arr());
    Fast_sort(Arr(), 10);
}