
import './App.css';
import './CarouselDemo.css';
import React, { Component } from 'react';
import {useRef} from 'react';
import { UsuarioServicio } from './service/UsuarioServicio';
import { HotelServicio } from './service/HotelServicio';
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

import { Password } from 'primereact/password';
import { GMap } from 'primereact/gmap';
import { ProgressSpinner } from 'primereact/progressspinner';
import ReactDOM from 'react-dom/client';

//

import {Ape} from './Ape';
//Formulari
//

import { Calendar } from 'primereact/calendar';

import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";      
import { toHaveAccessibleDescription } from '@testing-library/jest-dom/dist/matchers';
 





export default class App extends Component{
  
  constructor(){

    super();

    this.state = {
      visible : false,
      visiblever: false,
      usuario : {
        cedula : null,
        nombre : null,
        email : null,
        contraseña : null

      },

      hotel : {
        codigo : null,
        direccion : null,
        nombre : null,
        numero_estrellas : null,
        telefono : null,
        cedula_administrador_hotel : null,
        ciudad_codigo : null

      }

    };

    this.responsiveOptions = [
      {
          breakpoint: '1024px',
          numVisible: 3,
          numScroll: 3
      },
      {
          breakpoint: '600px',
          numVisible: 2,
          numScroll: 2
      },
      {
          breakpoint: '480px',
          numVisible: 1,
          numScroll: 1
      }
    ];


    this.usuarioServicio = new UsuarioServicio();
    this.save=this.save.bind(this);

    this.hotelServicio = new HotelServicio();
    this.productTemplate = this.productTemplate.bind(this);
    

    this.footer = (
      <div style={{float:'left', padding:'0px 80px'}}>
          <Button label="Guardar" icon="pi pi-user-plus"   className="p-button-success p-button-text" onClick={this.save}>
            
            </Button>
      </div>
  );

  this.footerExp = (
    <div style={{float:'left', padding:'0px 80px'}}>
        <Button label="Ingresa" icon="pi pi-user"   className="p-button-success p-button-text" onClick={this.login}>
          
          </Button>
    </div>
);
      
  
  

  }


  
  componentDidMounte() {
    
    this.hotelServicio.getAllHotel().then(data=>this.setState({hotel : data}));
    this.hotelServicio.getAllHotel().then(data => this.setState({ hotel: data.slice(0,9) }));
}
  

productTemplate(hotel) {
  return (
      <div className="product-item">
          <div className="product-item-content">
              <div className="mb-3">
                  <img src={`images/product/${hotel.foto}`} onError={(e) => e.target.src='https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png'} alt={hotel.nombre} className="product-image" />
              </div>
              <div>
                  <h4 className="mb-1">{hotel.nombre}</h4>
                  <h6 className="mt-0 mb-3">${hotel.habitacion.precio}</h6>
                  <div className="car-buttons mt-5">
                      <Button icon="pi pi-search" className="p-button p-button-rounded mr-2" />
                      <Button icon="pi pi-star-fill" className="p-button-success p-button-rounded mr-2" />
                      <Button icon="pi pi-cog" className="p-button-help p-button-rounded" />
                  </div>
              </div>
          </div>
      </div>
  );
}


  componentDidMount(){
    this.usuarioServicio.getAll().then(data=>this.setState({usuarios : data}))
 
      
  }
  
  login()
  {

   this.usuarioServicio.login(this.state.usuario.email,this.state.usuario.contraseña).then(data => {
      if (this.isJSON(data)){
        this.showError(data);
      }else{
        this.setState({
          usuario:{
          cedula: this.state.usuario.cedula,
          nombre: this.state.usuario.nombre,
          email : this.state.usuario.email,
          contraseña : this.state.usuario.contraseña
          }
        });
      }
    }
   );



  }

  save() {
    this.showLoading(10000);
    
    this.usuarioServicio.save(this.state.usuario).then(data => {
      if (this.isJSON(data)){
        this.showError(data);
    }else{
      console.log(data);
      this.setState({
        visible : false,
        visiblever : true,
        visibleInicio : false,
        usuario: {
          cedula: null,
          nombre: null,
          email: null,
          contraseña:null

        }
      });
      
      this.showSuccess();
      this.componentDidMount();
    }
      
    })
  }

  

 
  showLoading(life)
  {
    this.current.show({severity: 'info', summary: 'Cargando', detail: '...', life: life,closable: true});
  } 


  showSuccess() {
    this.current.show({severity: 'success', summary: 'Cuenta Creada', detail: 'Usuario Registrado', life: 3000,closable: false});
  } 

  getFormErrorMessage = (name) => {
    return this.aver().errors[name] && <small className="p-error">{this.aver().errors[name].message}</small>
};
  

  isJSON(data)
  {
    try {
      JSON.parse(data);
  } catch (e) {
      return false;
  }
  return true;
  }
 
  showError(texto) {
    this.current.show({severity: 'error', summary: texto, detail: 'Error de Creacion',life: 9000,closable: true});
}
  
  render(){
    return (
      <>
      <div>
        <label value={this.state.usuario.cedula}></label>
      </div>
    <div>
      
      <Dialog dismissableMask={true}  rt={true} header="Te hemos dado un BONO!" visible={this.state.visiblever} onHide={() => this.setState({visiblever: false})} breakpoints={{'960px': '75vw', '640px': '100vw'}} style={{width: '340px'}}>
          Verifica tu cuenta y reclama un bono de bienvenida :3
          
      </Dialog>
    </div>


      <Dialog dismissableMask={true}  rt={true} header="Crear Usuario"  blockScroll headerStyle={{background:'#ffffff',fontFamily:'Helvetica,Arial,sans-serif',color:'#000000',width:'340px'}} visible={this.state.visible} style={{width: '340px'}} footer={this.footer} modal={true} onHide={() => this.setState({visible: false})}>
  
            <form id="usuario-form" >
              <span className="p-float-label">
                <InputText value={this.state.usuario.cedula} style={{width : '290px'}} id="cedula" onChange={(e) => {
                    let val = e.target.value;
                    this.setState(prevState => {
                        let usuario = Object.assign({}, prevState.usuario);
                        usuario.cedula = val;

                        return { usuario };
                    })}
                  } />
                <label htmlFor="cedula">Cedula</label>
              </span>
              <br/>
              <span className="p-float-label">
                <InputText value={this.state.usuario.nombre} style={{width : '290px'}} id="nombre" onChange={(e) => {
                    let val = e.target.value;
                    this.setState(prevState => {
                        let usuario = Object.assign({}, prevState.usuario);
                        usuario.nombre = val

                        return { usuario };
                    })}
                  } />
                <label htmlFor="nombre">Nombre</label>
              </span>
              <br/>
              
              
              <span className="p-float-label">
                <InputText value={this.state.usuario.email} style={{width : '290px'}} id="email" onChange={(e) => {
                    let val = e.target.value;
                    this.setState(prevState => {
                        let usuario = Object.assign({}, prevState.usuario);
                        usuario.email = val

                        return { usuario };
                    })}
                  } />
                <label htmlFor="email">Correo</label>
              </span>



              <br/>
              <span className="p-float-label" >
                
                <Password toggleMask feedback={false} value={this.state.usuario.contraseña}  style={{width : '290px' }} inputId="contraseña" onChange={(e) => {
                    let val = e.target.value;
                    this.setState(prevState => {
                        let usuario = Object.assign({}, prevState.usuario);
                        usuario.contraseña = val

                        return { usuario };
                    })}
                  } />
                <label htmlFor="contraseña">Contraseña</label>
              </span>
            </form>
        </Dialog>



        <Dialog dismissableMask={true}  rt={true} header="Iniciar Sesion"  blockScroll headerStyle={{background:'#ffffff',fontFamily:'Helvetica,Arial,sans-serif',color:'#000000',width:'340px'}} visible={this.state.visibleInicio} style={{width: '340px'}} footer={this.footerExp} modal={true} onHide={() => this.setState({visibleInicio: false})}>
  
            <form id="usuario-form" >
              
              <span className="p-float-label">
                <InputText value={this.state.usuario.email} style={{width : '290px'}} id="email" onChange={(e) => {
                    let val = e.target.value;
                    this.setState(prevState => {
                        let usuario = Object.assign({}, prevState.usuario);
                        usuario.email = val

                        return { usuario };
                    })}
                  } />
                <label htmlFor="email">Correo</label>
              </span>



              <br/>
              <span className="p-float-label" >
                
                <Password toggleMask feedback={false} value={this.state.usuario.contraseña}  style={{width : '290px' }} inputId="contraseña" onChange={(e) => {
                    let val = e.target.value;
                    this.setState(prevState => {
                        let usuario = Object.assign({}, prevState.usuario);
                        usuario.contraseña = val

                        return { usuario };
                    })}
                  } />
                <label htmlFor="contraseña">Contraseña</label>
              </span>
              <br/>
              <div id='recuperar' style={{display:'block', width:'10px',height:'20px', fontSize:'12px'}} onClick={this.save}>
                <button className='botonRecuperar' >
             <b>Recuperar contraseña</b>
              </button> 
              </div>
            </form>
        </Dialog>





        <Toast ref={(el)=>this.current = el} ></Toast>

          <div  style={{width:'1920px' , height:'126px',  backgroundColor: '#000000', color: '#ffffff',position:'initial' }}>
              

              
          
            <div  style={{float:'right', padding:'0px 1658px'}}>
                <Image src="https://i.postimg.cc/W43YrZ64/LOGOS.png"   alt="Image" width="262" preview />
            </div>
            
            
                
            <div style={{ display:'block', padding:'44px 1600px'}}>
                <div id='estilo' style={{float:'right', padding:'0px 320px'}}>
                  <button className='botonNegocio' style={{display:'block', width:'191px',height:'50px', fontSize:'24px',fontFamily:'iceland',position:'static' }}>
                        
                        <text id='texto'>Registra tu alojamiento</text>
                  </button>
                </div>

                <div id='prueba' style={{float:'right', padding:'0px 40px'}}>
                  <button className='botonRegistro' onClick={() => {this.showSaveDialog()}} style={{display:'block', width:'191px',height:'50px', fontSize:'24px',fontFamily:'iceland',position:'static' }}>
                        Hazte una cuenta
                  </button>  
                </div>
                  
                  <button style={{display:'block', width:'191px',height:'50px', fontSize:'24px',fontFamily:'iceland',position:'static' }} onClick={() => {this.showSaveDialoge()}}>
                        Inicia sesión
                  </button>

            </div>
                  
                
                
          </div>

          
          
          <div id="foto" style={{width:'1920px' , height:'50px',  backgroundColor: '#000000', color: '#ffffff',position:'relative' }}>



            <div  style={{padding:'0px 250px'}}> 

              <div style={{float:'left', padding:'0px 110px'}}>
                    <Button  id = "botonestrans" icon="pi pi-send" className=" p-button-icon" color='white'  style={{background:'#00000000',color: '#ffffff', display:'block', width:'200px',height:'50px', fontSize:'24px',fontFamily:'iceland'}}>
                        <label > A donde ir</label>
                    </Button>
                </div>

              


              <div style={{float:'left', padding:'0px 0px'}}>
                    <Button icon="pi pi-calendar-times" className=" p-button-text"  style={{color: '#ffffff', display:'block', width:'200px',height:'50px', fontSize:'24px',fontFamily:'iceland',position:'static' }}>
                        <label> Fecha Salida</label>
                    </Button>
                </div>

              


              <div style={{float:'left', padding:'0px 100px'}}>
                    <Button icon="pi pi-calendar-times" className=" p-button-text"  style={{color: '#ffffff', display:'block', width:'200px',height:'50px', fontSize:'24px',fontFamily:'iceland',position:'static' }}>
                        <label> Fecha Regreso</label>
                    </Button>
                </div>

                
                <Button icon="pi pi-user" className=" p-button-text" style={{display:'block',color: '#ffffff', display:'block', width:'200px',height:'50px', fontSize:'24px',fontFamily:'iceland',position:'static' }}>
                        <label> Personas</label>
                    </Button>

              

            

            
            </div>  

              


          </div>

          
          <div id="fotosi" style={{width:'1920px' , height:'50px',  backgroundColor: '#000000', color: '#ffffff',position:'relative' }}>
            <div  style={{padding:'0px 250px'}}> 

              <div style={{float:'left', padding:'0px 106px'}}>
                  <AutoComplete  >
                    </AutoComplete>
                </div>




              <div style={{float:'left', padding:'0px 0px'}}>
                    <Calendar >
                    </Calendar>
                </div>




              <div style={{float:'left', padding:'0px 90px'}}>
                    <Calendar >
                    </Calendar>
                </div>

                
                <AutoComplete  >
                </AutoComplete>

            </div>  
          </div>


          <div id="fotono"style={{width:'1920px' , height:'929px'}}>
            <div  style={{padding:'300px 900px'}}> 
              
            </div>
          </div>
          

                  
                                        
    
  </>
      
    );
  }

  showSaveDialog(){
    this.setState({
      visible : true,
    });

}
showSaveDialoge(){
  this.setState({
    visibleInicio : true,
  });

}

thowSaveDialog(){
  this.setState({
    visible : false});

}


}


 