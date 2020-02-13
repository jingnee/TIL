import axios from 'axios';

const API_KEY = 'a1e94706c17587fbc21a8119288d2fb2';
const ROOT_URL = `https://api.openweathermap.org/data/2.5/forecast?appid=${API_KEY}`;

export const FETCH_WEATHER = 'FETCH_WEATHER';

// redux action
// type (mandatory)                     store가 데이터쓸지말지 판단하는데 필요해(type으로만 판단하기때문에 필수야)
// payload (optional, data?)            전달하고자 하는 데이터
//사용자가 상단의 search를 클릭하면 실행되는 함수

export function fetchWeather(city) {            //fetch : data가져온다는 의미
    const url = `${ROOT_URL}&q=${city}`;
    const request = axios.get(url);

    return{
        type: FETCH_WEATHER,
        payload: request
    }
}