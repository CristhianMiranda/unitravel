import axios, { AxiosError } from 'axios';

export class HotelServicio{
    baseUrl = 'http://localhost:8080/'

    getAllHotel(){
            return axios.get(this.baseUrl+'hoteles').then(res=>res.data);
    }


}