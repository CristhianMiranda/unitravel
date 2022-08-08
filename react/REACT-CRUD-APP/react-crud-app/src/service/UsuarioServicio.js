import axios, { AxiosError } from 'axios';

export class UsuarioServicio{
    baseUrl = 'http://localhost:8080/'
    getAll(){
        return axios.get(this.baseUrl+"usuario").then(res => /*{
            console.log(res)
        }*/res.data);
    }


    save(usuario)
    {

           
            return axios.post(this.baseUrl+"save",usuario).then(res => res.data).catch(function (error) {
                if (error.response) {
                  // La respuesta fue hecha y el servidor respondió con un código de estado
                  // que esta fuera del rango de 2xx
               //   console.log(error.response.data);
                  var json = JSON.stringify(error.response.data);
                  return json;
                  console.log(error.response.status);
                  console.log(error.response.headers);
                  
                } else if (error.request) {
                  // La petición fue hecha pero no se recibió respuesta
                  // `error.request` es una instancia de XMLHttpRequest en el navegador y una instancia de
                  // http.ClientRequest en node.js
                  console.log(error.request);
                } else {
                  // Algo paso al preparar la petición que lanzo un Error
                  console.log('Error', error.message);
                }
                console.log(error.config);
              });
           
            
        
    }
}