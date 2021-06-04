import React from 'react';
import ReactDOM from 'react-dom';
import {Items} from "./pages/Items";


const HelloWorld = () => {


    return (
        <Items/>
    );
}

ReactDOM.render(<HelloWorld/>, document.getElementById("root"));