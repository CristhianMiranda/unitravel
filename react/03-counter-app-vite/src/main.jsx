import React from 'react';
import ReactDOM from 'react-dom/client';
import { CounterApp } from './CounterApp';
//import  {App} from './HelloWorldApp';<App />
import  {FirstApp} from './FirstApp';
import {Prueba} from './Prueba'

import './index.css';

ReactDOM.createRoot(document.getElementById('root')).render(<React.StrictMode>
    
    <Prueba />
    {/*<CounterApp value={21}/>*/}
</React.StrictMode>);