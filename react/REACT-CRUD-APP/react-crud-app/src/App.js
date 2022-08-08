
import './App.css';
import React, { Component } from 'react';
import {useRef} from 'react';
import { UsuarioServicio } from './service/UsuarioServicio';
import {DataTable} from 'primereact/datatable';
import { Column } from 'primereact/column';
import { Panel } from 'primereact/panel';
//Prime Faces
import {Menubar} from 'primereact/menubar';
import { Dialog } from 'primereact/dialog';
import {Button} from 'primereact/button';
import { InputText } from 'primereact/inputtext';
import { Toast } from 'primereact/toast';


import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";      
 





export default class App extends Component{
  
  constructor(){
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
          <Button label="Guardar"    className="p-button-success p-button-text" onClick={this.save} />
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
      if (this.isJSON(data)){
        this.showError(data);
    }else{
      console.log(data);
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
    }
      
    })
  }

  
  isJSON(data)
  {
    try {
      JSON.parse(data);
  } catch (e) {
      return false;
  }
  return true;
  }

  buscarError(texto)
  {
    var palabra = 'null';
    console.log(palabra);
    const prueba =texto.search(palabra);
    var index = prueba;
    var mensaje ="";
    var aux="";
    var o='"';
    console.log(o);
    if(index >= 0) {
        console.log("la palabra existe dentro de la cadena y se encuentra en la posición " + index);
        index-=7;
        while (aux!==o) {
          aux=prueba[index];
          if(aux!=o)
          {
          mensaje= prueba[index];
          }
          index--;
        }
          
        console.log(mensaje);
    } else {
        console.log("la palabra no existe dentro de la cadena");
    }
  }
  showSuccess() {
    this.current.show({severity: 'success', summary: 'Cuenta Creada', detail: 'Usuario Registrado', life: 3000,closable: false});
  } 
 
  showError(texto) {
    
    this.current.show({severity: 'error', summary: texto, detail: 'Error de Creacion'});
}
  
  render(){
    return (
      <>
      <div style={{width:'80%', margin: '0 auto', marginTop: '20px'}}>
      <Menubar model={this.items}/>
        
        <br/>
          <Panel header="Crud Unitravel" >
              <DataTable value={this.state.usuarios} stripedRows responsiveLayout="scroll">
                <Column field="cedula" header="Cedula"></Column>
                <Column field="nombre" header="Nombre"></Column>
                <Column field="email" header="Correo"></Column>
                <Column field="contraseña" header="Contraseña"></Column>
              </DataTable>


            </Panel>
            
            <Button label="Show" icon="pi pi-external-link" onClick={() => this.showSaveDialog()}  />

            <Dialog  header="Registro"visible={this.state.visible} footer={this.footer} modal={true} style={{ width: '50vw' }} onHide={()=>this.setState({visible : false})} >
                <br/> 
                <span className="p-float-label">

                  <InputText value={this.state.cedula} id="cedula" onChange={(e) => this.setState(prevState=>{
                    let usuario = Object.assign({},prevState.usuario)
                    usuario.cedula = e.target.value

                    return {usuario}
                  })} />

                  <label htmlFor="cedula">Cedula</label>
                
                </span>

                <br/>    
                <span className="p-float-label">

                  <InputText value={this.state.nombre} id="nombre" onChange={(e) => 
                  {
                  let val = e.target.value;
                  this.setState(prevState=>{
                    let usuario = Object.assign({},prevState.usuario)
                    usuario.nombre = val;

                    return {usuario}
                  })}
                 } />

                  <label htmlFor="nombre">Nombre</label>
                
                </span>
                <br/>

                <span className="p-float-label">

                  <InputText value={this.state.email} id="email" onChange={(e) => 
                  {
                    
                      let val = e.target.value;

                  this.setState(prevState=>{
                    let usuario = Object.assign({},prevState.usuario)
                    usuario.email = val;

                    return {usuario}
                  })}
                 } />

                  <label htmlFor="email">Correo</label>
                
                </span>
                <br/>

                <span className="p-float-label">

                  <InputText value={this.state.contraseña} id="contraseña" onChange={(e) => 
                  {
                    let val=e.target.value;
                  this.setState(prevState=>{
                    let usuario = Object.assign({},prevState.usuario)
                    usuario.contraseña =val;

                    return {usuario}
                  })} 
                  }/>
                  
                  <label htmlFor="contraseña">Contraseña</label>
                
                </span>
                <br/>

                

            </Dialog>
            <Toast ref={(el)=>this.current = el} ></Toast>
 
        
        </div>

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


 