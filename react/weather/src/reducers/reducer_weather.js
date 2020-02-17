import { FETCH_WEATHER } from "../actions";

//business logic
//익명함수 -> 이 파일명 자체가 이 함수 이름이 돼
//state : 값(여기서 날씨),
//변경되면 무조건 실행돼
//action에 type(FETCH_WEATHER)과 payload(data = weather json)있어. 
export default function(state = [], action) {
    switch(action.type){
        case FETCH_WEATHER:
            //(x) return state.push(action.payload.data);
            //(old) return state.concat(action.payload.data);
            //[SEOUL, TOKYO, NEWYORK, SEATTLE]          전개 연산자 사용했을 때
            //[SEOUL, [TOKRY, NEWYORK, SEATTLE]]        전개 연산자 사용하지 않았을 때

            return [action.payload.data, ...state];
        default:
            return state;
    }
}