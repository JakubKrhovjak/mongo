import React, {useEffect} from 'react';
import ReactDOM from 'react-dom';
import Button from '@material-ui/core/Button';
import { httpClient } from "./httpClient";
import {Items} from "./Items/Items";


const HelloWorld = () => {


    return (
        <Items/>
    );
}

ReactDOM.render(<HelloWorld/>, document.getElementById("root"));