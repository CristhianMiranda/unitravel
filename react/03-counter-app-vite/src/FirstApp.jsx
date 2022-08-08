//import { Fragment } from "react";===<>
//FirstApp
import PropTypes from 'prop-types';


    const newMessage = {
        message: 'hola mundo',
        title: 'Cristhian',
    };

    const mensaje = ()=>{
        return 4+4;
    }


    

    export const FirstApp = ({title,subTitle,name}) =>{
    
        //console.log(props);
    return(
        <>
        <h1>{title}</h1>
        {/*<code>{JSON.stringify(newMessage)}</code>*/}
        <p>{subTitle}</p>
        <p>{name}</p>
        </>
    );
    
}
FirstApp.PropTypes = 
    {
        title: PropTypes.string.isRequired,
        subTitle: PropTypes.string.isRequired,
    }
/**Entra antes de los proptypes */
FirstApp.defaultProps = {
    name: 'cristhian Miranda',
    subTitle: 'No hay subtitulo',
    title: 'No hay titulo',
}