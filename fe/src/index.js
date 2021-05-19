import React from 'react';
import ReactDOM from 'react-dom';
import {Items} from "./Items/Items";


const HelloWorld = () => {


    return (
        <Items/>
    );
}

ReactDOM.render(<HelloWorld/>, document.getElementById("root"));