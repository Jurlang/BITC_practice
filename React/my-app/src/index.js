import React from 'react';
import ReactDOM from 'react-dom/client';
import Gugudan from './Gugudan';
import GugudanC from './GugudanC';
import GugudanGPT from './GugudanGPT';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <div>
        <GugudanC/>
        <hr/>
        <Gugudan/>
        <hr/>
        <GugudanGPT/>
    </div>
);
