import React, {useState} from 'react';
import ReactDOM from 'react-dom';
import {Items} from "./pages/Items";
import {BrowserRouter, Route, Switch} from 'react-router-dom'
import {Login} from "./pages/Login";

const Index = () => {
    const [state, setState] = useState({token: null, error: null});

    if(!state?.token) {
        return <Login setToken={setState} />
    }

    return (
        <BrowserRouter>
            <Switch>
                <Route exact path='/items'>
                    <Items/>
                </Route>
                <Route path='/'>
                    <Login setToken={setState}/>
                </Route>
            </Switch>
        </BrowserRouter>
    );
}

ReactDOM.render(<Index/>, document.getElementById("root"));