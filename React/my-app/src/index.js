import React from 'react';
import ReactDOM from 'react-dom/client';
import GugudanF from './GugudanF';
import GugudanC from './GugudanC';
import GugudanGPT from './GugudanGPT';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
    <div>
        <GugudanC/>
        <hr/>
        <GugudanF/>
        <hr/>
        <GugudanGPT/>
    </div>
);
