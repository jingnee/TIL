## pair sort
```cpp
bool compare (pair<string, pair<int, int>> a, pair<string, pair<int,int>> b){
	if(a.second.first == b.second.first)
        //second.second값이 큰 순으로 정렬
        //second.first값이 같을때 second.second 내림차순 정렬
        return a.second.second > b.second.second;
    else
        //second.first 내림차순 정렬
        return a.second.first > b.second.first;
}
```

## struct sort

```cpp
struct Student{
    string name;
    int kor;
    int eng;
}

bool compare(Student &a, Student &b){
    if(a.kor == b.kor)
        //국어점수가 같으면 영어점수 내림차순
        return a.eng > b.eng;
    else
        //국어점수 내림차순
        return a.kor > b.kor;
}
```

