import React, {useState} from 'react';
import ReactDOM from 'react-dom';
import {Items} from "./pages/Items";
import {BrowserRouter, Route, Switch} from 'react-router-dom'
import {Login} from "./pages/Login";
import {AlertContextProvider} from "./context/AlertContext";

const Index = () => {
    const [state, setState] = useState({token: "123", error: null});

    if (!state?.token) {
        return <Login setToken={setState}/>
    }

    return (
        <AlertContextProvider>
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
        </AlertContextProvider>
    );
}

ReactDOM.render(<Index/>, document.getElementById("root"));