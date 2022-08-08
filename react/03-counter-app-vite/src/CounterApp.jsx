import { useState } from 'react';
import PropTypes from 'prop-types';

//rafc

export const CounterApp = ({value,nombre})=>{
    console.log('render');
    //Esto de useState y el metodo counter y set counter es para mantener
    //el estado de algo y cambiarlo cuando se requiera y solo renderizar ese cambio
    const [ counter, setCounter ] = useState( value );


    const handleAdd = ()=>
    {
        setCounter((c)=> c + 1 );
        //setCounter( counter + 1);
        //console.log(event)
    } 
    const handleSubtract = ()=>
    {
        setCounter((c)=> c - 1 );
        //setCounter( counter + 1);
        //console.log(event)
    } 
    const handleReset = ()=>
    {
        setCounter(value);
    }

    return <>
                <h1>CounterApp</h1>
                <h2>{ counter } </h2>
                <button onClick={ handleAdd }>
                    +1
                </button>
                <button onClick={ handleSubtract }>
                    -1
                </button>
                <button onClick={ handleReset }>
                    Reset
                </button>
            </>
}
CounterApp.PropTypes={
    value: PropTypes.number.isRequired
}

