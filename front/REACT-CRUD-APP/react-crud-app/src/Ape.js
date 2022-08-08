
import './App.css';
import React, { Component } from 'react';
import {useRef} from 'react';
import { UsuarioServicio } from './service/UsuarioServicio';
import {DataTable} from 'primereact/datatable';
import { Column } from 'primereact/column';
//Prime Faces
import {Menubar} from 'primereact/menubar';
import { Dialog } from 'primereact/dialog';
import {Button} from 'primereact/button';
import { InputText } from 'primereact/inputtext';
import { Toast } from 'primereact/toast';
//Proyecto
import { Avatar } from 'primereact/avatar';
import { AvatarGroup } from 'primereact/avatargroup';
import { Badge } from 'primereact/badge';
import { Image } from 'primereact/image';
import { Panel } from 'primereact/panel';
import { Divider } from 'primereact/divider';
import { ContextMenu } from 'primereact/contextmenu';
import { AutoComplete } from 'primereact/autocomplete';
import { Carousel } from 'primereact/carousel';

import ReactDOM from 'react-dom/client';
//






import { Calendar } from 'primereact/calendar';

import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";      
 





export  class Ape extends Component{
  
  constructor(){

    //

    //

    super();
    this.state = {
      visible : false,
      usuario : {
        cedula : null,
        nombre : null,
        email : null,
        contraseña : null

      }
    };
    this.groupedCities = [
      {
          label: 'Germany', code: 'DE',
          items: [
              { label: 'Berlin', value: 'Berlin' },
              { label: 'Frankfurt', value: 'Frankfurt' },
              { label: 'Hamburg', value: 'Hamburg' },
              { label: 'Munich', value: 'Munich' }
          ]
      },
      {
          label: 'USA', code: 'US',
          items: [
              { label: 'Chicago', value: 'Chicago' },
              { label: 'Los Angeles', value: 'Los Angeles' },
              { label: 'New York', value: 'New York' },
              { label: 'San Francisco', value: 'San Francisco' }
          ]
      },
      {
          label: 'Japan', code: 'JP',
          items: [
              { label: 'Kyoto', value: 'Kyoto' },
              { label: 'Osaka', value: 'Osaka' },
              { label: 'Tokyo', value: 'Tokyo' },
              { label: 'Yokohama', value: 'Yokohama' }
          ]
      }
  ];
    
    this.items = [
      {
        label : 'Nuevo',
        icon  : 'pi pi-fw pi-plus',
        command : () => {this.showSaveDialog()}
      },
      {
        label : 'Editar',
        icon  : 'pi pi-fw pi-pencil',
        command : () => {alert('Editado!')}
      },
      {
        label : 'Eliminar',
        icon  : 'pi pi-fw pi-trash',
        command : () => {alert('Eliminado!')}
      }
      ];
    this.usuarioServicio = new UsuarioServicio();
    this.save=this.save.bind(this);

    this.footer = (
      <div>
          <Button label="Guardar"    className="p-button-success p-button-text" onClick={this.save}/>
      </div>

       


  );
  
  

    /*this.setState({
      usuarios: []
    });*/
    
    




  }


  

  
  componentDidMount(){
    this.usuarioServicio.getAll().then(data=>this.setState({usuarios : data}))
    
 
      
  }

  save() {
   
  
    this.usuarioServicio.save(this.state.usuario).then(data => {
      this.setState({
        visible : false,
        usuario: {
          id: null,
          nombre: null,
          apellido: null,
          direccion: null,
          telefono : null
        }
      });
      

      this.showSuccess();
      this.componentDidMount();
      this.login();
    })
  }


  showSuccess() {
    this.current.show({severity: 'success', summary: 'Cuenta Creada', detail: 'Usuario Registrado', life: 3000,closable: false});
  } 
 
  showError(texto) {
    this.current.show({severity: 'error', summary: texto, detail: 'Validation failed'});
}
  
  render(){
    return (
      <>



        <label>XD</label>
                                        
    
  </>
      
    );
  }

  showSaveDialog(){
    this.setState({
      visible : true});

}

thowSaveDialog(){
  this.setState({
    visible : false});

}


}


 